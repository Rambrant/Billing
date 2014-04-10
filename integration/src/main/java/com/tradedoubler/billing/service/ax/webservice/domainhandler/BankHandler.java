package com.tradedoubler.billing.service.ax.webservice.domainhandler;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgcustbank.AxdEntityCustBankAccount;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.call.*;
import com.tradedoubler.billing.transform.webservice.BankToAxCustBankAccountTransformer;
import org.slf4j.*;
import org.springframework.stereotype.Component;

/**
 * This class contains convenient methods that translates the Banks and communicates them to the AX-web service.
 *
 * @author bjoek
 * @since 2012-09-03
 */
@Component
public class BankHandler extends AbstractHandler {

    private final static Logger log = LoggerFactory.getLogger(BankHandler.class);

    /** All banks have account id "1". Even if another value is used, Ax will set it to "1" */
    public static final String CONSTANT_BANK_ACCOUNT_ID = "1";

    /**
     * Insert new bank in Ax
     */
    public void insertBank(Bank bank) throws BillingServiceException {
        String dataAreaId = converter.convert(bank.getMarketId());

        // Transform
        AxdEntityCustBankAccount axCustomerBank = new BankToAxCustBankAccountTransformer(CONSTANT_BANK_ACCOUNT_ID, bank).transform();

        // Create web service call
        InsertBankCall insertBankCall = webServiceCallFactory.createCall(InsertBankCall.class);

        log.debug(String.format("Inserting bank : %s dataAreaId: %s",
                bank.getBankAccount(), dataAreaId));

        // Execute web service call
        insertBankCall.execute(axCustomerBank, dataAreaId);

        // Handle error codes by throwing correct exception
        callResultHandler.handleInsertResult(insertBankCall);
    }

    /** Find a bank that may exist */
    public FindBankCall findBankByPk(String clientId, Market marketId) throws BillingServiceException {
        String dataAreaId = converter.convert(marketId);

        // Create web service call
        FindBankCall findBankCall = webServiceCallFactory.createCall(FindBankCall.class);

        log.debug(String.format("Find bank, id : %s, accountNum: %s",
                CONSTANT_BANK_ACCOUNT_ID, clientId));

        // Execute web service call
        //According to info in CustBank and Customer IDDs
        findBankCall.execute(CONSTANT_BANK_ACCOUNT_ID, clientId, dataAreaId);

        // Error handling
        callResultHandler.handleFindResult(findBankCall);

        // Errorhandling if more than one entity is found
        if (findBankCall.getNumberOfBanks() > 1) {
            throw BillingServiceException.createBugDisturbance(String.format("Found more than one Bank in Ax with bankAccount : %s, accountNum: %s",
                    CONSTANT_BANK_ACCOUNT_ID, clientId));
        }

        return findBankCall;
    }

    /** Update existing Bank */
    public void updateBank(FindBankCall findCall, Bank bank, Market marketId) throws BillingServiceException {
        // Transform the bank to axCustBankAccount
        AxdEntityCustBankAccount axCustomerBank = new BankToAxCustBankAccountTransformer(CONSTANT_BANK_ACCOUNT_ID, bank).transformForUpdate(findCall);

        String dataAreaId = converter.convert(marketId);

        // Create web service call
        UpdateBankCall updateBankCall = webServiceCallFactory.createCall(UpdateBankCall.class);

        log.debug(String.format("Updating bank : %s dataAreaId: %s",
                axCustomerBank.getAccountID(), dataAreaId));

        // Execute web service call
        updateBankCall.execute(axCustomerBank, dataAreaId);

        // Handle error codes by throwing correct exception
        callResultHandler.handleUpdateResult(updateBankCall);
    }

}
