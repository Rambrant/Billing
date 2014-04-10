package com.tradedoubler.billing.util;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author bjoek
 * @since 2012-09-17
 */
public class AxDbConstantsUtil {
    public static final String EXISTING_MARKET_ID = "51";
    public static final String EXISTING_CLIENT_ACCOUNT_NUM = "TELIA";
    public static final String EXISTING_AGREEMENT_ID = "TTHHQXTScafebabe0003";
    public static final String EXISTING_INVOICE_RULE_ID = "3F2504E0-4F89-11D3-9A0C-0305E82C3405";
    public static final String EXISTING_INVOICE_MESSAGE_RULE_ID = "00000000-0000-0000-3000-100000000001";
    public static final String EXISTING_INVOICE_MESSAGE_RULE_CLIENT_ID = "e4eb8a35-624d-48ca-8b91-f45002bb7a1e";
    public static final String EXISTING_INVOICE_MESSAGE_RULE_MARKET_ID = "885d8421-11f1-4684-1769-3478152e5597";
    public static final String EXISTING_SPLITTING_RULE_ID = "3BF0B4FF-CB76-45C7-9178-8B22C0F42381";
    public static final String EXISTING_INVOICE_RECIPIENT_ID = "703B123F-6329-4D79-BFAA-60762A5F6CF4";
    public static final String EXISTING_PURCHASE_ORDER_ID = "00000000-0000-0000-4000-100000000001";
    public static final String EXISTING_ORDER_LINE_ID = "AAAAA33333";

    private static final AtomicLong counter = new AtomicLong(0);

    /**
     * Generates a fresh invoice rule id prepended with facea ( fake a)
     * @return  A universally unique identifier (UUID), 128-bits and 32 characters
     */
    public static String generateInvoiceRuleId() {
        return replaceFront( "facea", UUID.randomUUID().toString());
    }

    /**
     * Generates a fresh invoice recipient id prepended with faceb ( fake b)
     * @return  A universally unique identifier (UUID), 128-bits and 32 characters
     */
    public static String generateInvoiceRecipientId() {
        return replaceFront( "faceb", UUID.randomUUID().toString());
    }

    /**
     * Generates a fresh invoice message rule id prepended with facec ( fake c)
     * @return  A universally unique identifier (UUID), 128-bits and 32 characters
     */
    public static String generateInvoiceMessageRuleId() {
        return replaceFront( "facec", UUID.randomUUID().toString());
    }

    /**
     * Generates a fresh purchase order rule id prepended with faced ( fake d)
     * @return  A universally unique identifier (UUID), 128-bits and 32 characters
     */
    public static String generatePurchaseOrderId() {
        return replaceFront( "faced", UUID.randomUUID().toString());
    }

    /**
     * Generates a fresh splitting rule id prepended with faced ( fake e)
     * @return  A universally unique identifier (UUID), 128-bits and 32 characters
     */
    public static String generateSplittingRuleId() {
        return replaceFront( "facee", UUID.randomUUID().toString());
    }

    /**
     * Generates a fresh client id
     * @return  A 10 characters id based on the current system time, prepended with "CL"
     */
    public static String generateClientId() {
        long time = System.currentTimeMillis();
        return "CL" + getLastChars( String.valueOf( time) + String.valueOf( time) + String.valueOf( time), 8);
    }

    /**
     * Generates a fresh order line id
     * @return  A 10 characters id based on the current system time, prepended with "OL"
     */
    public static String generateOrderLineId() {
        long time = getCurrentTimeMicros();
        return getLastChars( String.valueOf( time) + String.valueOf( time) + String.valueOf( time), 8);
    }

    /**
     * Generates a fresh agreement id
     * @return  A 2+10 characters id based on the current system time in ms and nanoseconds, prepended with "1-"
     */
    public static String generateAgreementId() {
        long time = getCurrentTimeMicros();
        long nanos = System.nanoTime();
        return "1-" + getLastChars( String.valueOf( time) + String.valueOf( nanos), 10);
    }

    private static String getLastChars( String s, int i) {
        return s.substring( s.length() - i, s.length());
    }

    private static String replaceFront( String front, String s) {
        return front + s.substring( front.length());
    }

    private static long getCurrentTimeMicros() {
        return System.currentTimeMillis() * 1000 + (counter.getAndIncrement() % 1000);
    }

}
