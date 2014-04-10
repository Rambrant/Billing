package com.tradedoubler.billing.domain;

/**
 * @author bjoek
 * @since 2012-06-25
 */
public class Address {
    private final String city;
    private final Country countryCode;
    private String line1;
    private String line2;
    private final String postalCode;
    private final AddressType addressType;
    private final String county;

    public Address(String line1, String line2, String city, String county, String postalCode, String countryCode, int addressType) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.county = county;
        this.postalCode = postalCode;
        this.countryCode = new Country(countryCode);
        this.addressType = new AddressType(addressType);
    }

    public String getLine1() {
        return line1;
    }

    /** May be null */
    public String getLine2() {
        return line2;
    }

    public String getCity() {
        return city;
    }

    /** May be null */
    public String getCounty() {
        return county;
    }

    public String getPostalCode() {
        return postalCode;
    }

    /** Two character country code according to ISO-3166 */
    public Country getCountryCode() {
        return countryCode;
    }

    /** The type of address. 1 = Invoicing, 3 = Primary */
    public AddressType getAddressType() {
        return addressType;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }
}
