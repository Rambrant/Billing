package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.*;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.InvoiceRecipientHandler;
import com.tradedoubler.billing.util.AxDbConstantsUtil;
import com.tradedoubler.testutil.ReflectionHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.*;

import static com.tradedoubler.billing.util.AxDbConstantsUtil.*;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author bjoek
 * @since 2012-07-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class UpdateInvoiceRecipientCallTest {
    private static final String SPLITTING_RULE_ID1 = "00000000-0000-0000-3000-100000000001";
    private static final String SPLITTING_RULE_ID2 = "00000000-0000-0000-3000-100000000002";
    private static final String SPLITTING_RULE_ID3 = "00000000-0000-0000-3000-100000000003";
    private Market market = new Market(51);

    @Autowired
    private InvoiceRecipientHandler invoiceRecipientHandler;

    @Test
    public void updateExistingShouldWork() throws BillingServiceException {
        InvoiceRecipient invoiceRecipient = createInvoiceRecipient(EXISTING_INVOICE_RECIPIENT_ID,
                createSplittingRules(EXISTING_INVOICE_RECIPIENT_ID, SPLITTING_RULE_ID1));

        FindInvoiceRecipientCall findInvoiceRecipientCall = invoiceRecipientHandler.findInvoiceRecipientByPk(invoiceRecipient.getInvoiceRecipientId(), market);

        invoiceRecipientHandler.updateInvoiceRecipient(findInvoiceRecipientCall, invoiceRecipient, market);
    }

    @Test
    public void updateExistingWithNullShouldWork() throws BillingServiceException {
        InvoiceRecipient invoiceRecipient = createInvoiceRecipient(EXISTING_INVOICE_RECIPIENT_ID,
                createSplittingRules(EXISTING_INVOICE_RECIPIENT_ID, SPLITTING_RULE_ID1));
        invoiceRecipient.setAttentionRow2(null);

        FindInvoiceRecipientCall findInvoiceRecipientCall = invoiceRecipientHandler.findInvoiceRecipientByPk(invoiceRecipient.getInvoiceRecipientId(), market);

        invoiceRecipientHandler.updateInvoiceRecipient(findInvoiceRecipientCall, invoiceRecipient, market);

        findInvoiceRecipientCall = invoiceRecipientHandler.findInvoiceRecipientByPk(invoiceRecipient.getInvoiceRecipientId(), market);
        AxdEntityMDSSalesInvoiceRecipient actual = findInvoiceRecipientCall.getInvoiceRecipient();
        assertThat(actual.getAttentionRow2(), nullValue());
    }

    @Test
    public void updateNonExistingShouldNotWork() throws BillingServiceException {
        InvoiceRecipient invoiceRecipient = createInvoiceRecipient(EXISTING_INVOICE_RECIPIENT_ID,
                createSplittingRules(EXISTING_INVOICE_RECIPIENT_ID, SPLITTING_RULE_ID1));

        FindInvoiceRecipientCall readInvoiceRecipientCall = invoiceRecipientHandler.findInvoiceRecipientByPk(invoiceRecipient.getInvoiceRecipientId(), market);

        //Change the id
        String id = generateInvoiceRecipientId();
        invoiceRecipient.setInvoiceRecipientId(id);

        try {
            invoiceRecipientHandler.updateInvoiceRecipient(readInvoiceRecipientCall, invoiceRecipient, market);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), startsWith("InvoiceRecipient PK: {" + id.toUpperCase() +
                    "}, dataAreaId: SE02  , No valid document identified from the entity key."));
        }
    }

    @Test
    public void updateWithInvalidHashShouldNotWork() throws BillingServiceException {
        InvoiceRecipient invoiceRecipient = createInvoiceRecipient(EXISTING_INVOICE_RECIPIENT_ID,
                createSplittingRules(EXISTING_INVOICE_RECIPIENT_ID, SPLITTING_RULE_ID1));

        FindInvoiceRecipientCall readInvoiceRecipientCall = spy(invoiceRecipientHandler.findInvoiceRecipientByPk(invoiceRecipient.getInvoiceRecipientId(), market));

        QName _AxdEntityMDSSalesInvoiceRecipientDocumentHash_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec", "_DocumentHash");
        JAXBElement<String> docHash = new JAXBElement<String>(_AxdEntityMDSSalesInvoiceRecipientDocumentHash_QNAME, String.class, "dummy");
        when(readInvoiceRecipientCall.getDocumentHash()).thenReturn(docHash);

        try {
            invoiceRecipientHandler.updateInvoiceRecipient(readInvoiceRecipientCall, invoiceRecipient, market);
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), startsWith("InvoiceRecipient PK: {703B123F-6329-4D79-BFAA-60762A5F6CF4}, dataAreaId: SE02  , The document hash does not match the hash in the XML."));
        }
    }

    @Test
    public void updateExistingWithNewInvRuleMessageShouldWork() throws BillingServiceException {
        // Make sure that there is only one random invoice rule message regardless of prior state
        InvoiceRecipient invoiceRecipient = createInvoiceRecipient(EXISTING_INVOICE_RECIPIENT_ID,
                createSplittingRules(EXISTING_INVOICE_RECIPIENT_ID, SPLITTING_RULE_ID1));

        FindInvoiceRecipientCall findInvoiceRecipientCall = invoiceRecipientHandler.findInvoiceRecipientByPk(
                invoiceRecipient.getInvoiceRecipientId(), market);

        // Remove all old and insert one new
        List<AxdEntityMDSSalesSplitter> splitters = findInvoiceRecipientCall.getSplitters();
        for (AxdEntityMDSSalesSplitter salesSplitter : splitters) {
            findInvoiceRecipientCall = invoiceRecipientHandler.findInvoiceRecipientByPk(invoiceRecipient.getInvoiceRecipientId(), market);
            invoiceRecipientHandler.deleteSplittingRule(findInvoiceRecipientCall, Guid.createFromAxGuid(salesSplitter.getSplitterId()), market);
        }
        findInvoiceRecipientCall = invoiceRecipientHandler.findInvoiceRecipientByPk(invoiceRecipient.getInvoiceRecipientId(), market);
        invoiceRecipientHandler.updateInvoiceRecipient(findInvoiceRecipientCall, invoiceRecipient, market);

        // Invoice rule should now contain one message
        findInvoiceRecipientCall = invoiceRecipientHandler.findInvoiceRecipientByPk(invoiceRecipient.getInvoiceRecipientId(), market);
        assertThat(findInvoiceRecipientCall.getSplitters().size(), is(1));
        assertThat(findInvoiceRecipientCall.getSplitters().get(0).getSplitterId(), is("{" + SPLITTING_RULE_ID1.toUpperCase() + "}"));


        // Update to three messages
        invoiceRecipient = createInvoiceRecipient(EXISTING_INVOICE_RECIPIENT_ID,
                createSplittingRules(EXISTING_INVOICE_RECIPIENT_ID, SPLITTING_RULE_ID1, SPLITTING_RULE_ID2, SPLITTING_RULE_ID3));

        invoiceRecipientHandler.updateInvoiceRecipient(findInvoiceRecipientCall, invoiceRecipient, market);

        findInvoiceRecipientCall = invoiceRecipientHandler.findInvoiceRecipientByPk(invoiceRecipient.getInvoiceRecipientId(), market);

        // Invoice rule should now contain three messages
        assertThat(findInvoiceRecipientCall.getSplitters().size(), is(3));
        assertThat(findInvoiceRecipientCall.getSplitters().get(0).getSplitterId(),
                anyOf(is("{" + SPLITTING_RULE_ID1 + "}"),
                        is("{" + SPLITTING_RULE_ID2 + "}"),
                        is("{" + SPLITTING_RULE_ID3 + "}")));
        assertThat(findInvoiceRecipientCall.getSplitters().get(1).getSplitterId(),
                anyOf(is("{" + SPLITTING_RULE_ID1 + "}"),
                        is("{" + SPLITTING_RULE_ID2 + "}"),
                        is("{" + SPLITTING_RULE_ID3 + "}")));
        assertThat(findInvoiceRecipientCall.getSplitters().get(2).getSplitterId(),
                anyOf(is("{" + SPLITTING_RULE_ID1 + "}"),
                        is("{" + SPLITTING_RULE_ID2 + "}"),
                        is("{" + SPLITTING_RULE_ID3 + "}")));


        // Update to one message again
        invoiceRecipient = createInvoiceRecipient(EXISTING_INVOICE_RECIPIENT_ID,
                createSplittingRules(EXISTING_INVOICE_RECIPIENT_ID, SPLITTING_RULE_ID1));

        invoiceRecipientHandler.updateInvoiceRecipient(findInvoiceRecipientCall, invoiceRecipient, market);

        findInvoiceRecipientCall = invoiceRecipientHandler.findInvoiceRecipientByPk(invoiceRecipient.getInvoiceRecipientId(), market);

        // Invoice rule should still contain three messages (no deletes performed)
        assertThat(findInvoiceRecipientCall.getSplitters().size(), is(3));
        assertThat(findInvoiceRecipientCall.getSplitters().get(0).getSplitterId(),
                anyOf(is("{" + SPLITTING_RULE_ID1 + "}"),
                        is("{" + SPLITTING_RULE_ID2 + "}"),
                        is("{" + SPLITTING_RULE_ID3 + "}")));
        assertThat(findInvoiceRecipientCall.getSplitters().get(1).getSplitterId(),
                anyOf(is("{" + SPLITTING_RULE_ID1 + "}"),
                        is("{" + SPLITTING_RULE_ID2 + "}"),
                        is("{" + SPLITTING_RULE_ID3 + "}")));
        assertThat(findInvoiceRecipientCall.getSplitters().get(2).getSplitterId(),
                anyOf(is("{" + SPLITTING_RULE_ID1 + "}"),
                        is("{" + SPLITTING_RULE_ID2 + "}"),
                        is("{" + SPLITTING_RULE_ID3 + "}")));
    }

    @Test
    public void leftoverSplitterShouldNotBeDeleted() throws BillingServiceException, NoSuchFieldException, IllegalAccessException {
        // Create invoice recipient with three splitters
        String invoiceRecipientId = AxDbConstantsUtil.generateInvoiceRecipientId();
        String splitterId1 = AxDbConstantsUtil.generateSplittingRuleId();
        String splitterId2 = AxDbConstantsUtil.generateSplittingRuleId();
        String splitterId3 = AxDbConstantsUtil.generateSplittingRuleId();

        InvoiceRecipient invoiceRecipient = createInvoiceRecipient(invoiceRecipientId, createSplittingRules(invoiceRecipientId, splitterId1, splitterId2, splitterId3));
        Market market = new Market(51);

        invoiceRecipientHandler.insertInvoiceRecipient(invoiceRecipient, market);

        // Check three splitters
        FindInvoiceRecipientCall findCall = invoiceRecipientHandler.findInvoiceRecipientByPk(new Guid(invoiceRecipientId), market);
        assertThat(findCall.getInvoiceRecipient().getMDSSalesSplitter().size(), is(3));

        // Update with two splitters
        new ReflectionHelper(invoiceRecipient.getSplittingRules().get(0)).setField("splitter", "update1");
        new ReflectionHelper(invoiceRecipient.getSplittingRules().get(1)).setField("splitter", "update2");
        new ReflectionHelper(invoiceRecipient.getSplittingRules().get(2)).setField("splitter", "update3");
        invoiceRecipient.getSplittingRules().remove(0);

        invoiceRecipientHandler.updateInvoiceRecipient(findCall, invoiceRecipient, market);

        // Check that we still have three splitters and that two of them are updated
        findCall = invoiceRecipientHandler.findInvoiceRecipientByPk(new Guid(invoiceRecipientId), market);
        assertThat(findCall.getInvoiceRecipient().getMDSSalesSplitter().size(), is(3));
        assertThat(findCall.getInvoiceRecipient().getMDSSalesSplitter().get(0).getSplitterValue(), is("sp - upd"));
        assertThat(findCall.getInvoiceRecipient().getMDSSalesSplitter().get(1).getSplitterValue(), is("update2"));
        assertThat(findCall.getInvoiceRecipient().getMDSSalesSplitter().get(2).getSplitterValue(), is("update3"));
    }

    private ArrayList<SplittingRule> createSplittingRules(String invoiceRecipientId, String... ids) {
        ArrayList<SplittingRule> splittingRules = new ArrayList<SplittingRule>();
        for (String id : ids) {
            splittingRules.add(new SplittingRule(id, invoiceRecipientId, "sp - upd"));
        }
        return splittingRules;
    }

    private InvoiceRecipient createInvoiceRecipient(String id, ArrayList<SplittingRule> splittingRules) {
        Address address = new Address("Vasagatan 38 - upd", null, "Göteborg - upd", null, "11124", "FI", 1);
        return new InvoiceRecipient(id, EXISTING_INVOICE_RULE_ID, "Att1 - utpdat", "Att2 - utpdat", "email - utpdat", true, address,
                splittingRules);
    }
}
