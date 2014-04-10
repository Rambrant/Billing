package com.tradedoubler.billing.property;


import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Thomas Rambrant (thore)
 */

public class BillingIntegrationProperties extends Properties
{
    public BillingIntegrationProperties()
    {
        try
        {
            this.load( new ClassPathResource( "billing-integration-barium.properties").getInputStream());
        }
        catch( IOException e)
        {
            throw new RuntimeException( "Failed to load settings from billing-integration-barium.properties");
        }
    }

    public Integer getIntegerProperty( String key)
    {
        return Integer.valueOf( this.getProperty( key));
    }

    public Integer getAzureVisibilityTimeoutSec()
    {
        return getIntegerProperty( "AZURE_DEFAULT_VISIBILITY_TIMEOUT_SECONDS");
    }

    public Integer getAzureRequestTimeoutMs()
    {
        return getIntegerProperty( "AZURE_DEFAULT_SERVICE_REQUEST_TIMEOUT_MS");
    }

    public String getAzureAccountName()
    {
        return getProperty( "AZURE_CRM_ACCOUNT_NAME");
    }

    public String getAzureAccountKey()
    {
        return getProperty( "AZURE_CRM_ACCOUNT_KEY");
    }

    public String getAzureQueueCommunicationProtocol()
    {
        return getProperty( "AZURE_QUEUE_COMMUNICATION_PROTOCOL");
    }

    public String getAgreementUpdatedQueueName()
    {
        return getProperty( "AZURE_QUEUE_AGREEMENT_UPDATED");
    }

    public String getClientUpdatedQueueName()
    {
        return getProperty( "AZURE_QUEUE_CLIENT_UPDATED");
    }

    public String getInvoicingCreatedQueueName()
    {
        return getProperty( "AZURE_QUEUE_INVOICING_CREATED");
    }

    public String getInvoicingUpdatedQueueName()
    {
        return getProperty( "AZURE_QUEUE_INVOICING_UPDATED");
    }

    public String getRecipientDeletedQueueName()
    {
        return getProperty( "AZURE_QUEUE_INVOICE_RECIPIENT_DELETED");
    }

    public String getSplittingRuleDeletedQueueName()
    {
        return getProperty( "AZURE_QUEUE_SPLITTING_RULE_DELETED");
    }

    public String getMarketMessageUpdatedQueueName()
    {
        return getProperty( "AZURE_QUEUE_MARKET_MESSAGE_UPDATED");
    }

    public String getUpdateForecastQueueName()
    {
        return getProperty( "AZURE_QUEUE_UPDATE_FORECAST");
    }
}
