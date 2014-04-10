package com.tradedoubler.billing.service.crm.azure;

import com.microsoft.windowsazure.services.core.storage.StorageException;
import com.microsoft.windowsazure.services.queue.client.*;
import com.tradedoubler.billing.service.crm.AzureServiceSetup;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.*;


/**
 * User: erigu
 * Date: 2012-06-18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/springPropertiesContext.xml",
        "/spring/springAutowireContext.xml", "/spring/springServicesContext.xml"})
public class AzureAccountTest {

    @Autowired
    AzureServiceSetup azureServiceSetup;

    @Before
    public void setUp() {
    }


    @Test
    public void testFetchFaultyQueue() throws Exception {
        String queue = "no-such-queue";
        String errorResult = "";
        try {
            AzureQueueWrapper cloudQueue = azureServiceSetup.getCloudQueue(queue);
            cloudQueue.retrieveMessage(1, null);
        } catch (StorageException e) {
            errorResult = e.getMessage();
        }

        assertTrue(errorResult.contains("The specified queue does not exist."));

    }

    @Test
    public void testWriteAndFetch() throws Exception {
        String queue = "billing-test";
        AzureMessage message = new AzureMessage(new CloudQueueMessage("Test.testWriteAndFetch"), queue);
        AzureQueueWrapper cloudQueue = azureServiceSetup.getCloudQueue(queue);
        cloudQueue.addMessage(message, null);

        AzureMessage fetchedMessage = cloudQueue.retrieveMessage(1, null);

        assertNotNull(fetchedMessage.getMessageContentAsString("UTF-8"));
        assertThat(fetchedMessage.getQueueName(), is("billing-test"));

    }

    @Test
    public void testNoQueueSpecified() throws Exception {
        String queue = "";
        String errorResult = "";
        try {
            AzureQueueWrapper cloudQueue = azureServiceSetup.getCloudQueue(queue);
            cloudQueue.retrieveMessage(1, null);
        } catch (IllegalArgumentException e) {
            errorResult = e.getMessage();
        }

        assertTrue(errorResult.contains("The argument must not be an empty string or null"));
    }

    @Test
    public void testDeleteMessage() throws Exception {
        String queue = "billing-test";

        AzureMessage message = new AzureMessage(new CloudQueueMessage("Test.testWriteAndFetch"), queue);
        AzureQueueWrapper cloudQueue = azureServiceSetup.getCloudQueue(queue);

        // Put a message on queue
        cloudQueue.addMessage(message, null);

        // Read a message from queue
        AzureMessage azureMessage = cloudQueue.retrieveMessage(1, null);

        // Delete it
        cloudQueue.deleteMessage(azureMessage, null);

        try {
            cloudQueue.deleteMessage(azureMessage, null);
            fail();
        } catch (StorageException sex) {
            assertThat(sex.getMessage(), is("The specified message does not exist."));
        }
    }


}
