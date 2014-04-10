
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_DOCommonSyncStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_DOCommonSyncStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Success"/>
 *     &lt;enumeration value="Error"/>
 *     &lt;enumeration value="ClientServerConflict"/>
 *     &lt;enumeration value="ErrorWhileDownload"/>
 *     &lt;enumeration value="DeletedOnClient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_DOCommonSyncStatus")
@XmlEnum
public enum AxdEnumDOCommonSyncStatus {

    @XmlEnumValue("Success")
    SUCCESS("Success"),
    @XmlEnumValue("Error")
    ERROR("Error"),
    @XmlEnumValue("ClientServerConflict")
    CLIENT_SERVER_CONFLICT("ClientServerConflict"),
    @XmlEnumValue("ErrorWhileDownload")
    ERROR_WHILE_DOWNLOAD("ErrorWhileDownload"),
    @XmlEnumValue("DeletedOnClient")
    DELETED_ON_CLIENT("DeletedOnClient");
    private final String value;

    AxdEnumDOCommonSyncStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumDOCommonSyncStatus fromValue(String v) {
        for (AxdEnumDOCommonSyncStatus c: AxdEnumDOCommonSyncStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
