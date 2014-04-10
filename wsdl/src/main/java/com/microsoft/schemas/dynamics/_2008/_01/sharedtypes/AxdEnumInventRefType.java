
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_InventRefType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_InventRefType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Sales"/>
 *     &lt;enumeration value="Purch"/>
 *     &lt;enumeration value="Production"/>
 *     &lt;enumeration value="ProdLine"/>
 *     &lt;enumeration value="InventJournal"/>
 *     &lt;enumeration value="CRMQuotation"/>
 *     &lt;enumeration value="InventTransfer"/>
 *     &lt;enumeration value="FixedAsset"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_InventRefType")
@XmlEnum
public enum AxdEnumInventRefType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Sales")
    SALES("Sales"),
    @XmlEnumValue("Purch")
    PURCH("Purch"),
    @XmlEnumValue("Production")
    PRODUCTION("Production"),
    @XmlEnumValue("ProdLine")
    PROD_LINE("ProdLine"),
    @XmlEnumValue("InventJournal")
    INVENT_JOURNAL("InventJournal"),
    @XmlEnumValue("CRMQuotation")
    CRM_QUOTATION("CRMQuotation"),
    @XmlEnumValue("InventTransfer")
    INVENT_TRANSFER("InventTransfer"),
    @XmlEnumValue("FixedAsset")
    FIXED_ASSET("FixedAsset");
    private final String value;

    AxdEnumInventRefType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumInventRefType fromValue(String v) {
        for (AxdEnumInventRefType c: AxdEnumInventRefType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
