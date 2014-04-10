package com.tradedoubler.billing.transform.webservice;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.AxdEntityMDSSalesSplitter;
import com.tradedoubler.billing.domain.SplittingRule;
import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.*;


/**
 * User: erigu
 * Date: 2012-09-21
 */
public class SplittingRuleToAxSalesSplitterTransformerTest {
    private SplittingRuleToAxSalesSplitterTransformer splittingRuleTransformer;

    @Test
    public void testTransform() throws Exception {
        List<SplittingRule> splittingRules = createSplittingRules("invReciId", "id1", "id2");
        splittingRuleTransformer = new SplittingRuleToAxSalesSplitterTransformer(splittingRules);

        List<AxdEntityMDSSalesSplitter> splitters = splittingRuleTransformer.transform();
        assertNotNull(splitters);
        assertEquals(2, splitters.size());
        int i = 1;
        for (AxdEntityMDSSalesSplitter splittingRule : splitters){
            assertEquals("entity", splittingRule.getClazz());
            assertEquals("{ID" + i + "}", splittingRule.getSplitterId());
            assertEquals("{INVRECIID}", splittingRule.getInvoiceRecipientId());
            i++;
        }
    }

    private ArrayList<SplittingRule> createSplittingRules(String invoiceRecipientId, String... ids) {
        ArrayList<SplittingRule> splittingRules = new ArrayList<SplittingRule>();
        for (String id : ids) {
            splittingRules.add(new SplittingRule(id, invoiceRecipientId, "sp - upd"));
        }
        return splittingRules;
    }
}
