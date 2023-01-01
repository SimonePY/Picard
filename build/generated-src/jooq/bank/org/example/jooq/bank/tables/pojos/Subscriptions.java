/*
 * This file is generated by jOOQ.
 */
package org.example.jooq.bank.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Subscriptions implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long user;
    private final Integer allianceornation;
    private final Integer isnation;
    private final Long date;
    private final Integer isreceive;
    private final Long amount;

    public Subscriptions(Subscriptions value) {
        this.user = value.user;
        this.allianceornation = value.allianceornation;
        this.isnation = value.isnation;
        this.date = value.date;
        this.isreceive = value.isreceive;
        this.amount = value.amount;
    }

    public Subscriptions(
        Long user,
        Integer allianceornation,
        Integer isnation,
        Long date,
        Integer isreceive,
        Long amount
    ) {
        this.user = user;
        this.allianceornation = allianceornation;
        this.isnation = isnation;
        this.date = date;
        this.isreceive = isreceive;
        this.amount = amount;
    }

    /**
     * Getter for <code>SUBSCRIPTIONS.user</code>.
     */
    public Long getUser() {
        return this.user;
    }

    /**
     * Getter for <code>SUBSCRIPTIONS.allianceOrNation</code>.
     */
    public Integer getAllianceornation() {
        return this.allianceornation;
    }

    /**
     * Getter for <code>SUBSCRIPTIONS.isNation</code>.
     */
    public Integer getIsnation() {
        return this.isnation;
    }

    /**
     * Getter for <code>SUBSCRIPTIONS.date</code>.
     */
    public Long getDate() {
        return this.date;
    }

    /**
     * Getter for <code>SUBSCRIPTIONS.isReceive</code>.
     */
    public Integer getIsreceive() {
        return this.isreceive;
    }

    /**
     * Getter for <code>SUBSCRIPTIONS.amount</code>.
     */
    public Long getAmount() {
        return this.amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Subscriptions other = (Subscriptions) obj;
        if (this.user == null) {
            if (other.user != null)
                return false;
        }
        else if (!this.user.equals(other.user))
            return false;
        if (this.allianceornation == null) {
            if (other.allianceornation != null)
                return false;
        }
        else if (!this.allianceornation.equals(other.allianceornation))
            return false;
        if (this.isnation == null) {
            if (other.isnation != null)
                return false;
        }
        else if (!this.isnation.equals(other.isnation))
            return false;
        if (this.date == null) {
            if (other.date != null)
                return false;
        }
        else if (!this.date.equals(other.date))
            return false;
        if (this.isreceive == null) {
            if (other.isreceive != null)
                return false;
        }
        else if (!this.isreceive.equals(other.isreceive))
            return false;
        if (this.amount == null) {
            if (other.amount != null)
                return false;
        }
        else if (!this.amount.equals(other.amount))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.user == null) ? 0 : this.user.hashCode());
        result = prime * result + ((this.allianceornation == null) ? 0 : this.allianceornation.hashCode());
        result = prime * result + ((this.isnation == null) ? 0 : this.isnation.hashCode());
        result = prime * result + ((this.date == null) ? 0 : this.date.hashCode());
        result = prime * result + ((this.isreceive == null) ? 0 : this.isreceive.hashCode());
        result = prime * result + ((this.amount == null) ? 0 : this.amount.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Subscriptions (");

        sb.append(user);
        sb.append(", ").append(allianceornation);
        sb.append(", ").append(isnation);
        sb.append(", ").append(date);
        sb.append(", ").append(isreceive);
        sb.append(", ").append(amount);

        sb.append(")");
        return sb.toString();
    }
}