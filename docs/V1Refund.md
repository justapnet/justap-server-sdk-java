
# V1Refund

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**account** | [**V1RefundExtra**](V1RefundExtra.md) | 支付渠道退款元参数 |  [optional]
**amount** | **Float** | 退款金额 | 
**chargeId** | **String** | Charge 对象 id | 
**chargeMerchantTradeId** | **String** | 商户系统订单号 | 
**created** | [**BigDecimal**](BigDecimal.md) | 退款创建时间 | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | 退款创建时间 |  [optional]
**description** | **String** | 退款说明 | 
**failureCode** | **String** | 支付渠道失败错误码 | 
**failureMsg** | **String** | 支付渠道失败原因描述 | 
**isSuccess** | **Boolean** | 退款是否成功 | 
**metadata** | **Map&lt;String, String&gt;** | 元数据，原样返回 |  [optional]
**refundId** | **String** | Refund 对象 ID | 
**refundNo** | **String** | 退款单号 | 
**status** | **String** | 退款状态 | 
**succeedTs** | [**BigDecimal**](BigDecimal.md) | 退款成功时间 | 
**successAt** | [**OffsetDateTime**](OffsetDateTime.md) | 退款成功时间 |  [optional]
**transactionNo** | **String** | 交易号 | 



