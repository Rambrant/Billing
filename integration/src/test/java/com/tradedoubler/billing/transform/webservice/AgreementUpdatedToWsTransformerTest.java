package com.tradedoubler.billing.transform.webservice;

import com.google.gson.Gson;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalescla.AxdEntityMDSSalesClientAgreement;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumAxdEntityAction;
import com.tradedoubler.billing.domain.AgreementUpdated;
import com.tradedoubler.billing.service.transform.*;
import com.tradedoubler.billing.transform.json.gson.GsonFactory;
import com.tradedoubler.testutil.FileUtil;
import org.junit.*;
import org.junit.rules.ErrorCollector;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import static org.junit.Assert.assertEquals;

/**
 * @author bjoek
 * @since 2012-07-03
 */
public class AgreementUpdatedToWsTransformerTest {
    private AgreementUpdated agreementUpdated;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Before
    public void setup() {
        String json = FileUtil.readFileFromClasspath("json-examples/agreement-updated-example.json");
        Gson gson = GsonFactory.getGson();
        agreementUpdated = gson.fromJson(json, AgreementUpdated.class);
    }


    @Test
    public void testTransform() throws Exception {
        AxConverterService converter = AxConverterServiceImpl.createNonDatabaseInstanceForTest();

        AgreementToWsTransformer transformer = new AgreementToWsTransformer(converter, agreementUpdated.getAgreement(), "DataAreaId");

        AxdEntityMDSSalesClientAgreement agreement = transformer.transformForUpdate(new JAXBElement<String>(new QName(""), String.class, "docHash"));

        assertEquals("docHash", agreement.getDocumentHash().getValue());
        assertEquals(AxdEnumAxdEntityAction.UPDATE, agreement.getAction());
        assertEquals("DataAreaId", agreement.getBelongsToDataAreaId());
        assertEquals("entity", agreement.getClazz());
        assertEquals("SEK", agreement.getCurrencyCode());
        assertEquals("Cl42824050", agreement.getCustId());
        assertEquals("Agreement Name Example", agreement.getDescription());
        assertEquals("\\\\someserver\\somefolder\\somefile.pdf", agreement.getDocumentLink().getValue());
        assertEquals("{3F2504E0-4F89-11D3-9A0C-0305E82C3401}", agreement.getInvoiceRuleId());
        assertEquals("3", agreement.getProductTypeId());
        assertEquals("1-1234567896", agreement.getSourceSystemAgreementId());
        assertEquals("2012-06-25", agreement.getValidFrom().toXMLFormat());
        assertEquals("2154-12-31", agreement.getValidTo().toXMLFormat());

    }
}
