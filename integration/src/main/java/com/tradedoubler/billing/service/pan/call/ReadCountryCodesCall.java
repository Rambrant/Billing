package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.ConverterValue;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.*;

import java.sql.*;
import java.util.List;

/**
 * Read the country code constants from Pan.
 *
 * @author bjoek
 * @since 2012-10-29
 */
public class ReadCountryCodesCall extends AbstractDatabaseCall {
    private static final RowMapper<ConverterValue<String>> rowMapper = new ParameterizedRowMapper<ConverterValue<String>>() {
        @Override
        public ConverterValue<String> mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ConverterValue<String>(
                    rs.getString("country_id_ax"), rs.getString("id"));
        }
    };

    ReadCountryCodesCall(SimpleJdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public List<ConverterValue<String>> fetchValues() {

        return getJdbcTemplate().query("" +
                " SELECT * FROM countries" +
                " WHERE country_id_ax IS NOT NULL" +
                " ORDER BY id",
                rowMapper
        );
    }
}
