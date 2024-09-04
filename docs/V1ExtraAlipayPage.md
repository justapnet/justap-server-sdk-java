
# V1ExtraAlipayPage

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**businessParams** | [**BigDecimal**](BigDecimal.md) | 业务扩展参数 | 
**directPayForm** | [**ExtraAlipayPageAlipayDirectPayForm**](ExtraAlipayPageAlipayDirectPayForm.md) |  |  [optional]
**disablePayChannels** | **String** | 禁用渠道 | 
**enablePayChannels** | **String** | 可用渠道 | 
**extendParams** | [**V1ExtraAlipayExtendParams**](V1ExtraAlipayExtendParams.md) | 业务扩展参数 |  [optional]
**goodsDetail** | [**List&lt;V1ExtraAlipayGoodsDetail&gt;**](V1ExtraAlipayGoodsDetail.md) | 商品明细列表 |  [optional]
**goodsType** | **String** | 商品类型 | 
**integrationType** | [**BigDecimal**](BigDecimal.md) | 支付宝用户ID | 
**invoiceInfo** | [**V1ExtraAlipayInvoiceInfo**](V1ExtraAlipayInvoiceInfo.md) | 发票信息 |  [optional]
**merchantTradeId** | **String** | [ONLY IN RESPONSE] 商户订单号 | 
**payUrl** | **String** | [ONLY IN RESPONSE] 支付链接 | 
**promoParams** | **String** | 优惠参数 | 
**qrPayMode** | **String** | 扫码支付模式 | 
**qrcodeWidth** | [**BigDecimal**](BigDecimal.md) | 二维码宽度 | 
**requestFromUrl** | [**BigDecimal**](BigDecimal.md) | 请求来源地址 | 
**sellerId** | **String** | [ONLY IN RESPONSE] 收款支付宝用户ID | 
**storeId** | **String** | 商户门店编号 | 
**subMerchant** | [**V1ExtraAlipaySubMerchant**](V1ExtraAlipaySubMerchant.md) | 二级商户信息 |  [optional]
**timeExpire** | **Integer** | 订单失效时间 |  [optional]



