package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.Guid;
import org.slf4j.*;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 * Confirms to admindb that an invoicing rule has been successfully delivered to AX.
 */
public class ConfirmResellerClientProcessedCall extends AbstractDatabaseCall {

    private final static Logger log = LoggerFactory.getLogger(ConfirmResellerClientProcessedCall.class);

    ConfirmResellerClientProcessedCall(SimpleJdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public void confirm(Guid resellerClientEventGuid) {
        String sql = "" +
                " UPDATE reseller_ir_client_events e" +
                " SET e.processed='Y'" +
                " WHERE e.reseller_ir_client_event_id = ?" +
                " AND e.processed='N'";
        int updateLines = getJdbcTemplate().update(sql, resellerClientEventGuid.getGuidForOracleDb());
        log.debug(String.format("Confirmed %d reseller client event messages in Pan", updateLines));
    }
}

