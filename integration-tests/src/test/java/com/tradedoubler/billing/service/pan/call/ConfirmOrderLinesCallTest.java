package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.pan.handler.OrderLinesPanHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * @author bjoek
 * @since 2012-10-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class ConfirmOrderLinesCallTest {
    @Autowired
    private OrderLinesPanHandler orderLinesPanHandler;

    @Autowired
    private DataSource dataSource;

    @Test
    public void confirmOrderLinesWithWrongBatchIdShouldThrowException() throws BillingServiceException {
        Guid batchId = Guid.createFromOracleDbGuid("cafebabe85C26E63E044002128BBA6A6");
        List<OrderLineFailed> failedOrderLines = new ArrayList<OrderLineFailed>();
        failedOrderLines.add(new OrderLineFailed("100", "Test av funktion"));
        try {
            orderLinesPanHandler.confirmOrderLines(batchId, failedOrderLines);
            fail();
        } catch (UncategorizedSQLException usex) {
            assertThat(usex.getMessage(), containsString("No open order lines exist with the specified batch id."));
        }
    }

    @Test
    public void wrongBatchIdShouldRollbackFailedOrderLines() throws BillingServiceException {
        SimpleJdbcTemplate template = new SimpleJdbcTemplate(dataSource);
        int countFailedBefore = template.queryForInt("SELECT COUNT(*) FROM admin.order_line_ax_errors");

        Guid batchId = Guid.createFromOracleDbGuid("cafebabe85C26E63E044002128BBA6A6");
        List<OrderLineFailed> failedOrderLines = new ArrayList<OrderLineFailed>();
        failedOrderLines.add(new OrderLineFailed("100", "Test av funktion"));

        try {
            orderLinesPanHandler.confirmOrderLines(batchId, failedOrderLines);
            fail();
        } catch (UncategorizedSQLException usex) {
            assertThat(usex.getMessage(), containsString("No open order lines exist with the specified batch id."));
        }

        // Check that failed order line has not been inserted (rollback works)
        int countFailedAfter = template.queryForInt("SELECT COUNT(*) FROM admin.order_line_ax_errors");
        assertThat(countFailedAfter, is(countFailedBefore));
    }

    @Test
    public void invalidFailedOrderLineShouldRollbackFailedOrderLines() throws BillingServiceException {
        SimpleJdbcTemplate template = new SimpleJdbcTemplate(dataSource);
        int countFailedBefore = template.queryForInt("SELECT COUNT(*) FROM admin.order_line_ax_errors");

        Guid batchId = Guid.createFromOracleDbGuid("cafebabe85C26E63E044002128BBA6A6");
        List<OrderLineFailed> failedOrderLines = new ArrayList<OrderLineFailed>();
        failedOrderLines.add(new OrderLineFailed("100", "Test av funktion"));

        char[] errMsg = new char[300];
        Arrays.fill(errMsg, 'n');

        failedOrderLines.add(new OrderLineFailed("100", new String(errMsg)));

        try {
            orderLinesPanHandler.confirmOrderLines(batchId, failedOrderLines);
            fail();
        } catch (UncategorizedSQLException usex) {
            assertThat(usex.getMessage(), startsWith("PreparedStatementCallback; uncategorized SQLException for SQL [ INSERT"));
        }

        // Check that failed order line has not been inserted (rollback works)
        int countFailedAfter = template.queryForInt("SELECT COUNT(*) FROM admin.order_line_ax_errors");
        assertThat(countFailedAfter, is(countFailedBefore));
    }

}
