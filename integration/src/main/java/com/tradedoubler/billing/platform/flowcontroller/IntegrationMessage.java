package com.tradedoubler.billing.platform.flowcontroller;

import com.tradedoubler.billing.domain.MetaData;

/** Defines an integration message for the billing integration platform. */
public class IntegrationMessage {

    /** The meta data for the message, used only by the MessageController */
    private final MetaData metaData;

    /**
     * if true the message has been marked as being delivered out-of-sequence and should not be processed,
     * and instead be deleted from its corresponding input integration point.
     */
    private boolean outOfSequence;

    /** The entity id that the message encompasses. */
    private final String entityId;

    /** The payload of the integration message. */
    private Object domainObject;

    /** Tracks how many attempts that has been made to finalize this message. */
    private int numberOfAttempts;

    public IntegrationMessage(String entityId, MetaData metaData) {
        this.entityId = entityId;
        this.metaData = metaData;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public boolean isOutOfSequence() {
        return outOfSequence;
    }

    public void setOutOfSequence(boolean outOfSequence) {
        this.outOfSequence = outOfSequence;
    }

    public String getEntityId() {
        return entityId;
    }

    public Object getDomainObject() {
        return domainObject;
    }

    public void setDomainObject(Object domainObject) {
        this.domainObject = domainObject;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }
}

