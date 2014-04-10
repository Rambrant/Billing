//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.28 at 01:35:45 PM CET 
//


package com.tradedoubler.customerinvoice;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_ProjItemType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_ProjItemType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Project"/>
 *     &lt;enumeration value="SalesOrder"/>
 *     &lt;enumeration value="InventJournal"/>
 *     &lt;enumeration value="PurchOrder"/>
 *     &lt;enumeration value="Production"/>
 *     &lt;enumeration value="ProdLine"/>
 *     &lt;enumeration value="BeginningBalance"/>
 *     &lt;enumeration value="VendorInvoice"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_ProjItemType")
@XmlEnum
public enum AxdEnumProjItemType {

    @XmlEnumValue("Project")
    PROJECT("Project"),
    @XmlEnumValue("SalesOrder")
    SALES_ORDER("SalesOrder"),
    @XmlEnumValue("InventJournal")
    INVENT_JOURNAL("InventJournal"),
    @XmlEnumValue("PurchOrder")
    PURCH_ORDER("PurchOrder"),
    @XmlEnumValue("Production")
    PRODUCTION("Production"),
    @XmlEnumValue("ProdLine")
    PROD_LINE("ProdLine"),
    @XmlEnumValue("BeginningBalance")
    BEGINNING_BALANCE("BeginningBalance"),
    @XmlEnumValue("VendorInvoice")
    VENDOR_INVOICE("VendorInvoice");
    private final String value;

    AxdEnumProjItemType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumProjItemType fromValue(String v) {
        for (AxdEnumProjItemType c: AxdEnumProjItemType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}