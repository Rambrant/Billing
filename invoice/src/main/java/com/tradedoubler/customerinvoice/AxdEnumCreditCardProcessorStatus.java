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
 * <p>Java class for AxdEnum_CreditCardProcessorStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_CreditCardProcessorStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NA"/>
 *     &lt;enumeration value="Approved"/>
 *     &lt;enumeration value="Declined"/>
 *     &lt;enumeration value="Error"/>
 *     &lt;enumeration value="Settled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_CreditCardProcessorStatus")
@XmlEnum
public enum AxdEnumCreditCardProcessorStatus {

    NA("NA"),
    @XmlEnumValue("Approved")
    APPROVED("Approved"),
    @XmlEnumValue("Declined")
    DECLINED("Declined"),
    @XmlEnumValue("Error")
    ERROR("Error"),
    @XmlEnumValue("Settled")
    SETTLED("Settled");
    private final String value;

    AxdEnumCreditCardProcessorStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumCreditCardProcessorStatus fromValue(String v) {
        for (AxdEnumCreditCardProcessorStatus c: AxdEnumCreditCardProcessorStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
