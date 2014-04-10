package com.tradedoubler.billing.platform.messagecontroller;

import java.sql.Timestamp;

/** Defines the persistent data regarding an integration message. */
public class MessageItem {

    /** The database primary key for the item. */
    private long id;

    /**
     * Determines when the integration message was created by the message transmitter.
     * Assumes all integration points to run in the same timezone.
     */
    private Timestamp messageCreateTime;

    /**
     * The exact number of ms for when the integration message was created by the message transmitter.
     * MySql drops the ms from the messageCreateTime variable.
     * This is necessary to handle an out-of-sequence scenario with ms accuracy.
     */
    private long messageCreateTimeMs;

    /**
     * The timestamp when the message was inserted into the database. Will use the timezone of the database server.
     * Time differences between messageCreateTime and dbInsertTime indicates problems with message processing.
     */
    private Timestamp dbInsertTime;

    /**
     * The message's guid, its unique key. It should be globally unique for all messages passing through Mule. All
     * message passing external actors are assumed to use the same algorithm to create guids.
     */
    private String guid;

    /** Determines the type of the message. For example createInvoicingRule */
    private String messageType;

    /**
     * Determines what entity the message encompasses. For example client 1223. If the message encompasses more than a
     * simple entity then a compound id could be created. Example a Client 123 and Agreement 321, then the entityId
     * can be 123_321. The important property is that the entityId is unique within one integration type.
     */
    private String entityId;

    /** The raw data of the message. Can be a json or xml string for example. */
    private String data;

    /** Determines how the data is saved in the database. txt or gz. */
    private String contentType;

    /** Tracks how many attempts that has been made to finalize this message. */
    private int numberOfAttempts;


    public Timestamp getMessageCreateTime() {
        return messageCreateTime;
    }

    public void setMessageCreateTime(Timestamp messageCreateTime) {
        this.messageCreateTime = messageCreateTime;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getMessageCreateTimeMs() {
        return messageCreateTimeMs;
    }

    public void setMessageCreateTimeMs(long messageCreateTimeMs) {
        this.messageCreateTimeMs = messageCreateTimeMs;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getDbInsertTime() {
        return dbInsertTime;
    }

    public void setDbInsertTime(Timestamp dbInsertTime) {
        this.dbInsertTime = dbInsertTime;
    }
}
