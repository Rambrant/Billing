package com.tradedoubler.billing.validate;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Reads a Json schema from file, supporting recursive use of the $ref attribute to include sub-schemas.
 * Any schema files referenced through the $ref attribute will be located using the path of the main schema as relative path.
 */
@Component
public class TdJsonSchemaReader {
    private final static String SCHEMA_FILE_ENCODING = "UTF-8";

    private final ClassPathResourceManager classPathResource = new ClassPathResourceManager();

    public TdJsonSchemaReader() {

    }

    /**
     * Reads a JSON schema file, supporting the use of the $ref attribute (sub schemas)
     *
     * @param jsonSchemaPath The path to the JSON Schema file to read
     * @return The full JSON schema as a TdJsonObject
     * @throws JSONException If the schema file could not be successfully parsed into JSON
     */
    public TdJsonObject readSchema(String jsonSchemaPath) throws JSONException {
        try {
            String schemaDirectoryPath = FilenameUtils.getFullPath(jsonSchemaPath);
            String jsonSchemaContent = classPathResource.getResourceContent(jsonSchemaPath, SCHEMA_FILE_ENCODING);

            jsonSchemaContent = includeSubSchemas(jsonSchemaContent, schemaDirectoryPath);

            return new TdJsonObject(jsonSchemaContent);
        } catch (Throwable x) {
            throw new JSONException(x);
        }
    }

    /*
     * Replace each $ref attribute with the content of the referenced Json schema.
     */
    private String includeSubSchemas(String jsonSchemaString, String schemaDirectoryPath) throws IOException, JSONException {
        int refAttributeBeginIndex = jsonSchemaString.indexOf("\"$ref\"");
        if (refAttributeBeginIndex == -1) {
            return jsonSchemaString; // Done. No more $ref attributes to replace
        }

        // Find path to sub schema, i.e. the value of the $ref attribute
        int refAttributeEndIndex = jsonSchemaString.indexOf(",", refAttributeBeginIndex);
        int refContextEndIndex = jsonSchemaString.indexOf("}", refAttributeBeginIndex);
        if (refAttributeEndIndex < 0 || refContextEndIndex < refAttributeEndIndex) {
            refAttributeEndIndex = refContextEndIndex;
        }
        String refAttribute = jsonSchemaString.substring(refAttributeBeginIndex, refAttributeEndIndex);
        String subSchemaFilename = refAttribute.split(":")[1].trim();
        subSchemaFilename = StringUtils.remove(subSchemaFilename, "\"").trim();
        String subSchemaFullPath = schemaDirectoryPath + subSchemaFilename;

        String refSchemaContent = classPathResource.getResourceContent(subSchemaFullPath, SCHEMA_FILE_ENCODING);
        refSchemaContent = removeUnwantedJsonSyntaxFromSubSchema(refSchemaContent);

        // Replace the entire $ref attribute and its value with the content of the sub schema
        jsonSchemaString = StringUtils.replace(jsonSchemaString, refAttribute, refSchemaContent);

        // Make recursive call with updated Json schema content
        return includeSubSchemas(jsonSchemaString, schemaDirectoryPath);
    }

    private String removeUnwantedJsonSyntaxFromSubSchema(String schemaContent) throws JSONException {
        TdJsonObject schemaJsonObject = new TdJsonObject(schemaContent);

        removeUnwantedSubSchemaAttributes(schemaJsonObject);

        /*
         * Remove first '{' and last '}', since we are only interested in the attributes of the main Json object
         */
        schemaContent = schemaJsonObject.toString().trim();
        schemaContent = StringUtils.removeStart(schemaContent, "{");
        schemaContent = StringUtils.removeEnd(schemaContent, "}");

        return schemaContent;
    }

    private void removeUnwantedSubSchemaAttributes(TdJsonObject schemaJsonObject) throws JSONException {
        schemaJsonObject.remove("id");
        schemaJsonObject.remove("description");
        schemaJsonObject.remove("required");
    }
}
