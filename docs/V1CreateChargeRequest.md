
# V1CreateChargeRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **Float** | [REQUIRED] 订单金额，单位元， 如 0.01 | 
**appId** | **String** | [REQUIRED] 应用 id | 
**body** | **String** | [REQUIRED] 服务明细 | 
**callbackUrl** | **String** | [OPTIONAL] 回调地址，如不传则使用 APP 设置中的回调地址。若都为空，则无法跳回原页面 | 
**channel** | [**Tradev1Channel**](Tradev1Channel.md) | [REQUIRED] 渠道名称 | 
**clientIp** | **String** | [REQUIRED] 客户端机器 IP | 
**currency** | **String** | 货币单位。国内收单机构仅支持 CNY | 
**description** | **String** | [OPTIONAL] 交易描述 | 
**extra** | [**V1CreateChargeRequestExtra**](V1CreateChargeRequestExtra.md) | [OPTIONAL] 各支付渠道元数据 |  [optional]
**merchantTradeId** | **String** | [REQUIRED] 客户系统的交易单号（订单号），必须在应用下唯一。长度不超过30个字符 | 
**metadata** | **Map&lt;String, String&gt;** | [OPTIONAL] 订单元数据，原样返回 |  [optional]
**notificationArea** | **String** | [OPTIONAL] 接受通知服务器所在区域，为确保消息能够送达，请选择服务器所在国家的国家码。如不填默认为 CN | 
**notifyUrl** | **String** | [OPTIONAL] 通知地址，如不传则使用 APP 设置中的通知地址。若都为空，则不发送通知 | 
**subject** | **String** | [REQUIRED] 物品或服务名称（交易标题） | 
**ttl** | **Integer** | [OPTIONAL] 订单超时时间，单位秒 | 



