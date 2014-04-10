package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.ConverterValue;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.*;

import java.sql.*;
import java.util.List;

/**
 * Read the posting profiles constants from Pan. Posting profiles examples: 'Reminder', 'Reminder and Interest' etc.
 *
 * @author bjoek
 * @since 2012-10-29
 */
public class ReadPostingProfilesCall extends AbstractDatabaseCall {
    private static final RowMapper<ConverterValue<Integer>> rowMapper = new ParameterizedRowMapper<ConverterValue<Integer>>() {
        @Override
        public ConverterValue<Integer> mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ConverterValue<Integer>(
                    rs.getString("ax_value"), Integer.parseInt(rs.getString("crm_value")));
        }
    };

    ReadPostingProfilesCall(SimpleJdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public List<ConverterValue<Integer>> fetchValues() {

        return getJdbcTemplate().query("" +
                " SELECT * FROM ax_converter_values" +
                " WHERE value_type = 'PostingProfile'" +
                " ORDER BY id",
                rowMapper
        );
    }
}
