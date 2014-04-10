package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.ConverterValue;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.pan.handler.ConverterValuesHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author bjoek
 * @since 2012-10-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class ReadAllMarketsCallTest {
    @Autowired
    private ConverterValuesHandler converterValuesHandler;

    @Test
    public void readPaymentMethodsShouldWork() throws BillingServiceException {
        List<ConverterValue<Integer>> paymentMethods = converterValuesHandler.getMarkets();
        assertThat(paymentMethods, notNullValue());
        assertThat(paymentMethods.size(), is(19));
        assertThat(paymentMethods.get(0).axValue, is("SE02"));
    }

}
