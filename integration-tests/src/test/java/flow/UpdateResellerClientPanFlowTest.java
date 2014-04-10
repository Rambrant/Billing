package flow;

import com.microsoft.schemas.dynamics._2008._01.services.CustomerServiceCreateRequest;
import com.microsoft.schemas.dynamics._2008._01.services.CustomerServiceFindRequest;
import com.microsoft.schemas.dynamics._2008._01.services.CustomerServiceUpdateRequest;
import com.microsoft.schemas.dynamics._2010._01.datacontracts.CallContext;
import com.tradedoubler.billing.domain.Address;
import com.tradedoubler.billing.domain.Market;
import com.tradedoubler.billing.domain.ResellerClient;
import com.tradedoubler.billing.service.ax.webservice.AxWebServiceSetup;
import com.tradedoubler.billing.service.cache.CacheService;
import com.tradedoubler.billing.service.pan.PanDatabaseServiceSetup;
import com.tradedoubler.billing.service.pan.call.ResellerClientEvent;
import mds_salesorderbasisline.SalesOrderBasisLineProcessingScheduleOrderBasisLineProcessingResponse;
import org.junit.Before;
import org.junit.Test;
import org.mule.api.config.ConfigurationBuilder;
import org.mule.config.spring.SpringRegistry;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.tck.junit4.AbstractMuleContextTestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.RowMapper;
import org.tempuri.MDSITGSalesClAServiceUpdateAifFaultFaultFaultMessage;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;

/**
 * @author bjorn
 * @since 2012-06-18
 */
public class UpdateResellerClientPanFlowTest extends AbstractMuleContextTestCase {
    private FlowTestHelper flowTestHelper = new FlowTestHelper();

    private AxWebServiceSetup axWebServiceSetupMock;
    private PanDatabaseServiceSetup panDatabaseServiceSetupMock;

    private CallContext callContext = new CallContext();

    private SalesOrderBasisLineProcessingScheduleOrderBasisLineProcessingResponse response;
    private CacheService cacheService;

    @Override
    protected ConfigurationBuilder getBuilder() throws Exception {
        return new SpringXmlConfigurationBuilder(new String[]{
                "spring/springPropertiesContext.xml",
                "spring/springBeansContext.xml",
                "spring/springContext-flowMock.xml",
                "spring/springServicesContext.xml",
                "flow/commons.xml",
                "flow/update-reseller-client-pan.xml"});
    }

    @Before
    public void setup() throws MDSITGSalesClAServiceUpdateAifFaultFaultFaultMessage {
        initializeApplicationContext();

        setupCommonMocks();

        setupResponse();
    }

    private void initializeApplicationContext() {
        ApplicationContext applicationContext = (ApplicationContext) muleContext.getRegistry().lookupObject(SpringRegistry.SPRING_APPLICATION_CONTEXT);
        axWebServiceSetupMock = applicationContext.getBean(AxWebServiceSetup.class);
        panDatabaseServiceSetupMock = applicationContext.getBean(PanDatabaseServiceSetup.class);
        cacheService = applicationContext.getBean(CacheService.class);

        flowTestHelper.skipMessageController(applicationContext);
    }

    private void setupCommonMocks() throws MDSITGSalesClAServiceUpdateAifFaultFaultFaultMessage {
        flowTestHelper.setupMockForAllPortCalls(axWebServiceSetupMock);
        flowTestHelper.setupMockForAllPortInserts(callContext);
        flowTestHelper.setupMockForAllPortUpdates(callContext);
        flowTestHelper.setupMockForAllDatabaseCalls(panDatabaseServiceSetupMock);
        
        // Three markets
        flowTestHelper.loadMarketsInCacheService(cacheService, new Market(51), new Market(81861), new Market(135926));

        when(axWebServiceSetupMock.getCallContext(anyString())).thenReturn(callContext);
    }

    private void setupResponse() {
        response = new SalesOrderBasisLineProcessingScheduleOrderBasisLineProcessingResponse();
        response.setResponse(true);
    }

    @Test
    public void nothingToFetchFlowShouldWork() throws Exception {
        when(flowTestHelper.jdbcTemplateMock.query(any(String.class), any(RowMapper.class))).thenReturn(new ArrayList());

        muleContext.start();
        Thread.sleep(1200);
        muleContext.stop();

        // Verify that pan database was queried for client reseller
        verify(flowTestHelper.jdbcTemplateMock, atLeast(1)).query(any(String.class), any(RowMapper.class));

        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }

