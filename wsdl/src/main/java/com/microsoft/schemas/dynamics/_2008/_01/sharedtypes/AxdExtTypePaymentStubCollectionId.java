
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdExtType_PaymentStubCollectionId.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdExtType_PaymentStubCollectionId">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="FIK"/>
 *     &lt;enumeration value="BBS"/>
 *     &lt;enumeration value="ESR_blue_PTT"/>
 *     &lt;enumeration value="ESR_red_bank"/>
 *     &lt;enumeration value="FIK762"/>
 *     &lt;enumeration value="ESR_orange"/>
 *     &lt;enumeration value="BelSMS101"/>
 *     &lt;enumeration value="BelSMS102"/>
 *     &lt;enumeration value="Finnish"/>
 *     &lt;enumeration value="FIK751"/>
 *     &lt;enumeration value="FIK752"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdExtType_PaymentStubCollectionId")
@XmlEnum
public enum AxdExtTypePaymentStubCollectionId {

    @XmlEnumValue("None")
    NONE("None"),
    FIK("FIK"),
    BBS("BBS"),
    @XmlEnumValue("ESR_blue_PTT")
    ESR_BLUE_PTT("ESR_blue_PTT"),
    @XmlEnumValue("ESR_red_bank")
    ESR_RED_BANK("ESR_red_bank"),
    @XmlEnumValue("FIK762")
    FIK_762("FIK762"),
    @XmlEnumValue("ESR_orange")
    ESR_ORANGE("ESR_orange"),
    @XmlEnumValue("BelSMS101")
    BEL_SMS_101("BelSMS101"),
    @XmlEnumValue("BelSMS102")
    BEL_SMS_102("BelSMS102"),
    @XmlEnumValue("Finnish")
    FINNISH("Finnish"),
    @XmlEnumValue("FIK751")
    FIK_751("FIK751"),
    @XmlEnumValue("FIK752")
    FIK_752("FIK752");
    private final String value;

    AxdExtTypePaymentStubCollectionId(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdExtTypePaymentStubCollectionId fromValue(String v) {
        for (AxdExtTypePaymentStubCollectionId c: AxdExtTypePaymentStubCollectionId.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
