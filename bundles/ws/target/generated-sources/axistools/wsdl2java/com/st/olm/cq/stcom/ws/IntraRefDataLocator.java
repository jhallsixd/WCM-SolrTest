/**
 * IntraRefDataLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.st.olm.cq.stcom.ws;

public class IntraRefDataLocator extends org.apache.axis.client.Service implements com.st.olm.cq.stcom.ws.IntraRefData {

    public IntraRefDataLocator() {
    }


    public IntraRefDataLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IntraRefDataLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RefDataWebServiceHandlerPort
    private java.lang.String RefDataWebServiceHandlerPort_address = "http://eul251.sgp.st.com:10080/ip/refdataws";

    public java.lang.String getRefDataWebServiceHandlerPortAddress() {
        return RefDataWebServiceHandlerPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RefDataWebServiceHandlerPortWSDDServiceName = "RefDataWebServiceHandlerPort";

    public java.lang.String getRefDataWebServiceHandlerPortWSDDServiceName() {
        return RefDataWebServiceHandlerPortWSDDServiceName;
    }

    public void setRefDataWebServiceHandlerPortWSDDServiceName(java.lang.String name) {
        RefDataWebServiceHandlerPortWSDDServiceName = name;
    }

    public com.st.olm.cq.stcom.ws.RefDataWebServiceHandler getRefDataWebServiceHandlerPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RefDataWebServiceHandlerPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRefDataWebServiceHandlerPort(endpoint);
    }

    public com.st.olm.cq.stcom.ws.RefDataWebServiceHandler getRefDataWebServiceHandlerPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.st.olm.cq.stcom.ws.IntraRefDataSoapBindingStub _stub = new com.st.olm.cq.stcom.ws.IntraRefDataSoapBindingStub(portAddress, this);
            _stub.setPortName(getRefDataWebServiceHandlerPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRefDataWebServiceHandlerPortEndpointAddress(java.lang.String address) {
        RefDataWebServiceHandlerPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.st.olm.cq.stcom.ws.RefDataWebServiceHandler.class.isAssignableFrom(serviceEndpointInterface)) {
                com.st.olm.cq.stcom.ws.IntraRefDataSoapBindingStub _stub = new com.st.olm.cq.stcom.ws.IntraRefDataSoapBindingStub(new java.net.URL(RefDataWebServiceHandlerPort_address), this);
                _stub.setPortName(getRefDataWebServiceHandlerPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("RefDataWebServiceHandlerPort".equals(inputPortName)) {
            return getRefDataWebServiceHandlerPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.st.com/refData", "IntraRefData");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.st.com/refData", "RefDataWebServiceHandlerPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RefDataWebServiceHandlerPort".equals(portName)) {
            setRefDataWebServiceHandlerPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
