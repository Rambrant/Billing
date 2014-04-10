package com.tradedoubler.billing.service;

/**
 * Utility methods for Spring parameters
 * @author bjoek
 * @since 2012-10-15
 */
public class ParameterUtil {
    /** Make sure that the parameter is initialized from property file */
    public static void checkParameter(String parameter) {
        if (parameter.isEmpty() || parameter.startsWith("$")) {
            throw new IllegalStateException("Parameter not initialized");
        }
    }

    /** Make sure that the parameter is initialized from property file */
    public static void checkParameter(int parameter) {
        if (parameter == 0) {
            throw new IllegalStateException("Parameter not initialized");
        }
    }

}
