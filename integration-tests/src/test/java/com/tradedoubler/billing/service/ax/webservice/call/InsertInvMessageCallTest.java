package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes.AxdEntityMDSSalesInvoiceMessage;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.*;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.InvoiceMessageRuleHandler;
import com.tradedoubler.billing.util.AxDbConstantsUtil;
import org.joda.time.DateTime;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * User: erigu
 * Date: 2012-09-10
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class InsertInvMessageCallTest {

    @Autowired
    InvoiceMessageRuleHandler invoiceMessageRuleHandler;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void insertNewForClientShouldWork() throws BillingServiceException {
        String id = AxDbConstantsUtil.generateInvoiceMessageRuleId();
        char[] textArr = new char[200];
        Arrays.fill(textArr, 't');
        String text = new String(textArr);
        ClientMessageRule invoiceMessage = new ClientMessageRule(id, AxDbConstantsUtil.EXISTING_CLIENT_ACCOUNT_NUM,
                text, new Timestamp(new DateTime().minusDays(30)), new Timestamp());

        System.out.println("InvoiceMessageId: " + id);

        invoiceMessageRuleHandler.insertInvoiceMessageRule(invoiceMessage, new Market(51));

        verifyInvoiceMessageInAx(new Guid(id), invoiceMessage);
    }

    @Test
    public void insertNewForMarketShouldWork() throws BillingServiceException {
        String id = AxDbConstantsUtil.generateInvoiceMessageRuleId();
        InvoiceIssuerMessageRule invoiceMessage = new InvoiceIssuerMessageRule(id, 51,
                "text", new Timestamp(new DateTime().minusDays(30)), new Timestamp());

        System.out.println("InvoiceMessageId: " + id);

        invoiceMessageRuleHandler.insertInvoiceMessageRule(invoiceMessage, new Market(51));

        verifyInvoiceMessageInAx(new Guid(id), invoiceMessage);
    }

    private void verifyInvoiceMessageInAx(Guid id, InvoiceMessageRule expected) throws BillingServiceException {
        FindInvoiceMessageRuleCall findInvoiceMessageRuleCall = invoiceMessageRuleHandler.findInvoiceMessageRuleByPk(id, new Market(51));

        collector.checkThat(findInvoiceMessageRuleCall.getNumberOfInvoiceMessageRules(), is(1));

        AxdEntityMDSSalesInvoiceMessage axdEntityMDSSalesInvoiceMessage = findInvoiceMessageRuleCall.getInvoiceMessageList().get(0);
        //collector.checkThat(axdEntityMDSSalesInvoiceMessage.getRefRecId(), is(expected.getClientId()));
        collector.checkThat(axdEntityMDSSalesInvoiceMessage.getText(), is(expected.getMessageText()));
        //collector.checkThat(axdEntityMDSSalesInvoiceMessage.getInvoiceMessageId(), is(expected.getParentPrimaryKeyForAx(null)));
        collector.checkThat(axdEntityMDSSalesInvoiceMessage.getSourceType(), is(expected.getSourceType()));
        collector.checkThat(axdEntityMDSSalesInvoiceMessage.getInvoiceMessageId(), is(expected.getInvoiceMessageRuleId().getGuidForAx()));
        collector.checkThat(axdEntityMDSSalesInvoiceMessage.getValidFrom().toString(), is(expected.getValidFrom().toString().substring(0, 10)));
        collector.checkThat(axdEntityMDSSalesInvoiceMessage.getValidTo().toString(), is(expected.getValidTo().toString().substring(0, 10)));
    }

    @Test
    public void insertAlreadyExistsShouldNotWork() throws BillingServiceException {
        ClientMessageRule invoiceMessage = new ClientMessageRule(AxDbConstantsUtil.EXISTING_INVOICE_MESSAGE_RULE_CLIENT_ID, AxDbConstantsUtil.EXISTING_CLIENT_ACCOUNT_NUM, "text", new Timestamp(), new Timestamp());

        try {
            invoiceMessageRuleHandler.insertInvoiceMessageRule(invoiceMessage, new Market(51));
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), startsWith("InvoiceMessageRule"));
            assertThat(bsex.getMessage(), endsWith("The record already exists."));
            assertThat(bsex.getCategory(), is(ServiceResultCategory.INTEGRATION_DISTURBANCE));
        }
    }

}
