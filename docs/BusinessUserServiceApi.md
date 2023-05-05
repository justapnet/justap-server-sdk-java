# BusinessUserServiceApi

All URIs are relative to *http://127.0.0.1:21011*

Method | HTTP request | Description
------------- | ------------- | -------------
[**businessUserServiceCreateUser**](BusinessUserServiceApi.md#businessUserServiceCreateUser) | **POST** /v1/business_users | 创建 BusinessUser 对象
[**businessUserServiceDeleteUser**](BusinessUserServiceApi.md#businessUserServiceDeleteUser) | **DELETE** /v1/business_users/{id} | 删除 BusinessUser 对象
[**businessUserServiceListAllUsers**](BusinessUserServiceApi.md#businessUserServiceListAllUsers) | **GET** /v1/business_users | 查询 BusinessUser 对象列表
[**businessUserServiceRetrieveUser**](BusinessUserServiceApi.md#businessUserServiceRetrieveUser) | **GET** /v1/business_users/{id} | 查询 BusinessUser 对象
[**businessUserServiceSearchUsers**](BusinessUserServiceApi.md#businessUserServiceSearchUsers) | **GET** /v1/business_users/search | 搜索 BusinessUser 对象
[**businessUserServiceUpdateUser**](BusinessUserServiceApi.md#businessUserServiceUpdateUser) | **POST** /v1/business_users/{id} | 更新 BusinessUser 对象


<a name="businessUserServiceCreateUser"></a>
# **businessUserServiceCreateUser**
> V1UserResponse businessUserServiceCreateUser(body)

创建 BusinessUser 对象

### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.BusinessUserServiceApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

BusinessUserServiceApi apiInstance = new BusinessUserServiceApi();
V1CreateUserRequest body = new V1CreateUserRequest(); // V1CreateUserRequest | 
try {
    V1UserResponse result = apiInstance.businessUserServiceCreateUser(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BusinessUserServiceApi#businessUserServiceCreateUser");
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

删除 BusinessUser 对象

### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.BusinessUserServiceApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

BusinessUserServiceApi apiInstance = new BusinessUserServiceApi();
String id = "id_example"; // String | 
String appId = "appId_example"; // String | 
try {
    V1DeleteUserResponse result = apiInstance.businessUserServiceDeleteUser(id, appId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BusinessUserServiceApi#businessUserServiceDeleteUser");
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

查询 BusinessUser 对象列表

### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.BusinessUserServiceApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

BusinessUserServiceApi apiInstance = new BusinessUserServiceApi();
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
    System.err.println("Exception when calling BusinessUserServiceApi#businessUserServiceListAllUsers");
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

查询 BusinessUser 对象

### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.BusinessUserServiceApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

BusinessUserServiceApi apiInstance = new BusinessUserServiceApi();
String id = "id_example"; // String | 
String appId = "appId_example"; // String | 
try {
    V1UserResponse result = apiInstance.businessUserServiceRetrieveUser(id, appId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BusinessUserServiceApi#businessUserServiceRetrieveUser");
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

搜索 BusinessUser 对象

### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.BusinessUserServiceApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

BusinessUserServiceApi apiInstance = new BusinessUserServiceApi();
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
    System.err.println("Exception when calling BusinessUserServiceApi#businessUserServiceSearchUsers");
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
> V1UserResponse businessUserServiceUpdateUser(id, appId, address, currency, description, email, name, phone, avatar, disabled, gender, parentUserId)

更新 BusinessUser 对象

### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.BusinessUserServiceApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

BusinessUserServiceApi apiInstance = new BusinessUserServiceApi();
String id = "id_example"; // String | 
String appId = "appId_example"; // String | 
String address = "address_example"; // String | 
String currency = "currency_example"; // String | 
String description = "description_example"; // String | 
String email = "email_example"; // String | 
String name = "name_example"; // String | 
String phone = "phone_example"; // String | 
String avatar = "avatar_example"; // String | 
Boolean disabled = true; // Boolean | 
String gender = "GENDER_UNKNOWN"; // String |  - GENDER_UNKNOWN: 未设置  - MALE: 男  - FE_MALE: 女  - PRIVACY: 保密  - ThirdGender: 第三性别
String parentUserId = "parentUserId_example"; // String | 
try {
    V1UserResponse result = apiInstance.businessUserServiceUpdateUser(id, appId, address, currency, description, email, name, phone, avatar, disabled, gender, parentUserId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BusinessUserServiceApi#businessUserServiceUpdateUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **appId** | **String**|  | [optional]
 **address** | **String**|  | [optional]
 **currency** | **String**|  | [optional]
 **description** | **String**|  | [optional]
 **email** | **String**|  | [optional]
 **name** | **String**|  | [optional]
 **phone** | **String**|  | [optional]
 **avatar** | **String**|  | [optional]
 **disabled** | **Boolean**|  | [optional]
 **gender** | **String**|  - GENDER_UNKNOWN: 未设置  - MALE: 男  - FE_MALE: 女  - PRIVACY: 保密  - ThirdGender: 第三性别 | [optional] [default to GENDER_UNKNOWN] [enum: GENDER_UNKNOWN, MALE, FE_MALE, PRIVACY, ThirdGender]
 **parentUserId** | **String**|  | [optional]

### Return type

[**V1UserResponse**](V1UserResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

