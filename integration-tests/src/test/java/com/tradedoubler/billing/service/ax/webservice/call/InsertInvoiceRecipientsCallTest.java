package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.*;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumNoYesCombo;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.InvoiceRecipientHandler;
import org.hamcrest.Matchers;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static com.tradedoubler.billing.util.AxDbConstantsUtil.*;
import static org.hamcrest.core.Is.is;

/**
 * @author bjoek
 * @since 2012-07-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class InsertInvoiceRecipientsCallTest {

    @Autowired
    private InvoiceRecipientHandler invoiceRecipientHandler;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void createNewWithSplitterShouldWork() throws BillingServiceException {
        String invoiceRecipientId1 = generateInvoiceRecipientId();
        InvoiceRecipient invoiceRecipient1 = createInvoiceRecipient(invoiceRecipientId1,
                createSplittingRules(invoiceRecipientId1, generateSplittingRuleId(), generateSplittingRuleId()));
        String invoiceRecipientId2 = generateInvoiceRecipientId();
        InvoiceRecipient invoiceRecipient2 = createInvoiceRecipient(invoiceRecipientId2,
                createSplittingRules(invoiceRecipientId2, generateSplittingRuleId(), generateSplittingRuleId()));
        String invoiceRecipientId3 = generateInvoiceRecipientId();
        InvoiceRecipient invoiceRecipient3 = createInvoiceRecipient(invoiceRecipientId3,
                createSplittingRules(invoiceRecipientId3, generateSplittingRuleId(), generateSplittingRuleId()));

        List<InvoiceRecipient> invoiceRecipients = new ArrayList<InvoiceRecipient>();
        invoiceRecipients.add(invoiceRecipient1);
        invoiceRecipients.add(invoiceRecipient2);
        invoiceRecipients.add(invoiceRecipient3);


        Market market = new Market(51);
        invoiceRecipientHandler.insertInvoiceRecipients(invoiceRecipients, market);

        verifyInvoiceRecipientWithSplitterInAx(invoiceRecipients);
    }

    private void verifyInvoiceRecipientWithSplitterInAx(List<InvoiceRecipient> expectedInvoiceRecipient) throws BillingServiceException {
        for (InvoiceRecipient expected : expectedInvoiceRecipient) {
            verifyOneInvoiceRecipient(expected);
        }
    }

    private void verifyOneInvoiceRecipient(InvoiceRecipient expected) throws BillingServiceException {
        Guid invoiceRecipientId = expected.getInvoiceRecipientId();
        System.out.println("Verifying id: " + invoiceRecipientId.getGuid());
        FindInvoiceRecipientCall findInvoiceRecipientCall = invoiceRecipientHandler.findInvoiceRecipientByPk(invoiceRecipientId, new Market(51));

        collector.checkThat(findInvoiceRecipientCall.getNumberOfInvoiceRecipient(), Matchers.is(1));

        AxdEntityMDSSalesInvoiceRecipient invoiceRecipient = findInvoiceRecipientCall.getInvoiceRecipient();
        collector.checkThat(invoiceRecipient.getInvoiceRecipientId(), is(invoiceRecipientId.getGuidForAx()));
        collector.checkThat(invoiceRecipient.getAttentionRow1().getValue(), is(expected.getAttentionRow1()));
        collector.checkThat(invoiceRecipient.getAttentionRow2().getValue(), is(expected.getAttentionRow2()));
        collector.checkThat(invoiceRecipient.getEmail().getValue(), is(expected.getEmailAddress()));
        collector.checkThat(invoiceRecipient.getDefaultRecipient(), is(AxdEnumNoYesCombo.YES));

        AxdEntityLogisticsPostalAddress postalAddress = invoiceRecipient.getLogisticsLocation().get(0).getLogisticsPostalAddress().get(0);
        collector.checkThat(postalAddress.getCity().getValue(), is(expected.getRegisteredAddress().getCity()));
        collector.checkThat(postalAddress.getBuildingCompliment().getValue(), is(expected.getRegisteredAddress().getCounty()));
//TODO        collector.checkThat(postalAddress.getStreet().getValue(), is(expected.getRegisteredAddress().getLine1() + "\r\n" +
//                expected.getRegisteredAddress().getLine2()));
        collector.checkThat(postalAddress.getZipCode().getValue(), is(expected.getRegisteredAddress().getPostalCode()));
        collector.checkThat(postalAddress.getCountryRegionId(), is("SWE"));

        List<AxdEntityMDSSalesSplitter> splitters = findInvoiceRecipientCall.getSplitters();
        collector.checkThat(splitters.size(), is(2));
        collector.checkThat(splitters.get(0).getSplitterId(), is(expected.getSplittingRules().get(0).getSplittingRuleId().getGuidForAx()));
        collector.checkThat(splitters.get(0).getSplitterValue(), is(expected.getSplittingRules().get(0).getSplitter()));
        collector.checkThat(splitters.get(0).getInvoiceRecipientId(), is(expected.getSplittingRules().get(0).getInvoiceRecipientId().getGuidForAx()));
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
        return new InvoiceRecipient(id, EXISTING_INVOICE_RULE_ID, new String(attArr), new String(attArr),
                "12345678901234567890123456789012345678901234567890123456789012345678901234567890", true, address,
                splittingRules);
    }

}
