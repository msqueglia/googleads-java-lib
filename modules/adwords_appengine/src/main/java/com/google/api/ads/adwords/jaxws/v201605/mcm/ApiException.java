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


package com.google.api.ads.adwords.jaxws.v201605.mcm;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "ApiExceptionFault", targetNamespace = "https://adwords.google.com/api/adwords/mcm/v201605")
public class ApiException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private com.google.api.ads.adwords.jaxws.v201605.cm.ApiException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ApiException(String message, com.google.api.ads.adwords.jaxws.v201605.cm.ApiException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ApiException(String message, com.google.api.ads.adwords.jaxws.v201605.cm.ApiException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.google.api.ads.adwords.jaxws.v201605.cm.ApiException
     */
    public com.google.api.ads.adwords.jaxws.v201605.cm.ApiException getFaultInfo() {
        return faultInfo;
    }

}
