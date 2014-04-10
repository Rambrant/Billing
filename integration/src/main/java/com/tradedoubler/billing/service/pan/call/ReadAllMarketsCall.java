package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.ConverterValue;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Read the market constants from Pan.
 *
 * @author bjoek
 * @since 2012-10-29
 */
public class ReadAllMarketsCall extends AbstractDatabaseCall {
    private static final RowMapper<ConverterValue<Integer>> rowMapper = new ParameterizedRowMapper<ConverterValue<Integer>>() {
        @Override
        public ConverterValue<Integer> mapRow(ResultSet rs, int rowNum) throws SQLException {
//            return new ConverterValue<Integer>(rs.getString("market_id_ax"), rs.getInt("organization_id"));

            return new ConverterValue<Integer>(rs.getString("ax_value"), rs.getInt("crm_value"));
        }
    };

    ReadAllMarketsCall(SimpleJdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public List<ConverterValue<Integer>> fetchValues() {
          return getJdbcTemplate().query("" +
                " SELECT * FROM ax_converter_values" +
                " WHERE value_type = 'Market'" +
                " ORDER BY id",
                rowMapper
        );
//        return getJdbcTemplate().query("" +
//                " SELECT * FROM td_organizations" +
//                " WHERE market_id_ax IS NOT NULL" +
//                " ORDER BY organization_id",
//                rowMapper
//        );
    }
}
