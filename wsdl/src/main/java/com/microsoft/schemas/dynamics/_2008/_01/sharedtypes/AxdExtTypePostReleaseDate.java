
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Release date:The date that the transaction can be posted. If the field is blank, the transaction can be posted immediately.
 * 
 * <p>Java class for AxdExtType_PostReleaseDate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AxdExtType_PostReleaseDate">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://schemas.microsoft.com/dynamics/2008/01/sharedtypes>AxdType_DateTime">
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AxdExtType_PostReleaseDate")
public class AxdExtTypePostReleaseDate
    extends AxdTypeDateTime
{


}
