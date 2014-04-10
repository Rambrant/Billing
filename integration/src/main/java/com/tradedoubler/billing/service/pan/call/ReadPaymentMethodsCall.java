package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.ConverterValue;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.*;

import java.sql.*;
import java.util.List;

/**
 * Read the payment methods constants from Pan. Payment methods examples: Direct debit, Bank transfer etc.
 *
 * @author bjoek
 * @since 2012-10-29
 */
public class ReadPaymentMethodsCall extends AbstractDatabaseCall {
    private static final RowMapper<ConverterValue<Integer>> rowMapper = new ParameterizedRowMapper<ConverterValue<Integer>>() {
        @Override
        public ConverterValue<Integer> mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ConverterValue<Integer>(
                    rs.getString("ax_value"), Integer.parseInt(rs.getString("crm_value")));
        }
    };

    ReadPaymentMethodsCall(SimpleJdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public List<ConverterValue<Integer>> fetchValues() {

        return getJdbcTemplate().query("" +
                " SELECT * FROM ax_converter_values" +
                " WHERE value_type = 'PaymentMethod'" +
                " ORDER BY id",
                rowMapper
        );
    }
}
