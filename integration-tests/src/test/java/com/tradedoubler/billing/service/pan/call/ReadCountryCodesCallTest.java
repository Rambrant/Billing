package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.pan.handler.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author bjoek
 * @since 2012-10-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class ReadCountryCodesCallTest {
    @Autowired
    private ConverterValuesHandler converterValuesHandler;

    @Test
    public void readCountryCodesShouldWork() throws BillingServiceException {
        List<ConverterValue<String>> countryCodes = converterValuesHandler.getCountryCodes();
        assertThat(countryCodes, notNullValue());
        assertThat(countryCodes.size(), is(67));
        assertThat(countryCodes.get(0).axValue, is("ARE"));
    }

}
