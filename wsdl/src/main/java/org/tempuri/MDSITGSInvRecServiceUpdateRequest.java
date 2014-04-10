
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas.dynamics._2006._02.documents.entitykeylist.EntityKeyList;
import com.microsoft.schemas.dynamics._2008._01.documents.mds_itgsinvrec.AxdMDSITGSInvRec;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://schemas.microsoft.com/dynamics/2006/02/documents/EntityKeyList}EntityKeyList" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec}MDS_ITGSInvRec" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "entityKeyList",
    "mdsitgsInvRec"
})
@XmlRootElement(name = "MDS_ITGSInvRecServiceUpdateRequest")
public class MDSITGSInvRecServiceUpdateRequest {

    @XmlElement(name = "EntityKeyList", namespace = "http://schemas.microsoft.com/dynamics/2006/02/documents/EntityKeyList")
    protected EntityKeyList entityKeyList;
    @XmlElement(name = "MDS_ITGSInvRec", namespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/MDS_ITGSInvRec")
    protected AxdMDSITGSInvRec mdsitgsInvRec;

    /**
     * Gets the value of the entityKeyList property.
     * 
     * @return
     *     possible object is
     *     {@link EntityKeyList }
     *     
     */
    public EntityKeyList getEntityKeyList() {
        return entityKeyList;
    }

    /**
     * Sets the value of the entityKeyList property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityKeyList }
     *     
     */
    public void setEntityKeyList(EntityKeyList value) {
        this.entityKeyList = value;
    }

    /**
     * Gets the value of the mdsitgsInvRec property.
     * 
     * @return
     *     possible object is
     *     {@link AxdMDSITGSInvRec }
     *     
     */
    public AxdMDSITGSInvRec getMDSITGSInvRec() {
        return mdsitgsInvRec;
    }

    /**
     * Sets the value of the mdsitgsInvRec property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxdMDSITGSInvRec }
     *     
     */
    public void setMDSITGSInvRec(AxdMDSITGSInvRec value) {
        this.mdsitgsInvRec = value;
    }

}