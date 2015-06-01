/**
 * RefDataWebServiceHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.st.olm.cq.stcom.ws;

public interface RefDataWebServiceHandler extends java.rmi.Remote {
    public com.st.olm.cq.stcom.ws.StringArray getExtranetClassifications() throws java.rmi.RemoteException, com.st.olm.cq.stcom.ws.IPWSException;
    public com.st.olm.cq.stcom.ws.CompanyTSDataArray getExtranetCompanies(java.lang.String parentCompOrgCode) throws java.rmi.RemoteException, com.st.olm.cq.stcom.ws.IPWSException;
    public com.st.olm.cq.stcom.ws.IndustrySegmentArray getIndustriesSegements() throws java.rmi.RemoteException, com.st.olm.cq.stcom.ws.IPWSException;
    public com.st.olm.cq.stcom.ws.CompanyTSDataNewArray getExtranetCompanies_WithBPType(java.lang.String parentCompOrgCode) throws java.rmi.RemoteException, com.st.olm.cq.stcom.ws.IPWSException;
    public com.st.olm.cq.stcom.ws.CompanyTSDataArray getExtranetCompanies_new(java.lang.String parentCompOrgCode) throws java.rmi.RemoteException, com.st.olm.cq.stcom.ws.IPWSException;
    public com.st.olm.cq.stcom.ws.PortalArray getExtranetPortals(java.lang.String parentCompOrgCode) throws java.rmi.RemoteException, com.st.olm.cq.stcom.ws.IPWSException;
    public com.st.olm.cq.stcom.ws.ApplicationImplArray getApplicationURLs(java.lang.String parentCompOrgCode) throws java.rmi.RemoteException, com.st.olm.cq.stcom.ws.IPWSException;
}
