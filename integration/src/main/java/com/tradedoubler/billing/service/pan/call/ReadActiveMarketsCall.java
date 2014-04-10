package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.Market;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Read all market, from Pan, that uses the Ax invoicing solution.
 *
 * @author bjoek
 * @since 2012-10-29
 */
public class ReadActiveMarketsCall extends AbstractDatabaseCall {
    private static final RowMapper<Market> rowMapper = new ParameterizedRowMapper<Market>() {
        @Override
        public Market mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Market(rs.getInt("organization_id"));
        }
    };

    ReadActiveMarketsCall(SimpleJdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public List<Market> fetchValues() {

                return getJdbcTemplate().query("" +
                " SELECT o.organization_id FROM ax_converter_values axc, td_organizations o" +
                " WHERE value_type = 'Market' AND o.organization_id = axc.crm_value" +
                " AND o.invoices_by_type_id = 2" +
                " ORDER BY o.organization_id",
                rowMapper
        );


//        return getJdbcTemplate().query("" +
//                " SELECT o.organization_id FROM td_organizations o" +
//                " WHERE o.market_id_ax IS NOT NULL" +
//                " AND o.invoices_by_type_id = 2" +
//                " ORDER BY o.organization_id",
//                rowMapper
//        );
    }
}
