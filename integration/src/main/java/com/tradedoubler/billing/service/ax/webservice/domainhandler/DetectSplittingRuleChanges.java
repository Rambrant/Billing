package com.tradedoubler.billing.service.ax.webservice.domainhandler;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.AxdEntityMDSSalesSplitter;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumAxdEntityAction;
import com.tradedoubler.billing.domain.SplittingRule;
import com.tradedoubler.billing.service.ax.webservice.call.FindInvoiceRecipientCall;

import java.util.*;

/**
 * This class identifies exists or not-exists changes for the invoice recipient splitting rules.<br>
 *
 * @author bjoek
 * @since 2012-09-05
 */
class DetectSplittingRuleChanges {

    private final ChangeDetector changeDetector;

    public DetectSplittingRuleChanges(FindInvoiceRecipientCall existingFindCall, List<SplittingRule> futureSplitters) {
        changeDetector = new ChangeDetector(getExistingSplitterIds(existingFindCall.getSplitters()), getFutureSplitterIds(futureSplitters));
    }

    private Set<String> getExistingSplitterIds(List<AxdEntityMDSSalesSplitter> splitters) {
        Set<String> returnValue = new TreeSet<String>();
        for (AxdEntityMDSSalesSplitter splitter : splitters) {
            returnValue.add(splitter.getSplitterId());
        }
        return returnValue;
    }

    private Set<String> getFutureSplitterIds(List<SplittingRule> futureSplitters) {
        Set<String> returnValue = new TreeSet<String>();
        for (SplittingRule splitter : futureSplitters) {
            returnValue.add(splitter.getSplittingRuleId().getGuidForAx());
        }
        return returnValue;
    }


    public void markSplitters(List<AxdEntityMDSSalesSplitter> mdsSalesInvoiceMessage) {
        markInserts(mdsSalesInvoiceMessage);
    }

    /** Modifies the data that are sent to the update call to Ax */
    private void markInserts(List<AxdEntityMDSSalesSplitter> splitters) {
        for (AxdEntityMDSSalesSplitter splitter : splitters) {
            if (changeDetector.getIdsToInsert().contains(splitter.getSplitterId())) {
                splitter.setAction(AxdEnumAxdEntityAction.CREATE);
            }
        }
    }
}
