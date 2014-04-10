package com.tradedoubler.billing.domain;

/**
 * Meta information for a message that is processed by a mule flow. The meta data identifies the message so
 * that out-of-order and duplicate detection mechanisms can work.
 * The metadata also includes information about the origin of the message.
 */
public class MetaData {

    private final Timestamp creationTime;
    private final Guid messageId;
    private String messageType;
    private final String sourceSystem;
    private final String version;

    public MetaData(String messageType, Guid messageId, Timestamp creationTime, String version, String sourceSystem) {
        this.messageType = messageType;
        this.messageId = messageId;
        this.creationTime = creationTime;
        this.version = version;
        this.sourceSystem = sourceSystem;
    }

    /**
     * The type of message, e.g. InvoicingRuleCreated. In combination with messageId and sourceSystem it forms a
     * unique message identifier used to for example detect duplicate messages. This minimizes the risk of colliding
     * message IDs, and allows each source system to have separate ID sequences for each message type.
     */
    public String getMessageType() {
        return messageType;
    }

    /** Message identifier. Set by the source system. */
    public Guid getMessageId() {
        return messageId;
    }

    /** The time of creation for this message. */
    public Timestamp getCreationTime() {
        return creationTime;
    }

    /** Version of the message format */
    public String getVersion() {
        return version;
    }

    /** Name/ID of the system that created the message */
    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

}
