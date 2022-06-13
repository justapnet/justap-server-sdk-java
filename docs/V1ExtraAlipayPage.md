
# V1ExtraAlipayPage

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**agreementSignParams** | [**V1ExtraAlipayAgreementSignParams**](V1ExtraAlipayAgreementSignParams.md) | 签约参数。如果希望在sdk中支付并签约，需要在这里传入签约信息。周期扣款场景 product_code 为 CYCLE_PAY_AUTH 时必填。 |  [optional]
**businessParams** | [**BigDecimal**](BigDecimal.md) | 业务扩展参数 | 
**disablePayChannels** | **String** | 禁用渠道 | 
**enablePayChannels** | **String** | 可用渠道 | 
**extUserInfo** | [**V1ExtraAlipayExtUserInfo**](V1ExtraAlipayExtUserInfo.md) | 支付宝用户信息 |  [optional]
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
**royaltyInfo** | [**V1ExtraAlipayRoyaltyInfo**](V1ExtraAlipayRoyaltyInfo.md) | 分账类型卖家的分账类型，目前只支持传入ROYALTY（普通分账类型）。 |  [optional]
**sellerId** | **String** | [ONLY IN RESPONSE] 收款支付宝用户ID | 
**settleInfo** | [**V1ExtraAlipaySettleInfo**](V1ExtraAlipaySettleInfo.md) | 结算信息 |  [optional]
**storeId** | **String** | 商户门店编号 | 
**subMerchant** | [**V1ExtraAlipaySubMerchant**](V1ExtraAlipaySubMerchant.md) | 二级商户信息 |  [optional]
**timeExpire** | **Integer** | 订单失效时间 |  [optional]



