package com.tradedoubler.billing.service.transform;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.domain.Currency;
import com.tradedoubler.billing.platform.logging.LogError;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.pan.handler.ConverterValuesHandler;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Service implementation for conversion methods for constants between Ax, Pan and Crm. The conversion service can be
 * disabled by the property SKIP_CONVERTER_SERVICE=true. A disabled conversion service uses hard coded conversion
 * values (as we know them 2012-12-01). The conversion values are only fetched during startup, to load new values
 * a restart of the system is needed.
 *
 * @author bjoek
 * @since 2012-10-29
 */
@Component
public class AxConverterServiceImpl implements AxConverterService {
    private final static Logger log = LoggerFactory.getLogger(AxConverterServiceImpl.class);

    @Autowired
    private ConverterValuesHandler converterValuesHandler;

    private AxConverterDefaultDbValues defaultDbValues = new AxConverterDefaultDbValues();

    @Value("${SKIP_CONVERTER_SERVICE}")
    private boolean skipConverterService;

    private final Map<String, ConverterValue<String>> countryCodeMappedByCrmValue = new LinkedHashMap<String, ConverterValue<String>>();
    private final Map<Integer, ConverterValue<Integer>> marketsMappedByCrmValue = new LinkedHashMap<Integer, ConverterValue<Integer>>();
    private final Map<String, ConverterValue<Integer>> marketsMappedByAxValue = new LinkedHashMap<String, ConverterValue<Integer>>();
    private final Map<Integer, ConverterValue<Integer>> paymentMethodMappedByCrmValue = new LinkedHashMap<Integer, ConverterValue<Integer>>();
    private final Map<Integer, ConverterValue<Integer>> postingProfileMappedByCrmValue = new LinkedHashMap<Integer, ConverterValue<Integer>>();
    private final Map<Integer, ConverterValue<Integer>> distributionModesMappedByCrmValue = new LinkedHashMap<Integer, ConverterValue<Integer>>();

    /** For test only */
    public static AxConverterService createNonDatabaseInstanceForTest() {
        AxConverterServiceImpl converterService = new AxConverterServiceImpl();

        // No database interactions
        converterService.converterValuesHandler = null;
        converterService.skipConverterService = true;

        converterService.defaultDbValues = new AxConverterDefaultDbValues();

        try {
            converterService.setup();
        } catch (BillingServiceException e) {
            // Just wrap the exception, this is going to be used for test code only
            throw new RuntimeException(e);
        }

        return converterService;
    }

    /** Load values during startup */
    @PostConstruct
    private void setup() throws BillingServiceException {
        if (skipConverterService) {
            log.warn(LogError.PLATFORM.name() + " - BE AWARE: The ConverterService will use hardcoded default values instead of database values. Should never be inactive in Production.");
        }

        loadCountryCodes();
        loadMarkets();
        loadPaymentMethods();
        loadPostingProfiles();
        loadDistributionModes();
    }

    /** Converts address types to Ax constants. This is static information and should not change (very often) */
    @Override
    public String convert(AddressType addressType) throws BillingServiceException {
        switch (addressType.getValue()) {
            case 3:
                return "Business";
            case 1:
                return "Invoice";
        }
        throw BillingServiceException.createBugDisturbance("The address type value " + addressType.getValue() +
                " was not found among the converter values");
    }

    /** Converts country codes from Crm to Ax values. The information is fetched from Pan database. */
    @Override
    public String convert(Country countryCode) throws BillingServiceException {
        ConverterValue returnValue = countryCodeMappedByCrmValue.get(countryCode.getValue());
        if (returnValue != null) {
            return returnValue.axValue;
        }
        throw BillingServiceException.createBugDisturbance("The country value " + countryCode.getValue() +
                " was not found among the converter values");
    }

    /** Converts currency codes to Ax constants. This is static information and should not change (very often) */
    @Override
    public String convert(Currency currencyCode) {
        if (currencyCode.getCurrencyCode().equalsIgnoreCase("CFP")) {
            return "XPF";
        }
        return currencyCode.getCurrencyCode();
    }

    /** Converts address types to Ax constants. This is static information and should not change (very often) */
    @Override
    public String convert(Language invoiceLanguage) {
        String languageCode = invoiceLanguage.getLanguageCode();
        if (languageCode.equalsIgnoreCase("no")) {
            return "nb-no";
        }
        if (languageCode.equalsIgnoreCase("en")) {
            return "en-US";
        }
        return languageCode;
    }

    /** Converts organization ids from Crm to Ax market values. The information is fetched from Pan database. */
    @Override
    public String convert(Market marketId) throws BillingServiceException {
        ConverterValue returnValue = marketsMappedByCrmValue.get(marketId.getOrganizationId());
        if (returnValue != null) {
            return returnValue.axValue;
        }
        throw BillingServiceException.createBugDisturbance("The organization number " + marketId.getOrganizationId() +
                " could not be converted to a market, it was not found among the converter values");
    }

