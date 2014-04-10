package com.tradedoubler.billing.transform.ftp;

import com.tradedoubler.billing.domain.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * User: erigu
 * Date: 2012-10-18
 */
public class InvoicedOrderLinesToCRMUpdateForecastTransformerTest {

    @Test
    public void testExecuteRevenusesAndSUF() throws Exception {
        List<InvoicedOrderLine> orderLineList = createMockedOrderLineListForRevenusesAndSUF();
        MetaData metaData = new MetaData("", new Guid("C6A4FE8E-C44F-408F-BC9A-19C8C6A4FE8E"), new Timestamp(), "", "");
        InvoicedOrderLinesToCRMUpdateForecastTransformer transformer = new InvoicedOrderLinesToCRMUpdateForecastTransformer(orderLineList, metaData);
        Map<String, UpdateForecast> agreementUpdateForecastmap = transformer.execute();
        assertNotNull(transformer.getListOfUpdatedForecastJson());
        BigDecimal[] expectedSuf = {BigDecimal.valueOf(90), BigDecimal.valueOf(180), BigDecimal.valueOf(0)};
        BigDecimal[] expectedFixedAndOtherRevenue = {BigDecimal.valueOf(100), BigDecimal.valueOf(200), BigDecimal.valueOf(0)};
        BigDecimal[] expectedTransactionalRevenue = {BigDecimal.valueOf(300), BigDecimal.valueOf(0), BigDecimal.valueOf(300)};
        int i = 0;
        for (UpdateForecast updateForecast : agreementUpdateForecastmap.values()) {
            MonthlyForecast monthlyForecast = updateForecast.getMonthlyForecast();
            assertEquals(expectedSuf[i], monthlyForecast.getSuf().getValue());
            assertEquals(expectedFixedAndOtherRevenue[i], monthlyForecast.getFixedAndOtherRevenue().getValue());
            assertEquals(expectedTransactionalRevenue[i], monthlyForecast.getTransactionalRevenue().getValue());
            assertEquals(BigDecimal.valueOf(0), monthlyForecast.getTradedoublerCommission().getValue());
            assertEquals(BigDecimal.valueOf(0), monthlyForecast.getAccountManagement().getValue());
            assertEquals(BigDecimal.valueOf(0), monthlyForecast.getConsulting().getValue());
            assertEquals(BigDecimal.valueOf(0), monthlyForecast.getMinimumTransactionFee().getValue());
            assertEquals(BigDecimal.valueOf(0), monthlyForecast.getNetworkFee().getValue());
            assertEquals(BigDecimal.valueOf(0), monthlyForecast.getOther().getValue());

            i++;
        }

        assertEquals(2, transformer.getListOfUpdatedForecastJson().size());
        //Expected 90, 180, 300
        System.out.println("InvoicedOrderLinesToCRMUpdateForecastTransformerTest.testExecute");
    }


    @Test
    public void testExecuteFeesAndOther() throws Exception {
        List<InvoicedOrderLine> orderLineList = createMockedOrderLineListForFeesAndOther();
        MetaData metaData = new MetaData("", new Guid("C6A4FE8E-C44F-408F-BC9A-19C8C6A4FE8E"), new Timestamp(), "", "");
        InvoicedOrderLinesToCRMUpdateForecastTransformer transformer = new InvoicedOrderLinesToCRMUpdateForecastTransformer(orderLineList, metaData);
        Map<String, UpdateForecast> agreementUpdateForecastmap = transformer.execute();
        assertNotNull(transformer.getListOfUpdatedForecastJson());

        BigDecimal[] expectedAccountManagement={BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(730)};
        BigDecimal[] expectedConsulting = {BigDecimal.valueOf(640), BigDecimal.valueOf(450), BigDecimal.valueOf(0)};
        BigDecimal[] expectedFilehostingFee = {BigDecimal.valueOf(90), BigDecimal.valueOf(180), BigDecimal.valueOf(0)};
        BigDecimal[] minimumTransactionFee = {BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0)};
        BigDecimal[] netWorkFee = {BigDecimal.valueOf(270), BigDecimal.valueOf(0), BigDecimal.valueOf(0)};
        BigDecimal[] expectedOther = {BigDecimal.valueOf(360), BigDecimal.valueOf(0), BigDecimal.valueOf(0)};

