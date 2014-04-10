package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.Guid;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.pan.handler.OrderLinesPanHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

/**
 * @author bjoek
 * @since 2012-10-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class ConfirmPrepaymentForecastOrderLinesCallTest {
    @Autowired
    private OrderLinesPanHandler orderLinesPanHandler;

    @Autowired
    private DataSource dataSource;

    @Test
    public void confirmOrderLinesWithWrongBatchIdShouldThrowException() throws BillingServiceException {
        Guid batchId = Guid.createFromOracleDbGuid("cafebabe85C26E63E044002128BBA6A6");
        try {
            orderLinesPanHandler.confirmForecastOrderLines(batchId);
            fail();
        } catch (UncategorizedSQLException usex) {
            assertThat(usex.getMessage(), containsString("No open order lines exist with the specified batch id."));
        }
    }

}
