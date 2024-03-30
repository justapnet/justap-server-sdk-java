# DefaultApi

All URIs are relative to *http://127.0.0.1:21011*

Method | HTTP request | Description
------------- | ------------- | -------------
[**businessUserServiceCreateUser**](DefaultApi.md#businessUserServiceCreateUser) | **POST** /v1/business_users | 创建 Business User 对象
[**businessUserServiceDeleteUser**](DefaultApi.md#businessUserServiceDeleteUser) | **DELETE** /v1/business_users/{id} | 删除 Business User 对象
[**businessUserServiceListAllUsers**](DefaultApi.md#businessUserServiceListAllUsers) | **GET** /v1/business_users | 查询 Business User 对象列表
[**businessUserServiceRetrieveUser**](DefaultApi.md#businessUserServiceRetrieveUser) | **GET** /v1/business_users/{id} | 查询 Business User 对象
[**businessUserServiceSearchUsers**](DefaultApi.md#businessUserServiceSearchUsers) | **GET** /v1/business_users/search | 查询 Business User 对象列表
[**businessUserServiceUpdateUser**](DefaultApi.md#businessUserServiceUpdateUser) | **PUT** /v1/business_users/{user.id} | 更新 Business User 对象
[**businessUserServiceUpdateUser2**](DefaultApi.md#businessUserServiceUpdateUser2) | **PATCH** /v1/business_users/{user.id} | 更新 Business User 对象
[**chargeServiceCharges**](DefaultApi.md#chargeServiceCharges) | **POST** /transaction/v1/charges | 创建 Charge 对象
[**chargeServiceCharges2**](DefaultApi.md#chargeServiceCharges2) | **POST** /v1/charges | 创建 Charge 对象
[**chargeServiceQueryCharge**](DefaultApi.md#chargeServiceQueryCharge) | **GET** /transaction/v1/charges/{charge_id} | 查询 Charge 对象
[**chargeServiceQueryCharge2**](DefaultApi.md#chargeServiceQueryCharge2) | **GET** /v1/charges/{charge_id} | 查询 Charge 对象
[**chargeServiceQueryCharge3**](DefaultApi.md#chargeServiceQueryCharge3) | **GET** /v1/charges/merchant_trade_id/{merchant_trade_id} | 查询 Charge 对象
[**chargeServiceQueryChargeList**](DefaultApi.md#chargeServiceQueryChargeList) | **GET** /transaction/v1/charges | 查询 Charge 对象列表
[**chargeServiceQueryChargeList2**](DefaultApi.md#chargeServiceQueryChargeList2) | **GET** /v1/charges | 查询 Charge 对象列表
[**chargeServiceReverseCharge**](DefaultApi.md#chargeServiceReverseCharge) | **POST** /transaction/v1/charges/{charge_id}/reverse | 撤销 Charge 对象
[**chargeServiceReverseCharge2**](DefaultApi.md#chargeServiceReverseCharge2) | **POST** /v1/charges/{charge_id}/reverse | 撤销 Charge 对象
[**refundServiceQueryRefund**](DefaultApi.md#refundServiceQueryRefund) | **GET** /transaction/v1/charges/{charge_id}/refunds/{refund_id} | 查询 Refund 对象
[**refundServiceQueryRefund2**](DefaultApi.md#refundServiceQueryRefund2) | **GET** /v1/refunds/{refund_id} | 查询 Refund 对象
[**refundServiceQueryRefundList**](DefaultApi.md#refundServiceQueryRefundList) | **GET** /transaction/v1/charges/{charge_id}/refunds | 查询 Refund 对象列表
[**refundServiceQueryRefundList2**](DefaultApi.md#refundServiceQueryRefundList2) | **GET** /v1/refunds | 查询 Refund 对象列表
[**refundServiceRefunds**](DefaultApi.md#refundServiceRefunds) | **POST** /transaction/v1/refunds | 创建 Refund 对象
[**refundServiceRefunds2**](DefaultApi.md#refundServiceRefunds2) | **POST** /v1/refunds | 创建 Refund 对象
[**royaltyServiceCreateRoyalty**](DefaultApi.md#royaltyServiceCreateRoyalty) | **POST** /v1/royalties | 创建 Royalty 对象
[**royaltyServiceListAllRoyalties**](DefaultApi.md#royaltyServiceListAllRoyalties) | **GET** /v1/royalties | 查询 Royalty 对象列表
[**royaltyServiceRetrieveRoyalty**](DefaultApi.md#royaltyServiceRetrieveRoyalty) | **GET** /v1/royalties/{id} | 查询 Royalty 对象
[**settlementServiceCreateSettlementAccount**](DefaultApi.md#settlementServiceCreateSettlementAccount) | **POST** /v1/settlement_accounts | 创建结算账户
[**settlementServiceDeleteSettlementAccount**](DefaultApi.md#settlementServiceDeleteSettlementAccount) | **DELETE** /v1/settlement_accounts/{id} | 删除结算账户
[**settlementServiceListAllSettlementAccounts**](DefaultApi.md#settlementServiceListAllSettlementAccounts) | **GET** /v1/settlement_accounts | 查询结算账户列表
[**settlementServiceRetrieveSettlementAccount**](DefaultApi.md#settlementServiceRetrieveSettlementAccount) | **GET** /v1/settlement_accounts/{id} | 查询结算账户
[**settlementServiceSearchSettlementAccounts**](DefaultApi.md#settlementServiceSearchSettlementAccounts) | **GET** /v1/settlement_accounts/search | 查询结算账户列表
[**settlementServiceUpdateSettlementAccount**](DefaultApi.md#settlementServiceUpdateSettlementAccount) | **PUT** /v1/settlement_accounts/{settlementAccount.id} | 更新结算账户
[**settlementServiceUpdateSettlementAccount2**](DefaultApi.md#settlementServiceUpdateSettlementAccount2) | **PATCH** /v1/settlement_accounts/{settlementAccount.id} | 更新结算账户


<a name="businessUserServiceCreateUser"></a>
# **businessUserServiceCreateUser**
> V1UserResponse businessUserServiceCreateUser(body)

创建 Business User 对象

创建 Business User 对象。商业用户是本系统中的一种账户类型，在交易完成之后可以对该类型的账户进行分账等操作。

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
V1CreateUserRequest body = new V1CreateUserRequest(); // V1CreateUserRequest | 
try {
    V1UserResponse result = apiInstance.businessUserServiceCreateUser(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#businessUserServiceCreateUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V1CreateUserRequest**](V1CreateUserRequest.md)|  |

### Return type

[**V1UserResponse**](V1UserResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="businessUserServiceDeleteUser"></a>
# **businessUserServiceDeleteUser**
> V1DeleteUserResponse businessUserServiceDeleteUser(id, appId)

删除 Business User 对象

删除 Business User 对象

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
String id = "id_example"; // String | 
String appId = "appId_example"; // String | 
try {
    V1DeleteUserResponse result = apiInstance.businessUserServiceDeleteUser(id, appId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#businessUserServiceDeleteUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **appId** | **String**|  | [optional]

### Return type

[**V1DeleteUserResponse**](V1DeleteUserResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="businessUserServiceListAllUsers"></a>
# **businessUserServiceListAllUsers**
> V1UserListResponse businessUserServiceListAllUsers(appId, limit, startingAfter, endingBefore, createdLt, createdLte, createdGt, createdGte, disabled)

查询 Business User 对象列表

查询 Business User 对象列表

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
String appId = "appId_example"; // String | 
Integer limit = 10; // Integer | [OPTIONAL] 限制有多少对象可以被返回，限制范围是从 1~100 项，默认是 10 项
String startingAfter = "startingAfter_example"; // String | [OPTIONAL] 在分页时使用的指针，决定了列表的第一项从何处开始。假设你的一次请求返回列表的最后一项的 id 是 obj_end，你可以使用 starting_after = obj_end 去获取下一页
String endingBefore = "endingBefore_example"; // String | [OPTIONAL] 在分页时使用的指针，决定了列表的最末项在何处结束。假设你的一次请求返回列表的第一项的 id 是 obj_start，你可以使用 ending_before = obj_start 去获取上一页
Long createdLt = 0L; // Long | 大于 charge 对象的创建时间，用 Unix 时间戳表示
Long createdLte = 0L; // Long | 大于或等于 charge 对象的创建时间，用 Unix 时间戳表示
Long createdGt = 0L; // Long | 小于 charge 对象的创建时间，用 Unix 时间戳表示
Long createdGte = 0L; // Long | 小于或等于 charge 对象的创建时间，用 Unix 时间戳表示
Boolean disabled = true; // Boolean | [OPTIONAL] 是否禁用，默认为 false
try {
    V1UserListResponse result = apiInstance.businessUserServiceListAllUsers(appId, limit, startingAfter, endingBefore, createdLt, createdLte, createdGt, createdGte, disabled);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#businessUserServiceListAllUsers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appId** | **String**|  | [optional]
 **limit** | **Integer**| [OPTIONAL] 限制有多少对象可以被返回，限制范围是从 1~100 项，默认是 10 项 | [optional] [default to 10]
 **startingAfter** | **String**| [OPTIONAL] 在分页时使用的指针，决定了列表的第一项从何处开始。假设你的一次请求返回列表的最后一项的 id 是 obj_end，你可以使用 starting_after &#x3D; obj_end 去获取下一页 | [optional]
 **endingBefore** | **String**| [OPTIONAL] 在分页时使用的指针，决定了列表的最末项在何处结束。假设你的一次请求返回列表的第一项的 id 是 obj_start，你可以使用 ending_before &#x3D; obj_start 去获取上一页 | [optional]
 **createdLt** | **Long**| 大于 charge 对象的创建时间，用 Unix 时间戳表示 | [optional] [default to 0]
 **createdLte** | **Long**| 大于或等于 charge 对象的创建时间，用 Unix 时间戳表示 | [optional] [default to 0]
 **createdGt** | **Long**| 小于 charge 对象的创建时间，用 Unix 时间戳表示 | [optional] [default to 0]
 **createdGte** | **Long**| 小于或等于 charge 对象的创建时间，用 Unix 时间戳表示 | [optional] [default to 0]
 **disabled** | **Boolean**| [OPTIONAL] 是否禁用，默认为 false | [optional]

### Return type

[**V1UserListResponse**](V1UserListResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="businessUserServiceRetrieveUser"></a>
# **businessUserServiceRetrieveUser**
> V1UserResponse businessUserServiceRetrieveUser(id, appId)

查询 Business User 对象

查询 Business User 对象

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
String id = "id_example"; // String | 
String appId = "appId_example"; // String | 
try {
    V1UserResponse result = apiInstance.businessUserServiceRetrieveUser(id, appId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#businessUserServiceRetrieveUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **appId** | **String**|  | [optional]

### Return type

[**V1UserResponse**](V1UserResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="businessUserServiceSearchUsers"></a>
# **businessUserServiceSearchUsers**
> V1UserListResponse businessUserServiceSearchUsers(appId, limit, createdLt, createdLte, createdGt, createdGte, email, name, phone)

查询 Business User 对象列表

查询 Business User 对象列表

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
String appId = "appId_example"; // String | 
Integer limit = 10; // Integer | [OPTIONAL] 限制有多少对象可以被返回，限制范围是从 1~100 项，默认是 10 项
Long createdLt = 0L; // Long | 大于 BusinessUser 对象的创建时间，用 Unix 时间戳表示
Long createdLte = 0L; // Long | 大于或等于 BusinessUser 对象的创建时间，用 Unix 时间戳表示
Long createdGt = 0L; // Long | 小于 BusinessUser 对象的创建时间，用 Unix 时间戳表示
Long createdGte = 0L; // Long | 小于或等于 BusinessUser 对象的创建时间，用 Unix 时间戳表示
String email = "email_example"; // String | [OPTIONAL] BusinessUser 对象的邮箱地址。支持模糊匹配
String name = "name_example"; // String | [OPTIONAL] BusinessUser 对象的用户名。支持模糊匹配
String phone = "phone_example"; // String | [OPTIONAL] BusinessUser 对象的手机号码
try {
    V1UserListResponse result = apiInstance.businessUserServiceSearchUsers(appId, limit, createdLt, createdLte, createdGt, createdGte, email, name, phone);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#businessUserServiceSearchUsers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appId** | **String**|  | [optional]
 **limit** | **Integer**| [OPTIONAL] 限制有多少对象可以被返回，限制范围是从 1~100 项，默认是 10 项 | [optional] [default to 10]
 **createdLt** | **Long**| 大于 BusinessUser 对象的创建时间，用 Unix 时间戳表示 | [optional] [default to 0]
 **createdLte** | **Long**| 大于或等于 BusinessUser 对象的创建时间，用 Unix 时间戳表示 | [optional] [default to 0]
 **createdGt** | **Long**| 小于 BusinessUser 对象的创建时间，用 Unix 时间戳表示 | [optional] [default to 0]
 **createdGte** | **Long**| 小于或等于 BusinessUser 对象的创建时间，用 Unix 时间戳表示 | [optional] [default to 0]
 **email** | **String**| [OPTIONAL] BusinessUser 对象的邮箱地址。支持模糊匹配 | [optional]
 **name** | **String**| [OPTIONAL] BusinessUser 对象的用户名。支持模糊匹配 | [optional]
 **phone** | **String**| [OPTIONAL] BusinessUser 对象的手机号码 | [optional]

### Return type

[**V1UserListResponse**](V1UserListResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="businessUserServiceUpdateUser"></a>
# **businessUserServiceUpdateUser**
> V1UserResponse businessUserServiceUpdateUser(userId, body, updateMask)

更新 Business User 对象

更新 Business User 对象

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
String userId = "userId_example"; // String | 
V1BusinessUser body = new V1BusinessUser(); // V1BusinessUser | 
String updateMask = "updateMask_example"; // String | 
try {
    V1UserResponse result = apiInstance.businessUserServiceUpdateUser(userId, body, updateMask);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#businessUserServiceUpdateUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**|  |
 **body** | [**V1BusinessUser**](V1BusinessUser.md)|  |
 **updateMask** | **String**|  | [optional]

### Return type

[**V1UserResponse**](V1UserResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="businessUserServiceUpdateUser2"></a>
# **businessUserServiceUpdateUser2**
> V1UserResponse businessUserServiceUpdateUser2(userId, body, updateMask)

更新 Business User 对象

更新 Business User 对象

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
String userId = "userId_example"; // String | 
V1BusinessUser body = new V1BusinessUser(); // V1BusinessUser | 
String updateMask = "updateMask_example"; // String | 
try {
    V1UserResponse result = apiInstance.businessUserServiceUpdateUser2(userId, body, updateMask);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#businessUserServiceUpdateUser2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**|  |
 **body** | [**V1BusinessUser**](V1BusinessUser.md)|  |
 **updateMask** | **String**|  | [optional]

### Return type

[**V1UserResponse**](V1UserResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="chargeServiceCharges"></a>
# **chargeServiceCharges**
> V1ChargeResponse chargeServiceCharges(body)

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
    V1ChargeResponse result = apiInstance.chargeServiceCharges(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#chargeServiceCharges");
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

<a name="chargeServiceCharges2"></a>
# **chargeServiceCharges2**
> V1ChargeResponse chargeServiceCharges2(body)

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
    V1ChargeResponse result = apiInstance.chargeServiceCharges2(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#chargeServiceCharges2");
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

<a name="chargeServiceQueryCharge"></a>
# **chargeServiceQueryCharge**
> V1ChargeResponse chargeServiceQueryCharge(chargeId, appId, merchantTradeId)

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
String merchantTradeId = "merchantTradeId_example"; // String | [OPTIONAL] 商户订单号
try {
    V1ChargeResponse result = apiInstance.chargeServiceQueryCharge(chargeId, appId, merchantTradeId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#chargeServiceQueryCharge");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **chargeId** | **String**| [REQUIRED] Charge 对象 id |
 **appId** | **String**| [REQUIRED] 应用 id | [optional]
 **merchantTradeId** | **String**| [OPTIONAL] 商户订单号 | [optional]

### Return type

[**V1ChargeResponse**](V1ChargeResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="chargeServiceQueryCharge2"></a>
# **chargeServiceQueryCharge2**
> V1ChargeResponse chargeServiceQueryCharge2(chargeId, appId, merchantTradeId)

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
String merchantTradeId = "merchantTradeId_example"; // String | [OPTIONAL] 商户订单号
try {
    V1ChargeResponse result = apiInstance.chargeServiceQueryCharge2(chargeId, appId, merchantTradeId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#chargeServiceQueryCharge2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **chargeId** | **String**| [REQUIRED] Charge 对象 id |
 **appId** | **String**| [REQUIRED] 应用 id | [optional]
 **merchantTradeId** | **String**| [OPTIONAL] 商户订单号 | [optional]

### Return type

[**V1ChargeResponse**](V1ChargeResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="chargeServiceQueryCharge3"></a>
# **chargeServiceQueryCharge3**
> V1ChargeResponse chargeServiceQueryCharge3(merchantTradeId, chargeId, appId)

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
String merchantTradeId = "merchantTradeId_example"; // String | [OPTIONAL] 商户订单号
String chargeId = "chargeId_example"; // String | [REQUIRED] Charge 对象 id
String appId = "appId_example"; // String | [REQUIRED] 应用 id
try {
    V1ChargeResponse result = apiInstance.chargeServiceQueryCharge3(merchantTradeId, chargeId, appId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#chargeServiceQueryCharge3");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **merchantTradeId** | **String**| [OPTIONAL] 商户订单号 |
 **chargeId** | **String**| [REQUIRED] Charge 对象 id | [optional]
 **appId** | **String**| [REQUIRED] 应用 id | [optional]

### Return type

[**V1ChargeResponse**](V1ChargeResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="chargeServiceQueryChargeList"></a>
# **chargeServiceQueryChargeList**
> V1ChargeListResponse chargeServiceQueryChargeList(appId, limit, startingAfter, endingBefore, merchantTradeId, createdLt, createdLte, createdGt, createdGte, channel, paid, refunded, reversed, closed, expired)

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
String channel = "CHANNEL_INVALID_UNSPECIFIED"; // String | [OPTIONAL] 渠道名称   - BALANCE: 余额支付  - AlipayQR: 支付宝扫码支付  - AlipayScan: 支付宝条码支付  - AlipayApp: 支付宝 App 支付  - AlipayWap: 支付宝手机网站支付  - AlipayPage: 支付宝电脑网站支付  - AlipayFace: 支付宝刷脸支付  - AlipayLite: 支付宝小程序支付  - AlipayJSAPI: 支付宝 JSAPI 支付  - WechatpayApp: 微信 App 支付  - WechatpayJSAPI: 微信 JSAPI 支付  - WechatpayH5: 微信 H5 支付  - WechatpayNative: 微信 Native 支付  - WechatpayLite: 微信小程序支付  - WechatpayFace: 刷脸支付  - WechatpayScan: 微信付款码支付  - UnionPayQr: 银联二维码支付（云闪付扫码）
Boolean paid = false; // Boolean | [OPTIONAL] 是否已付款
Boolean refunded = false; // Boolean | [OPTIONAL] 是否存在退款信息，无论退款是否成功。
Boolean reversed = false; // Boolean | [OPTIONAL] 是否已撤销
Boolean closed = false; // Boolean | [OPTIONAL] 是否已关闭
Boolean expired = false; // Boolean | [OPTIONAL] 是否已过期
try {
    V1ChargeListResponse result = apiInstance.chargeServiceQueryChargeList(appId, limit, startingAfter, endingBefore, merchantTradeId, createdLt, createdLte, createdGt, createdGte, channel, paid, refunded, reversed, closed, expired);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#chargeServiceQueryChargeList");
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
 **channel** | **String**| [OPTIONAL] 渠道名称   - BALANCE: 余额支付  - AlipayQR: 支付宝扫码支付  - AlipayScan: 支付宝条码支付  - AlipayApp: 支付宝 App 支付  - AlipayWap: 支付宝手机网站支付  - AlipayPage: 支付宝电脑网站支付  - AlipayFace: 支付宝刷脸支付  - AlipayLite: 支付宝小程序支付  - AlipayJSAPI: 支付宝 JSAPI 支付  - WechatpayApp: 微信 App 支付  - WechatpayJSAPI: 微信 JSAPI 支付  - WechatpayH5: 微信 H5 支付  - WechatpayNative: 微信 Native 支付  - WechatpayLite: 微信小程序支付  - WechatpayFace: 刷脸支付  - WechatpayScan: 微信付款码支付  - UnionPayQr: 银联二维码支付（云闪付扫码） | [optional] [default to CHANNEL_INVALID_UNSPECIFIED] [enum: CHANNEL_INVALID_UNSPECIFIED, BALANCE, AlipayQR, AlipayScan, AlipayApp, AlipayWap, AlipayPage, AlipayFace, AlipayLite, AlipayJSAPI, WechatpayApp, WechatpayJSAPI, WechatpayH5, WechatpayNative, WechatpayLite, WechatpayFace, WechatpayScan, UnionPayQr]
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

<a name="chargeServiceQueryChargeList2"></a>
# **chargeServiceQueryChargeList2**
> V1ChargeListResponse chargeServiceQueryChargeList2(appId, limit, startingAfter, endingBefore, merchantTradeId, createdLt, createdLte, createdGt, createdGte, channel, paid, refunded, reversed, closed, expired)

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
String channel = "CHANNEL_INVALID_UNSPECIFIED"; // String | [OPTIONAL] 渠道名称   - BALANCE: 余额支付  - AlipayQR: 支付宝扫码支付  - AlipayScan: 支付宝条码支付  - AlipayApp: 支付宝 App 支付  - AlipayWap: 支付宝手机网站支付  - AlipayPage: 支付宝电脑网站支付  - AlipayFace: 支付宝刷脸支付  - AlipayLite: 支付宝小程序支付  - AlipayJSAPI: 支付宝 JSAPI 支付  - WechatpayApp: 微信 App 支付  - WechatpayJSAPI: 微信 JSAPI 支付  - WechatpayH5: 微信 H5 支付  - WechatpayNative: 微信 Native 支付  - WechatpayLite: 微信小程序支付  - WechatpayFace: 刷脸支付  - WechatpayScan: 微信付款码支付  - UnionPayQr: 银联二维码支付（云闪付扫码）
Boolean paid = false; // Boolean | [OPTIONAL] 是否已付款
Boolean refunded = false; // Boolean | [OPTIONAL] 是否存在退款信息，无论退款是否成功。
Boolean reversed = false; // Boolean | [OPTIONAL] 是否已撤销
Boolean closed = false; // Boolean | [OPTIONAL] 是否已关闭
Boolean expired = false; // Boolean | [OPTIONAL] 是否已过期
try {
    V1ChargeListResponse result = apiInstance.chargeServiceQueryChargeList2(appId, limit, startingAfter, endingBefore, merchantTradeId, createdLt, createdLte, createdGt, createdGte, channel, paid, refunded, reversed, closed, expired);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#chargeServiceQueryChargeList2");
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
 **channel** | **String**| [OPTIONAL] 渠道名称   - BALANCE: 余额支付  - AlipayQR: 支付宝扫码支付  - AlipayScan: 支付宝条码支付  - AlipayApp: 支付宝 App 支付  - AlipayWap: 支付宝手机网站支付  - AlipayPage: 支付宝电脑网站支付  - AlipayFace: 支付宝刷脸支付  - AlipayLite: 支付宝小程序支付  - AlipayJSAPI: 支付宝 JSAPI 支付  - WechatpayApp: 微信 App 支付  - WechatpayJSAPI: 微信 JSAPI 支付  - WechatpayH5: 微信 H5 支付  - WechatpayNative: 微信 Native 支付  - WechatpayLite: 微信小程序支付  - WechatpayFace: 刷脸支付  - WechatpayScan: 微信付款码支付  - UnionPayQr: 银联二维码支付（云闪付扫码） | [optional] [default to CHANNEL_INVALID_UNSPECIFIED] [enum: CHANNEL_INVALID_UNSPECIFIED, BALANCE, AlipayQR, AlipayScan, AlipayApp, AlipayWap, AlipayPage, AlipayFace, AlipayLite, AlipayJSAPI, WechatpayApp, WechatpayJSAPI, WechatpayH5, WechatpayNative, WechatpayLite, WechatpayFace, WechatpayScan, UnionPayQr]
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

<a name="chargeServiceReverseCharge"></a>
# **chargeServiceReverseCharge**
> V1ChargeResponse chargeServiceReverseCharge(chargeId)

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
try {
    V1ChargeResponse result = apiInstance.chargeServiceReverseCharge(chargeId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#chargeServiceReverseCharge");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **chargeId** | **String**| Charge 对象 id |

### Return type

[**V1ChargeResponse**](V1ChargeResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="chargeServiceReverseCharge2"></a>
# **chargeServiceReverseCharge2**
> V1ChargeResponse chargeServiceReverseCharge2(chargeId)

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
try {
    V1ChargeResponse result = apiInstance.chargeServiceReverseCharge2(chargeId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#chargeServiceReverseCharge2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **chargeId** | **String**| Charge 对象 id |

### Return type

[**V1ChargeResponse**](V1ChargeResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="refundServiceQueryRefund"></a>
# **refundServiceQueryRefund**
> V1RefundResponse refundServiceQueryRefund(chargeId, refundId, appId)

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
    V1RefundResponse result = apiInstance.refundServiceQueryRefund(chargeId, refundId, appId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#refundServiceQueryRefund");
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

<a name="refundServiceQueryRefund2"></a>
# **refundServiceQueryRefund2**
> V1RefundResponse refundServiceQueryRefund2(refundId, chargeId, appId)

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
String refundId = "refundId_example"; // String | [REQUIRED] Refund 对象 id
String chargeId = "chargeId_example"; // String | [REQUIRED] 支付 Charge Id
String appId = "appId_example"; // String | [REQUIRED] 应用 id
try {
    V1RefundResponse result = apiInstance.refundServiceQueryRefund2(refundId, chargeId, appId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#refundServiceQueryRefund2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **refundId** | **String**| [REQUIRED] Refund 对象 id |
 **chargeId** | **String**| [REQUIRED] 支付 Charge Id | [optional]
 **appId** | **String**| [REQUIRED] 应用 id | [optional]

### Return type

[**V1RefundResponse**](V1RefundResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="refundServiceQueryRefundList"></a>
# **refundServiceQueryRefundList**
> V1RefundListResponse refundServiceQueryRefundList(chargeId, appId, limit, startingAfter, endingBefore)

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
    V1RefundListResponse result = apiInstance.refundServiceQueryRefundList(chargeId, appId, limit, startingAfter, endingBefore);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#refundServiceQueryRefundList");
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

<a name="refundServiceQueryRefundList2"></a>
# **refundServiceQueryRefundList2**
> V1RefundListResponse refundServiceQueryRefundList2(chargeId, appId, limit, startingAfter, endingBefore)

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
    V1RefundListResponse result = apiInstance.refundServiceQueryRefundList2(chargeId, appId, limit, startingAfter, endingBefore);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#refundServiceQueryRefundList2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **chargeId** | **String**| [REQUIRED] 支付 Charge Id | [optional]
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

<a name="refundServiceRefunds"></a>
# **refundServiceRefunds**
> V1RefundResponse refundServiceRefunds(body)

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
    V1RefundResponse result = apiInstance.refundServiceRefunds(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#refundServiceRefunds");
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

<a name="refundServiceRefunds2"></a>
# **refundServiceRefunds2**
> V1RefundResponse refundServiceRefunds2(body)

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
    V1RefundResponse result = apiInstance.refundServiceRefunds2(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#refundServiceRefunds2");
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

<a name="royaltyServiceCreateRoyalty"></a>
# **royaltyServiceCreateRoyalty**
> V1RoyaltyResponse royaltyServiceCreateRoyalty(body)

创建 Royalty 对象

对一个 Charge 对象进行分账，分账的金额和分账接收方由 Royalty 对象指定。Royalty 创建仅代表本系统成功接收分账申请，尚未提交到支付机构清分，更不代表分账立即成功，相关结果信息请调用查询接口确认

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
V1CreateRoyaltyRequest body = new V1CreateRoyaltyRequest(); // V1CreateRoyaltyRequest | 
try {
    V1RoyaltyResponse result = apiInstance.royaltyServiceCreateRoyalty(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#royaltyServiceCreateRoyalty");
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

<a name="royaltyServiceListAllRoyalties"></a>
# **royaltyServiceListAllRoyalties**
> V1ListAllRoyaltiesResponse royaltyServiceListAllRoyalties(limit, startingAfter, endingBefore, merchantTradeId, createdLt, createdLte, createdGt, createdGte, appId, settleAccountId, royaltySettlementId)

查询 Royalty 对象列表

查询 Royalty 对象的列表信息

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
Integer limit = 10; // Integer | [OPTIONAL] 限制有多少对象可以被返回，限制范围是从 1~100 项，默认是 10 项
String startingAfter = "startingAfter_example"; // String | [OPTIONAL] 在分页时使用的指针，决定了列表的第一项从何处开始。假设你的一次请求返回列表的最后一项的 id 是 obj_end，你可以使用 starting_after = obj_end 去获取下一页
String endingBefore = "endingBefore_example"; // String | [OPTIONAL] 在分页时使用的指针，决定了列表的最末项在何处结束。假设你的一次请求返回列表的第一项的 id 是 obj_start，你可以使用 ending_before = obj_start 去获取上一页
String merchantTradeId = "merchantTradeId_example"; // String | [OPTIONAL] 客户系统订单号
Long createdLt = 0L; // Long | 大于 charge 对象的创建时间，用 Unix 时间戳表示
Long createdLte = 0L; // Long | 大于或等于 charge 对象的创建时间，用 Unix 时间戳表示
Long createdGt = 0L; // Long | 小于 charge 对象的创建时间，用 Unix 时间戳表示
Long createdGte = 0L; // Long | 小于或等于 charge 对象的创建时间，用 Unix 时间戳表示
String appId = "appId_example"; // String | 
String settleAccountId = "settleAccountId_example"; // String | 
String royaltySettlementId = "royaltySettlementId_example"; // String | 
try {
    V1ListAllRoyaltiesResponse result = apiInstance.royaltyServiceListAllRoyalties(limit, startingAfter, endingBefore, merchantTradeId, createdLt, createdLte, createdGt, createdGte, appId, settleAccountId, royaltySettlementId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#royaltyServiceListAllRoyalties");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| [OPTIONAL] 限制有多少对象可以被返回，限制范围是从 1~100 项，默认是 10 项 | [optional] [default to 10]
 **startingAfter** | **String**| [OPTIONAL] 在分页时使用的指针，决定了列表的第一项从何处开始。假设你的一次请求返回列表的最后一项的 id 是 obj_end，你可以使用 starting_after &#x3D; obj_end 去获取下一页 | [optional]
 **endingBefore** | **String**| [OPTIONAL] 在分页时使用的指针，决定了列表的最末项在何处结束。假设你的一次请求返回列表的第一项的 id 是 obj_start，你可以使用 ending_before &#x3D; obj_start 去获取上一页 | [optional]
 **merchantTradeId** | **String**| [OPTIONAL] 客户系统订单号 | [optional]
 **createdLt** | **Long**| 大于 charge 对象的创建时间，用 Unix 时间戳表示 | [optional] [default to 0]
 **createdLte** | **Long**| 大于或等于 charge 对象的创建时间，用 Unix 时间戳表示 | [optional] [default to 0]
 **createdGt** | **Long**| 小于 charge 对象的创建时间，用 Unix 时间戳表示 | [optional] [default to 0]
 **createdGte** | **Long**| 小于或等于 charge 对象的创建时间，用 Unix 时间戳表示 | [optional] [default to 0]
 **appId** | **String**|  | [optional]
 **settleAccountId** | **String**|  | [optional]
 **royaltySettlementId** | **String**|  | [optional]

### Return type

[**V1ListAllRoyaltiesResponse**](V1ListAllRoyaltiesResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="royaltyServiceRetrieveRoyalty"></a>
# **royaltyServiceRetrieveRoyalty**
> V1RoyaltyResponse royaltyServiceRetrieveRoyalty(id)

查询 Royalty 对象

查询 Royalty 对象的信息

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
String id = "id_example"; // String | 
try {
    V1RoyaltyResponse result = apiInstance.royaltyServiceRetrieveRoyalty(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#royaltyServiceRetrieveRoyalty");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**V1RoyaltyResponse**](V1RoyaltyResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="settlementServiceCreateSettlementAccount"></a>
# **settlementServiceCreateSettlementAccount**
> V1SettlementAccountResponse settlementServiceCreateSettlementAccount(body)

创建结算账户

为用户创建一个结算账户。添加结算账户信息后方可对该用进行分账、余额充值、转账等操作。

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
V1CreateSettlementAccountRequest body = new V1CreateSettlementAccountRequest(); // V1CreateSettlementAccountRequest | 
try {
    V1SettlementAccountResponse result = apiInstance.settlementServiceCreateSettlementAccount(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#settlementServiceCreateSettlementAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V1CreateSettlementAccountRequest**](V1CreateSettlementAccountRequest.md)|  |

### Return type

[**V1SettlementAccountResponse**](V1SettlementAccountResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="settlementServiceDeleteSettlementAccount"></a>
# **settlementServiceDeleteSettlementAccount**
> V1DeleteSettlementAccountResponse settlementServiceDeleteSettlementAccount(id, appId)

删除结算账户

删除结算账户

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
String id = "id_example"; // String | 
String appId = "appId_example"; // String | 
try {
    V1DeleteSettlementAccountResponse result = apiInstance.settlementServiceDeleteSettlementAccount(id, appId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#settlementServiceDeleteSettlementAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **appId** | **String**|  | [optional]

### Return type

[**V1DeleteSettlementAccountResponse**](V1DeleteSettlementAccountResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="settlementServiceListAllSettlementAccounts"></a>
# **settlementServiceListAllSettlementAccounts**
> V1SettlementAccountListResponse settlementServiceListAllSettlementAccounts(appId, limit, startingAfter, endingBefore, createdLt, createdLte, createdGt, createdGte, disabled, customerId, businessUserId)

查询结算账户列表

查询结算账户列表

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
String appId = "appId_example"; // String | 
Integer limit = 10; // Integer | [OPTIONAL] 限制有多少对象可以被返回，限制范围是从 1~100 项，默认是 10 项
String startingAfter = "startingAfter_example"; // String | [OPTIONAL] 在分页时使用的指针，决定了列表的第一项从何处开始。假设你的一次请求返回列表的最后一项的 id 是 obj_end，你可以使用 starting_after = obj_end 去获取下一页
String endingBefore = "endingBefore_example"; // String | [OPTIONAL] 在分页时使用的指针，决定了列表的最末项在何处结束。假设你的一次请求返回列表的第一项的 id 是 obj_start，你可以使用 ending_before = obj_start 去获取上一页
Long createdLt = 0L; // Long | 大于 charge 对象的创建时间，用 Unix 时间戳表示
Long createdLte = 0L; // Long | 大于或等于 charge 对象的创建时间，用 Unix 时间戳表示
Long createdGt = 0L; // Long | 小于 charge 对象的创建时间，用 Unix 时间戳表示
Long createdGte = 0L; // Long | 小于或等于 charge 对象的创建时间，用 Unix 时间戳表示
Boolean disabled = true; // Boolean | [OPTIONAL] 是否禁用，默认为 false
String customerId = "customerId_example"; // String | [OPTIONAL] 客户 ID
String businessUserId = "businessUserId_example"; // String | [OPTIONAL] 商户用户 ID
try {
    V1SettlementAccountListResponse result = apiInstance.settlementServiceListAllSettlementAccounts(appId, limit, startingAfter, endingBefore, createdLt, createdLte, createdGt, createdGte, disabled, customerId, businessUserId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#settlementServiceListAllSettlementAccounts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appId** | **String**|  | [optional]
 **limit** | **Integer**| [OPTIONAL] 限制有多少对象可以被返回，限制范围是从 1~100 项，默认是 10 项 | [optional] [default to 10]
 **startingAfter** | **String**| [OPTIONAL] 在分页时使用的指针，决定了列表的第一项从何处开始。假设你的一次请求返回列表的最后一项的 id 是 obj_end，你可以使用 starting_after &#x3D; obj_end 去获取下一页 | [optional]
 **endingBefore** | **String**| [OPTIONAL] 在分页时使用的指针，决定了列表的最末项在何处结束。假设你的一次请求返回列表的第一项的 id 是 obj_start，你可以使用 ending_before &#x3D; obj_start 去获取上一页 | [optional]
 **createdLt** | **Long**| 大于 charge 对象的创建时间，用 Unix 时间戳表示 | [optional] [default to 0]
 **createdLte** | **Long**| 大于或等于 charge 对象的创建时间，用 Unix 时间戳表示 | [optional] [default to 0]
 **createdGt** | **Long**| 小于 charge 对象的创建时间，用 Unix 时间戳表示 | [optional] [default to 0]
 **createdGte** | **Long**| 小于或等于 charge 对象的创建时间，用 Unix 时间戳表示 | [optional] [default to 0]
 **disabled** | **Boolean**| [OPTIONAL] 是否禁用，默认为 false | [optional]
 **customerId** | **String**| [OPTIONAL] 客户 ID | [optional]
 **businessUserId** | **String**| [OPTIONAL] 商户用户 ID | [optional]

### Return type

[**V1SettlementAccountListResponse**](V1SettlementAccountListResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="settlementServiceRetrieveSettlementAccount"></a>
# **settlementServiceRetrieveSettlementAccount**
> V1SettlementAccountResponse settlementServiceRetrieveSettlementAccount(id, appId, object, dataId, dataAppId, dataBusinessUserId, dataCustomerId, dataChannel, dataRecipientWechatpayAccount, dataRecipientWechatpayName, dataRecipientWechatpayForceCheck, dataRecipientWechatpayType, dataRecipientWechatpayAccountType, dataRecipientWechatpayAppId, dataRecipientWechatpaySubAppId, dataRecipientPaymentAlipayAccount, dataRecipientPaymentAlipayName, dataRecipientPaymentAlipayType, dataRecipientPaymentAlipayAccountType, dataRecipientBankAccount, dataRecipientBankName, dataRecipientBankType, dataRecipientBankBankName, dataRecipientBankBankBranch, dataRecipientBankBankProvince, dataRecipientBankBankCity, dataRecipientYsepayMerchantDivisionMerUsercode, dataCreated, dataUpdated, dataObject)

查询结算账户

查询结算账户

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
String id = "id_example"; // String | 
String appId = "appId_example"; // String | 
String object = "SettlementAccount"; // String | 对象类型
String dataId = "0"; // String | 分账接收方的唯一标识
String dataAppId = "0"; // String | 分账接收方所在的应用 ID
String dataBusinessUserId = "0"; // String | 分账接收方的用户 ID
String dataCustomerId = "0"; // String | 分账接收方的用户 ID
String dataChannel = "CHANNEL_UNKNOWN"; // String | 分账接收方的账户类型
String dataRecipientWechatpayAccount = "dataRecipientWechatpayAccount_example"; // String | openid 或者商户号，由类型决定. 微信支付分账接收方账户，OPENID或者商户号
String dataRecipientWechatpayName = "dataRecipientWechatpayName_example"; // String | 微信支付分账接收方姓名或名称
Boolean dataRecipientWechatpayForceCheck = false; // Boolean | 是否强制校验收款人姓名
String dataRecipientWechatpayType = "TYPE_UNSET"; // String | 微信支付分账接收方类型
String dataRecipientWechatpayAccountType = "ACCOUNT_TYPE_UNSET"; // String | 微信支付分账接收方账户类型
String dataRecipientWechatpayAppId = "dataRecipientWechatpayAppId_example"; // String | 微信支付分账接收方 openid 所对应的服务商公众号 ID
String dataRecipientWechatpaySubAppId = "dataRecipientWechatpaySubAppId_example"; // String | 微信支付分账接收方 openid 所对应的商户公众号 ID
String dataRecipientPaymentAlipayAccount = "dataRecipientPaymentAlipayAccount_example"; // String | 支付宝账号，账号ID或者登录邮箱
String dataRecipientPaymentAlipayName = "dataRecipientPaymentAlipayName_example"; // String | 支付宝账号真实姓名
String dataRecipientPaymentAlipayType = "TYPE_UNSET"; // String | 支付宝账号类型
String dataRecipientPaymentAlipayAccountType = "ACCOUNT_TYPE_UNSET"; // String | 支付宝账号类型
String dataRecipientBankAccount = "dataRecipientBankAccount_example"; // String | 银行卡号
String dataRecipientBankName = "dataRecipientBankName_example"; // String | 银行卡开户名
String dataRecipientBankType = "dataRecipientBankType_example"; // String | 银行卡类型
String dataRecipientBankBankName = "dataRecipientBankBankName_example"; // String | 银行卡开户行编码
String dataRecipientBankBankBranch = "dataRecipientBankBankBranch_example"; // String | 银行卡开户支行
String dataRecipientBankBankProvince = "dataRecipientBankBankProvince_example"; // String | 银行卡开户省份
String dataRecipientBankBankCity = "dataRecipientBankBankCity_example"; // String | 银行卡开户城市
String dataRecipientYsepayMerchantDivisionMerUsercode = "dataRecipientYsepayMerchantDivisionMerUsercode_example"; // String | 银盛商户号
Long dataCreated = 0L; // Long | 分账接收方的创建时间
Long dataUpdated = 0L; // Long | 分账接收方的更新时间
String dataObject = "Recipient"; // String | 对象类型
try {
    V1SettlementAccountResponse result = apiInstance.settlementServiceRetrieveSettlementAccount(id, appId, object, dataId, dataAppId, dataBusinessUserId, dataCustomerId, dataChannel, dataRecipientWechatpayAccount, dataRecipientWechatpayName, dataRecipientWechatpayForceCheck, dataRecipientWechatpayType, dataRecipientWechatpayAccountType, dataRecipientWechatpayAppId, dataRecipientWechatpaySubAppId, dataRecipientPaymentAlipayAccount, dataRecipientPaymentAlipayName, dataRecipientPaymentAlipayType, dataRecipientPaymentAlipayAccountType, dataRecipientBankAccount, dataRecipientBankName, dataRecipientBankType, dataRecipientBankBankName, dataRecipientBankBankBranch, dataRecipientBankBankProvince, dataRecipientBankBankCity, dataRecipientYsepayMerchantDivisionMerUsercode, dataCreated, dataUpdated, dataObject);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#settlementServiceRetrieveSettlementAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **appId** | **String**|  | [optional]
 **object** | **String**| 对象类型 | [optional] [default to SettlementAccount]
 **dataId** | **String**| 分账接收方的唯一标识 | [optional] [default to 0]
 **dataAppId** | **String**| 分账接收方所在的应用 ID | [optional] [default to 0]
 **dataBusinessUserId** | **String**| 分账接收方的用户 ID | [optional] [default to 0]
 **dataCustomerId** | **String**| 分账接收方的用户 ID | [optional] [default to 0]
 **dataChannel** | **String**| 分账接收方的账户类型 | [optional] [default to CHANNEL_UNKNOWN] [enum: CHANNEL_UNKNOWN, ALIPAY, WECHATPAY, BANK, BALANCE, YSEPAY_MERCHANT]
 **dataRecipientWechatpayAccount** | **String**| openid 或者商户号，由类型决定. 微信支付分账接收方账户，OPENID或者商户号 | [optional]
 **dataRecipientWechatpayName** | **String**| 微信支付分账接收方姓名或名称 | [optional]
 **dataRecipientWechatpayForceCheck** | **Boolean**| 是否强制校验收款人姓名 | [optional] [default to false]
 **dataRecipientWechatpayType** | **String**| 微信支付分账接收方类型 | [optional] [default to TYPE_UNSET] [enum: TYPE_UNSET, B2C, B2B]
 **dataRecipientWechatpayAccountType** | **String**| 微信支付分账接收方账户类型 | [optional] [default to ACCOUNT_TYPE_UNSET] [enum: ACCOUNT_TYPE_UNSET, MERCHANT_ID, OPENID, SUB_OPENID, LOGIN_NAME, USER_ID]
 **dataRecipientWechatpayAppId** | **String**| 微信支付分账接收方 openid 所对应的服务商公众号 ID | [optional]
 **dataRecipientWechatpaySubAppId** | **String**| 微信支付分账接收方 openid 所对应的商户公众号 ID | [optional]
 **dataRecipientPaymentAlipayAccount** | **String**| 支付宝账号，账号ID或者登录邮箱 | [optional]
 **dataRecipientPaymentAlipayName** | **String**| 支付宝账号真实姓名 | [optional]
 **dataRecipientPaymentAlipayType** | **String**| 支付宝账号类型 | [optional] [default to TYPE_UNSET] [enum: TYPE_UNSET, B2C, B2B]
 **dataRecipientPaymentAlipayAccountType** | **String**| 支付宝账号类型 | [optional] [default to ACCOUNT_TYPE_UNSET] [enum: ACCOUNT_TYPE_UNSET, MERCHANT_ID, OPENID, SUB_OPENID, LOGIN_NAME, USER_ID]
 **dataRecipientBankAccount** | **String**| 银行卡号 | [optional]
 **dataRecipientBankName** | **String**| 银行卡开户名 | [optional]
 **dataRecipientBankType** | **String**| 银行卡类型 | [optional]
 **dataRecipientBankBankName** | **String**| 银行卡开户行编码 | [optional]
 **dataRecipientBankBankBranch** | **String**| 银行卡开户支行 | [optional]
 **dataRecipientBankBankProvince** | **String**| 银行卡开户省份 | [optional]
 **dataRecipientBankBankCity** | **String**| 银行卡开户城市 | [optional]
 **dataRecipientYsepayMerchantDivisionMerUsercode** | **String**| 银盛商户号 | [optional]
 **dataCreated** | **Long**| 分账接收方的创建时间 | [optional] [default to 0]
 **dataUpdated** | **Long**| 分账接收方的更新时间 | [optional] [default to 0]
 **dataObject** | **String**| 对象类型 | [optional] [default to Recipient]

### Return type

[**V1SettlementAccountResponse**](V1SettlementAccountResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="settlementServiceSearchSettlementAccounts"></a>
# **settlementServiceSearchSettlementAccounts**
> V1SettlementAccountListResponse settlementServiceSearchSettlementAccounts(userId, appId)

查询结算账户列表

查询结算账户列表

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
String userId = "userId_example"; // String | 
String appId = "appId_example"; // String | 
try {
    V1SettlementAccountListResponse result = apiInstance.settlementServiceSearchSettlementAccounts(userId, appId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#settlementServiceSearchSettlementAccounts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**|  | [optional]
 **appId** | **String**|  | [optional]

### Return type

[**V1SettlementAccountListResponse**](V1SettlementAccountListResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="settlementServiceUpdateSettlementAccount"></a>
# **settlementServiceUpdateSettlementAccount**
> V1SettlementAccountResponse settlementServiceUpdateSettlementAccount(settlementAccountId, body, updateMask)

更新结算账户

更新结算账户

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
String settlementAccountId = "settlementAccountId_example"; // String | 
V1UpdateAndPatchRequestBody body = new V1UpdateAndPatchRequestBody(); // V1UpdateAndPatchRequestBody | 
String updateMask = "updateMask_example"; // String | 
try {
    V1SettlementAccountResponse result = apiInstance.settlementServiceUpdateSettlementAccount(settlementAccountId, body, updateMask);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#settlementServiceUpdateSettlementAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **settlementAccountId** | **String**|  |
 **body** | [**V1UpdateAndPatchRequestBody**](V1UpdateAndPatchRequestBody.md)|  |
 **updateMask** | **String**|  | [optional]

### Return type

[**V1SettlementAccountResponse**](V1SettlementAccountResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="settlementServiceUpdateSettlementAccount2"></a>
# **settlementServiceUpdateSettlementAccount2**
> V1SettlementAccountResponse settlementServiceUpdateSettlementAccount2(settlementAccountId, body, updateMask)

更新结算账户

更新结算账户

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
String settlementAccountId = "settlementAccountId_example"; // String | 
V1UpdateAndPatchRequestBody body = new V1UpdateAndPatchRequestBody(); // V1UpdateAndPatchRequestBody | 
String updateMask = "updateMask_example"; // String | 
try {
    V1SettlementAccountResponse result = apiInstance.settlementServiceUpdateSettlementAccount2(settlementAccountId, body, updateMask);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#settlementServiceUpdateSettlementAccount2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **settlementAccountId** | **String**|  |
 **body** | [**V1UpdateAndPatchRequestBody**](V1UpdateAndPatchRequestBody.md)|  |
 **updateMask** | **String**|  | [optional]

### Return type

[**V1SettlementAccountResponse**](V1SettlementAccountResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

