# justap-server-sdk-java

Justap API
- API version: 1.0
  - Build date: 2024-09-04T00:13:14.840Z

For more information, please visit [https://www.justap.cn/docs](https://www.justap.cn/docs)

## Requirements

Building the API client library requires:
1. Java 1.8+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>justap-server-sdk-java</groupId>
  <artifactId>justap-server-sdk-java</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "justap-server-sdk-java:justap-server-sdk-java:1.0.0"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/justap-server-sdk-java-1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import justap.*;
import justap.auth.*;
import io.swagger.client.model.*;
import justap_sdk.DefaultApi;

import java.io.File;
import java.util.*;

public class DefaultApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        
        // Configure API key authorization: ApiKeyAuth
        ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
        ApiKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKeyAuth.setApiKeyPrefix("Token");

        DefaultApi apiInstance = new DefaultApi();
        V1CreateUserRequest body = new V1CreateUserRequest(); // V1CreateUserRequest | 
        try {
            V1UserResponse result = apiInstance.businessUserServiceCreateUser(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#businessUserServiceCreateUser");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://127.0.0.1:21011*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**businessUserServiceCreateUser**](docs/DefaultApi.md#businessUserServiceCreateUser) | **POST** /v1/business_users | 创建 Business User 对象
*DefaultApi* | [**businessUserServiceDeleteUser**](docs/DefaultApi.md#businessUserServiceDeleteUser) | **DELETE** /v1/business_users/{id} | 删除 Business User 对象
*DefaultApi* | [**businessUserServiceListAllUsers**](docs/DefaultApi.md#businessUserServiceListAllUsers) | **GET** /v1/business_users | 查询 Business User 对象列表
*DefaultApi* | [**businessUserServiceRetrieveUser**](docs/DefaultApi.md#businessUserServiceRetrieveUser) | **GET** /v1/business_users/{id} | 查询 Business User 对象
*DefaultApi* | [**businessUserServiceSearchUsers**](docs/DefaultApi.md#businessUserServiceSearchUsers) | **GET** /v1/business_users/search | 查询 Business User 对象列表
*DefaultApi* | [**businessUserServiceUpdateUser**](docs/DefaultApi.md#businessUserServiceUpdateUser) | **PUT** /v1/business_users/{user.id} | 更新 Business User 对象
*DefaultApi* | [**businessUserServiceUpdateUser2**](docs/DefaultApi.md#businessUserServiceUpdateUser2) | **PATCH** /v1/business_users/{user.id} | 更新 Business User 对象
*DefaultApi* | [**chargeServiceCharges**](docs/DefaultApi.md#chargeServiceCharges) | **POST** /transaction/v1/charges | 创建 Charge 对象
*DefaultApi* | [**chargeServiceCharges2**](docs/DefaultApi.md#chargeServiceCharges2) | **POST** /v1/charges | 创建 Charge 对象
*DefaultApi* | [**chargeServiceQueryCharge**](docs/DefaultApi.md#chargeServiceQueryCharge) | **GET** /transaction/v1/charges/{charge_id} | 查询 Charge 对象
*DefaultApi* | [**chargeServiceQueryCharge2**](docs/DefaultApi.md#chargeServiceQueryCharge2) | **GET** /v1/charges/{charge_id} | 查询 Charge 对象
*DefaultApi* | [**chargeServiceQueryCharge3**](docs/DefaultApi.md#chargeServiceQueryCharge3) | **GET** /v1/charges/merchant_trade_id/{merchant_trade_id} | 查询 Charge 对象
*DefaultApi* | [**chargeServiceQueryChargeList**](docs/DefaultApi.md#chargeServiceQueryChargeList) | **GET** /transaction/v1/charges | 查询 Charge 对象列表
*DefaultApi* | [**chargeServiceQueryChargeList2**](docs/DefaultApi.md#chargeServiceQueryChargeList2) | **GET** /v1/charges | 查询 Charge 对象列表
*DefaultApi* | [**chargeServiceReverseCharge**](docs/DefaultApi.md#chargeServiceReverseCharge) | **POST** /transaction/v1/charges/{charge_id}/reverse | 撤销 Charge 对象
*DefaultApi* | [**chargeServiceReverseCharge2**](docs/DefaultApi.md#chargeServiceReverseCharge2) | **POST** /v1/charges/{charge_id}/reverse | 撤销 Charge 对象
*DefaultApi* | [**refundServiceQueryRefund**](docs/DefaultApi.md#refundServiceQueryRefund) | **GET** /transaction/v1/charges/{charge_id}/refunds/{refund_id} | 查询 Refund 对象
*DefaultApi* | [**refundServiceQueryRefund2**](docs/DefaultApi.md#refundServiceQueryRefund2) | **GET** /v1/refunds/{refund_id} | 查询 Refund 对象
*DefaultApi* | [**refundServiceQueryRefundList**](docs/DefaultApi.md#refundServiceQueryRefundList) | **GET** /transaction/v1/charges/{charge_id}/refunds | 查询 Refund 对象列表
*DefaultApi* | [**refundServiceQueryRefundList2**](docs/DefaultApi.md#refundServiceQueryRefundList2) | **GET** /v1/refunds | 查询 Refund 对象列表
*DefaultApi* | [**refundServiceRefunds**](docs/DefaultApi.md#refundServiceRefunds) | **POST** /transaction/v1/refunds | 创建 Refund 对象
*DefaultApi* | [**refundServiceRefunds2**](docs/DefaultApi.md#refundServiceRefunds2) | **POST** /v1/refunds | 创建 Refund 对象
*DefaultApi* | [**royaltyServiceCreateRoyalty**](docs/DefaultApi.md#royaltyServiceCreateRoyalty) | **POST** /v1/royalties | 创建 Royalty 对象
*DefaultApi* | [**royaltyServiceListAllRoyalties**](docs/DefaultApi.md#royaltyServiceListAllRoyalties) | **GET** /v1/royalties | 查询 Royalty 对象列表
*DefaultApi* | [**royaltyServiceRetrieveRoyalty**](docs/DefaultApi.md#royaltyServiceRetrieveRoyalty) | **GET** /v1/royalties/{id} | 查询 Royalty 对象
*DefaultApi* | [**settlementServiceCreateSettlementAccount**](docs/DefaultApi.md#settlementServiceCreateSettlementAccount) | **POST** /v1/settlement_accounts | 创建结算账户
*DefaultApi* | [**settlementServiceDeleteSettlementAccount**](docs/DefaultApi.md#settlementServiceDeleteSettlementAccount) | **DELETE** /v1/settlement_accounts/{id} | 删除结算账户
*DefaultApi* | [**settlementServiceListAllSettlementAccounts**](docs/DefaultApi.md#settlementServiceListAllSettlementAccounts) | **GET** /v1/settlement_accounts | 查询结算账户列表
*DefaultApi* | [**settlementServiceRetrieveSettlementAccount**](docs/DefaultApi.md#settlementServiceRetrieveSettlementAccount) | **GET** /v1/settlement_accounts/{id} | 查询结算账户
*DefaultApi* | [**settlementServiceSearchSettlementAccounts**](docs/DefaultApi.md#settlementServiceSearchSettlementAccounts) | **GET** /v1/settlement_accounts/search | 查询结算账户列表
*DefaultApi* | [**settlementServiceUpdateSettlementAccount**](docs/DefaultApi.md#settlementServiceUpdateSettlementAccount) | **PUT** /v1/settlement_accounts/{settlementAccount.id} | 更新结算账户
*DefaultApi* | [**settlementServiceUpdateSettlementAccount2**](docs/DefaultApi.md#settlementServiceUpdateSettlementAccount2) | **PATCH** /v1/settlement_accounts/{settlementAccount.id} | 更新结算账户
*CheckoutServiceApi* | [**checkoutServiceCreateUnionQrCheckout**](docs/CheckoutServiceApi.md#checkoutServiceCreateUnionQrCheckout) | **POST** /v1/checkout/union_qr | 通过聚合收款码创建订单
*CustomerServiceApi* | [**customerServiceCreateCustomer**](docs/CustomerServiceApi.md#customerServiceCreateCustomer) | **POST** /v1/customers | 
*CustomerServiceApi* | [**customerServiceDeleteCustomer**](docs/CustomerServiceApi.md#customerServiceDeleteCustomer) | **DELETE** /v1/customers/{id} | 
*CustomerServiceApi* | [**customerServiceListAllCustomers**](docs/CustomerServiceApi.md#customerServiceListAllCustomers) | **GET** /v1/customers | 
*CustomerServiceApi* | [**customerServiceRetrieveCustomer**](docs/CustomerServiceApi.md#customerServiceRetrieveCustomer) | **GET** /v1/customers/{id} | 
*CustomerServiceApi* | [**customerServiceSearchCustomers**](docs/CustomerServiceApi.md#customerServiceSearchCustomers) | **GET** /v1/customers/search | 
*CustomerServiceApi* | [**customerServiceUpdateCustomer**](docs/CustomerServiceApi.md#customerServiceUpdateCustomer) | **POST** /v1/customers/{id} | 


## Documentation for Models

 - [ChargeRoutingRequestChargeMethod](docs/ChargeRoutingRequestChargeMethod.md)
 - [CreateRoyaltyRequestRoyaltyMode](docs/CreateRoyaltyRequestRoyaltyMode.md)
 - [CreateRoyaltyRequestRoyaltyReceiver](docs/CreateRoyaltyRequestRoyaltyReceiver.md)
 - [ExtraAlipayInvoiceInfoKeyInfo](docs/ExtraAlipayInvoiceInfoKeyInfo.md)
 - [ExtraAlipayJSAPIPayer](docs/ExtraAlipayJSAPIPayer.md)
 - [ExtraAlipayPageAlipayDirectPayForm](docs/ExtraAlipayPageAlipayDirectPayForm.md)
 - [ExtraAlipaySettleInfoSettleDetailInfos](docs/ExtraAlipaySettleInfoSettleDetailInfos.md)
 - [ExtraUnionPayCardlessQuickPayCardType](docs/ExtraUnionPayCardlessQuickPayCardType.md)
 - [ExtraWechatpayDetailGoodsDetail](docs/ExtraWechatpayDetailGoodsDetail.md)
 - [ExtraWechatpaySceneInfoH5Info](docs/ExtraWechatpaySceneInfoH5Info.md)
 - [ExtraWechatpaySceneInfoStoreInfo](docs/ExtraWechatpaySceneInfoStoreInfo.md)
 - [GooglerpcStatus](docs/GooglerpcStatus.md)
 - [OpenApiRoyaltyDetailInfoPojoTradeFundBillItem](docs/OpenApiRoyaltyDetailInfoPojoTradeFundBillItem.md)
 - [ProtobufAny](docs/ProtobufAny.md)
 - [RefundExtraAlipayOpenApiRoyaltyDetailInfoPojo](docs/RefundExtraAlipayOpenApiRoyaltyDetailInfoPojo.md)
 - [RefundExtraWechatPayAccount](docs/RefundExtraWechatPayAccount.md)
 - [RefundExtraWechatPayGoodsDetailItem](docs/RefundExtraWechatPayGoodsDetailItem.md)
 - [RefundRoutingRequestRefundMethod](docs/RefundRoutingRequestRefundMethod.md)
 - [RoyaltyReceiverRoyaltyFeeMode](docs/RoyaltyReceiverRoyaltyFeeMode.md)
 - [RoyaltySettlementRoyaltySettlementStatus](docs/RoyaltySettlementRoyaltySettlementStatus.md)
 - [RoyaltySettlementTransactionRoyaltyTransactionStatus](docs/RoyaltySettlementTransactionRoyaltyTransactionStatus.md)
 - [SettlementAccountRecipientAccountType](docs/SettlementAccountRecipientAccountType.md)
 - [SettlementAccountRecipientAlipayChannelRecipient](docs/SettlementAccountRecipientAlipayChannelRecipient.md)
 - [SettlementAccountRecipientBalanceChannelRecipient](docs/SettlementAccountRecipientBalanceChannelRecipient.md)
 - [SettlementAccountRecipientBankChannelRecipient](docs/SettlementAccountRecipientBankChannelRecipient.md)
 - [SettlementAccountRecipientRecipientType](docs/SettlementAccountRecipientRecipientType.md)
 - [SettlementAccountRecipientWechatpayChannelRecipient](docs/SettlementAccountRecipientWechatpayChannelRecipient.md)
 - [SettlementAccountRecipientYsepayMerchantRecipient](docs/SettlementAccountRecipientYsepayMerchantRecipient.md)
 - [Tradev1Channel](docs/Tradev1Channel.md)
 - [Tradev1RoyaltyMethod](docs/Tradev1RoyaltyMethod.md)
 - [V1AcquirerCloseTransactionResponse](docs/V1AcquirerCloseTransactionResponse.md)
 - [V1AcquirerCreateRefundResponse](docs/V1AcquirerCreateRefundResponse.md)
 - [V1AcquirerCreateRoyaltyResponse](docs/V1AcquirerCreateRoyaltyResponse.md)
 - [V1AcquirerCreateTransactionResponse](docs/V1AcquirerCreateTransactionResponse.md)
 - [V1AcquirerPaymentNotifyResponse](docs/V1AcquirerPaymentNotifyResponse.md)
 - [V1AcquirerQueryRefundResponse](docs/V1AcquirerQueryRefundResponse.md)
 - [V1AcquirerQueryRoyaltyResponse](docs/V1AcquirerQueryRoyaltyResponse.md)
 - [V1AcquirerQueryTransactionResponse](docs/V1AcquirerQueryTransactionResponse.md)
 - [V1AcquirerRefundNotifyResponse](docs/V1AcquirerRefundNotifyResponse.md)
 - [V1AcquirerRoyaltyNotifyResponse](docs/V1AcquirerRoyaltyNotifyResponse.md)
 - [V1AlipayCallbackResponse](docs/V1AlipayCallbackResponse.md)
 - [V1AlipayNotifyResponse](docs/V1AlipayNotifyResponse.md)
 - [V1BusinessUser](docs/V1BusinessUser.md)
 - [V1CallbackRoutingResponse](docs/V1CallbackRoutingResponse.md)
 - [V1Charge](docs/V1Charge.md)
 - [V1ChargeExtra](docs/V1ChargeExtra.md)
 - [V1ChargeListResponse](docs/V1ChargeListResponse.md)
 - [V1ChargeResponse](docs/V1ChargeResponse.md)
 - [V1ChargeRoutingResponse](docs/V1ChargeRoutingResponse.md)
 - [V1CreateChargeRequest](docs/V1CreateChargeRequest.md)
 - [V1CreateChargeRequestExtra](docs/V1CreateChargeRequestExtra.md)
 - [V1CreateCustomerRequest](docs/V1CreateCustomerRequest.md)
 - [V1CreateRefundRequest](docs/V1CreateRefundRequest.md)
 - [V1CreateRoyaltyRequest](docs/V1CreateRoyaltyRequest.md)
 - [V1CreateSettlementAccountRequest](docs/V1CreateSettlementAccountRequest.md)
 - [V1CreateUserRequest](docs/V1CreateUserRequest.md)
 - [V1Customer](docs/V1Customer.md)
 - [V1CustomerListResponse](docs/V1CustomerListResponse.md)
 - [V1CustomerResponse](docs/V1CustomerResponse.md)
 - [V1DeleteCustomerResponse](docs/V1DeleteCustomerResponse.md)
 - [V1DeleteProductResponse](docs/V1DeleteProductResponse.md)
 - [V1DeleteSettlementAccountResponse](docs/V1DeleteSettlementAccountResponse.md)
 - [V1DeleteUserResponse](docs/V1DeleteUserResponse.md)
 - [V1ExtraAlipayApp](docs/V1ExtraAlipayApp.md)
 - [V1ExtraAlipayBusinessParams](docs/V1ExtraAlipayBusinessParams.md)
 - [V1ExtraAlipayExtUserInfo](docs/V1ExtraAlipayExtUserInfo.md)
 - [V1ExtraAlipayExtendParams](docs/V1ExtraAlipayExtendParams.md)
 - [V1ExtraAlipayFace](docs/V1ExtraAlipayFace.md)
 - [V1ExtraAlipayFundBillList](docs/V1ExtraAlipayFundBillList.md)
 - [V1ExtraAlipayGoodsDetail](docs/V1ExtraAlipayGoodsDetail.md)
 - [V1ExtraAlipayInvoiceInfo](docs/V1ExtraAlipayInvoiceInfo.md)
 - [V1ExtraAlipayJSAPI](docs/V1ExtraAlipayJSAPI.md)
 - [V1ExtraAlipayLite](docs/V1ExtraAlipayLite.md)
 - [V1ExtraAlipayLogisticsDetail](docs/V1ExtraAlipayLogisticsDetail.md)
 - [V1ExtraAlipayPage](docs/V1ExtraAlipayPage.md)
 - [V1ExtraAlipayPayParams](docs/V1ExtraAlipayPayParams.md)
 - [V1ExtraAlipayQr](docs/V1ExtraAlipayQr.md)
 - [V1ExtraAlipayReceiverAddressInfo](docs/V1ExtraAlipayReceiverAddressInfo.md)
 - [V1ExtraAlipayScan](docs/V1ExtraAlipayScan.md)
 - [V1ExtraAlipaySettleInfo](docs/V1ExtraAlipaySettleInfo.md)
 - [V1ExtraAlipaySubMerchant](docs/V1ExtraAlipaySubMerchant.md)
 - [V1ExtraAlipayVoucherDetailList](docs/V1ExtraAlipayVoucherDetailList.md)
 - [V1ExtraAlipayWap](docs/V1ExtraAlipayWap.md)
 - [V1ExtraUnionPayCardlessQuickPay](docs/V1ExtraUnionPayCardlessQuickPay.md)
 - [V1ExtraWechatpayApp](docs/V1ExtraWechatpayApp.md)
 - [V1ExtraWechatpayAppConfig](docs/V1ExtraWechatpayAppConfig.md)
 - [V1ExtraWechatpayAppletConfig](docs/V1ExtraWechatpayAppletConfig.md)
 - [V1ExtraWechatpayDetail](docs/V1ExtraWechatpayDetail.md)
 - [V1ExtraWechatpayH5](docs/V1ExtraWechatpayH5.md)
 - [V1ExtraWechatpayJsapi](docs/V1ExtraWechatpayJsapi.md)
 - [V1ExtraWechatpayJsapiConfig](docs/V1ExtraWechatpayJsapiConfig.md)
 - [V1ExtraWechatpayLite](docs/V1ExtraWechatpayLite.md)
 - [V1ExtraWechatpayNative](docs/V1ExtraWechatpayNative.md)
 - [V1ExtraWechatpayPayer](docs/V1ExtraWechatpayPayer.md)
 - [V1ExtraWechatpayScan](docs/V1ExtraWechatpayScan.md)
 - [V1ExtraWechatpaySceneInfo](docs/V1ExtraWechatpaySceneInfo.md)
 - [V1ExtraWechatpaySettleInfo](docs/V1ExtraWechatpaySettleInfo.md)
 - [V1FinishRoyaltyResponse](docs/V1FinishRoyaltyResponse.md)
 - [V1Gender](docs/V1Gender.md)
 - [V1ListAllCustomersRequestCreated](docs/V1ListAllCustomersRequestCreated.md)
 - [V1ListAllRoyaltiesRequestCreated](docs/V1ListAllRoyaltiesRequestCreated.md)
 - [V1ListAllRoyaltiesResponse](docs/V1ListAllRoyaltiesResponse.md)
 - [V1ListAllSettlementAccountsRequestCreated](docs/V1ListAllSettlementAccountsRequestCreated.md)
 - [V1ListAllUsersRequestCreated](docs/V1ListAllUsersRequestCreated.md)
 - [V1NotifyRoutingResponse](docs/V1NotifyRoutingResponse.md)
 - [V1ProductListResponse](docs/V1ProductListResponse.md)
 - [V1ProductResponse](docs/V1ProductResponse.md)
 - [V1QueryChargeListRequestCreated](docs/V1QueryChargeListRequestCreated.md)
 - [V1Refund](docs/V1Refund.md)
 - [V1RefundExtra](docs/V1RefundExtra.md)
 - [V1RefundExtraAlipay](docs/V1RefundExtraAlipay.md)
 - [V1RefundExtraWechatPay](docs/V1RefundExtraWechatPay.md)
 - [V1RefundListResponse](docs/V1RefundListResponse.md)
 - [V1RefundResponse](docs/V1RefundResponse.md)
 - [V1RefundRoutingResponse](docs/V1RefundRoutingResponse.md)
 - [V1Royalty](docs/V1Royalty.md)
 - [V1RoyaltyResponse](docs/V1RoyaltyResponse.md)
 - [V1RoyaltyRoutingRequestRoyaltyMethod](docs/V1RoyaltyRoutingRequestRoyaltyMethod.md)
 - [V1RoyaltyRoutingResponse](docs/V1RoyaltyRoutingResponse.md)
 - [V1RoyaltySettlement](docs/V1RoyaltySettlement.md)
 - [V1RoyaltySettlementListResponse](docs/V1RoyaltySettlementListResponse.md)
 - [V1RoyaltySettlementResponse](docs/V1RoyaltySettlementResponse.md)
 - [V1RoyaltySettlementSource](docs/V1RoyaltySettlementSource.md)
 - [V1RoyaltySettlementSourceType](docs/V1RoyaltySettlementSourceType.md)
 - [V1RoyaltySettlementTransaction](docs/V1RoyaltySettlementTransaction.md)
 - [V1RoyaltySettlementTransactionListResponse](docs/V1RoyaltySettlementTransactionListResponse.md)
 - [V1RoyaltySettlementTransactionResponse](docs/V1RoyaltySettlementTransactionResponse.md)
 - [V1RoyaltyStatus](docs/V1RoyaltyStatus.md)
 - [V1SearchCustomersRequestCreated](docs/V1SearchCustomersRequestCreated.md)
 - [V1SearchRoyaltiesResponse](docs/V1SearchRoyaltiesResponse.md)
 - [V1SearchUsersRequestCreated](docs/V1SearchUsersRequestCreated.md)
 - [V1ServiceError](docs/V1ServiceError.md)
 - [V1SettlementAccount](docs/V1SettlementAccount.md)
 - [V1SettlementAccountChannel](docs/V1SettlementAccountChannel.md)
 - [V1SettlementAccountListResponse](docs/V1SettlementAccountListResponse.md)
 - [V1SettlementAccountRecipient](docs/V1SettlementAccountRecipient.md)
 - [V1SettlementAccountResponse](docs/V1SettlementAccountResponse.md)
 - [V1TransferRoutingResponse](docs/V1TransferRoutingResponse.md)
 - [V1UnionQrRequest](docs/V1UnionQrRequest.md)
 - [V1UpdateAndPatchRequestBody](docs/V1UpdateAndPatchRequestBody.md)
 - [V1User](docs/V1User.md)
 - [V1UserListResponse](docs/V1UserListResponse.md)
 - [V1UserResponse](docs/V1UserResponse.md)
 - [V1WechatpayCallbackResponse](docs/V1WechatpayCallbackResponse.md)
 - [V1WechatpayNotifyResponse](docs/V1WechatpayNotifyResponse.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### ApiKeyAuth

- **Type**: API key
- **API key parameter name**: X-JUSTAP-API-KEY
- **Location**: HTTP header


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

support@justap.net

