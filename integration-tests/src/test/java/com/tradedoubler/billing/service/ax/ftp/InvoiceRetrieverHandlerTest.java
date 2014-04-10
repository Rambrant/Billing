package com.tradedoubler.billing.service.ax.ftp;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.platform.flowcontroller.IntegrationMessage;
import com.tradedoubler.billing.platform.flowcontroller.ServiceResult;
import com.tradedoubler.billing.service.ax.ftp.handler.InvoiceFtpHandler;
import com.tradedoubler.billing.service.crm.JsonMessage;
import com.tradedoubler.billing.service.crm.JsonValidatorService;
import com.tradedoubler.billing.validate.JsonValidationProcessor;
import com.tradedoubler.billing.validate.TdJsonSchemaReader;
import com.tradedoubler.billing.validate.Validator;
import com.tradedoubler.testutil.ReflectionHelper;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mule.DefaultMuleEvent;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/** Integration test class for the ftp retrieval/deletes of invoices. */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springBeansContext.xml", "/spring/springServicesContext.xml"})
public class InvoiceRetrieverHandlerTest {  ///billing-integration/integration-tests
    private String ftpRoot = "./billing-integration/integration-tests/src/test/resources/ftp";
    private FTPClient client = new FTPClient();
    private TdJsonSchemaReader tdJsonSchemaReader = new TdJsonSchemaReader();

    @Autowired
    InvoiceFtpHandler invoiceRetrieverHandler;

    @Autowired
    JsonValidatorService jsonValidatorService;

    @Value("${FTP.HOST}")
    private String ftpHost;

    @Value("${FTP.PATH}")
    private String ftpPath;

    @Value("${FTP.USERNAME}")
    private String userName;

    @Value("${FTP.PASSWORD}")
    private String passwd;

    @Before
    public void init() throws Exception {
        if (System.getProperty("basedir") != null) ftpRoot = System.getProperty("basedir") + "/src/test/resources/ftp";
        //Remove all xml-files on ftp dev dir in case some where left
        deleteAllXMLFilesOnFtp();
    }


    @Test
    public void test(){
        String out = removeNonUtf8CompliantCharacters("ÅÄÖåäö");
      Assert.assertNotNull(out);


    }
        private String removeNonUtf8CompliantCharacters(final String inString) {
        if (null == inString) return null;
        byte[] byteArr = inString.getBytes();
        for (int i = 0; i < byteArr.length; i++) {
            byte ch = byteArr[i];

            if (!((ch < 253) || ch == '\t' || ch == '\n' || ch == '\r')) {
                byteArr[i] = ' ';
            }
        }
        return new String(byteArr);
    }
    @Test
    //@Ignore
    public void retrieveInvoiceShouldWork() throws Exception {

//        String[] files = {"MDS_ITG_SalesCustomerInvoice_exempel.xml", "MDS_ITG_SalesCustomerInvoice_exempel_credited.xml", "MDS_ITG_SalesCustomerInvoice_exempel_credited_paid.xml"};
//        String[] files = {"testÅÄÖ.xml"};
        String[] files = {"1364298744998_1363699710517_20130222_080550_7181571_00001.xml"};
        for (String file : files) {
            putFileOnFtp(ftpRoot + "/invoicepool/", file);
            AxInvoice axInvoice = invoiceRetrieverHandler.fetchInvoice();
            assertNotNull(axInvoice);
            invoiceRetrieverHandler.doTransformation(axInvoice);

            assertNotNull(axInvoice.getInvoice());
            assertTrue(axInvoice.getFileName().endsWith("xml"));
            assertTrue(axInvoice.getInvoiceXml().startsWith("<?xml version"));
            deleteFileOnFtp(file);
        }
    }

    @Test
    //@Ignore
    public void moveInvoiceShouldWork() throws Exception {

        String file = "test_paid.xml";
        putFileOnFtp(ftpRoot + "/invoicepool/", file);
        AxInvoice axInvoice = invoiceRetrieverHandler.fetchInvoice();
        assertNotNull(axInvoice);
        invoiceRetrieverHandler.doTransformation(axInvoice);

        invoiceRetrieverHandler.moveFailedInvoice(axInvoice, "");
        System.out.println("InvoiceRetrieverHandlerTest.moveInvoiceShouldWork");
    }