    /** Converts payment methods from Crm to Ax values. The information is fetched from Pan database. */
    @Override
    public String convert(PaymentMethod paymentMethod) throws BillingServiceException {
        ConverterValue returnValue = paymentMethodMappedByCrmValue.get(paymentMethod.getValue());
        if (returnValue != null) {
            return returnValue.axValue;
        }
        throw BillingServiceException.createBugDisturbance("The payment method value " + paymentMethod.getValue() +
                " was not found among the converter values");
    }

    /** Converts product types to Ax constants. This is static information and should not change (very often) */
    @Override
    public String convert(ProductType productType) {
        return "" + productType.getValue();
    }

    /** Converts terms of payment to Ax constants. This is static information and should not change (very often) */
    @Override
    public String convert(TermsOfPayment termsOfPayment) {
        return "" + termsOfPayment.getDays();
    }

    /** Converts payment methods from Crm to Ax values. The information is fetched from Pan database. */
    @Override
    public String convert(PostingProfile postingProfile) throws BillingServiceException {
        ConverterValue returnValue = postingProfileMappedByCrmValue.get(postingProfile.getValue());
        if (returnValue != null) {
            return returnValue.axValue;
        }
        throw BillingServiceException.createBugDisturbance("The posting profile value " + postingProfile.getValue() +
                " was not found among the converter values");
    }

    /** Converts distribution modes from Crm to Ax values. The information is fetched from Pan database. */
    @Override
    public String convert(DistributionMode distributionMode) throws BillingServiceException {
        ConverterValue returnValue = distributionModesMappedByCrmValue.get(distributionMode.getValue());
        if (returnValue != null) {
            return returnValue.axValue;
        }
        throw BillingServiceException.createBugDisturbance("The distribution mode value " + distributionMode.getValue() +
                " was not found among the converter values");
    }

    /** Converts revenue types to Ax constants. This is static information and should not change (very often) */
    @Override
    public String convert(RevenueType revenueType) {
        return revenueType.getValue() + "";
    }

    /** Converts data area id from Ax to market values. The information is fetched from Pan database. */
    @Override
    public Market convertMarket(String dataAreaID) throws BillingServiceException {
        ConverterValue<Integer> returnValue = marketsMappedByAxValue.get(dataAreaID.toUpperCase());
        if (returnValue != null) {
            return new Market(returnValue.crmValue);
        }
        throw BillingServiceException.createBugDisturbance("The market value " + dataAreaID +
                " could not be converted to an organization number, it was not found among the converter values");
    }

    private void loadCountryCodes() throws BillingServiceException {
        List<ConverterValue<String>> values;
        if (skipConverterService) {
            values = defaultDbValues.getCountryCodes();
        } else {
            values = converterValuesHandler.getCountryCodes();
        }

        countryCodeMappedByCrmValue.putAll(createMappedByCrmValue(values));
    }

    private void loadMarkets() throws BillingServiceException {
        List<ConverterValue<Integer>> values;
        if (skipConverterService) {
            values = defaultDbValues.getMarkets();
        } else {
            values = converterValuesHandler.getMarkets();
        }

        marketsMappedByCrmValue.putAll(createMappedByCrmValue(values));
        marketsMappedByAxValue.putAll(createMappedByAxValue(values));
    }

    private void loadPaymentMethods() throws BillingServiceException {
        List<ConverterValue<Integer>> values;
        if (skipConverterService) {
            values = defaultDbValues.getPaymentMethods();
        } else {
            values = converterValuesHandler.getPaymentMethods();
        }

        paymentMethodMappedByCrmValue.putAll(createMappedByCrmValue(values));
    }

    private void loadPostingProfiles() throws BillingServiceException {
        List<ConverterValue<Integer>> values;
        if (skipConverterService) {
            values = defaultDbValues.getPostingProfiles();
        } else {
            values = converterValuesHandler.getPostingProfiles();
        }

        postingProfileMappedByCrmValue.putAll(createMappedByCrmValue(values));
    }

    private void loadDistributionModes() throws BillingServiceException {
        List<ConverterValue<Integer>> values;
        if (skipConverterService) {
            values = defaultDbValues.getDistributionModes();
        } else {
            values = converterValuesHandler.getDistributionModes();
        }

        distributionModesMappedByCrmValue.putAll(createMappedByCrmValue(values));
    }

    private <T> Map<T, ConverterValue<T>> createMappedByCrmValue(List<ConverterValue<T>> values) {
        Map<T, ConverterValue<T>> returnValue = new LinkedHashMap<T, ConverterValue<T>>();
        for (ConverterValue<T> converterValue : values) {
            returnValue.put(converterValue.crmValue, converterValue);
        }
        return returnValue;
    }

    private <T> Map<String, ConverterValue<T>> createMappedByAxValue(List<ConverterValue<T>> values) {
        Map<String, ConverterValue<T>> returnValue = new LinkedHashMap<String, ConverterValue<T>>();
        for (ConverterValue<T> converterValue : values) {
            returnValue.put(converterValue.axValue, converterValue);
        }
        return returnValue;
    }

}
