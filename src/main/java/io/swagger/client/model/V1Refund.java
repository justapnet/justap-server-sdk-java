/*
 * Justap API
 * 欢迎阅读 Justap Api 文档  Justap 是为移动端应用和PC端应用打造的下一代聚合支付SAAS服务平台，通过一个 SDK 即可快速的支持各种形式的应用，并且一次接口完成多个不同支付渠道的接入。平台除了支持服务商子商户模式，同时还对商家自有商户（即自己前往微信、支付宝等机构开户）提供了完整的支持。  感谢您的支持，我们将不断探索，为您提供更优质的服务！如需技术支持可前往商户中心提交工单，支持工程师会尽快与您取得联系！  # 文档说明 采用 REST 风格设计。所有接口请求地址都是可预期的以及面向资源的。使用规范的 HTTP 响应代码来表示请求结果的正确或错误信息。使用 HTTP 内置的特性，如 HTTP Authentication 和 HTTP 请求方法让接口易于理解。  ## HTTP 状态码 HTTP 状态码可以用于表明服务的状态。服务器返回的 HTTP 状态码遵循 [RFC 7231](http://tools.ietf.org/html/rfc7231#section-6) 和 [IANA Status Code Registry](http://www.iana.org/assignments/http-status-codes/http-status-codes.xhtml) 标准。  ## 认证 在调用 API 时，必须提供 API Key 作为每个请求的身份验证。你可以在管理平台内管理你的 API Key。API Key 是商户在系统中的身份标识，请安全存储，确保其不要被泄露。如需获取或更新 API Key ，也可以在商户中心内进行操作。 Api Key 在使用自定义的 HTTP Header 进行传递。  ``` X-Justap-Api-Key ```  API Key 分为 live 和 test 两种模式。分别对应真实交易环境和模拟测试交易环境并且可以实时切换。 测试模式下的 API Key 会模拟交易等请求，但是不会产生任何真实交易行为和费用，便于调试和接入。  **⚠️ 注意**：在使用 live 模式前，需要先前往 `商户中心 -> 应用设置 -> 开发参数` 开启 live 模式。  <SecurityDefinitions />  ## 请求类型 所有的 API 请求只支持 HTTPS 方式调用。  ## 路由参数 路由参数是指出现在 URL 路径中的可变变量。在本文档中，使用 `{}` 包裹的部分。 例如： `{charge_id}`，在实际使用是，需要将 `{charge_id}` 替换为实际值 `charge_8a8sdf888888`  ## MIME Type MIME 类型用于指示服务器返回的数据格式。服务器目前默认采用 `application/json`。  例如: ``` application/json ```  ## 错误 服务器使用 HTTP 状态码 (status code) 来表明一个 API 请求的成功或失败状态。返回 HTTP 2XX 表明 API 请求成功。返回 HTTP 4XX 表明在请求 API 时提供了错误信息，例如参数缺失、参数错误、支付渠道错误等。返回 HTTP 5XX 表明 API 请求时，服务器发生了错误。 在返回错误的状态码时，回同时返回一些错误信息提示出错原因。  具体的错误码我们正在整理当中。  ## 分页 所有的 Justap 资源都可以被 list API 方法支持，例如分页 charges 和 refunds。这些 list API 方法拥有相同的数据结构。Justap 是基于 cursor 的分页机制，使用参数 starting_after 来决定列表从何处开始，使用参数 ending_before 来决定列表从何处结束。  ## 参数说明 请求参数中包含的以下字段释义请参考：  - REQUIRED: 必填参数 - OPTIONAL: 可选参数，可以在请求当前接口时按需传入 - CONDITIONAL: 在某些条件下必传 - RESPONSE-ONLY: 标示该参数仅在接口返回参数中出现，调用 API 时无需传入  # 如何保证幂等性 如果发生请求超时或服务器内部错误，客户端可能会尝试重发请求。您可以在请求中设置 ClientToken 参数避免多次重试带来重复操作的问题。  ## 什么是幂等性 在数学计算或者计算机科学中，幂等性（idempotence）是指相同操作或资源在一次或多次请求中具有同样效果的作用。幂等性是在分布式系统设计中具有十分重要的地位。  ## 保证幂等性 通常情况下，客户端只需要在500（InternalErrorInternalError）或503（ServiceUnavailable）错误，或者无法获取响应结果时重试。充实时您可以从客户端生成一个参数值不超过64个的ASCII字符，并将值赋予 ClientToken，保证重试请求的幂等性。  ## ClientToken 详解 ClientToken参数的详细信息如下所示。  - ClientToken 是一个由客户端生成的唯一的、大小写敏感、不超过64个ASCII字符的字符串。例如，`ClientToken=123e4567-e89b-12d3-a456-426655440000`。 - 如果您提供了一个已经使用过的 ClientToken，但其他请求参数**有变化**，则服务器会返回 IdempotentParameterMismatch 的错误代码。 - 如果您提供了一个已经使用过的 ClientToken，且其他请求参数**不变**，则服务器会尝试返回 ClientToken 对应的记录。  ## API列表 以下为部分包含了 ClientToken 参数的API，供您参考。具体哪些API支持 ClientToken 参数请以各 API 文档为准，此处不一一列举。  - [申请退款接口](https://www.justap.cn/docs#operation/TradeService_Refunds)  # 签名 为保证安全，JUSTAP 所有接口均需要对请求进行签名。服务器收到请求后进行签名的验证。如果签名验证不通过，将会拒绝处理请求，并返回 401 Unauthorized。  签名算法：  ``` base64Encode(hamc-sha256(md5(请求 body + 请求时间戳 + 一次性随机字符串) + 一次性随机字符串)) ```  ## 准备 首先需要在 Justap 创建一个应用，商户需要生成一对 RSA 密钥对，并将公钥配置到 `商户中心 -> 开发配置`。 RSA 可以使用支付宝提供的 [密钥生成工具](https://opendocs.alipay.com/common/02kipl) 来生成。  商户在使用时，可以按照下述步骤生成请求的签名。   ## 算法描述: - 在请求发送前，取完整的**请求 body** - 生成一个随机的32位字符串，得到 **一次性随机字符串** - 获取当前时间的时间戳，得到 **请求时间戳** - 在请求字符串后面拼接上 **请求时间戳** 和 **一次性随机字符串**，得到 **待 Hash 字符串** - 对 **待 Hash 字符串** 转换为 utf8 编码并计算 md5，得到 **待签名字符串** - **待签名字符串** 后面拼接上 一次性随机字符串，得到完整的 **待签名字符串** - 使用商户 RSA 私钥，对 **待签名字符串** 计算签名，并对 结果 进行 base64 编码，即可得到 **签名**  ## 设置HTTP头 Justap 要求请求通过 自定义头部 来传递签名。具体定义如下:  ``` X-Justap-Signature: 签名 X-Justap-Request-Time: 请求时间戳 X-Justap-Nonce: 一次性随机字符串 X-Justap-Body-Hash: 待签名字符串 ```  具体的签名算法实现，可参考我们提供的各语言 SDK。  # WebHooks 
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
import io.swagger.client.model.V1RefundExtra;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Refund 对象允许你可以对已经支付的 charge 对象发起退款请求。
 */
