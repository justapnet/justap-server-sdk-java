
# V1ExtraAlipayAgreementSignParams

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accessParams** | [**ExtraAlipayAgreementSignParamsAccessParams**](ExtraAlipayAgreementSignParamsAccessParams.md) | 请按当前接入的方式进行填充，且输入值必须为文档中的参数取值范围 |  [optional]
**externalAgreementNo** | **String** | 外部协议号 | 
**externalLogonId** | **String** | 外部用户唯一标识 | 
**periodRuleParams** | [**ExtraAlipayAgreementSignParamsPeriodRuleParams**](ExtraAlipayAgreementSignParamsPeriodRuleParams.md) | 周期管控规则参数period_rule_params，在签约周期扣款产品（如CYCLE_PAY_AUTH_P）时必传，在签约其他产品时无需传入。 周期扣款产品，会按照这里传入的参数提示用户，并对发起扣款的时间、金额、次数等做相应限制。 |  [optional]
**personalProductCode** | **String** | 个人签约产品码 | 
**signNotifyUrl** | **String** | 签约回调地址 | 
**signScene** | **String** | 签约场景 | 
**subMerchant** | [**ExtraAlipayAgreementSignParamsSubMerchant**](ExtraAlipayAgreementSignParamsSubMerchant.md) | 此参数用于传递子商户信息，无特殊需求时不用关注。目前商户代扣、海外代扣、淘旅行信用住产品支持传入该参数（在销售方案中“是否允许自定义子商户信息”需要选是）。 |  [optional]



