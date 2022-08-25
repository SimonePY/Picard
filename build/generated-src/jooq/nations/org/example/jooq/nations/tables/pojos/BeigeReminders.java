/*
 * This file is generated by jOOQ.
 */
package org.example.jooq.nations.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BeigeReminders implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Integer target;
    private final Integer attacker;
    private final Long turn;

    public BeigeReminders(BeigeReminders value) {
        this.target = value.target;
        this.attacker = value.attacker;
        this.turn = value.turn;
    }

    public BeigeReminders(
        Integer target,
        Integer attacker,
        Long turn
    ) {
        this.target = target;
        this.attacker = attacker;
        this.turn = turn;
    }

    /**
     * Getter for <code>BEIGE_REMINDERS.target</code>.
     */
    public Integer getTarget() {
        return this.target;
    }

    /**
     * Getter for <code>BEIGE_REMINDERS.attacker</code>.
     */
    public Integer getAttacker() {
        return this.attacker;
    }

    /**
     * Getter for <code>BEIGE_REMINDERS.turn</code>.
     */
    public Long getTurn() {
        return this.turn;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final BeigeReminders other = (BeigeReminders) obj;
        if (this.target == null) {
            if (other.target != null)
                return false;
        }
        else if (!this.target.equals(other.target))
            return false;
        if (this.attacker == null) {
            if (other.attacker != null)
                return false;
        }
        else if (!this.attacker.equals(other.attacker))
            return false;
        if (this.turn == null) {
            if (other.turn != null)
                return false;
        }
        else if (!this.turn.equals(other.turn))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.target == null) ? 0 : this.target.hashCode());
        result = prime * result + ((this.attacker == null) ? 0 : this.attacker.hashCode());
        result = prime * result + ((this.turn == null) ? 0 : this.turn.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("BeigeReminders (");

        sb.append(target);
        sb.append(", ").append(attacker);
        sb.append(", ").append(turn);

        sb.append(")");
        return sb.toString();
    }
}
