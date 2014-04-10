package com.tradedoubler.billing.service.transform;

import com.tradedoubler.billing.domain.ConverterValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains default conversion values which are used if real values cannot be loaded from Pan database
 *
 * @see AxConverterServiceImpl
 * @author bjoek
 * @since 2012-08-17
 */
public class AxConverterDefaultDbValues {
    private final List<ConverterValue<String>> countryCodes = new ArrayList<ConverterValue<String>>();
    private final List<ConverterValue<Integer>> markets = new ArrayList<ConverterValue<Integer>>();

    public AxConverterDefaultDbValues() {
        initializeCountryValues();
        initializeMarkets();
    }

    private void initializeCountryValues() {
        countryCodes.add(new ConverterValue<String>("ARE", "AE"));
        countryCodes.add(new ConverterValue<String>("ARE", "AE"));
        countryCodes.add(new ConverterValue<String>("ANT", "AN"));
        countryCodes.add(new ConverterValue<String>("ARG", "AR"));
        countryCodes.add(new ConverterValue<String>("AUT", "AT"));
        countryCodes.add(new ConverterValue<String>("AUS", "AU"));
        countryCodes.add(new ConverterValue<String>("BEL", "BE"));
        countryCodes.add(new ConverterValue<String>("BGR", "BG"));
        countryCodes.add(new ConverterValue<String>("BRA", "BR"));
        countryCodes.add(new ConverterValue<String>("BHS", "BS"));
        countryCodes.add(new ConverterValue<String>("CAN", "CA"));
        countryCodes.add(new ConverterValue<String>("CHE", "CH"));
        countryCodes.add(new ConverterValue<String>("CHL", "CL"));
        countryCodes.add(new ConverterValue<String>("CHN", "CN"));
        countryCodes.add(new ConverterValue<String>("COL", "CO"));
        countryCodes.add(new ConverterValue<String>("CRI", "CR"));
        countryCodes.add(new ConverterValue<String>("CYP", "CY"));
        countryCodes.add(new ConverterValue<String>("CZE", "CZ"));
        countryCodes.add(new ConverterValue<String>("DEU", "DE"));
        countryCodes.add(new ConverterValue<String>("DNK", "DK"));
        countryCodes.add(new ConverterValue<String>("EST", "EE"));
        countryCodes.add(new ConverterValue<String>("ESP", "ES"));
        countryCodes.add(new ConverterValue<String>("FIN", "FI"));
        countryCodes.add(new ConverterValue<String>("FRA", "FR"));
        countryCodes.add(new ConverterValue<String>("GBR", "GB"));
        countryCodes.add(new ConverterValue<String>("GGY", "GG"));
        countryCodes.add(new ConverterValue<String>("GIB", "GI"));
        countryCodes.add(new ConverterValue<String>("GRL", "GL"));
        countryCodes.add(new ConverterValue<String>("GRC", "GR"));
        countryCodes.add(new ConverterValue<String>("HKG", "HK"));
        countryCodes.add(new ConverterValue<String>("HND", "HN"));
        countryCodes.add(new ConverterValue<String>("HRV", "HR"));
        countryCodes.add(new ConverterValue<String>("IRL", "IE"));
        countryCodes.add(new ConverterValue<String>("ISR", "IL"));
        countryCodes.add(new ConverterValue<String>("IND", "IN"));
        countryCodes.add(new ConverterValue<String>("ISL", "IS"));
        countryCodes.add(new ConverterValue<String>("ITA", "IT"));
        countryCodes.add(new ConverterValue<String>("JEY", "JE"));
        countryCodes.add(new ConverterValue<String>("JOR", "JO"));
        countryCodes.add(new ConverterValue<String>("LTU", "LT"));
        countryCodes.add(new ConverterValue<String>("LUX", "LU"));
        countryCodes.add(new ConverterValue<String>("LVA", "LV"));
        countryCodes.add(new ConverterValue<String>("MAR", "MA"));
        countryCodes.add(new ConverterValue<String>("MLT", "MT"));
        countryCodes.add(new ConverterValue<String>("MEX", "MX"));
        countryCodes.add(new ConverterValue<String>("MYS", "MY"));
        countryCodes.add(new ConverterValue<String>("NLD", "NL"));
        countryCodes.add(new ConverterValue<String>("NOR", "NO"));
        countryCodes.add(new ConverterValue<String>("PAN", "PA"));
        countryCodes.add(new ConverterValue<String>("PER", "PE"));
        countryCodes.add(new ConverterValue<String>("PYF", "PF"));
        countryCodes.add(new ConverterValue<String>("POL", "PL"));
        countryCodes.add(new ConverterValue<String>("PRT", "PT"));
        countryCodes.add(new ConverterValue<String>("PRY", "PY"));
        countryCodes.add(new ConverterValue<String>("ROU", "RO"));
        countryCodes.add(new ConverterValue<String>("RUS", "RU"));
        countryCodes.add(new ConverterValue<String>("SWE", "SE"));
        countryCodes.add(new ConverterValue<String>("SGP", "SG"));
        countryCodes.add(new ConverterValue<String>("SVN", "SI"));
        countryCodes.add(new ConverterValue<String>("SVK", "SK"));
        countryCodes.add(new ConverterValue<String>("SLV", "SV"));
        countryCodes.add(new ConverterValue<String>("TUR", "TR"));
        countryCodes.add(new ConverterValue<String>("USA", "US"));
        countryCodes.add(new ConverterValue<String>("URY", "UY"));
        countryCodes.add(new ConverterValue<String>("VEN", "VE"));
        countryCodes.add(new ConverterValue<String>("VGB", "VG"));
        countryCodes.add(new ConverterValue<String>("VNM", "VN"));
        countryCodes.add(new ConverterValue<String>("ZAF", "ZA"));
    }

