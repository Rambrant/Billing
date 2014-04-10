package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr.*;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.*;
import com.tradedoubler.billing.domain.InvoicingRule;
import com.tradedoubler.billing.service.*;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.InvoicingRuleHandler;
import com.tradedoubler.billing.util.AxDbConstantsUtil;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static com.tradedoubler.billing.service.ax.webservice.call.WebServiceCallTestUtil.*;
import static com.tradedoubler.billing.util.AxDbConstantsUtil.EXISTING_CLIENT_ACCOUNT_NUM;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author bjoek
 * @since 2012-07-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class InsertInvoicingRuleCallTest {
    private static final String INV_RULE_MESSAGE_ID1 = "00000000-0000-0000-3000-200000000001";

    @Autowired
    private InvoicingRuleHandler invoicingRuleHandler;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void createNewShouldWork() throws BillingServiceException {
        String id = AxDbConstantsUtil.generateInvoiceRuleId();

        InvoicingRule invoiceRule = createInvoicingRule(id, AxDbConstantsUtil.EXISTING_CLIENT_ACCOUNT_NUM, 51);
        invoicingRuleHandler.insertInvoicingRule(invoiceRule);

        verifyInvoicingRuleInAx(invoiceRule);
    }

    private void verifyInvoicingRuleInAx(InvoicingRule expected) throws BillingServiceException {
        FindInvoicingRuleCall findInvoicingRuleCall = invoicingRuleHandler.findInvoicingRuleByPk(expected.getInvoicingRuleId(),
                expected.getMarketId());

        collector.checkThat(findInvoicingRuleCall.getNumberOfInvoicingRules(), is(1));

        AxdEntityMDSSalesInvoiceRule invoiceRule = findInvoicingRuleCall.getInvoiceRule();
        collector.checkThat(invoiceRule.getInvoiceRuleId(), is(expected.getInvoicingRuleId().getGuidForAx()));
        collector.checkThat(invoiceRule.getName(), is(expected.getInvoicingRuleName()));
        collector.checkThat(invoiceRule.getDescription().getValue(), is(expected.getDescription()));
        collector.checkThat(invoiceRule.getCurrencyCode(), is(expected.getCurrencyCode().getCurrencyCode()));
        collector.checkThat(invoiceRule.getIssuerReference().getValue(), is(expected.getIssuerReference()));
        collector.checkThat(invoiceRule.getCustomerReference().getValue(), is(expected.getClientReference()));
        collector.checkThat(invoiceRule.getDisplayTDComission(), is(AxdExtTypeMDSSalesInvoiceRuleDisplayTDComission.YES));
        collector.checkThat(invoiceRule.getDistributionMode(), is(AxdEnumMDSSalesInvoiceRuleDistributionMode.MAIL));
        collector.checkThat(invoiceRule.getPaymTermId(), is("30"));
        collector.checkThat(invoiceRule.getPaymModeId().getValue(), is("BANK"));
        collector.checkThat(invoiceRule.getPostingProfile(), is("SO_1"));
        collector.checkThat(invoiceRule.getRevenueTypeId(), is("1"));
        collector.checkThat(invoiceRule.getBelongsToDataAreaId().getValue(), is("SE02"));
        collector.checkThat(invoiceRule.getDeviatingExchRate(), is(AxdExtTypeMDSSalesInvoiceRuleDeviatingExchRate.YES));

        List<AxdEntityMDSSalesInvoiceMessage> invoiceMessages = invoiceRule.getMDSSalesInvoiceMessage();
        collector.checkThat(invoiceMessages.size(), is(4));
        collector.checkThat(invoiceMessages.get(0).getInvoiceMessageId(), is(expected.getInvoiceMessageRules().get(0).getInvoiceMessageRuleId().getGuidForAx()));
        collector.checkThat(invoiceMessages.get(0).getSourceType(), is(AxdEnumMDSSalesMessageSourceType.INVOICE_RULE));
        collector.checkThat(invoiceMessages.get(0).getText(), is(expected.getInvoiceMessageRules().get(0).getMessageText()));
        collector.checkThat(invoiceMessages.get(0).getValidFrom().toString(), is(expected.getInvoiceMessageRules().get(0).getValidFrom().toString().substring(0, 10)));
        collector.checkThat(invoiceMessages.get(0).getValidTo().toString(), is(expected.getInvoiceMessageRules().get(0).getValidTo().toString().substring(0, 10)));

        collector.checkThat(invoiceMessages.get(2).getInvoiceMessageId(), is(expected.getPurchaseOrders().get(0).getPurchaseOrderId().getGuidForAx()));
        collector.checkThat(invoiceMessages.get(2).getSourceType(), is(AxdEnumMDSSalesMessageSourceType.INVOICE_RULE_PURCHASE_ORDER));
        collector.checkThat(invoiceMessages.get(2).getText(), is(expected.getPurchaseOrders().get(0).getPoNumber()));
        collector.checkThat(invoiceMessages.get(2).getValidFrom().toString(), is(expected.getPurchaseOrders().get(0).getValidFrom().toString().substring(0, 10)));
        collector.checkThat(invoiceMessages.get(2).getValidTo().toString(), is(expected.getPurchaseOrders().get(0).getValidTo().toString().substring(0, 10)));
    }

    @Test
    public void createNewWithDuplicateMessagesShouldNotWork() throws BillingServiceException {
        String id = AxDbConstantsUtil.generateInvoiceRuleId();
        System.out.println("InvoiceRuleId: " + id);

        InvoicingRule invoiceRule = createInvoicingRule(id, createMessages(id, INV_RULE_MESSAGE_ID1, INV_RULE_MESSAGE_ID1),
                EXISTING_CLIENT_ACCOUNT_NUM, 51);
        try {
            invoicingRuleHandler.insertInvoicingRule(invoiceRule);
            fail();
        } catch (BillingServiceException bsex) {
            // This is normal, the message ids are duplicated
            assertThat(bsex.getMessage(), containsString("Cannot create a record in Sales Invoice Message (MDS_SalesInvoiceMessage)"));
        }

        FindInvoicingRuleCall findInvoicingRuleCall = invoicingRuleHandler.findInvoicingRuleByPk(invoiceRule.getInvoicingRuleId(), invoiceRule.getMarketId());
        assertThat(findInvoicingRuleCall.getNumberOfInvoicingRules(), is(0));
    }

    @Test
    public void createZeroGuidShouldNotWork() throws BillingServiceException {
        String id = "{00000000-0000-0000-0000-000000000000}";

        InvoicingRule invoiceRule = createInvoicingRule(id, AxDbConstantsUtil.EXISTING_CLIENT_ACCOUNT_NUM, 51);
        try {
            invoicingRuleHandler.insertInvoicingRule(invoiceRule);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), startsWith("InvoicingRule PK: {{00000000-0000-0000-0000-000000000000}}, dataAreaId: SE02  , Uncorrect value according to schema"));
        }
    }

    @Test
    public void createExistingShouldNotWork() throws BillingServiceException {
        InvoicingRule invoiceRule = createInvoicingRule(AxDbConstantsUtil.EXISTING_INVOICE_RULE_ID,
                AxDbConstantsUtil.EXISTING_CLIENT_ACCOUNT_NUM, 51);
        try {
            invoicingRuleHandler.insertInvoicingRule(invoiceRule);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), startsWith("InvoicingRule"));
            assertThat(bsex.getMessage(), endsWith("The record already exists."));
            assertThat(bsex.getCategory(), is(ServiceResultCategory.INTEGRATION_DISTURBANCE));
        }
    }


}
