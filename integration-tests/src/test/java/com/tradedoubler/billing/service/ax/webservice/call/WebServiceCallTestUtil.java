package com.tradedoubler.billing.service.ax.webservice.call;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.util.AxDbConstantsUtil;
import org.joda.time.DateTime;

import java.util.*;

/**
 * @author bjoek
 * @since 2012-11-13
 */
public class WebServiceCallTestUtil {
    public static Client createClient(String id, int marketId) {
        char[] lineArr = new char[120];
        Arrays.fill(lineArr, 'l');
        Address address = new Address(new String(lineArr), new String(lineArr),
                "123456789012345678901234567890123456789012345678901234567890",
                "123456789012345678901234567890123456789012345678901234567890",
                "1234567890", "SE", 3);
        List<Integer> markets = Arrays.asList(marketId);
        char[] nameArr = new char[100];
        Arrays.fill(nameArr, 'n');
        return new Client(id, new String(nameArr), "1234567890123456789012345", "12345678901234567890", ClientType.ADVERTISER,
                "SV", "12345678901234567890123456789012345678901234567890",
                new ArrayList<Bank>(), address,
                new ArrayList<ClientMessageRule>(), markets);
    }

    public static Agreement createAgreement(String id, String clientAccountNum, String invoiceRuleId, int marketId) {
        char[] documentLink = new char[200];
        Arrays.fill(documentLink, 'q');
        return new Agreement(id, clientAccountNum, invoiceRuleId,
                "123456789012345678901234567890123456789012345678901234567890", 1, marketId, "SEK", new Timestamp(new DateTime().minusDays(30)), new Timestamp(),
                new String(documentLink));
    }

    public static Agreement createAgreementWithNullDates(String id, String clientAccountNum, String invoiceRuleId, int marketId) {
        return new Agreement(id, clientAccountNum, invoiceRuleId,
                "test", 1, marketId, "SEK", null, null, "\\\\someserver\\somefolder\\somefile.pdf");
    }

    public static InvoicingRule createInvoicingRule(String id, String clientAccountNum, int marketId) {
        char[] msgArr = new char[200];
        Arrays.fill(msgArr, 'x');

        List<InvoicingRuleMessageRule> messages = new ArrayList<InvoicingRuleMessageRule>();
        messages.add(new InvoicingRuleMessageRule(AxDbConstantsUtil.generateInvoiceMessageRuleId(), id,
                new String(msgArr),
                new Timestamp(new DateTime().minusDays(10)), new Timestamp()));
        messages.add(new InvoicingRuleMessageRule(AxDbConstantsUtil.generateInvoiceMessageRuleId(), id,
                new String(msgArr),
                new Timestamp(new DateTime().minusDays(20)), new Timestamp()));

        List<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
        purchaseOrders.add(new PurchaseOrder(AxDbConstantsUtil.generatePurchaseOrderId(), id, new String(msgArr),
                new Timestamp(new DateTime().minusDays(30)), new Timestamp()));
        purchaseOrders.add(new PurchaseOrder(AxDbConstantsUtil.generatePurchaseOrderId(), id, new String(msgArr),
                new Timestamp(new DateTime().minusDays(40)), new Timestamp()));

        return new InvoicingRule(clientAccountNum,
                marketId, id, "123456789012345678901234567890123456789012345678901234567890",
                new String(msgArr), "123456789012345678901234567890123456789012345678901234567890",
                "123456789012345678901234567890123456789012345678901234567890", "SEK", 1, 30, 1, true,
                1, 1, true, new ArrayList<InvoiceRecipient>(), purchaseOrders,
                messages, new ArrayList<String>());
    }

    public static InvoicingRule createInvoicingRule(String invoiceRuleId, List<InvoicingRuleMessageRule> messages, String clientAccountNum, int marketId) {
        return new InvoicingRule(clientAccountNum,
                marketId, invoiceRuleId, "Test", "test", "Issuer Reference", "John Doe", "SEK", 1, 30, 1, true,
                1, 1, false, new ArrayList<InvoiceRecipient>(), new ArrayList<PurchaseOrder>(),
                messages, new ArrayList<String>());
    }

    public static List<InvoicingRuleMessageRule> createMessages(String invoiceRuleId, String... invRuleMessageId) {
        List<InvoicingRuleMessageRule> messages = new ArrayList<InvoicingRuleMessageRule>();
        for (String messageId : invRuleMessageId) {
            messages.add(new InvoicingRuleMessageRule(messageId, invoiceRuleId, "messageText",
                    new Timestamp(), new Timestamp()));
        }
        return messages;
    }

    public static Bank createBank(String clientId, int marketId) {
        return new Bank(clientId, marketId, "SWEDBANK42", "1234567890123456789012345678901234", "123456789012345678901234567890123456789012345678901234567890");
    }

}
