package com.tradedoubler.billing.validate;

import com.tradedoubler.billing.domain.Guid;

/**
 * Validates that a Crm Guid validates. Example valid Guid: {703B123F-6329-4D79-BFAA-60762A5F6CF4} 
 * 
 * User: erigu
 * Date: 2012-10-22
 */
public class GUIDValidator {

    public static boolean validateGUI(Guid guid){

        return guid.getGuid().matches("^(\\{{0,1}([0-9a-fA-F]){8}-([0-9a-fA-F]){4}-([0-9a-fA-F]){4}-([0-9a-fA-F]){4}-([0-9a-fA-F]){12}\\}{0,1})$");

    }


}
