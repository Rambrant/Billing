package com.tradedoubler.billing.transform.webservice;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.*;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.ObjectFactory;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.*;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.call.FindInvoiceRecipientCall;
import com.tradedoubler.billing.service.transform.*;
import org.junit.*;
import org.mockito.*;

import java.util.*;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.when;

/**
 * User: erigu
 * Date: 2012-09-21
 */
public class InvoiceRecipientToAxSalesInvoiceRecipientTransformerTest {

    private InvoiceRecipientToAxSalesInvoiceRecipientTransformer invoiceRecipientToAxSalesInvoiceRecipientTransformer;

    @Mock
    private
    FindInvoiceRecipientCall findCall;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testTransform() throws Exception {
        AxConverterService converter = AxConverterServiceImpl.createNonDatabaseInstanceForTest();
        Address address  = new Address("line 1", "line 2","Stockholm","county", "123-456", "SE", 1);
        List<SplittingRule> splittingRules = createSplittingRules("invRecId", "id1", "id2");
        InvoiceRecipient invoiceRecipient = new InvoiceRecipient("invRecId", "invRuleId", "attRow1", "attRow2", "test@test.test", true, address, splittingRules);
        invoiceRecipientToAxSalesInvoiceRecipientTransformer = new InvoiceRecipientToAxSalesInvoiceRecipientTransformer(converter, invoiceRecipient);
        AxdEntityMDSSalesInvoiceRecipient axRecip = invoiceRecipientToAxSalesInvoiceRecipientTransformer.transform();
        assertNotNull(axRecip);
        assertEquals("attRow1", axRecip.getAttentionRow1().getValue());
        assertEquals("attRow2", axRecip.getAttentionRow2().getValue());
        assertEquals("test@test.test", axRecip.getEmail().getValue());
        assertEquals("{INVRECID}", axRecip.getInvoiceRecipientId());
        assertEquals("{INVRULEID}", axRecip.getInvoiceRuleId().getValue());
        assertEquals(2, axRecip.getMDSSalesSplitter().size());
        assertEquals(1, axRecip.getLogisticsLocation().size());
    }

    @Test
    public void testTransformForUpdate() throws Exception {
        AxConverterService converter = AxConverterServiceImpl.createNonDatabaseInstanceForTest();
        Address address  = new Address("line 1", "line 2","Stockholm","county", "123-456", "SE", 1);
        List<SplittingRule> splittingRules = createSplittingRules("invRecId", "id1", "id2");
        InvoiceRecipient invoiceRecipient = new InvoiceRecipient("invRecId", "invRuleId", "attRow1", "attRow2", "test@test.test", true, address, splittingRules);
        invoiceRecipientToAxSalesInvoiceRecipientTransformer = new InvoiceRecipientToAxSalesInvoiceRecipientTransformer(converter, invoiceRecipient);

        ObjectFactory objectFactory = new ObjectFactory();
        when(findCall.getDocumentHash()).thenReturn(objectFactory.createAxdEntityMDSSalesInvoiceRecipientDocumentHash("12345abc"));

        AxdEntityMDSSalesInvoiceRecipient axRecip = invoiceRecipientToAxSalesInvoiceRecipientTransformer.transformForUpdate(findCall);
        assertEquals(AxdEnumAxdEntityAction.UPDATE, axRecip.getAction());
        assertEquals("12345abc", axRecip.getDocumentHash().getValue());
        for (AxdEntityLogisticsLocation logisticsLocation  : axRecip.getLogisticsLocation()) {
            assertEquals(AxdEnumAxdEntityAction.UPDATE, logisticsLocation.getAction());
            for (AxdEntityLogisticsPostalAddress logisticsPostalAddress : logisticsLocation.getLogisticsPostalAddress()){
                assertEquals(AxdEnumAxdEntityAction.UPDATE, logisticsPostalAddress.getAction());
                assertEquals(AxdEnumValidTimeStateUpdate.EFFECTIVE_BASED, logisticsPostalAddress.getUpdateMode());
            }
        }
        assertNotNull(axRecip);
        assertEquals("attRow1", axRecip.getAttentionRow1().getValue());
        assertEquals("attRow2", axRecip.getAttentionRow2().getValue());
        assertEquals("test@test.test", axRecip.getEmail().getValue());
        assertEquals("{INVRECID}", axRecip.getInvoiceRecipientId());
        assertEquals("{INVRULEID}", axRecip.getInvoiceRuleId().getValue());
        assertEquals(2, axRecip.getMDSSalesSplitter().size());
        assertEquals(1, axRecip.getLogisticsLocation().size());
    }

