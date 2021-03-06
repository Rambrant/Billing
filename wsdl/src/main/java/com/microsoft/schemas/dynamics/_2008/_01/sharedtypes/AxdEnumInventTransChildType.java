
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_InventTransChildType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_InventTransChildType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="WMSOrder"/>
 *     &lt;enumeration value="ProdJournalBOM"/>
 *     &lt;enumeration value="ProdJournalProd"/>
 *     &lt;enumeration value="DEL_InventJournalPickingList"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_InventTransChildType")
@XmlEnum
public enum AxdEnumInventTransChildType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("WMSOrder")
    WMS_ORDER("WMSOrder"),
    @XmlEnumValue("ProdJournalBOM")
    PROD_JOURNAL_BOM("ProdJournalBOM"),
    @XmlEnumValue("ProdJournalProd")
    PROD_JOURNAL_PROD("ProdJournalProd"),
    @XmlEnumValue("DEL_InventJournalPickingList")
    DEL_INVENT_JOURNAL_PICKING_LIST("DEL_InventJournalPickingList");
    private final String value;

    AxdEnumInventTransChildType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumInventTransChildType fromValue(String v) {
        for (AxdEnumInventTransChildType c: AxdEnumInventTransChildType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
