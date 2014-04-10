
package com.microsoft.schemas.dynamics._2008._01.documents.fault;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.datacontract.schemas._2004._07.microsoft_dynamics_ax_framework.ArrayOfInfologMessage;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.microsoft.schemas.dynamics._2008._01.documents.fault package. 
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

    private final static QName _FaultMessageList_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", "FaultMessageList");
    private final static QName _AifFault_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", "AifFault");
    private final static QName _FaultMessage_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", "FaultMessage");
    private final static QName _ArrayOfFaultMessage_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", "ArrayOfFaultMessage");
    private final static QName _ArrayOfFaultMessageList_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", "ArrayOfFaultMessageList");
    private final static QName _AifFaultCustomDetailXml_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", "CustomDetailXml");
    private final static QName _AifFaultStackTrace_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", "StackTrace");
    private final static QName _AifFaultFaultMessageListArray_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", "FaultMessageListArray");
    private final static QName _AifFaultInfologMessageList_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", "InfologMessageList");
    private final static QName _FaultMessageListServiceOperationParameter_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", "ServiceOperationParameter");
    private final static QName _FaultMessageListFaultMessageArray_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", "FaultMessageArray");
    private final static QName _FaultMessageListXPath_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", "XPath");
    private final static QName _FaultMessageListField_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", "Field");
    private final static QName _FaultMessageListService_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", "Service");
    private final static QName _FaultMessageListDocument_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", "Document");
    private final static QName _FaultMessageListXmlPosition_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", "XmlPosition");
    private final static QName _FaultMessageListXmlLine_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", "XmlLine");
    private final static QName _FaultMessageListServiceOperation_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", "ServiceOperation");
    private final static QName _FaultMessageListDocumentOperation_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", "DocumentOperation");
    private final static QName _FaultMessageCode_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", "Code");
    private final static QName _FaultMessageMessage_QNAME = new QName("http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", "Message");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.microsoft.schemas.dynamics._2008._01.documents.fault
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ArrayOfFaultMessageList }
     * 
     */
    public ArrayOfFaultMessageList createArrayOfFaultMessageList() {
        return new ArrayOfFaultMessageList();
    }

    /**
     * Create an instance of {@link AifFault }
     * 
     */
    public AifFault createAifFault() {
        return new AifFault();
    }

    /**
     * Create an instance of {@link FaultMessage }
     * 
     */
    public FaultMessage createFaultMessage() {
        return new FaultMessage();
    }

    /**
     * Create an instance of {@link FaultMessageList }
     * 
     */
    public FaultMessageList createFaultMessageList() {
        return new FaultMessageList();
    }

    /**
     * Create an instance of {@link ArrayOfFaultMessage }
     * 
     */
    public ArrayOfFaultMessage createArrayOfFaultMessage() {
        return new ArrayOfFaultMessage();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultMessageList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", name = "FaultMessageList")
    public JAXBElement<FaultMessageList> createFaultMessageList(FaultMessageList value) {
        return new JAXBElement<FaultMessageList>(_FaultMessageList_QNAME, FaultMessageList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AifFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", name = "AifFault")
    public JAXBElement<AifFault> createAifFault(AifFault value) {
        return new JAXBElement<AifFault>(_AifFault_QNAME, AifFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", name = "FaultMessage")
    public JAXBElement<FaultMessage> createFaultMessage(FaultMessage value) {
        return new JAXBElement<FaultMessage>(_FaultMessage_QNAME, FaultMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfFaultMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", name = "ArrayOfFaultMessage")
    public JAXBElement<ArrayOfFaultMessage> createArrayOfFaultMessage(ArrayOfFaultMessage value) {
        return new JAXBElement<ArrayOfFaultMessage>(_ArrayOfFaultMessage_QNAME, ArrayOfFaultMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfFaultMessageList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", name = "ArrayOfFaultMessageList")
    public JAXBElement<ArrayOfFaultMessageList> createArrayOfFaultMessageList(ArrayOfFaultMessageList value) {
        return new JAXBElement<ArrayOfFaultMessageList>(_ArrayOfFaultMessageList_QNAME, ArrayOfFaultMessageList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", name = "CustomDetailXml", scope = AifFault.class)
    public JAXBElement<String> createAifFaultCustomDetailXml(String value) {
        return new JAXBElement<String>(_AifFaultCustomDetailXml_QNAME, String.class, AifFault.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", name = "StackTrace", scope = AifFault.class)
    public JAXBElement<String> createAifFaultStackTrace(String value) {
        return new JAXBElement<String>(_AifFaultStackTrace_QNAME, String.class, AifFault.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfFaultMessageList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", name = "FaultMessageListArray", scope = AifFault.class)
    public JAXBElement<ArrayOfFaultMessageList> createAifFaultFaultMessageListArray(ArrayOfFaultMessageList value) {
        return new JAXBElement<ArrayOfFaultMessageList>(_AifFaultFaultMessageListArray_QNAME, ArrayOfFaultMessageList.class, AifFault.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfInfologMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", name = "InfologMessageList", scope = AifFault.class)
    public JAXBElement<ArrayOfInfologMessage> createAifFaultInfologMessageList(ArrayOfInfologMessage value) {
        return new JAXBElement<ArrayOfInfologMessage>(_AifFaultInfologMessageList_QNAME, ArrayOfInfologMessage.class, AifFault.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", name = "ServiceOperationParameter", scope = FaultMessageList.class)
    public JAXBElement<String> createFaultMessageListServiceOperationParameter(String value) {
        return new JAXBElement<String>(_FaultMessageListServiceOperationParameter_QNAME, String.class, FaultMessageList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfFaultMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", name = "FaultMessageArray", scope = FaultMessageList.class)
    public JAXBElement<ArrayOfFaultMessage> createFaultMessageListFaultMessageArray(ArrayOfFaultMessage value) {
        return new JAXBElement<ArrayOfFaultMessage>(_FaultMessageListFaultMessageArray_QNAME, ArrayOfFaultMessage.class, FaultMessageList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", name = "XPath", scope = FaultMessageList.class)
    public JAXBElement<String> createFaultMessageListXPath(String value) {
        return new JAXBElement<String>(_FaultMessageListXPath_QNAME, String.class, FaultMessageList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", name = "Field", scope = FaultMessageList.class)
    public JAXBElement<String> createFaultMessageListField(String value) {
        return new JAXBElement<String>(_FaultMessageListField_QNAME, String.class, FaultMessageList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", name = "Service", scope = FaultMessageList.class)
    public JAXBElement<String> createFaultMessageListService(String value) {
        return new JAXBElement<String>(_FaultMessageListService_QNAME, String.class, FaultMessageList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", name = "Document", scope = FaultMessageList.class)
    public JAXBElement<String> createFaultMessageListDocument(String value) {
        return new JAXBElement<String>(_FaultMessageListDocument_QNAME, String.class, FaultMessageList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", name = "XmlPosition", scope = FaultMessageList.class)
    public JAXBElement<String> createFaultMessageListXmlPosition(String value) {
        return new JAXBElement<String>(_FaultMessageListXmlPosition_QNAME, String.class, FaultMessageList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", name = "XmlLine", scope = FaultMessageList.class)
    public JAXBElement<String> createFaultMessageListXmlLine(String value) {
        return new JAXBElement<String>(_FaultMessageListXmlLine_QNAME, String.class, FaultMessageList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", name = "ServiceOperation", scope = FaultMessageList.class)
    public JAXBElement<String> createFaultMessageListServiceOperation(String value) {
        return new JAXBElement<String>(_FaultMessageListServiceOperation_QNAME, String.class, FaultMessageList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", name = "DocumentOperation", scope = FaultMessageList.class)
    public JAXBElement<String> createFaultMessageListDocumentOperation(String value) {
        return new JAXBElement<String>(_FaultMessageListDocumentOperation_QNAME, String.class, FaultMessageList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", name = "Code", scope = FaultMessage.class)
    public JAXBElement<String> createFaultMessageCode(String value) {
        return new JAXBElement<String>(_FaultMessageCode_QNAME, String.class, FaultMessage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault", name = "Message", scope = FaultMessage.class)
    public JAXBElement<String> createFaultMessageMessage(String value) {
        return new JAXBElement<String>(_FaultMessageMessage_QNAME, String.class, FaultMessage.class, value);
    }

}
