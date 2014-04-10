
package org.datacontract.schemas._2004._07.microsoft_dynamics_ax_framework;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.microsoft_dynamics_ax_framework package. 
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

    private final static QName _ArrayOfInfologMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/Microsoft.Dynamics.AX.Framework.Services", "ArrayOfInfologMessage");
    private final static QName _InfologMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/Microsoft.Dynamics.AX.Framework.Services", "InfologMessage");
    private final static QName _InfologMessageType_QNAME = new QName("http://schemas.datacontract.org/2004/07/Microsoft.Dynamics.AX.Framework.Services", "InfologMessageType");
    private final static QName _InfologMessageMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/Microsoft.Dynamics.AX.Framework.Services", "Message");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.microsoft_dynamics_ax_framework
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ArrayOfInfologMessage }
     * 
     */
    public ArrayOfInfologMessage createArrayOfInfologMessage() {
        return new ArrayOfInfologMessage();
    }

    /**
     * Create an instance of {@link InfologMessage }
     * 
     */
    public InfologMessage createInfologMessage() {
        return new InfologMessage();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfInfologMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Microsoft.Dynamics.AX.Framework.Services", name = "ArrayOfInfologMessage")
    public JAXBElement<ArrayOfInfologMessage> createArrayOfInfologMessage(ArrayOfInfologMessage value) {
        return new JAXBElement<ArrayOfInfologMessage>(_ArrayOfInfologMessage_QNAME, ArrayOfInfologMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfologMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Microsoft.Dynamics.AX.Framework.Services", name = "InfologMessage")
    public JAXBElement<InfologMessage> createInfologMessage(InfologMessage value) {
        return new JAXBElement<InfologMessage>(_InfologMessage_QNAME, InfologMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfologMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Microsoft.Dynamics.AX.Framework.Services", name = "InfologMessageType")
    public JAXBElement<InfologMessageType> createInfologMessageType(InfologMessageType value) {
        return new JAXBElement<InfologMessageType>(_InfologMessageType_QNAME, InfologMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Microsoft.Dynamics.AX.Framework.Services", name = "Message", scope = InfologMessage.class)
    public JAXBElement<String> createInfologMessageMessage(String value) {
        return new JAXBElement<String>(_InfologMessageMessage_QNAME, String.class, InfologMessage.class, value);
    }

}
