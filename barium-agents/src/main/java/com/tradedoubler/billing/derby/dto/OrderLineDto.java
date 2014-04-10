package com.tradedoubler.billing.derby.dto;

import com.tradedoubler.billing.type.ProducerEventDbType;

import java.sql.Timestamp;

/**
 * @author Thomas Rambrant (thore)
 */

public class OrderLineDto
{
    //
    // The database row id
    //
    private Long id;

    //
    // The entity id. helps when searching for a specific agreement
    //
    private String agreementId;

    //
    // The system time when this record was created
    //
    private Timestamp created;

    //
    // The error type that controls the type of handling we expect
    //
    private ProducerEventDbType eventType = ProducerEventDbType.NONE;

    //
    // This message has been handled and will not be seen again
    //
    private Boolean handled = false;

    //
    // The batch id of this "collection" of order lines
    //
    private String batchId;

    //
    // The number of order lines that the json message represents
    //
    private Integer numOrderLines;

    //
    // The "starting" id of the order lines to generate
    //
    private String orderLineId;

    //
    // The actual JSON message string
    //
    private String jsonOrderLine = "";

    public Long getId()
    {
        return id;
    }

    public void setId( Long rowId)
    {
        this.id = rowId;
    }

    public String getAgreementId()
    {
        return agreementId;
    }

    public void setAgreementId( String agreementId)
    {
        this.agreementId = agreementId;
    }

    public void setCreated( Timestamp created)
    {
        this.created = created;
    }

    public Timestamp getCreated()
    {
        return created;
    }

    public String getBatchId()
    {
        return batchId;
    }

    public void setBatchId( String batchId)
    {
        this.batchId = batchId;
    }

    public Integer getNumOrderLines()
    {
        return numOrderLines;
    }

    public void setNumOrderLines( Integer numOrderLines)
    {
        this.numOrderLines = numOrderLines;
    }

    public String getOrderLineId()
    {
        return orderLineId;
    }

    public void setOrderLineId( String orderLineId)
    {
        this.orderLineId = orderLineId;
    }

    public String getJsonOrderLine()
    {
        return jsonOrderLine;
    }

    public void setJsonOrderLine( String jsonOrderLine)
    {
        this.jsonOrderLine = jsonOrderLine.replace( "\n", " ");
    }

    public ProducerEventDbType getEventType()
    {
        return eventType;
    }

    public void setEventType( ProducerEventDbType eventType)
    {
        this.eventType = eventType;
    }

    public void setHandled( Boolean handled)
    {
        this.handled = handled;
    }

    public Boolean isHandled()
    {
        return handled;
    }

    @Override
    public String toString()
    {
        return "OrderLineDto { "   +
              "id = "                 + id            +
            ", eventType = "          + eventType     +
            ", handled = "            + handled       +
            ", created = "            + created       +
            ", batch_id = "           + batchId       +
            ", numOrderLines = "      + numOrderLines +
            ", orderLineId = "        + orderLineId   +
            ", jsonOrderLine = '"     + jsonOrderLine +
            '}';
    }


    public String shortString()
    {
        String shortJson = jsonOrderLine.replace( "\n", " ");

        if( jsonOrderLine.length() > 100)
        {
            shortJson = shortJson.substring( 0, 100) + "...";
        }

        return "OrderLineDto { "   +
              "id = "                 + id            +
            ", eventType = "          + eventType     +
            ", handled = "            + handled       +
            ", created = "            + created       +
            ", batch_id = "           + batchId       +
            ", numOrderLines = "      + numOrderLines +
            ", orderLineId = "        + orderLineId   +
            ", jsonOrderLine = '"     + shortJson     +
            '}';
    }
}
