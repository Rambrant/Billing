package com.tradedoubler.billing.transform.webservice;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.*;
import com.tradedoubler.billing.domain.Address;
import com.tradedoubler.billing.service.transform.*;
import org.junit.Test;

import static junit.framework.Assert.*;


/**
 * User: erigu
 * Date: 2012-09-21
 */
public class AddressToWsLogisticLocationTransformerTest {
    @Test
    public void testTransform() throws Exception {

        AxConverterService converter = AxConverterServiceImpl.createNonDatabaseInstanceForTest();

        Address address = new Address("line 1", "line 2","Stockholm","county", "123-456", "SE", 3);
        AddressToWsLogisticLocationTransformer addressToWsLogisticLocationTransformer = new AddressToWsLogisticLocationTransformer(converter, address);

        AxdEntityLogisticsLocation axAddress = addressToWsLogisticLocationTransformer.transform();
        assertNotNull(axAddress);
        assertEquals(1, axAddress.getLogisticsPostalAddress().size());
        assertEquals("entity", axAddress.getClazz());

        AxdEntityLogisticsPostalAddress logAdress = axAddress.getLogisticsPostalAddress().get(0);
        assertEquals("SWE", logAdress.getCountryRegionId());
        assertEquals("entity", logAdress.getClazz());
        assertEquals("Stockholm", logAdress.getCity().getValue());
        assertEquals("county", logAdress.getBuildingCompliment().getValue());
        assertEquals("line 1\r\nline 2", logAdress.getStreet().getValue());
        assertEquals("123-456", logAdress.getZipCode().getValue());

    }
}
