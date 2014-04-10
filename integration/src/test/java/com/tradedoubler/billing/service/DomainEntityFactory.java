package com.tradedoubler.billing.service;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.domain.Currency;
import com.tradedoubler.billing.service.ax.webservice.call.OrderLineResponseResult;
import org.joda.time.DateMidnight;

import java.math.BigDecimal;
import java.util.*;

import static com.tradedoubler.billing.util.AxDbConstantsUtil.*;

/**
 * @author bjoek
 * @since 2012-10-05
 */
public class DomainEntityFactory {

    private static final int MARKET_ORG_ID_SE = 51;
    private static final int MARKET_ORG_ID_DE = 135899;
    private static final int MARKET_ORG_ID_NO = 81861;

    public static Agreement createAgreement() {
        return new Agreement("sourceSystemAgreementId", "clientId",
                "invoicingRuleId", "description", 1, MARKET_ORG_ID_SE, "currencyCode",
                new Timestamp(new DateMidnight(2010, 10, 11)),
                new Timestamp(new DateMidnight(2010, 11, 12)),
                "documentLink");
    }

    public static InvoicingRule createInvoicingRule() {
        List<InvoicingRuleMessageRule> messages = new ArrayList<InvoicingRuleMessageRule>();
        messages.add(new InvoicingRuleMessageRule("invoiceMessageRuleId1", EXISTING_INVOICE_RULE_ID, "messageText",
                new Timestamp(), new Timestamp()));
        messages.add(new InvoicingRuleMessageRule("invoiceMessageRuleId2", EXISTING_INVOICE_RULE_ID, "messageText",
                new Timestamp(), new Timestamp()));

        List<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
        purchaseOrders.add(new PurchaseOrder("PurchaseOrderId1", EXISTING_INVOICE_RULE_ID, "Po Num",
                new Timestamp(), new Timestamp()));
        purchaseOrders.add(new PurchaseOrder("PurchaseOrderId2", EXISTING_INVOICE_RULE_ID, "Po Num",
                new Timestamp(), new Timestamp()));


        ArrayList<InvoiceRecipient> invoiceRecipients = new ArrayList<InvoiceRecipient>();
        Address address = new Address("line 1", "line 2", "Stockholm", "county", "123-456", "SE", 1);
        invoiceRecipients.add(new InvoiceRecipient("invRecId1", EXISTING_INVOICE_RULE_ID, "attRow1", "attRow2", "test@test.test",
                true, address, createSplittingRules("invRecId1", "splitter1", "splitter2")));
        invoiceRecipients.add(new InvoiceRecipient("invRecId2", EXISTING_INVOICE_RULE_ID, "attRow1", "attRow2", "test@test.test",
                true, address, createSplittingRules("invRecId2", "splitter4", "splitter5")));

        List<String> sourceSystemAgreementIds = new ArrayList<String>();
        sourceSystemAgreementIds.add("1-1234");
        sourceSystemAgreementIds.add("1-4321");

        return new InvoicingRule(EXISTING_CLIENT_ACCOUNT_NUM,
                MARKET_ORG_ID_SE, EXISTING_INVOICE_RULE_ID, "Test", "test", "Issuer Reference", "John Doe", "SEK", 1, 30, 1, true,
                1, 1, false, invoiceRecipients, purchaseOrders,
                messages, sourceSystemAgreementIds);
    }

    public static Client createClient() {
        String clientId = "clientId";

        Address address = new Address("Vasagatan 38", null, "Göteborg", null, "11120", "SE", 3);

        ArrayList<Bank> bankAccounts = new ArrayList<Bank>();
        bankAccounts.add(new Bank(clientId, MARKET_ORG_ID_SE, "bankCode", "bankAccount1", "accountOwner"));
        bankAccounts.add(new Bank(clientId, MARKET_ORG_ID_DE, "bankCode", "bankAccount2", "accountOwner"));

        ArrayList<ClientMessageRule> invoiceMessageRules = new ArrayList<ClientMessageRule>();
        invoiceMessageRules.add(new ClientMessageRule("invoiceMessageRuleId1", clientId,
                "messageText", new Timestamp(), new Timestamp()));
        invoiceMessageRules.add(new ClientMessageRule("invoiceMessageRuleId2", clientId,
                "messageText", new Timestamp(), new Timestamp()));

        return new Client(clientId, "Dummy", "5562842319", "SE556284231901", ClientType.ADVERTISER, "SV", "",
                bankAccounts, address,
                invoiceMessageRules, Arrays.asList(MARKET_ORG_ID_SE, MARKET_ORG_ID_NO));
    }


