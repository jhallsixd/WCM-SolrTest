/**
 * CompanyTSDataNew.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.st.olm.cq.stcom.ws;

public class CompanyTSDataNew  implements java.io.Serializable {
    private java.lang.String[] authEmailList;

    private java.lang.String bpType;

    private java.lang.String classification;

    private java.lang.String customerFocusFlag;

    private com.st.olm.cq.stcom.ws.DepartmentTSData[] departments;

    private boolean enableForPersonalization;

    private java.lang.String groupName;

    private java.lang.String id;

    private com.st.olm.cq.stcom.ws.IndustryCompSegmentTSData[] industryCompSegmentTSData;

    private java.lang.String lastUpdDate;

    private java.lang.String name;

    private boolean ndaEnable;

    private java.lang.String portalAccess;

    private java.lang.String portalGroupName;

    private com.st.olm.cq.stcom.ws.CompanyRegionGroupTSData[] regiongroups;

    private java.lang.String[] salesCoverageList;

    public CompanyTSDataNew() {
    }

    public CompanyTSDataNew(
           java.lang.String[] authEmailList,
           java.lang.String bpType,
           java.lang.String classification,
           java.lang.String customerFocusFlag,
           com.st.olm.cq.stcom.ws.DepartmentTSData[] departments,
           boolean enableForPersonalization,
           java.lang.String groupName,
           java.lang.String id,
           com.st.olm.cq.stcom.ws.IndustryCompSegmentTSData[] industryCompSegmentTSData,
           java.lang.String lastUpdDate,
           java.lang.String name,
           boolean ndaEnable,
           java.lang.String portalAccess,
           java.lang.String portalGroupName,
           com.st.olm.cq.stcom.ws.CompanyRegionGroupTSData[] regiongroups,
           java.lang.String[] salesCoverageList) {
           this.authEmailList = authEmailList;
           this.bpType = bpType;
           this.classification = classification;
           this.customerFocusFlag = customerFocusFlag;
           this.departments = departments;
           this.enableForPersonalization = enableForPersonalization;
           this.groupName = groupName;
           this.id = id;
           this.industryCompSegmentTSData = industryCompSegmentTSData;
           this.lastUpdDate = lastUpdDate;
           this.name = name;
           this.ndaEnable = ndaEnable;
           this.portalAccess = portalAccess;
           this.portalGroupName = portalGroupName;
           this.regiongroups = regiongroups;
           this.salesCoverageList = salesCoverageList;
    }


    /**
     * Gets the authEmailList value for this CompanyTSDataNew.
     * 
     * @return authEmailList
     */
    public java.lang.String[] getAuthEmailList() {
        return authEmailList;
    }


    /**
     * Sets the authEmailList value for this CompanyTSDataNew.
     * 
     * @param authEmailList
     */
    public void setAuthEmailList(java.lang.String[] authEmailList) {
        this.authEmailList = authEmailList;
    }

    public java.lang.String getAuthEmailList(int i) {
        return this.authEmailList[i];
    }

    public void setAuthEmailList(int i, java.lang.String _value) {
        this.authEmailList[i] = _value;
    }


    /**
     * Gets the bpType value for this CompanyTSDataNew.
     * 
     * @return bpType
     */
    public java.lang.String getBpType() {
        return bpType;
    }


    /**
     * Sets the bpType value for this CompanyTSDataNew.
     * 
     * @param bpType
     */
    public void setBpType(java.lang.String bpType) {
        this.bpType = bpType;
    }


    /**
     * Gets the classification value for this CompanyTSDataNew.
     * 
     * @return classification
     */
    public java.lang.String getClassification() {
        return classification;
    }


    /**
     * Sets the classification value for this CompanyTSDataNew.
     * 
     * @param classification
     */
    public void setClassification(java.lang.String classification) {
        this.classification = classification;
    }


    /**
     * Gets the customerFocusFlag value for this CompanyTSDataNew.
     * 
     * @return customerFocusFlag
     */
    public java.lang.String getCustomerFocusFlag() {
        return customerFocusFlag;
    }


    /**
     * Sets the customerFocusFlag value for this CompanyTSDataNew.
     * 
     * @param customerFocusFlag
     */
    public void setCustomerFocusFlag(java.lang.String customerFocusFlag) {
        this.customerFocusFlag = customerFocusFlag;
    }


    /**
     * Gets the departments value for this CompanyTSDataNew.
     * 
     * @return departments
     */
    public com.st.olm.cq.stcom.ws.DepartmentTSData[] getDepartments() {
        return departments;
    }


    /**
     * Sets the departments value for this CompanyTSDataNew.
     * 
     * @param departments
     */
    public void setDepartments(com.st.olm.cq.stcom.ws.DepartmentTSData[] departments) {
        this.departments = departments;
    }

    public com.st.olm.cq.stcom.ws.DepartmentTSData getDepartments(int i) {
        return this.departments[i];
    }

    public void setDepartments(int i, com.st.olm.cq.stcom.ws.DepartmentTSData _value) {
        this.departments[i] = _value;
    }


    /**
     * Gets the enableForPersonalization value for this CompanyTSDataNew.
     * 
     * @return enableForPersonalization
     */
    public boolean isEnableForPersonalization() {
        return enableForPersonalization;
    }


    /**
     * Sets the enableForPersonalization value for this CompanyTSDataNew.
     * 
     * @param enableForPersonalization
     */
    public void setEnableForPersonalization(boolean enableForPersonalization) {
        this.enableForPersonalization = enableForPersonalization;
    }


    /**
     * Gets the groupName value for this CompanyTSDataNew.
     * 
     * @return groupName
     */
    public java.lang.String getGroupName() {
        return groupName;
    }


    /**
     * Sets the groupName value for this CompanyTSDataNew.
     * 
     * @param groupName
     */
    public void setGroupName(java.lang.String groupName) {
        this.groupName = groupName;
    }


    /**
     * Gets the id value for this CompanyTSDataNew.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this CompanyTSDataNew.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the industryCompSegmentTSData value for this CompanyTSDataNew.
     * 
     * @return industryCompSegmentTSData
     */
    public com.st.olm.cq.stcom.ws.IndustryCompSegmentTSData[] getIndustryCompSegmentTSData() {
        return industryCompSegmentTSData;
    }


    /**
     * Sets the industryCompSegmentTSData value for this CompanyTSDataNew.
     * 
     * @param industryCompSegmentTSData
     */
    public void setIndustryCompSegmentTSData(com.st.olm.cq.stcom.ws.IndustryCompSegmentTSData[] industryCompSegmentTSData) {
        this.industryCompSegmentTSData = industryCompSegmentTSData;
    }

    public com.st.olm.cq.stcom.ws.IndustryCompSegmentTSData getIndustryCompSegmentTSData(int i) {
        return this.industryCompSegmentTSData[i];
    }

    public void setIndustryCompSegmentTSData(int i, com.st.olm.cq.stcom.ws.IndustryCompSegmentTSData _value) {
        this.industryCompSegmentTSData[i] = _value;
    }


    /**
     * Gets the lastUpdDate value for this CompanyTSDataNew.
     * 
     * @return lastUpdDate
     */
    public java.lang.String getLastUpdDate() {
        return lastUpdDate;
    }


    /**
     * Sets the lastUpdDate value for this CompanyTSDataNew.
     * 
     * @param lastUpdDate
     */
    public void setLastUpdDate(java.lang.String lastUpdDate) {
        this.lastUpdDate = lastUpdDate;
    }


    /**
     * Gets the name value for this CompanyTSDataNew.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this CompanyTSDataNew.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the ndaEnable value for this CompanyTSDataNew.
     * 
     * @return ndaEnable
     */
    public boolean isNdaEnable() {
        return ndaEnable;
    }


    /**
     * Sets the ndaEnable value for this CompanyTSDataNew.
     * 
     * @param ndaEnable
     */
    public void setNdaEnable(boolean ndaEnable) {
        this.ndaEnable = ndaEnable;
    }


    /**
     * Gets the portalAccess value for this CompanyTSDataNew.
     * 
     * @return portalAccess
     */
    public java.lang.String getPortalAccess() {
        return portalAccess;
    }


    /**
     * Sets the portalAccess value for this CompanyTSDataNew.
     * 
     * @param portalAccess
     */
    public void setPortalAccess(java.lang.String portalAccess) {
        this.portalAccess = portalAccess;
    }


    /**
     * Gets the portalGroupName value for this CompanyTSDataNew.
     * 
     * @return portalGroupName
     */
    public java.lang.String getPortalGroupName() {
        return portalGroupName;
    }


    /**
     * Sets the portalGroupName value for this CompanyTSDataNew.
     * 
     * @param portalGroupName
     */
    public void setPortalGroupName(java.lang.String portalGroupName) {
        this.portalGroupName = portalGroupName;
    }


    /**
     * Gets the regiongroups value for this CompanyTSDataNew.
     * 
     * @return regiongroups
     */
    public com.st.olm.cq.stcom.ws.CompanyRegionGroupTSData[] getRegiongroups() {
        return regiongroups;
    }


    /**
     * Sets the regiongroups value for this CompanyTSDataNew.
     * 
     * @param regiongroups
     */
    public void setRegiongroups(com.st.olm.cq.stcom.ws.CompanyRegionGroupTSData[] regiongroups) {
        this.regiongroups = regiongroups;
    }

    public com.st.olm.cq.stcom.ws.CompanyRegionGroupTSData getRegiongroups(int i) {
        return this.regiongroups[i];
    }

    public void setRegiongroups(int i, com.st.olm.cq.stcom.ws.CompanyRegionGroupTSData _value) {
        this.regiongroups[i] = _value;
    }


    /**
     * Gets the salesCoverageList value for this CompanyTSDataNew.
     * 
     * @return salesCoverageList
     */
    public java.lang.String[] getSalesCoverageList() {
        return salesCoverageList;
    }


    /**
     * Sets the salesCoverageList value for this CompanyTSDataNew.
     * 
     * @param salesCoverageList
     */
    public void setSalesCoverageList(java.lang.String[] salesCoverageList) {
        this.salesCoverageList = salesCoverageList;
    }

    public java.lang.String getSalesCoverageList(int i) {
        return this.salesCoverageList[i];
    }

    public void setSalesCoverageList(int i, java.lang.String _value) {
        this.salesCoverageList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CompanyTSDataNew)) return false;
        CompanyTSDataNew other = (CompanyTSDataNew) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.authEmailList==null && other.getAuthEmailList()==null) || 
             (this.authEmailList!=null &&
              java.util.Arrays.equals(this.authEmailList, other.getAuthEmailList()))) &&
            ((this.bpType==null && other.getBpType()==null) || 
             (this.bpType!=null &&
              this.bpType.equals(other.getBpType()))) &&
            ((this.classification==null && other.getClassification()==null) || 
             (this.classification!=null &&
              this.classification.equals(other.getClassification()))) &&
            ((this.customerFocusFlag==null && other.getCustomerFocusFlag()==null) || 
             (this.customerFocusFlag!=null &&
              this.customerFocusFlag.equals(other.getCustomerFocusFlag()))) &&
            ((this.departments==null && other.getDepartments()==null) || 
             (this.departments!=null &&
              java.util.Arrays.equals(this.departments, other.getDepartments()))) &&
            this.enableForPersonalization == other.isEnableForPersonalization() &&
            ((this.groupName==null && other.getGroupName()==null) || 
             (this.groupName!=null &&
              this.groupName.equals(other.getGroupName()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.industryCompSegmentTSData==null && other.getIndustryCompSegmentTSData()==null) || 
             (this.industryCompSegmentTSData!=null &&
              java.util.Arrays.equals(this.industryCompSegmentTSData, other.getIndustryCompSegmentTSData()))) &&
            ((this.lastUpdDate==null && other.getLastUpdDate()==null) || 
             (this.lastUpdDate!=null &&
              this.lastUpdDate.equals(other.getLastUpdDate()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            this.ndaEnable == other.isNdaEnable() &&
            ((this.portalAccess==null && other.getPortalAccess()==null) || 
             (this.portalAccess!=null &&
              this.portalAccess.equals(other.getPortalAccess()))) &&
            ((this.portalGroupName==null && other.getPortalGroupName()==null) || 
             (this.portalGroupName!=null &&
              this.portalGroupName.equals(other.getPortalGroupName()))) &&
            ((this.regiongroups==null && other.getRegiongroups()==null) || 
             (this.regiongroups!=null &&
              java.util.Arrays.equals(this.regiongroups, other.getRegiongroups()))) &&
            ((this.salesCoverageList==null && other.getSalesCoverageList()==null) || 
             (this.salesCoverageList!=null &&
              java.util.Arrays.equals(this.salesCoverageList, other.getSalesCoverageList())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAuthEmailList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAuthEmailList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAuthEmailList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBpType() != null) {
            _hashCode += getBpType().hashCode();
        }
        if (getClassification() != null) {
            _hashCode += getClassification().hashCode();
        }
        if (getCustomerFocusFlag() != null) {
            _hashCode += getCustomerFocusFlag().hashCode();
        }
        if (getDepartments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDepartments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDepartments(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += (isEnableForPersonalization() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getGroupName() != null) {
            _hashCode += getGroupName().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIndustryCompSegmentTSData() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIndustryCompSegmentTSData());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIndustryCompSegmentTSData(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLastUpdDate() != null) {
            _hashCode += getLastUpdDate().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        _hashCode += (isNdaEnable() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getPortalAccess() != null) {
            _hashCode += getPortalAccess().hashCode();
        }
        if (getPortalGroupName() != null) {
            _hashCode += getPortalGroupName().hashCode();
        }
        if (getRegiongroups() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRegiongroups());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRegiongroups(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSalesCoverageList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSalesCoverageList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSalesCoverageList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CompanyTSDataNew.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.st.com/refData", "companyTSDataNew"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authEmailList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authEmailList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bpType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bpType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("classification");
        elemField.setXmlName(new javax.xml.namespace.QName("", "classification"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerFocusFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerFocusFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departments");
        elemField.setXmlName(new javax.xml.namespace.QName("", "departments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.st.com/refData", "departmentTSData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enableForPersonalization");
        elemField.setXmlName(new javax.xml.namespace.QName("", "enableForPersonalization"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("industryCompSegmentTSData");
        elemField.setXmlName(new javax.xml.namespace.QName("", "industryCompSegmentTSData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.st.com/refData", "industryCompSegmentTSData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastUpdDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastUpdDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ndaEnable");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ndaEnable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("portalAccess");
        elemField.setXmlName(new javax.xml.namespace.QName("", "portalAccess"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("portalGroupName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "portalGroupName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regiongroups");
        elemField.setXmlName(new javax.xml.namespace.QName("", "regiongroups"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.st.com/refData", "companyRegionGroupTSData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesCoverageList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "salesCoverageList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
