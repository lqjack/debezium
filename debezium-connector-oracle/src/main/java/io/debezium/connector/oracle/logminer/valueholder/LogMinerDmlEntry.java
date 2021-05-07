/*
 * Copyright Debezium Authors.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.debezium.connector.oracle.logminer.valueholder;

import java.sql.Timestamp;
import java.util.List;

import io.debezium.connector.oracle.Scn;

public interface LogMinerDmlEntry {
    /**
     * This getter
     * @return old(current) values of the database record.
     * They represent values in WHERE clauses
     */
    List<LogMinerColumnValue> getOldValues();

    /**
     * this getter
     * @return new values to be applied to the database record
     * Those values are applicable for INSERT and UPDATE statements
     */
    List<LogMinerColumnValue> getNewValues();

    /**
     * @return LogMiner event operation type
     */
    int getOperation();

    /**
     * the scn obtained from a LogMiner entry.
     * This SCN is not a final SCN, just a candidate.
     * The actual SCN will be assigned after commit
     * @return it's value
     */
    Scn getScn();

    /**
     * @return transaction ID
     */
    String getTransactionId();

    /**
     * @return schema name
     */
    String getObjectOwner();

    /**
     * @return table name
     */
    String getObjectName();

    /**
     * @return database change time of this logical record
     */
    Timestamp getSourceTime();

    /**
     * @return unique row identifier
     */
    String getRowId();

    /**
     * @return the sequence
     */
    int getSequence();

    /**
     * sets scn obtained from a LogMiner entry
     * @param scn it's value
     */
    void setScn(Scn scn);

    /**
     * Sets table name
     * @param name table name
     */
    void setObjectName(String name);

    /**
     * Sets schema owner
     * @param name schema owner
     */
    void setObjectOwner(String name);

    /**
     * Sets the time of the database change
     * @param changeTime the time of the change
     */
    void setSourceTime(Timestamp changeTime);

    /**
     * @param id unique transaction ID
     */
    void setTransactionId(String id);

    /**
     * @param rowId unique row identifier
     */
    void setRowId(String rowId);

    /**
     * @param sequence operation sequence
     */
    void setSequence(int sequence);
}
