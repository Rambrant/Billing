package flow;

import com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import com.tradedoubler.billing.service.pan.PanDatabaseServiceSetup;
import org.datacontract.schemas._2004._07.dynamics_ax.*;
import org.datacontract.schemas._2004._07.dynamics_ax.ObjectFactory;
import org.junit.*;
import org.mule.api.config.ConfigurationBuilder;
import org.mule.config.spring.*;
import org.mule.tck.junit4.AbstractMuleContextTestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.RowMapper;
import org.tempuri.*;

import javax.xml.bind.JAXBElement;
import java.math.BigDecimal;
import java.util.*;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.eq;

/**
 * @author bjorn
 * @since 2012-06-18
 */
public class OrderLinesCreatedFlowTest extends AbstractMuleContextTestCase {
    private FlowTestHelper flowTestHelper = new FlowTestHelper();

    private AxWebServiceSetup axWebServiceSetupMock;
    private PanDatabaseServiceSetup panDatabaseServiceSetupMock;

    private List<OrderLine> orderLines = createOrderLines();
    private CallContext callContext = new CallContext();

    private ObjectFactory objectFactory = new ObjectFactory();
    private MDSSalesOrderBasisLineServiceOrderBasisLineInboundResponse responseEveryThingIsOk;
    private MDSSalesOrderBasisLineServiceOrderBasisLineInboundResponse responseHalfWillFail;

    @Override
    protected ConfigurationBuilder getBuilder() throws Exception {
        return new SpringXmlConfigurationBuilder(new String[]{
                "spring/springPropertiesContext.xml",
                "spring/springBeansContext.xml",
                "spring/springContext-flowMock.xml",
                "spring/springServicesContext.xml",
                "flow/commons.xml",
                "flow/create-order-lines-pan.xml"});
    }

    private List<OrderLine> createOrderLines() {
        List<OrderLine> orderLines = new ArrayList<OrderLine>();
        for (int i = 0; i < 10; i++) {
            OrderLine orderLine = new OrderLine("0-fa51ee9a469e", "orderLineID" + i, true, "110", "descr" + i,
                    BigDecimal.valueOf(1390.43), BigDecimal.valueOf(695.21), "1301", new Timestamp("2012-10-26T21:32:52"),
                    "11111", "" + i);
            orderLine.setDebitOrCredit(DebitOrCredit.DEBIT);
            orderLine.setQuantity(1);

            orderLines.add(orderLine);
        }
        return orderLines;
    }

    @Before
    public void setup() throws MDSITGSalesClAServiceUpdateAifFaultFaultFaultMessage {
        initializeApplicationContext();

        setupCommonMocks();

        setupAxResponse();
    }

    private void setupAxResponse() {

        ArrayOfMDSITGSalesOrderBasisLineContract value1 = new ArrayOfMDSITGSalesOrderBasisLineContract();
        JAXBElement<ArrayOfMDSITGSalesOrderBasisLineContract> response1 = objectFactory.createArrayOfMDSITGSalesOrderBasisLineContract(value1);

        responseEveryThingIsOk = new MDSSalesOrderBasisLineServiceOrderBasisLineInboundResponse();
        responseEveryThingIsOk.setResponse(response1);

        ArrayOfMDSITGSalesOrderBasisLineContract value2 = new ArrayOfMDSITGSalesOrderBasisLineContract();
        List<MDSITGSalesOrderBasisLineContract> contracts = value2.getMDSITGSalesOrderBasisLineContract();
        contracts.add(createContract("orderLineID1"));
        contracts.add(createContract("orderLineID3"));
        contracts.add(createContract("orderLineID5"));
        contracts.add(createContract("orderLineID7"));
        contracts.add(createContract("orderLineID9"));
        JAXBElement<ArrayOfMDSITGSalesOrderBasisLineContract> response2 = objectFactory.createArrayOfMDSITGSalesOrderBasisLineContract(value2);

        responseHalfWillFail = new MDSSalesOrderBasisLineServiceOrderBasisLineInboundResponse();
        responseHalfWillFail.setResponse(response2);
    }

    private MDSITGSalesOrderBasisLineContract createContract(String id) {
        MDSITGSalesOrderBasisLineContract contract = new MDSITGSalesOrderBasisLineContract();
        contract.setParmException(MDSITGSalesOrderBasisLineImportError.UPDATE_FAILED);
        contract.setParmOrderBasisLineId(objectFactory.createMDSITGSalesOrderBasisLineContractParmOrderBasisLineId(id));
        return contract;
    }

