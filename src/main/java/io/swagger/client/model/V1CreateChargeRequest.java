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
import io.swagger.client.model.Tradev1Channel;
import io.swagger.client.model.V1CreateChargeRequestExtra;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 你可以创建一个 charge 对象向用户收款。charge 是一个支付凭据对象，所有和支付相关的要素信息都存储在这个对象中，你的服务端可以通过发起支付请求来创建一个新的 charge 对象，也可以随时查询一个或者多个 charge 对象的状态。每个 charge 对象都拥有一个标识 id，该 id 在系统内唯一。
 */
@ApiModel(description = "你可以创建一个 charge 对象向用户收款。charge 是一个支付凭据对象，所有和支付相关的要素信息都存储在这个对象中，你的服务端可以通过发起支付请求来创建一个新的 charge 对象，也可以随时查询一个或者多个 charge 对象的状态。每个 charge 对象都拥有一个标识 id，该 id 在系统内唯一。")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-09-04T00:13:14.840Z")
public class V1CreateChargeRequest {
  @SerializedName("amount")
  private Float amount = null;

  @SerializedName("app_id")
  private String appId = null;

  @SerializedName("body")
  private String body = null;

  @SerializedName("callback_url")
  private String callbackUrl = null;

  @SerializedName("channel")
  private Tradev1Channel channel = null;

  @SerializedName("client_ip")
  private String clientIp = null;

  @SerializedName("currency")
  private String currency = "CNY";

  @SerializedName("description")
  private String description = null;

  @SerializedName("extra")
  private V1CreateChargeRequestExtra extra = null;

  @SerializedName("merchant_trade_id")
  private String merchantTradeId = null;

  @SerializedName("metadata")
  private Map<String, String> metadata = null;

  @SerializedName("notification_area")
  private String notificationArea = "CN";

  @SerializedName("notify_url")
  private String notifyUrl = null;

  @SerializedName("source")
  private String source = "Default";

  @SerializedName("subject")
  private String subject = null;

  @SerializedName("ttl")
  private Integer ttl = null;

  public V1CreateChargeRequest amount(Float amount) {
    this.amount = amount;
    return this;
  }

   /**
   * [REQUIRED] 订单金额，单位元， 如 0.01
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "[REQUIRED] 订单金额，单位元， 如 0.01")
  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public V1CreateChargeRequest appId(String appId) {
    this.appId = appId;
    return this;
  }

   /**
   * [REQUIRED] 应用 id
   * @return appId
  **/
  @ApiModelProperty(required = true, value = "[REQUIRED] 应用 id")
  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public V1CreateChargeRequest body(String body) {
    this.body = body;
    return this;
  }

