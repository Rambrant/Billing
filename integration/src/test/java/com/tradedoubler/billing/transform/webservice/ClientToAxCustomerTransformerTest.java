package com.tradedoubler.billing.transform.webservice;

import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdCustomer;
import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdEntityDirPartyDirOrganization;
import com.microsoft.schemas.dynamics._2008._01.documents.customer.ObjectFactory;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumAxdEntityAction;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumValidTimeStateUpdate;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdTypeDateTime;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.ax.webservice.call.FindClientCall;
import com.tradedoubler.billing.service.ax.webservice.call.ReadClientCall;
import com.tradedoubler.billing.service.transform.AxConverterService;
import com.tradedoubler.billing.service.transform.AxConverterServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.when;

/**
 * User: erigu
 * Date: 2012-09-24
 */
public class ClientToAxCustomerTransformerTest {

    private ClientToAxCustomerTransformer clientToAxCustomerTransformer;

    @Mock
    private
    ReadClientCall readCall;

    @Mock
    private
    FindClientCall findCall;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testTransform() throws Exception {
        AxConverterService converter = AxConverterServiceImpl.createNonDatabaseInstanceForTest();
        clientToAxCustomerTransformer = new ClientToAxCustomerTransformer(converter);
        Client client = createClient("clientId");
        AxdCustomer axCustomer = clientToAxCustomerTransformer.transform(client);
        assertNotNull(axCustomer);
        assertEquals(1, axCustomer.getCustTable().size());
        assertEquals("clientId", axCustomer.getCustTable().get(0).getAccountNum().getValue());
        assertEquals("External", axCustomer.getCustTable().get(0).getCustGroup());
        assertEquals("SE556284231901", axCustomer.getCustTable().get(0).getVATNum().getValue());
        assertNull("Org id should not be set in cust table", axCustomer.getCustTable().get(0).getOrgId());

        assertEquals(1, axCustomer.getCustTable().get(0).getDirParty().size());
        assertEquals("5562842319", ((AxdEntityDirPartyDirOrganization) axCustomer.getCustTable().get(0).getDirParty().get(0)).getOrgNumber().getValue());

        assertEquals("SV", axCustomer.getCustTable().get(0).getDirParty().get(0).getLanguageId().getValue());
        assertEquals("Dummy", axCustomer.getCustTable().get(0).getDirParty().get(0).getName().getValue());
        assertEquals(1, axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().size());
        assertEquals("Vasagatan 38", axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getStreet().getValue());
        assertEquals("11120", axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getZipCode().getValue());
        assertEquals("Göteborg", axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getCity().getValue());
        assertEquals("SWE", axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getCountryRegionId().getValue());
        assertEquals("Business", axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getRoles().getValue());
    }

        @Test
    public void testTransformNullClient() throws Exception {
        AxConverterService converter = AxConverterServiceImpl.createNonDatabaseInstanceForTest();
        clientToAxCustomerTransformer = new ClientToAxCustomerTransformer(converter);
        Client client = createNullClient("clientId");
        AxdCustomer axCustomer = clientToAxCustomerTransformer.transform(client);
        assertNotNull(axCustomer);

        assertEquals("0", ((AxdEntityDirPartyDirOrganization) axCustomer.getCustTable().get(0).getDirParty().get(0)).getOrgNumber().getValue());

            ResellerClient resellerClient = createNullResellerClient("clientId");
            axCustomer = clientToAxCustomerTransformer.transform(client);
            assertNotNull(axCustomer);

            assertEquals("0", ((AxdEntityDirPartyDirOrganization) axCustomer.getCustTable().get(0).getDirParty().get(0)).getOrgNumber().getValue());


    }

