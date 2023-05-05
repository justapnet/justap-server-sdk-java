# RoyaltyServiceApi

All URIs are relative to *http://127.0.0.1:21011*

Method | HTTP request | Description
------------- | ------------- | -------------
[**royaltyServiceCreateRoyalty**](RoyaltyServiceApi.md#royaltyServiceCreateRoyalty) | **POST** /v1/royalties | 创建 Royalty 对象


<a name="royaltyServiceCreateRoyalty"></a>
# **royaltyServiceCreateRoyalty**
> V1RoyaltyResponse royaltyServiceCreateRoyalty(body)

创建 Royalty 对象

### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.RoyaltyServiceApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

RoyaltyServiceApi apiInstance = new RoyaltyServiceApi();
V1CreateRoyaltyRequest body = new V1CreateRoyaltyRequest(); // V1CreateRoyaltyRequest | 
try {
    V1RoyaltyResponse result = apiInstance.royaltyServiceCreateRoyalty(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RoyaltyServiceApi#royaltyServiceCreateRoyalty");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V1CreateRoyaltyRequest**](V1CreateRoyaltyRequest.md)|  |

### Return type

[**V1RoyaltyResponse**](V1RoyaltyResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

