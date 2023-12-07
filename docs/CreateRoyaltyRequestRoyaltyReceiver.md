
# CreateRoyaltyRequestRoyaltyReceiver

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **Float** | [REQUIRED] 根据 royalty_mode 参数，如果 royalty_mode &#x3D; fixed, 则此参数传分润金额，单位元，如果 royalty_mode &#x3D; rate，此参数传百分比小数， 0.1 表示 10% | 
**fee** | **Float** | [OPTIONAL] 手续费，单位：元。 如果传递，则每笔分账都会在应分帐金额基础上扣除手续费后再请求支付平台进行分账 | 
**feeModel** | [**RoyaltyReceiverRoyaltyFeeMode**](RoyaltyReceiverRoyaltyFeeMode.md) | [OPTIONAL] 手续费模式，fixed 表示固定金额，rate 表示按比例计算手续费。此参数传手续费比例，0.1 表示 10% | 
**feeRatio** | **Float** | [OPTIONAL] 手续费比例，与 手续费 字段二选一即可ratio | 
**ratio** | **Float** | [OPTIONAL] 根据 royalty_mode 参数，如果 royalty_mode &#x3D; fixed, 此参数无效，如果 royalty_mode &#x3D; rate，此参数传分润比例，0.1 表示 10% | 
**recipientBusinessUserId** | **String** | 接受方的商业用户ID | 
**royaltyMode** | [**CreateRoyaltyRequestRoyaltyMode**](CreateRoyaltyRequestRoyaltyMode.md) | [REQUIRED] 分润模式，free 表示不收取，fixed 表示固定金额，rate 表示按比例分润 | 



