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
import io.swagger.client.model.V1ExtraAlipayExtUserInfo;
import io.swagger.client.model.V1ExtraAlipayExtendParams;
import io.swagger.client.model.V1ExtraAlipayGoodsDetail;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * V1ExtraAlipayApp
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-05-13T06:44:38.071Z")
public class V1ExtraAlipayApp {
  @SerializedName("credit_agreement_id")
  private String creditAgreementId = null;

  @SerializedName("credit_biz_order_id")
  private String creditBizOrderId = null;

  @SerializedName("credit_pay_mode")
  private String creditPayMode = null;

  @SerializedName("disable_pay_channels")
  private String disablePayChannels = null;

  @SerializedName("enable_pay_channels")
  private String enablePayChannels = null;

  @SerializedName("ext_user_info")
  private V1ExtraAlipayExtUserInfo extUserInfo = null;

  @SerializedName("extend_params")
  private V1ExtraAlipayExtendParams extendParams = null;

  @SerializedName("goods_detail")
  private List<V1ExtraAlipayGoodsDetail> goodsDetail = null;

  @SerializedName("goods_type")
  private String goodsType = null;

  @SerializedName("merchant_trade_id")
  private String merchantTradeId = null;

  @SerializedName("pay_param")
  private String payParam = null;

  @SerializedName("product_code")
  private String productCode = null;

  @SerializedName("seller_id")
  private String sellerId = null;

  @SerializedName("store_id")
  private String storeId = null;

  public V1ExtraAlipayApp creditAgreementId(String creditAgreementId) {
    this.creditAgreementId = creditAgreementId;
    return this;
  }

   /**
   * [ONLY IN RESPONSE] 信用支付协议号
   * @return creditAgreementId
  **/
  @ApiModelProperty(value = "[ONLY IN RESPONSE] 信用支付协议号")
  public String getCreditAgreementId() {
    return creditAgreementId;
  }

  public void setCreditAgreementId(String creditAgreementId) {
    this.creditAgreementId = creditAgreementId;
  }

  public V1ExtraAlipayApp creditBizOrderId(String creditBizOrderId) {
    this.creditBizOrderId = creditBizOrderId;
    return this;
  }

   /**
   * [ONLY IN RESPONSE] 信用支付业务订单号
   * @return creditBizOrderId
  **/
  @ApiModelProperty(value = "[ONLY IN RESPONSE] 信用支付业务订单号")
  public String getCreditBizOrderId() {
    return creditBizOrderId;
  }

  public void setCreditBizOrderId(String creditBizOrderId) {
    this.creditBizOrderId = creditBizOrderId;
  }

  public V1ExtraAlipayApp creditPayMode(String creditPayMode) {
    this.creditPayMode = creditPayMode;
    return this;
  }

   /**
   * [ONLY IN RESPONSE] 信用支付模式
   * @return creditPayMode
  **/
  @ApiModelProperty(value = "[ONLY IN RESPONSE] 信用支付模式")
  public String getCreditPayMode() {
    return creditPayMode;
  }

  public void setCreditPayMode(String creditPayMode) {
    this.creditPayMode = creditPayMode;
  }

  public V1ExtraAlipayApp disablePayChannels(String disablePayChannels) {
    this.disablePayChannels = disablePayChannels;
    return this;
  }

   /**
   * 禁用渠道
   * @return disablePayChannels
  **/
  @ApiModelProperty(value = "禁用渠道")
  public String getDisablePayChannels() {
    return disablePayChannels;
  }

  public void setDisablePayChannels(String disablePayChannels) {
    this.disablePayChannels = disablePayChannels;
  }

  public V1ExtraAlipayApp enablePayChannels(String enablePayChannels) {
    this.enablePayChannels = enablePayChannels;
    return this;
  }

   /**
   * 可用渠道
   * @return enablePayChannels
  **/
  @ApiModelProperty(value = "可用渠道")
  public String getEnablePayChannels() {
    return enablePayChannels;
  }

