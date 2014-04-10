package com.tradedoubler.billing.transform.webservice;

import com.microsoft.schemas.dynamics._2008._01.documents.customer.*;
import com.tradedoubler.billing.domain.*;
import com.tradedoubler.billing.platform.logging.LogError;
import com.tradedoubler.billing.service.BillingServiceException;
import com.tradedoubler.billing.service.ax.webservice.call.*;
import com.tradedoubler.billing.service.transform.AxConverterService;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.tradedoubler.billing.transform.webservice.AxUtil.convertNullToEmptyString;


/**
 * Transforms a domain Client to a Customer WebService object.<br>
 * Two transforms area present:<br>
 * one for create Customer and one for update Customer.
 * <p/>
 * User: erigu
 * Date: 2012-08-13
 */
public class ClientToAxCustomerTransformer {
    private final static org.slf4j.Logger log = LoggerFactory.getLogger(ClientToAxCustomerTransformer.class);
    private final AxConverterService converter;
    private final ObjectFactory objectFactory = new ObjectFactory();


    public ClientToAxCustomerTransformer(AxConverterService converter) {
        this.converter = converter;
    }

    /**
     * Transform the Client to a webservice AxdCustomer.
     *
     */
    public AxdCustomer transform(ContainsBasicClientInfo client) throws BillingServiceException {
        AxdCustomer axdCustomer = new AxdCustomer();

        //Create and add Customer table
        AxdEntityCustTable custTable = createCustTable(client);
        axdCustomer.getCustTable().add(custTable);


        return axdCustomer;
    }

    AxdCustomer transform(AxdCustomer client) {
        AxdCustomer axdCustomer = new AxdCustomer();

        //Create and add Customer table
        List<AxdEntityCustTable> custTableList = client.getCustTable();
        logErrorForMultipleEntries(custTableList, "Customer custTable");
        AxdEntityCustTable custTable = createCustTable(custTableList.get(0));
        axdCustomer.getCustTable().add(custTable);


        return axdCustomer;
    }

    /**
     * Transform with adding ValidAsOfDateTime, documentHash, recIDs as stated in the MDS_ITG documentation.
     *
     * @param readClientCall Contains ValidAsOfDateTime, documentHash and recIDs from the previous readCall.
     */
    public AxdCustomer transformForUpdate(Client client, ReadClientCall readClientCall) throws BillingServiceException {
        //First do same transform as for create customer
        AxdCustomer axdCustomer = transform(client);

        //Then add update specific tags. Some which are taken from the previous read-call
        AxUtil.addUpdateInfoOnCustomer(axdCustomer, readClientCall.getValidAsOfDateTime(), readClientCall.getDocumentHash(), readClientCall.getDirPartyRecId(), readClientCall.getDirPartyPostalAddressViewRecId());

        return axdCustomer;
    }

    public AxdCustomer transformForUpdate(ContainsBasicClientInfo client, FindClientCall findCall) throws BillingServiceException {
        //First do same transform as for create customer
        AxdCustomer axdCustomer = transform(client);

        //Then add update specific tags. Some which are taken from the previous read-call
        AxUtil.addUpdateInfoOnCustomer(axdCustomer, findCall.getValidAsOfDateTime(), findCall.getDocumentHash(), findCall.getDirPartyRecId(), findCall.getDirPartyPostalAddressViewRecId());

        return axdCustomer;
    }

    /** Transform existing customer with updated bank info */
    public AxdCustomer transformForUpdate(AxdCustomer client, String bankAccount, ReadClientCall readCall) throws BillingServiceException {
        //First do same transform as for create customer
        AxdCustomer axdCustomer = transform(client);

        AxUtil.updateCustomerForBankAccount(axdCustomer, bankAccount);

        //Then add update specific tags. Some which are taken from the previous read-call
        AxUtil.addUpdateInfoOnCustomer(axdCustomer, readCall.getValidAsOfDateTime(), readCall.getDocumentHash(), readCall.getDirPartyRecId(), readCall.getDirPartyPostalAddressViewRecId());


        return axdCustomer;
    }

    private AxdEntityCustTable createCustTable(ContainsBasicClientInfo client) throws BillingServiceException {
        AxdEntityCustTable custTable = new AxdEntityCustTable();
        custTable.setClazz("entity");
        custTable.setAccountNum(objectFactory.createAxdEntityCustTableAccountNum(client.getClientId()));
        custTable.setCustGroup("External");
        custTable.setIdentificationNumber(objectFactory.createAxdEntityCustTableIdentificationNumber(
                convertNullToEmptyString(client.getBusinessFormCode())));
        custTable.setVATNum(objectFactory.createAxdEntityCustTableVATNum(
                convertNullToEmptyString(client.getVatNumber())));

        AxdEntityDirPartyDirOrganization dirParty = new AxdEntityDirPartyDirOrganization();
        dirParty.setClazz("entity");
        dirParty.setLanguageId(objectFactory.createAxdEntityDirPartyDirPartyTableLanguageId(converter.convert(client.getInvoiceLanguage())));
        dirParty.setName(objectFactory.createAxdEntityDirPartyDirPartyTableName(client.getRegisteredCompanyName()));
        dirParty.setOrgNumber(objectFactory.createAxdEntityDirPartyDirOrganizationOrgNumber(client.getCompanyRegistrationNumber()));

        AxdEntityDirPartyPostalAddressView dirPartyPostalAddressView = createDirPartyPostalAddressView(client);
        dirParty.getDirPartyPostalAddressView().add(dirPartyPostalAddressView);
        custTable.getDirParty().add(dirParty);


        return custTable;
    }

