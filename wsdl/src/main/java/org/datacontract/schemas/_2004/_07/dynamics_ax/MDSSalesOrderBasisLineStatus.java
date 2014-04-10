
package org.datacontract.schemas._2004._07.dynamics_ax;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MDS_SalesOrderBasisLineStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MDS_SalesOrderBasisLineStatus">
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
@XmlType(name = "MDS_SalesOrderBasisLineStatus")
@XmlEnum
public enum MDSSalesOrderBasisLineStatus {

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

    MDSSalesOrderBasisLineStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MDSSalesOrderBasisLineStatus fromValue(String v) {
        for (MDSSalesOrderBasisLineStatus c: MDSSalesOrderBasisLineStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
