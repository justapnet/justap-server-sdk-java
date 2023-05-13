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
import io.swagger.client.model.V1ExtraAlipayApp;
import io.swagger.client.model.V1ExtraAlipayFace;
import io.swagger.client.model.V1ExtraAlipayLite;
import io.swagger.client.model.V1ExtraAlipayPage;
import io.swagger.client.model.V1ExtraAlipayQr;
import io.swagger.client.model.V1ExtraAlipayScan;
import io.swagger.client.model.V1ExtraAlipayWap;
import io.swagger.client.model.V1ExtraWechatpayApp;
import io.swagger.client.model.V1ExtraWechatpayH5;
import io.swagger.client.model.V1ExtraWechatpayJsapi;
import io.swagger.client.model.V1ExtraWechatpayLite;
import io.swagger.client.model.V1ExtraWechatpayNative;
import io.swagger.client.model.V1ExtraWechatpayScan;
import java.io.IOException;

/**
 * V1ChargeExtra
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-05-13T06:39:03.113Z")
public class V1ChargeExtra {
  @SerializedName("alipay_app")
  private V1ExtraAlipayApp alipayApp = null;

  @SerializedName("alipay_face")
  private V1ExtraAlipayFace alipayFace = null;

  @SerializedName("alipay_lite")
  private V1ExtraAlipayLite alipayLite = null;

  @SerializedName("alipay_page")
  private V1ExtraAlipayPage alipayPage = null;

  @SerializedName("alipay_qr")
  private V1ExtraAlipayQr alipayQr = null;

  @SerializedName("alipay_scan")
  private V1ExtraAlipayScan alipayScan = null;

  @SerializedName("alipay_wap")
  private V1ExtraAlipayWap alipayWap = null;

  @SerializedName("wechatpay_app")
  private V1ExtraWechatpayApp wechatpayApp = null;

  @SerializedName("wechatpay_h5")
  private V1ExtraWechatpayH5 wechatpayH5 = null;

  @SerializedName("wechatpay_jsapi")
  private V1ExtraWechatpayJsapi wechatpayJsapi = null;

  @SerializedName("wechatpay_lite")
  private V1ExtraWechatpayLite wechatpayLite = null;

  @SerializedName("wechatpay_native")
  private V1ExtraWechatpayNative wechatpayNative = null;

  @SerializedName("wechatpay_scan")
  private V1ExtraWechatpayScan wechatpayScan = null;

  public V1ChargeExtra alipayApp(V1ExtraAlipayApp alipayApp) {
    this.alipayApp = alipayApp;
    return this;
  }

   /**
   * 支付宝 App 支付渠道元数据
   * @return alipayApp
  **/
  @ApiModelProperty(value = "支付宝 App 支付渠道元数据")
  public V1ExtraAlipayApp getAlipayApp() {
    return alipayApp;
  }

  public void setAlipayApp(V1ExtraAlipayApp alipayApp) {
    this.alipayApp = alipayApp;
  }

  public V1ChargeExtra alipayFace(V1ExtraAlipayFace alipayFace) {
    this.alipayFace = alipayFace;
    return this;
  }

   /**
   * 支付宝 刷脸 支付渠道元数据
   * @return alipayFace
  **/
  @ApiModelProperty(value = "支付宝 刷脸 支付渠道元数据")
  public V1ExtraAlipayFace getAlipayFace() {
    return alipayFace;
  }

  public void setAlipayFace(V1ExtraAlipayFace alipayFace) {
    this.alipayFace = alipayFace;
  }

  public V1ChargeExtra alipayLite(V1ExtraAlipayLite alipayLite) {
    this.alipayLite = alipayLite;
    return this;
  }

   /**
   * 支付宝 小程序 支付渠道元数据
   * @return alipayLite
  **/
  @ApiModelProperty(value = "支付宝 小程序 支付渠道元数据")
  public V1ExtraAlipayLite getAlipayLite() {
    return alipayLite;
  }

  public void setAlipayLite(V1ExtraAlipayLite alipayLite) {
    this.alipayLite = alipayLite;
  }

  public V1ChargeExtra alipayPage(V1ExtraAlipayPage alipayPage) {
    this.alipayPage = alipayPage;
    return this;
  }

   /**
   * 支付宝 电脑网站 支付渠道元数据
   * @return alipayPage
  **/
  @ApiModelProperty(value = "支付宝 电脑网站 支付渠道元数据")
  public V1ExtraAlipayPage getAlipayPage() {
    return alipayPage;
  }

  public void setAlipayPage(V1ExtraAlipayPage alipayPage) {
    this.alipayPage = alipayPage;
  }

  public V1ChargeExtra alipayQr(V1ExtraAlipayQr alipayQr) {
    this.alipayQr = alipayQr;
    return this;
  }

   /**
   * 支付宝 当面付 支付渠道元数据
   * @return alipayQr
  **/
  @ApiModelProperty(value = "支付宝 当面付 支付渠道元数据")
  public V1ExtraAlipayQr getAlipayQr() {
    return alipayQr;
  }

  public void setAlipayQr(V1ExtraAlipayQr alipayQr) {
    this.alipayQr = alipayQr;
  }

  public V1ChargeExtra alipayScan(V1ExtraAlipayScan alipayScan) {
    this.alipayScan = alipayScan;
    return this;
  }

   /**
   * 支付宝 扫码(被扫) 支付渠道元数据
   * @return alipayScan
  **/
  @ApiModelProperty(value = "支付宝 扫码(被扫) 支付渠道元数据")
  public V1ExtraAlipayScan getAlipayScan() {
    return alipayScan;
  }

  public void setAlipayScan(V1ExtraAlipayScan alipayScan) {
    this.alipayScan = alipayScan;
  }

  public V1ChargeExtra alipayWap(V1ExtraAlipayWap alipayWap) {
    this.alipayWap = alipayWap;
    return this;
  }

   /**
   * 支付宝 手机网站 支付渠道元数据
   * @return alipayWap
  **/
  @ApiModelProperty(value = "支付宝 手机网站 支付渠道元数据")
  public V1ExtraAlipayWap getAlipayWap() {
    return alipayWap;
  }

  public void setAlipayWap(V1ExtraAlipayWap alipayWap) {
    this.alipayWap = alipayWap;
  }

  public V1ChargeExtra wechatpayApp(V1ExtraWechatpayApp wechatpayApp) {
    this.wechatpayApp = wechatpayApp;
    return this;
  }

   /**
   * 微信支付 App 支付渠道元数据
   * @return wechatpayApp
  **/
  @ApiModelProperty(value = "微信支付 App 支付渠道元数据")
  public V1ExtraWechatpayApp getWechatpayApp() {
    return wechatpayApp;
  }

  public void setWechatpayApp(V1ExtraWechatpayApp wechatpayApp) {
    this.wechatpayApp = wechatpayApp;
  }

  public V1ChargeExtra wechatpayH5(V1ExtraWechatpayH5 wechatpayH5) {
    this.wechatpayH5 = wechatpayH5;
    return this;
  }

   /**
   * 微信支付 H5 支付渠道元数据
   * @return wechatpayH5
  **/
  @ApiModelProperty(value = "微信支付 H5 支付渠道元数据")
  public V1ExtraWechatpayH5 getWechatpayH5() {
    return wechatpayH5;
  }

  public void setWechatpayH5(V1ExtraWechatpayH5 wechatpayH5) {
    this.wechatpayH5 = wechatpayH5;
  }

  public V1ChargeExtra wechatpayJsapi(V1ExtraWechatpayJsapi wechatpayJsapi) {
    this.wechatpayJsapi = wechatpayJsapi;
    return this;
  }

   /**
   * 微信支付 公众号 支付渠道元数据
   * @return wechatpayJsapi
  **/
  @ApiModelProperty(value = "微信支付 公众号 支付渠道元数据")
  public V1ExtraWechatpayJsapi getWechatpayJsapi() {
    return wechatpayJsapi;
  }

  public void setWechatpayJsapi(V1ExtraWechatpayJsapi wechatpayJsapi) {
    this.wechatpayJsapi = wechatpayJsapi;
  }

  public V1ChargeExtra wechatpayLite(V1ExtraWechatpayLite wechatpayLite) {
    this.wechatpayLite = wechatpayLite;
    return this;
  }

   /**
   * 微信支付 小程序 支付渠道元数据
   * @return wechatpayLite
  **/
  @ApiModelProperty(value = "微信支付 小程序 支付渠道元数据")
  public V1ExtraWechatpayLite getWechatpayLite() {
    return wechatpayLite;
  }

  public void setWechatpayLite(V1ExtraWechatpayLite wechatpayLite) {
    this.wechatpayLite = wechatpayLite;
  }

  public V1ChargeExtra wechatpayNative(V1ExtraWechatpayNative wechatpayNative) {
    this.wechatpayNative = wechatpayNative;
    return this;
  }

   /**
   * 微信支付 扫码(被扫) 支付渠道元数据
   * @return wechatpayNative
  **/
  @ApiModelProperty(value = "微信支付 扫码(被扫) 支付渠道元数据")
  public V1ExtraWechatpayNative getWechatpayNative() {
    return wechatpayNative;
  }

  public void setWechatpayNative(V1ExtraWechatpayNative wechatpayNative) {
    this.wechatpayNative = wechatpayNative;
  }

  public V1ChargeExtra wechatpayScan(V1ExtraWechatpayScan wechatpayScan) {
    this.wechatpayScan = wechatpayScan;
    return this;
  }

   /**
   * 微信支付 扫码(被扫) 支付渠道元数据
   * @return wechatpayScan
  **/
  @ApiModelProperty(value = "微信支付 扫码(被扫) 支付渠道元数据")
  public V1ExtraWechatpayScan getWechatpayScan() {
    return wechatpayScan;
  }

  public void setWechatpayScan(V1ExtraWechatpayScan wechatpayScan) {
    this.wechatpayScan = wechatpayScan;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1ChargeExtra v1ChargeExtra = (V1ChargeExtra) o;
    return Objects.equals(this.alipayApp, v1ChargeExtra.alipayApp) &&
        Objects.equals(this.alipayFace, v1ChargeExtra.alipayFace) &&
        Objects.equals(this.alipayLite, v1ChargeExtra.alipayLite) &&
        Objects.equals(this.alipayPage, v1ChargeExtra.alipayPage) &&
        Objects.equals(this.alipayQr, v1ChargeExtra.alipayQr) &&
        Objects.equals(this.alipayScan, v1ChargeExtra.alipayScan) &&
        Objects.equals(this.alipayWap, v1ChargeExtra.alipayWap) &&
        Objects.equals(this.wechatpayApp, v1ChargeExtra.wechatpayApp) &&
        Objects.equals(this.wechatpayH5, v1ChargeExtra.wechatpayH5) &&
        Objects.equals(this.wechatpayJsapi, v1ChargeExtra.wechatpayJsapi) &&
        Objects.equals(this.wechatpayLite, v1ChargeExtra.wechatpayLite) &&
        Objects.equals(this.wechatpayNative, v1ChargeExtra.wechatpayNative) &&
        Objects.equals(this.wechatpayScan, v1ChargeExtra.wechatpayScan);
  }

  @Override
  public int hashCode() {
    return Objects.hash(alipayApp, alipayFace, alipayLite, alipayPage, alipayQr, alipayScan, alipayWap, wechatpayApp, wechatpayH5, wechatpayJsapi, wechatpayLite, wechatpayNative, wechatpayScan);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1ChargeExtra {\n");
    
    sb.append("    alipayApp: ").append(toIndentedString(alipayApp)).append("\n");
    sb.append("    alipayFace: ").append(toIndentedString(alipayFace)).append("\n");
    sb.append("    alipayLite: ").append(toIndentedString(alipayLite)).append("\n");
    sb.append("    alipayPage: ").append(toIndentedString(alipayPage)).append("\n");
    sb.append("    alipayQr: ").append(toIndentedString(alipayQr)).append("\n");
    sb.append("    alipayScan: ").append(toIndentedString(alipayScan)).append("\n");
    sb.append("    alipayWap: ").append(toIndentedString(alipayWap)).append("\n");
    sb.append("    wechatpayApp: ").append(toIndentedString(wechatpayApp)).append("\n");
    sb.append("    wechatpayH5: ").append(toIndentedString(wechatpayH5)).append("\n");
    sb.append("    wechatpayJsapi: ").append(toIndentedString(wechatpayJsapi)).append("\n");
    sb.append("    wechatpayLite: ").append(toIndentedString(wechatpayLite)).append("\n");
    sb.append("    wechatpayNative: ").append(toIndentedString(wechatpayNative)).append("\n");
    sb.append("    wechatpayScan: ").append(toIndentedString(wechatpayScan)).append("\n");
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