  public void setEnablePayChannels(String enablePayChannels) {
    this.enablePayChannels = enablePayChannels;
  }

  public V1ExtraAlipayApp extUserInfo(V1ExtraAlipayExtUserInfo extUserInfo) {
    this.extUserInfo = extUserInfo;
    return this;
  }

   /**
   * 外部指定买家
   * @return extUserInfo
  **/
  @ApiModelProperty(value = "外部指定买家")
  public V1ExtraAlipayExtUserInfo getExtUserInfo() {
    return extUserInfo;
  }

  public void setExtUserInfo(V1ExtraAlipayExtUserInfo extUserInfo) {
    this.extUserInfo = extUserInfo;
  }

  public V1ExtraAlipayApp extendParams(V1ExtraAlipayExtendParams extendParams) {
    this.extendParams = extendParams;
    return this;
  }

   /**
   * 业务扩展参数
   * @return extendParams
  **/
  @ApiModelProperty(value = "业务扩展参数")
  public V1ExtraAlipayExtendParams getExtendParams() {
    return extendParams;
  }

  public void setExtendParams(V1ExtraAlipayExtendParams extendParams) {
    this.extendParams = extendParams;
  }

  public V1ExtraAlipayApp goodsDetail(List<V1ExtraAlipayGoodsDetail> goodsDetail) {
    this.goodsDetail = goodsDetail;
    return this;
  }

  public V1ExtraAlipayApp addGoodsDetailItem(V1ExtraAlipayGoodsDetail goodsDetailItem) {
    if (this.goodsDetail == null) {
      this.goodsDetail = new ArrayList<>();
    }
    this.goodsDetail.add(goodsDetailItem);
    return this;
  }

   /**
   * 商品明细列表
   * @return goodsDetail
  **/
  @ApiModelProperty(value = "商品明细列表")
  public List<V1ExtraAlipayGoodsDetail> getGoodsDetail() {
    return goodsDetail;
  }

  public void setGoodsDetail(List<V1ExtraAlipayGoodsDetail> goodsDetail) {
    this.goodsDetail = goodsDetail;
  }

  public V1ExtraAlipayApp goodsType(String goodsType) {
    this.goodsType = goodsType;
    return this;
  }

   /**
   * 商品类型
   * @return goodsType
  **/
  @ApiModelProperty(value = "商品类型")
  public String getGoodsType() {
    return goodsType;
  }

  public void setGoodsType(String goodsType) {
    this.goodsType = goodsType;
  }

  public V1ExtraAlipayApp merchantTradeId(String merchantTradeId) {
    this.merchantTradeId = merchantTradeId;
    return this;
  }

   /**
   * [ONLY IN RESPONSE] 商户订单号
   * @return merchantTradeId
  **/
  @ApiModelProperty(value = "[ONLY IN RESPONSE] 商户订单号")
  public String getMerchantTradeId() {
    return merchantTradeId;
  }

  public void setMerchantTradeId(String merchantTradeId) {
    this.merchantTradeId = merchantTradeId;
  }

  public V1ExtraAlipayApp payParam(String payParam) {
    this.payParam = payParam;
    return this;
  }

   /**
   * [ONLY IN RESPONSE] App 用于拉起支付的请求字符串
   * @return payParam
  **/
  @ApiModelProperty(value = "[ONLY IN RESPONSE] App 用于拉起支付的请求字符串")
  public String getPayParam() {
    return payParam;
  }

  public void setPayParam(String payParam) {
    this.payParam = payParam;
  }

  public V1ExtraAlipayApp productCode(String productCode) {
    this.productCode = productCode;
    return this;
  }

   /**
   * 销售产品码，商家和支付宝签约的产品码
   * @return productCode
  **/
  @ApiModelProperty(value = "销售产品码，商家和支付宝签约的产品码")
  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public V1ExtraAlipayApp sellerId(String sellerId) {
    this.sellerId = sellerId;
    return this;
  }

