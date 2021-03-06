
package org.tempuri;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.1
 * 2013-03-20T13:23:28.750+01:00
 * Generated source version: 2.6.1
 */

@WebFault(name = "AifFault", targetNamespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault")
public class MDSSalesOrderBasisLineServiceOrderBasisLineInboundAifFaultFaultFaultMessage extends Exception {
    
    private com.microsoft.schemas.dynamics._2008._01.documents.fault.AifFault aifFault;

    public MDSSalesOrderBasisLineServiceOrderBasisLineInboundAifFaultFaultFaultMessage() {
        super();
    }
    
    public MDSSalesOrderBasisLineServiceOrderBasisLineInboundAifFaultFaultFaultMessage(String message) {
        super(message);
    }
    
    public MDSSalesOrderBasisLineServiceOrderBasisLineInboundAifFaultFaultFaultMessage(String message, Throwable cause) {
        super(message, cause);
    }

    public MDSSalesOrderBasisLineServiceOrderBasisLineInboundAifFaultFaultFaultMessage(String message, com.microsoft.schemas.dynamics._2008._01.documents.fault.AifFault aifFault) {
        super(message);
        this.aifFault = aifFault;
    }

    public MDSSalesOrderBasisLineServiceOrderBasisLineInboundAifFaultFaultFaultMessage(String message, com.microsoft.schemas.dynamics._2008._01.documents.fault.AifFault aifFault, Throwable cause) {
        super(message, cause);
        this.aifFault = aifFault;
    }

    public com.microsoft.schemas.dynamics._2008._01.documents.fault.AifFault getFaultInfo() {
        return this.aifFault;
    }
}
