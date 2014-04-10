package com.tradedoubler.billing.transform.json.gson;

import com.google.gson.Gson;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.testutil.FileUtil;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author bjoek
 * @since 2012-08-21
 */
public class GsonFactoryTest {
    private final Gson gson = GsonFactory.getGson();

    @Test
    public void transformFromJsonShouldWork() {
        String json = FileUtil.readFileFromClasspath("json-examples/invoicing-rule-created-example.json");
        InvoicingRuleCreated invoicingRuleCreated = gson.fromJson(json, InvoicingRuleCreated.class);
        assertThat(invoicingRuleCreated, notNullValue());
    }

    @Test
    public void transformAgreementToJsonShouldWork() {
        String json = FileUtil.readFileFromClasspath("json-examples/agreement-updated-example.json");
        json = json.replaceAll("\n|\r|\t| ", "");
        Object domainObject = gson.fromJson(json, AgreementUpdated.class);
        String actual = gson.toJson(domainObject);
        actual = actual.replaceAll("\n|\r|\t| ", "");
        assertThat(actual, is(json));
    }

    @Test
    public void transformClientUpdatedToJsonShouldWork() {
        String json = FileUtil.readFileFromClasspath("json-examples/client-updated-example.json");
        json = json.replaceAll("\n|\r|\t| ", "");
        Object domainObject = gson.fromJson(json, ClientUpdated.class);
        String actual = gson.toJson(domainObject);
        actual = actual.replaceAll("\n|\r|\t| ", "");
        assertThat(actual, is(json));
    }

    @Test
    public void transformRecipientDeletedToJsonShouldWork() {
        String json = FileUtil.readFileFromClasspath("json-examples/invoice-recipient-deleted-example.json");
        json = json.replaceAll("\n|\r|\t| ", "");
        Object domainObject = gson.fromJson(json, InvoiceRecipientDeleted.class);
        String actual = gson.toJson(domainObject);
        actual = actual.replaceAll("\n|\r|\t| ", "");
        assertThat(actual, is(json));
    }

    @Test
    public void transformInvoicingRuleCreatedToJsonShouldWork() {
        String json = FileUtil.readFileFromClasspath("json-examples/invoicing-rule-created-example.json");
        json = json.replaceAll("\n|\r|\t| ", "");
        Object domainObject = gson.fromJson(json, InvoicingRuleCreated.class);
        String actual = gson.toJson(domainObject);
        actual = actual.replaceAll("\n|\r|\t| ", "");
        assertThat(actual, is(json));
    }

    @Test
    public void transformInvoicingRuleUpdatedToJsonShouldWork() {
        String json = FileUtil.readFileFromClasspath("json-examples/invoicing-rule-updated-example.json");
        json = json.replaceAll("\n|\r|\t| ", "");
        Object domainObject = gson.fromJson(json, InvoicingRuleUpdated.class);
        String actual = gson.toJson(domainObject);
        actual = actual.replaceAll("\n|\r|\t| ", "");
        assertThat(actual, is(json));
    }

    @Test
    public void transformMarketMessageUpdatedToJsonShouldWork() {
        String json = FileUtil.readFileFromClasspath("json-examples/market-message-updated-example.json");
        json = json.replaceAll("\n|\r|\t| ", "");
        Object domainObject = gson.fromJson(json, MarketMessageUpdated.class);
        String actual = gson.toJson(domainObject);
        actual = actual.replaceAll("\n|\r|\t| ", "");
        assertThat(actual, is(json));
    }

    @Test
    public void transformSplittingRuleDeletedToJsonShouldWork() {
        String json = FileUtil.readFileFromClasspath("json-examples/splitting-rule-deleted-example.json");
        json = json.replaceAll("\n|\r|\t| ", "").trim();
        Object domainObject = gson.fromJson(json, SplittingRuleDeleted.class);
        String actual = gson.toJson(domainObject);
        actual = actual.replaceAll("\n|\r|\t| ", "").trim();
        assertThat(actual, is(json));
    }

    @Test
    public void dummyConstructorShouldWork() {
        assertThat(new GsonFactory(), notNullValue());
    }
}
