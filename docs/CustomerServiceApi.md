# CustomerServiceApi

All URIs are relative to *http://127.0.0.1:21011*

Method | HTTP request | Description
------------- | ------------- | -------------
[**customerServiceCreateCustomer**](CustomerServiceApi.md#customerServiceCreateCustomer) | **POST** /v1/customers | 
[**customerServiceDeleteCustomer**](CustomerServiceApi.md#customerServiceDeleteCustomer) | **DELETE** /v1/customers/{id} | 
[**customerServiceListAllCustomers**](CustomerServiceApi.md#customerServiceListAllCustomers) | **GET** /v1/customers | 
[**customerServiceRetrieveCustomer**](CustomerServiceApi.md#customerServiceRetrieveCustomer) | **GET** /v1/customers/{id} | 
[**customerServiceSearchCustomers**](CustomerServiceApi.md#customerServiceSearchCustomers) | **GET** /v1/customers/search | 
[**customerServiceUpdateCustomer**](CustomerServiceApi.md#customerServiceUpdateCustomer) | **POST** /v1/customers/{id} | 


<a name="customerServiceCreateCustomer"></a>
# **customerServiceCreateCustomer**
> V1CustomerResponse customerServiceCreateCustomer(body)



### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.CustomerServiceApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

CustomerServiceApi apiInstance = new CustomerServiceApi();
V1CreateCustomerRequest body = new V1CreateCustomerRequest(); // V1CreateCustomerRequest | 
try {
    V1CustomerResponse result = apiInstance.customerServiceCreateCustomer(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomerServiceApi#customerServiceCreateCustomer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V1CreateCustomerRequest**](V1CreateCustomerRequest.md)|  |

### Return type

[**V1CustomerResponse**](V1CustomerResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="customerServiceDeleteCustomer"></a>
# **customerServiceDeleteCustomer**
> V1DeleteCustomerResponse customerServiceDeleteCustomer(id, appId)



### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.CustomerServiceApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

CustomerServiceApi apiInstance = new CustomerServiceApi();
String id = "id_example"; // String | 
String appId = "appId_example"; // String | 
try {
    V1DeleteCustomerResponse result = apiInstance.customerServiceDeleteCustomer(id, appId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomerServiceApi#customerServiceDeleteCustomer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **appId** | **String**|  | [optional]

### Return type

[**V1DeleteCustomerResponse**](V1DeleteCustomerResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="customerServiceListAllCustomers"></a>
# **customerServiceListAllCustomers**
> V1CustomerListResponse customerServiceListAllCustomers(appId, limit, startingAfter, endingBefore, createdLt, createdLte, createdGt, createdGte, disabled)



### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.CustomerServiceApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

CustomerServiceApi apiInstance = new CustomerServiceApi();
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
    V1CustomerListResponse result = apiInstance.customerServiceListAllCustomers(appId, limit, startingAfter, endingBefore, createdLt, createdLte, createdGt, createdGte, disabled);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomerServiceApi#customerServiceListAllCustomers");
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

[**V1CustomerListResponse**](V1CustomerListResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="customerServiceRetrieveCustomer"></a>
# **customerServiceRetrieveCustomer**
> V1CustomerResponse customerServiceRetrieveCustomer(id, appId)



### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.CustomerServiceApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

CustomerServiceApi apiInstance = new CustomerServiceApi();
String id = "id_example"; // String | 
String appId = "appId_example"; // String | 
try {
    V1CustomerResponse result = apiInstance.customerServiceRetrieveCustomer(id, appId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomerServiceApi#customerServiceRetrieveCustomer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **appId** | **String**|  | [optional]

### Return type

[**V1CustomerResponse**](V1CustomerResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="customerServiceSearchCustomers"></a>
# **customerServiceSearchCustomers**
> V1CustomerListResponse customerServiceSearchCustomers(appId, limit, createdLt, createdLte, createdGt, createdGte, email, name, phone)



### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.CustomerServiceApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

CustomerServiceApi apiInstance = new CustomerServiceApi();
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
    V1CustomerListResponse result = apiInstance.customerServiceSearchCustomers(appId, limit, createdLt, createdLte, createdGt, createdGte, email, name, phone);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomerServiceApi#customerServiceSearchCustomers");
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

[**V1CustomerListResponse**](V1CustomerListResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="customerServiceUpdateCustomer"></a>
# **customerServiceUpdateCustomer**
> V1CustomerResponse customerServiceUpdateCustomer(id)



### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.CustomerServiceApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

CustomerServiceApi apiInstance = new CustomerServiceApi();
String id = "id_example"; // String | 
try {
    V1CustomerResponse result = apiInstance.customerServiceUpdateCustomer(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomerServiceApi#customerServiceUpdateCustomer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**V1CustomerResponse**](V1CustomerResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

