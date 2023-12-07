
# V1ExtraWechatpayScan

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**attach** | **String** | 元数据 |  [optional]
**authCode** | **String** | 授权码 | 
**bankType** | **String** | 付款银行 | 
**cashFee** | **String** | 现金支付金额 | 
**cashFeeType** | **String** | 现金支付币种 | 
**detail** | [**V1ExtraWechatpayDetail**](V1ExtraWechatpayDetail.md) | 商品详情 |  [optional]
**feeType** | **String** | 货币种类 | 
**goodsTag** | **String** | 订单优惠标记 | 
**isSubscribe** | **Boolean** | 是否关注公众账号 | 
**payer** | [**V1ExtraWechatpayPayer**](V1ExtraWechatpayPayer.md) | 付款人信息 |  [optional]
**sceneInfo** | [**V1ExtraWechatpaySceneInfo**](V1ExtraWechatpaySceneInfo.md) | 场景信息 |  [optional]
**settleInfo** | [**V1ExtraWechatpaySettleInfo**](V1ExtraWechatpaySettleInfo.md) | 结算信息 |  [optional]
**settlementTotalFee** | [**BigDecimal**](BigDecimal.md) | 应结订单金额 | 
**spbillCreateIp** | **String** | 终端IP | 
**subIsSubscribe** | **Boolean** | 子商户是否关注公众账号 | 
**subOpenid** | **String** | 子商户openid | 
**timeEnd** | **String** | 支付完成时间 | 
**timeExpire** | **String** | 交易结束时间 | 
**timeStart** | **String** | 交易起始时间 | 



