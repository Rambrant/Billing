package com.tradedoubler.testutil;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;

/**
 * @author bjoek
 * @since 2012-06-26
 */
public class FileUtil {
    public static String readFileFromClasspath(String fileName) {
        URL url = FileUtil.class.getClassLoader().getResource(fileName);
        try {
            return IOUtils.toString(url.openStream(), "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(fileName, e);
        }
    }
}
