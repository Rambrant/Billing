
package com.microsoft.schemas.dynamics._2010._01.datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfstringstring;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.microsoft.schemas.dynamics._2010._01.datacontracts package. 
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

    private final static QName _CallContext_QNAME = new QName("http://schemas.microsoft.com/dynamics/2010/01/datacontracts", "CallContext");
    private final static QName _CallContextLanguage_QNAME = new QName("http://schemas.microsoft.com/dynamics/2010/01/datacontracts", "Language");
    private final static QName _CallContextPropertyBag_QNAME = new QName("http://schemas.microsoft.com/dynamics/2010/01/datacontracts", "PropertyBag");
    private final static QName _CallContextCompany_QNAME = new QName("http://schemas.microsoft.com/dynamics/2010/01/datacontracts", "Company");
    private final static QName _CallContextLogonAsUser_QNAME = new QName("http://schemas.microsoft.com/dynamics/2010/01/datacontracts", "LogonAsUser");
    private final static QName _CallContextMessageId_QNAME = new QName("http://schemas.microsoft.com/dynamics/2010/01/datacontracts", "MessageId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.microsoft.schemas.dynamics._2010._01.datacontracts
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CallContext }
     * 
     */
    public CallContext createCallContext() {
        return new CallContext();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CallContext }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2010/01/datacontracts", name = "CallContext")
    public JAXBElement<CallContext> createCallContext(CallContext value) {
        return new JAXBElement<CallContext>(_CallContext_QNAME, CallContext.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2010/01/datacontracts", name = "Language", scope = CallContext.class)
    public JAXBElement<String> createCallContextLanguage(String value) {
        return new JAXBElement<String>(_CallContextLanguage_QNAME, String.class, CallContext.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfstringstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2010/01/datacontracts", name = "PropertyBag", scope = CallContext.class)
    public JAXBElement<ArrayOfKeyValueOfstringstring> createCallContextPropertyBag(ArrayOfKeyValueOfstringstring value) {
        return new JAXBElement<ArrayOfKeyValueOfstringstring>(_CallContextPropertyBag_QNAME, ArrayOfKeyValueOfstringstring.class, CallContext.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2010/01/datacontracts", name = "Company", scope = CallContext.class)
    public JAXBElement<String> createCallContextCompany(String value) {
        return new JAXBElement<String>(_CallContextCompany_QNAME, String.class, CallContext.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2010/01/datacontracts", name = "LogonAsUser", scope = CallContext.class)
    public JAXBElement<String> createCallContextLogonAsUser(String value) {
        return new JAXBElement<String>(_CallContextLogonAsUser_QNAME, String.class, CallContext.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2010/01/datacontracts", name = "MessageId", scope = CallContext.class)
    public JAXBElement<String> createCallContextMessageId(String value) {
        return new JAXBElement<String>(_CallContextMessageId_QNAME, String.class, CallContext.class, value);
    }

}
