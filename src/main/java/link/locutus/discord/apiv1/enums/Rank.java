package link.locutus.discord.apiv1.enums;

import com.politicsandwar.graphql.model.AlliancePositionEnum;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    LEADER("leader", 5),
    HEIR("heir", 4),
    OFFICER("officer", 3),
    MEMBER("member", 2),
    APPLICANT("applicant", 1),
    REMOVE("remove", 0),
    BAN("ban", -1),
    UNBAN("unban", -2),
    INVITE("invite", -3),
    UNINVITE("uninvite", -3),

    ;

    public static final Rank[] values = values();
    private static final Map<Integer, Rank> byId = new HashMap<>();

    static {
        for (Rank rank : values()) {
            byId.put(rank.id, rank);
        }
    }

    public final String key;
    public final int id;

    Rank(String key, int id) {
        this.key = key;
        this.id = id;
    }

    public static Rank from(AlliancePositionEnum alliance_position) {
        switch (alliance_position) {
            case NOALLIANCE:
                return REMOVE;
            case APPLICANT:
                return APPLICANT;
            case MEMBER:
                return MEMBER;
            case OFFICER:
                return OFFICER;
            case HEIR:
                return HEIR;
            case LEADER:
                return LEADER;
            default:
                throw new IllegalStateException("Unknown position: " + alliance_position);
        }
    }

    public static Rank byId(int id) {
        return byId.get(id);
    }

    @Override
    public String toString() {
        return key;
    }
}
