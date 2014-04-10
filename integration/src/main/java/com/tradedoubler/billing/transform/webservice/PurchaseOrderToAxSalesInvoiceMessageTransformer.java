package com.tradedoubler.billing.transform.webservice;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr.AxdEntityMDSSalesInvoiceMessage;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumMDSSalesMessageSourceType;
import com.tradedoubler.billing.domain.PurchaseOrder;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;

/**
 * Transforms a purchase order to an Ax Webservice invoice message.<br>
 * <b>Note:</b> according to the integration document, a PurchaseOrder domain object is mapped to an AX InvoiceMessage represented
 * by the wsdl generated class used in the invoice rule web-service message call.
 */
class PurchaseOrderToAxSalesInvoiceMessageTransformer {
    private final List<PurchaseOrder> purchaseOrders;

       public PurchaseOrderToAxSalesInvoiceMessageTransformer(List<PurchaseOrder> purchaseOrders) {
           this.purchaseOrders = purchaseOrders;
       }


       public List<AxdEntityMDSSalesInvoiceMessage> transform() {
           ArrayList<AxdEntityMDSSalesInvoiceMessage> salesInvoiceMessages = new ArrayList<AxdEntityMDSSalesInvoiceMessage>();

           for (PurchaseOrder purchaseOrder : purchaseOrders) {

               AxdEntityMDSSalesInvoiceMessage message = transformOnePurchaseOrder(purchaseOrder);

               salesInvoiceMessages.add(message);
           }
           return salesInvoiceMessages;
       }

       private AxdEntityMDSSalesInvoiceMessage transformOnePurchaseOrder(PurchaseOrder purchaseOrder) {
           AxdEntityMDSSalesInvoiceMessage message = new AxdEntityMDSSalesInvoiceMessage();
           message.setClazz("entity");
           message.setInvoiceMessageId(purchaseOrder.getPurchaseOrderId().getGuidForAx());
           message.setSourceType(AxdEnumMDSSalesMessageSourceType.INVOICE_RULE_PURCHASE_ORDER);
           message.setText(purchaseOrder.getPoNumber());
           XMLGregorianCalendar from = DateConverter.convertISO8601ToXMLGregorianCalendar(purchaseOrder.getValidFrom().getTimestamp());
           XMLGregorianCalendar to = DateConverter.convertISO8601ToXMLGregorianCalendar(purchaseOrder.getValidTo().getTimestamp());
           message.setValidFrom(from);
           message.setValidTo(to);
           return message;
       }

}
