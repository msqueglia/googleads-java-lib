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
 *       Provides methods for creating, updating and retrieving {@link Package} objects.
 *       <p>
 *       To use this service, you need to have the new sales management solution
 *       enabled on your network. If you do not see a "Sales" tab in
 *       <a href="https://www.google.com/dfp">DoubleClick for Publishers (DFP)</a>,
 *       you will not be able to use this service.
 *       </p>
 *     
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.1
 * 
 */
@WebService(name = "PackageServiceInterface", targetNamespace = "https://www.google.com/apis/ads/publisher/v201511")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PackageServiceInterface {


    /**
     * 
     *         Creates new {@link Package} objects.
     *         
     *         For each package, the following fields are required:
     *         <ul>
     *         <li>{@link Package#proposalId}</li>
     *         <li>{@link Package#productPackageId}</li>
     *         <li>{@link Package#name}</li>
     *         </ul>
     *         
     *         @param packages the packages to create
     *         @return the created packages with their IDs filled in
     *       
     * 
     * @param packages
     * @return
     *     returns java.util.List<com.google.api.ads.dfp.jaxws.v201511.Package>
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201511")
    @RequestWrapper(localName = "createPackages", targetNamespace = "https://www.google.com/apis/ads/publisher/v201511", className = "com.google.api.ads.dfp.jaxws.v201511.PackageServiceInterfacecreatePackages")
    @ResponseWrapper(localName = "createPackagesResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201511", className = "com.google.api.ads.dfp.jaxws.v201511.PackageServiceInterfacecreatePackagesResponse")
    public List<Package> createPackages(
        @WebParam(name = "packages", targetNamespace = "https://www.google.com/apis/ads/publisher/v201511")
        List<Package> packages)
        throws ApiException_Exception
    ;

    /**
     * 
     *         Gets a {@link PackagePage} of {@link Package} objects
     *         that satisfy the given {@link Statement#query}.  The following fields are supported for
     *         filtering:
     *         
     *         <table>
     *         <tr>
     *         <th scope="col">PQL Property</th> <th scope="col">Object Property</th>
     *         </tr>
     *         <tr>
     *         <td>{@code id}</td>
     *         <td>{@link Package#id}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code name}</td>
     *         <td>{@link Package#name}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code proposalId}</td>
     *         <td>{@link Package#proposalId}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code productPackageId}</td>
     *         <td>{@link Package#productPackageId}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code isArchived}</td>
     *         <td>{@link Package#isArchived}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code lastModifiedDateTime}</td>
     *         <td>{@link Package#lastModifiedDateTime}</td>
     *         </tr>
     *         </table>
     *         
     *         @param filterStatement a Publisher Query Language statement used to filter
     *         a set of packages
     *         @return the packages that match the given filter
     *       
     * 
     * @param filterStatement
     * @return
     *     returns com.google.api.ads.dfp.jaxws.v201511.PackagePage
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201511")
    @RequestWrapper(localName = "getPackagesByStatement", targetNamespace = "https://www.google.com/apis/ads/publisher/v201511", className = "com.google.api.ads.dfp.jaxws.v201511.PackageServiceInterfacegetPackagesByStatement")
    @ResponseWrapper(localName = "getPackagesByStatementResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201511", className = "com.google.api.ads.dfp.jaxws.v201511.PackageServiceInterfacegetPackagesByStatementResponse")
    public PackagePage getPackagesByStatement(
        @WebParam(name = "filterStatement", targetNamespace = "https://www.google.com/apis/ads/publisher/v201511")
        Statement filterStatement)
        throws ApiException_Exception
    ;

    /**
     * 
     *         Performs actions on {@link Package} objects that match the given {@link Statement}.
     *         
     *         @param packageAction the action to perform
     *         @param filterStatement a Publisher Query Language statement used to filter a set of packages
     *         @return the result of the action performed
     *       
     * 
     * @param filterStatement
     * @param packageAction
     * @return
     *     returns com.google.api.ads.dfp.jaxws.v201511.UpdateResult
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201511")
    @RequestWrapper(localName = "performPackageAction", targetNamespace = "https://www.google.com/apis/ads/publisher/v201511", className = "com.google.api.ads.dfp.jaxws.v201511.PackageServiceInterfaceperformPackageAction")
    @ResponseWrapper(localName = "performPackageActionResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201511", className = "com.google.api.ads.dfp.jaxws.v201511.PackageServiceInterfaceperformPackageActionResponse")
    public UpdateResult performPackageAction(
        @WebParam(name = "packageAction", targetNamespace = "https://www.google.com/apis/ads/publisher/v201511")
        PackageAction packageAction,
        @WebParam(name = "filterStatement", targetNamespace = "https://www.google.com/apis/ads/publisher/v201511")
        Statement filterStatement)
        throws ApiException_Exception
    ;

    /**
     * 
     *         Updates the specified {@link Package} objects.
     *         
     *         @param packages the packages to update
     *         @return the updated packages
     *       
     * 
     * @param packages
     * @return
     *     returns java.util.List<com.google.api.ads.dfp.jaxws.v201511.Package>
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201511")
    @RequestWrapper(localName = "updatePackages", targetNamespace = "https://www.google.com/apis/ads/publisher/v201511", className = "com.google.api.ads.dfp.jaxws.v201511.PackageServiceInterfaceupdatePackages")
    @ResponseWrapper(localName = "updatePackagesResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201511", className = "com.google.api.ads.dfp.jaxws.v201511.PackageServiceInterfaceupdatePackagesResponse")
    public List<Package> updatePackages(
        @WebParam(name = "packages", targetNamespace = "https://www.google.com/apis/ads/publisher/v201511")
        List<Package> packages)
        throws ApiException_Exception
    ;

}
