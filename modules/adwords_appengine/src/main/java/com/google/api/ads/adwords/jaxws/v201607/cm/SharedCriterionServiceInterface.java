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


package com.google.api.ads.adwords.jaxws.v201607.cm;

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
 *       Manages which criteria are associated with shared sets.
 *     
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.1
 * 
 */
@WebService(name = "SharedCriterionServiceInterface", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201607")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SharedCriterionServiceInterface {


    /**
     * 
     *         Returns a list of SharedCriterion that meets the selector criteria.
     *         
     *         @param selector filters the criteria returned
     *         @return The list of SharedCriterion
     *         @throws ApiException
     *       
     * 
     * @param selector
     * @return
     *     returns com.google.api.ads.adwords.jaxws.v201607.cm.SharedCriterionPage
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201607")
    @RequestWrapper(localName = "get", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201607", className = "com.google.api.ads.adwords.jaxws.v201607.cm.SharedCriterionServiceInterfaceget")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201607", className = "com.google.api.ads.adwords.jaxws.v201607.cm.SharedCriterionServiceInterfacegetResponse")
    public SharedCriterionPage get(
        @WebParam(name = "selector", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201607")
        Selector selector)
        throws ApiException_Exception
    ;

    /**
     * 
     *         Adds, removes criteria in a shared set.
     *         
     *         @param operations A list of unique operations
     *         @return The list of updated SharedCriterion, returned in the same order as the
     *         {@code operations} array.
     *         @throws ApiException
     *       
     * 
     * @param operations
     * @return
     *     returns com.google.api.ads.adwords.jaxws.v201607.cm.SharedCriterionReturnValue
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201607")
    @RequestWrapper(localName = "mutate", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201607", className = "com.google.api.ads.adwords.jaxws.v201607.cm.SharedCriterionServiceInterfacemutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201607", className = "com.google.api.ads.adwords.jaxws.v201607.cm.SharedCriterionServiceInterfacemutateResponse")
    public SharedCriterionReturnValue mutate(
        @WebParam(name = "operations", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201607")
        List<SharedCriterionOperation> operations)
        throws ApiException_Exception
    ;

    /**
     * 
     *         Returns the list of SharedCriterion that match the query.
     *         
     *         @param query The SQL-like AWQL query string.
     *         @return A list of SharedCriterion.
     *         @throws ApiException
     *       
     * 
     * @param query
     * @return
     *     returns com.google.api.ads.adwords.jaxws.v201607.cm.SharedCriterionPage
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201607")
    @RequestWrapper(localName = "query", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201607", className = "com.google.api.ads.adwords.jaxws.v201607.cm.SharedCriterionServiceInterfacequery")
    @ResponseWrapper(localName = "queryResponse", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201607", className = "com.google.api.ads.adwords.jaxws.v201607.cm.SharedCriterionServiceInterfacequeryResponse")
    public SharedCriterionPage query(
        @WebParam(name = "query", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201607")
        String query)
        throws ApiException_Exception
    ;

}
