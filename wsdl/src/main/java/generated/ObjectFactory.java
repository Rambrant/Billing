
package generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.microsoft.schemas.dynamics._2006._02.documents.entitykeylist.EntityKeyList;
import com.microsoft.schemas.dynamics._2006._02.documents.querycriteria.QueryCriteria;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvmes.AxdMDSITGSInvMes;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
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

    private final static QName _QueryCriteria_QNAME = new QName("", "QueryCriteria");
    private final static QName _EntityKeyList_QNAME = new QName("", "EntityKeyList");
    private final static QName _AxdMDSITGSInvMes_QNAME = new QName("", "AxdMDS_ITGSInvMes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryCriteria }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "QueryCriteria")
    public JAXBElement<QueryCriteria> createQueryCriteria(QueryCriteria value) {
        return new JAXBElement<QueryCriteria>(_QueryCriteria_QNAME, QueryCriteria.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityKeyList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "EntityKeyList")
    public JAXBElement<EntityKeyList> createEntityKeyList(EntityKeyList value) {
        return new JAXBElement<EntityKeyList>(_EntityKeyList_QNAME, EntityKeyList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AxdMDSITGSInvMes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AxdMDS_ITGSInvMes")
    public JAXBElement<AxdMDSITGSInvMes> createAxdMDSITGSInvMes(AxdMDSITGSInvMes value) {
        return new JAXBElement<AxdMDSITGSInvMes>(_AxdMDSITGSInvMes_QNAME, AxdMDSITGSInvMes.class, null, value);
    }

}
