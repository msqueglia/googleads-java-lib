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
 *       Service to access basic details about any customer.
 *     
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.1
 * 
 */
@WebService(name = "CustomerServiceInterface", targetNamespace = "https://adwords.google.com/api/adwords/mcm/v201605")
@XmlSeeAlso({
    com.google.api.ads.adwords.jaxws.v201605.cm.ObjectFactory.class,
    com.google.api.ads.adwords.jaxws.v201605.mcm.ObjectFactory.class
})
public interface CustomerServiceInterface {


    /**
     * 
     *         Returns details of the authorized customer.
     *         
     *         @return customer associated with the caller
     *       
     * 
     * @return
     *     returns com.google.api.ads.adwords.jaxws.v201605.mcm.Customer
     * @throws ApiException
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://adwords.google.com/api/adwords/mcm/v201605")
    @RequestWrapper(localName = "get", targetNamespace = "https://adwords.google.com/api/adwords/mcm/v201605", className = "com.google.api.ads.adwords.jaxws.v201605.mcm.CustomerServiceInterfaceget")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "https://adwords.google.com/api/adwords/mcm/v201605", className = "com.google.api.ads.adwords.jaxws.v201605.mcm.CustomerServiceInterfacegetResponse")
    public Customer get()
        throws ApiException
    ;

    /**
     * 
     *         Returns details of all the customers directly accessible by the user authenticating the call.
     *         <p>
     *         Following V201605, if {@code clientCustomerId} is specified in the request header,
     *         only details of that customer will be returned.
     *       
     * 
     * @return
     *     returns java.util.List<com.google.api.ads.adwords.jaxws.v201605.mcm.Customer>
     * @throws ApiException
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://adwords.google.com/api/adwords/mcm/v201605")
    @RequestWrapper(localName = "getCustomers", targetNamespace = "https://adwords.google.com/api/adwords/mcm/v201605", className = "com.google.api.ads.adwords.jaxws.v201605.mcm.CustomerServiceInterfacegetCustomers")
    @ResponseWrapper(localName = "getCustomersResponse", targetNamespace = "https://adwords.google.com/api/adwords/mcm/v201605", className = "com.google.api.ads.adwords.jaxws.v201605.mcm.CustomerServiceInterfacegetCustomersResponse")
    public List<Customer> getCustomers()
        throws ApiException
    ;

    /**
     * 
     *         Update the authorized customer.
     *         
     *         <p>While there are a limited set of properties available to update, please read this
     *         <a href="https://support.google.com/analytics/answer/1033981">help center article
     *         on auto-tagging</a> before updating {@code customer.autoTaggingEnabled}.
     *         
     *         @param customer the requested updated value for the customer.
     *         @throws ApiException
     *       
     * 
     * @param customer
     * @return
     *     returns com.google.api.ads.adwords.jaxws.v201605.mcm.Customer
     * @throws ApiException
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://adwords.google.com/api/adwords/mcm/v201605")
    @RequestWrapper(localName = "mutate", targetNamespace = "https://adwords.google.com/api/adwords/mcm/v201605", className = "com.google.api.ads.adwords.jaxws.v201605.mcm.CustomerServiceInterfacemutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "https://adwords.google.com/api/adwords/mcm/v201605", className = "com.google.api.ads.adwords.jaxws.v201605.mcm.CustomerServiceInterfacemutateResponse")
    public Customer mutate(
        @WebParam(name = "customer", targetNamespace = "https://adwords.google.com/api/adwords/mcm/v201605")
        Customer customer)
        throws ApiException
    ;

}
