# CheckoutServiceApi

All URIs are relative to *http://127.0.0.1:21011*

Method | HTTP request | Description
------------- | ------------- | -------------
[**checkoutServiceCreateUnionQrCheckout**](CheckoutServiceApi.md#checkoutServiceCreateUnionQrCheckout) | **POST** /v1/checkout/union_qr | 通过聚合收款码创建订单


<a name="checkoutServiceCreateUnionQrCheckout"></a>
# **checkoutServiceCreateUnionQrCheckout**
> V1UnionQrRequest checkoutServiceCreateUnionQrCheckout(body)

通过聚合收款码创建订单

### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.CheckoutServiceApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

CheckoutServiceApi apiInstance = new CheckoutServiceApi();
V1UnionQrRequest body = new V1UnionQrRequest(); // V1UnionQrRequest | 
try {
    V1UnionQrRequest result = apiInstance.checkoutServiceCreateUnionQrCheckout(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CheckoutServiceApi#checkoutServiceCreateUnionQrCheckout");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V1UnionQrRequest**](V1UnionQrRequest.md)|  |

### Return type

[**V1UnionQrRequest**](V1UnionQrRequest.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

