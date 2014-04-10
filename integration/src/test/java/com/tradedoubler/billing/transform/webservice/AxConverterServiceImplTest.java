package com.tradedoubler.billing.transform.webservice;

import com.tradedoubler.billing.domain.Language;
import com.tradedoubler.billing.service.transform.*;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author bjoek
 * @since 2012-10-29
 */
public class AxConverterServiceImplTest {
    @Test
    public void createStandaloneNonDatabaseInstanceForTestShouldWork() throws Exception {
        AxConverterService converterService = AxConverterServiceImpl.createNonDatabaseInstanceForTest();
        assertThat(converterService, notNullValue());
    }

    @Test
    public void languageConversionShouldOnlyBeSpecialForEnglishAndNorwegian() throws Exception {
        AxConverterService converterService = AxConverterServiceImpl.createNonDatabaseInstanceForTest();
        assertThat(converterService.convert(new Language("SV")), is("SV"));
        assertThat(converterService.convert(new Language("no")), is("nb-no"));
        assertThat(converterService.convert(new Language("nO")), is("nb-no"));
        assertThat(converterService.convert(new Language("en")), is("en-US"));
        assertThat(converterService.convert(new Language("En")), is("en-US"));
    }
}
