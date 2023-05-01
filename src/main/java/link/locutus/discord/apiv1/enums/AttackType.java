package link.locutus.discord.apiv1.enums;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum AttackType {
    GROUND(3, 10, MilitaryUnit.SOLDIER, MilitaryUnit.TANK, MilitaryUnit.AIRCRAFT),
    VICTORY(0, 0),
    FORTIFY(3, 0),
    A_LOOT("Alliance Loot", 0, 0),
    AIRSTRIKE1("Airstrike Infrastructure", 4, 12, MilitaryUnit.AIRCRAFT), // infra
    AIRSTRIKE2("Airstrike Soldiers", 4, 12, MilitaryUnit.AIRCRAFT, MilitaryUnit.SOLDIER),
    AIRSTRIKE3("Airstrike Tanks", 4, 12, MilitaryUnit.AIRCRAFT, MilitaryUnit.TANK),
    AIRSTRIKE4("Airstrike Money", 4, 12, MilitaryUnit.AIRCRAFT, MilitaryUnit.MONEY),
    AIRSTRIKE5("Airstrike Ships", 4, 12, MilitaryUnit.AIRCRAFT, MilitaryUnit.SHIP),
    AIRSTRIKE6("Dogfight", 4, 12, MilitaryUnit.AIRCRAFT), // airstrike aircraft
    NAVAL(4, 14, MilitaryUnit.SHIP),
    PEACE(0, 0),
    MISSILE(8, 18, MilitaryUnit.MISSILE),
    NUKE(12, 25, MilitaryUnit.NUKE),
    ;

    public static final AttackType[] values = values();
    private final MilitaryUnit[] units;
    private final String name;
    private final int mapUsed;
    private final int resistanceIT;
    AttackType(int mapUsed, int resistanceIT, MilitaryUnit... units) {
        this(null, mapUsed, resistanceIT, units);
    }

    AttackType(String name, int mapUsed, int resistanceIT, MilitaryUnit... units) {
        this.units = units;
        this.name = name == null ? name() : name;
        this.mapUsed = mapUsed;
        this.resistanceIT = resistanceIT;
    }

    public static AttackType fromV3(com.politicsandwar.graphql.model.AttackType v3) {
        return switch (v3) {
            case AIRVINFRA -> AIRSTRIKE1;
            case AIRVSOLDIERS -> AIRSTRIKE2;
            case AIRVTANKS -> AIRSTRIKE3;
            case AIRVMONEY -> AIRSTRIKE4;
            case AIRVSHIPS -> AIRSTRIKE5;
            case AIRVAIR -> AIRSTRIKE6;
            case GROUND -> GROUND;
            case MISSILE -> MISSILE;
            case MISSILEFAIL -> MISSILE;
            case NUKE -> NUKE;
            case NUKEFAIL -> NUKE;
            case NAVAL -> NAVAL;
            case FORTIFY -> FORTIFY;
            case PEACE -> PEACE;
            case VICTORY -> VICTORY;
            case ALLIANCELOOT -> A_LOOT;
        };
    }

    public static AttackType get(String input) {
        if (input.charAt(input.length() - 1) == 'F') {
            return get(input.substring(0, input.length() - 1));
        }
        return valueOf(input);
    }

    @Override
    public String toString() {
        return name;
    }

    public int getResistanceIT() {
        return resistanceIT;
    }

    public int getMapUsed() {
        return mapUsed;
    }

    public String getName() {
        return name;
    }

    public MilitaryUnit[] getUnits() {
        return units;
    }

    public Map<MilitaryUnit, Integer> getLosses(int a, int b, int c) {
        if (a == 0 && b == 0 && c == 0) return Collections.emptyMap();
        Map<MilitaryUnit, Integer> map = new HashMap<>(2);
        if (a != 0) {
            map.put(units[0], a);
        }
        if (b != 0) {
            map.put(units[1], b);
        }
        if (c != 0) {
            map.put(units[2], c);
        }
        return map;
    }

    public boolean isVictory() {
        return switch (this) {
            case VICTORY, A_LOOT -> true;
            default -> false;
        };
    }
}