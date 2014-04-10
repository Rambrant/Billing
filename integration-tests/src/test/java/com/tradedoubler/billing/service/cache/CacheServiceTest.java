package com.tradedoubler.billing.service.cache;

import com.tradedoubler.billing.domain.Market;
import com.tradedoubler.billing.service.BillingServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author bjoek
 * @since 2013-01-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class CacheServiceTest {
    @Autowired
    private CacheService cacheService;

    @Test
    public void readPaymentMethodsShouldWork() throws BillingServiceException {
        List<Market> markets = cacheService.getAllMarkets();
        assertThat(markets, notNullValue());
        assertThat(markets.size(), greaterThan(1));

        List<Integer> orgIds = new ArrayList<Integer>();
        for (Market market : markets) {
            orgIds.add(market.getOrganizationId());
        }
        assertThat(orgIds, hasItem(51));
    }
}
