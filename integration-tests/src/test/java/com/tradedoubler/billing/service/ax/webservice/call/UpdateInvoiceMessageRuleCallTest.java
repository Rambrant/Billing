package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdEntityCustTable;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.InvoiceMessageRuleHandler;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import static com.tradedoubler.billing.util.AxDbConstantsUtil.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * User: erigu
 * Date: 2012-09-10
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class UpdateInvoiceMessageRuleCallTest {

    @Autowired
    private InvoiceMessageRuleHandler invoiceMessageRuleHandler;

    @Test
    public void updateShouldWork() throws BillingServiceException {
        InvoiceMessageRule invoiceMessage = new ClientMessageRule(EXISTING_INVOICE_MESSAGE_RULE_CLIENT_ID, EXISTING_CLIENT_ACCOUNT_NUM, "text", new Timestamp(), new Timestamp());

        FindInvoiceMessageRuleCall readInvoiceMessageRuleCall = invoiceMessageRuleHandler.findInvoiceMessageRuleByPk(invoiceMessage.getInvoiceMessageRuleId(), new Market(51));

        invoiceMessageRuleHandler.updateInvoiceMessageRule(readInvoiceMessageRuleCall, invoiceMessage, new Market(51));
    }

    @Test
    public void updateNonExistingShouldNotWork() throws BillingServiceException {
        ClientMessageRule invoiceMessage = new ClientMessageRule(EXISTING_INVOICE_MESSAGE_RULE_CLIENT_ID, EXISTING_CLIENT_ACCOUNT_NUM, "text", new Timestamp(), new Timestamp());

        FindInvoiceMessageRuleCall readInvoiceMessageRuleCall = invoiceMessageRuleHandler.findInvoiceMessageRuleByPk(invoiceMessage.getInvoiceMessageRuleId(), new Market(51));

        // Update id
        String id = generateInvoiceMessageRuleId();
        invoiceMessage.setInvoiceMessageRuleId(id);

        try {
            invoiceMessageRuleHandler.updateInvoiceMessageRule(readInvoiceMessageRuleCall, invoiceMessage, new Market(51));
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), Matchers.startsWith("InvoiceMessageRule PK: invoiceMessageRuleId: {" + id.toUpperCase() +
                    "} parentPrimaryKey: TELIA, dataAreaId: SE02  , No valid document identified from the entity key"));
        }

    }

    @Test
    public void updateWithWrongHashValueShouldNotWork() throws BillingServiceException {
        ClientMessageRule invoiceMessage = new ClientMessageRule(EXISTING_INVOICE_MESSAGE_RULE_CLIENT_ID, EXISTING_CLIENT_ACCOUNT_NUM, "text", new Timestamp(), new Timestamp());

        FindInvoiceMessageRuleCall readInvoiceMessageRuleCall = spy(invoiceMessageRuleHandler.findInvoiceMessageRuleByPk(invoiceMessage.getInvoiceMessageRuleId(), new Market(51)));

        QName _AxdEntityMDSSalesInvoiceMessageDocumentHash_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvMes", "_DocumentHash");
        JAXBElement<String> docHash = new JAXBElement<String>(_AxdEntityMDSSalesInvoiceMessageDocumentHash_QNAME, String.class, AxdEntityCustTable.class, "dummy");

        // Replace document hash value
        when(readInvoiceMessageRuleCall.getDocumentHash()).thenReturn(docHash);

        try {
            invoiceMessageRuleHandler.updateInvoiceMessageRule(readInvoiceMessageRuleCall, invoiceMessage, new Market(51));
            fail();
        } catch (BillingServiceException bsex) {
            assertThat(bsex.getMessage(), Matchers.startsWith("InvoiceMessageRule PK: invoiceMessageRuleId: {E4EB8A35-624D-48CA-8B91-F45002BB7A1E} parentPrimaryKey: TELIA, dataAreaId: SE02  , " +
                    "The document hash does not match the hash in the XML."));
        }

    }


}
