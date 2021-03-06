
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for AxdType_DateTime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdType_DateTime">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>dateTime">
 *       &lt;attribute name="localDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="timezone" type="{http://schemas.microsoft.com/dynamics/2008/01/sharedtypes}AxdEnum_Timezone" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdType_DateTime", propOrder = {
    "value"
})
@XmlSeeAlso({
    AxdExtTypeValidToDateTime.class,
    AxdExtTypeDateTimeExecuted.class,
    AxdExtTypeHcmEmploymentSeniorityDateTime.class,
    AxdExtTypeApprovedDateTime.class,
    AxdExtTypeEffectiveDateTime.class,
    AxdExtTypeBankStmtISODateTime.class,
    AxdExtTypeVersioningTimeStamp.class,
    AxdExtTypeClosedDateTime.class,
    AxdExtTypeFromDateTime.class,
    AxdExtTypeHcmEmploymentValidFrom.class,
    AxdExtTypeTrvDateTime.class,
    AxdExtTypeHcmEmploymentValidTo.class,
    AxdExtTypePostReleaseDate.class,
    AxdExtTypeInvoiceReleaseDate.class,
    AxdExtTypePurchReqSubmittedDateTime.class,
    AxdExtTypeEndDateTime.class,
    AxdExtTypeDateTimeSent.class,
    AxdExtTypeJournalPostedDateTime.class,
    AxdExtTypeAttributeValueDateTime.class,
    AxdExtTypeVendBankAccountActiveDate.class,
    AxdExtTypeHcmEmploymentStartDateTime.class,
    AxdExtTypeValidFromDateTime.class,
    AxdExtTypeJournalSessionLoginDateTime.class,
    AxdExtTypeActivationDateTime.class,
    AxdExtTypeStartDateTime.class,
    AxdExtTypeSmmDateTimeLastEdit.class,
    AxdExtTypeVendBankAccountExpiryDate.class,
    AxdExtTypeDOCommonLastSyncDateTime.class,
    AxdExtTypeExpirationDateTime.class,
    AxdExtTypeToDateTime.class,
    AxdExtTypeUTCTimestamp.class
})
public class AxdTypeDateTime {

    @XmlValue
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar value;
    @XmlAttribute(name = "localDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar localDateTime;
    @XmlAttribute(name = "timezone")
    protected AxdEnumTimezone timezone;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValue(XMLGregorianCalendar value) {
        this.value = value;
    }

    /**
     * Gets the value of the localDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLocalDateTime() {
        return localDateTime;
    }

    /**
     * Sets the value of the localDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLocalDateTime(XMLGregorianCalendar value) {
        this.localDateTime = value;
    }

    /**
     * Gets the value of the timezone property.
     * 
     * @return
     *     possible object is
     *     {@link AxdEnumTimezone }
     *     
     */
    public AxdEnumTimezone getTimezone() {
        return timezone;
    }

    /**
     * Sets the value of the timezone property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxdEnumTimezone }
     *     
     */
    public void setTimezone(AxdEnumTimezone value) {
        this.timezone = value;
    }

}