   /**
   * [ONLY IN RESPONSE] 支付宝卖家支付宝用户ID
   * @return sellerId
  **/
  @ApiModelProperty(value = "[ONLY IN RESPONSE] 支付宝卖家支付宝用户ID")
  public String getSellerId() {
    return sellerId;
  }

  public void setSellerId(String sellerId) {
    this.sellerId = sellerId;
  }

  public V1ExtraAlipayApp storeId(String storeId) {
    this.storeId = storeId;
    return this;
  }

   /**
   * 商户门店编号
   * @return storeId
  **/
  @ApiModelProperty(value = "商户门店编号")
  public String getStoreId() {
    return storeId;
  }

  public void setStoreId(String storeId) {
    this.storeId = storeId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1ExtraAlipayApp v1ExtraAlipayApp = (V1ExtraAlipayApp) o;
    return Objects.equals(this.creditAgreementId, v1ExtraAlipayApp.creditAgreementId) &&
        Objects.equals(this.creditBizOrderId, v1ExtraAlipayApp.creditBizOrderId) &&
        Objects.equals(this.creditPayMode, v1ExtraAlipayApp.creditPayMode) &&
        Objects.equals(this.disablePayChannels, v1ExtraAlipayApp.disablePayChannels) &&
        Objects.equals(this.enablePayChannels, v1ExtraAlipayApp.enablePayChannels) &&
        Objects.equals(this.extUserInfo, v1ExtraAlipayApp.extUserInfo) &&
        Objects.equals(this.extendParams, v1ExtraAlipayApp.extendParams) &&
        Objects.equals(this.goodsDetail, v1ExtraAlipayApp.goodsDetail) &&
        Objects.equals(this.goodsType, v1ExtraAlipayApp.goodsType) &&
        Objects.equals(this.merchantTradeId, v1ExtraAlipayApp.merchantTradeId) &&
        Objects.equals(this.payParam, v1ExtraAlipayApp.payParam) &&
        Objects.equals(this.productCode, v1ExtraAlipayApp.productCode) &&
        Objects.equals(this.sellerId, v1ExtraAlipayApp.sellerId) &&
        Objects.equals(this.storeId, v1ExtraAlipayApp.storeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creditAgreementId, creditBizOrderId, creditPayMode, disablePayChannels, enablePayChannels, extUserInfo, extendParams, goodsDetail, goodsType, merchantTradeId, payParam, productCode, sellerId, storeId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1ExtraAlipayApp {\n");
    
    sb.append("    creditAgreementId: ").append(toIndentedString(creditAgreementId)).append("\n");
    sb.append("    creditBizOrderId: ").append(toIndentedString(creditBizOrderId)).append("\n");
    sb.append("    creditPayMode: ").append(toIndentedString(creditPayMode)).append("\n");
    sb.append("    disablePayChannels: ").append(toIndentedString(disablePayChannels)).append("\n");
    sb.append("    enablePayChannels: ").append(toIndentedString(enablePayChannels)).append("\n");
    sb.append("    extUserInfo: ").append(toIndentedString(extUserInfo)).append("\n");
    sb.append("    extendParams: ").append(toIndentedString(extendParams)).append("\n");
    sb.append("    goodsDetail: ").append(toIndentedString(goodsDetail)).append("\n");
    sb.append("    goodsType: ").append(toIndentedString(goodsType)).append("\n");
    sb.append("    merchantTradeId: ").append(toIndentedString(merchantTradeId)).append("\n");
    sb.append("    payParam: ").append(toIndentedString(payParam)).append("\n");
    sb.append("    productCode: ").append(toIndentedString(productCode)).append("\n");
    sb.append("    sellerId: ").append(toIndentedString(sellerId)).append("\n");
    sb.append("    storeId: ").append(toIndentedString(storeId)).append("\n");
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

