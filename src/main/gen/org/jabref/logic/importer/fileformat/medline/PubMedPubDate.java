//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.07 at 05:50:46 PM BRT 
//


package org.jabref.logic.importer.fileformat.medline;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{}normal.date">
 *       &lt;attGroup ref="{}attlist.PubMedPubDate"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "PubMedPubDate")
public class PubMedPubDate
    extends NormalDate
{

    @XmlAttribute(name = "PubStatus", required = true)
    protected String pubStatus;

    /**
     * Gets the value of the pubStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPubStatus() {
        return pubStatus;
    }

    /**
     * Sets the value of the pubStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPubStatus(String value) {
        this.pubStatus = value;
    }

}
