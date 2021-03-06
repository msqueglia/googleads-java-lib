// Copyright 2016 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package admanager.axis.v201902.producttemplateservice;

import static com.google.api.ads.common.lib.utils.Builder.DEFAULT_CONFIGURATION_FILENAME;

import com.google.api.ads.admanager.axis.factory.AdManagerServices;
import com.google.api.ads.admanager.axis.v201902.AdExchangeEnvironment;
import com.google.api.ads.admanager.axis.v201902.AdUnitTargeting;
import com.google.api.ads.admanager.axis.v201902.ApiError;
import com.google.api.ads.admanager.axis.v201902.ApiException;
import com.google.api.ads.admanager.axis.v201902.CreativePlaceholder;
import com.google.api.ads.admanager.axis.v201902.GeoTargeting;
import com.google.api.ads.admanager.axis.v201902.LineItemType;
import com.google.api.ads.admanager.axis.v201902.Location;
import com.google.api.ads.admanager.axis.v201902.NetworkServiceInterface;
import com.google.api.ads.admanager.axis.v201902.ProductSegmentation;
import com.google.api.ads.admanager.axis.v201902.ProductTemplate;
import com.google.api.ads.admanager.axis.v201902.ProductTemplateMarketplaceInfo;
import com.google.api.ads.admanager.axis.v201902.ProductTemplateServiceInterface;
import com.google.api.ads.admanager.axis.v201902.ProductType;
import com.google.api.ads.admanager.axis.v201902.RateType;
import com.google.api.ads.admanager.axis.v201902.Size;
import com.google.api.ads.admanager.lib.client.AdManagerSession;
import com.google.api.ads.common.lib.auth.OfflineCredentials;
import com.google.api.ads.common.lib.auth.OfflineCredentials.Api;
import com.google.api.ads.common.lib.conf.ConfigurationLoadException;
import com.google.api.ads.common.lib.exception.OAuthException;
import com.google.api.ads.common.lib.exception.ValidationException;
import com.google.api.client.auth.oauth2.Credential;
import java.rmi.RemoteException;
import java.util.Random;

/**
 * This example creates a programmatic product template. Your network must have sales management
 * enabled to run this example.
 *
 * <p>To publish the created product template to Marketplace, you must create a
 * ProductTemplateBaseRate with a Marketplace rate card.
 *
 * <p>Credentials and properties in {@code fromFile()} are pulled from the "ads.properties" file.
 * See README for more info.
 */
public class CreateProgrammaticProductTemplates {

