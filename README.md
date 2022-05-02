# justap-server-sdk-java

Justap API
- API version: 1.0
  - Build date: 2022-05-02T15:38:56.099Z

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
        V1CreateChargeRequest body = new V1CreateChargeRequest(); // V1CreateChargeRequest | 
        try {
            V1ChargeResponse result = apiInstance.tradeServiceCharges(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#tradeServiceCharges");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://127.0.0.1:21011*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**tradeServiceCharges**](docs/DefaultApi.md#tradeServiceCharges) | **POST** /transaction/v1/charges | 创建 Charge 对象
*DefaultApi* | [**tradeServiceQueryCharge**](docs/DefaultApi.md#tradeServiceQueryCharge) | **GET** /transaction/v1/charges/{charge_id} | 查询 Charge 对象
*DefaultApi* | [**tradeServiceQueryChargeList**](docs/DefaultApi.md#tradeServiceQueryChargeList) | **GET** /transaction/v1/charges | 查询 Charge 对象列表
*DefaultApi* | [**tradeServiceQueryRefund**](docs/DefaultApi.md#tradeServiceQueryRefund) | **GET** /transaction/v1/charges/{charge_id}/refunds/{refund_id} | 查询 Refund 对象
*DefaultApi* | [**tradeServiceQueryRefundList**](docs/DefaultApi.md#tradeServiceQueryRefundList) | **GET** /transaction/v1/charges/{charge_id}/refunds | 查询 Refund 对象列表
*DefaultApi* | [**tradeServiceRefunds**](docs/DefaultApi.md#tradeServiceRefunds) | **POST** /transaction/v1/refunds | 创建 Refund 对象
*DefaultApi* | [**tradeServiceReverseCharge**](docs/DefaultApi.md#tradeServiceReverseCharge) | **POST** /transaction/v1/charges/{charge_id}/reverse | 撤销 Charge 对象


## Documentation for Models

 - [ExtraAlipayAgreementSignParamsAccessParams](docs/ExtraAlipayAgreementSignParamsAccessParams.md)
 - [ExtraAlipayAgreementSignParamsPeriodRuleParams](docs/ExtraAlipayAgreementSignParamsPeriodRuleParams.md)
 - [ExtraAlipayAgreementSignParamsSubMerchant](docs/ExtraAlipayAgreementSignParamsSubMerchant.md)
 - [ExtraAlipayInvoiceInfoKeyInfo](docs/ExtraAlipayInvoiceInfoKeyInfo.md)
 - [ExtraAlipayRoyaltyInfoRoyaltyDetailInfos](docs/ExtraAlipayRoyaltyInfoRoyaltyDetailInfos.md)
 - [ExtraAlipaySettleInfoSettleDetailInfos](docs/ExtraAlipaySettleInfoSettleDetailInfos.md)
 - [ExtraWechatpayDetailGoodsDetail](docs/ExtraWechatpayDetailGoodsDetail.md)
 - [ExtraWechatpaySceneInfoStoreInfo](docs/ExtraWechatpaySceneInfoStoreInfo.md)
 - [HealthCheckResponseServingStatus](docs/HealthCheckResponseServingStatus.md)
 - [OpenApiRoyaltyDetailInfoPojoTradeFundBillItem](docs/OpenApiRoyaltyDetailInfoPojoTradeFundBillItem.md)
 - [ProtobufAny](docs/ProtobufAny.md)
 - [QueryChargeListRequestCreated](docs/QueryChargeListRequestCreated.md)
 - [RefundExtraAlipayOpenApiRoyaltyDetailInfoPojo](docs/RefundExtraAlipayOpenApiRoyaltyDetailInfoPojo.md)
 - [RefundExtraWechatPayAccount](docs/RefundExtraWechatPayAccount.md)
 - [RefundExtraWechatPayGoodsDetailItem](docs/RefundExtraWechatPayGoodsDetailItem.md)
 - [RpcStatus](docs/RpcStatus.md)
 - [V1AlipayCallbackResponse](docs/V1AlipayCallbackResponse.md)
 - [V1AlipayNotifyResponse](docs/V1AlipayNotifyResponse.md)
 - [V1Channel](docs/V1Channel.md)
 - [V1Charge](docs/V1Charge.md)
 - [V1ChargeExtra](docs/V1ChargeExtra.md)
 - [V1ChargeListResponse](docs/V1ChargeListResponse.md)
 - [V1ChargeResponse](docs/V1ChargeResponse.md)
 - [V1CreateChargeRequest](docs/V1CreateChargeRequest.md)
 - [V1CreateChargeRequestExtra](docs/V1CreateChargeRequestExtra.md)
 - [V1CreateRefundRequest](docs/V1CreateRefundRequest.md)
 - [V1ExtraAlipayAgreementParams](docs/V1ExtraAlipayAgreementParams.md)
 - [V1ExtraAlipayAgreementSignParams](docs/V1ExtraAlipayAgreementSignParams.md)
 - [V1ExtraAlipayApp](docs/V1ExtraAlipayApp.md)
 - [V1ExtraAlipayBusinessParams](docs/V1ExtraAlipayBusinessParams.md)
 - [V1ExtraAlipayExtUserInfo](docs/V1ExtraAlipayExtUserInfo.md)
 - [V1ExtraAlipayExtendParams](docs/V1ExtraAlipayExtendParams.md)
 - [V1ExtraAlipayFace](docs/V1ExtraAlipayFace.md)
 - [V1ExtraAlipayFundBillList](docs/V1ExtraAlipayFundBillList.md)
 - [V1ExtraAlipayGoodsDetail](docs/V1ExtraAlipayGoodsDetail.md)
 - [V1ExtraAlipayInvoiceInfo](docs/V1ExtraAlipayInvoiceInfo.md)
 - [V1ExtraAlipayLite](docs/V1ExtraAlipayLite.md)
 - [V1ExtraAlipayLogisticsDetail](docs/V1ExtraAlipayLogisticsDetail.md)
 - [V1ExtraAlipayPage](docs/V1ExtraAlipayPage.md)
 - [V1ExtraAlipayPayParams](docs/V1ExtraAlipayPayParams.md)
 - [V1ExtraAlipayQr](docs/V1ExtraAlipayQr.md)
 - [V1ExtraAlipayReceiverAddressInfo](docs/V1ExtraAlipayReceiverAddressInfo.md)
 - [V1ExtraAlipayRoyaltyInfo](docs/V1ExtraAlipayRoyaltyInfo.md)
 - [V1ExtraAlipayScan](docs/V1ExtraAlipayScan.md)
 - [V1ExtraAlipaySettleInfo](docs/V1ExtraAlipaySettleInfo.md)
 - [V1ExtraAlipaySubMerchant](docs/V1ExtraAlipaySubMerchant.md)
 - [V1ExtraAlipayVoucherDetailList](docs/V1ExtraAlipayVoucherDetailList.md)
 - [V1ExtraAlipayWap](docs/V1ExtraAlipayWap.md)
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
 - [V1HealthCheckResponse](docs/V1HealthCheckResponse.md)
 - [V1Refund](docs/V1Refund.md)
 - [V1RefundExtra](docs/V1RefundExtra.md)
 - [V1RefundExtraAlipay](docs/V1RefundExtraAlipay.md)
 - [V1RefundExtraWechatPay](docs/V1RefundExtraWechatPay.md)
 - [V1RefundListResponse](docs/V1RefundListResponse.md)
 - [V1RefundResponse](docs/V1RefundResponse.md)
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