    private static ArrayList<SplittingRule> createSplittingRules(String invoiceRecipientId, String... ids) {
        ArrayList<SplittingRule> splittingRules = new ArrayList<SplittingRule>();
        for (String id : ids) {
            splittingRules.add(new SplittingRule(id, invoiceRecipientId, "splitter"));
        }
        return splittingRules;
    }

    public static List<OrderLine> createOrderLines() {
        List<OrderLine> orderLines = new ArrayList<OrderLine>();
        for (int i = 0; i < 10; i++) {
            OrderLine orderLine = createOrderLine(i, BigDecimal.valueOf(1390.43), BigDecimal.valueOf(695.21));

            orderLines.add(orderLine);
        }
        return orderLines;
    }

    public static List<OrderLine> createValidationOrderLines() {
        List<OrderLine> returnValue = new ArrayList<OrderLine>();
        int counter = 0;
        //Failed
        returnValue.add(createOrderLine(++counter, new BigDecimal("0"), new BigDecimal("0")));
        //OK
        returnValue.add(createOrderLine(++counter, new BigDecimal("0"), new BigDecimal("5")));
        //OK
        returnValue.add(createOrderLine(++counter, new BigDecimal("0"), new BigDecimal("-5")));

        //OK
        returnValue.add(createOrderLine(++counter, new BigDecimal("10"), new BigDecimal("0")));
        //Ok
        returnValue.add(createOrderLine(++counter, new BigDecimal("10"), new BigDecimal("5")));
        //Wrong cost
        returnValue.add(createOrderLine(++counter, new BigDecimal("10"), new BigDecimal("-5")));

        //Wrong total
        returnValue.add(createOrderLine(++counter, new BigDecimal("-10"), new BigDecimal("5")));
        //OK
        returnValue.add(createOrderLine(++counter, new BigDecimal("-10"), new BigDecimal("-5")));
        //OK
        returnValue.add(createOrderLine(++counter, new BigDecimal("-10"), new BigDecimal("0")));

        return returnValue;
    }

    private static OrderLine createOrderLine(int counter, BigDecimal total, BigDecimal cost) {
        OrderLine orderLine = new OrderLine("0-fa51ee9a469e", "" + counter, true, "110", "descr" + counter,
                total, cost, "1301", new Timestamp("2012-10-26T21:32:52"),
                "11111", "" + counter);

        return orderLine;
    }

    public static List<PrepaymentOrderLine> createPrepaymentOrderLines() {
        List<PrepaymentOrderLine> returnValue = new ArrayList<PrepaymentOrderLine>();

        returnValue.add(createPaymentOrderLine("1-1234567890", 100, 10, "120", "1301"));
        returnValue.add(createPaymentOrderLine("1-1234567890", 100, 10, "120", "1301"));
        returnValue.add(createPaymentOrderLine("1-1234567890", 100, 10, "114", "1301"));
        returnValue.add(createPaymentOrderLine("1-1234567890", 100, 10, "114", "1302"));
        returnValue.add(createPaymentOrderLine("1-4242424242", 100, 10, "120", "1301"));
        returnValue.add(createPaymentOrderLine("1-4242424242", 100, 10, "120", "1302"));

        return returnValue;
    }

    private static PrepaymentOrderLine createPaymentOrderLine(String systemAgreementId, int total, int cost, String salesPart, String period) {
        return new PrepaymentOrderLine(
                new OrderLine(systemAgreementId, "orderLineId", true, salesPart, "description",
                        new BigDecimal(total), new BigDecimal(cost), period, new Timestamp(), null,
                        null),
                new Currency("SEK"));
    }

    public static List<OrderLineResponseResult> createFailedOrderLineResults() {
        List<OrderLineResponseResult> list = new ArrayList<OrderLineResponseResult>();
        list.add(new OrderLineResponseResult("1", "Gick inte", "bad state"));
        list.add(new OrderLineResponseResult("3", "Gick inte", "bad state"));
        list.add(new OrderLineResponseResult("5", "Gick inte", "bad state"));
        list.add(new OrderLineResponseResult("7", "Gick inte", "bad state"));
        list.add(new OrderLineResponseResult("9", "Gick inte", "bad state"));
        return list;
    }

}