@ApiModel(description = "Refund 对象允许你可以对已经支付的 charge 对象发起退款请求。")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-12-07T07:04:49.831Z")
public class V1Refund {
  @SerializedName("account")
  private V1RefundExtra account = null;

  @SerializedName("amount")
  private Float amount = null;

  @SerializedName("charge_id")
  private String chargeId = null;

  @SerializedName("charge_merchant_trade_id")
  private String chargeMerchantTradeId = null;

  @SerializedName("created")
  private BigDecimal created = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("failure_code")
  private String failureCode = null;

  @SerializedName("failure_msg")
  private String failureMsg = null;

  @SerializedName("is_success")
  private Boolean isSuccess = false;

  @SerializedName("metadata")
  private Map<String, String> metadata = null;

  @SerializedName("refund_id")
  private String refundId = null;

  @SerializedName("refund_no")
  private String refundNo = null;

  @SerializedName("status")
  private String status = null;

  @SerializedName("succeed_ts")
  private BigDecimal succeedTs = null;

  @SerializedName("success_at")
  private OffsetDateTime successAt = null;

  @SerializedName("transaction_no")
  private String transactionNo = null;

  public V1Refund account(V1RefundExtra account) {
    this.account = account;
    return this;
  }

   /**
   * 支付渠道退款元参数
   * @return account
  **/
  @ApiModelProperty(value = "支付渠道退款元参数")
  public V1RefundExtra getAccount() {
    return account;
  }

