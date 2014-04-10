package com.tradedoubler.billing.domain;

import java.util.*;

/**
 * Universally unique identifier
 * <p/>
 * Pattern ^(\\{{0,1}([0-9a-fA-F]){8}-([0-9a-fA-F]){4}-([0-9a-fA-F]){4}-([0-9a-fA-F]){4}-([0-9a-fA-F]){12}\\}{0,1})$
 *
 * @author bjoek
 * @since 2012-06-25
 */
public class Guid {
    private final String guid;

    public Guid(String guid) {
        this.guid = guid.toLowerCase();
    }

    /** Create Guid from a string that does not conform to the guid format */
    public static Guid createGuidFromString(String nonGuidString) {
        return new Guid(UUID.nameUUIDFromBytes(nonGuidString.getBytes()).toString());
    } 
    
    /** Create Guid received from the Ax system (uses capital letters and {} around the guid value) */
    public static Guid createFromAxGuid(String guid) {
        // Remove the braces
        return new Guid(guid.replaceAll("\\{|\\}", ""));
    }

    /** Create Guid received from Oracle DB (uses capital letters and does not have - between values) */
    public static Guid createFromOracleDbGuid(String guid) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(guid.substring(0, 8)).append("-");
        stringBuilder.append(guid.substring(8, 12)).append("-");
        stringBuilder.append(guid.substring(12, 16)).append("-");
        stringBuilder.append(guid.substring(16, 20)).append("-");
        stringBuilder.append(guid.substring(20, 32));
        return new Guid(stringBuilder.toString());
    }

    public String getGuid() {
        return guid;
    }

    /** Capital letters and {} around the guid value */
    public String getGuidForAx() {
        return "{" + guid.toUpperCase() + "}";
    }

    /** Capital letters and does not have - between values */
    public String getGuidForOracleDb() {
        return guid.replaceAll("-", "").toUpperCase();
    }

    @Override
    public String toString() {
        return guid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        return equalsGuid((Guid) o);
    }

    public boolean equalsGuid(Guid other) {
        return equalsCrmGuid(other.guid);
    }

    public boolean equalsCrmGuid(String crmGuid) {
        return this.guid.equalsIgnoreCase(crmGuid);
    }

    public boolean equalsAxGuid(String axGuid) {
        return getGuidForAx().equalsIgnoreCase(axGuid);
    }

    @Override
    public int hashCode() {
        return guid.hashCode();
    }

}
