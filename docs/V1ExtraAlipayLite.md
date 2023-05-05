
# V1ExtraAlipayLite

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**body** | **String** | 商品描述 |  [optional]
**businessParams** | [**V1ExtraAlipayBusinessParams**](V1ExtraAlipayBusinessParams.md) | 业务扩展参数 |  [optional]
**buyerId** | **String** | 买家的支付宝唯一用户号（2088开头的16位纯数字） |  [optional]
**discountableAmount** | **Double** | 可打折金额. 参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 如果该值未传入，但传入了【订单总金额】，【不可打折金额】则该值默认为【订单总金额】-【不可打折金额】 |  [optional]
**extendParams** | [**V1ExtraAlipayExtendParams**](V1ExtraAlipayExtendParams.md) | 业务扩展参数 |  [optional]
**logisticsDetail** | [**V1ExtraAlipayLogisticsDetail**](V1ExtraAlipayLogisticsDetail.md) | 物流信息 |  [optional]
**operatorId** | **String** | 商户操作员编号 |  [optional]
**productCode** | **String** | 销售产品码，商家和支付宝签约的产品码，为固定值 FACE_TO_FACE_PAYMENT |  [optional]
**receiverAddressInfo** | [**V1ExtraAlipayReceiverAddressInfo**](V1ExtraAlipayReceiverAddressInfo.md) | 收货信息 |  [optional]
**sellerId** | **String** | 卖家支付宝用户号 |  [optional]
**settleInfo** | [**V1ExtraAlipaySettleInfo**](V1ExtraAlipaySettleInfo.md) | 结算信息 |  [optional]
**storeId** | **String** | 商户门店编号 |  [optional]
**terminalId** | **String** | 商户机具终端编号 |  [optional]
**timeExpire** | **String** | 绝对超时时间，格式为yyyy-MM-dd HH:mm:ss |  [optional]
**timeoutExpress** | **String** | 订单有效时间，该时间段内订单可以进行支付，结束后订单将关闭，天数为0表示永久有效 |  [optional]
**tradeNo** | **String** | [ONLY IN RESPONSE] 支付宝交易号 |  [optional]
**undiscountableAmount** | **Double** | 不可打折金额. 不参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 如果该值未传入，但传入了【订单总金额】,【可打折金额】，则该值默认为【订单总金额】-【可打折金额】 |  [optional]



