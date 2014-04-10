package com.tradedoubler.billing.validate;

import org.apache.commons.io.IOUtils;

import java.io.*;

/** Utility class to fetch resources from the class path. Primarily used to fetch json validations schemas from jar-files. */
class ClassPathResourceManager {
    public ClassPathResourceManager() {
    }

    InputStream getResourceAsStream(String resourcePath) {
        return getClass().getClassLoader().getResourceAsStream(resourcePath);
    }

    public String getResourceContent(String resourcePath, String encoding) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = getResourceAsStream(resourcePath);
            StringWriter stringWriter = new StringWriter();
            IOUtils.copy(inputStream, stringWriter, encoding);

            return stringWriter.toString();
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

}
