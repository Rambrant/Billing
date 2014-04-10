
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_TaxTransRelationshipType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_TaxTransRelationshipType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Tax"/>
 *     &lt;enumeration value="UseTaxPayable"/>
 *     &lt;enumeration value="TransactionLineAccount"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_TaxTransRelationshipType")
@XmlEnum
public enum AxdEnumTaxTransRelationshipType {

    @XmlEnumValue("Tax")
    TAX("Tax"),
    @XmlEnumValue("UseTaxPayable")
    USE_TAX_PAYABLE("UseTaxPayable"),
    @XmlEnumValue("TransactionLineAccount")
    TRANSACTION_LINE_ACCOUNT("TransactionLineAccount");
    private final String value;

    AxdEnumTaxTransRelationshipType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTaxTransRelationshipType fromValue(String v) {
        for (AxdEnumTaxTransRelationshipType c: AxdEnumTaxTransRelationshipType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
