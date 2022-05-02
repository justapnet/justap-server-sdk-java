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
import io.swagger.client.model.V1ExtraAlipayAgreementSignParams;
import io.swagger.client.model.V1ExtraAlipayExtUserInfo;
import io.swagger.client.model.V1ExtraAlipayExtendParams;
import io.swagger.client.model.V1ExtraAlipayGoodsDetail;
import io.swagger.client.model.V1ExtraAlipayInvoiceInfo;
import io.swagger.client.model.V1ExtraAlipayRoyaltyInfo;
import io.swagger.client.model.V1ExtraAlipaySettleInfo;
import io.swagger.client.model.V1ExtraAlipaySubMerchant;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * V1ExtraAlipayPage
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-05-02T17:26:10.059Z")
public class V1ExtraAlipayPage {
  @SerializedName("agreement_sign_params")
  private V1ExtraAlipayAgreementSignParams agreementSignParams = null;

  @SerializedName("business_params")
  private Integer businessParams = null;

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

  @SerializedName("integration_type")
  private Integer integrationType = null;

  @SerializedName("invoice_info")
  private V1ExtraAlipayInvoiceInfo invoiceInfo = null;

  @SerializedName("merchant_trade_id")
  private String merchantTradeId = null;

  @SerializedName("pay_url")
  private String payUrl = null;

  @SerializedName("promo_params")
  private String promoParams = null;

  @SerializedName("qr_pay_mode")
  private String qrPayMode = null;

  @SerializedName("qrcode_width")
  private Integer qrcodeWidth = null;

  @SerializedName("request_from_url")
  private Integer requestFromUrl = null;

  @SerializedName("royalty_info")
  private V1ExtraAlipayRoyaltyInfo royaltyInfo = null;

  @SerializedName("seller_id")
  private String sellerId = null;

  @SerializedName("settle_info")
  private V1ExtraAlipaySettleInfo settleInfo = null;

  @SerializedName("store_id")
  private String storeId = null;

  @SerializedName("sub_merchant")
  private V1ExtraAlipaySubMerchant subMerchant = null;

  @SerializedName("time_expire")
  private Integer timeExpire = null;

  public V1ExtraAlipayPage agreementSignParams(V1ExtraAlipayAgreementSignParams agreementSignParams) {
    this.agreementSignParams = agreementSignParams;
    return this;
  }

   /**
   * Get agreementSignParams
   * @return agreementSignParams
  **/
  @ApiModelProperty(value = "")
  public V1ExtraAlipayAgreementSignParams getAgreementSignParams() {
    return agreementSignParams;
  }

  public void setAgreementSignParams(V1ExtraAlipayAgreementSignParams agreementSignParams) {
    this.agreementSignParams = agreementSignParams;
  }

  public V1ExtraAlipayPage businessParams(Integer businessParams) {
    this.businessParams = businessParams;
    return this;
  }

   /**
   * Get businessParams
   * @return businessParams
  **/
  @ApiModelProperty(value = "")
  public Integer getBusinessParams() {
    return businessParams;
  }

  public void setBusinessParams(Integer businessParams) {
    this.businessParams = businessParams;
  }

  public V1ExtraAlipayPage disablePayChannels(String disablePayChannels) {
    this.disablePayChannels = disablePayChannels;
    return this;
  }

   /**
   * Get disablePayChannels
   * @return disablePayChannels
  **/
  @ApiModelProperty(value = "")
  public String getDisablePayChannels() {
    return disablePayChannels;
  }

  public void setDisablePayChannels(String disablePayChannels) {
    this.disablePayChannels = disablePayChannels;
  }

  public V1ExtraAlipayPage enablePayChannels(String enablePayChannels) {
    this.enablePayChannels = enablePayChannels;
    return this;
  }

   /**
   * Get enablePayChannels
   * @return enablePayChannels
  **/
  @ApiModelProperty(value = "")
  public String getEnablePayChannels() {
    return enablePayChannels;
  }

  public void setEnablePayChannels(String enablePayChannels) {
    this.enablePayChannels = enablePayChannels;
  }

  public V1ExtraAlipayPage extUserInfo(V1ExtraAlipayExtUserInfo extUserInfo) {
    this.extUserInfo = extUserInfo;
    return this;
  }

   /**
   * Get extUserInfo
   * @return extUserInfo
  **/
  @ApiModelProperty(value = "")
  public V1ExtraAlipayExtUserInfo getExtUserInfo() {
    return extUserInfo;
  }

