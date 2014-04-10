package com.tradedoubler.billing.transform.webservice;

import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsalescla.*;
import com.microsoft.schemas.dynamics._2008._01.sharedtypes.AxdEnumAxdEntityAction;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.service.transform.AxConverterService;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;

import static com.tradedoubler.billing.transform.webservice.AxUtil.convertNullToEmptyString;

/**
 * Convert an Agreement to Ax representation of the same
 * 
 * User: erigu
 * Date: 2012-06-25
 */
public class AgreementToWsTransformer {
    private static final Timestamp DEFAULT_NULL_VALID_FROM_DATE = new Timestamp("1901-01-01T00:00:00.000+02:00");
    private static final Timestamp DEFAULT_NULL_VALID_TO_DATE = new Timestamp("2154-12-31T00:00:00.000+02:00");
    private final AxConverterService converter;
    private final Agreement agreement;
    private final String dataAreaId;

    public AgreementToWsTransformer(AxConverterService converter, Agreement agreement, String dataAreaId) {
        this.converter = converter;
        this.agreement = agreement;
        this.dataAreaId = dataAreaId;
    }

    public AxdEntityMDSSalesClientAgreement transformForUpdate(JAXBElement<String> documentHash) {
        AxdEntityMDSSalesClientAgreement clientAgreement = transform();
        updateEntityWithDocumentHash(documentHash, clientAgreement);
        return clientAgreement;
    }

    private AxdEntityMDSSalesClientAgreement updateEntityWithDocumentHash(JAXBElement<String> documentHash, AxdEntityMDSSalesClientAgreement salesClientAgreement) {
        salesClientAgreement.setClazz("entity");
        salesClientAgreement.setAction(AxdEnumAxdEntityAction.UPDATE);
        salesClientAgreement.setDocumentHash(documentHash);

        return salesClientAgreement;
    }

    public AxdEntityMDSSalesClientAgreement transform() {
        ObjectFactory factory = new ObjectFactory();

        AxdEntityMDSSalesClientAgreement clientAgreement = new AxdEntityMDSSalesClientAgreement();
        clientAgreement.setBelongsToDataAreaId(dataAreaId);
        clientAgreement.setClazz("entity");
        clientAgreement.setCurrencyCode(converter.convert(agreement.getCurrencyCode()));
        clientAgreement.setCustId(agreement.getClientId());
        clientAgreement.setDescription(agreement.getDescription());
        clientAgreement.setDocumentLink(factory.createAxdEntityMDSSalesClientAgreementDocumentLink(
                convertNullToEmptyString(agreement.getDocumentLink())));
        clientAgreement.setInvoiceRuleId(agreement.getInvoicingRuleId().getGuidForAx());
        clientAgreement.setProductTypeId(converter.convert(agreement.getProductType()));
        clientAgreement.setSourceSystemAgreementId(agreement.getSourceSystemAgreementId());

        Timestamp validFromTimestamp = agreement.getValidFrom() == null ? DEFAULT_NULL_VALID_FROM_DATE : agreement.getValidFrom();
        XMLGregorianCalendar validFrom = DateConverter.convertISO8601ToXMLGregorianCalendar(validFromTimestamp.getTimestamp());
        clientAgreement.setValidFrom(validFrom);

        Timestamp validToTimestamp = agreement.getValidTo() == null ? DEFAULT_NULL_VALID_TO_DATE : agreement.getValidTo();
        XMLGregorianCalendar validTo = DateConverter.convertISO8601ToXMLGregorianCalendar(validToTimestamp.getTimestamp());
        clientAgreement.setValidTo(validTo);

        return clientAgreement;
    }

}
