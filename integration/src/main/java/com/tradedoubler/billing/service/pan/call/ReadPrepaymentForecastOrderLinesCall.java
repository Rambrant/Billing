package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.Currency;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.domain.Timestamp;
import com.tradedoubler.billing.service.BillingServiceException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.*;

import java.sql.*;
import java.util.*;

/**
 * A database call to fetch batchId and order line forecasts from Pan. The order lines are then inserted in Crm as forecasts
 * and the batchId is used to confirm the order lines in Pan.
 *
 * @author bjoek
 * @since 2012-09-26
 */
public class ReadPrepaymentForecastOrderLinesCall extends AbstractDatabaseCall {
    private static final String version = "1.0";
    private static final String sourceSystemId = "PAN";

    private static final RowMapper<PrepaymentOrderLine> rowMapper = new ParameterizedRowMapper<PrepaymentOrderLine>() {
        @Override
        public PrepaymentOrderLine mapRow(ResultSet rs, int rowNum) throws SQLException {
            OrderLine orderLine = new OrderLine(
                    rs.getString("source_system_agreement_id"),
                    rs.getString("id"), rs.getString("invoiceable").equalsIgnoreCase("Y"),
                    rs.getString("sales_part"), rs.getString("description"),
                    rs.getBigDecimal("total"),
                    rs.getBigDecimal("cost"), rs.getString("period"),
                    new Timestamp(rs.getDate("date_of_prepayment")),
                    rs.getString("credited_invoice_no"), rs.getString("splitter")
            );

            return new PrepaymentOrderLine(orderLine, new Currency(rs.getString("currency_id")));
        }
    };

    private static final String FETCH_FORECAST_ORDER_LINES_SQL = "" +
            " SELECT " +
            "   ol.id" +
            "  ,ol.source_system_agreement_id" +
            "  ,ol.invoiceable" +
            "  ,ol.sales_part" +
            "  ,ol.description" +
            "  ,ol.total" +
            "  ,ol.cost" +
            "  ,ol.period" +
            "  ,ol.date_of_prepayment" +
            "  ,ol.credited_invoice_no" +
            "  ,ol.splitter" +
            "  ,p.currency_id" +
            " FROM order_lines ol" +
            " INNER JOIN programs p ON p.id = ol.program_id" +
            " WHERE ol.order_line_batch_id_pp = ?" +
            " ORDER BY ol.id";

    private List<PrepaymentOrderLine> orderLines;
    private Guid batchId;
    private final SimpleJdbcCall fetchOrderLineBatchIdPP;

    public ReadPrepaymentForecastOrderLinesCall(SimpleJdbcTemplate jdbcTemplate, SimpleJdbcCall fetchOrderLineBatchIdPP) {
        super(jdbcTemplate);
        this.fetchOrderLineBatchIdPP = fetchOrderLineBatchIdPP;
    }

    public void read() throws BillingServiceException {
        String batchIdCallValue = fetchOrderLineBatchIdPP.executeFunction(String.class);

        checkFailExecutionStatus(batchIdCallValue);

        if (batchIdCallValue.equals("0")) {
            orderLines = new ArrayList<PrepaymentOrderLine>();
            return;
        }

        orderLines = getJdbcTemplate().query(FETCH_FORECAST_ORDER_LINES_SQL, rowMapper, batchIdCallValue);

        checkEmptyOrderLineSet(batchIdCallValue, orderLines);

        batchId = Guid.createFromOracleDbGuid(batchIdCallValue);
    }

    private void checkFailExecutionStatus(String batchIdCallValue) throws BillingServiceException {
        if (batchIdCallValue.startsWith("" + DB_FUNCTION_ERROR_CODE) || batchIdCallValue.isEmpty()) {
            throw BillingServiceException.createBugDisturbance(String.format(
                    "Something went wrong when executing stored function billing_pkg.fetchOrderLineBatchIdPP in Pan database. " +
                            "Return value was %s", batchIdCallValue));
        }
    }

    private void checkEmptyOrderLineSet(String batchIdCallValue, List<PrepaymentOrderLine> orderLines) throws BillingServiceException {
        if (orderLines.size() == 0) {
            throw BillingServiceException.createBugDisturbance(String.format("BatchId %s was reported, but no order lines where returned", batchIdCallValue));
        }
    }

    public List<PrepaymentOrderLine> getOrderLines() {
        return orderLines;
    }

    public Guid getBatchId() {
        return batchId;
    }

    public String getVersion() {
        return version;
    }

    public String getSourceSystemId() {
        return sourceSystemId;
    }
}
