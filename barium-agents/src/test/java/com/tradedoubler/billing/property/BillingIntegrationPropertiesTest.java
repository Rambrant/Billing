package com.tradedoubler.billing.property;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Thomas Rambrant (thore)
 */
public class BillingIntegrationPropertiesTest
{
    private BillingIntegrationProperties properties;

    @Before
    public void setUp() throws Exception
    {
        properties = new BillingIntegrationProperties();
    }

    @Test
    public void testAzureProperties() throws Exception
    {
        Assert.assertTrue( properties.getAzureVisibilityTimeoutSec() > 0);
        Assert.assertTrue( properties.getAzureRequestTimeoutMs() > 0);
        Assert.assertTrue( properties.getAzureAccountName().length() > 0);
        Assert.assertTrue( properties.getAzureAccountKey().length() > 0);

        Assert.assertTrue( properties.getAgreementUpdatedQueueName().contains( "barium"));
        Assert.assertTrue( properties.getClientUpdatedQueueName().contains( "barium"));
        Assert.assertTrue( properties.getInvoicingCreatedQueueName().contains( "barium"));
        Assert.assertTrue( properties.getInvoicingUpdatedQueueName().contains( "barium"));
        Assert.assertTrue( properties.getRecipientDeletedQueueName().contains( "barium"));
        Assert.assertTrue( properties.getSplittingRuleDeletedQueueName().contains( "barium"));
        Assert.assertTrue( properties.getMarketMessageUpdatedQueueName().contains( "barium"));
        Assert.assertTrue( properties.getUpdateForecastQueueName().contains( "barium"));
    }
}
