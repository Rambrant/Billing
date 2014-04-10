package com.tradedoubler.billing.transform.webservice;

import com.tradedoubler.billing.domain.*;
import org.datacontract.schemas._2004._07.dynamics_ax.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

import static junit.framework.Assert.assertEquals;

/**
 * User: erigu
 * Date: 2012-09-21
 */
public class OrderLineToAxSalesOrderBasisLineContractTransformerTest {

    private OrderLineToAxSalesOrderBasisLineContractTransformer orderLineToAxSalesOrderBasisLineContractTransformer;

    @Test
    public void testTransform() {
        List<OrderLine> orderLines = createMockedOrderLines();
        orderLineToAxSalesOrderBasisLineContractTransformer = new OrderLineToAxSalesOrderBasisLineContractTransformer(orderLines);
        ArrayOfMDSITGSalesOrderBasisLineContract axObject = orderLineToAxSalesOrderBasisLineContractTransformer.transform();
        assertEquals(2, axObject.getMDSITGSalesOrderBasisLineContract().size());

        for (int i = 0; i < axObject.getMDSITGSalesOrderBasisLineContract().size(); i++) {
            MDSITGSalesOrderBasisLineContract olItem = axObject.getMDSITGSalesOrderBasisLineContract().get(i);
            assertEquals("0-fa51ee9a469e", olItem.getParmClientAgreementSourceSystemAgreement().getValue());
            assertEquals(0, BigDecimal.valueOf(695.21).compareTo(olItem.getParmCostAmount()));
            assertEquals("11111", olItem.getParmCreditedInvoiceId().getValue());
            assertEquals("11111", olItem.getParmCreditedInvoiceId().getValue());

            assertEquals( MDSSalesOrderBasisLineStatus.UNPROCESSED, olItem.getParmStatus());

            assertEquals("2012-10-26T21:32:52", olItem.getParmDateOfPrepayment().toString());
            assertEquals("Yes", olItem.getParmDebit().value());
            assertEquals("descr" + i, olItem.getParmDescription().getValue());
            assertEquals("Yes", olItem.getParmInvoiceable().value());
            assertEquals("orderLineID" + i, olItem.getParmOrderBasisLineId().getValue());
            assertEquals("110", olItem.getParmOrderItemId().getValue());
            assertEquals("1301", olItem.getParmPeriod().getValue());
            assertEquals(Integer.valueOf(1), olItem.getParmQuantity());
            assertEquals("" + i, olItem.getParmSplitterValue().getValue());

        }


    }

    @Test
    public void testUpdateTransform() {
        List<OrderLine> orderLines = createMockedOrderLines();
        orderLineToAxSalesOrderBasisLineContractTransformer = new OrderLineToAxSalesOrderBasisLineContractTransformer(orderLines);
        ArrayOfMDSITGSalesOrderBasisLineContract axObject = orderLineToAxSalesOrderBasisLineContractTransformer.transformForUpdate();
        assertEquals(2, axObject.getMDSITGSalesOrderBasisLineContract().size());

        for (int i = 0; i < axObject.getMDSITGSalesOrderBasisLineContract().size(); i++) {
            MDSITGSalesOrderBasisLineContract olItem = axObject.getMDSITGSalesOrderBasisLineContract().get(i);
            assertEquals("0-fa51ee9a469e", olItem.getParmClientAgreementSourceSystemAgreement().getValue());
            assertEquals(0, BigDecimal.valueOf(695.21).compareTo(olItem.getParmCostAmount()));
            assertEquals("11111", olItem.getParmCreditedInvoiceId().getValue());
            assertEquals("11111", olItem.getParmCreditedInvoiceId().getValue());

            assertEquals(MDSSalesOrderBasisLineStatus.READY_FOR_REPROCESS, olItem.getParmStatus());

            assertEquals("2012-10-26T21:32:52", olItem.getParmDateOfPrepayment().toString());
            assertEquals("Yes", olItem.getParmDebit().value());
            assertEquals("descr" + i, olItem.getParmDescription().getValue());
            assertEquals("Yes", olItem.getParmInvoiceable().value());
            assertEquals("orderLineID" + i, olItem.getParmOrderBasisLineId().getValue());
            assertEquals("110", olItem.getParmOrderItemId().getValue());
            assertEquals("1301", olItem.getParmPeriod().getValue());
            assertEquals(Integer.valueOf(1), olItem.getParmQuantity());
            assertEquals("" + i, olItem.getParmSplitterValue().getValue());

        }

    }

    private List<OrderLine> createMockedOrderLines() {
        List<OrderLine> orderLines = new ArrayList<OrderLine>();

        for (int i = 0; i < 2; i++) {
            String id = "orderLineID";
            String dateString = "2012-10-26T21:32:52";
            OrderLine orderLine = new OrderLine("0-fa51ee9a469e", id + i, true, "110", "descr" + i,
                    BigDecimal.valueOf(1390.43), BigDecimal.valueOf(695.21),
                    "1301", new Timestamp(dateString), "11111", "" + i);
            orderLine.setQuantity(1);
            orderLine.setDebitOrCredit(DebitOrCredit.DEBIT);

            orderLines.add(orderLine);
        }

        return orderLines;
    }

}
