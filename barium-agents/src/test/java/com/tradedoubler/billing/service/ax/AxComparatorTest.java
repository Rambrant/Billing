package com.tradedoubler.billing.service.ax;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.exception.AxValidationException;
import com.tradedoubler.billing.platform.flowcontroller.IntegrationMessage;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.transform.json.gson.GsonFactory;
import com.tradedoubler.testutil.FileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @author Thomas Rambrant (thore)
 */

@RunWith( SpringJUnit4ClassRunner.class)

@ContextConfiguration( locations = {
    "/spring/springPropertiesContext-barium.xml",
    "/spring/springBeansContext.xml",
    "/spring/springAutowireContext.xml",
    "/spring/springServicesContext.xml"})

public class AxComparatorTest
{
    @Autowired
    AxService axService;

    @Autowired
    private AxComparator comparator;

    @Test
    public void testValidateInvoicingRule() throws Exception
    {
        try
        {
            InvoicingRuleUpdated rule = GsonFactory.getGson().fromJson(
                FileUtil.readFileFromClasspath( "json-examples/invoicing-rule-updated-example.json"),
                InvoicingRuleUpdated.class);

            ServiceResult serviceResult = new ServiceResult();

            MetaData metaData = new MetaData(
                "UpdateInvoicingRule",
                new Guid( UUID.randomUUID().toString()),
                new Timestamp(),
                "1.0",
                "CRM");

            IntegrationMessage message = new IntegrationMessage( rule.getInvoicingRule().getInvoicingRuleId().toString(), metaData);

            message.setDomainObject( rule);

            serviceResult.setIntegrationMessage( message);

            axService.updateInvoicingRule( serviceResult);

            comparator.validateInvoicingRule( rule.getInvoicingRule());
        }
        catch( AxValidationException e)
        {
            printErrors( e );
            throw e;
        }
    }

    @Test
    public void testValidateClient() throws Exception
    {
        try
        {
            ClientUpdated client = GsonFactory.getGson().fromJson(
                FileUtil.readFileFromClasspath( "json-examples/client-updated-example.json"),
                ClientUpdated.class);

            ServiceResult serviceResult = new ServiceResult();

            MetaData metaData = new MetaData(
                "UpdateClient",
                new Guid( UUID.randomUUID().toString()),
                new Timestamp(),
                "1.0",
                "CRM");

            IntegrationMessage message = new IntegrationMessage( client.getClient().getClientId(), metaData);

            message.setDomainObject( client);

            serviceResult.setIntegrationMessage( message);

            axService.updateClient( serviceResult );

            comparator.validateClient( client.getClient() );

        }
        catch( AxValidationException e)
        {
            printErrors( e);
            throw e;
        }
    }

    @Test
    public void testValidateAgreement() throws Exception
    {
        try
        {
            AgreementUpdated agreement = GsonFactory.getGson().fromJson(
                FileUtil.readFileFromClasspath( "json-examples/agreement-updated-example.json"),
                AgreementUpdated.class);

            ServiceResult serviceResult = new ServiceResult();

            MetaData metaData = new MetaData(
                "UpdateAgreement",
                new Guid( UUID.randomUUID().toString()),
                new Timestamp(),
                "1.0",
                "CRM");

            IntegrationMessage message = new IntegrationMessage( agreement.getAgreement().getSourceSystemAgreementId(), metaData);

            message.setDomainObject( agreement);

            serviceResult.setIntegrationMessage( message);

            axService.updateAgreement( serviceResult );

            comparator.validateAgreement( agreement.getAgreement() );

        }
        catch( AxValidationException e)
        {
            printErrors( e);
            throw e;
        }
    }

    @Test
    public void testValidateMarketMessage() throws Exception
    {
        try
        {
            MarketMessageUpdated marketMessage = GsonFactory.getGson().fromJson(
                FileUtil.readFileFromClasspath( "json-examples/market-message-updated-example.json"),
                MarketMessageUpdated.class);

            ServiceResult serviceResult = new ServiceResult();

            MetaData metaData = new MetaData(
                "UpdateMarketMessage",
                new Guid( UUID.randomUUID().toString()),
                new Timestamp(),
                "1.0",
                "CRM");

            IntegrationMessage message = new IntegrationMessage( marketMessage.getInvoiceMessageRule().getInvoiceMessageRuleId().toString(), metaData);

            message.setDomainObject( marketMessage);

            serviceResult.setIntegrationMessage( message);

            axService.updateMarketMessage( serviceResult);

            comparator.validateMarketMessage( marketMessage.getInvoiceMessageRule());

        }
        catch( AxValidationException e)
        {
            printErrors( e);
            throw e;
        }
    }

    private void printErrors( AxValidationException e)
    {
        System.out.print( "\n" + e.getMessage() + "\n" );

        for( String message: e.getErrors())
        {
            System.out.print( "\t" + message + "\n" );
        }
    }
}
