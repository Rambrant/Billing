package com.tradedoubler.billing.transform.json.gson;

import com.google.gson.*;
import com.tradedoubler.billing.domain.*;
import org.slf4j.*;

/**
 * Creates a gson object that will use special handling for our custom types.
 * <p/>
 * This is how the Json is read and written if the serializers are used
 * {
 * "clientId" : "18811826",
 * "marketId" : 51,
 * "invoicingRuleId" : "3f2504e0-4f89-11d3-9a0c-0305e82c3401",
 * "invoicingRuleName" : "Invoice Message Rule Example Name",
 * "description" : "Example description",
 * "issuerReference" : "Max Revenue",
 * "clientReference" : "John Doe",
 * "currencyCode" : "SEK",
 * "distributionMode" : 1,
 * "termsOfPayment" : 30,
 * "postingProfile" : 1,
 * "displayTDcommission" : true,
 * "revenueType" : 1,
 * "paymentMethod" : 1,
 * "deviatingExchangeRate" : false,
 * "invoiceRecipients" : [],
 * "purchaseOrders" : [],
 * "invoiceMessageRules" : [],
 * "sourceSystemAgreementIds" : ["1-888111"],
 * }
 * This would be the output without the serializers (would break json validation).
 * {
 * "clientId" : "18811826",
 * "marketId" : { "organizationId" : 51 },
 * "invoicingRuleId" : { "guid" : "3f2504e0-4f89-11d3-9a0c-0305e82c3401" },
 * "invoicingRuleName" : "Invoice Message Rule Example Name",
 * "description" : "Example description",
 * "issuerReference" : "Max Revenue",
 * "clientReference" : "John Doe",
 * "currencyCode" : { "currencyCode" : "SEK" },
 * "distributionMode" : { "value" : 1 },
 * "termsOfPayment" : { "value" : 30 },
 * "postingProfile" : { "value" : 1 },
 * "displayTDcommission" : true,
 * "revenueType" : { "value" : 1 },
 * "paymentMethod" : { "value" : 1 },
 * "deviatingExchangeRate" : false,
 * "invoiceRecipients" : [],
 * "purchaseOrders" : [],
 * "invoiceMessageRules" : [],
 * "sourceSystemAgreementIds" : ["1-888111"],
 * }
 *
 * @since 2012-06-25
 */
public class GsonFactory {

    private final static Logger log = LoggerFactory.getLogger(GsonFactory.class);

    private static final Gson gson = createInstance();

    private static Gson createInstance() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        // Make sure that null is explicitly written to json (normal behaviour is silent removal)
        gsonBuilder.serializeNulls();

        // Hides internal representations (see example above)
        gsonBuilder.registerTypeAdapter(AddressType.class, new AddressTypeSerializer());
        gsonBuilder.registerTypeAdapter(Country.class, new CountrySerializer());
        gsonBuilder.registerTypeAdapter(Currency.class, new CurrencySerializer());
        gsonBuilder.registerTypeAdapter(DistributionMode.class, new DistributionModeSerializer());
        gsonBuilder.registerTypeAdapter(Guid.class, new GuidSerializer());
        gsonBuilder.registerTypeAdapter(Language.class, new LanguageSerializer());
        gsonBuilder.registerTypeAdapter(Market.class, new MarketSerializer());
        gsonBuilder.registerTypeAdapter(PaymentMethod.class, new PaymentMethodSerializer());
        gsonBuilder.registerTypeAdapter(PostingProfile.class, new PostingProfileSerializer());
        gsonBuilder.registerTypeAdapter(ProductType.class, new ProductTypeSerializer());
        gsonBuilder.registerTypeAdapter(RevenueType.class, new RevenueTypeSerializer());
        gsonBuilder.registerTypeAdapter(ClientType.class, new ClientTypeSerializer());
        gsonBuilder.registerTypeAdapter(TermsOfPayment.class, new TermsOfPaymentSerializer());
        gsonBuilder.registerTypeAdapter(Timestamp.class, new TimestampSerializer());
        gsonBuilder.registerTypeAdapter(Money.class, new MoneySerializer());
        gsonBuilder.registerTypeAdapter(Event.class, new EventSerializer());

        // Creates custom json for invoice
        gsonBuilder.registerTypeAdapter(Invoice.class, new InvoiceSerializer());

        //Invoice message rules are devided into three distinct domain objects
        gsonBuilder.registerTypeHierarchyAdapter(InvoiceMessageRule.class, new InvoiceMessageRuleSerializer());

        gsonBuilder = gsonBuilder.setPrettyPrinting();
        Gson gsonInstance = gsonBuilder.create();
        log.info("Created Gson instance");

        return gsonInstance;
    }

    public static Gson getGson() {
        return gson;
    }
}
