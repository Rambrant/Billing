
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_TrvExpTypeEDT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_TrvExpTypeEDT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Empty"/>
 *     &lt;enumeration value="Expense"/>
 *     &lt;enumeration value="Advance"/>
 *     &lt;enumeration value="Allowance"/>
 *     &lt;enumeration value="Transport"/>
 *     &lt;enumeration value="Personal"/>
 *     &lt;enumeration value="Airline"/>
 *     &lt;enumeration value="CarRental"/>
 *     &lt;enumeration value="Conference"/>
 *     &lt;enumeration value="Entertainment"/>
 *     &lt;enumeration value="Hotel"/>
 *     &lt;enumeration value="Meals"/>
 *     &lt;enumeration value="Gift"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_TrvExpTypeEDT")
@XmlEnum
public enum AxdExtTypeTrvExpTypeEDT {

    @XmlEnumValue("Empty")
    EMPTY("Empty"),
    @XmlEnumValue("Expense")
    EXPENSE("Expense"),
    @XmlEnumValue("Advance")
    ADVANCE("Advance"),
    @XmlEnumValue("Allowance")
    ALLOWANCE("Allowance"),
    @XmlEnumValue("Transport")
    TRANSPORT("Transport"),
    @XmlEnumValue("Personal")
    PERSONAL("Personal"),
    @XmlEnumValue("Airline")
    AIRLINE("Airline"),
    @XmlEnumValue("CarRental")
    CAR_RENTAL("CarRental"),
    @XmlEnumValue("Conference")
    CONFERENCE("Conference"),
    @XmlEnumValue("Entertainment")
    ENTERTAINMENT("Entertainment"),
    @XmlEnumValue("Hotel")
    HOTEL("Hotel"),
    @XmlEnumValue("Meals")
    MEALS("Meals"),
    @XmlEnumValue("Gift")
    GIFT("Gift");
    private final String value;

    AxdExtTypeTrvExpTypeEDT(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypeTrvExpTypeEDT fromValue(String v) {
        for (AxdExtTypeTrvExpTypeEDT c: AxdExtTypeTrvExpTypeEDT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
