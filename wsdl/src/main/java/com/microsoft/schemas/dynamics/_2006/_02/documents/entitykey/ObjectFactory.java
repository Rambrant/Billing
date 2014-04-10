
package com.microsoft.schemas.dynamics._2006._02.documents.entitykey;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.microsoft.schemas.dynamics._2006._02.documents.entitykey package. 
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

    private final static QName _EntityKey_QNAME = new QName("http://schemas.microsoft.com/dynamics/2006/02/documents/EntityKey", "EntityKey");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.microsoft.schemas.dynamics._2006._02.documents.entitykey
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link KeyData }
     * 
     */
    public KeyData createKeyData() {
        return new KeyData();
    }

    /**
     * Create an instance of {@link EntityKey }
     * 
     */
    public EntityKey createEntityKey() {
        return new EntityKey();
    }

    /**
     * Create an instance of {@link KeyField }
     * 
     */
    public KeyField createKeyField() {
        return new KeyField();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityKey }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2006/02/documents/EntityKey", name = "EntityKey")
    public JAXBElement<EntityKey> createEntityKey(EntityKey value) {
        return new JAXBElement<EntityKey>(_EntityKey_QNAME, EntityKey.class, null, value);
    }

}
