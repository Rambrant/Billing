
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_InventJournalType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_InventJournalType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Movement"/>
 *     &lt;enumeration value="LossProfit"/>
 *     &lt;enumeration value="Transfer"/>
 *     &lt;enumeration value="BOM"/>
 *     &lt;enumeration value="Count"/>
 *     &lt;enumeration value="project"/>
 *     &lt;enumeration value="TagCounting"/>
 *     &lt;enumeration value="Asset"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_InventJournalType")
@XmlEnum
public enum AxdEnumInventJournalType {

    @XmlEnumValue("Movement")
    MOVEMENT("Movement"),
    @XmlEnumValue("LossProfit")
    LOSS_PROFIT("LossProfit"),
    @XmlEnumValue("Transfer")
    TRANSFER("Transfer"),
    BOM("BOM"),
    @XmlEnumValue("Count")
    COUNT("Count"),
    @XmlEnumValue("project")
    PROJECT("project"),
    @XmlEnumValue("TagCounting")
    TAG_COUNTING("TagCounting"),
    @XmlEnumValue("Asset")
    ASSET("Asset");
    private final String value;

    AxdEnumInventJournalType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumInventJournalType fromValue(String v) {
        for (AxdEnumInventJournalType c: AxdEnumInventJournalType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
