package com.tradedoubler.billing.service.ax.webservice.domainhandler;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalescla.AxdEntityMDSSalesClientAgreement;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.call.*;
import com.tradedoubler.billing.transform.webservice.AgreementToWsTransformer;
import org.slf4j.*;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBElement;

/**
 * This class contains convenient methods that translates the Agreements and communicates them to the AX-web service.
 *
 * @author bjoek
 * @since 2012-09-03
 */
@Component
public class AgreementHandler extends AbstractHandler {

    private final static Logger log = LoggerFactory.getLogger(AgreementHandler.class);

    /** Insert new Agreement */
    public void insertAgreement(Agreement agreement) throws BillingServiceException {
        String dataAreaId = converter.convert(agreement.getMarketId());

        //Transform domain object to an AxRepresentation
        AxdEntityMDSSalesClientAgreement axSalesClientAgreement = new AgreementToWsTransformer(converter, agreement, dataAreaId).transform();

        //Create the request based on the provided AxWebServiceSetup
        InsertAgreementCall insertClientAgreementCall = webServiceCallFactory.createCall(InsertAgreementCall.class);

        //Execute the request on the AxRepresentation
        log.debug("Inserting client agreement : " + axSalesClientAgreement.getSourceSystemAgreementId());
        insertClientAgreementCall.execute(axSalesClientAgreement);

        // Handle error codes by throwing correct exception
        callResultHandler.handleInsertResult(insertClientAgreementCall);

    }

    /** Update existing Agreement */
    public void updateAgreement(FindAgreementCall findCall, Agreement agreement) throws BillingServiceException {
        String dataAreaId = converter.convert(agreement.getMarketId());
        JAXBElement<String> documentHash = findCall.getDocumentHash();

        //Transform domain object to an AxRepresentation
        AgreementToWsTransformer transformer = new AgreementToWsTransformer(converter, agreement, dataAreaId);
        AxdEntityMDSSalesClientAgreement salesClientAgreement = transformer.transformForUpdate(documentHash);

        UpdateAgreementCall updateCall = webServiceCallFactory.createCall(UpdateAgreementCall.class);

        // Execute request
        log.debug("Update client agreement : " + salesClientAgreement.getSourceSystemAgreementId());
        updateCall.execute(salesClientAgreement);

        // Handle error codes by throwing correct exception
        callResultHandler.handleUpdateResult(updateCall);
    }

    /** Find an Agreement that may exists */
    public FindAgreementCall findAgreementByPk(String sourceSystemAgreementId, Market marketId) throws BillingServiceException {
        String dataAreaId = converter.convert(marketId);

        FindAgreementCall findAgreementCall = webServiceCallFactory.createCall(FindAgreementCall.class);

        // Execute request
        log.debug("Find client agreement : " + sourceSystemAgreementId);
        findAgreementCall.execute(sourceSystemAgreementId, dataAreaId);

        // Handle error codes by throwing correct exception
        callResultHandler.handleFindResult(findAgreementCall);

        // Errorhandling if more than one entity is found
        if (findAgreementCall.getNumberOfAgreements() > 1) {
            throw BillingServiceException.createBugDisturbance("Found more than one Agreement in Ax with AgreementId: " + sourceSystemAgreementId);
        }

        return findAgreementCall;
    }

}
