package link.locutus.discord.pnw;

import link.locutus.discord.db.GuildDB;
import link.locutus.discord.db.entities.DBWar;
import link.locutus.discord.util.task.war.WarCard;
import link.locutus.discord.apiv1.domains.subdomains.DBAttack;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public enum BeigeReason {
    INACTIVE("Nations who are inactive (2 days)"),
    ALREADY_BEIGE_STACKED("Enemies already with enough beige to rebuild (6 days)"),
    NO_ENEMY_OFFENSIVE_WARS("Enemies not declaring any offensive wars"),
    MISSILE_TURRET("Enemies with high number of missiles"),
    NUKE_TURRET("Enemies with high numbers of nukes"),
    VACATION_MODE("You can beige enemies in Vacation Mode"),
    BEIGE_CYCLE("If the enemy does not have beige, and two other strong nations can sit them whilst beige. DO NOT BEIGE DEFENSIVE WARS"),
    BEIGE_CYCLE_4D("If the enemy does not have beige, and one other strong nation can sit them whilst beige for 4d. DO NOT BEIGE DEFENSIVE WARS"),
    BEIGE_CYCLE_1("If the enemy does not have beige, and one other strong nation can sit them whilst beige for 2d. DO NOT BEIGE DEFENSIVE WARS"),
    BLOCKADED("If you are being sat on/blockaded and need to restock on warchest"),
    UNDER_C10_SLOG("If the enemy has less than 10 cities"),
    NOT_AN_ENEMY("Non enemies are not subject to beige/cycle orders"),
    APPLICANT("Applicants aren't subject to beige/cycle orders"),
    DO_NOT_RAID("Try to peace nations that are on the Do Not Raid list"),
    LOW_RESISTANCE("Low resistance, at risk of getting beiged"),
    LOW_RESISTANCE_OFFENSIVE("Low resistance, at risk of getting beiged"),
    OFFENSIVE_WAR("War is offensive"),
    NO_RECENT_WARS("Enemy is has not declared a war in the past 20 days"),
    NO_RECENT_3_CONSECUTIVE_LOGINS("Enemy has not had 3 consecutive logins in the past 120 days"),
    NO_RECENT_5_CONSECUTIVE_LOGINS("Enemy has not had 5 consecutive logins in the past 120 days"),
    INCORRECT_ENEMY_MMR("Enemy does not have 5 barracks/factories"),

    USELESS("Enemy has no recent wars and no recent consecutive logins OR incorrect MMR"),

    NO_REASON("")
    ;

    private final String desc;

    BeigeReason(String desc) {
        this.desc = desc;
    }

    public String getDescription() {
        return desc;
    }

    public static Set<BeigeReason> getAllowedBeigeReasons(GuildDB db, DBNation attacker, DBWar war, DBAttack attack) {
        Set<BeigeReason> reasons = getBeigeReason(db, attacker, war, attack);
        if (reasons.isEmpty()) {
            return Collections.emptySet();
        }
        DBNation defender = war.getNation(!war.isAttacker(attacker));
        Set<BeigeReason> allowed = db.getAllowedBeigeReasons(defender);
        allowed.removeIf(f -> !reasons.contains(f));
        return allowed;
    }

    public static Set<BeigeReason> getBeigeReason(GuildDB db, DBNation attacker, DBWar war, DBAttack attack) {
        Set<BeigeReason> result = new HashSet<>();
        boolean declared = war.isAttacker(attacker);
        DBNation defender = war.getNation(!declared);

        Function<DBNation, Boolean> canRaid = db.getCanRaid();
        if (!canRaid.apply(defender)) result.add(DO_NOT_RAID);

        Set<Integer> enemies = db.getCoalition("enemies");
        if (!enemies.contains(defender.getAlliance_id())) result.add(NOT_AN_ENEMY);
        if (defender.getVm_turns() > 0) result.add(VACATION_MODE);
        if (defender.getActive_m() > 2880) result.add(INACTIVE);
        if (defender.getPosition() <= 1) result.add(APPLICANT);
        if (defender.getBeigeTurns() > 120) result.add(ALREADY_BEIGE_STACKED);
        if (defender.getMissiles() >= 5) result.add(MISSILE_TURRET);
        if (defender.getNukes() >= 4) result.add(NUKE_TURRET);
        if (defender.getOff() == 0) result.add(NO_ENEMY_OFFENSIVE_WARS);
        if (war.isAttacker(attacker)) result.add(OFFENSIVE_WAR);

        {
            if (defender.daysSince3ConsecutiveLogins() > 120) {
                result.add(NO_RECENT_3_CONSECUTIVE_LOGINS);
                if (defender.daysSince5ConsecutiveLogins() > 120) {
                    result.add(NO_RECENT_5_CONSECUTIVE_LOGINS);
                }
            }
            String mmr = defender.getMMRBuildingStr();
            if (!mmr.startsWith("55")) {
                result.add(INCORRECT_ENEMY_MMR);
            }

            if (defender.getOff() == 0 && defender.daysSinceLastOffensive() > 20) {
                result.add(NO_RECENT_WARS);
            }

            if (result.contains(NO_RECENT_WARS) && (result.contains(INCORRECT_ENEMY_MMR) || result.contains(NO_RECENT_5_CONSECUTIVE_LOGINS))) {
                result.add(USELESS);
            }

        }

        if (defender.getActive_m() < 2880 && defender.getVm_turns() == 0) {
            List<DBAttack> attacks = war.getAttacks();
            Map.Entry<Integer, Integer> res = war.getResistance(war.getAttacks());
            int otherRes = war.isAttacker(attacker) ? res.getKey() : res.getValue();
            if (otherRes <= 42) {
                if (war.isAttacker(attacker)) {
                    result.add(LOW_RESISTANCE_OFFENSIVE);
                }
                result.add(LOW_RESISTANCE);
            }

            if (attack != null) attacks.remove(attack);
            WarCard card = new WarCard(war, attacks, true);
            if (card.blockaded == attacker.getNation_id()) {
                result.add(BLOCKADED);
            }
        }

        if (defender.getDef() > 0 && (attack == null ? !defender.isBeige() : defender.getBeigeTurns() <= 24) && war.attacker_id == attacker.getNation_id()) {
            List<DBWar> otherWars = defender.getWars();
            int numSitting = 0;
            int numSitting4d = 0;

            for (DBWar other : otherWars) {
                if (other.attacker_id == attacker.getNation_id()) continue;
                if (other.attacker_id == defender.getNation_id()) continue;
                DBNation otherAttacker = other.getNation(true);
                if (otherAttacker == null) continue;
                if (otherAttacker.getGroundStrength(true, false) * 0.8 <= defender.getGroundStrength(true, true))
                    continue;
                if (otherAttacker.getAircraft() * 0.8 <= defender.getAircraft()) continue;
                Map.Entry<Integer, Integer> resistance = other.getResistance(other.getAttacks());
                Integer defRes = resistance.getValue();
                Integer attRes = resistance.getKey();
                if (defRes <= 12) continue;
                if (attRes <= 25) continue;

                long timeLeft = other.date + TimeUnit.DAYS.toMillis(5) - System.currentTimeMillis();
                if (timeLeft >= TimeUnit.DAYS.toMillis(4)) {
                    numSitting4d++;
                }
                numSitting++;
            }
            if (numSitting >= 2 && (attack != null || !defender.isBeige())) {
                result.add(BEIGE_CYCLE);
            }
            if (numSitting >= 1 && (attack != null || !defender.isBeige())) {
                result.add(BEIGE_CYCLE_1);
            }
            if (numSitting4d >= 1) {
                result.add(BEIGE_CYCLE_4D);
            }
        }

        if (defender.getCities() < 10) {
            result.add(UNDER_C10_SLOG);
        }

//        if (result.isEmpty()) {
//            if (attack != null) {
//                Map.Entry<Integer, Integer> res = war.getResistance(war.getAttacks());
//                int otherRes = war.isAttacker(attacker) ? res.getValue() : res.getKey();
//
//                List<DBAttack> attacks = war.getAttacks();
//                attacks.remove(attack);
//                WarCard card = new WarCard(war, attacks, true);
//
//            }
////            else if ()
//        }

        if (result.isEmpty()) {
            result.add(NO_REASON);
        }

        return result;

    }


}