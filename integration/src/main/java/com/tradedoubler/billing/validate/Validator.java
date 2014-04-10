package com.tradedoubler.billing.validate;

import com.fasterxml.jackson.databind.JsonNode;
import com.tradedoubler.billing.platform.flowcontroller.*;
import com.tradedoubler.billing.service.BillingServiceException;
import org.apache.commons.io.IOUtils;
import org.eel.kitchen.jsonschema.main.*;
import org.eel.kitchen.jsonschema.report.ValidationReport;
import org.eel.kitchen.jsonschema.util.JsonLoader;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.*;

/**
 * Validates Json against Json validation schemas.
 *
 * @author bjorn
 * @since 2012-10-12
 */
@Component
public class Validator {
    private final static Logger log = LoggerFactory.getLogger(Validator.class);

    // The schema path is set in the XML config as spring property jsonSchemaPath.
    @Autowired
    private TdJsonSchemaReader jsonSchemaReader;

    private final Map<String, JsonSchema> schemaMap = new LinkedHashMap<String, JsonSchema>();

    /**
     * Validates a Json-string. If it fails a ServiceResult with a bug-disturbance is created.
     *
     * @param serviceResult        A ServiceResult with correct state - bug-disturbance = true if failed validation
     * @param jsonStringToValidate
     * @param jsonSchemaPath
     * @return
     * @throws BillingServiceException throw if json schema cannot be read
     */
    public ServiceResult validate(ServiceResult serviceResult, String jsonStringToValidate, String jsonSchemaPath) throws BillingServiceException {
        if (serviceResult.isDisturbance()) {
            return serviceResult;
        }

        JsonSchema schema = loadJsonSchema(jsonSchemaPath);
        JsonNode jsonNodeToValidate = parseJson(jsonStringToValidate);

        // Validate Json against schema
        ValidationReport validationReport = schema.validate(jsonNodeToValidate);

        if (!validationReport.isSuccess()) {
            serviceResult = ServiceResultErrorHandler.handleJsonValidationFail(serviceResult,
                    validationReport.getMessages().toString(), jsonSchemaPath, jsonStringToValidate);

        }

        return serviceResult;
    }

    /**
     * Loads a Json schema from the file given by Spring property jsonSchemaPath in the xml config.
     *
     * @param jsonSchemaPath path to schema
     * @return A JasonSchema object on successful parsing of the schema file, exception on failure.
     */
    private JsonSchema loadJsonSchema(String jsonSchemaPath) throws BillingServiceException {
        JsonSchema schema = schemaMap.get(jsonSchemaPath);
        if (schema == null) {
            log.info("Loading json schema " + jsonSchemaPath);
            InputStream jsonSchemaInputStream = null;
            try {
                TdJsonObject jsonSchemaObject = jsonSchemaReader.readSchema(jsonSchemaPath);
                JsonNode schemaNode = JsonLoader.fromString(jsonSchemaObject.toString());
                schema = JsonSchemaFactory.defaultFactory().fromSchema(schemaNode);
                schemaMap.put(jsonSchemaPath, schema);
            } catch (Exception e) {
                throw BillingServiceException.createBugDisturbance(String.format("Error when loading json schema %s. Error: %s", jsonSchemaPath, e.getMessage()));
            } finally {
                IOUtils.closeQuietly(jsonSchemaInputStream);
            }
            log.debug("Loaded json schema: " + jsonSchemaPath);
        }
        return schema;
    }

    /**
     * Parses a Json string into a JsonNode object.
     *
     * @param jsonString The Json string to parse
     * @return A JsonNode object on successful parsing of the input string, exception on failure.
     */
    private JsonNode parseJson(String jsonString) throws BillingServiceException {
        if (log.isDebugEnabled()) {
            log.debug("Parsing json string: " + jsonString);
        }
        com.fasterxml.jackson.databind.JsonNode jsonNodeToValidate;
        try {
            jsonNodeToValidate = JsonLoader.fromString(jsonString);
        } catch (Exception e) {
            throw BillingServiceException.createBugDisturbance(String.format("Error, other than schema-validation, when parsing json %s. Error message : %s", jsonString, e.getMessage()));

        }
        return jsonNodeToValidate;
    }


}
