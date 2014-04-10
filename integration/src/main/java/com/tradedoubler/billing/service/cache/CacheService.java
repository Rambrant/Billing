package com.tradedoubler.billing.service.cache;

import com.tradedoubler.billing.domain.Market;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.pan.call.DatabaseCallFactory;
import com.tradedoubler.billing.service.pan.call.ReadActiveMarketsCall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Contains values that are seldom changed, so they can be cached at system startup.
 *
 * @author bjoek
 * @since 2013-01-22
 */
@Component
public class CacheService {
    private final static Logger log = LoggerFactory.getLogger(CacheService.class);

    @Autowired
    private DatabaseCallFactory databaseCallFactory;

    private List<Market> markets = null;

    /** Returns all markets. This list is cached and unmodifiable */
    public synchronized List<Market> getAllMarkets() throws BillingServiceException {
        if (markets == null) {
            log.debug("Loading markets for the cache");
            markets = loadMarkets();
        }
        return markets;
    }

    private List<Market> loadMarkets() throws BillingServiceException {
        ReadActiveMarketsCall call = databaseCallFactory.createCall(ReadActiveMarketsCall.class);
        List<Market> markets = call.fetchValues();

        return Collections.unmodifiableList(markets);
    }

}
