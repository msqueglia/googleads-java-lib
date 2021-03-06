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

package admanager.axis.v201905.proposalservice;

import static com.google.api.ads.common.lib.utils.Builder.DEFAULT_CONFIGURATION_FILENAME;

import com.beust.jcommander.Parameter;
import com.google.api.ads.admanager.axis.factory.AdManagerServices;
import com.google.api.ads.admanager.axis.v201905.ApiError;
import com.google.api.ads.admanager.axis.v201905.ApiException;
import com.google.api.ads.admanager.axis.v201905.Money;
import com.google.api.ads.admanager.axis.v201905.NetworkServiceInterface;
import com.google.api.ads.admanager.axis.v201905.Proposal;
import com.google.api.ads.admanager.axis.v201905.ProposalCompanyAssociation;
import com.google.api.ads.admanager.axis.v201905.ProposalCompanyAssociationType;
import com.google.api.ads.admanager.axis.v201905.ProposalMarketplaceInfo;
import com.google.api.ads.admanager.axis.v201905.ProposalServiceInterface;
import com.google.api.ads.admanager.axis.v201905.SalespersonSplit;
import com.google.api.ads.admanager.lib.client.AdManagerSession;
import com.google.api.ads.admanager.lib.utils.examples.ArgumentNames;
import com.google.api.ads.common.lib.auth.OfflineCredentials;
import com.google.api.ads.common.lib.auth.OfflineCredentials.Api;
import com.google.api.ads.common.lib.conf.ConfigurationLoadException;
import com.google.api.ads.common.lib.exception.OAuthException;
import com.google.api.ads.common.lib.exception.ValidationException;
import com.google.api.ads.common.lib.utils.examples.CodeSampleParams;
import com.google.api.client.auth.oauth2.Credential;
import java.rmi.RemoteException;
import java.util.Random;

/**
 * This example creates a programmatic proposal. Your network must have sales management enabled to
 * run this example.
 *
 * <p>Credentials and properties in {@code fromFile()} are pulled from the "ads.properties" file.
 * See README for more info.
 */
public class CreateProgrammaticProposals {

  private static class CreateProgrammaticProposalsParams extends CodeSampleParams {
    @Parameter(
        names = ArgumentNames.ADVERTISER_ID,
        required = true,
        description = "The ID of the advertiser that the proposal will belong to.")
    private Long advertiserId;

    @Parameter(
        names = ArgumentNames.BUYER_ID,
        required = true,
        description =
            "The ID of the buyer. This can be obtained through the Programmatic_Buyer"
                + " PQL table.")
    private Long buyerId;

    @Parameter(
        names = ArgumentNames.PRIMARY_SALESPERSON_ID,
        required = true,
        description = "The ID of the primary salesperson.")
    private Long primarySalespersonId;

    @Parameter(
        names = ArgumentNames.PRIMARY_TRAFFICKER_ID,
        required = true,
        description = "The ID of the primary trafficker.")
    private Long primaryTraffickerId;
  }

  /**
   * Runs the example.
   *
   * @param adManagerServices the services factory.
   * @param session the session.
   * @param advertiserId the ID of the advertiser that the proposal will belong to.
   * @param buyerId the ID of the buyer. This can be obtained through the Programmatic_Buyer PQL
   *     table.
   * @param primarySalespersonId the ID of the primary salesperson.
   * @param primaryTraffickerId the ID of the primary trafficker.
   * @throws ApiException if the API request failed with one or more service errors.
   * @throws RemoteException if the API request failed due to other errors.
   */
  public static void runExample(
      AdManagerServices adManagerServices,
      AdManagerSession session,
      long advertiserId,
      long buyerId,
      long primarySalespersonId,
      long primaryTraffickerId)
      throws RemoteException {
    // Get the ProposalService.
    ProposalServiceInterface proposalService =
        adManagerServices.get(session, ProposalServiceInterface.class);

    // Get the NetworkService.
    NetworkServiceInterface networkService =
        adManagerServices.get(session, NetworkServiceInterface.class);

    // Create a proposal.
    Proposal proposal = new Proposal();
    proposal.setName("Programmatic proposal #" + new Random().nextInt(Integer.MAX_VALUE));

    // Set the required Marketplace information.
    ProposalMarketplaceInfo marketplaceInfo = new ProposalMarketplaceInfo();
    marketplaceInfo.setBuyerAccountId(buyerId);
    proposal.setMarketplaceInfo(marketplaceInfo);
    proposal.setIsProgrammatic(true);

    // Create a proposal company association.
    ProposalCompanyAssociation proposalCompanyAssociation = new ProposalCompanyAssociation();
    proposalCompanyAssociation.setCompanyId(advertiserId);
    proposalCompanyAssociation.setType(ProposalCompanyAssociationType.ADVERTISER);
    proposal.setAdvertiser(proposalCompanyAssociation);

    // Create salesperson split for the primary salesperson.
    SalespersonSplit primarySalesperson = new SalespersonSplit();
    primarySalesperson.setSplit(100000);
    primarySalesperson.setUserId(primarySalespersonId);
    proposal.setPrimarySalesperson(primarySalesperson);

    // Set the trafficker.
    proposal.setPrimaryTraffickerId(primaryTraffickerId);

    // Set the probability to close to 100%.
    proposal.setProbabilityOfClose(100000L);

    // Create a budget for the proposal worth 100 in the network local currency.
    Money budget = new Money();
    budget.setMicroAmount(100000000L);
    budget.setCurrencyCode(networkService.getCurrentNetwork().getCurrencyCode());
    proposal.setBudget(budget);

    // Create the proposal on the server.
    Proposal[] proposals = proposalService.createProposals(new Proposal[] {proposal});

    for (Proposal createdProposal : proposals) {
      System.out.printf(
          "A programmatic proposal with ID %d and name '%s' was created.%n",
          createdProposal.getId(), createdProposal.getName());
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

    CreateProgrammaticProposalsParams params = new CreateProgrammaticProposalsParams();
    if (!params.parseArguments(args)) {
      // Either pass the required parameters for this example on the command line, or insert them
      // into the code here. See the parameter class definition above for descriptions.
      params.advertiserId = Long.parseLong("INSERT_ADVERTISER_ID_HERE");
      params.buyerId = Long.parseLong("INSERT_BUYER_ID_HERE");
      params.primarySalespersonId = Long.parseLong("INSERT_PRIMARY_SALESPERSON_ID_HERE");
      params.primaryTraffickerId = Long.parseLong("INSERT_PRIMARY_TRAFFICKER_ID_HERE");
    }

    try {
      runExample(
          adManagerServices,
          session,
          params.advertiserId,
          params.buyerId,
          params.primarySalespersonId,
          params.primaryTraffickerId);
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
