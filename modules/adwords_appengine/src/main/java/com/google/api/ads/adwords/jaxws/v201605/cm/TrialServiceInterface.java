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


package com.google.api.ads.adwords.jaxws.v201605.cm;

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
 *       TrialService manages the life cycle of campaign trials. It is used to create new trials from
 *       drafts, modify trial properties, promote changes in a trial back to its base campaign, and to
 *       archive a trial.
 *       
 *       <p>A trial is an experiment, running two variants (trial arms) - the base campaign and the trial
 *       - at the same time, directing a fixed share of traffic to each trial arm. A trial is created from
 *       a draft of the base campaign and will be a snapshot of changes in the draft at the time of
 *       creation.
 *       
 *       <h3>Constraints</h3>
 *       
 *       <ul>
 *       <li>A campaign cannot have running/scheduled "AdWords Campaign Experiments" (ACE) and
 *       running/scheduled trials at the same time. Trial creation will fail, if the base campaign
 *       has a running/scheduled ACE experiment.</li>
 *       <li>Trial names must be unique across all of the customer's non-deleted trial and campaign
 *       names.</li>
 *       <li>When creating a trial, [startDate, endDate] cannot be in the past or overlap with any other
 *       running/scheduled trial, must be within the base campaign's [startDate, endDate] and
 *       endDate must be later than startDate.</li>
 *       <li>A future startDate/endDate can be updated to a different future startDate/endDate as long
 *       as the constraints on [startDate, endDate] are not violated.</li>
 *       <li>There is at most one trial running and at most one trial scheduled for the future at a
 *       time, per base campaign.</li>
 *       <li>The base campaign's budget cannot be shared with any other campaign. Trial creation will
 *       fail if the base campaign's budget is shared with another campaign.</li>
 *       </ul>
 *       
 *       <h3>Life cycle</h3>
 *       
 *       A trial's {@link Trial#status status} reflects the state of the trial within its life cycle. Some
 *       status transitions are performed explicitly by sending a {@link Operator#SET SET} operation,
 *       while other status transitions occur asynchronously without a client operation.
 *       
 *       <p>When a trial is first {@link Operator#ADD ADD}ed, its status is
 *       {@link TrialStatus#CREATING CREATING}. The trial will be created asynchronously, and once it
 *       is fully created, its status will change to {@link TrialStatus#ACTIVE ACTIVE}.
 *       
 *       <p>If the asynchronous creation of the trial fails, its status will change to
 *       {@link TrialStatus#CREATION_FAILED CREATION_FAILED}.
 *       
 *       <p>To promote changes in an {@link TrialStatus#ACTIVE ACTIVE} trial back to the base campaign,
 *       set the trial status to {@link TrialStatus#PROMOTING PROMOTING}. The promotion itself will occur
 *       asynchronously. If the promotion operation fails after some of the base campaign has already been
 *       updated, the status will change to {@link TrialStatus#PROMOTE_FAILED PROMOTE_FAILED}.
 *       
 *       <p>To graduate an {@link TrialStatus#ACTIVE ACTIVE} trial, which will allow its associated
 *       campaign to act independently of the trial and free it of restrictions from the trial, set the
 *       status to {@link TrialStatus#GRADUATED GRADUATED} and provide a new
 *       {@link Budget#budgetid budgetId} for the campaign to use (since it can no longer share the base
 *       campaign's budget).
 *       
 *       <p>Any trial that is not {@link TrialStatus#CREATING CREATING} or
 *       {@link TrialStatus#PROMOTING PROMOTING} can be archived by setting the status to the value of the
 *       same name.
 *     
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.1
 * 
 */
@WebService(name = "TrialServiceInterface", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201605")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TrialServiceInterface {


    /**
     * 
     *         Loads a TrialPage containing a list of {@link Trial} objects matching the selector.
     *         
     *         @param selector defines which subset of all available trials to return, the sort order, and
     *         which fields to include
     *         
     *         @return Returns a page of matching trial objects.
     *         @throws com.google.ads.api.services.common.error.ApiException if errors occurred while
     *         retrieving the results.
     *       
     * 
     * @param selector
     * @return
     *     returns com.google.api.ads.adwords.jaxws.v201605.cm.TrialPage
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201605")
    @RequestWrapper(localName = "get", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201605", className = "com.google.api.ads.adwords.jaxws.v201605.cm.TrialServiceInterfaceget")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201605", className = "com.google.api.ads.adwords.jaxws.v201605.cm.TrialServiceInterfacegetResponse")
    public TrialPage get(
        @WebParam(name = "selector", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201605")
        Selector selector)
        throws ApiException_Exception
    ;

    /**
     * 
     *         Creates new trials, updates properties and controls the life cycle of existing trials.
     *         See {@link TrialService} for details on the trial life cycle.
     *         
     *         @return Returns the list of updated Trials, in the same order as the {@code operations} list.
     *         @throws com.google.ads.api.services.common.error.ApiException if errors occurred while
     *         processing the request.
     *       
     * 
     * @param operations
     * @return
     *     returns com.google.api.ads.adwords.jaxws.v201605.cm.TrialReturnValue
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201605")
    @RequestWrapper(localName = "mutate", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201605", className = "com.google.api.ads.adwords.jaxws.v201605.cm.TrialServiceInterfacemutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201605", className = "com.google.api.ads.adwords.jaxws.v201605.cm.TrialServiceInterfacemutateResponse")
    public TrialReturnValue mutate(
        @WebParam(name = "operations", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201605")
        List<TrialOperation> operations)
        throws ApiException_Exception
    ;

    /**
     * 
     *         Loads a TrialPage containing a list of {@link Trial} objects matching the query.
     *         
     *         @param query defines which subset of all available trials to return, the sort order, and
     *         which fields to include
     *         
     *         @return Returns a page of matching trial objects.
     *         @throws com.google.ads.api.services.common.error.ApiException if errors occurred while
     *         retrieving the results.
     *       
     * 
     * @param query
     * @return
     *     returns com.google.api.ads.adwords.jaxws.v201605.cm.TrialPage
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201605")
    @RequestWrapper(localName = "query", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201605", className = "com.google.api.ads.adwords.jaxws.v201605.cm.TrialServiceInterfacequery")
    @ResponseWrapper(localName = "queryResponse", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201605", className = "com.google.api.ads.adwords.jaxws.v201605.cm.TrialServiceInterfacequeryResponse")
    public TrialPage query(
        @WebParam(name = "query", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201605")
        String query)
        throws ApiException_Exception
    ;

}