    private void initializeApplicationContext() {
        ApplicationContext applicationContext = (ApplicationContext) muleContext.getRegistry().lookupObject(SpringRegistry.SPRING_APPLICATION_CONTEXT);
        axWebServiceSetupMock = applicationContext.getBean(AxWebServiceSetup.class);
        panDatabaseServiceSetupMock = applicationContext.getBean(PanDatabaseServiceSetup.class);

        flowTestHelper.skipMessageController(applicationContext);
    }

    private void setupCommonMocks() throws MDSITGSalesClAServiceUpdateAifFaultFaultFaultMessage {
        flowTestHelper.setupMockForAllPortCalls(axWebServiceSetupMock);
        flowTestHelper.setupMockForAllPortInserts(callContext);
        flowTestHelper.setupMockForAllPortUpdates(callContext);
        flowTestHelper.setupMockForAllDatabaseCalls(panDatabaseServiceSetupMock);

        when(axWebServiceSetupMock.getCallContext(anyString())).thenReturn(callContext);
    }

    @Test
    public void nothingToFetchFlowShouldWork() throws Exception {
        muleContext.start();
        when(flowTestHelper.fetchOrderLineBatchIdMock.executeFunction(String.class)).thenReturn("0");

        Thread.sleep(1200);
        muleContext.stop();

        // Verify that pan database was queried for order lines
        verify(flowTestHelper.fetchOrderLineBatchIdMock, atLeast(1)).executeFunction(String.class);

        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }

    @Test
    public void normalFlowShouldWork() throws Exception {
        String batchId = "CCF99706EF702578E044002128BBA6A6";

        when(flowTestHelper.fetchOrderLineBatchIdMock.executeFunction(String.class)).thenReturn(batchId).thenReturn("0");
        when(flowTestHelper.jdbcTemplateMock.query(anyString(), any(RowMapper.class), eq(batchId))).thenReturn(orderLines);
        when(flowTestHelper.salesOrderBasisLinePortMock.orderBasisLineInbound(
                any(MDSSalesOrderBasisLineServiceOrderBasisLineInboundRequest.class), same(callContext)))
                .thenReturn(responseEveryThingIsOk);

        muleContext.start();

        Thread.sleep(1200);
        muleContext.stop();

        // Verify that pan database was queried for order lines
        verify(flowTestHelper.fetchOrderLineBatchIdMock, atLeast(1)).executeFunction(String.class);
        verify(flowTestHelper.jdbcTemplateMock).query(anyString(), any(RowMapper.class), eq(batchId));

        // Verify call to ax
        verify(flowTestHelper.salesOrderBasisLinePortMock).orderBasisLineInbound(
                any(MDSSalesOrderBasisLineServiceOrderBasisLineInboundRequest.class), same(callContext));

        // Verify that batch was confirmed in pan database
        verify(flowTestHelper.updateBatchOfOrderLinesMock).executeFunction(BigDecimal.class, batchId);

        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }

    @Test
    public void failedOrderLinesFlowShouldWork() throws Exception {
        String batchId = "CCF99706EF702578E044002128BBA6A6";

        when(flowTestHelper.fetchOrderLineBatchIdMock.executeFunction(String.class)).thenReturn(batchId).thenReturn("0");
        when(flowTestHelper.jdbcTemplateMock.query(anyString(), any(RowMapper.class), eq(batchId))).thenReturn(orderLines);
        when(flowTestHelper.salesOrderBasisLinePortMock.orderBasisLineInbound(
                any(MDSSalesOrderBasisLineServiceOrderBasisLineInboundRequest.class), same(callContext)))
                .thenReturn(responseHalfWillFail);

        muleContext.start();

        Thread.sleep(1200);
        muleContext.stop();

        // Verify that pan database was queried for order lines
        verify(flowTestHelper.fetchOrderLineBatchIdMock, atLeast(1)).executeFunction(String.class);
        verify(flowTestHelper.jdbcTemplateMock).query(anyString(), any(RowMapper.class), eq(batchId));

        // Verify call to ax
        verify(flowTestHelper.salesOrderBasisLinePortMock).orderBasisLineInbound(
                any(MDSSalesOrderBasisLineServiceOrderBasisLineInboundRequest.class), same(callContext));

        // Verify that failed order lines where inserted and batch was confirmed in pan database
        verify(flowTestHelper.jdbcTemplateMock).batchUpdate(anyString(), any(Map[].class));
        verify(flowTestHelper.updateBatchOfOrderLinesMock).executeFunction(BigDecimal.class, batchId);

        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }

}
