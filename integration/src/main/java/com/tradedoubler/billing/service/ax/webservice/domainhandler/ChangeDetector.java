package com.tradedoubler.billing.service.ax.webservice.domainhandler;

import java.util.*;

/**
 * Detects ids that has to be inserted or deleted when updating lists. The remaining ids are updates.
 * The class uses lists of existing ids and desired (future) ids to determine changes.
 *
 * User: bjoek
 * Date: 2012-09-06
 */
class ChangeDetector {
    private final Set<String> existingIds;
    private final Set<String> futureIds;
    private final Set<String> idsToInsert = new TreeSet<String>();
    private final Set<String> idsToDelete = new TreeSet<String>();

    public ChangeDetector(Set<String> existingIds, Set<String> futureIds) {
        this.existingIds = existingIds;
        this.futureIds = futureIds;
        detectChanges();
    }

    private void detectChanges() {
        for (String existingInvoiceMessageId : existingIds) {
            if (futureIds.contains(existingInvoiceMessageId)) {
                // Existed before and exist in future -> update
            } else {
                // Existed before and not exist in future -> delete
                idsToDelete.add(existingInvoiceMessageId);
            }
        }
        for (String futureInvoiceMessageId : futureIds) {
            if (existingIds.contains(futureInvoiceMessageId)) {
                // Existed before and exist in future -> update
            } else {
                // Not existed before and exists in future -> insert
                idsToInsert.add(futureInvoiceMessageId);
            }
        }
    }

    public Set<String> getIdsToInsert() {
        return idsToInsert;
    }

    public Set<String> getIdsToDelete() {
        return idsToDelete;
    }
}
