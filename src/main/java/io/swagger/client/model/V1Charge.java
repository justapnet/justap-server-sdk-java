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
import io.swagger.client.model.ProtobufAny;
import io.swagger.client.model.Tradev1Channel;
import io.swagger.client.model.V1ChargeExtra;
import io.swagger.client.model.V1Refund;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * V1Charge
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-05-13T06:31:32.932Z")
public class V1Charge {
  @SerializedName("amount")
  private Double amount = 0.0d;

  @SerializedName("amount_fee")
  private Float amountFee = null;

  @SerializedName("amount_refund")
  private Float amountRefund = null;

  @SerializedName("amount_royalty")
  private Float amountRoyalty = null;

  @SerializedName("amount_settle")
  private Double amountSettle = null;

  @SerializedName("app_id")
  private String appId = null;

  @SerializedName("body")
  private String body = null;

  @SerializedName("channel")
  private Tradev1Channel channel = null;

  @SerializedName("charge_id")
  private String chargeId = null;

  @SerializedName("client_ip")
  private String clientIp = null;

  @SerializedName("closed")
  private Boolean closed = false;

  @SerializedName("closed_at")
  private OffsetDateTime closedAt = null;

  @SerializedName("closed_ts")
  private String closedTs = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("credential")
  private ProtobufAny credential = null;

  @SerializedName("currency")
  private String currency = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("expired_ts")
  private String expiredTs = null;

  @SerializedName("extra")
  private V1ChargeExtra extra = null;

  @SerializedName("failure_code")
  private String failureCode = null;

  @SerializedName("failure_msg")
  private String failureMsg = null;

  @SerializedName("live_mode")
  private Boolean liveMode = false;

  @SerializedName("merchant_trade_id")
  private String merchantTradeId = null;

  @SerializedName("metadata")
  private Map<String, String> metadata = null;

  @SerializedName("object")
  private String object = "Charge";

  @SerializedName("paid")
  private Boolean paid = false;

  @SerializedName("paid_at")
  private OffsetDateTime paidAt = null;

  @SerializedName("paid_ts")
  private String paidTs = null;

  @SerializedName("refunded")
  private Boolean refunded = false;

  @SerializedName("refunds")
  private List<V1Refund> refunds = null;

  @SerializedName("reversed")
  private Boolean reversed = false;

  @SerializedName("reversed_at")
  private OffsetDateTime reversedAt = null;

  @SerializedName("subject")
  private String subject = null;

  @SerializedName("time_expire")
  private OffsetDateTime timeExpire = null;

  @SerializedName("transaction_no")
  private String transactionNo = null;

  @SerializedName("ttl")
  private Integer ttl = 0;

  public V1Charge amount(Double amount) {
    this.amount = amount;
    return this;
  }

   /**
   * 订单金额
   * @return amount
  **/
  @ApiModelProperty(value = "订单金额")
  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public V1Charge amountFee(Float amountFee) {
    this.amountFee = amountFee;
    return this;
  }

   /**
   * 下单金额
   * @return amountFee
  **/
  @ApiModelProperty(value = "下单金额")
  public Float getAmountFee() {
    return amountFee;
  }

  public void setAmountFee(Float amountFee) {
    this.amountFee = amountFee;
  }

  public V1Charge amountRefund(Float amountRefund) {
    this.amountRefund = amountRefund;
    return this;
  }

   /**
   * 订单退款总金额
   * @return amountRefund
  **/
  @ApiModelProperty(value = "订单退款总金额")
  public Float getAmountRefund() {
    return amountRefund;
  }

  public void setAmountRefund(Float amountRefund) {
    this.amountRefund = amountRefund;
  }

  public V1Charge amountRoyalty(Float amountRoyalty) {
    this.amountRoyalty = amountRoyalty;
    return this;
  }

   /**
   * 分账金额
   * @return amountRoyalty
  **/
  @ApiModelProperty(value = "分账金额")
  public Float getAmountRoyalty() {
    return amountRoyalty;
  }

  public void setAmountRoyalty(Float amountRoyalty) {
    this.amountRoyalty = amountRoyalty;
  }

  public V1Charge amountSettle(Double amountSettle) {
    this.amountSettle = amountSettle;
    return this;
  }

