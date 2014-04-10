package com.tradedoubler.billing.derby.dto;

import com.tradedoubler.billing.type.ProducerEventDbType;

import java.sql.Timestamp;

/**
 * @author Thomas Rambrant (thore)
 */

public class CrmMessageDto
{
    //
    // The database row id
    //
    private Long id;

    //
    // The system time when this record was created
    //
    private Timestamp created;

    //
    // The entity id. helps when searching for a specific entity
    //
    private String entityId;

    //
    // The error type that controls the type of handling we expect
    //
    private ProducerEventDbType eventType = ProducerEventDbType.NONE;

    //
    // Set to true to signal that this message is a create message that should not be sent until
    // the corresponding ,out of order, update message has been treated. This flag is set to false
    // by the output service
    //
    private Boolean outOfOrder = false;

    //
    // The row id of the create entity that we set to out_of_order. This is set on update messages and
    // its used to control the flow for out of order errors
    //
    private Long associatedRowId = 0L;

    //
    // This message has been sent and will not be seen again until the visibility time out has been reached
    //
    private Boolean sent = false;

    //
    // When did we send this. Used to control the visibility
    //
    private Timestamp sendTime;

    //
    // How many times has this message been sent? Used for error control
    //
    private Long numberOfSends = 0L;

    //
    // This message has been deleted
    //
    private Boolean deleted = false;

    //
    // When did we delete this.
    //
    private Timestamp deleteTime;

    //
    // The message id entered in the MetaData of the JSON message
    //
    private String messageId;

    //
    // The actual JSON message string
    //
    private String jsonMessage = "";

    public Long getId()
    {
        return id;
    }

    public void setId( Long rowId)
    {
        this.id = rowId;
    }

    public Timestamp getCreated()
    {
        return created;
    }

    public String getEntityId()
    {
        return entityId;
    }

    public void setEntityId( String entityId )
    {
        this.entityId = entityId;
    }

    public String getJsonMessage()
    {
        return jsonMessage;
    }

    public void setJsonMessage( String jsonMessage)
    {
        this.jsonMessage = jsonMessage.replace( "\n", " ");
    }

    public String getMessageId()
    {
        return messageId;
    }

    public void setMessageId( String messageId)
    {
        this.messageId = messageId;
    }

    public ProducerEventDbType getEventType()
    {
        return eventType;
    }

    public void setEventType( ProducerEventDbType eventType)
    {
        this.eventType = eventType;
    }

    public Boolean isOutOfOrder()
    {
        return outOfOrder;
    }

    public void setOutOfOrder( Boolean outOfOrder)
    {
        this.outOfOrder = outOfOrder;
    }

    public void setAssociatedRowId( Long associatedRowId)
    {
        this.associatedRowId = associatedRowId;
    }

    public Long getAssociatedRowId()
    {
        return associatedRowId;
    }

    public Boolean isSent()
    {
        return sent;
    }

    public void setSent( boolean status)
    {
        this.numberOfSends += 1;

        this.sent     = status;
        this.sendTime = new Timestamp( System.currentTimeMillis());
    }

    public Timestamp getSendTime()
    {
        return sendTime;
    }

    public Long getNumberOfSends()
    {
        return numberOfSends;
    }

    public Boolean isDeleted()
    {
        return deleted;
    }

    public void setDeleted( boolean status)
    {
        this.deleted    = status;
        this.deleteTime = new Timestamp( System.currentTimeMillis());
    }

    public Timestamp getDeleteTime()
    {
        return deleteTime;
    }

    @Override
    public String toString()
    {
        return "CrmMessageDto { "     +
              "id = "                 + id                 +
            ", entityId = "           + entityId           +
            ", eventType = "          + eventType          +
            ", outOfOrder = "         + outOfOrder         +
            ", associatedRowId = "    + associatedRowId    +
            ", sent = "               + sent               +
            ", sendTime = "           + sendTime           +
            ", numberOfSends = "      + numberOfSends      +
            ", created = "            + created            +
            ", deleted = "            + deleted            +
            ", deleteTime = "         + deleteTime         +
            ", jsonMessage = '"       + jsonMessage        +
            '}';
    }

    public String shortString()
    {
        String shortJson = jsonMessage.replace( "\n", " ");

        if( jsonMessage.length() > 100)
        {
            shortJson = shortJson.substring( 0, 100) + "...";
        }

        return "CrmMessageDto { "     +
              "id = "                 + id                 +
            ", entityId = "           + entityId           +
            ", eventType = "          + eventType          +
            ", outOfOrder = "         + outOfOrder         +
            ", associatedRowId = "    + associatedRowId    +
            ", sent = "               + sent               +
            ", sendTime = "           + sendTime           +
            ", numberOfSends = "      + numberOfSends      +
            ", created = "            + created            +
            ", deleted = "            + deleted            +
            ", deleteTime = "         + deleteTime         +
            ", jsonMessage = '"       + shortJson          +
            '}';
    }

    //
    // These methods are only used by the database RowMapper class and should not be used directly by anyone else
    // These have to be public to allow the RowMapper to use them
    //
    public void setSendTime( Timestamp sendTime)
    {
        this.sendTime = sendTime;
    }

    public void setNumberOfSends( Long numberOfSends)
    {
        this.numberOfSends = numberOfSends;
    }

    public void setDeleteTime( Timestamp deleteTime)
    {
        this.deleteTime = deleteTime;
    }

    public void setCreated( Timestamp created)
    {
        this.created = created;
    }
}
