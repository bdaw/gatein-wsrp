
package org.oasis.wsrp.v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FailedPortlets complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FailedPortlets">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oasis:names:tc:wsrp:v2:types}BaseFailed">
 *       &lt;sequence>
 *         &lt;element name="portletHandles" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FailedPortlets", propOrder = {
    "portletHandles"
})
public class FailedPortlets
    extends BaseFailed
{

    @XmlElement(required = true)
    protected List<String> portletHandles;

    /**
     * Gets the value of the portletHandles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the portletHandles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPortletHandles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPortletHandles() {
        if (portletHandles == null) {
            portletHandles = new ArrayList<String>();
        }
        return this.portletHandles;
    }

}