    @Test
    public void testTransformFindCallDirectlyToUpdate() throws BillingServiceException {
        AxConverterService converter = AxConverterServiceImpl.createNonDatabaseInstanceForTest();
        Address address  = new Address("line 1", "line 2","Stockholm","county", "123-456", "SE", 1);
        List<SplittingRule> splittingRules = createSplittingRules("invRecId", "id1", "id2");
        InvoiceRecipient invoiceRecipient = new InvoiceRecipient("invRecId", "invRuleId", "attRow1", "attRow2", "test@test.test", true, address, splittingRules);
        invoiceRecipientToAxSalesInvoiceRecipientTransformer = new InvoiceRecipientToAxSalesInvoiceRecipientTransformer(converter, invoiceRecipient);
        AxdEntityMDSSalesInvoiceRecipient axRecip = invoiceRecipientToAxSalesInvoiceRecipientTransformer.transform();

        ObjectFactory objectFactory = new ObjectFactory();
        when(findCall.getDocumentHash()).thenReturn(objectFactory.createAxdEntityMDSSalesInvoiceRecipientDocumentHash("12345abc"));
        when(findCall.getInvoiceRecipient()).thenReturn(axRecip);
        when(findCall.getLogisticLocationRecId()).thenReturn(objectFactory.createAxdEntityLogisticsLocationRecId(1234L));
        when(findCall.getPostalAddressLocationId()).thenReturn(1111L);
        when(findCall.getPostalAddressRecId()).thenReturn(objectFactory.createAxdEntityLogisticsPostalAddressRecId(4321L));




        AxdEntityMDSSalesInvoiceRecipient axInvoiceRecipient = InvoiceRecipientToAxSalesInvoiceRecipientTransformer.transformFindCallDirectlyToUpdate(findCall);

        AxdEntityLogisticsLocation logistloc = axInvoiceRecipient.getLogisticsLocation().get(0);

        assertEquals(AxdEnumAxdEntityAction.UPDATE, logistloc.getAction());
        assertEquals(Long.valueOf(1234), logistloc.getRecId().getValue());
        assertEquals(AxdEnumAxdEntityAction.UPDATE, logistloc.getLogisticsPostalAddress().get(0).getAction());


        assertNotNull(axInvoiceRecipient);
        assertEquals(AxdEnumAxdEntityAction.UPDATE, axRecip.getAction());
                assertEquals(AxdEnumAxdEntityAction.UPDATE, axRecip.getAction());
        assertEquals("12345abc", axRecip.getDocumentHash().getValue());
        for (AxdEntityLogisticsLocation logisticsLocation  : axRecip.getLogisticsLocation()) {
            assertEquals(AxdEnumAxdEntityAction.UPDATE, logisticsLocation.getAction());
            for (AxdEntityLogisticsPostalAddress logisticsPostalAddress : logisticsLocation.getLogisticsPostalAddress()){
                assertEquals(AxdEnumAxdEntityAction.UPDATE, logisticsPostalAddress.getAction());
                assertEquals(AxdEnumValidTimeStateUpdate.EFFECTIVE_BASED, logisticsPostalAddress.getUpdateMode());
                assertEquals(1111L, logisticsPostalAddress.getLocation());
                assertEquals(Long.valueOf(4321L), logisticsPostalAddress.getRecId().getValue());

            }
        }
        assertNotNull(axRecip);
        assertEquals("attRow1", axRecip.getAttentionRow1().getValue());
        assertEquals("attRow2", axRecip.getAttentionRow2().getValue());
        assertEquals("test@test.test", axRecip.getEmail().getValue());
        assertEquals("{INVRECID}", axRecip.getInvoiceRecipientId());
        assertEquals("{INVRULEID}", axRecip.getInvoiceRuleId().getValue());
        assertEquals(2, axRecip.getMDSSalesSplitter().size());
        assertEquals(1, axRecip.getLogisticsLocation().size());
    }

    private ArrayList<SplittingRule> createSplittingRules(String invoiceRecipientId, String... ids) {
        ArrayList<SplittingRule> splittingRules = new ArrayList<SplittingRule>();
        for (String id : ids) {
            splittingRules.add(new SplittingRule(id, invoiceRecipientId, "sp - upd"));
        }
        return splittingRules;
    }
}
