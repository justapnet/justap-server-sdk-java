
# V1RoyaltySettlement

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **Float** | 结算金额 | 
**amountCanceled** | **Float** | 结算取消金额 | 
**amountFailed** | **Float** | 结算失败金额 | 
**amountSucceeded** | **Float** | 结算成功金额 | 
**appId** | **String** | 付款方 App ID | 
**count** | **Long** | 分账总笔数 | 
**countCanceled** | **Long** | 分账取消笔数 | 
**countFailed** | **Long** | 分账失败笔数 | 
**countSucceeded** | **Long** | 分账成功笔数 | 
**fee** | **Float** | 手续费 | 
**id** | **String** | 分账结算单 ID | 
**livemode** | **Boolean** |  |  [optional]
**metadata** | **Map&lt;String, String&gt;** | 元数据 | 
**object** | **String** | 对象类型 | 
**operationUrl** | **String** | 操作链接 | 
**source** | [**V1RoyaltySettlementSource**](V1RoyaltySettlementSource.md) | 分账来源 | 
**status** | [**RoyaltySettlementRoyaltySettlementStatus**](RoyaltySettlementRoyaltySettlementStatus.md) | 结算状态 | 
**timeFinished** | **Long** | 分账完成时间 | 
**transactions** | [**List&lt;V1RoyaltySettlementTransaction&gt;**](V1RoyaltySettlementTransaction.md) | 分账处理流水列表 | 



