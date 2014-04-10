package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.*;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumNoYesCombo;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.*;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.InvoiceRecipientHandler;
import com.tradedoubler.billing.util.AxDbConstantsUtil;
import org.hamcrest.Matchers;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

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
public class InsertInvoiceRecipientCallTest {

    @Autowired
    private InvoiceRecipientHandler invoiceRecipientHandler;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void createNewWithNoSplittersShouldWork() throws BillingServiceException {
        String invoiceRecipientId = AxDbConstantsUtil.generateInvoiceRecipientId();

        System.out.println("invoiceRecipientId: " + invoiceRecipientId);
        InvoiceRecipient invoiceRecipient = createInvoiceRecipient(invoiceRecipientId, createSplittingRules(invoiceRecipientId));
        Market market = new Market(51);
        invoiceRecipientHandler.insertInvoiceRecipient(invoiceRecipient, market);

        verifyInvoiceRecipientInAx(invoiceRecipient);
    }

    private void verifyInvoiceRecipientInAx(InvoiceRecipient expected) throws BillingServiceException {
        FindInvoiceRecipientCall findInvoiceRecipientCall = invoiceRecipientHandler.findInvoiceRecipientByPk(expected.getInvoiceRecipientId(), new Market(51));

        collector.checkThat(findInvoiceRecipientCall.getNumberOfInvoiceRecipient(), Matchers.is(1));

        AxdEntityMDSSalesInvoiceRecipient invoiceRecipient = findInvoiceRecipientCall.getInvoiceRecipient();
        collector.checkThat(invoiceRecipient.getInvoiceRecipientId(), is(expected.getInvoiceRecipientId().getGuidForAx()));
        collector.checkThat(invoiceRecipient.getAttentionRow1().getValue(), is(expected.getAttentionRow1()));
        collector.checkThat(invoiceRecipient.getAttentionRow2().getValue(), is(expected.getAttentionRow2()));
        collector.checkThat(invoiceRecipient.getEmail().getValue(), is(expected.getEmailAddress()));
        collector.checkThat(invoiceRecipient.getDefaultRecipient(), is(AxdEnumNoYesCombo.YES));

        AxdEntityLogisticsPostalAddress postalAddress = invoiceRecipient.getLogisticsLocation().get(0).getLogisticsPostalAddress().get(0);
        collector.checkThat(postalAddress.getCity().getValue(), is(expected.getRegisteredAddress().getCity()));
        collector.checkThat(postalAddress.getBuildingCompliment().getValue(), is(expected.getRegisteredAddress().getCounty()));
        collector.checkThat(replaceNewLine(postalAddress.getStreet().getValue(), ":"), is(expected.getRegisteredAddress().getLine1() + ":" +
                expected.getRegisteredAddress().getLine2()));
        collector.checkThat(postalAddress.getZipCode().getValue(), is(expected.getRegisteredAddress().getPostalCode()));
        collector.checkThat(postalAddress.getCountryRegionId(), is("SWE"));

        List<AxdEntityMDSSalesSplitter> splitters = findInvoiceRecipientCall.getSplitters();
        collector.checkThat(splitters.size(), is(0));
    }

    @Test
    public void createNewWithSplitterShouldWork() throws BillingServiceException {
        String invoiceRecipientId = AxDbConstantsUtil.generateInvoiceRecipientId();
        String splitterId1 = AxDbConstantsUtil.generateSplittingRuleId();
        String splitterId2 = AxDbConstantsUtil.generateSplittingRuleId();

        InvoiceRecipient invoiceRecipient = createInvoiceRecipient(invoiceRecipientId, createSplittingRules(invoiceRecipientId, splitterId1, splitterId2));
        Market market = new Market(51);
        invoiceRecipientHandler.insertInvoiceRecipient(invoiceRecipient, market);

        verifyInvoiceRecipientWithSplitterInAx(invoiceRecipient);
    }

