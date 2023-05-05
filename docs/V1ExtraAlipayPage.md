
# V1ExtraAlipayPage

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**businessParams** | [**BigDecimal**](BigDecimal.md) | 业务扩展参数 |  [optional]
**disablePayChannels** | **String** | 禁用渠道 |  [optional]
**enablePayChannels** | **String** | 可用渠道 |  [optional]
**extendParams** | [**V1ExtraAlipayExtendParams**](V1ExtraAlipayExtendParams.md) | 业务扩展参数 |  [optional]
**goodsDetail** | [**List&lt;V1ExtraAlipayGoodsDetail&gt;**](V1ExtraAlipayGoodsDetail.md) | 商品明细列表 |  [optional]
**goodsType** | **String** | 商品类型 |  [optional]
**integrationType** | [**BigDecimal**](BigDecimal.md) | 支付宝用户ID |  [optional]
**invoiceInfo** | [**V1ExtraAlipayInvoiceInfo**](V1ExtraAlipayInvoiceInfo.md) | 发票信息 |  [optional]
**merchantTradeId** | **String** | [ONLY IN RESPONSE] 商户订单号 |  [optional]
**payUrl** | **String** | [ONLY IN RESPONSE] 支付链接 |  [optional]
**promoParams** | **String** | 优惠参数 |  [optional]
**qrPayMode** | **String** | 扫码支付模式 |  [optional]
**qrcodeWidth** | [**BigDecimal**](BigDecimal.md) | 二维码宽度 |  [optional]
**requestFromUrl** | [**BigDecimal**](BigDecimal.md) | 请求来源地址 |  [optional]
**sellerId** | **String** | [ONLY IN RESPONSE] 收款支付宝用户ID |  [optional]
**storeId** | **String** | 商户门店编号 |  [optional]
**subMerchant** | [**V1ExtraAlipaySubMerchant**](V1ExtraAlipaySubMerchant.md) | 二级商户信息 |  [optional]
**timeExpire** | **Integer** | 订单失效时间 |  [optional]



