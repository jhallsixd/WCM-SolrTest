/**
 * Role.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.st.olm.cq.stcom.ws;

public class Role  implements java.io.Serializable {
    private java.lang.String appXRoleId;

    private java.lang.String code;

    private java.lang.String genRemTkt;

    private java.lang.String name;

    private java.lang.String peremiters;

    public Role() {
    }

    public Role(
           java.lang.String appXRoleId,
           java.lang.String code,
           java.lang.String genRemTkt,
           java.lang.String name,
           java.lang.String peremiters) {
           this.appXRoleId = appXRoleId;
           this.code = code;
           this.genRemTkt = genRemTkt;
           this.name = name;
           this.peremiters = peremiters;
    }


    /**
     * Gets the appXRoleId value for this Role.
     * 
     * @return appXRoleId
     */
    public java.lang.String getAppXRoleId() {
        return appXRoleId;
    }


    /**
     * Sets the appXRoleId value for this Role.
     * 
     * @param appXRoleId
     */
    public void setAppXRoleId(java.lang.String appXRoleId) {
        this.appXRoleId = appXRoleId;
    }


    /**
     * Gets the code value for this Role.
     * 
     * @return code
     */
    public java.lang.String getCode() {
        return code;
    }


    /**
     * Sets the code value for this Role.
     * 
     * @param code
     */
    public void setCode(java.lang.String code) {
        this.code = code;
    }


    /**
     * Gets the genRemTkt value for this Role.
     * 
     * @return genRemTkt
     */
    public java.lang.String getGenRemTkt() {
        return genRemTkt;
    }


    /**
     * Sets the genRemTkt value for this Role.
     * 
     * @param genRemTkt
     */
    public void setGenRemTkt(java.lang.String genRemTkt) {
        this.genRemTkt = genRemTkt;
    }


    /**
     * Gets the name value for this Role.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Role.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the peremiters value for this Role.
     * 
     * @return peremiters
     */
    public java.lang.String getPeremiters() {
        return peremiters;
    }


    /**
     * Sets the peremiters value for this Role.
     * 
     * @param peremiters
     */
    public void setPeremiters(java.lang.String peremiters) {
        this.peremiters = peremiters;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Role)) return false;
        Role other = (Role) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.appXRoleId==null && other.getAppXRoleId()==null) || 
             (this.appXRoleId!=null &&
              this.appXRoleId.equals(other.getAppXRoleId()))) &&
            ((this.code==null && other.getCode()==null) || 
             (this.code!=null &&
              this.code.equals(other.getCode()))) &&
            ((this.genRemTkt==null && other.getGenRemTkt()==null) || 
             (this.genRemTkt!=null &&
              this.genRemTkt.equals(other.getGenRemTkt()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.peremiters==null && other.getPeremiters()==null) || 
             (this.peremiters!=null &&
              this.peremiters.equals(other.getPeremiters())));
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
        if (getAppXRoleId() != null) {
            _hashCode += getAppXRoleId().hashCode();
        }
        if (getCode() != null) {
            _hashCode += getCode().hashCode();
        }
        if (getGenRemTkt() != null) {
            _hashCode += getGenRemTkt().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPeremiters() != null) {
            _hashCode += getPeremiters().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Role.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.st.com/refData", "role"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("appXRoleId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "appXRoleId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("genRemTkt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "genRemTkt"));
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
        elemField.setFieldName("peremiters");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peremiters"));
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
