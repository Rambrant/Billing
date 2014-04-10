package com.tradedoubler.billing.util;

/**
 * @author Thomas Rambrant (thore)
 */

public class IntegrationPointUtil
{
    public static <T> String createId( Class<T> classType, String methodName)
    {
        return classType.getSimpleName() + "." + methodName;
    }
}
