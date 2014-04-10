
package org.datacontract.schemas._2004._07.dynamics_ax;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.dynamics_ax package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MDSITGSalesOrderBasisLineImportError_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", "MDS_ITG_SalesOrderBasisLineImportError");
    private final static QName _MDSITGSalesOrderBasisLineContract_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", "MDS_ITGSalesOrderBasisLineContract");
    private final static QName _NoYes_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", "NoYes");
    private final static QName _MDSSalesOrderBasisLineStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", "MDS_SalesOrderBasisLineStatus");
    private final static QName _ArrayOfMDSITGSalesOrderBasisLineContract_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", "ArrayOfMDS_ITGSalesOrderBasisLineContract");
    private final static QName _MDSITGSalesOrderBasisLineContractParmOrderItemId_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", "parmOrderItemId");
    private final static QName _MDSITGSalesOrderBasisLineContractParmDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", "parmDescription");
    private final static QName _MDSITGSalesOrderBasisLineContractParmSplitterValue_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", "parmSplitterValue");
    private final static QName _MDSITGSalesOrderBasisLineContractParmPeriod_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", "parmPeriod");
    private final static QName _MDSITGSalesOrderBasisLineContractParmErrorMsg_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", "parmErrorMsg");
    private final static QName _MDSITGSalesOrderBasisLineContractParmOrderBasisLineId_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", "parmOrderBasisLineId");
    private final static QName _MDSITGSalesOrderBasisLineContractParmCreditedInvoiceId_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", "parmCreditedInvoiceId");
    private final static QName _MDSITGSalesOrderBasisLineContractParmClientAgreementSourceSystemAgreement_QNAME = new QName("http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", "parmClientAgreementSourceSystemAgreement");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.dynamics_ax
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ArrayOfMDSITGSalesOrderBasisLineContract }
     * 
     */
    public ArrayOfMDSITGSalesOrderBasisLineContract createArrayOfMDSITGSalesOrderBasisLineContract() {
        return new ArrayOfMDSITGSalesOrderBasisLineContract();
    }

    /**
     * Create an instance of {@link MDSITGSalesOrderBasisLineContract }
     * 
     */
    public MDSITGSalesOrderBasisLineContract createMDSITGSalesOrderBasisLineContract() {
        return new MDSITGSalesOrderBasisLineContract();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MDSITGSalesOrderBasisLineImportError }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", name = "MDS_ITG_SalesOrderBasisLineImportError")
    public JAXBElement<MDSITGSalesOrderBasisLineImportError> createMDSITGSalesOrderBasisLineImportError(MDSITGSalesOrderBasisLineImportError value) {
        return new JAXBElement<MDSITGSalesOrderBasisLineImportError>(_MDSITGSalesOrderBasisLineImportError_QNAME, MDSITGSalesOrderBasisLineImportError.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MDSITGSalesOrderBasisLineContract }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", name = "MDS_ITGSalesOrderBasisLineContract")
    public JAXBElement<MDSITGSalesOrderBasisLineContract> createMDSITGSalesOrderBasisLineContract(MDSITGSalesOrderBasisLineContract value) {
        return new JAXBElement<MDSITGSalesOrderBasisLineContract>(_MDSITGSalesOrderBasisLineContract_QNAME, MDSITGSalesOrderBasisLineContract.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoYes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", name = "NoYes")
    public JAXBElement<NoYes> createNoYes(NoYes value) {
        return new JAXBElement<NoYes>(_NoYes_QNAME, NoYes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MDSSalesOrderBasisLineStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", name = "MDS_SalesOrderBasisLineStatus")
    public JAXBElement<MDSSalesOrderBasisLineStatus> createMDSSalesOrderBasisLineStatus(MDSSalesOrderBasisLineStatus value) {
        return new JAXBElement<MDSSalesOrderBasisLineStatus>(_MDSSalesOrderBasisLineStatus_QNAME, MDSSalesOrderBasisLineStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfMDSITGSalesOrderBasisLineContract }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", name = "ArrayOfMDS_ITGSalesOrderBasisLineContract")
    public JAXBElement<ArrayOfMDSITGSalesOrderBasisLineContract> createArrayOfMDSITGSalesOrderBasisLineContract(ArrayOfMDSITGSalesOrderBasisLineContract value) {
        return new JAXBElement<ArrayOfMDSITGSalesOrderBasisLineContract>(_ArrayOfMDSITGSalesOrderBasisLineContract_QNAME, ArrayOfMDSITGSalesOrderBasisLineContract.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", name = "parmOrderItemId", scope = MDSITGSalesOrderBasisLineContract.class)
    public JAXBElement<String> createMDSITGSalesOrderBasisLineContractParmOrderItemId(String value) {
        return new JAXBElement<String>(_MDSITGSalesOrderBasisLineContractParmOrderItemId_QNAME, String.class, MDSITGSalesOrderBasisLineContract.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", name = "parmDescription", scope = MDSITGSalesOrderBasisLineContract.class)
    public JAXBElement<String> createMDSITGSalesOrderBasisLineContractParmDescription(String value) {
        return new JAXBElement<String>(_MDSITGSalesOrderBasisLineContractParmDescription_QNAME, String.class, MDSITGSalesOrderBasisLineContract.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", name = "parmSplitterValue", scope = MDSITGSalesOrderBasisLineContract.class)
    public JAXBElement<String> createMDSITGSalesOrderBasisLineContractParmSplitterValue(String value) {
        return new JAXBElement<String>(_MDSITGSalesOrderBasisLineContractParmSplitterValue_QNAME, String.class, MDSITGSalesOrderBasisLineContract.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", name = "parmPeriod", scope = MDSITGSalesOrderBasisLineContract.class)
    public JAXBElement<String> createMDSITGSalesOrderBasisLineContractParmPeriod(String value) {
        return new JAXBElement<String>(_MDSITGSalesOrderBasisLineContractParmPeriod_QNAME, String.class, MDSITGSalesOrderBasisLineContract.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", name = "parmErrorMsg", scope = MDSITGSalesOrderBasisLineContract.class)
    public JAXBElement<String> createMDSITGSalesOrderBasisLineContractParmErrorMsg(String value) {
        return new JAXBElement<String>(_MDSITGSalesOrderBasisLineContractParmErrorMsg_QNAME, String.class, MDSITGSalesOrderBasisLineContract.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", name = "parmOrderBasisLineId", scope = MDSITGSalesOrderBasisLineContract.class)
    public JAXBElement<String> createMDSITGSalesOrderBasisLineContractParmOrderBasisLineId(String value) {
        return new JAXBElement<String>(_MDSITGSalesOrderBasisLineContractParmOrderBasisLineId_QNAME, String.class, MDSITGSalesOrderBasisLineContract.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", name = "parmCreditedInvoiceId", scope = MDSITGSalesOrderBasisLineContract.class)
    public JAXBElement<String> createMDSITGSalesOrderBasisLineContractParmCreditedInvoiceId(String value) {
        return new JAXBElement<String>(_MDSITGSalesOrderBasisLineContractParmCreditedInvoiceId_QNAME, String.class, MDSITGSalesOrderBasisLineContract.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Dynamics.Ax.Application", name = "parmClientAgreementSourceSystemAgreement", scope = MDSITGSalesOrderBasisLineContract.class)
    public JAXBElement<String> createMDSITGSalesOrderBasisLineContractParmClientAgreementSourceSystemAgreement(String value) {
        return new JAXBElement<String>(_MDSITGSalesOrderBasisLineContractParmClientAgreementSourceSystemAgreement_QNAME, String.class, MDSITGSalesOrderBasisLineContract.class, value);
    }

}
