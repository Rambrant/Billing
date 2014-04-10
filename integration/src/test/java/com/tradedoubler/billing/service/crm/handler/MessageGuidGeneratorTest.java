package com.tradedoubler.billing.service.crm.handler;

import com.tradedoubler.billing.domain.Guid;
import com.tradedoubler.billing.service.BillingServiceException;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author bjoek
 * @since 2013-03-06
 */
public class MessageGuidGeneratorTest {
    @Test
    public void generateForecastGuidShouldWork() throws BillingServiceException {
        Guid guid = new Guid("FF8481B0-B630-45F5-8F80-D602E0215DBF");
        String systemAgreementId = "0-123456789";

        Guid compositeGuid = new MessageGuidGenerator(guid).generateCompositeGuid(systemAgreementId);

        assertThat(compositeGuid.getGuid(), is("ff8481b0-b630-45f5-8f80-d60223456789"));
    }



    @Test
    public void generateShortForecastGuidShouldWork() throws BillingServiceException {
        Guid guid = new Guid("FF8481B0-B630-45F5-8F80-D602E0215DBF");
        String systemAgreementId = "0-123";

        Guid compositeGuid = new MessageGuidGenerator(guid).generateCompositeGuid(systemAgreementId);

        assertThat(compositeGuid.getGuid(), is("ff8481b0-b630-45f5-8f80-d60200000123"));
    }

    @Test
    public void generateShortestForecastGuidShouldWork() throws BillingServiceException {
        Guid guid = new Guid("FF8481B0-B630-45F5-8F80-D602E0215DBF");
        String systemAgreementId = "1-1";

        Guid compositeGuid = new MessageGuidGenerator(guid).generateCompositeGuid(systemAgreementId);

        assertThat(compositeGuid.getGuid(), is("ff8481b0-b630-45f5-8f80-d60200000001"));
    }
}