   /**
   * 结算金额，不一定有，视支付通道情况返回
   * @return amountSettle
  **/
  @ApiModelProperty(value = "结算金额，不一定有，视支付通道情况返回")
  public Double getAmountSettle() {
    return amountSettle;
  }

  public void setAmountSettle(Double amountSettle) {
    this.amountSettle = amountSettle;
  }

  public V1Charge appId(String appId) {
    this.appId = appId;
    return this;
  }

   /**
   * 应用ID
   * @return appId
  **/
  @ApiModelProperty(value = "应用ID")
  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public V1Charge body(String body) {
    this.body = body;
    return this;
  }

   /**
   * 订单描述信息
   * @return body
  **/
  @ApiModelProperty(value = "订单描述信息")
  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public V1Charge channel(Tradev1Channel channel) {
    this.channel = channel;
    return this;
  }

   /**
   * 支付渠道
   * @return channel
  **/
  @ApiModelProperty(value = "支付渠道")
  public Tradev1Channel getChannel() {
    return channel;
  }

  public void setChannel(Tradev1Channel channel) {
    this.channel = channel;
  }

  public V1Charge chargeId(String chargeId) {
    this.chargeId = chargeId;
    return this;
  }

   /**
   * Charge 对象 id
   * @return chargeId
  **/
  @ApiModelProperty(value = "Charge 对象 id")
  public String getChargeId() {
    return chargeId;
  }

  public void setChargeId(String chargeId) {
    this.chargeId = chargeId;
  }

  public V1Charge clientIp(String clientIp) {
    this.clientIp = clientIp;
    return this;
  }

   /**
   * 顾客IP
   * @return clientIp
  **/
  @ApiModelProperty(value = "顾客IP")
  public String getClientIp() {
    return clientIp;
  }

  public void setClientIp(String clientIp) {
    this.clientIp = clientIp;
  }

  public V1Charge closed(Boolean closed) {
    this.closed = closed;
    return this;
  }

   /**
   * 是否关闭
   * @return closed
  **/
  @ApiModelProperty(value = "是否关闭")
  public Boolean isClosed() {
    return closed;
  }

  public void setClosed(Boolean closed) {
    this.closed = closed;
  }

  public V1Charge closedAt(OffsetDateTime closedAt) {
    this.closedAt = closedAt;
    return this;
  }

   /**
   * 关闭时间
   * @return closedAt
  **/
  @ApiModelProperty(value = "关闭时间")
  public OffsetDateTime getClosedAt() {
    return closedAt;
  }

  public void setClosedAt(OffsetDateTime closedAt) {
    this.closedAt = closedAt;
  }

  public V1Charge closedTs(String closedTs) {
    this.closedTs = closedTs;
    return this;
  }

   /**
   * 关闭时间戳
   * @return closedTs
  **/
  @ApiModelProperty(value = "关闭时间戳")
  public String getClosedTs() {
    return closedTs;
  }

  public void setClosedTs(String closedTs) {
    this.closedTs = closedTs;
  }

  public V1Charge createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Charge 对象创建时间
   * @return createdAt
  **/
  @ApiModelProperty(value = "Charge 对象创建时间")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public V1Charge credential(ProtobufAny credential) {
    this.credential = credential;
    return this;
  }

   /**
   * 支付凭证
   * @return credential
  **/
  @ApiModelProperty(value = "支付凭证")
  public ProtobufAny getCredential() {
    return credential;
  }

  public void setCredential(ProtobufAny credential) {
    this.credential = credential;
  }

  public V1Charge currency(String currency) {
    this.currency = currency;
    return this;
  }

   /**
   * 货币单位，当前仅支持 CNY
   * @return currency
  **/
  @ApiModelProperty(value = "货币单位，当前仅支持 CNY")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public V1Charge description(String description) {
    this.description = description;
    return this;
  }

   /**
   * 描述信息
   * @return description
  **/
  @ApiModelProperty(value = "描述信息")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public V1Charge expiredTs(String expiredTs) {
    this.expiredTs = expiredTs;
    return this;
  }

   /**
   * 订单过期时间戳
   * @return expiredTs
  **/
  @ApiModelProperty(value = "订单过期时间戳")
  public String getExpiredTs() {
    return expiredTs;
  }