    private void initializeMarkets() {
//        Presently not in db
        markets.add(new ConverterValue<Integer>("SE05", 51));
        markets.add(new ConverterValue<Integer>("SE04", 51));
        markets.add(new ConverterValue<Integer>("SE03", 51));
//      End presently not in db

        markets.add(new ConverterValue<Integer>("SE02", 51));
        markets.add(new ConverterValue<Integer>("NO01", 81861));
        markets.add(new ConverterValue<Integer>("DK01", 135827));
        markets.add(new ConverterValue<Integer>("FI01", 135926));
        markets.add(new ConverterValue<Integer>("GB01", 135908));
        markets.add(new ConverterValue<Integer>("DE01", 135899));
        markets.add(new ConverterValue<Integer>("FR01", 135935));
        markets.add(new ConverterValue<Integer>("ES01", 135893));
        markets.add(new ConverterValue<Integer>("NL01", 135942));
        markets.add(new ConverterValue<Integer>("IT01", 279691));
        markets.add(new ConverterValue<Integer>("LT01", 318472));
        markets.add(new ConverterValue<Integer>("PL01", 926898));
        markets.add(new ConverterValue<Integer>("BE01", 392132));
        markets.add(new ConverterValue<Integer>("CH01", 883589));
        markets.add(new ConverterValue<Integer>("RU01", 1060739));
        markets.add(new ConverterValue<Integer>("PT01", 1060740));
        markets.add(new ConverterValue<Integer>("IE01", 279690));
        markets.add(new ConverterValue<Integer>("AT01", 176630));
        markets.add(new ConverterValue<Integer>("BR01", 1648044));
    }

    public List<ConverterValue<String>> getCountryCodes() {
        return countryCodes;
    }

    public List<ConverterValue<Integer>> getMarkets() {
        return markets;
    }

    public List<ConverterValue<Integer>> getPaymentMethods() {
        List<ConverterValue<Integer>> returnValue = new ArrayList<ConverterValue<Integer>>();
        returnValue.add(new ConverterValue<Integer>("BANK", 1));
        returnValue.add(new ConverterValue<Integer>("DD", 2));
        return returnValue;
    }

    public List<ConverterValue<Integer>> getPostingProfiles() {
        List<ConverterValue<Integer>> returnValue = new ArrayList<ConverterValue<Integer>>();
        returnValue.add(new ConverterValue<Integer>("SO_1", 1));
        returnValue.add(new ConverterValue<Integer>("SO_2", 2));
        returnValue.add(new ConverterValue<Integer>("SO_3", 3));
        return returnValue;
    }

    public List<ConverterValue<Integer>> getDistributionModes() {
        List<ConverterValue<Integer>> returnValue = new ArrayList<ConverterValue<Integer>>();
        returnValue.add(new ConverterValue<Integer>("Mail", 1));
        returnValue.add(new ConverterValue<Integer>("Email", 2));
        returnValue.add(new ConverterValue<Integer>("MailAndEmail", 3));
        return returnValue;
    }

}
