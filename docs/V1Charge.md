
# V1Charge

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **Double** | 订单金额 |  [optional]
**amountFee** | **Float** | 下单金额 |  [optional]
**amountRefund** | **Float** | 订单退款总金额 |  [optional]
**amountRoyalty** | **Float** | 分账金额 |  [optional]
**amountSettle** | **Double** | 结算金额，不一定有，视支付通道情况返回 |  [optional]
**appId** | **String** | 应用ID |  [optional]
**body** | **String** | 订单描述信息 |  [optional]
**channel** | [**Tradev1Channel**](Tradev1Channel.md) | 支付渠道 |  [optional]
**chargeId** | **String** | Charge 对象 id |  [optional]
**clientIp** | **String** | 顾客IP |  [optional]
**closed** | **Boolean** | 是否关闭 |  [optional]
**closedAt** | [**OffsetDateTime**](OffsetDateTime.md) | 关闭时间 |  [optional]
**closedTs** | **String** | 关闭时间戳 |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | Charge 对象创建时间 |  [optional]
**credential** | [**ProtobufAny**](ProtobufAny.md) | 支付凭证 |  [optional]
**currency** | **String** | 货币单位，当前仅支持 CNY |  [optional]
**description** | **String** | 描述信息 |  [optional]
**expiredTs** | **String** | 订单过期时间戳 |  [optional]
**extra** | [**V1ChargeExtra**](V1ChargeExtra.md) | 支付渠道元数据 |  [optional]
**failureCode** | **String** | 收单机构错误码 |  [optional]
**failureMsg** | **String** | 收单机构错误描述信息 |  [optional]
**liveMode** | **Boolean** | 表明是否是沙箱环境 |  [optional]
**merchantTradeId** | **String** | 商户系统订单号，APP下需唯一 |  [optional]
**metadata** | **Map&lt;String, String&gt;** | 订单元数据，原样返回 |  [optional]
**object** | **String** | 对象类型 |  [optional]
**paid** | **Boolean** | 表明是否已支付 |  [optional]
**paidAt** | [**OffsetDateTime**](OffsetDateTime.md) | 支付时间 |  [optional]
**paidTs** | **String** | 支付时间戳 |  [optional]
**refunded** | **Boolean** | 表明是否包含退款，含退款失败的 |  [optional]
**refunds** | [**List&lt;V1Refund&gt;**](V1Refund.md) | Refund 对象列表 |  [optional]
**reversed** | **Boolean** | 表明是否已经撤销 |  [optional]
**reversedAt** | [**OffsetDateTime**](OffsetDateTime.md) | 冲正时间 |  [optional]
**subject** | **String** | 订单描述主题 |  [optional]
**timeExpire** | [**OffsetDateTime**](OffsetDateTime.md) | 订单过期时间 |  [optional]
**transactionNo** | **String** | Charge 的支付单号 |  [optional]
**ttl** | **Integer** | 订单生存时间，单位秒 |  [optional]



