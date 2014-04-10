package com.tradedoubler.billing.platform.messagecontroller;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;


/**
 * Created by IntelliJ IDEA.
 * User: mattjo
 * Date: 2012-09-03
 * Time: 10:01
 * To change this template use File | Settings | File Templates.
 */
public class MessageControllerServiceTest {


    @Test
    public void testGz() {
        final String text = "hello this is my message to process";
        try {
            // test compression
            byte[] compressed = MessageControllerService.compress(text);
            String decompressed = MessageControllerService.decompress(compressed);
            assertEquals(text, decompressed);

            // test base64 encoding
            byte[] input = text.getBytes("UTF8");
            String data = MessageControllerService.encodeBase64(input);
            byte[] decomp = MessageControllerService.decodeBase64(data);
            assertEquals(input.length, decomp.length);
            String result = new String(decomp, "UTF8");
            assertEquals(text, result);

            // test compression and encoding together
            compressed = MessageControllerService.compress(text);
            data = MessageControllerService.encodeBase64(compressed);
            decomp = MessageControllerService.decodeBase64(data);
            decompressed = MessageControllerService.decompress(decomp);
            assertEquals(text, decompressed);


            // Test database string
            /*String moreData = "H4sIAAAAAAAAAHNxGQWjYBQMdxDvUpqbW6ngm1pcnJieqmBkAADFNUSB+QMAAA==";
            decomp = MessageControllerService.decodeBase64(moreData);
            decompressed = MessageControllerService.decompress(decomp);
            assertEquals(text,decompressed);
            */


        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }
}
