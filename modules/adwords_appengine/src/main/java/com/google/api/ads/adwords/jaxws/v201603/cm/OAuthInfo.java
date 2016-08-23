// Copyright 2016 Google Inc. All Rights Reserved.
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


package com.google.api.ads.adwords.jaxws.v201603.cm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *             Data used for authorization using OAuth.
 *             For more information about OAuth, see:
 *             {@link "https://developers.google.com/accounts/docs/OAuth2"}
 *           
 * 
 * <p>Java class for OAuthInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OAuthInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="httpMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="httpRequestUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="httpAuthorizationHeader" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OAuthInfo", propOrder = {
    "httpMethod",
    "httpRequestUrl",
    "httpAuthorizationHeader"
})
public class OAuthInfo {

    protected String httpMethod;
    protected String httpRequestUrl;
    protected String httpAuthorizationHeader;

    /**
     * Gets the value of the httpMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHttpMethod() {
        return httpMethod;
    }

    /**
     * Sets the value of the httpMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHttpMethod(String value) {
        this.httpMethod = value;
    }

    /**
     * Gets the value of the httpRequestUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHttpRequestUrl() {
        return httpRequestUrl;
    }

    /**
     * Sets the value of the httpRequestUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHttpRequestUrl(String value) {
        this.httpRequestUrl = value;
    }

    /**
     * Gets the value of the httpAuthorizationHeader property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHttpAuthorizationHeader() {
        return httpAuthorizationHeader;
    }

    /**
     * Sets the value of the httpAuthorizationHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHttpAuthorizationHeader(String value) {
        this.httpAuthorizationHeader = value;
    }

}
