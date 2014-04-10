
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_OMOperatingUnitType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_OMOperatingUnitType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="OMDepartment"/>
 *     &lt;enumeration value="OMCostCenter"/>
 *     &lt;enumeration value="OMValueStream"/>
 *     &lt;enumeration value="OMBusinessUnit"/>
 *     &lt;enumeration value="OMAnyOU"/>
 *     &lt;enumeration value="RetailChannel"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_OMOperatingUnitType")
@XmlEnum
public enum AxdEnumOMOperatingUnitType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("OMDepartment")
    OM_DEPARTMENT("OMDepartment"),
    @XmlEnumValue("OMCostCenter")
    OM_COST_CENTER("OMCostCenter"),
    @XmlEnumValue("OMValueStream")
    OM_VALUE_STREAM("OMValueStream"),
    @XmlEnumValue("OMBusinessUnit")
    OM_BUSINESS_UNIT("OMBusinessUnit"),
    @XmlEnumValue("OMAnyOU")
    OM_ANY_OU("OMAnyOU"),
    @XmlEnumValue("RetailChannel")
    RETAIL_CHANNEL("RetailChannel");
    private final String value;

    AxdEnumOMOperatingUnitType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumOMOperatingUnitType fromValue(String v) {
        for (AxdEnumOMOperatingUnitType c: AxdEnumOMOperatingUnitType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
