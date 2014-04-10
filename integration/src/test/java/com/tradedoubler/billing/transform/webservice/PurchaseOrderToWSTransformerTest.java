package com.tradedoubler.billing.transform.webservice;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr.AxdEntityMDSSalesInvoiceMessage;
import com.tradedoubler.billing.domain.PurchaseOrder;
import com.tradedoubler.billing.domain.Timestamp;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * User: erigu
 * Date: 2012-09-21
 */
public class PurchaseOrderToWSTransformerTest {

    private PurchaseOrderToAxSalesInvoiceMessageTransformer purchaseOrderToAxSalesInvoiceMessageTransformer;

    @Test
    public void testTransform(){

        List<PurchaseOrder> purchaseOrders = createPurchaseOrders();
        purchaseOrderToAxSalesInvoiceMessageTransformer = new PurchaseOrderToAxSalesInvoiceMessageTransformer(purchaseOrders);


        List<AxdEntityMDSSalesInvoiceMessage> axObject = purchaseOrderToAxSalesInvoiceMessageTransformer.transform();
        assertEquals(2, axObject.size());

        for (int i = 0; i < axObject.size(); i++) {
            AxdEntityMDSSalesInvoiceMessage invoiceMessage = axObject.get(i);
            assertEquals("{PURCHID" + i + "}", invoiceMessage.getInvoiceMessageId());
            assertEquals("entity", invoiceMessage.getClazz());
            assertEquals("2012-10-26", invoiceMessage.getValidFrom().toString());
            assertEquals("2012-10-28", invoiceMessage.getValidTo().toString());
            assertEquals("poNum", invoiceMessage.getText());
            assertEquals("InvoiceRulePurchaseOrder", invoiceMessage.getSourceType().value());
        }


    }


    private List<PurchaseOrder> createPurchaseOrders() {
        List<PurchaseOrder> orderLines = new ArrayList<PurchaseOrder>();

        for (int i = 0; i < 2; i++) {
            String id = "purchID";
            String fromDate = "2012-10-26";
            String toDate = "2012-10-28";
            PurchaseOrder orderLine = new PurchaseOrder(id + i, "invId", "poNum", new Timestamp(fromDate), new Timestamp(toDate));

            orderLines.add(orderLine);
        }

        return orderLines;
    }

}
