/**
 * IntraRefDataSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.st.olm.cq.stcom.ws;

public class IntraRefDataSoapBindingStub extends org.apache.axis.client.Stub implements com.st.olm.cq.stcom.ws.RefDataWebServiceHandler {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[7];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getExtranetClassifications");
        oper.setReturnType(new javax.xml.namespace.QName("http://jaxb.dev.java.net/array", "stringArray"));
        oper.setReturnClass(com.st.olm.cq.stcom.ws.StringArray.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.st.com/refData", "IPWSException"),
                      "com.st.olm.cq.stcom.ws.IPWSException",
                      new javax.xml.namespace.QName("http://www.st.com/refData", "IPWSException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getExtranetCompanies");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parentCompOrgCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.st.com/refData", "companyTSDataArray"));
        oper.setReturnClass(com.st.olm.cq.stcom.ws.CompanyTSDataArray.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.st.com/refData", "IPWSException"),
                      "com.st.olm.cq.stcom.ws.IPWSException",
                      new javax.xml.namespace.QName("http://www.st.com/refData", "IPWSException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getIndustriesSegements");
        oper.setReturnType(new javax.xml.namespace.QName("http://www.st.com/refData", "industrySegmentArray"));
        oper.setReturnClass(com.st.olm.cq.stcom.ws.IndustrySegmentArray.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.st.com/refData", "IPWSException"),
                      "com.st.olm.cq.stcom.ws.IPWSException",
                      new javax.xml.namespace.QName("http://www.st.com/refData", "IPWSException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getExtranetCompanies_WithBPType");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parentCompOrgCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.st.com/refData", "companyTSDataNewArray"));
        oper.setReturnClass(com.st.olm.cq.stcom.ws.CompanyTSDataNewArray.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.st.com/refData", "IPWSException"),
                      "com.st.olm.cq.stcom.ws.IPWSException",
                      new javax.xml.namespace.QName("http://www.st.com/refData", "IPWSException"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getExtranetCompanies_new");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parentCompOrgCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.st.com/refData", "companyTSDataArray"));
        oper.setReturnClass(com.st.olm.cq.stcom.ws.CompanyTSDataArray.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.st.com/refData", "IPWSException"),
                      "com.st.olm.cq.stcom.ws.IPWSException",
                      new javax.xml.namespace.QName("http://www.st.com/refData", "IPWSException"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getExtranetPortals");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parentCompOrgCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.st.com/refData", "portalArray"));
        oper.setReturnClass(com.st.olm.cq.stcom.ws.PortalArray.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.st.com/refData", "IPWSException"),
                      "com.st.olm.cq.stcom.ws.IPWSException",
                      new javax.xml.namespace.QName("http://www.st.com/refData", "IPWSException"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getApplicationURLs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parentCompOrgCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.st.com/refData", "applicationImplArray"));
        oper.setReturnClass(com.st.olm.cq.stcom.ws.ApplicationImplArray.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.st.com/refData", "IPWSException"),
                      "com.st.olm.cq.stcom.ws.IPWSException",
                      new javax.xml.namespace.QName("http://www.st.com/refData", "IPWSException"), 
                      true
                     ));
        _operations[6] = oper;

    }

    public IntraRefDataSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public IntraRefDataSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public IntraRefDataSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://jaxb.dev.java.net/array", "stringArray");
            cachedSerQNames.add(qName);
            cls = com.st.olm.cq.stcom.ws.StringArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.st.com/refData", "applicationImpl");
            cachedSerQNames.add(qName);
            cls = com.st.olm.cq.stcom.ws.ApplicationImpl.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.st.com/refData", "applicationImplArray");
            cachedSerQNames.add(qName);
            cls = com.st.olm.cq.stcom.ws.ApplicationImplArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.st.com/refData", "companyDeptRegionGroupTSData");
            cachedSerQNames.add(qName);
            cls = com.st.olm.cq.stcom.ws.CompanyDeptRegionGroupTSData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.st.com/refData", "companyRegionGroupTSData");
            cachedSerQNames.add(qName);
            cls = com.st.olm.cq.stcom.ws.CompanyRegionGroupTSData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.st.com/refData", "companyTSData");
            cachedSerQNames.add(qName);
            cls = com.st.olm.cq.stcom.ws.CompanyTSData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.st.com/refData", "companyTSDataArray");
            cachedSerQNames.add(qName);
            cls = com.st.olm.cq.stcom.ws.CompanyTSDataArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.st.com/refData", "companyTSDataNew");
            cachedSerQNames.add(qName);
            cls = com.st.olm.cq.stcom.ws.CompanyTSDataNew.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.st.com/refData", "companyTSDataNewArray");
            cachedSerQNames.add(qName);
            cls = com.st.olm.cq.stcom.ws.CompanyTSDataNewArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.st.com/refData", "cti");
            cachedSerQNames.add(qName);
            cls = com.st.olm.cq.stcom.ws.Cti.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.st.com/refData", "departmentTSData");
            cachedSerQNames.add(qName);
            cls = com.st.olm.cq.stcom.ws.DepartmentTSData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.st.com/refData", "industryCompSegmentTSData");
            cachedSerQNames.add(qName);
            cls = com.st.olm.cq.stcom.ws.IndustryCompSegmentTSData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.st.com/refData", "industrySegment");
            cachedSerQNames.add(qName);
            cls = com.st.olm.cq.stcom.ws.IndustrySegment.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.st.com/refData", "industrySegmentArray");
            cachedSerQNames.add(qName);
            cls = com.st.olm.cq.stcom.ws.IndustrySegmentArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.st.com/refData", "IPWSException");
            cachedSerQNames.add(qName);
            cls = com.st.olm.cq.stcom.ws.IPWSException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.st.com/refData", "portal");
            cachedSerQNames.add(qName);
            cls = com.st.olm.cq.stcom.ws.Portal.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.st.com/refData", "portalArray");
            cachedSerQNames.add(qName);
            cls = com.st.olm.cq.stcom.ws.PortalArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.st.com/refData", "role");
            cachedSerQNames.add(qName);
            cls = com.st.olm.cq.stcom.ws.Role.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.st.olm.cq.stcom.ws.StringArray getExtranetClassifications() throws java.rmi.RemoteException, com.st.olm.cq.stcom.ws.IPWSException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.st.com/refData", "getExtranetClassifications"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.st.olm.cq.stcom.ws.StringArray) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.st.olm.cq.stcom.ws.StringArray) org.apache.axis.utils.JavaUtils.convert(_resp, com.st.olm.cq.stcom.ws.StringArray.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.st.olm.cq.stcom.ws.IPWSException) {
              throw (com.st.olm.cq.stcom.ws.IPWSException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.st.olm.cq.stcom.ws.CompanyTSDataArray getExtranetCompanies(java.lang.String parentCompOrgCode) throws java.rmi.RemoteException, com.st.olm.cq.stcom.ws.IPWSException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.st.com/refData", "getExtranetCompanies"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parentCompOrgCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.st.olm.cq.stcom.ws.CompanyTSDataArray) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.st.olm.cq.stcom.ws.CompanyTSDataArray) org.apache.axis.utils.JavaUtils.convert(_resp, com.st.olm.cq.stcom.ws.CompanyTSDataArray.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.st.olm.cq.stcom.ws.IPWSException) {
              throw (com.st.olm.cq.stcom.ws.IPWSException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.st.olm.cq.stcom.ws.IndustrySegmentArray getIndustriesSegements() throws java.rmi.RemoteException, com.st.olm.cq.stcom.ws.IPWSException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.st.com/refData", "getIndustriesSegements"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.st.olm.cq.stcom.ws.IndustrySegmentArray) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.st.olm.cq.stcom.ws.IndustrySegmentArray) org.apache.axis.utils.JavaUtils.convert(_resp, com.st.olm.cq.stcom.ws.IndustrySegmentArray.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.st.olm.cq.stcom.ws.IPWSException) {
              throw (com.st.olm.cq.stcom.ws.IPWSException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.st.olm.cq.stcom.ws.CompanyTSDataNewArray getExtranetCompanies_WithBPType(java.lang.String parentCompOrgCode) throws java.rmi.RemoteException, com.st.olm.cq.stcom.ws.IPWSException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.st.com/refData", "getExtranetCompanies_WithBPType"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parentCompOrgCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.st.olm.cq.stcom.ws.CompanyTSDataNewArray) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.st.olm.cq.stcom.ws.CompanyTSDataNewArray) org.apache.axis.utils.JavaUtils.convert(_resp, com.st.olm.cq.stcom.ws.CompanyTSDataNewArray.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.st.olm.cq.stcom.ws.IPWSException) {
              throw (com.st.olm.cq.stcom.ws.IPWSException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.st.olm.cq.stcom.ws.CompanyTSDataArray getExtranetCompanies_new(java.lang.String parentCompOrgCode) throws java.rmi.RemoteException, com.st.olm.cq.stcom.ws.IPWSException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.st.com/refData", "getExtranetCompanies_new"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parentCompOrgCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.st.olm.cq.stcom.ws.CompanyTSDataArray) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.st.olm.cq.stcom.ws.CompanyTSDataArray) org.apache.axis.utils.JavaUtils.convert(_resp, com.st.olm.cq.stcom.ws.CompanyTSDataArray.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.st.olm.cq.stcom.ws.IPWSException) {
              throw (com.st.olm.cq.stcom.ws.IPWSException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.st.olm.cq.stcom.ws.PortalArray getExtranetPortals(java.lang.String parentCompOrgCode) throws java.rmi.RemoteException, com.st.olm.cq.stcom.ws.IPWSException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.st.com/refData", "getExtranetPortals"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parentCompOrgCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.st.olm.cq.stcom.ws.PortalArray) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.st.olm.cq.stcom.ws.PortalArray) org.apache.axis.utils.JavaUtils.convert(_resp, com.st.olm.cq.stcom.ws.PortalArray.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.st.olm.cq.stcom.ws.IPWSException) {
              throw (com.st.olm.cq.stcom.ws.IPWSException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.st.olm.cq.stcom.ws.ApplicationImplArray getApplicationURLs(java.lang.String parentCompOrgCode) throws java.rmi.RemoteException, com.st.olm.cq.stcom.ws.IPWSException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.st.com/refData", "getApplicationURLs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parentCompOrgCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.st.olm.cq.stcom.ws.ApplicationImplArray) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.st.olm.cq.stcom.ws.ApplicationImplArray) org.apache.axis.utils.JavaUtils.convert(_resp, com.st.olm.cq.stcom.ws.ApplicationImplArray.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.st.olm.cq.stcom.ws.IPWSException) {
              throw (com.st.olm.cq.stcom.ws.IPWSException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
