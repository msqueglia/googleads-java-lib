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

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * 
 *       BiddingStrategy Service to get/mutate bidding strategies.
 *       <span class="constraint AdxEnabled">This is disabled for AdX.</span>
 *     
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.1
 * 
 */
@WebService(name = "BiddingStrategyServiceInterface", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BiddingStrategyServiceInterface {


    /**
     * 
     *         Returns a list of bidding strategies that match the selector.
     *         
     *         @return list of bidding strategies specified by the selector.
     *         @throws com.google.ads.api.services.common.error.ApiException if problems
     *         occurred while retrieving results.
     *       
     * 
     * @param selector
     * @return
     *     returns com.google.api.ads.adwords.jaxws.v201603.cm.BiddingStrategyPage
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603")
    @RequestWrapper(localName = "get", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603", className = "com.google.api.ads.adwords.jaxws.v201603.cm.BiddingStrategyServiceInterfaceget")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603", className = "com.google.api.ads.adwords.jaxws.v201603.cm.BiddingStrategyServiceInterfacegetResponse")
    public BiddingStrategyPage get(
        @WebParam(name = "selector", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603")
        Selector selector)
        throws ApiException_Exception
    ;

    /**
     * 
     *         Applies the list of mutate operations.
     *         
     *         @param operations the operations to apply
     *         @return the modified list of BiddingStrategy
     *         @throws ApiException
     *       
     * 
     * @param operations
     * @return
     *     returns com.google.api.ads.adwords.jaxws.v201603.cm.BiddingStrategyReturnValue
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603")
    @RequestWrapper(localName = "mutate", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603", className = "com.google.api.ads.adwords.jaxws.v201603.cm.BiddingStrategyServiceInterfacemutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603", className = "com.google.api.ads.adwords.jaxws.v201603.cm.BiddingStrategyServiceInterfacemutateResponse")
    public BiddingStrategyReturnValue mutate(
        @WebParam(name = "operations", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603")
        List<BiddingStrategyOperation> operations)
        throws ApiException_Exception
    ;

    /**
     * 
     *         Returns a list of bidding strategies that match the query.
     *         
     *         @param query The SQL-like AWQL query string.
     *         @throws ApiException when there are one or more errors with the request.
     *       
     * 
     * @param query
     * @return
     *     returns com.google.api.ads.adwords.jaxws.v201603.cm.BiddingStrategyPage
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603")
    @RequestWrapper(localName = "query", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603", className = "com.google.api.ads.adwords.jaxws.v201603.cm.BiddingStrategyServiceInterfacequery")
    @ResponseWrapper(localName = "queryResponse", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603", className = "com.google.api.ads.adwords.jaxws.v201603.cm.BiddingStrategyServiceInterfacequeryResponse")
    public BiddingStrategyPage query(
        @WebParam(name = "query", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201603")
        String query)
        throws ApiException_Exception
    ;

}
