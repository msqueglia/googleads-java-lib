// Copyright 2015 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * OperatingSystemTargeting.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Mar 02, 2009 (07:08:06 PST) WSDL2Java emitter.
 */

package com.google.api.ads.dfp.axis.v201511;


/**
 * Represents operating systems that are being targeted or excluded
 * by the
 *             {@link LineItem}.
 */
public class OperatingSystemTargeting  implements java.io.Serializable {
    /* Indicates whether operating systems should be targeted or excluded.
     * This
     *                 attribute is optional and defaults to {@code true}. */
    private java.lang.Boolean isTargeted;

    /* Operating systems that are being targeted or excluded by the
     * {@link LineItem}. */
    private com.google.api.ads.dfp.axis.v201511.Technology[] operatingSystems;

    public OperatingSystemTargeting() {
    }

    public OperatingSystemTargeting(
           java.lang.Boolean isTargeted,
           com.google.api.ads.dfp.axis.v201511.Technology[] operatingSystems) {
           this.isTargeted = isTargeted;
           this.operatingSystems = operatingSystems;
    }


    /**
     * Gets the isTargeted value for this OperatingSystemTargeting.
     * 
     * @return isTargeted   * Indicates whether operating systems should be targeted or excluded.
     * This
     *                 attribute is optional and defaults to {@code true}.
     */
    public java.lang.Boolean getIsTargeted() {
        return isTargeted;
    }


    /**
     * Sets the isTargeted value for this OperatingSystemTargeting.
     * 
     * @param isTargeted   * Indicates whether operating systems should be targeted or excluded.
     * This
     *                 attribute is optional and defaults to {@code true}.
     */
    public void setIsTargeted(java.lang.Boolean isTargeted) {
        this.isTargeted = isTargeted;
    }


    /**
     * Gets the operatingSystems value for this OperatingSystemTargeting.
     * 
     * @return operatingSystems   * Operating systems that are being targeted or excluded by the
     * {@link LineItem}.
     */
    public com.google.api.ads.dfp.axis.v201511.Technology[] getOperatingSystems() {
        return operatingSystems;
    }


    /**
     * Sets the operatingSystems value for this OperatingSystemTargeting.
     * 
     * @param operatingSystems   * Operating systems that are being targeted or excluded by the
     * {@link LineItem}.
     */
    public void setOperatingSystems(com.google.api.ads.dfp.axis.v201511.Technology[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public com.google.api.ads.dfp.axis.v201511.Technology getOperatingSystems(int i) {
        return this.operatingSystems[i];
    }

    public void setOperatingSystems(int i, com.google.api.ads.dfp.axis.v201511.Technology _value) {
        this.operatingSystems[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OperatingSystemTargeting)) return false;
        OperatingSystemTargeting other = (OperatingSystemTargeting) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.isTargeted==null && other.getIsTargeted()==null) || 
             (this.isTargeted!=null &&
              this.isTargeted.equals(other.getIsTargeted()))) &&
            ((this.operatingSystems==null && other.getOperatingSystems()==null) || 
             (this.operatingSystems!=null &&
              java.util.Arrays.equals(this.operatingSystems, other.getOperatingSystems())));
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
        if (getIsTargeted() != null) {
            _hashCode += getIsTargeted().hashCode();
        }
        if (getOperatingSystems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOperatingSystems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOperatingSystems(), i);
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
        new org.apache.axis.description.TypeDesc(OperatingSystemTargeting.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.google.com/apis/ads/publisher/v201511", "OperatingSystemTargeting"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isTargeted");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.google.com/apis/ads/publisher/v201511", "isTargeted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operatingSystems");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.google.com/apis/ads/publisher/v201511", "operatingSystems"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://www.google.com/apis/ads/publisher/v201511", "Technology"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