        assertEquals(3, agreementUpdateForecastmap.values().size());

        int i = 0;
        for (UpdateForecast updateForecast : agreementUpdateForecastmap.values()) {
            MonthlyForecast monthlyForecast = updateForecast.getMonthlyForecast();
            assertEquals(expectedAccountManagement[i], monthlyForecast.getAccountManagement().getValue());
            assertEquals(expectedConsulting[i], monthlyForecast.getConsulting().getValue());
            assertEquals(expectedFilehostingFee[i], monthlyForecast.getFilehostingFee().getValue());
            assertEquals(minimumTransactionFee[i], monthlyForecast.getMinimumTransactionFee().getValue());
            assertEquals(netWorkFee[i], monthlyForecast.getNetworkFee().getValue());
            assertEquals(expectedOther[i], monthlyForecast.getOther().getValue());

            i++;
        }

        //Expected 90, 180, 300
        System.out.println("InvoicedOrderLinesToCRMUpdateForecastTransformerTest.testExecute");
    }
    @Test
    public void testTradedoublerCommission() throws Exception {
        List<InvoicedOrderLine> orderLineList = createMockedOrderLineListForTradeDoublerCommission();
        MetaData metaData = new MetaData("", new Guid("C6A4FE8E-C44F-408F-BC9A-19C8C6A4FE8E"), new Timestamp(), "", "");
        InvoicedOrderLinesToCRMUpdateForecastTransformer transformer = new InvoicedOrderLinesToCRMUpdateForecastTransformer(orderLineList, metaData);
        Map<String, UpdateForecast> agreementUpdateForecastmap = transformer.execute();
        assertNotNull(transformer.getListOfUpdatedForecastJson());
        String[] salesPart = {"1","2","3","4","5","6","7","335","350"};

        BigDecimal[] expectedAccountManagement={BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0)};
        BigDecimal[] expectedConsulting = {BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0)};
        BigDecimal[] expectedFilehostingFee = {BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0)};
        BigDecimal[] minimumTransactionFee = {BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0)};
        BigDecimal[] netWorkFee = {BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0)};
        BigDecimal[] expectedOther = {BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0)};
        BigDecimal[] expectedTDCommission = {BigDecimal.valueOf(1360), BigDecimal.valueOf(630), BigDecimal.valueOf(2611)};

        assertEquals(3, agreementUpdateForecastmap.values().size());

        int i = 0;
        for (UpdateForecast updateForecast : agreementUpdateForecastmap.values()) {
            MonthlyForecast monthlyForecast = updateForecast.getMonthlyForecast();
            assertEquals(expectedAccountManagement[i], monthlyForecast.getAccountManagement().getValue());
            assertEquals(expectedConsulting[i], monthlyForecast.getConsulting().getValue());
            assertEquals(expectedFilehostingFee[i], monthlyForecast.getFilehostingFee().getValue());
            assertEquals(minimumTransactionFee[i], monthlyForecast.getMinimumTransactionFee().getValue());
            assertEquals(netWorkFee[i], monthlyForecast.getNetworkFee().getValue());
            assertEquals(expectedOther[i], monthlyForecast.getOther().getValue());
            assertEquals(expectedTDCommission[i], monthlyForecast.getTradedoublerCommission().getValue());

            i++;
        }

        //Expected 90, 180, 300
        System.out.println("InvoicedOrderLinesToCRMUpdateForecastTransformerTest.testExecute");
    }
    private List<InvoicedOrderLine> createMockedOrderLineListForRevenusesAndSUF() {

        List<InvoicedOrderLine> listOfInvoicedOrderLines = new ArrayList<InvoicedOrderLine>();
        String[] salesPart = {"110", "240", "170"};
        BigDecimal[] total = {BigDecimal.valueOf(100), BigDecimal.valueOf(200), BigDecimal.valueOf(300)};
        BigDecimal[] cost = {BigDecimal.valueOf(10), BigDecimal.valueOf(20), BigDecimal.valueOf(30)};
        String[] systemAgreements = {"0-fa51ee9a469e", "0-fa51ee9a469a", "0-fa51ee9a469e"};

        for (int i = 0; i < 3; i++) {
            String dateString = "2013-05-24T15:30:01.999+02:00";
            OrderLine orderLine = new OrderLine(systemAgreements[i], "AAAAA33333", true, salesPart[i], "description" + i,
                    total[i], cost[i], "1301", new Timestamp(dateString),
                    "11111", "" + i);

            InvoicedOrderLine invoicedOrderLine = new InvoicedOrderLine("", "", new Market(51), new Currency(""), orderLine, "", InvoiceOrderLineStatus.NONE);
            listOfInvoicedOrderLines.add(invoicedOrderLine);
        }
        return listOfInvoicedOrderLines;
    }

    private List<InvoicedOrderLine> createMockedOrderLineListForFeesAndOther() {

        List<InvoicedOrderLine> listOfInvoicedOrderLines = new ArrayList<InvoicedOrderLine>();
        String[] salesPart = {"305", "340", "120", "114", "112", "113", "270"};
        BigDecimal[] total = {BigDecimal.valueOf(100), BigDecimal.valueOf(200), BigDecimal.valueOf(300),BigDecimal.valueOf(400), BigDecimal.valueOf(500), BigDecimal.valueOf(700), BigDecimal.valueOf(800)};
        BigDecimal[] cost = {BigDecimal.valueOf(10), BigDecimal.valueOf(20), BigDecimal.valueOf(30),BigDecimal.valueOf(40), BigDecimal.valueOf(50), BigDecimal.valueOf(60),BigDecimal.valueOf(70)};

        String[] systemAgreements = {"0-fa51ee9a469e", "0-fa51ee9a469a", "0-fa51ee9a469e","0-fa51ee9a469e", "0-fa51ee9a469a", "0-fa51ee9a469e","0-fa51ee9a468e"};

        for (int i = 0; i < salesPart.length; i++) {
            String dateString = "2013-05-24T15:30:01.999+02:00";
            OrderLine orderLine = new OrderLine(systemAgreements[i], "AAAAA33333", true, salesPart[i], "description" + i,
                    total[i], cost[i], "1301", new Timestamp(dateString),
                    "11111", "" + i);

            InvoicedOrderLine invoicedOrderLine = new InvoicedOrderLine("", "", new Market(51), new Currency(""), orderLine, "", InvoiceOrderLineStatus.NONE);
            listOfInvoicedOrderLines.add(invoicedOrderLine);
        }
        return listOfInvoicedOrderLines;
    }

    private List<InvoicedOrderLine> createMockedOrderLineListForTradeDoublerCommission() {

        List<InvoicedOrderLine> listOfInvoicedOrderLines = new ArrayList<InvoicedOrderLine>();
        String[] salesPart = {"1","2","3","4","5","6","7","335","350"};
        BigDecimal[] total = {BigDecimal.valueOf(100), BigDecimal.valueOf(200), BigDecimal.valueOf(300),BigDecimal.valueOf(400), BigDecimal.valueOf(500), BigDecimal.valueOf(700), BigDecimal.valueOf(800),BigDecimal.valueOf(900), BigDecimal.valueOf(1000)};
        BigDecimal[] cost = {BigDecimal.valueOf(10), BigDecimal.valueOf(20), BigDecimal.valueOf(30),BigDecimal.valueOf(40), BigDecimal.valueOf(50), BigDecimal.valueOf(60),BigDecimal.valueOf(70),BigDecimal.valueOf(10),BigDecimal.valueOf(9)};

        String[] systemAgreements = {"0-fa51ee9a469e", "0-fa51ee9a469a", "0-fa51ee9a469e","0-fa51ee9a469e", "0-fa51ee9a469a", "0-fa51ee9a469e","0-fa51ee9a468e","0-fa51ee9a468e","0-fa51ee9a468e"};

        for (int i = 0; i < salesPart.length; i++) {
            String dateString = "2013-05-24T15:30:01.999+02:00";
            OrderLine orderLine = new OrderLine(systemAgreements[i], "AAAAA33333", true, salesPart[i], "description" + i,
                    total[i], cost[i], "1301", new Timestamp(dateString),
                    "11111", "" + i);

            InvoicedOrderLine invoicedOrderLine = new InvoicedOrderLine("", "", new Market(51), new Currency(""), orderLine, "", InvoiceOrderLineStatus.NONE);
            listOfInvoicedOrderLines.add(invoicedOrderLine);
        }
        return listOfInvoicedOrderLines;
    }

}
