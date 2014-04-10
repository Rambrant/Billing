
package com.microsoft.schemas.dynamics._2008._01.services;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.1
 * 2013-03-20T13:23:21.163+01:00
 * Generated source version: 2.6.1
 */

@WebFault(name = "AifFault", targetNamespace = "http://schemas.microsoft.com/dynamics/2008/01/documents/Fault")
public class CustomerServiceReadAifFaultFaultFaultMessage extends Exception {
    
    private com.microsoft.schemas.dynamics._2008._01.documents.fault.AifFault aifFault;

    public CustomerServiceReadAifFaultFaultFaultMessage() {
        super();
    }
    
    public CustomerServiceReadAifFaultFaultFaultMessage(String message) {
        super(message);
    }
    
    public CustomerServiceReadAifFaultFaultFaultMessage(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerServiceReadAifFaultFaultFaultMessage(String message, com.microsoft.schemas.dynamics._2008._01.documents.fault.AifFault aifFault) {
        super(message);
        this.aifFault = aifFault;
    }

    public CustomerServiceReadAifFaultFaultFaultMessage(String message, com.microsoft.schemas.dynamics._2008._01.documents.fault.AifFault aifFault, Throwable cause) {
        super(message, cause);
        this.aifFault = aifFault;
    }

    public com.microsoft.schemas.dynamics._2008._01.documents.fault.AifFault getFaultInfo() {
        return this.aifFault;
    }
}