  public void setExtUserInfo(V1ExtraAlipayExtUserInfo extUserInfo) {
    this.extUserInfo = extUserInfo;
  }

  public V1ExtraAlipayPage extendParams(V1ExtraAlipayExtendParams extendParams) {
    this.extendParams = extendParams;
    return this;
  }

   /**
   * Get extendParams
   * @return extendParams
  **/
  @ApiModelProperty(value = "")
  public V1ExtraAlipayExtendParams getExtendParams() {
    return extendParams;
  }

  public void setExtendParams(V1ExtraAlipayExtendParams extendParams) {
    this.extendParams = extendParams;
  }

  public V1ExtraAlipayPage goodsDetail(List<V1ExtraAlipayGoodsDetail> goodsDetail) {
    this.goodsDetail = goodsDetail;
    return this;
  }

  public V1ExtraAlipayPage addGoodsDetailItem(V1ExtraAlipayGoodsDetail goodsDetailItem) {
    if (this.goodsDetail == null) {
      this.goodsDetail = new ArrayList<>();
    }
    this.goodsDetail.add(goodsDetailItem);
    return this;
  }

   /**
   * Get goodsDetail
   * @return goodsDetail
  **/
  @ApiModelProperty(value = "")
  public List<V1ExtraAlipayGoodsDetail> getGoodsDetail() {
    return goodsDetail;
  }

  public void setGoodsDetail(List<V1ExtraAlipayGoodsDetail> goodsDetail) {
    this.goodsDetail = goodsDetail;
  }

  public V1ExtraAlipayPage goodsType(String goodsType) {
    this.goodsType = goodsType;
    return this;
  }

   /**
   * Get goodsType
   * @return goodsType
  **/
  @ApiModelProperty(value = "")
  public String getGoodsType() {
    return goodsType;
  }

  public void setGoodsType(String goodsType) {
    this.goodsType = goodsType;
  }

  public V1ExtraAlipayPage integrationType(Integer integrationType) {
    this.integrationType = integrationType;
    return this;
  }

   /**
   * Get integrationType
   * @return integrationType
  **/
  @ApiModelProperty(value = "")
  public Integer getIntegrationType() {
    return integrationType;
  }

  public void setIntegrationType(Integer integrationType) {
    this.integrationType = integrationType;
  }

  public V1ExtraAlipayPage invoiceInfo(V1ExtraAlipayInvoiceInfo invoiceInfo) {
    this.invoiceInfo = invoiceInfo;
    return this;
  }

   /**
   * Get invoiceInfo
   * @return invoiceInfo
  **/
  @ApiModelProperty(value = "")
  public V1ExtraAlipayInvoiceInfo getInvoiceInfo() {
    return invoiceInfo;
  }

  public void setInvoiceInfo(V1ExtraAlipayInvoiceInfo invoiceInfo) {
    this.invoiceInfo = invoiceInfo;
  }

  public V1ExtraAlipayPage merchantTradeId(String merchantTradeId) {
    this.merchantTradeId = merchantTradeId;
    return this;
  }

   /**
   * Get merchantTradeId
   * @return merchantTradeId
  **/
  @ApiModelProperty(value = "")
  public String getMerchantTradeId() {
    return merchantTradeId;
  }

  public void setMerchantTradeId(String merchantTradeId) {
    this.merchantTradeId = merchantTradeId;
  }

  public V1ExtraAlipayPage payUrl(String payUrl) {
    this.payUrl = payUrl;
    return this;
  }

   /**
   * Get payUrl
   * @return payUrl
  **/
  @ApiModelProperty(value = "")
  public String getPayUrl() {
    return payUrl;
  }

  public void setPayUrl(String payUrl) {
    this.payUrl = payUrl;
  }

  public V1ExtraAlipayPage promoParams(String promoParams) {
    this.promoParams = promoParams;
    return this;
  }

   /**
   * Get promoParams
   * @return promoParams
  **/
  @ApiModelProperty(value = "")
  public String getPromoParams() {
    return promoParams;
  }

  public void setPromoParams(String promoParams) {
    this.promoParams = promoParams;
  }

  public V1ExtraAlipayPage qrPayMode(String qrPayMode) {
    this.qrPayMode = qrPayMode;
    return this;
  }

