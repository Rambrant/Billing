package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.domain.Timestamp;
import com.tradedoubler.billing.service.BillingServiceException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.*;

import java.sql.Date;
import java.sql.*;
import java.util.*;

/**
 * A database call to fetch batchId and order lines from Pan. The order lines are then inserted in Ax for invoicing and the
 * batchId is used to confirm the order lines in Pan.
 *
 * @author bjoek
 * @since 2012-09-26
 */
public class ReadOrderLinesCall extends AbstractDatabaseCall {

    private static final String FETCH_ORDER_LINES_SQL = "" +
            " SELECT " +
            "  id" +
            " ,source_system_agreement_id" +
            " ,invoiceable" +
            " ,sales_part" +
            " ,description" +
            " ,total" +
            " ,cost" +
            " ,period" +
            " ,date_of_prepayment" +
            " ,credited_invoice_no" +
            " ,splitter" +
            " FROM admin.order_lines" +
            " WHERE order_line_batch_id = ?" +
            " ORDER BY id";

    private static final OrderLineRowMapper orderLineRowMapper = new OrderLineRowMapper();
    private List<OrderLine> orderLines;
    private Guid batchId;
    private final SimpleJdbcCall fetchOrderLineBatchId;

    public ReadOrderLinesCall(SimpleJdbcTemplate jdbcTemplate, SimpleJdbcCall fetchOrderLineBatchId) {
        super(jdbcTemplate);
        this.fetchOrderLineBatchId = fetchOrderLineBatchId;
    }

    public void read() throws BillingServiceException {
        String batchIdCallValue = fetchOrderLineBatchId.executeFunction(String.class);

        checkFailExecutionStatus(batchIdCallValue);

        if (batchIdCallValue.equals("0")) {
            orderLines = new ArrayList<OrderLine>();
            return;
        }

        orderLines = getJdbcTemplate().query(FETCH_ORDER_LINES_SQL, orderLineRowMapper, batchIdCallValue);

        checkEmptyOrderLineSet(batchIdCallValue, orderLines);

        batchId = Guid.createFromOracleDbGuid(batchIdCallValue);
    }

    private void checkFailExecutionStatus(String batchIdCallValue) throws BillingServiceException {
        if (batchIdCallValue.startsWith("" + DB_FUNCTION_ERROR_CODE) || batchIdCallValue.isEmpty()) {
            throw BillingServiceException.createBugDisturbance(String.format(
                    "Something went wrong when executing stored function billing_pkg.fetchOrderLineBatchId in Pan database. " +
                            "Return value was %s", batchIdCallValue));
        }
    }

    private void checkEmptyOrderLineSet(String batchIdCallValue, List<OrderLine> orderLines) throws BillingServiceException {
        if (orderLines.size() == 0) {
            throw BillingServiceException.createBugDisturbance(String.format("BatchId %s was reported, but no order lines where returned", batchIdCallValue));
        }
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public Guid getBatchId() {
        return batchId;
    }

    public String getVersion() {
        return "1.0";
    }

    public String getSourceSystemId() {
        return "PAN";
    }

    private static class OrderLineRowMapper implements RowMapper<OrderLine> {
        @Override
        public OrderLine mapRow(ResultSet rs, int rowNum) throws SQLException {
            Date date_of_prepayment = rs.getDate("date_of_prepayment");
            return new OrderLine(
                    rs.getString("source_system_agreement_id"),
                    rs.getString("id"), rs.getString("invoiceable").equalsIgnoreCase("Y"),
                    rs.getString("sales_part"), rs.getString("description"),
                    rs.getBigDecimal("total"),
                    rs.getBigDecimal("cost"), rs.getString("period"),
                    date_of_prepayment == null ? null : new Timestamp(date_of_prepayment),
                    rs.getString("credited_invoice_no"), rs.getString("splitter")
            );
        }
    }

}
