
package org.datacontract.schemas._2004._07.microsoft_dynamics_ax;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.microsoft_dynamics_ax package. 
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

    private final static QName _XppObjectBase_QNAME = new QName("http://schemas.datacontract.org/2004/07/Microsoft.Dynamics.Ax.Xpp", "XppObjectBase");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.microsoft_dynamics_ax
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link XppObjectBase }
     * 
     */
    public XppObjectBase createXppObjectBase() {
        return new XppObjectBase();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XppObjectBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Microsoft.Dynamics.Ax.Xpp", name = "XppObjectBase")
    public JAXBElement<XppObjectBase> createXppObjectBase(XppObjectBase value) {
        return new JAXBElement<XppObjectBase>(_XppObjectBase_QNAME, XppObjectBase.class, null, value);
    }

}