    private AxdEntityDirPartyPostalAddressView createDirPartyPostalAddressView(ContainsBasicClientInfo client) throws BillingServiceException {
        AxdEntityDirPartyPostalAddressView dirPartyPostalAddressView = new AxdEntityDirPartyPostalAddressView();
        dirPartyPostalAddressView.setClazz("entity");

        Address registeredAddress = client.getRegisteredAddress();
        dirPartyPostalAddressView.setCity(objectFactory.createAxdEntityDirPartyPostalAddressViewCity(registeredAddress.getCity()));
        /*Mapping below should be correct according to excel map document*/
        dirPartyPostalAddressView.setCountryRegionId(objectFactory.createAxdEntityDirPartyPostalAddressViewCountryRegionId(converter.convert(registeredAddress.getCountryCode())));
        dirPartyPostalAddressView.setRoles(objectFactory.createAxdEntityDirPartyPostalAddressViewRoles(converter.convert(registeredAddress.getAddressType())));

        String street = AxUtil.createStreet(registeredAddress.getLine1(), registeredAddress.getLine2());
        dirPartyPostalAddressView.setStreet(objectFactory.createAxdEntityDirPartyPostalAddressViewStreet(street));

        dirPartyPostalAddressView.setBuildingCompliment(objectFactory.createAxdEntityDirPartyPostalAddressViewBuildingCompliment(
                convertNullToEmptyString(registeredAddress.getCounty())));

        dirPartyPostalAddressView.setZipCode(objectFactory.createAxdEntityDirPartyPostalAddressViewZipCode(registeredAddress.getPostalCode()));

        return dirPartyPostalAddressView;
    }

    private AxdEntityCustTable createCustTable(AxdEntityCustTable client) {
        List<AxdEntityDirPartyDirPartyTable> dirPartyList = client.getDirParty();
        logErrorForMultipleEntries(dirPartyList, "Customer custTable dirParty");
        AxdEntityDirPartyDirOrganization clientDirParty = (AxdEntityDirPartyDirOrganization) dirPartyList.get(0);

        List<AxdEntityDirPartyPostalAddressView> postalAddressViewList = clientDirParty.getDirPartyPostalAddressView();
        logErrorForMultipleEntries(postalAddressViewList, "Customer custTable dirParty postalAddressView");
        AxdEntityDirPartyPostalAddressView clientAddressView = postalAddressViewList.get(0);

        AxdEntityCustTable custTable = new AxdEntityCustTable();
        custTable.setClazz("entity");
        custTable.setAccountNum(client.getAccountNum());
        custTable.setCustGroup("External");
        custTable.setIdentificationNumber(client.getIdentificationNumber());
        custTable.setVATNum(client.getVATNum());

        AxdEntityDirPartyDirOrganization dirParty = new AxdEntityDirPartyDirOrganization();
        dirParty.setClazz("entity");
        dirParty.setLanguageId(clientDirParty.getLanguageId());
        dirParty.setName(clientDirParty.getName());
        dirParty.setOrgNumber(clientDirParty.getOrgNumber());

        AxdEntityDirPartyPostalAddressView dirPartyPostalAddressView = createDirPartyPostalAddressView(clientAddressView);
        dirParty.getDirPartyPostalAddressView().add(dirPartyPostalAddressView);
        custTable.getDirParty().add(dirParty);

        return custTable;
    }

    private AxdEntityDirPartyPostalAddressView createDirPartyPostalAddressView(AxdEntityDirPartyPostalAddressView client) {
        AxdEntityDirPartyPostalAddressView dirPartyPostalAddressView = new AxdEntityDirPartyPostalAddressView();
        dirPartyPostalAddressView.setClazz("entity");

        dirPartyPostalAddressView.setCity(client.getCity());
        dirPartyPostalAddressView.setCountryRegionId(client.getCountryRegionId());
        dirPartyPostalAddressView.setRoles(client.getRoles());

        dirPartyPostalAddressView.setStreet(client.getStreet());
        dirPartyPostalAddressView.setCity(client.getCity());
        dirPartyPostalAddressView.setCounty(client.getCounty());

        dirPartyPostalAddressView.setZipCode(client.getZipCode());

        return dirPartyPostalAddressView;
    }

    private static void logErrorForMultipleEntries(List<?> list, String objectMessage) {
        int size = list.size();
        if (size != 1) {
            log.error(LogError.AX_INCONSISTENCY.name(), String.format("%s contained %d entries, expected only one entry", objectMessage, size));
        }
    }
}
