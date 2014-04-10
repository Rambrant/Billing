package com.tradedoubler.billing.service.ax;

import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdEntityCustTable;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgcustbank.AxdEntityCustBankAccount;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalescla.AxdEntityMDSSalesClientAgreement;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalesinvr.AxdEntityMDSSalesInvoiceRule;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes.AxdEntityMDSSalesInvoiceMessage;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.AxdEntityMDSSalesInvoiceRecipient;
import com.tradedoubler.billing.domain.Guid;
import com.tradedoubler.billing.domain.Market;
import com.tradedoubler.billing.service.ax.webservice.call.*;
import com.tradedoubler.billing.service.ax.webservice.domainhandler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Thomas Rambrant (thore)
 */

@Component
public class AxReader
{
    @Autowired
    private AgreementHandler agreementHandler;

    @Autowired
    private ClientHandler clientHandler;

    @Autowired
    private InvoicingRuleHandler invoicingRuleHandler;

    @Autowired
    InvoiceMessageRuleHandler invoiceMessageRuleHandler;

    @Autowired
    private BankHandler bankHandler;

    @Autowired
    private InvoiceRecipientHandler invoiceRecipientHandler;


    AxdEntityMDSSalesClientAgreement getAgreement( String agreementId, Market market)
    {
        try
        {
            FindAgreementCall findAgreementCall = agreementHandler.findAgreementByPk(
                agreementId,
                market);

            //
            // The handler guaranties that we only have, at most, one agreement in the array
            //
            if( findAgreementCall.getSalesClientAgreements().size() == 1)
            {
                return findAgreementCall.getSalesClientAgreements().get( 0);
            }

            return null;
        }
        catch( Exception e)
        {
            return null;
        }
    }

    AxdEntityCustTable getClient( String clientId, Market market)
    {
        try
        {
            FindClientCall findClientCall = clientHandler.findClientByPk(
                clientId,
                market );

            return findClientCall.getCustomer();
        }
        catch( Exception e)
        {
            return null;
        }
    }

    AxdEntityMDSSalesInvoiceRule getInvoicingRule( String invoiceId)
    {
        try
        {
            FindInvoicingRuleCall findInvoicingRuleCall = invoicingRuleHandler.findInvoicingRuleByPk(
                new Guid( invoiceId ),
                new Market( 51 ) );

            return findInvoicingRuleCall.getInvoiceRule();
        }
        catch( Exception e)
        {
            return null;
        }
    }

    AxdEntityMDSSalesInvoiceMessage getInvoiceMessageRule( String invoiceMessageId)
    {
        try
        {
            FindInvoiceMessageRuleCall findInvoiceMessageRuleCall = invoiceMessageRuleHandler.findInvoiceMessageRuleByPk(
                new Guid( invoiceMessageId ),
                new Market( 51 ) );

            //
            // The handler guaranties that we only have, at most, one invoice message in the array
            //
            if( findInvoiceMessageRuleCall.getInvoiceMessageList().size() == 1)
            {
                return findInvoiceMessageRuleCall.getInvoiceMessageList().get( 0);
            }

            return null;
        }
        catch( Exception e)
        {
            return null;
        }
    }

    AxdEntityMDSSalesInvoiceMessage getMarketMessage( String invoiceMessageId, Market market)
    {
        try
        {
            FindInvoiceMessageRuleCall findInvoiceMessageRuleCall = invoiceMessageRuleHandler.findInvoiceMessageRuleByPk(
                new Guid( invoiceMessageId),
                market);

            //
            // The handler guaranties that we only have, at most, one invoice message in the array
            //
            if( findInvoiceMessageRuleCall.getInvoiceMessageList().size() == 1)
            {
                return findInvoiceMessageRuleCall.getInvoiceMessageList().get( 0);
            }

            return null;
        }
        catch( Exception e)
        {
            return null;
        }
    }

    AxdEntityCustBankAccount getBank( String bankId, Market market)
    {
        try
        {
            FindBankCall findInvoiceMessageRuleCall = bankHandler.findBankByPk(
                bankId,
                market);

            //
            // The handler guaranties that we only have, at most, one bank in the array
            //
            if( findInvoiceMessageRuleCall.getBanks().size() == 1)
            {
                return findInvoiceMessageRuleCall.getBanks().get( 0);
            }

            return null;
        }
        catch( Exception e)
        {
            return null;
        }
    }

    AxdEntityMDSSalesInvoiceRecipient getInvoiceRecipient( String recipientId)
    {
        try
        {
            FindInvoiceRecipientCall findInvoiceRecipientCall = invoiceRecipientHandler.findInvoiceRecipientByPk(
                new Guid( recipientId),
                new Market( 51));

            return findInvoiceRecipientCall.getInvoiceRecipient();
        }
        catch( Exception e)
        {
            return null;
        }
    }

    List< AxdEntityMDSSalesInvoiceRecipient> getInvoiceRecipientByInvoicingRuleId( String invoicingRuleId)
    {
        try
        {
            FindInvoiceRecipientsByInvoicingRuleCall findInvoiceRecipientCall = invoiceRecipientHandler.findInvoiceRecipientsByInvoicingRule(
                new Guid( invoicingRuleId),
                new Market( 51));

            return findInvoiceRecipientCall.getInvoiceRecipients();
        }
        catch( Exception e)
        {
            return null;
        }
    }
}