  public void setExpiredTs(String expiredTs) {
    this.expiredTs = expiredTs;
  }

  public V1Charge extra(V1ChargeExtra extra) {
    this.extra = extra;
    return this;
  }

   /**
   * 支付渠道元数据
   * @return extra
  **/
  @ApiModelProperty(value = "支付渠道元数据")
  public V1ChargeExtra getExtra() {
    return extra;
  }

  public void setExtra(V1ChargeExtra extra) {
    this.extra = extra;
  }

  public V1Charge failureCode(String failureCode) {
    this.failureCode = failureCode;
    return this;
  }

   /**
   * 收单机构错误码
   * @return failureCode
  **/
  @ApiModelProperty(value = "收单机构错误码")
  public String getFailureCode() {
    return failureCode;
  }

  public void setFailureCode(String failureCode) {
    this.failureCode = failureCode;
  }

  public V1Charge failureMsg(String failureMsg) {
    this.failureMsg = failureMsg;
    return this;
  }

   /**
   * 收单机构错误描述信息
   * @return failureMsg
  **/
  @ApiModelProperty(value = "收单机构错误描述信息")
  public String getFailureMsg() {
    return failureMsg;
  }

  public void setFailureMsg(String failureMsg) {
    this.failureMsg = failureMsg;
  }

  public V1Charge liveMode(Boolean liveMode) {
    this.liveMode = liveMode;
    return this;
  }

   /**
   * 表明是否是沙箱环境
   * @return liveMode
  **/
  @ApiModelProperty(value = "表明是否是沙箱环境")
  public Boolean isLiveMode() {
    return liveMode;
  }

  public void setLiveMode(Boolean liveMode) {
    this.liveMode = liveMode;
  }

  public V1Charge merchantTradeId(String merchantTradeId) {
    this.merchantTradeId = merchantTradeId;
    return this;
  }

   /**
   * 商户系统订单号，APP下需唯一
   * @return merchantTradeId
  **/
  @ApiModelProperty(value = "商户系统订单号，APP下需唯一")
  public String getMerchantTradeId() {
    return merchantTradeId;
  }

  public void setMerchantTradeId(String merchantTradeId) {
    this.merchantTradeId = merchantTradeId;
  }

  public V1Charge metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  public V1Charge putMetadataItem(String key, String metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }

