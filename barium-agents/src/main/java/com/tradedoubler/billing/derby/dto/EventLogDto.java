package com.tradedoubler.billing.derby.dto;

import com.tradedoubler.billing.fetch.FlowName;
import com.tradedoubler.billing.type.EventLogType;

import java.sql.Timestamp;

/**
 * @author Thomas Rambrant (thore)
 */

public class EventLogDto
{
    private Long         id;
    private Timestamp    created;
    private FlowName     flowName;
    private String       integrationPointId;
    private String       messageId;
    private EventLogType eventType;

    public Long getId()
    {
        return id;
    }

    public void setId( Long id)
    {
        this.id = id;
    }

    public Timestamp getCreated()
    {
        return created;
    }

    public void setCreated( Timestamp created)
    {
        this.created = created;
    }

    public FlowName getFlowName()
    {
        return flowName;
    }

    public void setFlowName( FlowName flowName)
    {
        this.flowName = flowName;
    }

    public String getIntegrationPointId()
    {
        return integrationPointId;
    }

    public void setIntegrationPointId( String integrationPointId)
    {
        this.integrationPointId = integrationPointId;
    }

    public String getMessageId()
    {
        return messageId;
    }

    public void setMessageId( String messageId)
    {
        this.messageId = messageId;
    }

    public EventLogType getEventType()
    {
        return eventType;
    }

    public void setEventType( EventLogType eventType)
    {
        this.eventType = eventType;
    }

    @Override
    public String toString()
    {
        return "EventLogDto { " +
              "id = "                 + id                 +
            ", eventType = "          + eventType          +
            ", flowName = "           + flowName           +
            ", integrationPointId = " + integrationPointId +
            ", messageId = '"         + messageId          + "'" +
            ", created = "            + created            +
            '}';
    }
}