    @Test
    public void testTransformForUpdateWithFind() throws Exception {
        AxConverterService converter = AxConverterServiceImpl.createNonDatabaseInstanceForTest();
        clientToAxCustomerTransformer = new ClientToAxCustomerTransformer(converter);
        Client client = createClient("clientId");

        ObjectFactory objectFactory = new ObjectFactory();
        AxdTypeDateTime axDateTime = new AxdTypeDateTime();
        axDateTime.setLocalDateTime(DateConverter.convertISO8601ToXMLGregorianCalendar("2013-05-24T15:30:01.999+02:00"));
        when(findCall.getValidAsOfDateTime()).thenReturn(objectFactory.createAxdCustomerValidAsOfDateTime(axDateTime));
        when(findCall.getDocumentHash()).thenReturn(objectFactory.createAxdEntityCustTableDocumentHash("ashgdf"));
        when(findCall.getDirPartyRecId()).thenReturn(objectFactory.createAxdEntityCustTableRecId(1234l));
        when(findCall.getDirPartyPostalAddressViewRecId()).thenReturn(objectFactory.createAxdEntityDirPartyPostalAddressViewRecId(4321l));
        AxdCustomer axCustomer = clientToAxCustomerTransformer.transformForUpdate(client, findCall);
        assertNotNull(axCustomer);

        assertEquals(1, axCustomer.getCustTable().size());
        assertEquals("clientId", axCustomer.getCustTable().get(0).getAccountNum().getValue());
        assertEquals("External", axCustomer.getCustTable().get(0).getCustGroup());
        assertEquals("SE556284231901", axCustomer.getCustTable().get(0).getVATNum().getValue());
        assertEquals(AxdEnumAxdEntityAction.UPDATE, axCustomer.getCustTable().get(0).getAction());
        assertNull("Org id should not be set in cust table", axCustomer.getCustTable().get(0).getOrgId());

        assertEquals(1, axCustomer.getCustTable().get(0).getDirParty().size());
        assertEquals("5562842319", ((AxdEntityDirPartyDirOrganization) axCustomer.getCustTable().get(0).getDirParty().get(0)).getOrgNumber().getValue());
        assertEquals(AxdEnumAxdEntityAction.UPDATE, axCustomer.getCustTable().get(0).getDirParty().get(0).getAction());

        assertEquals("SV", axCustomer.getCustTable().get(0).getDirParty().get(0).getLanguageId().getValue());
        assertEquals("Dummy", axCustomer.getCustTable().get(0).getDirParty().get(0).getName().getValue());
        assertEquals(1, axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().size());
        assertEquals(Long.valueOf(1234), axCustomer.getCustTable().get(0).getDirParty().get(0).getRecId().getValue());

        assertEquals(AxdEnumAxdEntityAction.UPDATE, axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getAction());
        assertEquals(AxdEnumValidTimeStateUpdate.EFFECTIVE_BASED, axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getUpdateMode());

        assertEquals("Vasagatan 38", axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getStreet().getValue());
        assertEquals("11120", axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getZipCode().getValue());
        assertEquals("Göteborg", axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getCity().getValue());
        assertEquals("SWE", axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getCountryRegionId().getValue());
        assertEquals("Business", axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getRoles().getValue());
        assertEquals(Long.valueOf(4321), axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getRecId().getValue());

    }

    @Test
    public void testTransformForUpdateWithRead() throws Exception {
        AxConverterService converter = AxConverterServiceImpl.createNonDatabaseInstanceForTest();
        clientToAxCustomerTransformer = new ClientToAxCustomerTransformer(converter);
        Client client = createClient("clientId");

        ObjectFactory objectFactory = new ObjectFactory();
        AxdTypeDateTime axDateTime = new AxdTypeDateTime();
        axDateTime.setLocalDateTime(DateConverter.convertISO8601ToXMLGregorianCalendar("2013-05-24T15:30:01.999+02:00"));
        when(readCall.getValidAsOfDateTime()).thenReturn(objectFactory.createAxdCustomerValidAsOfDateTime(axDateTime));
        when(readCall.getDocumentHash()).thenReturn(objectFactory.createAxdEntityCustTableDocumentHash("ashgdf"));
        when(readCall.getDirPartyRecId()).thenReturn(objectFactory.createAxdEntityCustTableRecId(1234l));
        when(readCall.getDirPartyPostalAddressViewRecId()).thenReturn(objectFactory.createAxdEntityDirPartyPostalAddressViewRecId(4321l));
        AxdCustomer axCustomer = clientToAxCustomerTransformer.transformForUpdate(client, readCall);
        assertNotNull(axCustomer);

        assertEquals(1, axCustomer.getCustTable().size());
        assertEquals("clientId", axCustomer.getCustTable().get(0).getAccountNum().getValue());
        assertEquals("External", axCustomer.getCustTable().get(0).getCustGroup());
        assertEquals("SE556284231901", axCustomer.getCustTable().get(0).getVATNum().getValue());
        assertEquals(AxdEnumAxdEntityAction.UPDATE, axCustomer.getCustTable().get(0).getAction());
        assertNull("Org id should not be set in cust table", axCustomer.getCustTable().get(0).getOrgId());

        assertEquals(1, axCustomer.getCustTable().get(0).getDirParty().size());
        assertEquals("5562842319", ((AxdEntityDirPartyDirOrganization) axCustomer.getCustTable().get(0).getDirParty().get(0)).getOrgNumber().getValue());
        assertEquals(AxdEnumAxdEntityAction.UPDATE, axCustomer.getCustTable().get(0).getDirParty().get(0).getAction());

        assertEquals("SV", axCustomer.getCustTable().get(0).getDirParty().get(0).getLanguageId().getValue());
        assertEquals("Dummy", axCustomer.getCustTable().get(0).getDirParty().get(0).getName().getValue());
        assertEquals(1, axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().size());
        assertEquals(Long.valueOf(1234), axCustomer.getCustTable().get(0).getDirParty().get(0).getRecId().getValue());

        assertEquals(AxdEnumAxdEntityAction.UPDATE, axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getAction());
        assertEquals(AxdEnumValidTimeStateUpdate.EFFECTIVE_BASED, axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getUpdateMode());

        assertEquals("Vasagatan 38", axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getStreet().getValue());
        assertEquals("11120", axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getZipCode().getValue());
        assertEquals("Göteborg", axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getCity().getValue());
        assertEquals("SWE", axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getCountryRegionId().getValue());
        assertEquals("Business", axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getRoles().getValue());
        assertEquals(Long.valueOf(4321), axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getRecId().getValue());

    }

