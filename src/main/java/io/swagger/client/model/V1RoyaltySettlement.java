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
import io.swagger.client.model.Tradev1RoyaltyMethod;
import io.swagger.client.model.V1RoyaltySettlementSource;
import io.swagger.client.model.V1RoyaltySettlementTransaction;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * V1RoyaltySettlement
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-05-13T04:16:11.137Z")
public class V1RoyaltySettlement {
  @SerializedName("amount")
  private Double amount = null;

  @SerializedName("amount_canceled")
  private Double amountCanceled = null;

  @SerializedName("amount_failed")
  private Double amountFailed = null;

  @SerializedName("amount_succeeded")
  private Double amountSucceeded = null;

  @SerializedName("app_id")
  private String appId = null;

  @SerializedName("count")
  private String count = null;

  @SerializedName("count_canceled")
  private String countCanceled = null;

  @SerializedName("count_failed")
  private String countFailed = null;

  @SerializedName("count_succeeded")
  private String countSucceeded = null;

  @SerializedName("created")
  private String created = null;

  @SerializedName("fee")
  private Double fee = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("livemode")
  private Boolean livemode = null;

  @SerializedName("metadata")
  private Map<String, String> metadata = null;

  @SerializedName("method")
  private Tradev1RoyaltyMethod method = null;

  @SerializedName("object")
  private String object = "RoyaltySettlement";

  @SerializedName("operation_url")
  private String operationUrl = null;

  @SerializedName("source")
  private V1RoyaltySettlementSource source = null;

  @SerializedName("status")
  private String status = null;

  @SerializedName("time_finished")
  private String timeFinished = null;

  @SerializedName("transactions")
  private List<V1RoyaltySettlementTransaction> transactions = null;

  public V1RoyaltySettlement amount(Double amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(value = "")
  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public V1RoyaltySettlement amountCanceled(Double amountCanceled) {
    this.amountCanceled = amountCanceled;
    return this;
  }

   /**
   * Get amountCanceled
   * @return amountCanceled
  **/
  @ApiModelProperty(value = "")
  public Double getAmountCanceled() {
    return amountCanceled;
  }

  public void setAmountCanceled(Double amountCanceled) {
    this.amountCanceled = amountCanceled;
  }

  public V1RoyaltySettlement amountFailed(Double amountFailed) {
    this.amountFailed = amountFailed;
    return this;
  }

   /**
   * Get amountFailed
   * @return amountFailed
  **/
  @ApiModelProperty(value = "")
  public Double getAmountFailed() {
    return amountFailed;
  }

  public void setAmountFailed(Double amountFailed) {
    this.amountFailed = amountFailed;
  }

  public V1RoyaltySettlement amountSucceeded(Double amountSucceeded) {
    this.amountSucceeded = amountSucceeded;
    return this;
  }

   /**
   * Get amountSucceeded
   * @return amountSucceeded
  **/
  @ApiModelProperty(value = "")
  public Double getAmountSucceeded() {
    return amountSucceeded;
  }

  public void setAmountSucceeded(Double amountSucceeded) {
    this.amountSucceeded = amountSucceeded;
  }

  public V1RoyaltySettlement appId(String appId) {
    this.appId = appId;
    return this;
  }

   /**
   * Get appId
   * @return appId
  **/
  @ApiModelProperty(value = "")
  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public V1RoyaltySettlement count(String count) {
    this.count = count;
    return this;
  }

   /**
   * Get count
   * @return count
  **/
  @ApiModelProperty(value = "")
  public String getCount() {
    return count;
  }

  public void setCount(String count) {
    this.count = count;
  }

  public V1RoyaltySettlement countCanceled(String countCanceled) {
    this.countCanceled = countCanceled;
    return this;
  }

   /**
   * Get countCanceled
   * @return countCanceled
  **/
  @ApiModelProperty(value = "")
  public String getCountCanceled() {
    return countCanceled;
  }

  public void setCountCanceled(String countCanceled) {
    this.countCanceled = countCanceled;
  }

  public V1RoyaltySettlement countFailed(String countFailed) {
    this.countFailed = countFailed;
    return this;
  }

   /**
   * Get countFailed
   * @return countFailed
  **/
  @ApiModelProperty(value = "")
  public String getCountFailed() {
    return countFailed;
  }

  public void setCountFailed(String countFailed) {
    this.countFailed = countFailed;
  }

  public V1RoyaltySettlement countSucceeded(String countSucceeded) {
    this.countSucceeded = countSucceeded;
    return this;
  }

   /**
   * Get countSucceeded
   * @return countSucceeded
  **/
  @ApiModelProperty(value = "")
  public String getCountSucceeded() {
    return countSucceeded;
  }

  public void setCountSucceeded(String countSucceeded) {
    this.countSucceeded = countSucceeded;
  }

  public V1RoyaltySettlement created(String created) {
    this.created = created;
    return this;
  }

   /**
   * Get created
   * @return created
  **/
  @ApiModelProperty(value = "")
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public V1RoyaltySettlement fee(Double fee) {
    this.fee = fee;
    return this;
  }

   /**
   * Get fee
   * @return fee
  **/
  @ApiModelProperty(value = "")
  public Double getFee() {
    return fee;
  }

  public void setFee(Double fee) {
    this.fee = fee;
  }

  public V1RoyaltySettlement id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public V1RoyaltySettlement livemode(Boolean livemode) {
    this.livemode = livemode;
    return this;
  }

   /**
   * Get livemode
   * @return livemode
  **/
  @ApiModelProperty(value = "")
  public Boolean isLivemode() {
    return livemode;
  }

  public void setLivemode(Boolean livemode) {
    this.livemode = livemode;
  }

  public V1RoyaltySettlement metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  public V1RoyaltySettlement putMetadataItem(String key, String metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }

   /**
   * Get metadata
   * @return metadata
  **/
  @ApiModelProperty(value = "")
  public Map<String, String> getMetadata() {
    return metadata;
  }

  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }

