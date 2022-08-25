/*
 * This file is generated by jOOQ.
 */
package org.example.jooq.nations;


import org.example.jooq.nations.tables.NationMilHistory;
import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables in the default schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index INDEX_MIL_AMOUNT = Internal.createIndex(DSL.name("index_mil_amount"), NationMilHistory.NATION_MIL_HISTORY, new OrderField[] { NationMilHistory.NATION_MIL_HISTORY.AMOUNT }, false);
    public static final Index INDEX_MIL_DATE = Internal.createIndex(DSL.name("index_mil_date"), NationMilHistory.NATION_MIL_HISTORY, new OrderField[] { NationMilHistory.NATION_MIL_HISTORY.DATE }, false);
    public static final Index INDEX_MIL_UNIT = Internal.createIndex(DSL.name("index_mil_unit"), NationMilHistory.NATION_MIL_HISTORY, new OrderField[] { NationMilHistory.NATION_MIL_HISTORY.UNIT }, false);
}
