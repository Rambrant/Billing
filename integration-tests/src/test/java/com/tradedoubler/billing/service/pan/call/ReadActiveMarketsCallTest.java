package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.Market;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.transform.AxConverterService;
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
 * @since 2012-10-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class ReadActiveMarketsCallTest {
    @Autowired
    private DatabaseCallFactory databaseCallFactory;

    @Autowired
    private AxConverterService axConverterService;

    @Test
    public void readActiveMarketsShouldWork() throws BillingServiceException {
        ReadActiveMarketsCall call = databaseCallFactory.createCall(ReadActiveMarketsCall.class);
        List<Market> markets = call.fetchValues();
        assertThat(markets, notNullValue());
        assertThat(markets.size(), greaterThan(1));

        List<Integer> orgIds = new ArrayList<Integer>();
        for (Market market : markets) {
            orgIds.add(market.getOrganizationId());
        }
        assertThat(orgIds, hasItem(51));
    }

    @Test
    public void translateActiveMarketsShouldWork() throws BillingServiceException {
        ReadActiveMarketsCall call = databaseCallFactory.createCall(ReadActiveMarketsCall.class);
        List<Market> markets = call.fetchValues();

        for (Market market : markets) {
            System.out.printf("%s(%d), ", axConverterService.convert(market), market.getOrganizationId());
        }
        System.out.println();
    }

}