    @Test
    //@Ignore
    public void updateForecast() throws Exception {
        //Event = Posted
        String file = "test_posted.xml";
        putFileOnFtp(ftpRoot + "/invoicepool/", file);

        AxInvoice axInvoice = invoiceRetrieverHandler.fetchInvoice();
        invoiceRetrieverHandler.doTransformation(axInvoice);

//        Map<String, JsonMessage> mapOfForecasts = axInvoice.getUpdateForecasts();

//        JsonValidationProcessor jsonValidationProcessor = new JsonValidationProcessor();
        ServiceResult serviceResult = createServiceResultForForecasts(axInvoice);


//            MuleEvent event = jsonValidationProcessor.process(createMuleEvent(serviceResult));
        serviceResult = jsonValidatorService.validateUpdateForecast(serviceResult);
        serviceResult = jsonValidatorService.validateUpdateForecast(serviceResult);

//            assertTrue(event.getMessage().getPayload() instanceof ServiceResult);
        assertFalse(serviceResult.isBugDisturbance());
        deleteFileOnFtp(file);

    }


    @Test
    //@Ignore

    public void testDomainObject() throws Exception {


        String file = "MDS_ITG_SalesCustomerInvoice_exempel_credited_paid.xml";

        putFileOnFtp(ftpRoot + "/invoicepool/", file);

        AxInvoice axInvoice = invoiceRetrieverHandler.fetchInvoice();
        invoiceRetrieverHandler.doTransformation(axInvoice);

        assertNotNull(axInvoice);
        assertNotNull(axInvoice.getInvoice());
        assertEquals("SE100000018", axInvoice.getInvoice().getInvoiceId());
        assertEquals("SE100000018", axInvoice.getInvoice().getInvoiceId());

        assertEquals(0, BigDecimal.valueOf(767.00).compareTo(axInvoice.getInvoice().getNetAmount()));
        assertEquals(0, BigDecimal.valueOf(191.75).compareTo(axInvoice.getInvoice().getVat()));
        assertEquals(0, BigDecimal.valueOf(0.00).compareTo(axInvoice.getInvoice().getAmountOpen()));
        assertEquals("SEK", axInvoice.getInvoice().getCurrency());
        assertEquals("PAID", axInvoice.getInvoice().getEvent().name());

        assertEquals(1, axInvoice.getInvoice().getInvoicedAgreements().size());
        InvoicedAgreement invoicedAgreement = axInvoice.getInvoice().getInvoicedAgreements().get(0);
        assertEquals("TTHHQXTScafebabe1003", invoicedAgreement.getSourceSystemAgreementID().trim());
        assertEquals(0, BigDecimal.valueOf(-7055.33).compareTo(invoicedAgreement.getGP()));

        assertEquals(1, invoicedAgreement.getInvoicedOrderLines().size());
        InvoicedOrderLine invoicedOrderLine = invoicedAgreement.getInvoicedOrderLines().get(0);
        assertEquals("SE100000018", invoicedOrderLine.getInvoiceId());
        assertEquals("0000000027", invoicedOrderLine.getOrderLineId());
        assertEquals(51, invoicedOrderLine.getMarket().getOrganizationId());
        assertEquals("SEK", invoicedOrderLine.getCurrencyCode().getCurrencyCode());


        deleteFileOnFtp(file);


    }

//    @Test
//    //@Ignore
//
//    public void deleteInvoiceShouldWork() {
//        String file = "InvoiceForDeleteTest.xml";
//        try {
//            //Copy invoice-file to test area first
//            putFileOnFtp(ftpRoot + "/invoicepool/", file);
//
//            AxInvoice invoiceToBeDeleted = new AxInvoice();
//            invoiceToBeDeleted.setFileName(file);
//
//            invoiceRetrieverHandler.deleteInvoice(invoiceToBeDeleted);
//
//            ///Assert existence of file here
//        } catch (Exception e) {
//            deleteFileOnFtp(file);
//        }
//
//    }

    @Test
    //@Ignore
    public void createJsonShouldWork() throws Exception {
        //Event = Posted
        String file = "test_posted.xml";
        putFileOnFtp(ftpRoot + "/invoicepool/", file);

        AxInvoice axInvoice = invoiceRetrieverHandler.fetchInvoice();
        invoiceRetrieverHandler.doTransformation(axInvoice);

        String json = axInvoice.getInvoiceJson().toString();
        assertNotNull(json);
//        assertTrue(json.contains(getInvoiceJsonComare()));
        JsonValidationProcessor jsonValidationProcessor = new JsonValidationProcessor();
        Validator validator = new Validator();
        new ReflectionHelper(validator).setField(tdJsonSchemaReader);
        new ReflectionHelper(jsonValidationProcessor).setField(validator);
        jsonValidationProcessor.setJsonSchemaPath("validation/schema/billing/create-invoice-information-schema.json");
        ServiceResult serviceResult = createServiceResult(json);
        MuleEvent event = jsonValidationProcessor.process(createMuleEvent(serviceResult));
        assertTrue(event.getMessage().getPayload() instanceof ServiceResult);
        assertFalse(serviceResult.isBugDisturbance());
        deleteFileOnFtp(file);
    }