    @Test
    public void testTransformForUpdateWithBankAccount() throws Exception {
        AxConverterService converter = AxConverterServiceImpl.createNonDatabaseInstanceForTest();

        clientToAxCustomerTransformer = new ClientToAxCustomerTransformer(converter);
        Client client = createClient("clientId");

        ObjectFactory objectFactory = new ObjectFactory();
        AxdTypeDateTime axDateTime = new AxdTypeDateTime();
        axDateTime.setLocalDateTime(DateConverter.convertISO8601ToXMLGregorianCalendar("2013-05-24T15:30:01.999+02:00"));
        when(readCall.getValidAsOfDateTime()).thenReturn(objectFactory.createAxdCustomerValidAsOfDateTime(axDateTime));
        when(readCall.getDocumentHash()).thenReturn(objectFactory.createAxdEntityCustTableDocumentHash("ashgdf"));
        when(readCall.getDirPartyRecId()).thenReturn(objectFactory.createAxdEntityCustTableRecId(1234l));
        when(readCall.getDirPartyPostalAddressViewRecId()).thenReturn(objectFactory.createAxdEntityDirPartyPostalAddressViewRecId(4321l));

        AxdCustomer firstCustomer = clientToAxCustomerTransformer.transform(client);
        AxdCustomer axCustomer = clientToAxCustomerTransformer.transformForUpdate(firstCustomer, "bankAccountValue", readCall);
        assertNotNull(axCustomer);

        assertEquals(1, axCustomer.getCustTable().size());

        assertEquals("bankAccountValue", axCustomer.getCustTable().get(0).getBankAccount().getValue());

        assertEquals("clientId", axCustomer.getCustTable().get(0).getAccountNum().getValue());
        assertEquals("External", axCustomer.getCustTable().get(0).getCustGroup());
        assertEquals("SE556284231901", axCustomer.getCustTable().get(0).getVATNum().getValue());
        assertEquals(AxdEnumAxdEntityAction.UPDATE, axCustomer.getCustTable().get(0).getAction());
        assertNull("Org id should not be set in cust table", axCustomer.getCustTable().get(0).getOrgId());

        assertEquals(1, axCustomer.getCustTable().get(0).getDirParty().size());
        assertEquals("5562842319", ((AxdEntityDirPartyDirOrganization) axCustomer.getCustTable().get(0).getDirParty().get(0)).getOrgNumber().getValue());
        assertEquals(AxdEnumAxdEntityAction.UPDATE, axCustomer.getCustTable().get(0).getDirParty().get(0).getAction());

        assertEquals("SV", axCustomer.getCustTable().get(0).getDirParty().get(0).getLanguageId().getValue());
        assertEquals("Dummy", axCustomer.getCustTable().get(0).getDirParty().get(0).getName().getValue());
        assertEquals(1, axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().size());
        assertEquals(Long.valueOf(1234), axCustomer.getCustTable().get(0).getDirParty().get(0).getRecId().getValue());

        assertEquals(AxdEnumAxdEntityAction.UPDATE, axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getAction());
        assertEquals(AxdEnumValidTimeStateUpdate.EFFECTIVE_BASED, axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getUpdateMode());

        assertEquals("Vasagatan 38", axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getStreet().getValue());
        assertEquals("11120", axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getZipCode().getValue());
        assertEquals("Göteborg", axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getCity().getValue());
        assertEquals("SWE", axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getCountryRegionId().getValue());
        assertEquals("Business", axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getRoles().getValue());
        assertEquals(Long.valueOf(4321), axCustomer.getCustTable().get(0).getDirParty().get(0).getDirPartyPostalAddressView().get(0).getRecId().getValue());

    }

    private Client createClient(String id) {
        Address address = new Address("Vasagatan 38", null, "Göteborg", null, "11120", "SE", 3);
        List<Integer> markets = Arrays.asList(51);
        return new Client(id, "Dummy", "5562842319", "SE556284231901", ClientType.ADVERTISER, "SV", "",
                new ArrayList<Bank>(), address,
                new ArrayList<ClientMessageRule>(), markets);
    }

    private Client createNullClient(String id) {
        Address address = new Address("Vasagatan 38", null, "Göteborg", null, "11120", "SE", 3);
        List<Integer> markets = Arrays.asList(51);
        return new Client(id, "Dummy", null, "SE556284231901", ClientType.ADVERTISER, "SV", "",
                new ArrayList<Bank>(), address,
                new ArrayList<ClientMessageRule>(), markets);
    }

   private ResellerClient createNullResellerClient(String id) {
        Address address = new Address("Vasagatan 38", null, "Göteborg", null, "11120", "SE", 3);
        List<Integer> markets = Arrays.asList(51);
        return new ResellerClient(id, "Dummy", null, "SE556284231901", "SV", "", address);
    }

}
