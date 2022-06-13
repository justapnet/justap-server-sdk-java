
# ExtraAlipayAgreementSignParamsPeriodRuleParams

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**executeTime** | **String** | 扣款执行时间execute_time是周期扣款产品必填，枚举值为TIMING和FIXED | 
**period** | **String** | 周期数period是周期扣款产品必填。与另一参数period_type组合使用确定扣款周期，例如period_type为DAY，period&#x3D;90，则扣款周期为90天 | 
**periodType** | **String** | 周期类型period_type是周期扣款产品必填，枚举值为DAY和MONTH | 
**singleAmount** | **String** | 单笔扣款金额single_amount是周期扣款产品必填，单位为元 | 
**totalAmount** | **String** | 扣款总金额total_amount是周期扣款产品必填，单位为元 | 
**totalPayments** | **String** | 扣款总笔数total_payments是周期扣款产品必填，单位为笔 | 



