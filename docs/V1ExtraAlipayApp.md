
# V1ExtraAlipayApp

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**agreementSignParams** | [**V1ExtraAlipayAgreementSignParams**](V1ExtraAlipayAgreementSignParams.md) | 签约参数。如果希望在sdk中支付并签约，需要在这里传入签约信息。周期扣款场景 product_code 为 CYCLE_PAY_AUTH 时必填。 |  [optional]
**creditAgreementId** | **String** | [ONLY IN RESPONSE] 信用支付协议号 | 
**creditBizOrderId** | **String** | [ONLY IN RESPONSE] 信用支付业务订单号 | 
**creditPayMode** | **String** | [ONLY IN RESPONSE] 信用支付模式 | 
**disablePayChannels** | **String** | 禁用渠道 | 
**enablePayChannels** | **String** | 可用渠道 | 
**extUserInfo** | [**V1ExtraAlipayExtUserInfo**](V1ExtraAlipayExtUserInfo.md) | 外部指定买家 |  [optional]
**extendParams** | [**V1ExtraAlipayExtendParams**](V1ExtraAlipayExtendParams.md) | 业务扩展参数 |  [optional]
**goodsDetail** | [**List&lt;V1ExtraAlipayGoodsDetail&gt;**](V1ExtraAlipayGoodsDetail.md) | 商品明细列表 |  [optional]
**goodsType** | **String** | 商品类型 | 
**merchantTradeId** | **String** | [ONLY IN RESPONSE] 商户订单号 | 
**payParam** | **String** | [ONLY IN RESPONSE] App 用于拉起支付的请求字符串 | 
**productCode** | **String** | 销售产品码，商家和支付宝签约的产品码 | 
**sellerId** | **String** | [ONLY IN RESPONSE] 支付宝卖家支付宝用户ID | 
**storeId** | **String** | 商户门店编号 | 