  public V1RoyaltySettlement method(Tradev1RoyaltyMethod method) {
    this.method = method;
    return this;
  }

   /**
   * Get method
   * @return method
  **/
  @ApiModelProperty(value = "")
  public Tradev1RoyaltyMethod getMethod() {
    return method;
  }

  public void setMethod(Tradev1RoyaltyMethod method) {
    this.method = method;
  }

  public V1RoyaltySettlement object(String object) {
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

  public V1RoyaltySettlement operationUrl(String operationUrl) {
    this.operationUrl = operationUrl;
    return this;
  }

   /**
   * Get operationUrl
   * @return operationUrl
  **/
  @ApiModelProperty(value = "")
  public String getOperationUrl() {
    return operationUrl;
  }

  public void setOperationUrl(String operationUrl) {
    this.operationUrl = operationUrl;
  }

  public V1RoyaltySettlement source(V1RoyaltySettlementSource source) {
    this.source = source;
    return this;
  }

   /**
   * Get source
   * @return source
  **/
  @ApiModelProperty(value = "")
  public V1RoyaltySettlementSource getSource() {
    return source;
  }

  public void setSource(V1RoyaltySettlementSource source) {
    this.source = source;
  }

  public V1RoyaltySettlement status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public V1RoyaltySettlement timeFinished(String timeFinished) {
    this.timeFinished = timeFinished;
    return this;
  }

   /**
   * Get timeFinished
   * @return timeFinished
  **/
  @ApiModelProperty(value = "")
  public String getTimeFinished() {
    return timeFinished;
  }

  public void setTimeFinished(String timeFinished) {
    this.timeFinished = timeFinished;
  }

  public V1RoyaltySettlement transactions(List<V1RoyaltySettlementTransaction> transactions) {
    this.transactions = transactions;
    return this;
  }

  public V1RoyaltySettlement addTransactionsItem(V1RoyaltySettlementTransaction transactionsItem) {
    if (this.transactions == null) {
      this.transactions = new ArrayList<>();
    }
    this.transactions.add(transactionsItem);
    return this;
  }

   /**
   * Get transactions
   * @return transactions
  **/
  @ApiModelProperty(value = "")
  public List<V1RoyaltySettlementTransaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<V1RoyaltySettlementTransaction> transactions) {
    this.transactions = transactions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1RoyaltySettlement v1RoyaltySettlement = (V1RoyaltySettlement) o;
    return Objects.equals(this.amount, v1RoyaltySettlement.amount) &&
        Objects.equals(this.amountCanceled, v1RoyaltySettlement.amountCanceled) &&
        Objects.equals(this.amountFailed, v1RoyaltySettlement.amountFailed) &&
        Objects.equals(this.amountSucceeded, v1RoyaltySettlement.amountSucceeded) &&
        Objects.equals(this.appId, v1RoyaltySettlement.appId) &&
        Objects.equals(this.count, v1RoyaltySettlement.count) &&
        Objects.equals(this.countCanceled, v1RoyaltySettlement.countCanceled) &&
        Objects.equals(this.countFailed, v1RoyaltySettlement.countFailed) &&
        Objects.equals(this.countSucceeded, v1RoyaltySettlement.countSucceeded) &&
        Objects.equals(this.created, v1RoyaltySettlement.created) &&
        Objects.equals(this.fee, v1RoyaltySettlement.fee) &&
        Objects.equals(this.id, v1RoyaltySettlement.id) &&
        Objects.equals(this.livemode, v1RoyaltySettlement.livemode) &&
        Objects.equals(this.metadata, v1RoyaltySettlement.metadata) &&
        Objects.equals(this.method, v1RoyaltySettlement.method) &&
        Objects.equals(this.object, v1RoyaltySettlement.object) &&
        Objects.equals(this.operationUrl, v1RoyaltySettlement.operationUrl) &&
        Objects.equals(this.source, v1RoyaltySettlement.source) &&
        Objects.equals(this.status, v1RoyaltySettlement.status) &&
        Objects.equals(this.timeFinished, v1RoyaltySettlement.timeFinished) &&
        Objects.equals(this.transactions, v1RoyaltySettlement.transactions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, amountCanceled, amountFailed, amountSucceeded, appId, count, countCanceled, countFailed, countSucceeded, created, fee, id, livemode, metadata, method, object, operationUrl, source, status, timeFinished, transactions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1RoyaltySettlement {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    amountCanceled: ").append(toIndentedString(amountCanceled)).append("\n");
    sb.append("    amountFailed: ").append(toIndentedString(amountFailed)).append("\n");
    sb.append("    amountSucceeded: ").append(toIndentedString(amountSucceeded)).append("\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    countCanceled: ").append(toIndentedString(countCanceled)).append("\n");
    sb.append("    countFailed: ").append(toIndentedString(countFailed)).append("\n");
    sb.append("    countSucceeded: ").append(toIndentedString(countSucceeded)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    fee: ").append(toIndentedString(fee)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    livemode: ").append(toIndentedString(livemode)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    object: ").append(toIndentedString(object)).append("\n");
    sb.append("    operationUrl: ").append(toIndentedString(operationUrl)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    timeFinished: ").append(toIndentedString(timeFinished)).append("\n");
    sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
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