  public void setAccount(V1RefundExtra account) {
    this.account = account;
  }

  public V1Refund amount(Float amount) {
    this.amount = amount;
    return this;
  }

   /**
   * 退款金额
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "退款金额")
  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public V1Refund chargeId(String chargeId) {
    this.chargeId = chargeId;
    return this;
  }

   /**
   * Charge 对象 id
   * @return chargeId
  **/
  @ApiModelProperty(required = true, value = "Charge 对象 id")
  public String getChargeId() {
    return chargeId;
  }

  public void setChargeId(String chargeId) {
    this.chargeId = chargeId;
  }

  public V1Refund chargeMerchantTradeId(String chargeMerchantTradeId) {
    this.chargeMerchantTradeId = chargeMerchantTradeId;
    return this;
  }

   /**
   * 商户系统订单号
   * @return chargeMerchantTradeId
  **/
  @ApiModelProperty(required = true, value = "商户系统订单号")
  public String getChargeMerchantTradeId() {
    return chargeMerchantTradeId;
  }

  public void setChargeMerchantTradeId(String chargeMerchantTradeId) {
    this.chargeMerchantTradeId = chargeMerchantTradeId;
  }

  public V1Refund created(BigDecimal created) {
    this.created = created;
    return this;
  }

   /**
   * 退款创建时间
   * @return created
  **/
  @ApiModelProperty(required = true, value = "退款创建时间")
  public BigDecimal getCreated() {
    return created;
  }

  public void setCreated(BigDecimal created) {
    this.created = created;
  }

  public V1Refund createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * 退款创建时间
   * @return createdAt
  **/
  @ApiModelProperty(value = "退款创建时间")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public V1Refund description(String description) {
    this.description = description;
    return this;
  }

   /**
   * 退款说明
   * @return description
  **/
  @ApiModelProperty(required = true, value = "退款说明")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public V1Refund failureCode(String failureCode) {
    this.failureCode = failureCode;
    return this;
  }

   /**
   * 支付渠道失败错误码
   * @return failureCode
  **/
  @ApiModelProperty(required = true, value = "支付渠道失败错误码")
  public String getFailureCode() {
    return failureCode;
  }

  public void setFailureCode(String failureCode) {
    this.failureCode = failureCode;
  }

  public V1Refund failureMsg(String failureMsg) {
    this.failureMsg = failureMsg;
    return this;
  }

   /**
   * 支付渠道失败原因描述
   * @return failureMsg
  **/
  @ApiModelProperty(required = true, value = "支付渠道失败原因描述")
  public String getFailureMsg() {
    return failureMsg;
  }

  public void setFailureMsg(String failureMsg) {
    this.failureMsg = failureMsg;
  }

  public V1Refund isSuccess(Boolean isSuccess) {
    this.isSuccess = isSuccess;
    return this;
  }

   /**
   * 退款是否成功
   * @return isSuccess
  **/
  @ApiModelProperty(required = true, value = "退款是否成功")
  public Boolean isIsSuccess() {
    return isSuccess;
  }

  public void setIsSuccess(Boolean isSuccess) {
    this.isSuccess = isSuccess;
  }

  public V1Refund metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  public V1Refund putMetadataItem(String key, String metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }

