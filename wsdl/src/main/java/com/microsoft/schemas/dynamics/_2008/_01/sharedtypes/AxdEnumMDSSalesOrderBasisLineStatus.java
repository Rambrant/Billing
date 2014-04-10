
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_MDS_SalesOrderBasisLineStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_MDS_SalesOrderBasisLineStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Processed"/>
 *     &lt;enumeration value="Unprocessed"/>
 *     &lt;enumeration value="Error"/>
 *     &lt;enumeration value="ReadyForReprocess"/>
 *     &lt;enumeration value="Hold"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_MDS_SalesOrderBasisLineStatus")
@XmlEnum
public enum AxdEnumMDSSalesOrderBasisLineStatus {

    @XmlEnumValue("Processed")
    PROCESSED("Processed"),
    @XmlEnumValue("Unprocessed")
    UNPROCESSED("Unprocessed"),
    @XmlEnumValue("Error")
    ERROR("Error"),
    @XmlEnumValue("ReadyForReprocess")
    READY_FOR_REPROCESS("ReadyForReprocess"),
    @XmlEnumValue("Hold")
    HOLD("Hold");
    private final String value;

    AxdEnumMDSSalesOrderBasisLineStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumMDSSalesOrderBasisLineStatus fromValue(String v) {
        for (AxdEnumMDSSalesOrderBasisLineStatus c: AxdEnumMDSSalesOrderBasisLineStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
