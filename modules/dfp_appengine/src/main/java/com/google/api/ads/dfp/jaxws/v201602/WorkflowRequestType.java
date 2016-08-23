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


package com.google.api.ads.dfp.jaxws.v201602;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WorkflowRequestType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WorkflowRequestType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="WORKFLOW_APPROVAL_REQUEST"/>
 *     &lt;enumeration value="WORKFLOW_EXTERNAL_CONDITION_REQUEST"/>
 *     &lt;enumeration value="UNKNOWN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WorkflowRequestType")
@XmlEnum
public enum WorkflowRequestType {


    /**
     * 
     *                 This is a request for an approval action. Either by a frontend user or an API request.
     *               
     * 
     */
    WORKFLOW_APPROVAL_REQUEST,

    /**
     * 
     *                 This is an external condition request. It is pending an external system to determine whether an
     *                 action should trigger or not.
     *               
     * 
     */
    WORKFLOW_EXTERNAL_CONDITION_REQUEST,
    UNKNOWN;

    public String value() {
        return name();
    }

    public static WorkflowRequestType fromValue(String v) {
        return valueOf(v);
    }

}
