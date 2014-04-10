package com.tradedoubler.billing.platform.messagecontroller;

import com.tradedoubler.billing.domain.MetaData;
import com.tradedoubler.billing.platform.flowcontroller.IntegrationMessage;
import com.tradedoubler.billing.platform.logging.LogError;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.*;
import java.sql.*;
import java.util.List;
import java.util.zip.*;

/**
 * This service is only used by the MessageController and is responsible for reading and writing
 * information to the MySql database through the use of Spring and JDBC Templates.
 */
public class MessageControllerService {

    private final static Logger log = LoggerFactory.getLogger(MessageControllerService.class);

    /** Sets a limit for when the message controller starts zipping the raw data */
    private long startZippingLimit = 20000;

    /** Used to communicate with the MySql database that offers persistence of the integration messages. */
    private JdbcTemplate jdbcTemplate;

    /**
     * Injected by Spring. Controls at what length of the raw data that zipping occurs.
     *
     * @param startZippingLimit The start limit.
     */
    public void setStartZippingLimit(long startZippingLimit) {
        this.startZippingLimit = startZippingLimit;
    }

    /** The data source is injected by Spring to allow easier configuration for various run-time environments. */
    public void setDataSource(DataSource dataSource) {
        try {
            jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.setIgnoreWarnings(false);
            jdbcTemplate.setQueryTimeout(30);
        } catch (Exception e) {
            log.error( LogError.PLATFORM.name(),e);
        }
    }


    /** SQL to find a message item. */
    private static final String findSql = "select message_item_id,message_guid,message_type,entity_id,message_create_time," +
            "message_content,message_create_time_ms,content_type,number_of_attempts, db_insert_time " +
            "from MESSAGE_ITEM where message_guid=? " +
            "or (" +
            "message_type=? and " +
            "entity_id=? and " +
            "message_create_time_ms > ?" +
            ")";


    /**
     * Fetches the asked for message item from the database.
     *
     * @param integrationMessage The integration message that supplies the meta-data needed
     * @return null if no such item or the item if it has been found.
     * @throws Exception When there is an inconsistency in the database table
     * @throws org.springframework.dao.DataAccessException
     *                   When there are other problems with the database
     */
    public MessageItem findMessageItem(IntegrationMessage integrationMessage) throws Exception {

        MetaData metaData = integrationMessage.getMetaData();

        if(metaData == null){
            throw new Exception("Missing metadata");
        }else if(metaData.getMessageId() == null){
            throw new Exception("metaData.getMessageId == null");
        }else if(metaData.getMessageType() == null){
            throw new Exception("metaData.getMessageType() == null");
        }else if(metaData.getCreationTime() == null){
            throw new Exception("metaData.getCreationTime() == null");
        }

        List<MessageItem> items = (List<MessageItem>) jdbcTemplate.query(findSql,
                new Object[]{metaData.getMessageId().getGuid(), metaData.getMessageType(), integrationMessage.getEntityId(),
                        metaData.getCreationTime().getSqlTimestamp().getTime()},
                new MessageItemRowMapper());

        if (items.isEmpty()) {
            return null;
        }
        return items.get(0);
    }


    /** SQL to insert a message item. */
    private final static String insertSql =
            "INSERT INTO MESSAGE_ITEM (message_guid, message_type, entity_id, message_create_time, message_content, message_create_time_ms,content_type,number_of_attempts,db_insert_time) " +
                    " VALUES (?,?,?,?,?,?,?,1,NOW())";