    @Test
    //@Ignore
    public void updateJsonShouldWork() throws Exception {

        //Event = Paid
        String file = "test_paid.xml";
        putFileOnFtp(ftpRoot + "/invoicepool/", file);

        AxInvoice axInvoice = invoiceRetrieverHandler.fetchInvoice();
        invoiceRetrieverHandler.doTransformation(axInvoice);

        String json = axInvoice.getInvoiceJson().toString();
        assertNotNull(json);
//        assertTrue(json.contains(getInvoiceUpdateJsonCompare()));
        JsonValidationProcessor jsonValidationProcessor = new JsonValidationProcessor();
        Validator validator = new Validator();
        new ReflectionHelper(validator).setField(tdJsonSchemaReader);
        new ReflectionHelper(jsonValidationProcessor).setField(validator);
        jsonValidationProcessor.setJsonSchemaPath("validation/schema/billing/update-invoice-information-schema.json");
        ServiceResult serviceResult = createServiceResult(json);
        MuleEvent event = jsonValidationProcessor.process(createMuleEvent(serviceResult));
        assertTrue(event.getMessage().getPayload() instanceof ServiceResult);
        assertFalse(serviceResult.isBugDisturbance());
        deleteFileOnFtp(file);
    }

    @Test
    //@Ignore
    public void updateWriteOffJsonShouldWork() throws Exception {

        //Event = WriteOff
        String file = "test_writeoff.xml";
        putFileOnFtp(ftpRoot + "/invoicepool/", file);

        AxInvoice axInvoice = invoiceRetrieverHandler.fetchInvoice();
        invoiceRetrieverHandler.doTransformation(axInvoice);

        String json = axInvoice.getInvoiceJson().toString();
        assertNotNull(json);
//        assertTrue(json.contains(getInvoiceUpdateJsonCompare()));
        JsonValidationProcessor jsonValidationProcessor = new JsonValidationProcessor();
        Validator validator = new Validator();
        new ReflectionHelper(validator).setField(tdJsonSchemaReader);
        new ReflectionHelper(jsonValidationProcessor).setField(validator);
        jsonValidationProcessor.setJsonSchemaPath("validation/schema/billing/update-invoice-information-schema.json");
        ServiceResult serviceResult = createServiceResult(json);
        MuleEvent event = jsonValidationProcessor.process(createMuleEvent(serviceResult));
        assertTrue(event.getMessage().getPayload() instanceof ServiceResult);
        assertFalse(serviceResult.isBugDisturbance());
        deleteFileOnFtp(file);
    }


    private MuleEvent createMuleEvent(ServiceResult serviceResult) {
        MuleMessage muleMessage = new DefaultMuleMessage(serviceResult, mock(MuleContext.class));
        return new DefaultMuleEvent(muleMessage, mock(MuleEvent.class));
    }

    private ServiceResult createServiceResultForForecasts(AxInvoice axInvoice) {
        ServiceResult serviceResult = new ServiceResult();
        IntegrationMessage integrationMessage = new IntegrationMessage("1", new MetaData("", new Guid(""), new Timestamp(), "", ""));
        integrationMessage.setDomainObject(axInvoice);
        serviceResult.setIntegrationMessage(integrationMessage);
        return serviceResult;
    }

    private ServiceResult createServiceResult(String json) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setRawData(new JsonMessage(json));
        return serviceResult;
    }

    private void putFileOnFtp(String localDir, String fileName) {
//        FTPClient client = new FTPClient();
        FileInputStream fileInputStream = null;

        try {
            client.connect(ftpHost);
            client.login(userName, passwd);

            client.changeWorkingDirectory(ftpPath);
            //
            // Create an InputStream of the file to be uploaded
            //
            fileInputStream = new FileInputStream(localDir + fileName);

            //
            // Store file to server
            //

            client.storeFile(fileName, fileInputStream);
            client.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteFileOnFtp(String fileName) {

        try {
            client.connect(ftpHost);
            client.login(userName, passwd);

            client.changeWorkingDirectory(ftpPath);
            //
            // Create an InputStream of the file to be uploaded
            //
            client.deleteFile(fileName);

            client.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void deleteAllXMLFilesOnFtp() throws IOException {

        try {
            client.connect(ftpHost);
            client.login(userName, passwd);

            client.changeWorkingDirectory(ftpPath);

            FTPFile[] list = client.listFiles();
            for (FTPFile file : list) {

                if (file.isFile()) {

                    String fileName = file.getName();
                    fileName = fileName == null ? "" : fileName.trim();
                    if (fileName.endsWith(".xml")) {
                        client.deleteFile(file.getName());
                    }
                }
            }

            client.logout();

        } finally {
            try {
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

