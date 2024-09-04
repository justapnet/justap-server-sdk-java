
# V1ExtraAlipayWap

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**authToken** | **String** | 授权码 | 
**businessParams** | **String** | 业务扩展参数 | 
**directPayForm** | [**ExtraAlipayPageAlipayDirectPayForm**](ExtraAlipayPageAlipayDirectPayForm.md) |  |  [optional]
**disablePayChannels** | **String** | 禁用渠道 | 
**enablePayChannels** | **String** | 可用渠道 | 
**extendParams** | [**V1ExtraAlipayExtendParams**](V1ExtraAlipayExtendParams.md) | 业务扩展参数 |  [optional]
**fundBillList** | **List&lt;String&gt;** | 支付金额信息 |  [optional]
**goodsDetail** | [**List&lt;V1ExtraAlipayGoodsDetail&gt;**](V1ExtraAlipayGoodsDetail.md) | 商品明细列表 |  [optional]
**goodsType** | **String** | 商品类型 | 
**merchantTradeId** | **String** | [ONLY IN RESPONSE] 商户订单号 | 
**payUrl** | **String** | [ONLY IN RESPONSE] 支付链接 | 
**productCode** | **String** | 销售产品码 | 
**promoParams** | **String** | 优惠参数 | 
**quitUrl** | **String** | 支付取消跳转的地址 | 
**returnUrl** | **String** | 支付成功跳转的地址 | 
**sellerId** | **String** | [ONLY IN RESPONSE] 收款支付宝用户ID | 
**storeId** | **String** | 商户门店编号 | 
**voucherDetailList** | [**V1ExtraAlipayVoucherDetailList**](V1ExtraAlipayVoucherDetailList.md) |  |  [optional]