   /**
   * Get qrPayMode
   * @return qrPayMode
  **/
  @ApiModelProperty(value = "")
  public String getQrPayMode() {
    return qrPayMode;
  }

  public void setQrPayMode(String qrPayMode) {
    this.qrPayMode = qrPayMode;
  }

  public V1ExtraAlipayPage qrcodeWidth(Integer qrcodeWidth) {
    this.qrcodeWidth = qrcodeWidth;
    return this;
  }

   /**
   * Get qrcodeWidth
   * @return qrcodeWidth
  **/
  @ApiModelProperty(value = "")
  public Integer getQrcodeWidth() {
    return qrcodeWidth;
  }

  public void setQrcodeWidth(Integer qrcodeWidth) {
    this.qrcodeWidth = qrcodeWidth;
  }

  public V1ExtraAlipayPage requestFromUrl(Integer requestFromUrl) {
    this.requestFromUrl = requestFromUrl;
    return this;
  }

   /**
   * Get requestFromUrl
   * @return requestFromUrl
  **/
  @ApiModelProperty(value = "")
  public Integer getRequestFromUrl() {
    return requestFromUrl;
  }

  public void setRequestFromUrl(Integer requestFromUrl) {
    this.requestFromUrl = requestFromUrl;
  }

  public V1ExtraAlipayPage royaltyInfo(V1ExtraAlipayRoyaltyInfo royaltyInfo) {
    this.royaltyInfo = royaltyInfo;
    return this;
  }

   /**
   * Get royaltyInfo
   * @return royaltyInfo
  **/
  @ApiModelProperty(value = "")
  public V1ExtraAlipayRoyaltyInfo getRoyaltyInfo() {
    return royaltyInfo;
  }

  public void setRoyaltyInfo(V1ExtraAlipayRoyaltyInfo royaltyInfo) {
    this.royaltyInfo = royaltyInfo;
  }

  public V1ExtraAlipayPage sellerId(String sellerId) {
    this.sellerId = sellerId;
    return this;
  }

   /**
   * Get sellerId
   * @return sellerId
  **/
  @ApiModelProperty(value = "")
  public String getSellerId() {
    return sellerId;
  }

  public void setSellerId(String sellerId) {
    this.sellerId = sellerId;
  }

  public V1ExtraAlipayPage settleInfo(V1ExtraAlipaySettleInfo settleInfo) {
    this.settleInfo = settleInfo;
    return this;
  }

   /**
   * Get settleInfo
   * @return settleInfo
  **/
  @ApiModelProperty(value = "")
  public V1ExtraAlipaySettleInfo getSettleInfo() {
    return settleInfo;
  }

  public void setSettleInfo(V1ExtraAlipaySettleInfo settleInfo) {
    this.settleInfo = settleInfo;
  }

  public V1ExtraAlipayPage storeId(String storeId) {
    this.storeId = storeId;
    return this;
  }

   /**
   * Get storeId
   * @return storeId
  **/
  @ApiModelProperty(value = "")
  public String getStoreId() {
    return storeId;
  }

  public void setStoreId(String storeId) {
    this.storeId = storeId;
  }

  public V1ExtraAlipayPage subMerchant(V1ExtraAlipaySubMerchant subMerchant) {
    this.subMerchant = subMerchant;
    return this;
  }

   /**
   * Get subMerchant
   * @return subMerchant
  **/
  @ApiModelProperty(value = "")
  public V1ExtraAlipaySubMerchant getSubMerchant() {
    return subMerchant;
  }

  public void setSubMerchant(V1ExtraAlipaySubMerchant subMerchant) {
    this.subMerchant = subMerchant;
  }

  public V1ExtraAlipayPage timeExpire(Integer timeExpire) {
    this.timeExpire = timeExpire;
    return this;
  }

   /**
   * Get timeExpire
   * @return timeExpire
  **/
  @ApiModelProperty(value = "")
  public Integer getTimeExpire() {
    return timeExpire;
  }

