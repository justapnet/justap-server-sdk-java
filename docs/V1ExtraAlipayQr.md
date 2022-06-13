
# V1ExtraAlipayQr

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**buyerId** | **String** | 买家的支付宝唯一用户号（2088开头的16位纯数字） | 
**discountableAmount** | **String** | 可打折金额. 参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 如果该值未传入，但传入了【订单总金额】，【不可打折金额】则该值默认为【订单总金额】-【不可打折金额】 |  [optional]
**goodsDetail** | [**List&lt;V1ExtraAlipayGoodsDetail&gt;**](V1ExtraAlipayGoodsDetail.md) | 商品明细列表 |  [optional]
**operatorId** | **String** | 商户操作员编号 | 
**productCode** | **String** | 销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY | 
**qrCode** | **String** | [ONLY IN RESPONSE] 二维码 | 
**qrCodeTimeoutExpress** | **String** | 支付场景。 条码支付，取值：bar_code； 声波支付，取值：wave_code | 
**qrLink** | **String** | [ONLY IN RESPONSE] 二维码图片的URL地址 | 
**queryOptions** | **String** | 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。注：若为空，则默认为15d。 |  [optional]
**storeId** | **String** | 商户门店编号 | 
**terminalId** | **String** | 商户机具终端编号 | 



