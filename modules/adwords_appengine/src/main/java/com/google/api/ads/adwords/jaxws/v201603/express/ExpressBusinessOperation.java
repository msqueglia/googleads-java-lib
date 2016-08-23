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


package com.google.api.ads.adwords.jaxws.v201603.express;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.google.api.ads.adwords.jaxws.v201603.cm.Operation;


/**
 * 
 *             A typed {@link Operation} class that uses an instance of {@link ExpressBusiness} as its operand.
 *             
 *             <p class="note"><b>Note:</b> The <code>REMOVE</code> operator is not
 *             supported. To remove an {@link ExpressBusiness}, set its {@link ExpressBusiness#status status}
 *             to <code>DELETED</code>.</p>
 *           
 * 
 * <p>Java class for ExpressBusinessOperation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExpressBusinessOperation">
 *   &lt;complexContent>
 *     &lt;extension base="{https://adwords.google.com/api/adwords/cm/v201603}Operation">
 *       &lt;sequence>
 *         &lt;element name="operand" type="{https://adwords.google.com/api/adwords/express/v201603}ExpressBusiness" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExpressBusinessOperation", propOrder = {
    "operand"
})
public class ExpressBusinessOperation
    extends Operation
{

    protected ExpressBusiness operand;

    /**
     * Gets the value of the operand property.
     * 
     * @return
     *     possible object is
     *     {@link ExpressBusiness }
     *     
     */
    public ExpressBusiness getOperand() {
        return operand;
    }

    /**
     * Sets the value of the operand property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressBusiness }
     *     
     */
    public void setOperand(ExpressBusiness value) {
        this.operand = value;
    }

}