   /**
   * 订单元数据，原样返回
   * @return metadata
  **/
  @ApiModelProperty(value = "订单元数据，原样返回")
  public Map<String, String> getMetadata() {
    return metadata;
  }

  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }

  public V1Charge object(String object) {
    this.object = object;
    return this;
  }

   /**
   * 对象类型
   * @return object
  **/
  @ApiModelProperty(value = "对象类型")
  public String getObject() {
    return object;
  }

  public void setObject(String object) {
    this.object = object;
  }

  public V1Charge paid(Boolean paid) {
    this.paid = paid;
    return this;
  }

   /**
   * 表明是否已支付
   * @return paid
  **/
  @ApiModelProperty(value = "表明是否已支付")
  public Boolean isPaid() {
    return paid;
  }

  public void setPaid(Boolean paid) {
    this.paid = paid;
  }

  public V1Charge paidAt(OffsetDateTime paidAt) {
    this.paidAt = paidAt;
    return this;
  }

   /**
   * 支付时间
   * @return paidAt
  **/
  @ApiModelProperty(value = "支付时间")
  public OffsetDateTime getPaidAt() {
    return paidAt;
  }

  public void setPaidAt(OffsetDateTime paidAt) {
    this.paidAt = paidAt;
  }

  public V1Charge paidTs(String paidTs) {
    this.paidTs = paidTs;
    return this;
  }

   /**
   * 支付时间戳
   * @return paidTs
  **/
  @ApiModelProperty(value = "支付时间戳")
  public String getPaidTs() {
    return paidTs;
  }

  public void setPaidTs(String paidTs) {
    this.paidTs = paidTs;
  }

  public V1Charge refunded(Boolean refunded) {
    this.refunded = refunded;
    return this;
  }

   /**
   * 表明是否包含退款，含退款失败的
   * @return refunded
  **/
  @ApiModelProperty(value = "表明是否包含退款，含退款失败的")
  public Boolean isRefunded() {
    return refunded;
  }

  public void setRefunded(Boolean refunded) {
    this.refunded = refunded;
  }

  public V1Charge refunds(List<V1Refund> refunds) {
    this.refunds = refunds;
    return this;
  }

  public V1Charge addRefundsItem(V1Refund refundsItem) {
    if (this.refunds == null) {
      this.refunds = new ArrayList<>();
    }
    this.refunds.add(refundsItem);
    return this;
  }

   /**
   * Refund 对象列表
   * @return refunds
  **/
  @ApiModelProperty(value = "Refund 对象列表")
  public List<V1Refund> getRefunds() {
    return refunds;
  }

  public void setRefunds(List<V1Refund> refunds) {
    this.refunds = refunds;
  }

  public V1Charge reversed(Boolean reversed) {
    this.reversed = reversed;
    return this;
  }

   /**
   * 表明是否已经撤销
   * @return reversed
  **/
  @ApiModelProperty(value = "表明是否已经撤销")
  public Boolean isReversed() {
    return reversed;
  }

  public void setReversed(Boolean reversed) {
    this.reversed = reversed;
  }

  public V1Charge reversedAt(OffsetDateTime reversedAt) {
    this.reversedAt = reversedAt;
    return this;
  }

   /**
   * 冲正时间
   * @return reversedAt
  **/
  @ApiModelProperty(value = "冲正时间")
  public OffsetDateTime getReversedAt() {
    return reversedAt;
  }

  public void setReversedAt(OffsetDateTime reversedAt) {
    this.reversedAt = reversedAt;
  }

  public V1Charge subject(String subject) {
    this.subject = subject;
    return this;
  }

   /**
   * 订单描述主题
   * @return subject
  **/
  @ApiModelProperty(value = "订单描述主题")
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public V1Charge timeExpire(OffsetDateTime timeExpire) {
    this.timeExpire = timeExpire;
    return this;
  }

   /**
   * 订单过期时间
   * @return timeExpire
  **/
  @ApiModelProperty(value = "订单过期时间")
  public OffsetDateTime getTimeExpire() {
    return timeExpire;
  }

  public void setTimeExpire(OffsetDateTime timeExpire) {
    this.timeExpire = timeExpire;
  }

  public V1Charge transactionNo(String transactionNo) {
    this.transactionNo = transactionNo;
    return this;
  }

   /**
   * Charge 的支付单号
   * @return transactionNo
  **/
  @ApiModelProperty(value = "Charge 的支付单号")
  public String getTransactionNo() {
    return transactionNo;
  }

  public void setTransactionNo(String transactionNo) {
    this.transactionNo = transactionNo;
  }

  public V1Charge ttl(Integer ttl) {
    this.ttl = ttl;
    return this;
  }

   /**
   * 订单生存时间，单位秒
   * @return ttl
  **/
  @ApiModelProperty(value = "订单生存时间，单位秒")
  public Integer getTtl() {
    return ttl;
  }

  public void setTtl(Integer ttl) {
    this.ttl = ttl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1Charge v1Charge = (V1Charge) o;
    return Objects.equals(this.amount, v1Charge.amount) &&
        Objects.equals(this.amountFee, v1Charge.amountFee) &&
        Objects.equals(this.amountRefund, v1Charge.amountRefund) &&
        Objects.equals(this.amountRoyalty, v1Charge.amountRoyalty) &&
        Objects.equals(this.amountSettle, v1Charge.amountSettle) &&
        Objects.equals(this.appId, v1Charge.appId) &&
        Objects.equals(this.body, v1Charge.body) &&
        Objects.equals(this.channel, v1Charge.channel) &&
        Objects.equals(this.chargeId, v1Charge.chargeId) &&
        Objects.equals(this.clientIp, v1Charge.clientIp) &&
        Objects.equals(this.closed, v1Charge.closed) &&
        Objects.equals(this.closedAt, v1Charge.closedAt) &&
        Objects.equals(this.closedTs, v1Charge.closedTs) &&
        Objects.equals(this.createdAt, v1Charge.createdAt) &&
        Objects.equals(this.credential, v1Charge.credential) &&
        Objects.equals(this.currency, v1Charge.currency) &&
        Objects.equals(this.description, v1Charge.description) &&
        Objects.equals(this.expiredTs, v1Charge.expiredTs) &&
        Objects.equals(this.extra, v1Charge.extra) &&
        Objects.equals(this.failureCode, v1Charge.failureCode) &&
        Objects.equals(this.failureMsg, v1Charge.failureMsg) &&
        Objects.equals(this.liveMode, v1Charge.liveMode) &&
        Objects.equals(this.merchantTradeId, v1Charge.merchantTradeId) &&
        Objects.equals(this.metadata, v1Charge.metadata) &&
        Objects.equals(this.object, v1Charge.object) &&
        Objects.equals(this.paid, v1Charge.paid) &&
        Objects.equals(this.paidAt, v1Charge.paidAt) &&
        Objects.equals(this.paidTs, v1Charge.paidTs) &&
        Objects.equals(this.refunded, v1Charge.refunded) &&
        Objects.equals(this.refunds, v1Charge.refunds) &&
        Objects.equals(this.reversed, v1Charge.reversed) &&
        Objects.equals(this.reversedAt, v1Charge.reversedAt) &&
        Objects.equals(this.subject, v1Charge.subject) &&
        Objects.equals(this.timeExpire, v1Charge.timeExpire) &&
        Objects.equals(this.transactionNo, v1Charge.transactionNo) &&
        Objects.equals(this.ttl, v1Charge.ttl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, amountFee, amountRefund, amountRoyalty, amountSettle, appId, body, channel, chargeId, clientIp, closed, closedAt, closedTs, createdAt, credential, currency, description, expiredTs, extra, failureCode, failureMsg, liveMode, merchantTradeId, metadata, object, paid, paidAt, paidTs, refunded, refunds, reversed, reversedAt, subject, timeExpire, transactionNo, ttl);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1Charge {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    amountFee: ").append(toIndentedString(amountFee)).append("\n");
    sb.append("    amountRefund: ").append(toIndentedString(amountRefund)).append("\n");
    sb.append("    amountRoyalty: ").append(toIndentedString(amountRoyalty)).append("\n");
    sb.append("    amountSettle: ").append(toIndentedString(amountSettle)).append("\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    chargeId: ").append(toIndentedString(chargeId)).append("\n");
    sb.append("    clientIp: ").append(toIndentedString(clientIp)).append("\n");
    sb.append("    closed: ").append(toIndentedString(closed)).append("\n");
    sb.append("    closedAt: ").append(toIndentedString(closedAt)).append("\n");
    sb.append("    closedTs: ").append(toIndentedString(closedTs)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    credential: ").append(toIndentedString(credential)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    expiredTs: ").append(toIndentedString(expiredTs)).append("\n");
    sb.append("    extra: ").append(toIndentedString(extra)).append("\n");
    sb.append("    failureCode: ").append(toIndentedString(failureCode)).append("\n");
    sb.append("    failureMsg: ").append(toIndentedString(failureMsg)).append("\n");
    sb.append("    liveMode: ").append(toIndentedString(liveMode)).append("\n");
    sb.append("    merchantTradeId: ").append(toIndentedString(merchantTradeId)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    object: ").append(toIndentedString(object)).append("\n");
    sb.append("    paid: ").append(toIndentedString(paid)).append("\n");
    sb.append("    paidAt: ").append(toIndentedString(paidAt)).append("\n");
    sb.append("    paidTs: ").append(toIndentedString(paidTs)).append("\n");
    sb.append("    refunded: ").append(toIndentedString(refunded)).append("\n");
    sb.append("    refunds: ").append(toIndentedString(refunds)).append("\n");
    sb.append("    reversed: ").append(toIndentedString(reversed)).append("\n");
    sb.append("    reversedAt: ").append(toIndentedString(reversedAt)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    timeExpire: ").append(toIndentedString(timeExpire)).append("\n");
    sb.append("    transactionNo: ").append(toIndentedString(transactionNo)).append("\n");
    sb.append("    ttl: ").append(toIndentedString(ttl)).append("\n");
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

