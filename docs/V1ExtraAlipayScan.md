
# V1ExtraAlipayScan

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**advancePaymentType** | **String** | 预授权类型 | 
**authCode** | **String** | 用户的条码 | 
**authConfirmMode** | **String** | 授权确认方式 | 
**authNo** | **String** | 授权号 | 
**buyerId** | **String** | 买家的支付宝用户id | 
**buyerLogonId** | **String** | [ONLY IN RESPONSE] 买家支付宝账号 | 
**buyerPayAmount** | **Double** | [ONLY IN RESPONSE] 付款金额 | 
**buyerUserId** | **String** | [ONLY IN RESPONSE] 买家在支付宝的用户id | 
**discountAmount** | **Double** | [ONLY IN RESPONSE] 商家优惠金额 | 
**discountGoodsDetail** | **String** | [ONLY IN RESPONSE] 商家优惠商品明细 | 
**discountableAmount** | **Double** | 可打折金额 | 
**extendParams** | [**V1ExtraAlipayExtendParams**](V1ExtraAlipayExtendParams.md) | 业务扩展参数 |  [optional]
**fundBillList** | [**V1ExtraAlipayFundBillList**](V1ExtraAlipayFundBillList.md) | [ONLY IN RESPONSE] 支付金额信息 |  [optional]
**gmtPayment** | **String** | [ONLY IN RESPONSE] 支付时间 | 
**goodsDetail** | [**List&lt;V1ExtraAlipayGoodsDetail&gt;**](V1ExtraAlipayGoodsDetail.md) | 商品明细列表 |  [optional]
**invoiceAmount** | **Double** | [ONLY IN RESPONSE] 开票金额 | 
**isAsyncPay** | [**V1ExtraAlipayPayParams**](V1ExtraAlipayPayParams.md) | 是否异步支付 |  [optional]
**operatorId** | **String** | 商户操作员编号 | 
**payParams** | **String** | [ONLY IN RESPONSE] 支付宝返回的支付参数 | 
**pointAmount** | **Double** | [ONLY IN RESPONSE] 集分宝金额 | 
**productCode** | **String** | 销售产品码 | 
**queryOptions** | **String** | 商户授权查询类型 | 
**receiptAmount** | **Double** | [ONLY IN RESPONSE] 实收金额 | 
**requestOrgPid** | **String** | 请求方机构id | 
**scene** | **String** | 支付场景 | 
**storeId** | **String** | 商户门店编号 | 
**storeName** | **String** | [ONLY IN RESPONSE] 商户门店名称 | 
**terminalId** | **String** | 商户机具终端编号 | 
**totalAmount** | **Double** | [ONLY IN RESPONSE] 订单金额 | 
**voucherDetailList** | [**V1ExtraAlipayVoucherDetailList**](V1ExtraAlipayVoucherDetailList.md) | [ONLY IN RESPONSE] 商家优惠明细列表 |  [optional]



