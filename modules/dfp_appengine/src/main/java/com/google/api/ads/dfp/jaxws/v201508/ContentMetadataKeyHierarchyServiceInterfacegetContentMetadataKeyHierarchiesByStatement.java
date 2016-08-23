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


package com.google.api.ads.dfp.jaxws.v201508;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *             Gets a {@link ContentMetadataKeyHierarchyPage} of {@link ContentMetadataKeyHierarchy}
 *             objects that satisfy the given {@link Statement#query}. The following fields are supported
 *             for filtering:
 *             
 *             <table>
 *             <tr>
 *             <th scope="col">PQL Property</th> <th scope="col">Object Property</th>
 *             </tr>
 *             <tr>
 *             <td>{@code id}</td>
 *             <td>{@link ContentMetadataKeyHierarchy#id}</td>
 *             </tr>
 *             <tr>
 *             <td>{@code name}</td>
 *             <td>{@link ContentMetadataKeyHierarchy#name}</td>
 *             </tr>
 *             <tr>
 *             <td>{@code status}</td>
 *             <td>{@link ContentMetadataKeyHierarchy#status}</td>
 *             </tr>
 *             </table>
 *             
 *             @param filterStatement a Publisher Query Language statement used to filter a set of
 *             content metadata key hierarchies
 *             @return the content metadata key hierarchies that match the given filter
 *             @throws ApiException if the ID of the active network does not exist or there is a
 *             backend error
 *           
 * 
 * <p>Java class for getContentMetadataKeyHierarchiesByStatement element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="getContentMetadataKeyHierarchiesByStatement">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element name="filterStatement" type="{https://www.google.com/apis/ads/publisher/v201508}Statement" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "filterStatement"
})
@XmlRootElement(name = "getContentMetadataKeyHierarchiesByStatement")
public class ContentMetadataKeyHierarchyServiceInterfacegetContentMetadataKeyHierarchiesByStatement {

    protected Statement filterStatement;

    /**
     * Gets the value of the filterStatement property.
     * 
     * @return
     *     possible object is
     *     {@link Statement }
     *     
     */
    public Statement getFilterStatement() {
        return filterStatement;
    }

    /**
     * Sets the value of the filterStatement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Statement }
     *     
     */
    public void setFilterStatement(Statement value) {
        this.filterStatement = value;
    }

}
