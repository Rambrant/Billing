package com.tradedoubler.billing.transform.webservice;

import com.google.gson.Gson;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalescla.AxdEntityMDSSalesClientAgreement;
import com.tradedoubler.billing.domain.InvoicingRuleCreated;
import com.tradedoubler.billing.service.transform.*;
import com.tradedoubler.billing.transform.json.gson.GsonFactory;
import com.tradedoubler.testutil.FileUtil;
import org.junit.*;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author bjoek
 * @since 2012-07-03
 */
public class AgreementCreatedToWsTransformerTest {
    private InvoicingRuleCreated invoicingRuleCreated;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Before
    public void setup() {
        String json = FileUtil.readFileFromClasspath("json-examples/invoicing-rule-created-example.json");
        Gson gson = GsonFactory.getGson();
        invoicingRuleCreated = gson.fromJson(json, InvoicingRuleCreated.class);
    }


    @Test
    public void testTransform() throws Exception {
        AxConverterService converter = AxConverterServiceImpl.createNonDatabaseInstanceForTest();

        AgreementToWsTransformer transformer = new AgreementToWsTransformer(converter, invoicingRuleCreated.getAgreement(), "DataAreaId");

        AxdEntityMDSSalesClientAgreement agreement = transformer.transform();

        collector.checkThat(agreement.getBelongsToDataAreaId(), is("DataAreaId"));
        collector.checkThat(agreement.getClazz(), is("entity"));
        collector.checkThat(agreement.getCurrencyCode(), is("EUR"));
        collector.checkThat(agreement.getCustId(), is("49135002"));
        collector.checkThat(agreement.getDescription(), is("German opportunity - do not edit, used in unit tests"));
        collector.checkThat(agreement.getDocumentLink().getValue(), is(""));
        collector.checkThat(agreement.getInvoiceRuleId(), is("{F3DE63DF-24E5-E111-8B5B-005056B45DA6}"));
        collector.checkThat(agreement.getProductTypeId(), is("6"));
        collector.checkThat(agreement.getSourceSystemAgreementId(), is("1-888111"));
        collector.checkThat(agreement.getValidFrom().toXMLFormat(), is("2012-08-15"));
        collector.checkThat(agreement.getValidTo().toXMLFormat(), is("2012-08-29"));
    }
}
