
# V1Charge

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **Double** | 订单金额 | 
**amountFee** | **Float** | 下单金额 | 
**amountRefund** | **Float** | 订单退款总金额 | 
**amountRoyalty** | **Float** | 分账金额 | 
**amountSettle** | **Double** | 结算金额，不一定有，视支付通道情况返回 | 
**appId** | **String** | 应用ID | 
**body** | **String** | 订单描述信息 | 
**channel** | [**V1Channel**](V1Channel.md) | 支付渠道 | 
**chargeId** | **String** | Charge 对象 id | 
**clientIp** | **String** | 顾客IP | 
**closed** | **Boolean** | 是否关闭 | 
**closedAt** | [**OffsetDateTime**](OffsetDateTime.md) | 关闭时间 |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | Charge 对象创建时间 |  [optional]
**credential** | [**ProtobufAny**](ProtobufAny.md) | 支付凭证 |  [optional]
**currency** | **String** | 货币单位，当前仅支持 CNY | 
**description** | **String** | 描述信息 | 
**extra** | [**V1ChargeExtra**](V1ChargeExtra.md) | 支付渠道元数据 |  [optional]
**failureCode** | **String** | 收单机构错误码 | 
**failureMsg** | **String** | 收单机构错误描述信息 | 
**liveMode** | **Boolean** | 表明是否是沙箱环境 | 
**merchantTradeId** | **String** | 商户系统订单号，APP下需唯一 | 
**metadata** | **Map&lt;String, String&gt;** | 订单元数据，原样返回 |  [optional]
**paid** | **Boolean** | 表明是否已支付 | 
**paidAt** | [**OffsetDateTime**](OffsetDateTime.md) | 支付时间 |  [optional]
**refunded** | **Boolean** | 表明是否包含退款，含退款失败的 | 
**refunds** | [**List&lt;V1Refund&gt;**](V1Refund.md) | Refund 对象列表 |  [optional]
**reversed** | **Boolean** | 表明是否已经撤销 | 
**reversedAt** | [**OffsetDateTime**](OffsetDateTime.md) | 冲正时间 |  [optional]
**subject** | **String** | 订单描述主题 | 
**timeExpire** | [**OffsetDateTime**](OffsetDateTime.md) | 订单过期时间 |  [optional]
**transactionNo** | **String** | Charge 的支付单号 | 
**ttl** | **Integer** | 订单生存时间，单位秒 | 



