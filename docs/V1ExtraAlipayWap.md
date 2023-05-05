
# V1ExtraAlipayWap

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**authToken** | **String** | 授权码 |  [optional]
**businessParams** | **String** | 业务扩展参数 |  [optional]
**disablePayChannels** | **String** | 禁用渠道 |  [optional]
**enablePayChannels** | **String** | 可用渠道 |  [optional]
**extendParams** | [**V1ExtraAlipayExtendParams**](V1ExtraAlipayExtendParams.md) | 业务扩展参数 |  [optional]
**fundBillList** | **List&lt;String&gt;** | 支付金额信息 |  [optional]
**goodsDetail** | [**List&lt;V1ExtraAlipayGoodsDetail&gt;**](V1ExtraAlipayGoodsDetail.md) | 商品明细列表 |  [optional]
**goodsType** | **String** | 商品类型 |  [optional]
**merchantTradeId** | **String** | [ONLY IN RESPONSE] 商户订单号 |  [optional]
**payUrl** | **String** | [ONLY IN RESPONSE] 支付链接 |  [optional]
**productCode** | **String** | 销售产品码 |  [optional]
**promoParams** | **String** | 优惠参数 |  [optional]
**quitUrl** | **String** | 支付取消跳转的地址 |  [optional]
**returnUrl** | **String** | 支付成功跳转的地址 |  [optional]
**sellerId** | **String** | [ONLY IN RESPONSE] 收款支付宝用户ID |  [optional]
**storeId** | **String** | 商户门店编号 |  [optional]
**voucherDetailList** | [**V1ExtraAlipayVoucherDetailList**](V1ExtraAlipayVoucherDetailList.md) |  |  [optional]



