
package org.datacontract.schemas._2004._07.dynamics_ax;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MDS_ITG_SalesOrderBasisLineImportError.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MDS_ITG_SalesOrderBasisLineImportError">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FieldLength"/>
 *     &lt;enumeration value="UpdateSuccessful"/>
 *     &lt;enumeration value="UpdateFailed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MDS_ITG_SalesOrderBasisLineImportError")
@XmlEnum
public enum MDSITGSalesOrderBasisLineImportError {

    @XmlEnumValue("FieldLength")
    FIELD_LENGTH("FieldLength"),
    @XmlEnumValue("UpdateSuccessful")
    UPDATE_SUCCESSFUL("UpdateSuccessful"),
    @XmlEnumValue("UpdateFailed")
    UPDATE_FAILED("UpdateFailed");
    private final String value;

    MDSITGSalesOrderBasisLineImportError(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MDSITGSalesOrderBasisLineImportError fromValue(String v) {
        for (MDSITGSalesOrderBasisLineImportError c: MDSITGSalesOrderBasisLineImportError.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
