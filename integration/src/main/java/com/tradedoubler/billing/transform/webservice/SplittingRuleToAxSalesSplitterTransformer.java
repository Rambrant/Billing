package com.tradedoubler.billing.transform.webservice;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.*;
import com.tradedoubler.billing.domain.SplittingRule;

import java.util.*;

/**
 * Convert a Splitting Rule to Ax representation of the same.
 * 
 * User: erigu
 * Date: 2012-09-04
 */
public class SplittingRuleToAxSalesSplitterTransformer {
    private final List<SplittingRule> splittingRules;
    private final ObjectFactory objectFactory = new ObjectFactory();

    public SplittingRuleToAxSalesSplitterTransformer(List<SplittingRule> splittingRules) {


        this.splittingRules = splittingRules;
    }

    public List<AxdEntityMDSSalesSplitter> transform() {
        List<AxdEntityMDSSalesSplitter> listOfAxSalesSplitter = new ArrayList<AxdEntityMDSSalesSplitter>();
        for (SplittingRule splittingRule : splittingRules) {
            listOfAxSalesSplitter.add(transformOne(splittingRule));
        }

        return listOfAxSalesSplitter;
    }

    private AxdEntityMDSSalesSplitter transformOne(SplittingRule splittingRule) {
        AxdEntityMDSSalesSplitter axSalesSplitter = objectFactory.createAxdEntityMDSSalesSplitter();
        axSalesSplitter.setClazz("entity");

        //This value should be handled by Ax, but we set it anyway
        axSalesSplitter.setInvoiceRecipientId(splittingRule.getInvoiceRecipientId().getGuidForAx());

        axSalesSplitter.setSplitterId(splittingRule.getSplittingRuleId().getGuidForAx());
        axSalesSplitter.setSplitterValue(splittingRule.getSplitter());
        return axSalesSplitter;
    }

}
