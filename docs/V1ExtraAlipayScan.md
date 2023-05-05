
# V1ExtraAlipayScan

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**advancePaymentType** | **String** | 预授权类型 |  [optional]
**authCode** | **String** | 用户的条码 |  [optional]
**authConfirmMode** | **String** | 授权确认方式 |  [optional]
**authNo** | **String** | 授权号 |  [optional]
**buyerId** | **String** | 买家的支付宝用户id |  [optional]
**buyerLogonId** | **String** | [ONLY IN RESPONSE] 买家支付宝账号 |  [optional]
**buyerPayAmount** | **Double** | [ONLY IN RESPONSE] 付款金额 |  [optional]
**buyerUserId** | **String** | [ONLY IN RESPONSE] 买家在支付宝的用户id |  [optional]
**discountAmount** | **Double** | [ONLY IN RESPONSE] 商家优惠金额 |  [optional]
**discountGoodsDetail** | **String** | [ONLY IN RESPONSE] 商家优惠商品明细 |  [optional]
**discountableAmount** | **Double** | 可打折金额 |  [optional]
**extendParams** | [**V1ExtraAlipayExtendParams**](V1ExtraAlipayExtendParams.md) | 业务扩展参数 |  [optional]
**fundBillList** | [**V1ExtraAlipayFundBillList**](V1ExtraAlipayFundBillList.md) | [ONLY IN RESPONSE] 支付金额信息 |  [optional]
**gmtPayment** | **String** | [ONLY IN RESPONSE] 支付时间 |  [optional]
**goodsDetail** | [**List&lt;V1ExtraAlipayGoodsDetail&gt;**](V1ExtraAlipayGoodsDetail.md) | 商品明细列表 |  [optional]
**invoiceAmount** | **Double** | [ONLY IN RESPONSE] 开票金额 |  [optional]
**isAsyncPay** | [**V1ExtraAlipayPayParams**](V1ExtraAlipayPayParams.md) | 是否异步支付 |  [optional]
**operatorId** | **String** | 商户操作员编号 |  [optional]
**payParams** | **String** | [ONLY IN RESPONSE] 支付宝返回的支付参数 |  [optional]
**pointAmount** | **Double** | [ONLY IN RESPONSE] 集分宝金额 |  [optional]
**productCode** | **String** | 销售产品码 |  [optional]
**queryOptions** | **String** | 商户授权查询类型 |  [optional]
**receiptAmount** | **Double** | [ONLY IN RESPONSE] 实收金额 |  [optional]
**requestOrgPid** | **String** | 请求方机构id |  [optional]
**scene** | **String** | 支付场景 |  [optional]
**storeId** | **String** | 商户门店编号 |  [optional]
**storeName** | **String** | [ONLY IN RESPONSE] 商户门店名称 |  [optional]
**terminalId** | **String** | 商户机具终端编号 |  [optional]
**totalAmount** | **Double** | [ONLY IN RESPONSE] 订单金额 |  [optional]
**voucherDetailList** | [**V1ExtraAlipayVoucherDetailList**](V1ExtraAlipayVoucherDetailList.md) | [ONLY IN RESPONSE] 商家优惠明细列表 |  [optional]



