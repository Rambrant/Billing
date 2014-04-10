package com.tradedoubler.billing.service.pan.call;

import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.domain.Timestamp;
import com.tradedoubler.billing.fetch.FlowName;
import com.tradedoubler.billing.service.BillingServiceException;
import org.slf4j.*;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.*;

import java.sql.*;
import java.util.List;

import static com.tradedoubler.billing.service.pan.call.ResellerClientEvent.ModificationType.*;

/**
 * Read the posting profiles constants from Pan. Posting profiles examples: 'Reminder', 'Reminder and Interest' etc.
 *
 * @author bjoek
 * @since 2012-10-29
 */
public class ReadUpdatedOrCreatedResellerCall extends AbstractDatabaseCall {
    private static final RowMapper<ResellerClientEvent> eventRowMapper = createEventRowMapper();
    private static final RowMapper<ResellerClient> clientRowMapper = createClientRowMapper();
    private static final Logger log = LoggerFactory.getLogger(ReadUpdatedOrCreatedResellerCall.class);
    private ResellerClientUpdated reseller;

    ReadUpdatedOrCreatedResellerCall(SimpleJdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public void read() throws BillingServiceException {
        ResellerClientEvent event = getResellerClientEvent();

        if (event == null) {
            return;
        }

        ResellerClient client = getResellerClient(event);

        MetaData metaData = createMetadata(event);

        reseller = new ResellerClientUpdated(metaData, client);
    }

    public ResellerClientUpdated getReseller() {
        return reseller;
    }

    private ResellerClientEvent getResellerClientEvent() {
        List<ResellerClientEvent> events = getJdbcTemplate().query("" +
                " SELECT  " +
                "    create_date" +
                "  , event_type" +
                "  , reseller_id" +
                "  , reseller_ir_client_event_id" +
                " FROM (" +
                "   SELECT * " +
                "   FROM reseller_ir_client_events e" +
                "   WHERE e.processed = 'N'" +
                "   ORDER BY e.event_type, e.id" +
                " ) " +
                " WHERE rownum = 1",
                eventRowMapper
        );

        if (events.size() == 0) {
            return null;
        }

        ResellerClientEvent event = events.get(0);
        log.info(String.format("Fetched one ResellerClientEvent: Guid=%s, Create Date=%s, ResellerClientFk=%d, create or update: %s",
                event.resellerClientEventGuid, event.eventCreateDate, event.resellerClientId, event.modification));

        return event;
    }

    private ResellerClient getResellerClient(ResellerClientEvent event) throws BillingServiceException {
        long resellerClientId = event.resellerClientId;

        List<ResellerClient> clients = getJdbcTemplate().query("" +
                " SELECT " +
                "  o.id AS ClientId" +
                "  , o.name AS RegisteredCompanyName" +
                "  , o.organization_no AS CompanyRegistrationNumber" +
                "  , o.vatno AS VatNumber" +
                "  , pe.language_id AS InvoiceLanguage" +
                "  , '' AS BusinessFormCode" +
                "  , o.address1 AS Addr_Line1" +
                "  , o.address2 AS Addr_Line2" +
                "  , o.zipcode AS Addr_PostalCode" +
                "  , o.city AS Addr_City" +
                "  , o.extra2 AS Addr_County" +
                "  , o.country_id AS Addr_CountryCode" +
                "  , '3' AS Addr_AddressType" +
                " FROM organizations o" +
                " INNER JOIN td_organizations tdo ON tdo.organization_id = o.id" +
                " INNER JOIN programs pr ON pr.id = tdo.secret_program_id" +
                " INNER JOIN persons pe ON pe.id = pr.ref_person_id" +
                " WHERE o.id = ?" +
                " ORDER BY o.id",
                clientRowMapper, resellerClientId
        );

        if (clients.size() == 0) {
            throw BillingServiceException.createBugDisturbance(String.format(
                    "Inconsistency between reseller_clients_events and reseller_clients, reseller_client_id : %d",
                    resellerClientId));
        }

        return clients.get(0);
    }

    private MetaData createMetadata(ResellerClientEvent event) {
        return new MetaData(FlowName.UpdateResellerClientPan.name(),
                Guid.createFromOracleDbGuid(event.resellerClientEventGuid),
                new Timestamp(event.eventCreateDate), "1.0", "PAN");
    }

    private static ParameterizedRowMapper<ResellerClientEvent> createEventRowMapper() {
        return new ParameterizedRowMapper<ResellerClientEvent>() {
            @Override
            public ResellerClientEvent mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ResellerClientEvent(
                        rs.getString("reseller_ir_client_event_id"),
                        rs.getLong("reseller_id"),
                        rs.getDate("create_date"),
                        rs.getInt("event_type") == 1 ? CREATE : UPDATE);
            }
        };
    }

    private static RowMapper<ResellerClient> createClientRowMapper() {
        return new ParameterizedRowMapper<ResellerClient>() {
            @Override
            public ResellerClient mapRow(ResultSet rs, int rowNum) throws SQLException {
                Address address = createAddress(rs);
                ResellerClient resellerClient = createClient(rs, address);

                return resellerClient;
            }

            private Address createAddress(ResultSet rs) throws SQLException {

                return new Address(
                        rs.getString("Addr_Line1"),
                        rs.getString("Addr_Line2"),
                        rs.getString("Addr_City"),
                        rs.getString("Addr_County"),
                        rs.getString("Addr_PostalCode"),
                        rs.getString("Addr_CountryCode"),
                        rs.getInt("Addr_AddressType")
                );
            }

            private ResellerClient createClient(ResultSet rs, Address address) throws SQLException {
                return new ResellerClient(
                        rs.getString("ClientId"),
                        rs.getString("RegisteredCompanyName"),
                        rs.getString("CompanyRegistrationNumber"),
                        rs.getString("VatNumber"),
                        rs.getString("InvoiceLanguage"),
                        rs.getString("BusinessFormCode"),
                        address
                );

            }

        };
    }


}
