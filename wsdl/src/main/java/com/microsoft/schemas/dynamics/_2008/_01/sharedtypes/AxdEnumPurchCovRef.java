
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_PurchCovRef.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_PurchCovRef">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="ProjectTrans"/>
 *     &lt;enumeration value="FixedAssetsTrans"/>
 *     &lt;enumeration value="SalesOrderLine"/>
 *     &lt;enumeration value="ProdTrans"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_PurchCovRef")
@XmlEnum
public enum AxdEnumPurchCovRef {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("ProjectTrans")
    PROJECT_TRANS("ProjectTrans"),
    @XmlEnumValue("FixedAssetsTrans")
    FIXED_ASSETS_TRANS("FixedAssetsTrans"),
    @XmlEnumValue("SalesOrderLine")
    SALES_ORDER_LINE("SalesOrderLine"),
    @XmlEnumValue("ProdTrans")
    PROD_TRANS("ProdTrans");
    private final String value;

    AxdEnumPurchCovRef(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumPurchCovRef fromValue(String v) {
        for (AxdEnumPurchCovRef c: AxdEnumPurchCovRef.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
