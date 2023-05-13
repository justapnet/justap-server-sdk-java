/*
 * Justap API
 * 欢迎阅读 Justap Api 文档  Justap 是为移动端应用和PC端应用打造的下一代聚合支付SAAS服务平台，通过一个 SDK 即可快速的支持各种形式的应用，并且一次接口完成多个不同支付渠道的接入。平台除了支持服务商子商户模式，同时还对商家自有商户（即自己前往微信、支付宝等机构开户）提供了完整的支持。  感谢您的支持，我们将不断探索，为您提供更优质的服务！如需技术支持可前往商户中心提交工单，支持工程师会尽快与您取得联系！  # 文档说明 采用 REST 风格设计。所有接口请求地址都是可预期的以及面向资源的。使用规范的 HTTP 响应代码来表示请求结果的正确或错误信息。使用 HTTP 内置的特性，如 HTTP Authentication 和 HTTP 请求方法让接口易于理解。  ## HTTP 状态码 HTTP 状态码可以用于表明服务的状态。服务器返回的 HTTP 状态码遵循 [RFC 7231](http://tools.ietf.org/html/rfc7231#section-6) 和 [IANA Status Code Registry](http://www.iana.org/assignments/http-status-codes/http-status-codes.xhtml) 标准。  ## 认证 在调用 API 时，必须提供 API Key 作为每个请求的身份验证。你可以在管理平台内管理你的 API Key。API Key 是商户在系统中的身份标识，请安全存储，确保其不要被泄露。如需获取或更新 API Key ，也可以在商户中心内进行操作。 Api Key 在使用自定义的 HTTP Header 进行传递。  ``` X-Justap-Api-Key ```  API Key 分为 live 和 test 两种模式。分别对应真实交易环境和模拟测试交易环境并且可以实时切换。 测试模式下的 API Key 会模拟交易等请求，但是不会产生任何真实交易行为和费用，便于调试和接入。  **⚠️ 注意**：在使用 live 模式前，需要先前往 `商户中心 -> 应用设置 -> 开发参数` 开启 live 模式。  <SecurityDefinitions />  ## 请求类型 所有的 API 请求只支持 HTTPS 方式调用。  ## 路由参数 路由参数是指出现在 URL 路径中的可变变量。在本文档中，使用 `{}` 包裹的部分。 例如： `{charge_id}`，在实际使用是，需要将 `{charge_id}` 替换为实际值 `charge_8a8sdf888888`  ## MIME Type MIME 类型用于指示服务器返回的数据格式。服务器目前默认采用 `application/json`。  例如: ``` application/json ```  ## 错误 服务器使用 HTTP 状态码 (status code) 来表明一个 API 请求的成功或失败状态。返回 HTTP 2XX 表明 API 请求成功。返回 HTTP 4XX 表明在请求 API 时提供了错误信息，例如参数缺失、参数错误、支付渠道错误等。返回 HTTP 5XX 表明 API 请求时，服务器发生了错误。 在返回错误的状态码时，回同时返回一些错误信息提示出错原因。  具体的错误码我们正在整理当中。  ## 分页 所有的 Justap 资源都可以被 list API 方法支持，例如分页 charges 和 refunds。这些 list API 方法拥有相同的数据结构。Justap 是基于 cursor 的分页机制，使用参数 starting_after 来决定列表从何处开始，使用参数 ending_before 来决定列表从何处结束。  ## 参数说明 请求参数中包含的以下字段释义请参考：  - REQUIRED: 必填参数 - OPTIONAL: 可选参数，可以在请求当前接口时按需传入 - CONDITIONAL: 在某些条件下必传 - RESPONSE-ONLY: 标示该参数仅在接口返回参数中出现，调用 API 时无需传入  # 如何保证幂等性 如果发生请求超时或服务器内部错误，客户端可能会尝试重发请求。您可以在请求中设置 ClientToken 参数避免多次重试带来重复操作的问题。  ## 什么是幂等性 在数学计算或者计算机科学中，幂等性（idempotence）是指相同操作或资源在一次或多次请求中具有同样效果的作用。幂等性是在分布式系统设计中具有十分重要的地位。  ## 保证幂等性 通常情况下，客户端只需要在500（InternalErrorInternalError）或503（ServiceUnavailable）错误，或者无法获取响应结果时重试。充实时您可以从客户端生成一个参数值不超过64个的ASCII字符，并将值赋予 ClientToken，保证重试请求的幂等性。  ## ClientToken 详解 ClientToken参数的详细信息如下所示。  - ClientToken 是一个由客户端生成的唯一的、大小写敏感、不超过64个ASCII字符的字符串。例如，`ClientToken=123e4567-e89b-12d3-a456-426655440000`。 - 如果您提供了一个已经使用过的 ClientToken，但其他请求参数**有变化**，则服务器会返回 IdempotentParameterMismatch 的错误代码。 - 如果您提供了一个已经使用过的 ClientToken，且其他请求参数**不变**，则服务器会尝试返回 ClientToken 对应的记录。  ## API列表 以下为部分包含了 ClientToken 参数的API，供您参考。具体哪些API支持 ClientToken 参数请以各 API 文档为准，此处不一一列举。  - [申请退款接口](https://www.justap.cn/docs#operation/TradeService_Refunds)  # 签名 为保证安全，JUSTAP 所有接口均需要对请求进行签名。服务器收到请求后进行签名的验证。如果签名验证不通过，将会拒绝处理请求，并返回 401 Unauthorized。  签名算法：  ``` base64Encode(hamc-sha256(md5(请求 body + 请求时间戳 + 一次性随机字符串) + 一次性随机字符串)) ```  ## 准备 首先需要在 Justap 创建一个应用，商户需要生成一对 RSA 密钥对，并将公钥配置到 `商户中心 -> 开发配置`。 RSA 可以使用支付宝提供的 [密钥生成工具](https://opendocs.alipay.com/common/02kipl) 来生成。  商户在使用时，可以按照下述步骤生成请求的签名。   ## 算法描述: - 在请求发送前，取完整的**请求 body** - 生成一个随机的32位字符串，得到 **一次性随机字符串** - 获取当前时间的时间戳，得到 **请求时间戳** - 在请求字符串后面拼接上 **请求时间戳** 和 **一次性随机字符串**，得到 **待 Hash 字符串** - 对 **待 Hash 字符串** 计算 md5，得到 **待签名字符串** - **待签名字符串** 后面拼接上 一次性随机字符串，得到完整的 **待签名字符串** - 使用商户 RSA 私钥，对 **待签名字符串** 计算签名，并对 结果 进行 base64 编码，即可得到 **签名**  ## 设置HTTP头 Justap 要求请求通过 自定义头部 来传递签名。具体定义如下:  ``` X-Justap-Signature: 签名 X-Justap-Request-Time: 请求时间戳 X-Justap-Nonce: 一次性随机字符串 X-Justap-Body-Hash: 待签名字符串 ```  具体的签名算法实现，可参考我们提供的各语言 SDK。  # WebHooks 
 *
 * OpenAPI spec version: 1.0
 * Contact: support@justap.net
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.V1ExtraWechatpayDetail;
import io.swagger.client.model.V1ExtraWechatpayPayer;
import io.swagger.client.model.V1ExtraWechatpaySceneInfo;
import io.swagger.client.model.V1ExtraWechatpaySettleInfo;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * V1ExtraWechatpayScan
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-05-13T08:52:07.806Z")
public class V1ExtraWechatpayScan {
  @SerializedName("attach")
  private String attach = null;

  @SerializedName("auth_code")
  private String authCode = null;

  @SerializedName("bank_type")
  private String bankType = null;

  @SerializedName("cash_fee")
  private String cashFee = null;

  @SerializedName("cash_fee_type")
  private String cashFeeType = null;

  @SerializedName("detail")
  private V1ExtraWechatpayDetail detail = null;

  @SerializedName("fee_type")
  private String feeType = null;

  @SerializedName("goods_tag")
  private String goodsTag = null;

  @SerializedName("is_subscribe")
  private Boolean isSubscribe = false;

  @SerializedName("payer")
  private V1ExtraWechatpayPayer payer = null;

  @SerializedName("scene_info")
  private V1ExtraWechatpaySceneInfo sceneInfo = null;

  @SerializedName("settle_info")
  private V1ExtraWechatpaySettleInfo settleInfo = null;

  @SerializedName("settlement_total_fee")
  private BigDecimal settlementTotalFee = null;

  @SerializedName("spbill_create_ip")
  private String spbillCreateIp = null;

  @SerializedName("sub_is_subscribe")
  private Boolean subIsSubscribe = false;

  @SerializedName("sub_openid")
  private String subOpenid = null;

  @SerializedName("time_end")
  private String timeEnd = null;

  @SerializedName("time_expire")
  private String timeExpire = null;

  @SerializedName("time_start")
  private String timeStart = null;

  public V1ExtraWechatpayScan attach(String attach) {
    this.attach = attach;
    return this;
  }

   /**
   * 元数据
   * @return attach
  **/
  @ApiModelProperty(value = "元数据")
  public String getAttach() {
    return attach;
  }

  public void setAttach(String attach) {
    this.attach = attach;
  }

  public V1ExtraWechatpayScan authCode(String authCode) {
    this.authCode = authCode;
    return this;
  }

   /**
   * 授权码
   * @return authCode
  **/
  @ApiModelProperty(value = "授权码")
  public String getAuthCode() {
    return authCode;
  }

  public void setAuthCode(String authCode) {
    this.authCode = authCode;
  }

  public V1ExtraWechatpayScan bankType(String bankType) {
    this.bankType = bankType;
    return this;
  }

   /**
   * 付款银行
   * @return bankType
  **/
  @ApiModelProperty(value = "付款银行")
  public String getBankType() {
    return bankType;
  }

  public void setBankType(String bankType) {
    this.bankType = bankType;
  }

  public V1ExtraWechatpayScan cashFee(String cashFee) {
    this.cashFee = cashFee;
    return this;
  }

   /**
   * 现金支付金额
   * @return cashFee
  **/
  @ApiModelProperty(value = "现金支付金额")
  public String getCashFee() {
    return cashFee;
  }

  public void setCashFee(String cashFee) {
    this.cashFee = cashFee;
  }

  public V1ExtraWechatpayScan cashFeeType(String cashFeeType) {
    this.cashFeeType = cashFeeType;
    return this;
  }

   /**
   * 现金支付币种
   * @return cashFeeType
  **/
  @ApiModelProperty(value = "现金支付币种")
  public String getCashFeeType() {
    return cashFeeType;
  }

  public void setCashFeeType(String cashFeeType) {
    this.cashFeeType = cashFeeType;
  }

  public V1ExtraWechatpayScan detail(V1ExtraWechatpayDetail detail) {
    this.detail = detail;
    return this;
  }

   /**
   * 商品详情
   * @return detail
  **/
  @ApiModelProperty(value = "商品详情")
  public V1ExtraWechatpayDetail getDetail() {
    return detail;
  }

  public void setDetail(V1ExtraWechatpayDetail detail) {
    this.detail = detail;
  }

  public V1ExtraWechatpayScan feeType(String feeType) {
    this.feeType = feeType;
    return this;
  }

   /**
   * 货币种类
   * @return feeType
  **/
  @ApiModelProperty(value = "货币种类")
  public String getFeeType() {
    return feeType;
  }

  public void setFeeType(String feeType) {
    this.feeType = feeType;
  }

  public V1ExtraWechatpayScan goodsTag(String goodsTag) {
    this.goodsTag = goodsTag;
    return this;
  }

   /**
   * 订单优惠标记
   * @return goodsTag
  **/
  @ApiModelProperty(value = "订单优惠标记")
  public String getGoodsTag() {
    return goodsTag;
  }

  public void setGoodsTag(String goodsTag) {
    this.goodsTag = goodsTag;
  }

  public V1ExtraWechatpayScan isSubscribe(Boolean isSubscribe) {
    this.isSubscribe = isSubscribe;
    return this;
  }

   /**
   * 是否关注公众账号
   * @return isSubscribe
  **/
  @ApiModelProperty(value = "是否关注公众账号")
  public Boolean isIsSubscribe() {
    return isSubscribe;
  }

  public void setIsSubscribe(Boolean isSubscribe) {
    this.isSubscribe = isSubscribe;
  }

  public V1ExtraWechatpayScan payer(V1ExtraWechatpayPayer payer) {
    this.payer = payer;
    return this;
  }

   /**
   * 付款人信息
   * @return payer
  **/
  @ApiModelProperty(value = "付款人信息")
  public V1ExtraWechatpayPayer getPayer() {
    return payer;
  }

  public void setPayer(V1ExtraWechatpayPayer payer) {
    this.payer = payer;
  }

  public V1ExtraWechatpayScan sceneInfo(V1ExtraWechatpaySceneInfo sceneInfo) {
    this.sceneInfo = sceneInfo;
    return this;
  }

   /**
   * 场景信息
   * @return sceneInfo
  **/
  @ApiModelProperty(value = "场景信息")
  public V1ExtraWechatpaySceneInfo getSceneInfo() {
    return sceneInfo;
  }

  public void setSceneInfo(V1ExtraWechatpaySceneInfo sceneInfo) {
    this.sceneInfo = sceneInfo;
  }

  public V1ExtraWechatpayScan settleInfo(V1ExtraWechatpaySettleInfo settleInfo) {
    this.settleInfo = settleInfo;
    return this;
  }

   /**
   * 结算信息
   * @return settleInfo
  **/
  @ApiModelProperty(value = "结算信息")
  public V1ExtraWechatpaySettleInfo getSettleInfo() {
    return settleInfo;
  }

  public void setSettleInfo(V1ExtraWechatpaySettleInfo settleInfo) {
    this.settleInfo = settleInfo;
  }

  public V1ExtraWechatpayScan settlementTotalFee(BigDecimal settlementTotalFee) {
    this.settlementTotalFee = settlementTotalFee;
    return this;
  }

   /**
   * 应结订单金额
   * @return settlementTotalFee
  **/
  @ApiModelProperty(value = "应结订单金额")
  public BigDecimal getSettlementTotalFee() {
    return settlementTotalFee;
  }

  public void setSettlementTotalFee(BigDecimal settlementTotalFee) {
    this.settlementTotalFee = settlementTotalFee;
  }

  public V1ExtraWechatpayScan spbillCreateIp(String spbillCreateIp) {
    this.spbillCreateIp = spbillCreateIp;
    return this;
  }

   /**
   * 终端IP
   * @return spbillCreateIp
  **/
  @ApiModelProperty(value = "终端IP")
  public String getSpbillCreateIp() {
    return spbillCreateIp;
  }

  public void setSpbillCreateIp(String spbillCreateIp) {
    this.spbillCreateIp = spbillCreateIp;
  }

  public V1ExtraWechatpayScan subIsSubscribe(Boolean subIsSubscribe) {
    this.subIsSubscribe = subIsSubscribe;
    return this;
  }

   /**
   * 子商户是否关注公众账号
   * @return subIsSubscribe
  **/
  @ApiModelProperty(value = "子商户是否关注公众账号")
  public Boolean isSubIsSubscribe() {
    return subIsSubscribe;
  }

  public void setSubIsSubscribe(Boolean subIsSubscribe) {
    this.subIsSubscribe = subIsSubscribe;
  }

  public V1ExtraWechatpayScan subOpenid(String subOpenid) {
    this.subOpenid = subOpenid;
    return this;
  }

   /**
   * 子商户openid
   * @return subOpenid
  **/
  @ApiModelProperty(value = "子商户openid")
  public String getSubOpenid() {
    return subOpenid;
  }

  public void setSubOpenid(String subOpenid) {
    this.subOpenid = subOpenid;
  }

  public V1ExtraWechatpayScan timeEnd(String timeEnd) {
    this.timeEnd = timeEnd;
    return this;
  }

   /**
   * 支付完成时间
   * @return timeEnd
  **/
  @ApiModelProperty(value = "支付完成时间")
  public String getTimeEnd() {
    return timeEnd;
  }

  public void setTimeEnd(String timeEnd) {
    this.timeEnd = timeEnd;
  }

  public V1ExtraWechatpayScan timeExpire(String timeExpire) {
    this.timeExpire = timeExpire;
    return this;
  }

   /**
   * 交易结束时间
   * @return timeExpire
  **/
  @ApiModelProperty(value = "交易结束时间")
  public String getTimeExpire() {
    return timeExpire;
  }

  public void setTimeExpire(String timeExpire) {
    this.timeExpire = timeExpire;
  }

  public V1ExtraWechatpayScan timeStart(String timeStart) {
    this.timeStart = timeStart;
    return this;
  }

   /**
   * 交易起始时间
   * @return timeStart
  **/
  @ApiModelProperty(value = "交易起始时间")
  public String getTimeStart() {
    return timeStart;
  }

  public void setTimeStart(String timeStart) {
    this.timeStart = timeStart;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1ExtraWechatpayScan v1ExtraWechatpayScan = (V1ExtraWechatpayScan) o;
    return Objects.equals(this.attach, v1ExtraWechatpayScan.attach) &&
        Objects.equals(this.authCode, v1ExtraWechatpayScan.authCode) &&
        Objects.equals(this.bankType, v1ExtraWechatpayScan.bankType) &&
        Objects.equals(this.cashFee, v1ExtraWechatpayScan.cashFee) &&
        Objects.equals(this.cashFeeType, v1ExtraWechatpayScan.cashFeeType) &&
        Objects.equals(this.detail, v1ExtraWechatpayScan.detail) &&
        Objects.equals(this.feeType, v1ExtraWechatpayScan.feeType) &&
        Objects.equals(this.goodsTag, v1ExtraWechatpayScan.goodsTag) &&
        Objects.equals(this.isSubscribe, v1ExtraWechatpayScan.isSubscribe) &&
        Objects.equals(this.payer, v1ExtraWechatpayScan.payer) &&
        Objects.equals(this.sceneInfo, v1ExtraWechatpayScan.sceneInfo) &&
        Objects.equals(this.settleInfo, v1ExtraWechatpayScan.settleInfo) &&
        Objects.equals(this.settlementTotalFee, v1ExtraWechatpayScan.settlementTotalFee) &&
        Objects.equals(this.spbillCreateIp, v1ExtraWechatpayScan.spbillCreateIp) &&
        Objects.equals(this.subIsSubscribe, v1ExtraWechatpayScan.subIsSubscribe) &&
        Objects.equals(this.subOpenid, v1ExtraWechatpayScan.subOpenid) &&
        Objects.equals(this.timeEnd, v1ExtraWechatpayScan.timeEnd) &&
        Objects.equals(this.timeExpire, v1ExtraWechatpayScan.timeExpire) &&
        Objects.equals(this.timeStart, v1ExtraWechatpayScan.timeStart);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attach, authCode, bankType, cashFee, cashFeeType, detail, feeType, goodsTag, isSubscribe, payer, sceneInfo, settleInfo, settlementTotalFee, spbillCreateIp, subIsSubscribe, subOpenid, timeEnd, timeExpire, timeStart);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1ExtraWechatpayScan {\n");
    
    sb.append("    attach: ").append(toIndentedString(attach)).append("\n");
    sb.append("    authCode: ").append(toIndentedString(authCode)).append("\n");
    sb.append("    bankType: ").append(toIndentedString(bankType)).append("\n");
    sb.append("    cashFee: ").append(toIndentedString(cashFee)).append("\n");
    sb.append("    cashFeeType: ").append(toIndentedString(cashFeeType)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    feeType: ").append(toIndentedString(feeType)).append("\n");
    sb.append("    goodsTag: ").append(toIndentedString(goodsTag)).append("\n");
    sb.append("    isSubscribe: ").append(toIndentedString(isSubscribe)).append("\n");
    sb.append("    payer: ").append(toIndentedString(payer)).append("\n");
    sb.append("    sceneInfo: ").append(toIndentedString(sceneInfo)).append("\n");
    sb.append("    settleInfo: ").append(toIndentedString(settleInfo)).append("\n");
    sb.append("    settlementTotalFee: ").append(toIndentedString(settlementTotalFee)).append("\n");
    sb.append("    spbillCreateIp: ").append(toIndentedString(spbillCreateIp)).append("\n");
    sb.append("    subIsSubscribe: ").append(toIndentedString(subIsSubscribe)).append("\n");
    sb.append("    subOpenid: ").append(toIndentedString(subOpenid)).append("\n");
    sb.append("    timeEnd: ").append(toIndentedString(timeEnd)).append("\n");
    sb.append("    timeExpire: ").append(toIndentedString(timeExpire)).append("\n");
    sb.append("    timeStart: ").append(toIndentedString(timeStart)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