  /**
   * Runs the example.
   *
   * @param adManagerServices the services factory.
   * @param session the session.
   * @throws ApiException if the API request failed with one or more service errors.
   * @throws RemoteException if the API request failed due to other errors.
   */
  public static void runExample(AdManagerServices adManagerServices, AdManagerSession session)
      throws RemoteException {
    ProductTemplateServiceInterface productTemplateService =
        adManagerServices.get(session, ProductTemplateServiceInterface.class);

    NetworkServiceInterface networkService =
        adManagerServices.get(session, NetworkServiceInterface.class);

    // Create a programmatic product template.
    ProductTemplate productTemplate = new ProductTemplate();
    productTemplate.setName(
        "Programmatic product template #" + new Random().nextInt(Integer.MAX_VALUE));
    productTemplate.setDescription(
        "This product template creates programmatic proposal line items "
            + "targeting all ad units with product segmentation on geo targeting.");

    // Set the name macro which will be used to generate the names of the products.
    // This will create a segmentation based on the line item type, ad unit, and location.
    productTemplate.setNameMacro("<line-item-type> - <ad-unit> - <template-name> - <location>");

    // Set the product type so the created proposal line items will be trafficked in Ad Manager.
    productTemplate.setProductType(ProductType.DFP);

    // Set required Marketplace information.
    ProductTemplateMarketplaceInfo marketplaceInfo = new ProductTemplateMarketplaceInfo();
    marketplaceInfo.setAdExchangeEnvironment(AdExchangeEnvironment.DISPLAY);
    productTemplate.setProductTemplateMarketplaceInfo(marketplaceInfo);

    productTemplate.setRateType(RateType.CPM);

    CreativePlaceholder creativePlaceholder = new CreativePlaceholder();
    creativePlaceholder.setSize(new Size(300, 250, false));

    // Set the size of creatives that can be associated with the product template.
    productTemplate.setCreativePlaceholders(new CreativePlaceholder[] {creativePlaceholder});

    // Set the type of proposal line item to be created from the product template.
    productTemplate.setLineItemType(LineItemType.STANDARD);

    // Get the root ad unit ID used to target the whole site.
    String rootAdUnitId = networkService.getCurrentNetwork().getEffectiveRootAdUnitId();

    // Create ad unit targeting for the root ad unit (i.e. the whole network).
    AdUnitTargeting adUnitTargeting = new AdUnitTargeting();
    adUnitTargeting.setAdUnitId(rootAdUnitId);
    adUnitTargeting.setIncludeDescendants(true);

    // Create geo targeting for the US.
    Location countryLocation = new Location();
    countryLocation.setId(2840L);

    // Create geo targeting for Hong Kong.
    Location regionLocation = new Location();
    regionLocation.setId(2344L);

    GeoTargeting geoTargeting = new GeoTargeting();
    geoTargeting.setTargetedLocations(new Location[] {countryLocation, regionLocation});

    // Add targeting as product segmentation.
    ProductSegmentation productSegmentation = new ProductSegmentation();
    productSegmentation.setAdUnitSegments(new AdUnitTargeting[] {adUnitTargeting});
    productSegmentation.setGeoSegment(geoTargeting);

    productTemplate.setProductSegmentation(productSegmentation);

    // Create the product template on the server.
    ProductTemplate[] productTemplates =
        productTemplateService.createProductTemplates(new ProductTemplate[] {productTemplate});

    for (ProductTemplate createdProductTemplate : productTemplates) {
      System.out.printf(
          "A programmatic product template with ID %d and name '%s' was created.%n",
          createdProductTemplate.getId(), createdProductTemplate.getName());
    }
  }

  public static void main(String[] args) {
    AdManagerSession session;
    try {
      // Generate a refreshable OAuth2 credential.
      Credential oAuth2Credential =
          new OfflineCredentials.Builder()
              .forApi(Api.AD_MANAGER)
              .fromFile()
              .build()
              .generateCredential();

      // Construct a AdManagerSession.
      session =
          new AdManagerSession.Builder().fromFile().withOAuth2Credential(oAuth2Credential).build();
    } catch (ConfigurationLoadException cle) {
      System.err.printf(
          "Failed to load configuration from the %s file. Exception: %s%n",
          DEFAULT_CONFIGURATION_FILENAME, cle);
      return;
    } catch (ValidationException ve) {
      System.err.printf(
          "Invalid configuration in the %s file. Exception: %s%n",
          DEFAULT_CONFIGURATION_FILENAME, ve);
      return;
    } catch (OAuthException oe) {
      System.err.printf(
          "Failed to create OAuth credentials. Check OAuth settings in the %s file. "
              + "Exception: %s%n",
          DEFAULT_CONFIGURATION_FILENAME, oe);
      return;
    }

    AdManagerServices adManagerServices = new AdManagerServices();

    try {
      runExample(adManagerServices, session);
    } catch (ApiException apiException) {
      // ApiException is the base class for most exceptions thrown by an API request. Instances
      // of this exception have a message and a collection of ApiErrors that indicate the
      // type and underlying cause of the exception. Every exception object in the admanager.axis
      // packages will return a meaningful value from toString
      //
      // ApiException extends RemoteException, so this catch block must appear before the
      // catch block for RemoteException.
      System.err.println("Request failed due to ApiException. Underlying ApiErrors:");
      if (apiException.getErrors() != null) {
        int i = 0;
        for (ApiError apiError : apiException.getErrors()) {
          System.err.printf("  Error %d: %s%n", i++, apiError);
        }
      }
    } catch (RemoteException re) {
      System.err.printf("Request failed unexpectedly due to RemoteException: %s%n", re);
    }
  }
}
