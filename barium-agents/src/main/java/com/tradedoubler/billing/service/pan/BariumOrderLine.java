package com.tradedoubler.billing.service.pan;

import com.tradedoubler.billing.domain.*;

import java.math.BigDecimal;

/**
 * @author Thomas Rambrant (thore)
 */

public class BariumOrderLine extends OrderLine
{
    private Integer numberOfOrderLines;
    private String  batchId;

    public BariumOrderLine(
        String        batchId,
        String        systemAgreementId,
        String        orderLineId,
        boolean       invoiceable,
        String        salesPart,
        String        description,
        int           quantity,
        BigDecimal    total,
        BigDecimal    cost,
        String        period,
        Timestamp     dateOfPrepayment,
        DebitOrCredit debitOrCredit,
        String        creditedInvoiceID,
        String        splitter)
    {
        super(
            systemAgreementId,
            orderLineId,
            invoiceable,
            salesPart,
            description,
            total,
            cost,
            period,
            dateOfPrepayment,
            creditedInvoiceID,
            splitter);

        super.setQuantity(quantity);
        super.setDebitOrCredit(debitOrCredit);
        this.batchId            = batchId;
        this.numberOfOrderLines = 1;

    }

    public String getBatchId()
    {
        return batchId;
    }

    public void setBatchId( String batchId)
    {
        this.batchId = batchId;
    }

    public Integer getNumberOfOrderLines()
    {
        return numberOfOrderLines;
    }

    public void setNumberOfOrderLines( Integer numberOfOrderLines)
    {
        this.numberOfOrderLines = numberOfOrderLines;
    }
}
