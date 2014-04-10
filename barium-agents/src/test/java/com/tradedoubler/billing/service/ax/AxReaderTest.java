package com.tradedoubler.billing.service.ax;

import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdEntityCustTable;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgcustbank.AxdEntityCustBankAccount;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalescla.AxdEntityMDSSalesClientAgreement;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr.AxdEntityMDSSalesInvoiceRule;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes.AxdEntityMDSSalesInvoiceMessage;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.AxdEntityMDSSalesInvoiceRecipient;
import com.tradedoubler.billing.domain.Guid;
import com.tradedoubler.billing.domain.Market;
import com.tradedoubler.billing.util.AxDbConstantsUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Thomas Rambrant (thore)
 */

@RunWith( SpringJUnit4ClassRunner.class)

@ContextConfiguration( locations = {
    "/spring/springPropertiesContext-barium.xml",
    "/spring/springBeansContext.xml",
    "/spring/springAutowireContext.xml",
    "/spring/springServicesContext.xml"})

public class AxReaderTest
{
    @Autowired
    private AxReader axReader;

    @Test
    public void testGetAgreement() throws Exception
    {
        AxdEntityMDSSalesClientAgreement result = axReader.getAgreement(
            AxDbConstantsUtil.EXISTING_AGREEMENT_ID,
            new Market( 51));

        Assert.assertEquals(
            AxDbConstantsUtil.EXISTING_AGREEMENT_ID,
            result.getSourceSystemAgreementId());
    }

    @Test
    public void testGetClient() throws Exception
    {
        AxdEntityCustTable result = axReader.getClient(
            AxDbConstantsUtil.EXISTING_CLIENT_ACCOUNT_NUM,
            new Market( 51 ) );

        Assert.assertEquals(
            AxDbConstantsUtil.EXISTING_CLIENT_ACCOUNT_NUM,
            result.getAccountNum().getValue());
    }

    @Test
    public void testGetInvoicingRule() throws Exception
    {
        AxdEntityMDSSalesInvoiceRule result = axReader.getInvoicingRule(
            AxDbConstantsUtil.EXISTING_INVOICE_RULE_ID );

        Assert.assertEquals(
            new Guid( AxDbConstantsUtil.EXISTING_INVOICE_RULE_ID).getGuidForAx(),
            result.getInvoiceRuleId());
    }

    @Test
    public void testGetInvoiceRecipient() throws Exception
    {
        AxdEntityMDSSalesInvoiceRecipient result = axReader.getInvoiceRecipient(
            AxDbConstantsUtil.EXISTING_INVOICE_RECIPIENT_ID );

        Assert.assertEquals(
            new Guid( AxDbConstantsUtil.EXISTING_INVOICE_RECIPIENT_ID).getGuidForAx(),
            result.getInvoiceRecipientId());
    }

    @Test
    public void testGetInvoiceRecipientByInvoiceId() throws Exception
    {
        List< AxdEntityMDSSalesInvoiceRecipient> result = axReader.getInvoiceRecipientByInvoicingRuleId(
            AxDbConstantsUtil.EXISTING_INVOICE_RULE_ID );

        for( AxdEntityMDSSalesInvoiceRecipient recipient: result)
        {
            Assert.assertEquals(
                new Guid( AxDbConstantsUtil.EXISTING_INVOICE_RULE_ID).getGuidForAx(),
                recipient.getInvoiceRuleId().getValue());
        }
    }

    @Test
    public void testGetInvoiceMessageRule() throws Exception
    {
        AxdEntityMDSSalesInvoiceMessage result = axReader.getInvoiceMessageRule(
            AxDbConstantsUtil.EXISTING_INVOICE_MESSAGE_RULE_ID );

        Assert.assertEquals(
            new Guid( AxDbConstantsUtil.EXISTING_INVOICE_MESSAGE_RULE_ID).getGuidForAx(),
            result.getInvoiceMessageId());
    }

    @Test
    public void testGetMarketMessage() throws Exception
    {
        AxdEntityMDSSalesInvoiceMessage result = axReader.getMarketMessage(
            AxDbConstantsUtil.EXISTING_INVOICE_MESSAGE_RULE_MARKET_ID,
            new Market( 51));

        Assert.assertEquals(
            new Guid( AxDbConstantsUtil.EXISTING_INVOICE_MESSAGE_RULE_MARKET_ID).getGuidForAx(),
            result.getInvoiceMessageId());
    }

    @Test
    public void testGetBank()
    {
        AxdEntityCustBankAccount result = axReader.getBank(
            AxDbConstantsUtil.EXISTING_CLIENT_ACCOUNT_NUM,
            new Market( 51));

        Assert.assertEquals(
            AxDbConstantsUtil.EXISTING_CLIENT_ACCOUNT_NUM,
            result.getCustAccount());
    }
}
