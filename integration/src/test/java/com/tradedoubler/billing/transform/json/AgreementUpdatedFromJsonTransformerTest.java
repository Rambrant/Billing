package com.tradedoubler.billing.transform.json;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.service.crm.JsonMessage;
import com.tradedoubler.testutil.*;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author bjoek
 * @since 2012-07-04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext-test.xml",
        "/spring/springBeansContext.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class AgreementUpdatedFromJsonTransformerTest {
    @Autowired
    private ApplicationContext applicationContext;

    private AgreementUpdatedFromJsonTransformer transformer;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Before
    public void setUp() throws Exception {
        ApplicationContextUtil contextUtil = new ApplicationContextUtil(applicationContext);
        transformer = contextUtil.registerAnnotatedBean(AgreementUpdatedFromJsonTransformer.class);
    }

    @Test
    public void testEmptyJson() throws Exception {
        JsonMessage jsonMessage = new JsonMessage("");
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setRawData(jsonMessage);

        ServiceResult result = (ServiceResult) transformer.doTransform(serviceResult, "UTF-8");
        assertNull(result.getIntegrationMessage());
        collector.checkThat(result.isBugDisturbance(), is(true));
        assertThat(result.getErrorMessage(), is("Was not able to transform class class com.tradedoubler.billing.domain.AgreementUpdated"));
    }

    @Test
    public void testExampleJson() throws Exception {
        String json = FileUtil.readFileFromClasspath("json-examples/agreement-updated-example.json");
        JsonMessage jsonMessage = new JsonMessage(json);
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setRawData(jsonMessage);


        ServiceResult result = (ServiceResult) transformer.doTransform(serviceResult, "UTF-8");
        AgreementUpdated agreementUpdated = (AgreementUpdated) result.getIntegrationMessage().getDomainObject();

        Agreement agreement = agreementUpdated.getAgreement();

        collector.checkThat(agreement.getCurrencyCode().getCurrencyCode(), is("SEK"));
        collector.checkThat(agreement.getDocumentLink(), is("\\\\someserver\\somefolder\\somefile.pdf"));
        collector.checkThat(agreement.getClientId(), is("Cl42824050"));
        collector.checkThat(agreement.getDescription(), is("Agreement Name Example"));
        collector.checkThat(agreement.getSourceSystemAgreementId(), is("1-1234567896"));
        collector.checkThat(agreement.getValidFrom().getTimestamp(), is("2012-06-25T15:30:01.999+02:00"));
        collector.checkThat(agreement.getValidTo(), nullValue());
        collector.checkThat(agreement.getInvoicingRuleId().getGuid(), is("3f2504e0-4f89-11d3-9a0c-0305e82c3401"));
        collector.checkThat(agreement.getMarketId().getOrganizationId(), is(51));
        collector.checkThat(agreement.getProductType().getValue(), is(3));
    }
}

