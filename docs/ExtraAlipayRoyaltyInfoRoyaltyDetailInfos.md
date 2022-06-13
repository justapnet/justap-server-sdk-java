
# ExtraAlipayRoyaltyInfoRoyaltyDetailInfos

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **String** | 分账的金额，单位为元 | 
**amountPercentage** | **String** | 分账的比例，值为20~100之间的整数，如：20，表示分账金额按20%来打分账 | 
**batchNo** | **String** | 分账批次号，格式为：当天日期[yyyyMMdd] + 四位流水号，如：20120220-00001 | 
**desc** | **String** | 分账描述信息 | 
**outRelationId** | **String** | 商户分账的外部关联号，用于关联到每一笔分账信息，商户可自定义，如一笔分账多笔，则需要为每一笔分账都保持唯一，如果为空，则有利于商户排查问题 | 
**serialNo** | **String** | 分账序列号，表示分账执行的顺序，必须为正整数 | 
**transIn** | **String** | 如果转入账号类型为userId，本参数为接受分账金额的支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。 如果转入账号类型为bankIndex，本参数为28位的银行编号（商户和支付宝签约时确定）。如果转入账号类型为storeId，本参数为商户的门店ID。 | 
**transInType** | **String** | 接受分账金额的账户类型： userId：支付宝账号对应的支付宝唯一用户号。 bankIndex：分账到银行账户的银行编号。目前暂时只支持分账到一个银行编号。storeId：分账到门店对应的银行卡编号。默认值为userId。 | 
**transOut** | **String** | 如果转出账号类型为userId，本参数为要分账的支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。 | 
**transOutType** | **String** | 要分账的账户类型。目前只支持userId：支付宝账号对应的支付宝唯一用户号。默认值为userId。 | 



