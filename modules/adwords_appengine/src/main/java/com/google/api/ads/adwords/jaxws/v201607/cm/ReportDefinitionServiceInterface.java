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
 *       <p><b>Note:</b> As of v201109 this service is read-only. New report
 *       definitions are no longer allowed.</p>
 *       <p>A report definition describes the report type, date range, and
 *       {@linkplain Selector fields to include in the report}. Additionally, you can
 *       specify {@linkplain Predicate predicates} to filter which rows are returned
 *       in a generated report. Please note that sorting and paging are not supported for report
 *       downloads.</p>
 *       
 *       <p>To find out which report fields are available based on report
 *       type, see the <a href="/adwords/api/docs/appendix/reports">Report
 *       Types</a> appendix or call {@link #getReportFields}.</p>
 *       
 *       <p>For more information about retrieving reports, see
 *       <a href="/adwords/api/docs/guides/reporting">Reporting Basics</a>.
 *     
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.1
 * 
 */
@WebService(name = "ReportDefinitionServiceInterface", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201607")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ReportDefinitionServiceInterface {


    /**
     * 
     *         Returns the available report fields for a given report type.
     *         When using this method the {@code clientCustomerId} header field is
     *         optional. Callers are discouraged from setting the clientCustomerId
     *         header field in calls to this method as its presence will trigger an
     *         authorization error if the caller does not have access to the customer
     *         with the included ID.
     *         
     *         @param reportType The type of report.
     *         @return The list of available report fields. Each
     *         {@link ReportDefinitionField} encapsulates the field name, the
     *         field data type, and the enum values (if the field's type is
     *         {@code enum}).
     *         @throws ApiException if a problem occurred while fetching the
     *         ReportDefinitionField information.
     *       
     * 
     * @param reportType
     * @return
     *     returns java.util.List<com.google.api.ads.adwords.jaxws.v201607.cm.ReportDefinitionField>
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201607")
    @RequestWrapper(localName = "getReportFields", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201607", className = "com.google.api.ads.adwords.jaxws.v201607.cm.ReportDefinitionServiceInterfacegetReportFields")
    @ResponseWrapper(localName = "getReportFieldsResponse", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201607", className = "com.google.api.ads.adwords.jaxws.v201607.cm.ReportDefinitionServiceInterfacegetReportFieldsResponse")
    public List<ReportDefinitionField> getReportFields(
        @WebParam(name = "reportType", targetNamespace = "https://adwords.google.com/api/adwords/cm/v201607")
        ReportDefinitionReportType reportType)
        throws ApiException_Exception
    ;

}
