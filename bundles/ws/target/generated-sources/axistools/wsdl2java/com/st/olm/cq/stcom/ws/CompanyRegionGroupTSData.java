/**
 * CompanyRegionGroupTSData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.st.olm.cq.stcom.ws;

public class CompanyRegionGroupTSData  implements java.io.Serializable {
    private java.lang.String displayName;

    private java.lang.String regionAdGroupName;

    private java.lang.String regionCode;

    private java.lang.String regionDescription;

    public CompanyRegionGroupTSData() {
    }

    public CompanyRegionGroupTSData(
           java.lang.String displayName,
           java.lang.String regionAdGroupName,
           java.lang.String regionCode,
           java.lang.String regionDescription) {
           this.displayName = displayName;
           this.regionAdGroupName = regionAdGroupName;
           this.regionCode = regionCode;
           this.regionDescription = regionDescription;
    }


    /**
     * Gets the displayName value for this CompanyRegionGroupTSData.
     * 
     * @return displayName
     */
    public java.lang.String getDisplayName() {
        return displayName;
    }


    /**
     * Sets the displayName value for this CompanyRegionGroupTSData.
     * 
     * @param displayName
     */
    public void setDisplayName(java.lang.String displayName) {
        this.displayName = displayName;
    }


    /**
     * Gets the regionAdGroupName value for this CompanyRegionGroupTSData.
     * 
     * @return regionAdGroupName
     */
    public java.lang.String getRegionAdGroupName() {
        return regionAdGroupName;
    }


    /**
     * Sets the regionAdGroupName value for this CompanyRegionGroupTSData.
     * 
     * @param regionAdGroupName
     */
    public void setRegionAdGroupName(java.lang.String regionAdGroupName) {
        this.regionAdGroupName = regionAdGroupName;
    }


    /**
     * Gets the regionCode value for this CompanyRegionGroupTSData.
     * 
     * @return regionCode
     */
    public java.lang.String getRegionCode() {
        return regionCode;
    }


    /**
     * Sets the regionCode value for this CompanyRegionGroupTSData.
     * 
     * @param regionCode
     */
    public void setRegionCode(java.lang.String regionCode) {
        this.regionCode = regionCode;
    }


    /**
     * Gets the regionDescription value for this CompanyRegionGroupTSData.
     * 
     * @return regionDescription
     */
    public java.lang.String getRegionDescription() {
        return regionDescription;
    }


    /**
     * Sets the regionDescription value for this CompanyRegionGroupTSData.
     * 
     * @param regionDescription
     */
    public void setRegionDescription(java.lang.String regionDescription) {
        this.regionDescription = regionDescription;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CompanyRegionGroupTSData)) return false;
        CompanyRegionGroupTSData other = (CompanyRegionGroupTSData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.displayName==null && other.getDisplayName()==null) || 
             (this.displayName!=null &&
              this.displayName.equals(other.getDisplayName()))) &&
            ((this.regionAdGroupName==null && other.getRegionAdGroupName()==null) || 
             (this.regionAdGroupName!=null &&
              this.regionAdGroupName.equals(other.getRegionAdGroupName()))) &&
            ((this.regionCode==null && other.getRegionCode()==null) || 
             (this.regionCode!=null &&
              this.regionCode.equals(other.getRegionCode()))) &&
            ((this.regionDescription==null && other.getRegionDescription()==null) || 
             (this.regionDescription!=null &&
              this.regionDescription.equals(other.getRegionDescription())));
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
        if (getDisplayName() != null) {
            _hashCode += getDisplayName().hashCode();
        }
        if (getRegionAdGroupName() != null) {
            _hashCode += getRegionAdGroupName().hashCode();
        }
        if (getRegionCode() != null) {
            _hashCode += getRegionCode().hashCode();
        }
        if (getRegionDescription() != null) {
            _hashCode += getRegionDescription().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CompanyRegionGroupTSData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.st.com/refData", "companyRegionGroupTSData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("displayName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "displayName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regionAdGroupName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "regionAdGroupName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regionCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "regionCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regionDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("", "regionDescription"));
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
