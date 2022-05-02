# DefaultApi

All URIs are relative to *http://127.0.0.1:21011*

Method | HTTP request | Description
------------- | ------------- | -------------
[**tradeServiceCharges**](DefaultApi.md#tradeServiceCharges) | **POST** /transaction/v1/charges | 创建 Charge 对象
[**tradeServiceQueryCharge**](DefaultApi.md#tradeServiceQueryCharge) | **GET** /transaction/v1/charges/{charge_id} | 查询 Charge 对象
[**tradeServiceQueryChargeList**](DefaultApi.md#tradeServiceQueryChargeList) | **GET** /transaction/v1/charges | 查询 Charge 对象列表
[**tradeServiceQueryRefund**](DefaultApi.md#tradeServiceQueryRefund) | **GET** /transaction/v1/charges/{charge_id}/refunds/{refund_id} | 查询 Refund 对象
[**tradeServiceQueryRefundList**](DefaultApi.md#tradeServiceQueryRefundList) | **GET** /transaction/v1/charges/{charge_id}/refunds | 查询 Refund 对象列表
[**tradeServiceRefunds**](DefaultApi.md#tradeServiceRefunds) | **POST** /transaction/v1/refunds | 创建 Refund 对象
[**tradeServiceReverseCharge**](DefaultApi.md#tradeServiceReverseCharge) | **POST** /transaction/v1/charges/{charge_id}/reverse | 撤销 Charge 对象


<a name="tradeServiceCharges"></a>
# **tradeServiceCharges**
> V1ChargeResponse tradeServiceCharges(body)

创建 Charge 对象

发起一次支付请求时需要创建一个新的 charge 对象，获取一个可用的支付凭据用于客户端向第三方渠道发起支付请求。如果使用测试模式的 API Key，则不会发生真实交易。当支付成功后，会发送 Webhooks 通知。

### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.DefaultApi;

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
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V1CreateChargeRequest**](V1CreateChargeRequest.md)|  |

### Return type

[**V1ChargeResponse**](V1ChargeResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="tradeServiceQueryCharge"></a>
# **tradeServiceQueryCharge**
> V1ChargeResponse tradeServiceQueryCharge(chargeId, appId)

查询 Charge 对象

你可以在后台异步通知之前，通过查询接口确认支付状态。通过charge对象的id查询一个已创建的charge对象。

### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String chargeId = "chargeId_example"; // String | [REQUIRED] Charge 对象 id
String appId = "appId_example"; // String | [REQUIRED] 应用 id
try {
    V1ChargeResponse result = apiInstance.tradeServiceQueryCharge(chargeId, appId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#tradeServiceQueryCharge");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **chargeId** | **String**| [REQUIRED] Charge 对象 id |
 **appId** | **String**| [REQUIRED] 应用 id | [optional]

### Return type

[**V1ChargeResponse**](V1ChargeResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="tradeServiceQueryChargeList"></a>
# **tradeServiceQueryChargeList**
> V1ChargeListResponse tradeServiceQueryChargeList(appId, limit, startingAfter, endingBefore, merchantTradeId, createdLt, createdLte, createdGt, createdGte, channel, paid, refunded, reversed, closed, expired)

查询 Charge 对象列表

返回之前创建过 charge 对象的一个列表。列表是按创建时间进行排序，总是将最新的 charge 对象显示在最前。如果不设置 created 参数，默认查询近一个月的数据；设置了 created 参数，会按照对应的时间段查询。

### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String appId = "appId_example"; // String | [REQUIRED] 应用 id
Integer limit = 10; // Integer | [OPTIONAL] 限制有多少对象可以被返回，限制范围是从 1~100 项，默认是 10 项
String startingAfter = "startingAfter_example"; // String | [OPTIONAL] 在分页时使用的指针，决定了列表的第一项从何处开始。假设你的一次请求返回列表的最后一项的 id 是 obj_end，你可以使用 starting_after = obj_end 去获取下一页
String endingBefore = "endingBefore_example"; // String | [OPTIONAL] 在分页时使用的指针，决定了列表的最末项在何处结束。假设你的一次请求返回列表的第一项的 id 是 obj_start，你可以使用 ending_before = obj_start 去获取上一页
String merchantTradeId = "merchantTradeId_example"; // String | [OPTIONAL] 客户系统订单号
Long createdLt = 0L; // Long | 大于 charge 对象的创建时间，用 Unix 时间戳表示
Long createdLte = 0L; // Long | 大于或等于 charge 对象的创建时间，用 Unix 时间戳表示
Long createdGt = 0L; // Long | 小于 charge 对象的创建时间，用 Unix 时间戳表示
Long createdGte = 0L; // Long | 小于或等于 charge 对象的创建时间，用 Unix 时间戳表示
String channel = "CHANNEL_INVALID_UNSPECIFIED"; // String | [OPTIONAL] 渠道名称   - BALANCE: 余额  - AlipayQR: 支付宝扫码支付  - AlipayScan: 支付宝条码支付  - AlipayApp: 支付宝 App 支付  - AlipayWap: 支付宝手机网站支付  - AlipayPage: 支付宝电脑网站支付  - AlipayFace: 支付宝刷脸支付  - AlipayLite: 支付宝小程序支付  - WechatpayApp: 微信 App 支付  - WechatpayJSAPI: 微信 JSAPI 支付  - WechatpayH5: 微信 H5 支付  - WechatpayNative: 微信 Native 支付  - WechatpayLite: 微信小程序支付  - WechatpayFace: 刷脸支付  - WechatpayScan: 微信付款码支付
Boolean paid = false; // Boolean | [OPTIONAL] 是否已付款
Boolean refunded = false; // Boolean | [OPTIONAL] 是否存在退款信息，无论退款是否成功。
Boolean reversed = false; // Boolean | [OPTIONAL] 是否已撤销
Boolean closed = false; // Boolean | [OPTIONAL] 是否已关闭
Boolean expired = false; // Boolean | [OPTIONAL] 是否已过期
try {
    V1ChargeListResponse result = apiInstance.tradeServiceQueryChargeList(appId, limit, startingAfter, endingBefore, merchantTradeId, createdLt, createdLte, createdGt, createdGte, channel, paid, refunded, reversed, closed, expired);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#tradeServiceQueryChargeList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appId** | **String**| [REQUIRED] 应用 id | [optional]
 **limit** | **Integer**| [OPTIONAL] 限制有多少对象可以被返回，限制范围是从 1~100 项，默认是 10 项 | [optional] [default to 10]
 **startingAfter** | **String**| [OPTIONAL] 在分页时使用的指针，决定了列表的第一项从何处开始。假设你的一次请求返回列表的最后一项的 id 是 obj_end，你可以使用 starting_after &#x3D; obj_end 去获取下一页 | [optional]
 **endingBefore** | **String**| [OPTIONAL] 在分页时使用的指针，决定了列表的最末项在何处结束。假设你的一次请求返回列表的第一项的 id 是 obj_start，你可以使用 ending_before &#x3D; obj_start 去获取上一页 | [optional]
 **merchantTradeId** | **String**| [OPTIONAL] 客户系统订单号 | [optional]
 **createdLt** | **Long**| 大于 charge 对象的创建时间，用 Unix 时间戳表示 | [optional] [default to 0]
 **createdLte** | **Long**| 大于或等于 charge 对象的创建时间，用 Unix 时间戳表示 | [optional] [default to 0]
 **createdGt** | **Long**| 小于 charge 对象的创建时间，用 Unix 时间戳表示 | [optional] [default to 0]
 **createdGte** | **Long**| 小于或等于 charge 对象的创建时间，用 Unix 时间戳表示 | [optional] [default to 0]
 **channel** | **String**| [OPTIONAL] 渠道名称   - BALANCE: 余额  - AlipayQR: 支付宝扫码支付  - AlipayScan: 支付宝条码支付  - AlipayApp: 支付宝 App 支付  - AlipayWap: 支付宝手机网站支付  - AlipayPage: 支付宝电脑网站支付  - AlipayFace: 支付宝刷脸支付  - AlipayLite: 支付宝小程序支付  - WechatpayApp: 微信 App 支付  - WechatpayJSAPI: 微信 JSAPI 支付  - WechatpayH5: 微信 H5 支付  - WechatpayNative: 微信 Native 支付  - WechatpayLite: 微信小程序支付  - WechatpayFace: 刷脸支付  - WechatpayScan: 微信付款码支付 | [optional] [default to CHANNEL_INVALID_UNSPECIFIED] [enum: CHANNEL_INVALID_UNSPECIFIED, BALANCE, AlipayQR, AlipayScan, AlipayApp, AlipayWap, AlipayPage, AlipayFace, AlipayLite, WechatpayApp, WechatpayJSAPI, WechatpayH5, WechatpayNative, WechatpayLite, WechatpayFace, WechatpayScan]
 **paid** | **Boolean**| [OPTIONAL] 是否已付款 | [optional] [default to false]
 **refunded** | **Boolean**| [OPTIONAL] 是否存在退款信息，无论退款是否成功。 | [optional] [default to false]
 **reversed** | **Boolean**| [OPTIONAL] 是否已撤销 | [optional] [default to false]
 **closed** | **Boolean**| [OPTIONAL] 是否已关闭 | [optional] [default to false]
 **expired** | **Boolean**| [OPTIONAL] 是否已过期 | [optional] [default to false]

### Return type

[**V1ChargeListResponse**](V1ChargeListResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="tradeServiceQueryRefund"></a>
# **tradeServiceQueryRefund**
> V1RefundResponse tradeServiceQueryRefund(chargeId, refundId, appId)

查询 Refund 对象

可以通过 charge 对象的查询接口查询某一个 charge 对象的退款列表，也可以通过 refund 对象的 id 查询一个已创建的 refund 对象。可以在 Webhooks 通知之前，通过查询接口确认退款状态。

### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String chargeId = "chargeId_example"; // String | [REQUIRED] 支付 Charge Id
String refundId = "refundId_example"; // String | [REQUIRED] Refund 对象 id
String appId = "appId_example"; // String | [REQUIRED] 应用 id
try {
    V1RefundResponse result = apiInstance.tradeServiceQueryRefund(chargeId, refundId, appId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#tradeServiceQueryRefund");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **chargeId** | **String**| [REQUIRED] 支付 Charge Id |
 **refundId** | **String**| [REQUIRED] Refund 对象 id |
 **appId** | **String**| [REQUIRED] 应用 id | [optional]

### Return type

[**V1RefundResponse**](V1RefundResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="tradeServiceQueryRefundList"></a>
# **tradeServiceQueryRefundList**
> V1RefundListResponse tradeServiceQueryRefundList(chargeId, appId, limit, startingAfter, endingBefore)

查询 Refund 对象列表

返回之前创建 charge 对象的一个 refund 对象列表。列表是按创建时间进行排序，总是将最新的 refund 对象显示在最前。

### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String chargeId = "chargeId_example"; // String | [REQUIRED] 支付 Charge Id
String appId = "appId_example"; // String | [REQUIRED] 应用 id
Integer limit = 10; // Integer | [OPTIONAL] 限制有多少对象可以被返回，限制范围是从 1~100 项，默认是 10 项
String startingAfter = "startingAfter_example"; // String | [OPTIONAL] 在分页时使用的指针，决定了列表的第一项从何处开始。假设你的一次请求返回列表的最后一项的 id 是 obj_end，你可以使用 starting_after = obj_end 去获取下一页
String endingBefore = "endingBefore_example"; // String | [OPTIONAL] 在分页时使用的指针，决定了列表的最末项在何处结束。假设你的一次请求返回列表的第一项的 id 是 obj_start，你可以使用 ending_before = obj_start 去获取上一页
try {
    V1RefundListResponse result = apiInstance.tradeServiceQueryRefundList(chargeId, appId, limit, startingAfter, endingBefore);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#tradeServiceQueryRefundList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **chargeId** | **String**| [REQUIRED] 支付 Charge Id |
 **appId** | **String**| [REQUIRED] 应用 id | [optional]
 **limit** | **Integer**| [OPTIONAL] 限制有多少对象可以被返回，限制范围是从 1~100 项，默认是 10 项 | [optional] [default to 10]
 **startingAfter** | **String**| [OPTIONAL] 在分页时使用的指针，决定了列表的第一项从何处开始。假设你的一次请求返回列表的最后一项的 id 是 obj_end，你可以使用 starting_after &#x3D; obj_end 去获取下一页 | [optional]
 **endingBefore** | **String**| [OPTIONAL] 在分页时使用的指针，决定了列表的最末项在何处结束。假设你的一次请求返回列表的第一项的 id 是 obj_start，你可以使用 ending_before &#x3D; obj_start 去获取上一页 | [optional]

### Return type

[**V1RefundListResponse**](V1RefundListResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="tradeServiceRefunds"></a>
# **tradeServiceRefunds**
> V1RefundResponse tradeServiceRefunds(body)

创建 Refund 对象

通过发起一次退款请求创建一个新的 refund 对象，只能对已经发生交易并且没有全额退款的 charge 对象发起退款。当进行全额退款之前，可以进行多次退款，直至全额退款。当一次退款成功后，会发送 Webhooks 通知。

### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
V1CreateRefundRequest body = new V1CreateRefundRequest(); // V1CreateRefundRequest | 
try {
    V1RefundResponse result = apiInstance.tradeServiceRefunds(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#tradeServiceRefunds");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V1CreateRefundRequest**](V1CreateRefundRequest.md)|  |

### Return type

[**V1RefundResponse**](V1RefundResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="tradeServiceReverseCharge"></a>
# **tradeServiceReverseCharge**
> V1ChargeResponse tradeServiceReverseCharge(chargeId, appId)

撤销 Charge 对象

针对已经创建的 Charge，你可以调用撤销接口进行交易的关闭。接口支持对于未成功付款的订单进行撤销，则关闭交易。调用此接口后用户后期不能支付成功。  注：撤销订单在不同收单机构会有不同的行为。对于成功付款的订单请使用 退款 接口进行退款处理。只有针对未支付的订单，我们建议你调用撤销接口。  - 微信支付：如果此订单用户支付失败，微信支付系统会将此订单关闭；如果用户支付成功，微信支付系统会将此订单资金退还给用户。(7天以内的交易单可调用撤销) - 支付宝：如果此订单用户支付失败，支付宝系统会将此订单关闭；如果用户支付成功，支付宝系统会将此订单资金退还给用户。

### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String chargeId = "chargeId_example"; // String | Charge 对象 id
String appId = "appId_example"; // String | [REQUIRED] 应用 id
try {
    V1ChargeResponse result = apiInstance.tradeServiceReverseCharge(chargeId, appId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#tradeServiceReverseCharge");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **chargeId** | **String**| Charge 对象 id |
 **appId** | **String**| [REQUIRED] 应用 id | [optional]

### Return type

[**V1ChargeResponse**](V1ChargeResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