    /**
     * Compresses the given string with gzip.
     *
     * @param string The string to compress
     * @return the compressed bytes
     * @throws IOException When the compression fails
     */
    public static byte[] compress(String string) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream(string.length());
        GZIPOutputStream gos = new GZIPOutputStream(os);
        gos.write(string.getBytes());
        gos.close();
        byte[] compressed = os.toByteArray();
        os.close();
        return compressed;
    }


    /**
     * Decompresses the given data which is expected to be gzipped.
     *
     * @param compressed The gzipped raw data
     * @return The decompressed data as a String.
     * @throws IOException When decompression fails or when the input is not gzip format.
     */
    public static String decompress(byte[] compressed) throws IOException {
        final int BUFFER_SIZE = 32;
        ByteArrayInputStream is = new ByteArrayInputStream(compressed);
        GZIPInputStream gis = new GZIPInputStream(is, BUFFER_SIZE);
        StringBuilder string = new StringBuilder();
        byte[] data = new byte[BUFFER_SIZE];
        int bytesRead;
        while ((bytesRead = gis.read(data)) != -1) {
            string.append(new String(data, 0, bytesRead));
        }
        gis.close();
        is.close();
        return string.toString();
    }

    /**
     * Encode the given data as base64.
     *
     * @param data The data to encode.
     * @return The encoded data
     * @throws IOException
     */
    public static String encodeBase64(byte[] data) throws IOException {
        return new String(Base64.encodeBase64(data), "UTF8");
    }

    /**
     * Decode the given base64 string to bytes.
     *
     * @param base64 String with base64 encoded content.
     * @return The encoded result
     * @throws UnsupportedEncodingException
     */
    public static byte[] decodeBase64(String base64) throws UnsupportedEncodingException {
        return Base64.decodeBase64(base64.getBytes("UTF8"));
    }

    /**
     * Inserts a new message item in the database.
     *
     * @param guid        The message's guid. Should be unique per integration message
     * @param createTime  The create time when the message was created
     * @param messageType
     * @param entityId
     * @param data
     * @throws Exception When there is an inconsistency in the database table
     * @throws org.springframework.dao.DataAccessException
     *                   When there are other problems with the database
     */
    public void insertMessageItem(String guid, Timestamp createTime, String messageType, String entityId, String data) throws Exception {

        // Is the data too long to store?
        String contentType = "txt";
        if (data != null && data.length() > startZippingLimit) {
            try {
                byte[] gzip = MessageControllerService.compress(data);
                data = MessageControllerService.encodeBase64(gzip);
                contentType = "gz";
            } catch (Exception e) {
                log.error( LogError.PLATFORM.name(),e);
            }
        }

        int res = jdbcTemplate.update(insertSql, guid, messageType, entityId, createTime, data, createTime.getTime(), contentType);
        if (res != 1) {
            StringBuffer sb = new StringBuffer();
            sb.append("Could not insert MessageItem into the MySql database. Parameters:\n");
            sb.append("Guid: ").append(guid).append(" createTime: ").append(createTime).append(" messageType: ");
            sb.append(messageType).append(" entityId: ").append(entityId).append(" data:\n").append(data);
            throw new Exception(sb.toString());
        }
    }


    /** SQL to update a message item. */
    private final static String updateSql = "UPDATE MESSAGE_ITEM SET number_of_attempts=? where message_item_id=?";

    /**
     * Updates the given message with how many times it has been processed.
     *
     * @param id               The primary key of the message item
     * @param numberOfAttempts The new number of attempts to set
     * @throws Exception
     */
    public void updateMessageItem(long id, int numberOfAttempts) throws Exception {
        int res = jdbcTemplate.update(updateSql, numberOfAttempts, id);
        if (res != 1) {
            StringBuffer sb = new StringBuffer();
            sb.append("Could not update MessageItem in the MySql database. Parameters:\n");
            sb.append("ID (pk): ").append(numberOfAttempts).append(" NumberOfAttempts: ").append(numberOfAttempts);
            throw new Exception(sb.toString());
        }
    }

    // Helper class that creates message items from database rows.
    private static class MessageItemRowMapper implements org.springframework.jdbc.core.RowMapper {

        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            MessageItem item = new MessageItem();
            try {
                item.setId(rs.getLong("message_item_id"));
                item.setGuid(rs.getString("message_guid"));
                item.setMessageType(rs.getString("message_type"));
                item.setEntityId(rs.getString("entity_id"));
                item.setMessageCreateTime(rs.getTimestamp("message_create_time"));
                item.setData(rs.getString("message_content"));
                item.setMessageCreateTimeMs(rs.getLong("message_create_time_ms"));
                item.setContentType(rs.getString("content_type"));
                item.setNumberOfAttempts(rs.getInt("number_of_attempts"));
                item.setDbInsertTime(rs.getTimestamp("db_insert_time"));
            } catch (Exception e) {
                log.error( LogError.PLATFORM.name(), e);
            }

            // Does the data need to be decompressed?
            if ("gz".equalsIgnoreCase(item.getContentType())) {
                try {
                    byte[] gzip = MessageControllerService.decodeBase64(item.getData());
                    String data = MessageControllerService.decompress(gzip);
                    item.setData(data);
                    //log.severe("Decompressed data: " + item.getData());
                } catch (Exception e) {
                    log.error( LogError.PLATFORM.name(),e);
                } catch (Throwable t) {
                    log.error( LogError.PLATFORM.name(),t);
                }
            }
            return item;
        }
    }
}
