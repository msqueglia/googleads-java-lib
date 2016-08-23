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


package com.google.api.ads.dfp.jaxws.v201511;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ThirdPartyAudienceSegment.AudienceSegmentApprovalStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ThirdPartyAudienceSegment.AudienceSegmentApprovalStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UNAPPROVED"/>
 *     &lt;enumeration value="APPROVED"/>
 *     &lt;enumeration value="REJECTED"/>
 *     &lt;enumeration value="UNKNOWN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ThirdPartyAudienceSegment.AudienceSegmentApprovalStatus")
@XmlEnum
public enum ThirdPartyAudienceSegmentAudienceSegmentApprovalStatus {


    /**
     * 
     *                 Specifies that this segment is waiting to be approved or rejected. It cannot be targeted.
     *               
     * 
     */
    UNAPPROVED,

    /**
     * 
     *                 Specifies that this segment is approved and can be targeted.
     *               
     * 
     */
    APPROVED,

    /**
     * 
     *                 Specifies that this segment is rejected and cannot be targeted.
     *               
     * 
     */
    REJECTED,

    /**
     * 
     *                 The value returned if the actual value is not exposed by the requested API version.
     *               
     * 
     */
    UNKNOWN;

    public String value() {
        return name();
    }

    public static ThirdPartyAudienceSegmentAudienceSegmentApprovalStatus fromValue(String v) {
        return valueOf(v);
    }

}
