
package com.microsoft.schemas.dynamics._2006._02.documents.querycriteria;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.microsoft.schemas.dynamics._2006._02.documents.querycriteria package. 
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

    private final static QName _QueryCriteria_QNAME = new QName("http://schemas.microsoft.com/dynamics/2006/02/documents/QueryCriteria", "QueryCriteria");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.microsoft.schemas.dynamics._2006._02.documents.querycriteria
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CriteriaElement }
     * 
     */
    public CriteriaElement createCriteriaElement() {
        return new CriteriaElement();
    }

    /**
     * Create an instance of {@link QueryCriteria }
     * 
     */
    public QueryCriteria createQueryCriteria() {
        return new QueryCriteria();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryCriteria }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/dynamics/2006/02/documents/QueryCriteria", name = "QueryCriteria")
    public JAXBElement<QueryCriteria> createQueryCriteria(QueryCriteria value) {
        return new JAXBElement<QueryCriteria>(_QueryCriteria_QNAME, QueryCriteria.class, null, value);
    }

}