   /**
   * 元数据，原样返回
   * @return metadata
  **/
  @ApiModelProperty(value = "元数据，原样返回")
  public Map<String, String> getMetadata() {
    return metadata;
  }

  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }

  public V1Refund refundId(String refundId) {
    this.refundId = refundId;
    return this;
  }

   /**
   * Refund 对象 ID
   * @return refundId
  **/
  @ApiModelProperty(required = true, value = "Refund 对象 ID")
  public String getRefundId() {
    return refundId;
  }

  public void setRefundId(String refundId) {
    this.refundId = refundId;
  }

  public V1Refund refundNo(String refundNo) {
    this.refundNo = refundNo;
    return this;
  }

   /**
   * 退款单号
   * @return refundNo
  **/
  @ApiModelProperty(required = true, value = "退款单号")
  public String getRefundNo() {
    return refundNo;
  }

  public void setRefundNo(String refundNo) {
    this.refundNo = refundNo;
  }

  public V1Refund status(String status) {
    this.status = status;
    return this;
  }

   /**
   * 退款状态
   * @return status
  **/
  @ApiModelProperty(required = true, value = "退款状态")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public V1Refund succeedTs(BigDecimal succeedTs) {
    this.succeedTs = succeedTs;
    return this;
  }

   /**
   * 退款成功时间
   * @return succeedTs
  **/
  @ApiModelProperty(required = true, value = "退款成功时间")
  public BigDecimal getSucceedTs() {
    return succeedTs;
  }

  public void setSucceedTs(BigDecimal succeedTs) {
    this.succeedTs = succeedTs;
  }

  public V1Refund successAt(OffsetDateTime successAt) {
    this.successAt = successAt;
    return this;
  }

   /**
   * 退款成功时间
   * @return successAt
  **/
  @ApiModelProperty(value = "退款成功时间")
  public OffsetDateTime getSuccessAt() {
    return successAt;
  }

  public void setSuccessAt(OffsetDateTime successAt) {
    this.successAt = successAt;
  }

  public V1Refund transactionNo(String transactionNo) {
    this.transactionNo = transactionNo;
    return this;
  }

   /**
   * 交易号
   * @return transactionNo
  **/
  @ApiModelProperty(required = true, value = "交易号")
  public String getTransactionNo() {
    return transactionNo;
  }

  public void setTransactionNo(String transactionNo) {
    this.transactionNo = transactionNo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1Refund v1Refund = (V1Refund) o;
    return Objects.equals(this.account, v1Refund.account) &&
        Objects.equals(this.amount, v1Refund.amount) &&
        Objects.equals(this.chargeId, v1Refund.chargeId) &&
        Objects.equals(this.chargeMerchantTradeId, v1Refund.chargeMerchantTradeId) &&
        Objects.equals(this.created, v1Refund.created) &&
        Objects.equals(this.createdAt, v1Refund.createdAt) &&
        Objects.equals(this.description, v1Refund.description) &&
        Objects.equals(this.failureCode, v1Refund.failureCode) &&
        Objects.equals(this.failureMsg, v1Refund.failureMsg) &&
        Objects.equals(this.isSuccess, v1Refund.isSuccess) &&
        Objects.equals(this.metadata, v1Refund.metadata) &&
        Objects.equals(this.refundId, v1Refund.refundId) &&
        Objects.equals(this.refundNo, v1Refund.refundNo) &&
        Objects.equals(this.status, v1Refund.status) &&
        Objects.equals(this.succeedTs, v1Refund.succeedTs) &&
        Objects.equals(this.successAt, v1Refund.successAt) &&
        Objects.equals(this.transactionNo, v1Refund.transactionNo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(account, amount, chargeId, chargeMerchantTradeId, created, createdAt, description, failureCode, failureMsg, isSuccess, metadata, refundId, refundNo, status, succeedTs, successAt, transactionNo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1Refund {\n");
    
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    chargeId: ").append(toIndentedString(chargeId)).append("\n");
    sb.append("    chargeMerchantTradeId: ").append(toIndentedString(chargeMerchantTradeId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    failureCode: ").append(toIndentedString(failureCode)).append("\n");
    sb.append("    failureMsg: ").append(toIndentedString(failureMsg)).append("\n");
    sb.append("    isSuccess: ").append(toIndentedString(isSuccess)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    refundId: ").append(toIndentedString(refundId)).append("\n");
    sb.append("    refundNo: ").append(toIndentedString(refundNo)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    succeedTs: ").append(toIndentedString(succeedTs)).append("\n");
    sb.append("    successAt: ").append(toIndentedString(successAt)).append("\n");
    sb.append("    transactionNo: ").append(toIndentedString(transactionNo)).append("\n");
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

