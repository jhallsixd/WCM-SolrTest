/**
 * ApplicationImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.st.olm.cq.stcom.ws;

public class ApplicationImpl  implements java.io.Serializable {
    private java.lang.String accessLevel;

    private java.lang.String adCode;

    private com.st.olm.cq.stcom.ws.Role[] allowedRoles;

    private java.lang.String code;

    private java.lang.String description;

    private java.lang.String jointVentureCode;

    private java.lang.String notes;

    private com.st.olm.cq.stcom.ws.Cti remedyCTI;

    private java.lang.String url;

    public ApplicationImpl() {
    }

    public ApplicationImpl(
           java.lang.String accessLevel,
           java.lang.String adCode,
           com.st.olm.cq.stcom.ws.Role[] allowedRoles,
           java.lang.String code,
           java.lang.String description,
           java.lang.String jointVentureCode,
           java.lang.String notes,
           com.st.olm.cq.stcom.ws.Cti remedyCTI,
           java.lang.String url) {
           this.accessLevel = accessLevel;
           this.adCode = adCode;
           this.allowedRoles = allowedRoles;
           this.code = code;
           this.description = description;
           this.jointVentureCode = jointVentureCode;
           this.notes = notes;
           this.remedyCTI = remedyCTI;
           this.url = url;
    }


    /**
     * Gets the accessLevel value for this ApplicationImpl.
     * 
     * @return accessLevel
     */
    public java.lang.String getAccessLevel() {
        return accessLevel;
    }


    /**
     * Sets the accessLevel value for this ApplicationImpl.
     * 
     * @param accessLevel
     */
    public void setAccessLevel(java.lang.String accessLevel) {
        this.accessLevel = accessLevel;
    }


    /**
     * Gets the adCode value for this ApplicationImpl.
     * 
     * @return adCode
     */
    public java.lang.String getAdCode() {
        return adCode;
    }


    /**
     * Sets the adCode value for this ApplicationImpl.
     * 
     * @param adCode
     */
    public void setAdCode(java.lang.String adCode) {
        this.adCode = adCode;
    }


    /**
     * Gets the allowedRoles value for this ApplicationImpl.
     * 
     * @return allowedRoles
     */
    public com.st.olm.cq.stcom.ws.Role[] getAllowedRoles() {
        return allowedRoles;
    }


    /**
     * Sets the allowedRoles value for this ApplicationImpl.
     * 
     * @param allowedRoles
     */
    public void setAllowedRoles(com.st.olm.cq.stcom.ws.Role[] allowedRoles) {
        this.allowedRoles = allowedRoles;
    }

    public com.st.olm.cq.stcom.ws.Role getAllowedRoles(int i) {
        return this.allowedRoles[i];
    }

    public void setAllowedRoles(int i, com.st.olm.cq.stcom.ws.Role _value) {
        this.allowedRoles[i] = _value;
    }


    /**
     * Gets the code value for this ApplicationImpl.
     * 
     * @return code
     */
    public java.lang.String getCode() {
        return code;
    }


    /**
     * Sets the code value for this ApplicationImpl.
     * 
     * @param code
     */
    public void setCode(java.lang.String code) {
        this.code = code;
    }


    /**
     * Gets the description value for this ApplicationImpl.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ApplicationImpl.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the jointVentureCode value for this ApplicationImpl.
     * 
     * @return jointVentureCode
     */
    public java.lang.String getJointVentureCode() {
        return jointVentureCode;
    }


    /**
     * Sets the jointVentureCode value for this ApplicationImpl.
     * 
     * @param jointVentureCode
     */
    public void setJointVentureCode(java.lang.String jointVentureCode) {
        this.jointVentureCode = jointVentureCode;
    }


    /**
     * Gets the notes value for this ApplicationImpl.
     * 
     * @return notes
     */
    public java.lang.String getNotes() {
        return notes;
    }


    /**
     * Sets the notes value for this ApplicationImpl.
     * 
     * @param notes
     */
    public void setNotes(java.lang.String notes) {
        this.notes = notes;
    }


    /**
     * Gets the remedyCTI value for this ApplicationImpl.
     * 
     * @return remedyCTI
     */
    public com.st.olm.cq.stcom.ws.Cti getRemedyCTI() {
        return remedyCTI;
    }


    /**
     * Sets the remedyCTI value for this ApplicationImpl.
     * 
     * @param remedyCTI
     */
    public void setRemedyCTI(com.st.olm.cq.stcom.ws.Cti remedyCTI) {
        this.remedyCTI = remedyCTI;
    }


    /**
     * Gets the url value for this ApplicationImpl.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this ApplicationImpl.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ApplicationImpl)) return false;
        ApplicationImpl other = (ApplicationImpl) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accessLevel==null && other.getAccessLevel()==null) || 
             (this.accessLevel!=null &&
              this.accessLevel.equals(other.getAccessLevel()))) &&
            ((this.adCode==null && other.getAdCode()==null) || 
             (this.adCode!=null &&
              this.adCode.equals(other.getAdCode()))) &&
            ((this.allowedRoles==null && other.getAllowedRoles()==null) || 
             (this.allowedRoles!=null &&
              java.util.Arrays.equals(this.allowedRoles, other.getAllowedRoles()))) &&
            ((this.code==null && other.getCode()==null) || 
             (this.code!=null &&
              this.code.equals(other.getCode()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.jointVentureCode==null && other.getJointVentureCode()==null) || 
             (this.jointVentureCode!=null &&
              this.jointVentureCode.equals(other.getJointVentureCode()))) &&
            ((this.notes==null && other.getNotes()==null) || 
             (this.notes!=null &&
              this.notes.equals(other.getNotes()))) &&
            ((this.remedyCTI==null && other.getRemedyCTI()==null) || 
             (this.remedyCTI!=null &&
              this.remedyCTI.equals(other.getRemedyCTI()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl())));
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
        if (getAccessLevel() != null) {
            _hashCode += getAccessLevel().hashCode();
        }
        if (getAdCode() != null) {
            _hashCode += getAdCode().hashCode();
        }
        if (getAllowedRoles() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAllowedRoles());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAllowedRoles(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCode() != null) {
            _hashCode += getCode().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getJointVentureCode() != null) {
            _hashCode += getJointVentureCode().hashCode();
        }
        if (getNotes() != null) {
            _hashCode += getNotes().hashCode();
        }
        if (getRemedyCTI() != null) {
            _hashCode += getRemedyCTI().hashCode();
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ApplicationImpl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.st.com/refData", "applicationImpl"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accessLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accessLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "adCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allowedRoles");
        elemField.setXmlName(new javax.xml.namespace.QName("", "allowedRoles"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.st.com/refData", "role"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jointVentureCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jointVentureCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "notes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remedyCTI");
        elemField.setXmlName(new javax.xml.namespace.QName("", "remedyCTI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.st.com/refData", "cti"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url"));
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
