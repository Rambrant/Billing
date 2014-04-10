package com.tradedoubler.billing.transform.webservice;

import com.tradedoubler.billing.domain.*;
import org.datacontract.schemas._2004._07.dynamics_ax.*;

import java.util.List;

import static com.tradedoubler.billing.transform.webservice.AxUtil.convertNullToEmptyString;

/**
 * Convert a list of Order Lines to Ax representations of the same.
 * 
 * User: erigu
 * Date: 2012-09-04
 */
public class OrderLineToAxSalesOrderBasisLineContractTransformer {
    private final List<OrderLine> orderLines;
    private final ObjectFactory objectFactory = new ObjectFactory();

    public OrderLineToAxSalesOrderBasisLineContractTransformer(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public ArrayOfMDSITGSalesOrderBasisLineContract transform() {

        ArrayOfMDSITGSalesOrderBasisLineContract orderBasisLineContractArray = new ArrayOfMDSITGSalesOrderBasisLineContract();

        for (OrderLine orderLine : orderLines) {
            MDSITGSalesOrderBasisLineContract orderBasisLineContract = createOneSalesOrderBasisLineContract(orderLine);
            orderBasisLineContractArray.getMDSITGSalesOrderBasisLineContract().add(orderBasisLineContract);
        }

        return orderBasisLineContractArray;
    }

    public ArrayOfMDSITGSalesOrderBasisLineContract transformForUpdate() {

        ArrayOfMDSITGSalesOrderBasisLineContract orderBasisLineContractArray = transform();
        AxUtil.addUpdateInfoOrderLine(orderBasisLineContractArray);

        return orderBasisLineContractArray;
    }


    private MDSITGSalesOrderBasisLineContract createOneSalesOrderBasisLineContract(OrderLine orderLine) {
        MDSITGSalesOrderBasisLineContract orderBasisLineContract = new MDSITGSalesOrderBasisLineContract();
        orderBasisLineContract.setParmClientAgreementSourceSystemAgreement(objectFactory.createMDSITGSalesOrderBasisLineContractParmClientAgreementSourceSystemAgreement(orderLine.getSystemAgreementId()));
        orderBasisLineContract.setParmCostAmount(orderLine.getCost().getValue());

        orderBasisLineContract.setParmCreditedInvoiceId(objectFactory.createMDSITGSalesOrderBasisLineContractParmCreditedInvoiceId(
                convertNullToEmptyString(orderLine.getCreditedInvoiceID())));

        Timestamp dateOfPrepayment = orderLine.getDateOfPrepayment();
        if (dateOfPrepayment != null) {
            orderBasisLineContract.setParmDateOfPrepayment(DateConverter.convertISO8601WithTimeToXMLGregorianCalendar(dateOfPrepayment.getTimestamp()));
        } else {
            // This will not reset the value if updated, but we don't know how to do that.
            orderBasisLineContract.setParmDateOfPrepayment(null);
        }

        if (orderLine.getDebitOrCredit() == null) {
            throw new IllegalStateException("Debit or Credit flag must be set.");
        }
        orderBasisLineContract.setParmDebit(orderLine.getDebitOrCredit() == DebitOrCredit.DEBIT ? NoYes.YES : NoYes.NO);

        orderBasisLineContract.setParmDescription(objectFactory.createMDSITGSalesOrderBasisLineContractParmDescription(
                convertNullToEmptyString(orderLine.getDescription())));

        orderBasisLineContract.setParmInvoiceable(orderLine.isInvoiceable() ? NoYes.YES : NoYes.NO);
        orderBasisLineContract.setParmOrderBasisLineId(objectFactory.createMDSITGSalesOrderBasisLineContractParmOrderBasisLineId(orderLine.getOrderLineId()));
        orderBasisLineContract.setParmOrderItemId(objectFactory.createMDSITGSalesOrderBasisLineContractParmOrderItemId(orderLine.getSalesPart()));
        orderBasisLineContract.setParmPeriod(objectFactory.createMDSITGSalesOrderBasisLineContractParmPeriod(orderLine.getPeriod()));
        orderBasisLineContract.setParmQuantity(orderLine.getQuantity());
        orderBasisLineContract.setParmSplitterValue(objectFactory.createMDSITGSalesOrderBasisLineContractParmSplitterValue(orderLine.getSplitter()));
        orderBasisLineContract.setParmTotalAmount(orderLine.getTotal().getValue());
        orderBasisLineContract.setParmStatus(MDSSalesOrderBasisLineStatus.UNPROCESSED);

        return orderBasisLineContract;
    }


}
