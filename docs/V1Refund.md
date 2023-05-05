
# V1Refund

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**account** | [**V1RefundExtra**](V1RefundExtra.md) | 支付渠道退款元参数 |  [optional]
**amount** | **Float** | 退款金额 |  [optional]
**chargeId** | **String** | Charge 对象 id |  [optional]
**chargeMerchantTradeId** | **String** | 商户系统订单号 |  [optional]
**created** | [**BigDecimal**](BigDecimal.md) | 退款创建时间 |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | 退款创建时间 |  [optional]
**description** | **String** | 退款说明 |  [optional]
**failureCode** | **String** | 支付渠道失败错误码 |  [optional]
**failureMsg** | **String** | 支付渠道失败原因描述 |  [optional]
**isSuccess** | **Boolean** | 退款是否成功 |  [optional]
**metadata** | **Map&lt;String, String&gt;** | 元数据，原样返回 |  [optional]
**refundId** | **String** | Refund 对象 ID |  [optional]
**refundNo** | **String** | 退款单号 |  [optional]
**status** | **String** | 退款状态 |  [optional]
**succeedTs** | [**BigDecimal**](BigDecimal.md) | 退款成功时间 |  [optional]
**successAt** | [**OffsetDateTime**](OffsetDateTime.md) | 退款成功时间 |  [optional]
**transactionNo** | **String** | 交易号 |  [optional]



