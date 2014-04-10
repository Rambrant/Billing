package com.tradedoubler.billing.transform.webservice;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.*;
import com.tradedoubler.billing.domain.Address;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.transform.AxConverterService;

import static com.tradedoubler.billing.transform.webservice.AxUtil.convertNullToEmptyString;

/**
 * Convert an Address to Ax representation of the same
 * 
 * User: erigu
 * Date: 2012-09-04
 */
class AddressToWsLogisticLocationTransformer {

    private final AxConverterService converter;
    private final Address address;

    public AddressToWsLogisticLocationTransformer(AxConverterService converter, Address address) {
        this.converter = converter;
        this.address = address;
    }

    public AxdEntityLogisticsLocation transform() throws BillingServiceException {
        ObjectFactory objectFactory = new ObjectFactory();
        AxdEntityLogisticsLocation axdEntityLogisticsLocation = objectFactory.createAxdEntityLogisticsLocation();
        axdEntityLogisticsLocation.setClazz("entity");
        AxdEntityLogisticsPostalAddress logisticPostalAddress = objectFactory.createAxdEntityLogisticsPostalAddress();
        logisticPostalAddress.setClazz("entity");
        logisticPostalAddress.setBuildingCompliment(objectFactory.createAxdEntityLogisticsPostalAddressBuildingCompliment(
                convertNullToEmptyString(address.getCounty())));
        logisticPostalAddress.setCity(objectFactory.createAxdEntityLogisticsPostalAddressCity(address.getCity()));
        logisticPostalAddress.setCountryRegionId(converter.convert(address.getCountryCode()));

        String street = AxUtil.createStreet(address.getLine1(), address.getLine2());

        logisticPostalAddress.setStreet(objectFactory.createAxdEntityLogisticsPostalAddressStreet(street));

        //Street number is not used because CRM has that information in the street part.

        logisticPostalAddress.setZipCode(objectFactory.createAxdEntityLogisticsPostalAddressZipCode(address.getPostalCode()));

        axdEntityLogisticsLocation.getLogisticsPostalAddress().add(logisticPostalAddress);

        return axdEntityLogisticsLocation;
    }
}
