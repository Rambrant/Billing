package com.tradedoubler.billing.service.pan.call;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 * Common functionality for pan database calls
 *
 * @author bjoek
 * @since 2012-09-26
 */
public abstract class AbstractDatabaseCall {
    /** Default error code that stored functions return if they fail */
    public static final int DB_FUNCTION_ERROR_CODE = -1;
    private final SimpleJdbcTemplate jdbcTemplate;

    AbstractDatabaseCall(SimpleJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    SimpleJdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

}