   /**
   * [REQUIRED] 服务明细
   * @return body
  **/
  @ApiModelProperty(required = true, value = "[REQUIRED] 服务明细")
  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public V1CreateChargeRequest callbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
    return this;
  }

   /**
   * [OPTIONAL] 回调地址，如不传则使用 APP 设置中的回调地址。若都为空，则无法跳回原页面
   * @return callbackUrl
  **/
  @ApiModelProperty(required = true, value = "[OPTIONAL] 回调地址，如不传则使用 APP 设置中的回调地址。若都为空，则无法跳回原页面")
  public String getCallbackUrl() {
    return callbackUrl;
  }

  public void setCallbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
  }

  public V1CreateChargeRequest channel(Tradev1Channel channel) {
    this.channel = channel;
    return this;
  }

   /**
   * [REQUIRED] 渠道名称
   * @return channel
  **/
  @ApiModelProperty(required = true, value = "[REQUIRED] 渠道名称")
  public Tradev1Channel getChannel() {
    return channel;
  }

  public void setChannel(Tradev1Channel channel) {
    this.channel = channel;
  }

  public V1CreateChargeRequest clientIp(String clientIp) {
    this.clientIp = clientIp;
    return this;
  }

   /**
   * [REQUIRED] 客户端机器 IP
   * @return clientIp
  **/
  @ApiModelProperty(required = true, value = "[REQUIRED] 客户端机器 IP")
  public String getClientIp() {
    return clientIp;
  }

  public void setClientIp(String clientIp) {
    this.clientIp = clientIp;
  }

  public V1CreateChargeRequest currency(String currency) {
    this.currency = currency;
    return this;
  }

   /**
   * 货币单位。国内收单机构仅支持 CNY
   * @return currency
  **/
  @ApiModelProperty(required = true, value = "货币单位。国内收单机构仅支持 CNY")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public V1CreateChargeRequest description(String description) {
    this.description = description;
    return this;
  }

   /**
   * [OPTIONAL] 交易描述
   * @return description
  **/
  @ApiModelProperty(required = true, value = "[OPTIONAL] 交易描述")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public V1CreateChargeRequest extra(V1CreateChargeRequestExtra extra) {
    this.extra = extra;
    return this;
  }

   /**
   * [OPTIONAL] 各支付渠道元数据
   * @return extra
  **/
  @ApiModelProperty(value = "[OPTIONAL] 各支付渠道元数据")
  public V1CreateChargeRequestExtra getExtra() {
    return extra;
  }

  public void setExtra(V1CreateChargeRequestExtra extra) {
    this.extra = extra;
  }

  public V1CreateChargeRequest merchantTradeId(String merchantTradeId) {
    this.merchantTradeId = merchantTradeId;
    return this;
  }

   /**
   * [REQUIRED] 客户系统的交易单号（订单号），必须在应用下唯一。长度不超过30个字符
   * @return merchantTradeId
  **/
  @ApiModelProperty(required = true, value = "[REQUIRED] 客户系统的交易单号（订单号），必须在应用下唯一。长度不超过30个字符")
  public String getMerchantTradeId() {
    return merchantTradeId;
  }

  public void setMerchantTradeId(String merchantTradeId) {
    this.merchantTradeId = merchantTradeId;
  }

  public V1CreateChargeRequest metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  public V1CreateChargeRequest putMetadataItem(String key, String metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }

   /**
   * [OPTIONAL] 订单元数据，原样返回
   * @return metadata
  **/
  @ApiModelProperty(value = "[OPTIONAL] 订单元数据，原样返回")
  public Map<String, String> getMetadata() {
    return metadata;
  }

  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }

  public V1CreateChargeRequest notificationArea(String notificationArea) {
    this.notificationArea = notificationArea;
    return this;
  }

   /**
   * [OPTIONAL] 接受通知服务器所在区域，为确保消息能够送达，请选择服务器所在国家的国家码。如不填默认为 CN
   * @return notificationArea
  **/
  @ApiModelProperty(required = true, value = "[OPTIONAL] 接受通知服务器所在区域，为确保消息能够送达，请选择服务器所在国家的国家码。如不填默认为 CN")
  public String getNotificationArea() {
    return notificationArea;
  }

  public void setNotificationArea(String notificationArea) {
    this.notificationArea = notificationArea;
  }

  public V1CreateChargeRequest notifyUrl(String notifyUrl) {
    this.notifyUrl = notifyUrl;
    return this;
  }

   /**
   * [OPTIONAL] 通知地址，如不传则使用 APP 设置中的通知地址。若都为空，则不发送通知
   * @return notifyUrl
  **/
  @ApiModelProperty(required = true, value = "[OPTIONAL] 通知地址，如不传则使用 APP 设置中的通知地址。若都为空，则不发送通知")
  public String getNotifyUrl() {
    return notifyUrl;
  }

  public void setNotifyUrl(String notifyUrl) {
    this.notifyUrl = notifyUrl;
  }

  public V1CreateChargeRequest source(String source) {
    this.source = source;
    return this;
  }

   /**
   * [OPTIONAL] 支付来源。固定值: DEFAULT
   * @return source
  **/
  @ApiModelProperty(required = true, value = "[OPTIONAL] 支付来源。固定值: DEFAULT")
  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public V1CreateChargeRequest subject(String subject) {
    this.subject = subject;
    return this;
  }

   /**
   * [REQUIRED] 物品或服务名称（交易标题）
   * @return subject
  **/
  @ApiModelProperty(required = true, value = "[REQUIRED] 物品或服务名称（交易标题）")
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public V1CreateChargeRequest ttl(Integer ttl) {
    this.ttl = ttl;
    return this;
  }

   /**
   * [OPTIONAL] 订单超时时间，单位秒
   * @return ttl
  **/
  @ApiModelProperty(required = true, value = "[OPTIONAL] 订单超时时间，单位秒")
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
    V1CreateChargeRequest v1CreateChargeRequest = (V1CreateChargeRequest) o;
    return Objects.equals(this.amount, v1CreateChargeRequest.amount) &&
        Objects.equals(this.appId, v1CreateChargeRequest.appId) &&
        Objects.equals(this.body, v1CreateChargeRequest.body) &&
        Objects.equals(this.callbackUrl, v1CreateChargeRequest.callbackUrl) &&
        Objects.equals(this.channel, v1CreateChargeRequest.channel) &&
        Objects.equals(this.clientIp, v1CreateChargeRequest.clientIp) &&
        Objects.equals(this.currency, v1CreateChargeRequest.currency) &&
        Objects.equals(this.description, v1CreateChargeRequest.description) &&
        Objects.equals(this.extra, v1CreateChargeRequest.extra) &&
        Objects.equals(this.merchantTradeId, v1CreateChargeRequest.merchantTradeId) &&
        Objects.equals(this.metadata, v1CreateChargeRequest.metadata) &&
        Objects.equals(this.notificationArea, v1CreateChargeRequest.notificationArea) &&
        Objects.equals(this.notifyUrl, v1CreateChargeRequest.notifyUrl) &&
        Objects.equals(this.source, v1CreateChargeRequest.source) &&
        Objects.equals(this.subject, v1CreateChargeRequest.subject) &&
        Objects.equals(this.ttl, v1CreateChargeRequest.ttl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, appId, body, callbackUrl, channel, clientIp, currency, description, extra, merchantTradeId, metadata, notificationArea, notifyUrl, source, subject, ttl);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1CreateChargeRequest {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    clientIp: ").append(toIndentedString(clientIp)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    extra: ").append(toIndentedString(extra)).append("\n");
    sb.append("    merchantTradeId: ").append(toIndentedString(merchantTradeId)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    notificationArea: ").append(toIndentedString(notificationArea)).append("\n");
    sb.append("    notifyUrl: ").append(toIndentedString(notifyUrl)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
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

