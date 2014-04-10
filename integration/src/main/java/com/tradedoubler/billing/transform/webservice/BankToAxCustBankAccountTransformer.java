package com.tradedoubler.billing.transform.webservice;


import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgcustbank.*;
import com.tradedoubler.billing.domain.Bank;
import com.tradedoubler.billing.service.ax.webservice.call.*;


/**
 * Transforms a domain Client to a Customer WebService object.<br>
 * Two transforms area present:<br>
 * one for create Customer and one for update Customer.
 * <p/>
 * User: erigu
 * Date: 2012-08-13
 */
public class BankToAxCustBankAccountTransformer {
    private final String bankAccountId;
    private final Bank bankAccount;
    private final ObjectFactory objectFactory = new ObjectFactory();

    public BankToAxCustBankAccountTransformer(String bankAccountId, Bank bankAccount) {
        this.bankAccountId = bankAccountId;
        this.bankAccount = bankAccount;
    }

    /**
     * Transform the Bank to a webservice AxdEntityCustBankAccount.
     *
     * @return the transformed bank entity
     */
    public AxdEntityCustBankAccount transform() {
        AxdEntityCustBankAccount custBankAccount = objectFactory.createAxdEntityCustBankAccount();
        custBankAccount.setClazz("entity");
        custBankAccount.setAccountID(bankAccountId);
        custBankAccount.setAccountNum(objectFactory.createAxdEntityCustBankAccountAccountNum(bankAccount.getBankAccount()));
        custBankAccount.setName(objectFactory.createAxdEntityCustBankAccountName(bankAccount.getAccountOwner()));
        custBankAccount.setRegistrationNum(objectFactory.createAxdEntityCustBankAccountRegistrationNum(bankAccount.getBankCode()));
        custBankAccount.setCustAccount(bankAccount.getClientId());

        return custBankAccount;
    }


    public AxdEntityCustBankAccount transformForUpdate(FindBankCall findCall) {
        AxdEntityCustBankAccount axCustBankAccount = transform();
        AxUtil.addUpdateInfoOnBankAccount(axCustBankAccount, findCall.getDocumentHash());
        return axCustBankAccount;
    }
}
