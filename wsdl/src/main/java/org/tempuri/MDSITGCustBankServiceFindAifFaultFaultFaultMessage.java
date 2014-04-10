
package org.tempuri;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.1
 * 2013-03-20T13:23:23.530+01:00
 * Generated source version: 2.6.1
 */

@WebFault(name = "AifFault", targetNamespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault")
public class MDSITGCustBankServiceFindAifFaultFaultFaultMessage extends Exception {
    
    private com.microsoft.schemas.dynamics._2008._01.documents.fault.AifFault aifFault;

    public MDSITGCustBankServiceFindAifFaultFaultFaultMessage() {
        super();
    }
    
    public MDSITGCustBankServiceFindAifFaultFaultFaultMessage(String message) {
        super(message);
    }
    
    public MDSITGCustBankServiceFindAifFaultFaultFaultMessage(String message, Throwable cause) {
        super(message, cause);
    }

    public MDSITGCustBankServiceFindAifFaultFaultFaultMessage(String message, com.microsoft.schemas.dynamics._2008._01.documents.fault.AifFault aifFault) {
        super(message);
        this.aifFault = aifFault;
    }

    public MDSITGCustBankServiceFindAifFaultFaultFaultMessage(String message, com.microsoft.schemas.dynamics._2008._01.documents.fault.AifFault aifFault, Throwable cause) {
        super(message, cause);
        this.aifFault = aifFault;
    }

    public com.microsoft.schemas.dynamics._2008._01.documents.fault.AifFault getFaultInfo() {
        return this.aifFault;
    }
}