    private void verifyInvoiceRecipientWithSplitterInAx(InvoiceRecipient expected) throws BillingServiceException {
        FindInvoiceRecipientCall findInvoiceRecipientCall = invoiceRecipientHandler.findInvoiceRecipientByPk(expected.getInvoiceRecipientId(), new Market(51));

        collector.checkThat(findInvoiceRecipientCall.getNumberOfInvoiceRecipient(), Matchers.is(1));

        AxdEntityMDSSalesInvoiceRecipient invoiceRecipient = findInvoiceRecipientCall.getInvoiceRecipient();
        collector.checkThat(invoiceRecipient.getInvoiceRecipientId(), is(expected.getInvoiceRecipientId().getGuidForAx()));
        collector.checkThat(invoiceRecipient.getAttentionRow1().getValue(), is(expected.getAttentionRow1()));
        collector.checkThat(invoiceRecipient.getAttentionRow2().getValue(), is(expected.getAttentionRow2()));
        collector.checkThat(invoiceRecipient.getEmail().getValue(), is(expected.getEmailAddress()));
        collector.checkThat(invoiceRecipient.getDefaultRecipient(), is(AxdEnumNoYesCombo.YES));

        AxdEntityLogisticsPostalAddress postalAddress = invoiceRecipient.getLogisticsLocation().get(0).getLogisticsPostalAddress().get(0);
        collector.checkThat(postalAddress.getCity().getValue(), is(expected.getRegisteredAddress().getCity()));
        collector.checkThat(postalAddress.getBuildingCompliment().getValue(), is(expected.getRegisteredAddress().getCounty()));
        collector.checkThat(replaceNewLine(postalAddress.getStreet().getValue(), ":"), is(expected.getRegisteredAddress().getLine1() + ":" +
                expected.getRegisteredAddress().getLine2()));
        collector.checkThat(postalAddress.getZipCode().getValue(), is(expected.getRegisteredAddress().getPostalCode()));
        collector.checkThat(postalAddress.getCountryRegionId(), is("SWE"));

        List<AxdEntityMDSSalesSplitter> splitters = findInvoiceRecipientCall.getSplitters();
        collector.checkThat(splitters.size(), is(2));
        collector.checkThat(splitters.get(0).getSplitterId(), is(expected.getSplittingRules().get(0).getSplittingRuleId().getGuidForAx()));
        collector.checkThat(splitters.get(0).getSplitterValue(), is(expected.getSplittingRules().get(0).getSplitter()));
        collector.checkThat(splitters.get(0).getInvoiceRecipientId(), is(expected.getSplittingRules().get(0).getInvoiceRecipientId().getGuidForAx()));

    }

    private String replaceNewLine(String string, String replacement) {
        return string.replaceAll("\\n\\r|\\n|\\r", replacement);
    }

    @Test
    public void createNewWithThreeSplitterShouldWork() throws BillingServiceException {
        String invoiceRecipientId = AxDbConstantsUtil.generateInvoiceRecipientId();
        String splitterId1 = AxDbConstantsUtil.generateSplittingRuleId();
        String splitterId2 = AxDbConstantsUtil.generateSplittingRuleId();
        String splitterId3 = AxDbConstantsUtil.generateSplittingRuleId();

        InvoiceRecipient invoiceRecipient = createInvoiceRecipient(invoiceRecipientId, createSplittingRules(invoiceRecipientId, splitterId1, splitterId2, splitterId3));
        Market market = new Market(51);
        System.out.println("Created new InvoiceRecipient with id: " + invoiceRecipientId);
        invoiceRecipientHandler.insertInvoiceRecipient(invoiceRecipient, market);
    }

    @Test
    public void createExistingShouldNotWork() throws BillingServiceException {
        String invoiceRecipientId = AxDbConstantsUtil.EXISTING_INVOICE_RECIPIENT_ID;
        String splitterId = AxDbConstantsUtil.EXISTING_SPLITTING_RULE_ID;

        InvoiceRecipient invoiceRecipient = createInvoiceRecipient(invoiceRecipientId, createSplittingRules(invoiceRecipientId, splitterId));
        Market market = new Market(51);

        try {
            invoiceRecipientHandler.insertInvoiceRecipient(invoiceRecipient, market);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), startsWith("InvoiceRecipient"));
            assertThat(bsex.getMessage(), endsWith("The record already exists."));
            assertThat(bsex.getCategory(), Matchers.is(ServiceResultCategory.INTEGRATION_DISTURBANCE));
        }
    }

    private ArrayList<SplittingRule> createSplittingRules(String invoiceRecipientId, String... ids) {
        ArrayList<SplittingRule> splittingRules = new ArrayList<SplittingRule>();
        for (String id : ids) {
            splittingRules.add(new SplittingRule(id, invoiceRecipientId, "1234567890"));
        }
        return splittingRules;
    }

    private InvoiceRecipient createInvoiceRecipient(String id, ArrayList<SplittingRule> splittingRules) {
        char[] lineArr = new char[120];
        Arrays.fill(lineArr, 'x');
        Address address = new Address(new String(lineArr), new String(lineArr),
                "123456789012345678901234567890123456789012345678901234567890",
                "123456789012345678901234567890123456789012345678901234567890",
                "1234567890", "SE", 1);
        char[] attArr = new char[200];
        Arrays.fill(attArr, 'x');
        return new InvoiceRecipient(id, AxDbConstantsUtil.EXISTING_INVOICE_RULE_ID, new String(attArr), new String(attArr),
                "12345678901234567890123456789012345678901234567890123456789012345678901234567890", true, address,
                splittingRules);
    }

}