  public void setTimeExpire(Integer timeExpire) {
    this.timeExpire = timeExpire;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1ExtraAlipayPage v1ExtraAlipayPage = (V1ExtraAlipayPage) o;
    return Objects.equals(this.agreementSignParams, v1ExtraAlipayPage.agreementSignParams) &&
        Objects.equals(this.businessParams, v1ExtraAlipayPage.businessParams) &&
        Objects.equals(this.disablePayChannels, v1ExtraAlipayPage.disablePayChannels) &&
        Objects.equals(this.enablePayChannels, v1ExtraAlipayPage.enablePayChannels) &&
        Objects.equals(this.extUserInfo, v1ExtraAlipayPage.extUserInfo) &&
        Objects.equals(this.extendParams, v1ExtraAlipayPage.extendParams) &&
        Objects.equals(this.goodsDetail, v1ExtraAlipayPage.goodsDetail) &&
        Objects.equals(this.goodsType, v1ExtraAlipayPage.goodsType) &&
        Objects.equals(this.integrationType, v1ExtraAlipayPage.integrationType) &&
        Objects.equals(this.invoiceInfo, v1ExtraAlipayPage.invoiceInfo) &&
        Objects.equals(this.merchantTradeId, v1ExtraAlipayPage.merchantTradeId) &&
        Objects.equals(this.payUrl, v1ExtraAlipayPage.payUrl) &&
        Objects.equals(this.promoParams, v1ExtraAlipayPage.promoParams) &&
        Objects.equals(this.qrPayMode, v1ExtraAlipayPage.qrPayMode) &&
        Objects.equals(this.qrcodeWidth, v1ExtraAlipayPage.qrcodeWidth) &&
        Objects.equals(this.requestFromUrl, v1ExtraAlipayPage.requestFromUrl) &&
        Objects.equals(this.royaltyInfo, v1ExtraAlipayPage.royaltyInfo) &&
        Objects.equals(this.sellerId, v1ExtraAlipayPage.sellerId) &&
        Objects.equals(this.settleInfo, v1ExtraAlipayPage.settleInfo) &&
        Objects.equals(this.storeId, v1ExtraAlipayPage.storeId) &&
        Objects.equals(this.subMerchant, v1ExtraAlipayPage.subMerchant) &&
        Objects.equals(this.timeExpire, v1ExtraAlipayPage.timeExpire);
  }

  @Override
  public int hashCode() {
    return Objects.hash(agreementSignParams, businessParams, disablePayChannels, enablePayChannels, extUserInfo, extendParams, goodsDetail, goodsType, integrationType, invoiceInfo, merchantTradeId, payUrl, promoParams, qrPayMode, qrcodeWidth, requestFromUrl, royaltyInfo, sellerId, settleInfo, storeId, subMerchant, timeExpire);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1ExtraAlipayPage {\n");
    
    sb.append("    agreementSignParams: ").append(toIndentedString(agreementSignParams)).append("\n");
    sb.append("    businessParams: ").append(toIndentedString(businessParams)).append("\n");
    sb.append("    disablePayChannels: ").append(toIndentedString(disablePayChannels)).append("\n");
    sb.append("    enablePayChannels: ").append(toIndentedString(enablePayChannels)).append("\n");
    sb.append("    extUserInfo: ").append(toIndentedString(extUserInfo)).append("\n");
    sb.append("    extendParams: ").append(toIndentedString(extendParams)).append("\n");
    sb.append("    goodsDetail: ").append(toIndentedString(goodsDetail)).append("\n");
    sb.append("    goodsType: ").append(toIndentedString(goodsType)).append("\n");
    sb.append("    integrationType: ").append(toIndentedString(integrationType)).append("\n");
    sb.append("    invoiceInfo: ").append(toIndentedString(invoiceInfo)).append("\n");
    sb.append("    merchantTradeId: ").append(toIndentedString(merchantTradeId)).append("\n");
    sb.append("    payUrl: ").append(toIndentedString(payUrl)).append("\n");
    sb.append("    promoParams: ").append(toIndentedString(promoParams)).append("\n");
    sb.append("    qrPayMode: ").append(toIndentedString(qrPayMode)).append("\n");
    sb.append("    qrcodeWidth: ").append(toIndentedString(qrcodeWidth)).append("\n");
    sb.append("    requestFromUrl: ").append(toIndentedString(requestFromUrl)).append("\n");
    sb.append("    royaltyInfo: ").append(toIndentedString(royaltyInfo)).append("\n");
    sb.append("    sellerId: ").append(toIndentedString(sellerId)).append("\n");
    sb.append("    settleInfo: ").append(toIndentedString(settleInfo)).append("\n");
    sb.append("    storeId: ").append(toIndentedString(storeId)).append("\n");
    sb.append("    subMerchant: ").append(toIndentedString(subMerchant)).append("\n");
    sb.append("    timeExpire: ").append(toIndentedString(timeExpire)).append("\n");
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

