# SettlementServiceApi

All URIs are relative to *http://127.0.0.1:21011*

Method | HTTP request | Description
------------- | ------------- | -------------
[**settlementServiceCreateSettlementAccount**](SettlementServiceApi.md#settlementServiceCreateSettlementAccount) | **POST** /v1/settlement_accounts | 创建 SettlementAccount 对象
[**settlementServiceDeleteSettlementAccount**](SettlementServiceApi.md#settlementServiceDeleteSettlementAccount) | **DELETE** /v1/settlement_accounts/{id} | 删除 SettlementAccount 对象
[**settlementServiceListAllSettlementAccounts**](SettlementServiceApi.md#settlementServiceListAllSettlementAccounts) | **GET** /v1/settlement_accounts | 查询 SettlementAccount 对象列表
[**settlementServiceRetrieveSettlementAccount**](SettlementServiceApi.md#settlementServiceRetrieveSettlementAccount) | **GET** /v1/settlement_accounts/{id} | 查询 SettlementAccount 对象
[**settlementServiceSearchSettlementAccounts**](SettlementServiceApi.md#settlementServiceSearchSettlementAccounts) | **GET** /v1/settlement_accounts/search | 搜索 SettlementAccount 对象
[**settlementServiceUpdateSettlementAccount**](SettlementServiceApi.md#settlementServiceUpdateSettlementAccount) | **POST** /v1/settlement_accounts/{id} | 更新 SettlementAccount 对象


<a name="settlementServiceCreateSettlementAccount"></a>
# **settlementServiceCreateSettlementAccount**
> V1SettlementAccountResponse settlementServiceCreateSettlementAccount(appId, userId, customerId, channel, recipientWechatpayChannelRecipientAccount, recipientWechatpayChannelRecipientName, recipientWechatpayChannelRecipientForceCheck, recipientWechatpayChannelRecipientType, recipientWechatpayChannelRecipientAccountType, recipientWechatpayChannelRecipientAppId, recipientAlipayChannelRecipientAccount, recipientAlipayChannelRecipientName, recipientAlipayChannelRecipientType, recipientAlipayChannelRecipientAccountType, recipientBankChannelRecipientAccount, recipientBankChannelRecipientName, recipientBankChannelRecipientType, recipientBankChannelRecipientBankName, recipientBankChannelRecipientBankBranch, recipientBankChannelRecipientBankProvince, recipientBankChannelRecipientBankCity)

创建 SettlementAccount 对象

### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.SettlementServiceApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

SettlementServiceApi apiInstance = new SettlementServiceApi();
String appId = "appId_example"; // String | 
String userId = "userId_example"; // String | 
String customerId = "customerId_example"; // String | 
String channel = "CHANNEL_UNKNOWN"; // String |  - ALIPAY: 分账到支付宝  - WECHANTPAY: 分账到微信支付  - BANK: 分账到银行卡  - BALANCE: 分账到 justap 账户余额
String recipientWechatpayChannelRecipientAccount = "recipientWechatpayChannelRecipientAccount_example"; // String | openid 或者商户号，由类型决定  微信支付分账接收方账户，OPENID或者商户号
String recipientWechatpayChannelRecipientName = "recipientWechatpayChannelRecipientName_example"; // String | 微信支付分账接收方姓名或名称
Boolean recipientWechatpayChannelRecipientForceCheck = false; // Boolean | 是否强制校验收款人姓名
String recipientWechatpayChannelRecipientType = "TYPE_UNSET"; // String | 微信支付分账接收方类型
String recipientWechatpayChannelRecipientAccountType = "ACCOUNT_TYPE_UNSET"; // String | 微信支付分账接收方账户类型   - ACCOUNT_TYPE_UNSET: 未设置  - MERCHANT_ID: 分账到微信商户号  - OPENID: 分账到个人微信号（父公众号的openid，或服务商的openid））  - SUB_OPENID: 分账到个人微信号，子账号的  - LOGIN_NAME: 分账到微信登录号
String recipientWechatpayChannelRecipientAppId = "recipientWechatpayChannelRecipientAppId_example"; // String | 微信支付分账接收方 openid 所对应的公众号 ID
String recipientAlipayChannelRecipientAccount = "recipientAlipayChannelRecipientAccount_example"; // String | 支付宝账号，账号ID或者登录邮箱
String recipientAlipayChannelRecipientName = "recipientAlipayChannelRecipientName_example"; // String | 支付宝账号真实姓名
String recipientAlipayChannelRecipientType = "TYPE_UNSET"; // String | 支付宝账号类型
String recipientAlipayChannelRecipientAccountType = "ACCOUNT_TYPE_UNSET"; // String | 支付宝账号类型   - ACCOUNT_TYPE_UNSET: 未设置  - MERCHANT_ID: 分账到微信商户号  - OPENID: 分账到个人微信号（父公众号的openid，或服务商的openid））  - SUB_OPENID: 分账到个人微信号，子账号的  - LOGIN_NAME: 分账到微信登录号
String recipientBankChannelRecipientAccount = "recipientBankChannelRecipientAccount_example"; // String | 银行卡号
String recipientBankChannelRecipientName = "recipientBankChannelRecipientName_example"; // String | 银行卡开户名
String recipientBankChannelRecipientType = "recipientBankChannelRecipientType_example"; // String | 银行卡类型
String recipientBankChannelRecipientBankName = "recipientBankChannelRecipientBankName_example"; // String | 银行卡开户行编码
String recipientBankChannelRecipientBankBranch = "recipientBankChannelRecipientBankBranch_example"; // String | 银行卡开户支行
String recipientBankChannelRecipientBankProvince = "recipientBankChannelRecipientBankProvince_example"; // String | 银行卡开户省份
String recipientBankChannelRecipientBankCity = "recipientBankChannelRecipientBankCity_example"; // String | 银行卡开户城市
try {
    V1SettlementAccountResponse result = apiInstance.settlementServiceCreateSettlementAccount(appId, userId, customerId, channel, recipientWechatpayChannelRecipientAccount, recipientWechatpayChannelRecipientName, recipientWechatpayChannelRecipientForceCheck, recipientWechatpayChannelRecipientType, recipientWechatpayChannelRecipientAccountType, recipientWechatpayChannelRecipientAppId, recipientAlipayChannelRecipientAccount, recipientAlipayChannelRecipientName, recipientAlipayChannelRecipientType, recipientAlipayChannelRecipientAccountType, recipientBankChannelRecipientAccount, recipientBankChannelRecipientName, recipientBankChannelRecipientType, recipientBankChannelRecipientBankName, recipientBankChannelRecipientBankBranch, recipientBankChannelRecipientBankProvince, recipientBankChannelRecipientBankCity);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SettlementServiceApi#settlementServiceCreateSettlementAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appId** | **String**|  | [optional]
 **userId** | **String**|  | [optional]
 **customerId** | **String**|  | [optional]
 **channel** | **String**|  - ALIPAY: 分账到支付宝  - WECHANTPAY: 分账到微信支付  - BANK: 分账到银行卡  - BALANCE: 分账到 justap 账户余额 | [optional] [default to CHANNEL_UNKNOWN] [enum: CHANNEL_UNKNOWN, ALIPAY, WECHANTPAY, BANK, BALANCE]
 **recipientWechatpayChannelRecipientAccount** | **String**| openid 或者商户号，由类型决定  微信支付分账接收方账户，OPENID或者商户号 | [optional]
 **recipientWechatpayChannelRecipientName** | **String**| 微信支付分账接收方姓名或名称 | [optional]
 **recipientWechatpayChannelRecipientForceCheck** | **Boolean**| 是否强制校验收款人姓名 | [optional] [default to false]
 **recipientWechatpayChannelRecipientType** | **String**| 微信支付分账接收方类型 | [optional] [default to TYPE_UNSET] [enum: TYPE_UNSET, B2C, B2B]
 **recipientWechatpayChannelRecipientAccountType** | **String**| 微信支付分账接收方账户类型   - ACCOUNT_TYPE_UNSET: 未设置  - MERCHANT_ID: 分账到微信商户号  - OPENID: 分账到个人微信号（父公众号的openid，或服务商的openid））  - SUB_OPENID: 分账到个人微信号，子账号的  - LOGIN_NAME: 分账到微信登录号 | [optional] [default to ACCOUNT_TYPE_UNSET] [enum: ACCOUNT_TYPE_UNSET, MERCHANT_ID, OPENID, SUB_OPENID, LOGIN_NAME, USER_ID]
 **recipientWechatpayChannelRecipientAppId** | **String**| 微信支付分账接收方 openid 所对应的公众号 ID | [optional]
 **recipientAlipayChannelRecipientAccount** | **String**| 支付宝账号，账号ID或者登录邮箱 | [optional]
 **recipientAlipayChannelRecipientName** | **String**| 支付宝账号真实姓名 | [optional]
 **recipientAlipayChannelRecipientType** | **String**| 支付宝账号类型 | [optional] [default to TYPE_UNSET] [enum: TYPE_UNSET, B2C, B2B]
 **recipientAlipayChannelRecipientAccountType** | **String**| 支付宝账号类型   - ACCOUNT_TYPE_UNSET: 未设置  - MERCHANT_ID: 分账到微信商户号  - OPENID: 分账到个人微信号（父公众号的openid，或服务商的openid））  - SUB_OPENID: 分账到个人微信号，子账号的  - LOGIN_NAME: 分账到微信登录号 | [optional] [default to ACCOUNT_TYPE_UNSET] [enum: ACCOUNT_TYPE_UNSET, MERCHANT_ID, OPENID, SUB_OPENID, LOGIN_NAME, USER_ID]
 **recipientBankChannelRecipientAccount** | **String**| 银行卡号 | [optional]
 **recipientBankChannelRecipientName** | **String**| 银行卡开户名 | [optional]
 **recipientBankChannelRecipientType** | **String**| 银行卡类型 | [optional]
 **recipientBankChannelRecipientBankName** | **String**| 银行卡开户行编码 | [optional]
 **recipientBankChannelRecipientBankBranch** | **String**| 银行卡开户支行 | [optional]
 **recipientBankChannelRecipientBankProvince** | **String**| 银行卡开户省份 | [optional]
 **recipientBankChannelRecipientBankCity** | **String**| 银行卡开户城市 | [optional]

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

删除 SettlementAccount 对象

### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.SettlementServiceApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

SettlementServiceApi apiInstance = new SettlementServiceApi();
String id = "id_example"; // String | 
String appId = "appId_example"; // String | 
try {
    V1DeleteSettlementAccountResponse result = apiInstance.settlementServiceDeleteSettlementAccount(id, appId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SettlementServiceApi#settlementServiceDeleteSettlementAccount");
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
> V1SettlementAccountListResponse settlementServiceListAllSettlementAccounts(appId, limit, startingAfter, endingBefore, createdLt, createdLte, createdGt, createdGte, disabled, customerId, userId)

查询 SettlementAccount 对象列表

### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.SettlementServiceApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

SettlementServiceApi apiInstance = new SettlementServiceApi();
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
String userId = "userId_example"; // String | [OPTIONAL] 商户用户 ID
try {
    V1SettlementAccountListResponse result = apiInstance.settlementServiceListAllSettlementAccounts(appId, limit, startingAfter, endingBefore, createdLt, createdLte, createdGt, createdGte, disabled, customerId, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SettlementServiceApi#settlementServiceListAllSettlementAccounts");
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
 **userId** | **String**| [OPTIONAL] 商户用户 ID | [optional]

### Return type

[**V1SettlementAccountListResponse**](V1SettlementAccountListResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="settlementServiceRetrieveSettlementAccount"></a>
# **settlementServiceRetrieveSettlementAccount**
> V1SettlementAccountResponse settlementServiceRetrieveSettlementAccount(id, appId, object, dataId, dataAppId, dataUserId, dataChannel, dataRecipientWechatpayChannelRecipientAccount, dataRecipientWechatpayChannelRecipientName, dataRecipientWechatpayChannelRecipientForceCheck, dataRecipientWechatpayChannelRecipientType, dataRecipientWechatpayChannelRecipientAccountType, dataRecipientWechatpayChannelRecipientAppId, dataRecipientAlipayChannelRecipientAccount, dataRecipientAlipayChannelRecipientName, dataRecipientAlipayChannelRecipientType, dataRecipientAlipayChannelRecipientAccountType, dataRecipientBankChannelRecipientAccount, dataRecipientBankChannelRecipientName, dataRecipientBankChannelRecipientType, dataRecipientBankChannelRecipientBankName, dataRecipientBankChannelRecipientBankBranch, dataRecipientBankChannelRecipientBankProvince, dataRecipientBankChannelRecipientBankCity, dataCreated, dataUpdated, dataObject)

查询 SettlementAccount 对象

### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.SettlementServiceApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

SettlementServiceApi apiInstance = new SettlementServiceApi();
String id = "id_example"; // String | 
String appId = "appId_example"; // String | 
String object = "SettlementAccount"; // String | 对象类型
String dataId = "0"; // String | 分账接收方的唯一标识
String dataAppId = "0"; // String | 分账接收方所在的应用 ID
String dataUserId = "0"; // String | 分账接收方的用户 ID
String dataChannel = "CHANNEL_UNKNOWN"; // String | 分账接收方的账户类型   - ALIPAY: 分账到支付宝  - WECHANTPAY: 分账到微信支付  - BANK: 分账到银行卡  - BALANCE: 分账到 justap 账户余额
String dataRecipientWechatpayChannelRecipientAccount = "dataRecipientWechatpayChannelRecipientAccount_example"; // String | openid 或者商户号，由类型决定  微信支付分账接收方账户，OPENID或者商户号
String dataRecipientWechatpayChannelRecipientName = "dataRecipientWechatpayChannelRecipientName_example"; // String | 微信支付分账接收方姓名或名称
Boolean dataRecipientWechatpayChannelRecipientForceCheck = false; // Boolean | 是否强制校验收款人姓名
String dataRecipientWechatpayChannelRecipientType = "TYPE_UNSET"; // String | 微信支付分账接收方类型
String dataRecipientWechatpayChannelRecipientAccountType = "ACCOUNT_TYPE_UNSET"; // String | 微信支付分账接收方账户类型   - ACCOUNT_TYPE_UNSET: 未设置  - MERCHANT_ID: 分账到微信商户号  - OPENID: 分账到个人微信号（父公众号的openid，或服务商的openid））  - SUB_OPENID: 分账到个人微信号，子账号的  - LOGIN_NAME: 分账到微信登录号
String dataRecipientWechatpayChannelRecipientAppId = "dataRecipientWechatpayChannelRecipientAppId_example"; // String | 微信支付分账接收方 openid 所对应的公众号 ID
String dataRecipientAlipayChannelRecipientAccount = "dataRecipientAlipayChannelRecipientAccount_example"; // String | 支付宝账号，账号ID或者登录邮箱
String dataRecipientAlipayChannelRecipientName = "dataRecipientAlipayChannelRecipientName_example"; // String | 支付宝账号真实姓名
String dataRecipientAlipayChannelRecipientType = "TYPE_UNSET"; // String | 支付宝账号类型
String dataRecipientAlipayChannelRecipientAccountType = "ACCOUNT_TYPE_UNSET"; // String | 支付宝账号类型   - ACCOUNT_TYPE_UNSET: 未设置  - MERCHANT_ID: 分账到微信商户号  - OPENID: 分账到个人微信号（父公众号的openid，或服务商的openid））  - SUB_OPENID: 分账到个人微信号，子账号的  - LOGIN_NAME: 分账到微信登录号
String dataRecipientBankChannelRecipientAccount = "dataRecipientBankChannelRecipientAccount_example"; // String | 银行卡号
String dataRecipientBankChannelRecipientName = "dataRecipientBankChannelRecipientName_example"; // String | 银行卡开户名
String dataRecipientBankChannelRecipientType = "dataRecipientBankChannelRecipientType_example"; // String | 银行卡类型
String dataRecipientBankChannelRecipientBankName = "dataRecipientBankChannelRecipientBankName_example"; // String | 银行卡开户行编码
String dataRecipientBankChannelRecipientBankBranch = "dataRecipientBankChannelRecipientBankBranch_example"; // String | 银行卡开户支行
String dataRecipientBankChannelRecipientBankProvince = "dataRecipientBankChannelRecipientBankProvince_example"; // String | 银行卡开户省份
String dataRecipientBankChannelRecipientBankCity = "dataRecipientBankChannelRecipientBankCity_example"; // String | 银行卡开户城市
Long dataCreated = 0L; // Long | 分账接收方的创建时间
Long dataUpdated = 0L; // Long | 分账接收方的更新时间
String dataObject = "Recipient"; // String | 对象类型
try {
    V1SettlementAccountResponse result = apiInstance.settlementServiceRetrieveSettlementAccount(id, appId, object, dataId, dataAppId, dataUserId, dataChannel, dataRecipientWechatpayChannelRecipientAccount, dataRecipientWechatpayChannelRecipientName, dataRecipientWechatpayChannelRecipientForceCheck, dataRecipientWechatpayChannelRecipientType, dataRecipientWechatpayChannelRecipientAccountType, dataRecipientWechatpayChannelRecipientAppId, dataRecipientAlipayChannelRecipientAccount, dataRecipientAlipayChannelRecipientName, dataRecipientAlipayChannelRecipientType, dataRecipientAlipayChannelRecipientAccountType, dataRecipientBankChannelRecipientAccount, dataRecipientBankChannelRecipientName, dataRecipientBankChannelRecipientType, dataRecipientBankChannelRecipientBankName, dataRecipientBankChannelRecipientBankBranch, dataRecipientBankChannelRecipientBankProvince, dataRecipientBankChannelRecipientBankCity, dataCreated, dataUpdated, dataObject);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SettlementServiceApi#settlementServiceRetrieveSettlementAccount");
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
 **dataUserId** | **String**| 分账接收方的用户 ID | [optional] [default to 0]
 **dataChannel** | **String**| 分账接收方的账户类型   - ALIPAY: 分账到支付宝  - WECHANTPAY: 分账到微信支付  - BANK: 分账到银行卡  - BALANCE: 分账到 justap 账户余额 | [optional] [default to CHANNEL_UNKNOWN] [enum: CHANNEL_UNKNOWN, ALIPAY, WECHANTPAY, BANK, BALANCE]
 **dataRecipientWechatpayChannelRecipientAccount** | **String**| openid 或者商户号，由类型决定  微信支付分账接收方账户，OPENID或者商户号 | [optional]
 **dataRecipientWechatpayChannelRecipientName** | **String**| 微信支付分账接收方姓名或名称 | [optional]
 **dataRecipientWechatpayChannelRecipientForceCheck** | **Boolean**| 是否强制校验收款人姓名 | [optional] [default to false]
 **dataRecipientWechatpayChannelRecipientType** | **String**| 微信支付分账接收方类型 | [optional] [default to TYPE_UNSET] [enum: TYPE_UNSET, B2C, B2B]
 **dataRecipientWechatpayChannelRecipientAccountType** | **String**| 微信支付分账接收方账户类型   - ACCOUNT_TYPE_UNSET: 未设置  - MERCHANT_ID: 分账到微信商户号  - OPENID: 分账到个人微信号（父公众号的openid，或服务商的openid））  - SUB_OPENID: 分账到个人微信号，子账号的  - LOGIN_NAME: 分账到微信登录号 | [optional] [default to ACCOUNT_TYPE_UNSET] [enum: ACCOUNT_TYPE_UNSET, MERCHANT_ID, OPENID, SUB_OPENID, LOGIN_NAME, USER_ID]
 **dataRecipientWechatpayChannelRecipientAppId** | **String**| 微信支付分账接收方 openid 所对应的公众号 ID | [optional]
 **dataRecipientAlipayChannelRecipientAccount** | **String**| 支付宝账号，账号ID或者登录邮箱 | [optional]
 **dataRecipientAlipayChannelRecipientName** | **String**| 支付宝账号真实姓名 | [optional]
 **dataRecipientAlipayChannelRecipientType** | **String**| 支付宝账号类型 | [optional] [default to TYPE_UNSET] [enum: TYPE_UNSET, B2C, B2B]
 **dataRecipientAlipayChannelRecipientAccountType** | **String**| 支付宝账号类型   - ACCOUNT_TYPE_UNSET: 未设置  - MERCHANT_ID: 分账到微信商户号  - OPENID: 分账到个人微信号（父公众号的openid，或服务商的openid））  - SUB_OPENID: 分账到个人微信号，子账号的  - LOGIN_NAME: 分账到微信登录号 | [optional] [default to ACCOUNT_TYPE_UNSET] [enum: ACCOUNT_TYPE_UNSET, MERCHANT_ID, OPENID, SUB_OPENID, LOGIN_NAME, USER_ID]
 **dataRecipientBankChannelRecipientAccount** | **String**| 银行卡号 | [optional]
 **dataRecipientBankChannelRecipientName** | **String**| 银行卡开户名 | [optional]
 **dataRecipientBankChannelRecipientType** | **String**| 银行卡类型 | [optional]
 **dataRecipientBankChannelRecipientBankName** | **String**| 银行卡开户行编码 | [optional]
 **dataRecipientBankChannelRecipientBankBranch** | **String**| 银行卡开户支行 | [optional]
 **dataRecipientBankChannelRecipientBankProvince** | **String**| 银行卡开户省份 | [optional]
 **dataRecipientBankChannelRecipientBankCity** | **String**| 银行卡开户城市 | [optional]
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

搜索 SettlementAccount 对象

### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.SettlementServiceApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

SettlementServiceApi apiInstance = new SettlementServiceApi();
String userId = "userId_example"; // String | 
String appId = "appId_example"; // String | 
try {
    V1SettlementAccountListResponse result = apiInstance.settlementServiceSearchSettlementAccounts(userId, appId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SettlementServiceApi#settlementServiceSearchSettlementAccounts");
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
> V1SettlementAccountResponse settlementServiceUpdateSettlementAccount(id, customerId, userId, channel, recipientWechatpayChannelRecipientAccount, recipientWechatpayChannelRecipientName, recipientWechatpayChannelRecipientForceCheck, recipientWechatpayChannelRecipientType, recipientWechatpayChannelRecipientAccountType, recipientWechatpayChannelRecipientAppId, recipientAlipayChannelRecipientAccount, recipientAlipayChannelRecipientName, recipientAlipayChannelRecipientType, recipientAlipayChannelRecipientAccountType, recipientBankChannelRecipientAccount, recipientBankChannelRecipientName, recipientBankChannelRecipientType, recipientBankChannelRecipientBankName, recipientBankChannelRecipientBankBranch, recipientBankChannelRecipientBankProvince, recipientBankChannelRecipientBankCity)

更新 SettlementAccount 对象

### Example
```java
// Import classes:
//import justap.ApiClient;
//import justap.ApiException;
//import justap.Configuration;
//import justap.auth.*;
//import justap_sdk.SettlementServiceApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: ApiKeyAuth
ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
ApiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//ApiKeyAuth.setApiKeyPrefix("Token");

SettlementServiceApi apiInstance = new SettlementServiceApi();
String id = "id_example"; // String | 
String customerId = "customerId_example"; // String | 
String userId = "userId_example"; // String | 
String channel = "CHANNEL_UNKNOWN"; // String |  - ALIPAY: 分账到支付宝  - WECHANTPAY: 分账到微信支付  - BANK: 分账到银行卡  - BALANCE: 分账到 justap 账户余额
String recipientWechatpayChannelRecipientAccount = "recipientWechatpayChannelRecipientAccount_example"; // String | openid 或者商户号，由类型决定  微信支付分账接收方账户，OPENID或者商户号
String recipientWechatpayChannelRecipientName = "recipientWechatpayChannelRecipientName_example"; // String | 微信支付分账接收方姓名或名称
Boolean recipientWechatpayChannelRecipientForceCheck = false; // Boolean | 是否强制校验收款人姓名
String recipientWechatpayChannelRecipientType = "TYPE_UNSET"; // String | 微信支付分账接收方类型
String recipientWechatpayChannelRecipientAccountType = "ACCOUNT_TYPE_UNSET"; // String | 微信支付分账接收方账户类型   - ACCOUNT_TYPE_UNSET: 未设置  - MERCHANT_ID: 分账到微信商户号  - OPENID: 分账到个人微信号（父公众号的openid，或服务商的openid））  - SUB_OPENID: 分账到个人微信号，子账号的  - LOGIN_NAME: 分账到微信登录号
String recipientWechatpayChannelRecipientAppId = "recipientWechatpayChannelRecipientAppId_example"; // String | 微信支付分账接收方 openid 所对应的公众号 ID
String recipientAlipayChannelRecipientAccount = "recipientAlipayChannelRecipientAccount_example"; // String | 支付宝账号，账号ID或者登录邮箱
String recipientAlipayChannelRecipientName = "recipientAlipayChannelRecipientName_example"; // String | 支付宝账号真实姓名
String recipientAlipayChannelRecipientType = "TYPE_UNSET"; // String | 支付宝账号类型
String recipientAlipayChannelRecipientAccountType = "ACCOUNT_TYPE_UNSET"; // String | 支付宝账号类型   - ACCOUNT_TYPE_UNSET: 未设置  - MERCHANT_ID: 分账到微信商户号  - OPENID: 分账到个人微信号（父公众号的openid，或服务商的openid））  - SUB_OPENID: 分账到个人微信号，子账号的  - LOGIN_NAME: 分账到微信登录号
String recipientBankChannelRecipientAccount = "recipientBankChannelRecipientAccount_example"; // String | 银行卡号
String recipientBankChannelRecipientName = "recipientBankChannelRecipientName_example"; // String | 银行卡开户名
String recipientBankChannelRecipientType = "recipientBankChannelRecipientType_example"; // String | 银行卡类型
String recipientBankChannelRecipientBankName = "recipientBankChannelRecipientBankName_example"; // String | 银行卡开户行编码
String recipientBankChannelRecipientBankBranch = "recipientBankChannelRecipientBankBranch_example"; // String | 银行卡开户支行
String recipientBankChannelRecipientBankProvince = "recipientBankChannelRecipientBankProvince_example"; // String | 银行卡开户省份
String recipientBankChannelRecipientBankCity = "recipientBankChannelRecipientBankCity_example"; // String | 银行卡开户城市
try {
    V1SettlementAccountResponse result = apiInstance.settlementServiceUpdateSettlementAccount(id, customerId, userId, channel, recipientWechatpayChannelRecipientAccount, recipientWechatpayChannelRecipientName, recipientWechatpayChannelRecipientForceCheck, recipientWechatpayChannelRecipientType, recipientWechatpayChannelRecipientAccountType, recipientWechatpayChannelRecipientAppId, recipientAlipayChannelRecipientAccount, recipientAlipayChannelRecipientName, recipientAlipayChannelRecipientType, recipientAlipayChannelRecipientAccountType, recipientBankChannelRecipientAccount, recipientBankChannelRecipientName, recipientBankChannelRecipientType, recipientBankChannelRecipientBankName, recipientBankChannelRecipientBankBranch, recipientBankChannelRecipientBankProvince, recipientBankChannelRecipientBankCity);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SettlementServiceApi#settlementServiceUpdateSettlementAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **customerId** | **String**|  | [optional]
 **userId** | **String**|  | [optional]
 **channel** | **String**|  - ALIPAY: 分账到支付宝  - WECHANTPAY: 分账到微信支付  - BANK: 分账到银行卡  - BALANCE: 分账到 justap 账户余额 | [optional] [default to CHANNEL_UNKNOWN] [enum: CHANNEL_UNKNOWN, ALIPAY, WECHANTPAY, BANK, BALANCE]
 **recipientWechatpayChannelRecipientAccount** | **String**| openid 或者商户号，由类型决定  微信支付分账接收方账户，OPENID或者商户号 | [optional]
 **recipientWechatpayChannelRecipientName** | **String**| 微信支付分账接收方姓名或名称 | [optional]
 **recipientWechatpayChannelRecipientForceCheck** | **Boolean**| 是否强制校验收款人姓名 | [optional] [default to false]
 **recipientWechatpayChannelRecipientType** | **String**| 微信支付分账接收方类型 | [optional] [default to TYPE_UNSET] [enum: TYPE_UNSET, B2C, B2B]
 **recipientWechatpayChannelRecipientAccountType** | **String**| 微信支付分账接收方账户类型   - ACCOUNT_TYPE_UNSET: 未设置  - MERCHANT_ID: 分账到微信商户号  - OPENID: 分账到个人微信号（父公众号的openid，或服务商的openid））  - SUB_OPENID: 分账到个人微信号，子账号的  - LOGIN_NAME: 分账到微信登录号 | [optional] [default to ACCOUNT_TYPE_UNSET] [enum: ACCOUNT_TYPE_UNSET, MERCHANT_ID, OPENID, SUB_OPENID, LOGIN_NAME, USER_ID]
 **recipientWechatpayChannelRecipientAppId** | **String**| 微信支付分账接收方 openid 所对应的公众号 ID | [optional]
 **recipientAlipayChannelRecipientAccount** | **String**| 支付宝账号，账号ID或者登录邮箱 | [optional]
 **recipientAlipayChannelRecipientName** | **String**| 支付宝账号真实姓名 | [optional]
 **recipientAlipayChannelRecipientType** | **String**| 支付宝账号类型 | [optional] [default to TYPE_UNSET] [enum: TYPE_UNSET, B2C, B2B]
 **recipientAlipayChannelRecipientAccountType** | **String**| 支付宝账号类型   - ACCOUNT_TYPE_UNSET: 未设置  - MERCHANT_ID: 分账到微信商户号  - OPENID: 分账到个人微信号（父公众号的openid，或服务商的openid））  - SUB_OPENID: 分账到个人微信号，子账号的  - LOGIN_NAME: 分账到微信登录号 | [optional] [default to ACCOUNT_TYPE_UNSET] [enum: ACCOUNT_TYPE_UNSET, MERCHANT_ID, OPENID, SUB_OPENID, LOGIN_NAME, USER_ID]
 **recipientBankChannelRecipientAccount** | **String**| 银行卡号 | [optional]
 **recipientBankChannelRecipientName** | **String**| 银行卡开户名 | [optional]
 **recipientBankChannelRecipientType** | **String**| 银行卡类型 | [optional]
 **recipientBankChannelRecipientBankName** | **String**| 银行卡开户行编码 | [optional]
 **recipientBankChannelRecipientBankBranch** | **String**| 银行卡开户支行 | [optional]
 **recipientBankChannelRecipientBankProvince** | **String**| 银行卡开户省份 | [optional]
 **recipientBankChannelRecipientBankCity** | **String**| 银行卡开户城市 | [optional]

### Return type

[**V1SettlementAccountResponse**](V1SettlementAccountResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

