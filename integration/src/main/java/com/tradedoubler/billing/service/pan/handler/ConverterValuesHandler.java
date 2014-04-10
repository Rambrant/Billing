package com.tradedoubler.billing.service.pan.handler;

import com.tradedoubler.billing.domain.ConverterValue;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.pan.call.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Contains convenience methods to fetch conversion constants values from Pan database.
 *
 * @author bjoek
 * @since 2012-09-26
 */
@Component
public class ConverterValuesHandler {
    private final static Logger log = LoggerFactory.getLogger(ConverterValuesHandler.class);

    @Autowired
    private DatabaseCallFactory databaseCallFactory;

    /** Fetch country code constants */
    public List<ConverterValue<String>> getCountryCodes() throws BillingServiceException {
        ReadCountryCodesCall call = databaseCallFactory.createCall(ReadCountryCodesCall.class);

        log.debug("Fetching country codes from pan database");

        try {
            return call.fetchValues();
        } catch (RuntimeException rex) {
            throw BillingServiceException.createBugDisturbance("Could not read country code converter values from Pan database : " +
                    rex.getMessage());
        }
    }

    /** Fetch market (data area) constants */
    public List<ConverterValue<Integer>> getMarkets() throws BillingServiceException {
        ReadAllMarketsCall call = databaseCallFactory.createCall(ReadAllMarketsCall.class);

        log.debug("Fetching markets from pan database");

        try {
            return call.fetchValues();
        } catch (RuntimeException rex) {
            throw BillingServiceException.createBugDisturbance("Could not read market converter values from Pan database : " +
                    rex.getMessage());
        }
    }

    /** Fetch payment method constants. Payment methods examples: Direct debit, Bank transfer etc. */
    public List<ConverterValue<Integer>> getPaymentMethods() throws BillingServiceException {
        ReadPaymentMethodsCall call = databaseCallFactory.createCall(ReadPaymentMethodsCall.class);

        log.debug("Fetching payment methods from pan database");

        try {
            return call.fetchValues();
        } catch (RuntimeException rex) {
            throw BillingServiceException.createBugDisturbance("Could not read payment methods values from Pan database : " +
                    rex.getMessage());
        }
    }

    /** Fetch posting profile constants. Posting profiles examples: 'Reminder', 'Reminder and Interest' etc. */
    public List<ConverterValue<Integer>> getPostingProfiles() throws BillingServiceException {
        ReadPostingProfilesCall call = databaseCallFactory.createCall(ReadPostingProfilesCall.class);

        log.debug("Fetching posting profiles from pan database");

        try {
            return call.fetchValues();
        } catch (RuntimeException rex) {
            throw BillingServiceException.createBugDisturbance("Could not read posting profiles values from Pan database : " +
                    rex.getMessage());
        }
    }

    /** Fetch distribution mode constants. Distribution modes examples: by Email, by Post etc. */
    public List<ConverterValue<Integer>> getDistributionModes() throws BillingServiceException {
        ReadDistributionModesCall call = databaseCallFactory.createCall(ReadDistributionModesCall.class);

        log.debug("Fetching distribution modes from pan database");

        try {
            return call.fetchValues();
        } catch (RuntimeException rex) {
            throw BillingServiceException.createBugDisturbance("Could not read distribution modes values from Pan database : " +
                    rex.getMessage());
        }
    }
}
