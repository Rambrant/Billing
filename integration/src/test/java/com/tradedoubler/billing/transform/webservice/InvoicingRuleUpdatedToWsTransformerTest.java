package com.tradedoubler.billing.transform.webservice;

import com.google.gson.Gson;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr.*;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.*;
import com.tradedoubler.billing.domain.InvoicingRuleUpdated;
import com.tradedoubler.billing.service.transform.*;
import com.tradedoubler.billing.transform.json.gson.GsonFactory;
import com.tradedoubler.testutil.FileUtil;
import org.junit.*;
import org.junit.rules.ErrorCollector;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author bjoek
 * @since 2012-07-02
 */
public class InvoicingRuleUpdatedToWsTransformerTest {

    private InvoicingRuleUpdated invoicingRuleUpdated;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Before
    public void setup() {
        String json = FileUtil.readFileFromClasspath("json-examples/invoicing-rule-created-example.json");
        Gson gson = GsonFactory.getGson();
        invoicingRuleUpdated = gson.fromJson(json, InvoicingRuleUpdated.class);
    }

    @Test
    public void testTransform() throws Exception {
        AxConverterService converter = AxConverterServiceImpl.createNonDatabaseInstanceForTest();

        InvoicingRuleToAxSalesInvoiceRuleTransformer transformer = new InvoicingRuleToAxSalesInvoiceRuleTransformer(converter, invoicingRuleUpdated.getInvoicingRule(), "18811826");
        AxdEntityMDSSalesInvoiceRule salesInvoiceRule = transformer.transformForUpdate("docHash");

        collector.checkThat(salesInvoiceRule.getBelongsToDataAreaId().getValue(), is("18811826"));
        collector.checkThat(salesInvoiceRule.getAction(), is(AxdEnumAxdEntityAction.UPDATE));
        collector.checkThat(salesInvoiceRule.getClazz(), is("entity"));
        collector.checkThat(salesInvoiceRule.getCurrencyCode(), is("EUR"));
        collector.checkThat(salesInvoiceRule.getCustomerReference().getValue(), is("Lasse Volvosson"));
        collector.checkThat(salesInvoiceRule.getDescription().getValue(), is("Used in unit tests - do not edit"));
        collector.checkThat(salesInvoiceRule.getDeviatingExchRate(), is(AxdExtTypeMDSSalesInvoiceRuleDeviatingExchRate.NO));
        collector.checkThat(salesInvoiceRule.getDisplayTDComission(), is(AxdExtTypeMDSSalesInvoiceRuleDisplayTDComission.YES));
        collector.checkThat(salesInvoiceRule.getDistributionMode(), is(AxdEnumMDSSalesInvoiceRuleDistributionMode.MAIL));
        collector.checkThat(salesInvoiceRule.getInvoiceRuleId(), is("{F3DE63DF-24E5-E111-8B5B-005056B45DA6}"));
        collector.checkThat(salesInvoiceRule.getIssuerReference().getValue(), is("Maria Lind"));
        collector.checkThat(salesInvoiceRule.getName(), is("Volvo - do not edit"));
        collector.checkThat(salesInvoiceRule.getPaymModeId().getValue(), is("DD"));
        collector.checkThat(salesInvoiceRule.getPaymTermId(), is("30"));
        collector.checkThat(salesInvoiceRule.getPostingProfile(), is("SO_1"));
        collector.checkThat(salesInvoiceRule.getRevenueTypeId(), is("1"));

        List<AxdEntityMDSSalesInvoiceMessage> mdsSalesInvoiceMessage = salesInvoiceRule.getMDSSalesInvoiceMessage();
        collector.checkThat(mdsSalesInvoiceMessage.size(), is(5));
        AxdEntityMDSSalesInvoiceMessage message = mdsSalesInvoiceMessage.get(0);

        collector.checkThat(message.getClazz(), is("entity"));
        collector.checkThat(message.getAction(), is(AxdEnumAxdEntityAction.UPDATE));
        collector.checkThat(message.getInvoiceMessageId(), is("{451C9139-40E5-E111-8B5B-005056B45DA6}"));
        collector.checkThat(message.getSourceType(), is(AxdEnumMDSSalesMessageSourceType.INVOICE_RULE));
        collector.checkThat(message.getText(), is("This is a text to be printed on all invoices for this invoicing rule"));
        collector.checkThat(message.getValidFrom().toXMLFormat(), is("2012-08-13"));
        collector.checkThat(message.getValidTo().toXMLFormat(), is("2012-08-30"));

    }
}