    @Test
    public void insertFlowShouldWork() throws Exception {
        String resellerClientEventGuid = "2B911A64E26843D0937DE610CF652E07";
        ResellerClientEvent event = new ResellerClientEvent(resellerClientEventGuid, 42, new Date(1), ResellerClientEvent.ModificationType.CREATE);
        Address address = new Address("Vasagatan 38", null, "Göteborg", null, "11120", "SE", 3);
        ResellerClient client = new ResellerClient("clientId", "registeredCompanyName", "companyRegistrationNumber",
                "vatNumber", "SV", "", address);

        // Found one reseller
        when(flowTestHelper.jdbcTemplateMock.query(any(String.class), any(RowMapper.class)))
                .thenReturn(Arrays.asList(event)).thenReturn(new ArrayList());
        when(flowTestHelper.jdbcTemplateMock.query(any(String.class), any(RowMapper.class), eq(42L)))
                .thenReturn(Arrays.asList(client));

        // No client found in Ax, inserts must be performed
        when(flowTestHelper.customerPortMock.find(any(CustomerServiceFindRequest.class), same(callContext))).thenReturn(flowTestHelper.createCustomerNotFound());

        muleContext.start();
        Thread.sleep(1200);
        muleContext.stop();

        // Verify that pan database was queried for order lines
        verify(flowTestHelper.jdbcTemplateMock, atLeast(1)).query(any(String.class), any(RowMapper.class));
        verify(flowTestHelper.jdbcTemplateMock).query(any(String.class), any(RowMapper.class), eq(42L));

        // Verify that reseller was inserted into Ax (once for each of three markets)
        verify(flowTestHelper.customerPortMock, times(3)).find(any(CustomerServiceFindRequest.class), same(callContext));
        verify(flowTestHelper.customerPortMock, times(3)).create(any(CustomerServiceCreateRequest.class), same(callContext));

        // Verify that reseller client was confirmed
        verify(flowTestHelper.jdbcTemplateMock).update(any(String.class), eq("2B911A64E26843D0937DE610CF652E07"));

        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }

    @Test
    public void updateFlowShouldWork() throws Exception {
        String resellerClientEventGuid = "2B911A64E26843D0937DE610CF652E07";
        ResellerClientEvent event = new ResellerClientEvent(resellerClientEventGuid, 42, new Date(1), ResellerClientEvent.ModificationType.CREATE);
        Address address = new Address("Vasagatan 38", null, "Göteborg", null, "11120", "SE", 3);
        ResellerClient client = new ResellerClient("clientId", "registeredCompanyName", "companyRegistrationNumber",
                "vatNumber", "SV", "", address);

        // Found one reseller
        when(flowTestHelper.jdbcTemplateMock.query(any(String.class), any(RowMapper.class)))
                .thenReturn(Arrays.asList(event)).thenReturn(new ArrayList());
        when(flowTestHelper.jdbcTemplateMock.query(any(String.class), any(RowMapper.class), eq(42L)))
                .thenReturn(Arrays.asList(client));

        // Client was found in Ax, update must be performed
        when(flowTestHelper.customerPortMock.find(any(CustomerServiceFindRequest.class), same(callContext))).thenReturn(flowTestHelper.createCustomerFound());

        muleContext.start();
        Thread.sleep(1200);
        muleContext.stop();

        // Verify that pan database was queried for order lines
        verify(flowTestHelper.jdbcTemplateMock, atLeast(1)).query(any(String.class), any(RowMapper.class));
        verify(flowTestHelper.jdbcTemplateMock).query(any(String.class), any(RowMapper.class), eq(42L));

        // Verify that reseller was inserted into Ax (once for each of three markets)
        verify(flowTestHelper.customerPortMock, times(3)).find(any(CustomerServiceFindRequest.class), same(callContext));
        verify(flowTestHelper.customerPortMock, times(3)).update(any(CustomerServiceUpdateRequest.class), same(callContext));

        // Verify that reseller client was confirmed
        verify(flowTestHelper.jdbcTemplateMock).update(any(String.class), eq("2B911A64E26843D0937DE610CF652E07"));

        verifyNoMoreInteractions(flowTestHelper.getAllMocks());
    }

}
