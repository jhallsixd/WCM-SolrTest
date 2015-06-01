/**
 * DepartmentTSData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.st.olm.cq.stcom.ws;

public class DepartmentTSData  implements java.io.Serializable {
    private java.lang.String adGroupName;

    private java.lang.String classification;

    private com.st.olm.cq.stcom.ws.CompanyDeptRegionGroupTSData[] deptRegionGroups;

    private java.lang.String displayName;

    private java.lang.String name;

    private java.lang.String portalAccess;

    public DepartmentTSData() {
    }

    public DepartmentTSData(
           java.lang.String adGroupName,
           java.lang.String classification,
           com.st.olm.cq.stcom.ws.CompanyDeptRegionGroupTSData[] deptRegionGroups,
           java.lang.String displayName,
           java.lang.String name,
           java.lang.String portalAccess) {
           this.adGroupName = adGroupName;
           this.classification = classification;
           this.deptRegionGroups = deptRegionGroups;
           this.displayName = displayName;
           this.name = name;
           this.portalAccess = portalAccess;
    }


    /**
     * Gets the adGroupName value for this DepartmentTSData.
     * 
     * @return adGroupName
     */
    public java.lang.String getAdGroupName() {
        return adGroupName;
    }


    /**
     * Sets the adGroupName value for this DepartmentTSData.
     * 
     * @param adGroupName
     */
    public void setAdGroupName(java.lang.String adGroupName) {
        this.adGroupName = adGroupName;
    }


    /**
     * Gets the classification value for this DepartmentTSData.
     * 
     * @return classification
     */
    public java.lang.String getClassification() {
        return classification;
    }


    /**
     * Sets the classification value for this DepartmentTSData.
     * 
     * @param classification
     */
    public void setClassification(java.lang.String classification) {
        this.classification = classification;
    }


    /**
     * Gets the deptRegionGroups value for this DepartmentTSData.
     * 
     * @return deptRegionGroups
     */
    public com.st.olm.cq.stcom.ws.CompanyDeptRegionGroupTSData[] getDeptRegionGroups() {
        return deptRegionGroups;
    }


    /**
     * Sets the deptRegionGroups value for this DepartmentTSData.
     * 
     * @param deptRegionGroups
     */
    public void setDeptRegionGroups(com.st.olm.cq.stcom.ws.CompanyDeptRegionGroupTSData[] deptRegionGroups) {
        this.deptRegionGroups = deptRegionGroups;
    }

    public com.st.olm.cq.stcom.ws.CompanyDeptRegionGroupTSData getDeptRegionGroups(int i) {
        return this.deptRegionGroups[i];
    }

    public void setDeptRegionGroups(int i, com.st.olm.cq.stcom.ws.CompanyDeptRegionGroupTSData _value) {
        this.deptRegionGroups[i] = _value;
    }


    /**
     * Gets the displayName value for this DepartmentTSData.
     * 
     * @return displayName
     */
    public java.lang.String getDisplayName() {
        return displayName;
    }


    /**
     * Sets the displayName value for this DepartmentTSData.
     * 
     * @param displayName
     */
    public void setDisplayName(java.lang.String displayName) {
        this.displayName = displayName;
    }


    /**
     * Gets the name value for this DepartmentTSData.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this DepartmentTSData.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the portalAccess value for this DepartmentTSData.
     * 
     * @return portalAccess
     */
    public java.lang.String getPortalAccess() {
        return portalAccess;
    }


    /**
     * Sets the portalAccess value for this DepartmentTSData.
     * 
     * @param portalAccess
     */
    public void setPortalAccess(java.lang.String portalAccess) {
        this.portalAccess = portalAccess;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DepartmentTSData)) return false;
        DepartmentTSData other = (DepartmentTSData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.adGroupName==null && other.getAdGroupName()==null) || 
             (this.adGroupName!=null &&
              this.adGroupName.equals(other.getAdGroupName()))) &&
            ((this.classification==null && other.getClassification()==null) || 
             (this.classification!=null &&
              this.classification.equals(other.getClassification()))) &&
            ((this.deptRegionGroups==null && other.getDeptRegionGroups()==null) || 
             (this.deptRegionGroups!=null &&
              java.util.Arrays.equals(this.deptRegionGroups, other.getDeptRegionGroups()))) &&
            ((this.displayName==null && other.getDisplayName()==null) || 
             (this.displayName!=null &&
              this.displayName.equals(other.getDisplayName()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.portalAccess==null && other.getPortalAccess()==null) || 
             (this.portalAccess!=null &&
              this.portalAccess.equals(other.getPortalAccess())));
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
        if (getAdGroupName() != null) {
            _hashCode += getAdGroupName().hashCode();
        }
        if (getClassification() != null) {
            _hashCode += getClassification().hashCode();
        }
        if (getDeptRegionGroups() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDeptRegionGroups());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDeptRegionGroups(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDisplayName() != null) {
            _hashCode += getDisplayName().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPortalAccess() != null) {
            _hashCode += getPortalAccess().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DepartmentTSData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.st.com/refData", "departmentTSData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adGroupName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "adGroupName"));
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
        elemField.setFieldName("deptRegionGroups");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deptRegionGroups"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.st.com/refData", "companyDeptRegionGroupTSData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("displayName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "displayName"));
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
        elemField.setFieldName("portalAccess");
        elemField.setXmlName(new javax.xml.namespace.QName("", "portalAccess"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
