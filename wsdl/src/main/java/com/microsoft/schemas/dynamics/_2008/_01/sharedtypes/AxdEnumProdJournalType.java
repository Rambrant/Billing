
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_ProdJournalType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_ProdJournalType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Picklist"/>
 *     &lt;enumeration value="ReportFinished"/>
 *     &lt;enumeration value="RouteCard"/>
 *     &lt;enumeration value="JobCard"/>
 *     &lt;enumeration value="DEL_PmfCoByProduct"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_ProdJournalType")
@XmlEnum
public enum AxdEnumProdJournalType {

    @XmlEnumValue("Picklist")
    PICKLIST("Picklist"),
    @XmlEnumValue("ReportFinished")
    REPORT_FINISHED("ReportFinished"),
    @XmlEnumValue("RouteCard")
    ROUTE_CARD("RouteCard"),
    @XmlEnumValue("JobCard")
    JOB_CARD("JobCard"),
    @XmlEnumValue("DEL_PmfCoByProduct")
    DEL_PMF_CO_BY_PRODUCT("DEL_PmfCoByProduct");
    private final String value;

    AxdEnumProdJournalType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumProdJournalType fromValue(String v) {
        for (AxdEnumProdJournalType c: AxdEnumProdJournalType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
