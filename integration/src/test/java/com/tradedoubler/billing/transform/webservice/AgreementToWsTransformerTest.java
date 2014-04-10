package com.tradedoubler.billing.transform.webservice;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalescla.AxdEntityMDSSalesClientAgreement;
import com.tradedoubler.billing.domain.Agreement;
import com.tradedoubler.billing.service.transform.AxConverterService;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * @author bjoek
 * @since 2012-09-17
 */
public class AgreementToWsTransformerTest {
    private final AxConverterService converter = mock(AxConverterService.class);

    @Test
    public void testTransformNullValidToAndValidFrom() throws Exception {
        Agreement agreement = new Agreement("sourceSystemAgreementId", "clientId", "invoicingRuleId",
                             "description", 3, 51, "SEK",
                        null, null, "documentLink");
        AgreementToWsTransformer transformer = new AgreementToWsTransformer(converter, agreement, "SE02");
        AxdEntityMDSSalesClientAgreement clientAgreement = transformer.transform();
        assertThat(clientAgreement.getValidFrom().toString(), is("1901-01-01"));
        assertThat(clientAgreement.getValidTo().toString(), is("2154-12-31"));
    }
}
