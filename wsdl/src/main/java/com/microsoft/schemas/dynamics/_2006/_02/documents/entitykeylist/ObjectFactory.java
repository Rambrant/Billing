
package com.microsoft.schemas.dynamics._2006._02.documents.entitykeylist;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.microsoft.schemas.dynamics._2006._02.documents.entitykeylist package. 
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

    private final static QName _EntityKeyList_QNAME = new QName("http://schemas.microsoft.com/dynamics/2006/02/documents/EntityKeyList", "EntityKeyList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.microsoft.schemas.dynamics._2006._02.documents.entitykeylist
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EntityKeyList }
     * 
     */
    public EntityKeyList createEntityKeyList() {
        return new EntityKeyList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityKeyList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2006/02/documents/EntityKeyList", name = "EntityKeyList")
    public JAXBElement<EntityKeyList> createEntityKeyList(EntityKeyList value) {
        return new JAXBElement<EntityKeyList>(_EntityKeyList_QNAME, EntityKeyList.class, null, value);
    }

}
