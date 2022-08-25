/*
 * This file is generated by jOOQ.
 */
package org.example.jooq.bank.tables;


import java.util.function.Function;

import org.example.jooq.bank.DefaultSchema;
import org.example.jooq.bank.Keys;
import org.example.jooq.bank.tables.records.TransactionsAlliance_2Record;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function20;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row20;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TransactionsAlliance_2 extends TableImpl<TransactionsAlliance_2Record> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>TRANSACTIONS_ALLIANCE_2</code>
     */
    public static final TransactionsAlliance_2 TRANSACTIONS_ALLIANCE_2 = new TransactionsAlliance_2();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TransactionsAlliance_2Record> getRecordType() {
        return TransactionsAlliance_2Record.class;
    }

    /**
     * The column <code>TRANSACTIONS_ALLIANCE_2.tx_id</code>.
     */
    public final TableField<TransactionsAlliance_2Record, Integer> TX_ID = createField(DSL.name("tx_id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>TRANSACTIONS_ALLIANCE_2.tx_datetime</code>.
     */
    public final TableField<TransactionsAlliance_2Record, Long> TX_DATETIME = createField(DSL.name("tx_datetime"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>TRANSACTIONS_ALLIANCE_2.sender_id</code>.
     */
    public final TableField<TransactionsAlliance_2Record, Long> SENDER_ID = createField(DSL.name("sender_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>TRANSACTIONS_ALLIANCE_2.sender_type</code>.
     */
    public final TableField<TransactionsAlliance_2Record, Integer> SENDER_TYPE = createField(DSL.name("sender_type"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>TRANSACTIONS_ALLIANCE_2.receiver_id</code>.
     */
    public final TableField<TransactionsAlliance_2Record, Long> RECEIVER_ID = createField(DSL.name("receiver_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>TRANSACTIONS_ALLIANCE_2.receiver_type</code>.
     */
    public final TableField<TransactionsAlliance_2Record, Integer> RECEIVER_TYPE = createField(DSL.name("receiver_type"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>TRANSACTIONS_ALLIANCE_2.banker_nation_id</code>.
     */
    public final TableField<TransactionsAlliance_2Record, Integer> BANKER_NATION_ID = createField(DSL.name("banker_nation_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>TRANSACTIONS_ALLIANCE_2.note</code>.
     */
    public final TableField<TransactionsAlliance_2Record, String> NOTE = createField(DSL.name("note"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>TRANSACTIONS_ALLIANCE_2.MONEY</code>.
     */
    public final TableField<TransactionsAlliance_2Record, Integer> MONEY = createField(DSL.name("MONEY"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>TRANSACTIONS_ALLIANCE_2.FOOD</code>.
     */
    public final TableField<TransactionsAlliance_2Record, Integer> FOOD = createField(DSL.name("FOOD"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>TRANSACTIONS_ALLIANCE_2.COAL</code>.
     */
    public final TableField<TransactionsAlliance_2Record, Integer> COAL = createField(DSL.name("COAL"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>TRANSACTIONS_ALLIANCE_2.OIL</code>.
     */
    public final TableField<TransactionsAlliance_2Record, Integer> OIL = createField(DSL.name("OIL"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>TRANSACTIONS_ALLIANCE_2.URANIUM</code>.
     */
    public final TableField<TransactionsAlliance_2Record, Integer> URANIUM = createField(DSL.name("URANIUM"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>TRANSACTIONS_ALLIANCE_2.LEAD</code>.
     */
    public final TableField<TransactionsAlliance_2Record, Integer> LEAD = createField(DSL.name("LEAD"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>TRANSACTIONS_ALLIANCE_2.IRON</code>.
     */
    public final TableField<TransactionsAlliance_2Record, Integer> IRON = createField(DSL.name("IRON"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>TRANSACTIONS_ALLIANCE_2.BAUXITE</code>.
     */
    public final TableField<TransactionsAlliance_2Record, Integer> BAUXITE = createField(DSL.name("BAUXITE"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>TRANSACTIONS_ALLIANCE_2.GASOLINE</code>.
     */
    public final TableField<TransactionsAlliance_2Record, Integer> GASOLINE = createField(DSL.name("GASOLINE"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>TRANSACTIONS_ALLIANCE_2.MUNITIONS</code>.
     */
    public final TableField<TransactionsAlliance_2Record, Integer> MUNITIONS = createField(DSL.name("MUNITIONS"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>TRANSACTIONS_ALLIANCE_2.STEEL</code>.
     */
    public final TableField<TransactionsAlliance_2Record, Integer> STEEL = createField(DSL.name("STEEL"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>TRANSACTIONS_ALLIANCE_2.ALUMINUM</code>.
     */
    public final TableField<TransactionsAlliance_2Record, Integer> ALUMINUM = createField(DSL.name("ALUMINUM"), SQLDataType.INTEGER.nullable(false), this, "");

    private TransactionsAlliance_2(Name alias, Table<TransactionsAlliance_2Record> aliased) {
        this(alias, aliased, null);
    }

    private TransactionsAlliance_2(Name alias, Table<TransactionsAlliance_2Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>TRANSACTIONS_ALLIANCE_2</code> table reference
     */
    public TransactionsAlliance_2(String alias) {
        this(DSL.name(alias), TRANSACTIONS_ALLIANCE_2);
    }

    /**
     * Create an aliased <code>TRANSACTIONS_ALLIANCE_2</code> table reference
     */
    public TransactionsAlliance_2(Name alias) {
        this(alias, TRANSACTIONS_ALLIANCE_2);
    }

    /**
     * Create a <code>TRANSACTIONS_ALLIANCE_2</code> table reference
     */
    public TransactionsAlliance_2() {
        this(DSL.name("TRANSACTIONS_ALLIANCE_2"), null);
    }

    public <O extends Record> TransactionsAlliance_2(Table<O> child, ForeignKey<O, TransactionsAlliance_2Record> key) {
        super(child, key, TRANSACTIONS_ALLIANCE_2);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<TransactionsAlliance_2Record, Integer> getIdentity() {
        return (Identity<TransactionsAlliance_2Record, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<TransactionsAlliance_2Record> getPrimaryKey() {
        return Keys.TRANSACTIONS_ALLIANCE_2__PK_TRANSACTIONS_ALLIANCE_2;
    }

    @Override
    public TransactionsAlliance_2 as(String alias) {
        return new TransactionsAlliance_2(DSL.name(alias), this);
    }

    @Override
    public TransactionsAlliance_2 as(Name alias) {
        return new TransactionsAlliance_2(alias, this);
    }

    @Override
    public TransactionsAlliance_2 as(Table<?> alias) {
        return new TransactionsAlliance_2(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public TransactionsAlliance_2 rename(String name) {
        return new TransactionsAlliance_2(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TransactionsAlliance_2 rename(Name name) {
        return new TransactionsAlliance_2(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public TransactionsAlliance_2 rename(Table<?> name) {
        return new TransactionsAlliance_2(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row20 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row20<Integer, Long, Long, Integer, Long, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fieldsRow() {
        return (Row20) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function20<? super Integer, ? super Long, ? super Long, ? super Integer, ? super Long, ? super Integer, ? super Integer, ? super String, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function20<? super Integer, ? super Long, ? super Long, ? super Integer, ? super Long, ? super Integer, ? super Integer, ? super String, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
