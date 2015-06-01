/**
 * IndustryCompSegmentTSData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.st.olm.cq.stcom.ws;

public class IndustryCompSegmentTSData  implements java.io.Serializable {
    private java.lang.String displayName;

    private java.lang.String id;

    private java.lang.String name;

    private java.lang.String verticalAdGroupName;

    private boolean visible;

    public IndustryCompSegmentTSData() {
    }

    public IndustryCompSegmentTSData(
           java.lang.String displayName,
           java.lang.String id,
           java.lang.String name,
           java.lang.String verticalAdGroupName,
           boolean visible) {
           this.displayName = displayName;
           this.id = id;
           this.name = name;
           this.verticalAdGroupName = verticalAdGroupName;
           this.visible = visible;
    }


    /**
     * Gets the displayName value for this IndustryCompSegmentTSData.
     * 
     * @return displayName
     */
    public java.lang.String getDisplayName() {
        return displayName;
    }


    /**
     * Sets the displayName value for this IndustryCompSegmentTSData.
     * 
     * @param displayName
     */
    public void setDisplayName(java.lang.String displayName) {
        this.displayName = displayName;
    }


    /**
     * Gets the id value for this IndustryCompSegmentTSData.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this IndustryCompSegmentTSData.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the name value for this IndustryCompSegmentTSData.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this IndustryCompSegmentTSData.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the verticalAdGroupName value for this IndustryCompSegmentTSData.
     * 
     * @return verticalAdGroupName
     */
    public java.lang.String getVerticalAdGroupName() {
        return verticalAdGroupName;
    }


    /**
     * Sets the verticalAdGroupName value for this IndustryCompSegmentTSData.
     * 
     * @param verticalAdGroupName
     */
    public void setVerticalAdGroupName(java.lang.String verticalAdGroupName) {
        this.verticalAdGroupName = verticalAdGroupName;
    }


    /**
     * Gets the visible value for this IndustryCompSegmentTSData.
     * 
     * @return visible
     */
    public boolean isVisible() {
        return visible;
    }


    /**
     * Sets the visible value for this IndustryCompSegmentTSData.
     * 
     * @param visible
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IndustryCompSegmentTSData)) return false;
        IndustryCompSegmentTSData other = (IndustryCompSegmentTSData) obj;
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
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.verticalAdGroupName==null && other.getVerticalAdGroupName()==null) || 
             (this.verticalAdGroupName!=null &&
              this.verticalAdGroupName.equals(other.getVerticalAdGroupName()))) &&
            this.visible == other.isVisible();
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getVerticalAdGroupName() != null) {
            _hashCode += getVerticalAdGroupName().hashCode();
        }
        _hashCode += (isVisible() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IndustryCompSegmentTSData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.st.com/refData", "industryCompSegmentTSData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("displayName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "displayName"));
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
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("verticalAdGroupName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "verticalAdGroupName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("visible");
        elemField.setXmlName(new javax.xml.namespace.QName("", "visible"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
