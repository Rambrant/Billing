
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.datacontract.schemas._2004._07.dynamics_ax.ArrayOfMDSITGSalesOrderBasisLineContract;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
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

    private final static QName _MDSSalesOrderBasisLineServiceOrderBasisLineInboundResponseResponse_QNAME = new QName("http://tempuri.org", "response");
    private final static QName _MDSSalesOrderBasisLineServiceOrderBasisLineInboundRequestOrderBasisLine_QNAME = new QName("http://tempuri.org", "_orderBasisLine");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MDSSalesOrderBasisLineServiceOrderBasisLineInboundResponse }
     * 
     */
    public MDSSalesOrderBasisLineServiceOrderBasisLineInboundResponse createMDSSalesOrderBasisLineServiceOrderBasisLineInboundResponse() {
        return new MDSSalesOrderBasisLineServiceOrderBasisLineInboundResponse();
    }

    /**
     * Create an instance of {@link MDSSalesOrderBasisLineServiceOrderBasisLineInboundRequest }
     * 
     */
    public MDSSalesOrderBasisLineServiceOrderBasisLineInboundRequest createMDSSalesOrderBasisLineServiceOrderBasisLineInboundRequest() {
        return new MDSSalesOrderBasisLineServiceOrderBasisLineInboundRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfMDSITGSalesOrderBasisLineContract }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org", name = "response", scope = MDSSalesOrderBasisLineServiceOrderBasisLineInboundResponse.class)
    public JAXBElement<ArrayOfMDSITGSalesOrderBasisLineContract> createMDSSalesOrderBasisLineServiceOrderBasisLineInboundResponseResponse(ArrayOfMDSITGSalesOrderBasisLineContract value) {
        return new JAXBElement<ArrayOfMDSITGSalesOrderBasisLineContract>(_MDSSalesOrderBasisLineServiceOrderBasisLineInboundResponseResponse_QNAME, ArrayOfMDSITGSalesOrderBasisLineContract.class, MDSSalesOrderBasisLineServiceOrderBasisLineInboundResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfMDSITGSalesOrderBasisLineContract }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org", name = "_orderBasisLine", scope = MDSSalesOrderBasisLineServiceOrderBasisLineInboundRequest.class)
    public JAXBElement<ArrayOfMDSITGSalesOrderBasisLineContract> createMDSSalesOrderBasisLineServiceOrderBasisLineInboundRequestOrderBasisLine(ArrayOfMDSITGSalesOrderBasisLineContract value) {
        return new JAXBElement<ArrayOfMDSITGSalesOrderBasisLineContract>(_MDSSalesOrderBasisLineServiceOrderBasisLineInboundRequestOrderBasisLine_QNAME, ArrayOfMDSITGSalesOrderBasisLineContract.class, MDSSalesOrderBasisLineServiceOrderBasisLineInboundRequest.class, value);
    }

}
