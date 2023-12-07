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
import io.swagger.client.model.V1ExtraAlipayExtendParams;
import io.swagger.client.model.V1ExtraAlipayFundBillList;
import io.swagger.client.model.V1ExtraAlipayGoodsDetail;
import io.swagger.client.model.V1ExtraAlipayPayParams;
import io.swagger.client.model.V1ExtraAlipayVoucherDetailList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * V1ExtraAlipayScan
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-12-07T07:04:49.831Z")
public class V1ExtraAlipayScan {
  @SerializedName("advance_payment_type")
  private String advancePaymentType = null;

  @SerializedName("auth_code")
  private String authCode = null;

  @SerializedName("auth_confirm_mode")
  private String authConfirmMode = null;

  @SerializedName("auth_no")
  private String authNo = null;

  @SerializedName("buyer_id")
  private String buyerId = null;

  @SerializedName("buyer_logon_id")
  private String buyerLogonId = null;

  @SerializedName("buyer_pay_amount")
  private Double buyerPayAmount = null;

  @SerializedName("buyer_user_id")
  private String buyerUserId = null;

  @SerializedName("discount_amount")
  private Double discountAmount = null;

  @SerializedName("discount_goods_detail")
  private String discountGoodsDetail = null;

  @SerializedName("discountable_amount")
  private Double discountableAmount = null;

  @SerializedName("extend_params")
  private V1ExtraAlipayExtendParams extendParams = null;

  @SerializedName("fund_bill_list")
  private V1ExtraAlipayFundBillList fundBillList = null;

  @SerializedName("gmt_payment")
  private String gmtPayment = null;

  @SerializedName("goods_detail")
  private List<V1ExtraAlipayGoodsDetail> goodsDetail = null;

  @SerializedName("invoice_amount")
  private Double invoiceAmount = null;

  @SerializedName("is_async_pay")
  private V1ExtraAlipayPayParams isAsyncPay = null;

  @SerializedName("operator_id")
  private String operatorId = null;

  @SerializedName("pay_params")
  private String payParams = null;

  @SerializedName("point_amount")
  private Double pointAmount = null;

  @SerializedName("product_code")
  private String productCode = null;

  @SerializedName("query_options")
  private String queryOptions = null;

  @SerializedName("receipt_amount")
  private Double receiptAmount = null;

  @SerializedName("request_org_pid")
  private String requestOrgPid = null;

  @SerializedName("scene")
  private String scene = null;

  @SerializedName("store_id")
  private String storeId = null;

  @SerializedName("store_name")
  private String storeName = null;

  @SerializedName("terminal_id")
  private String terminalId = null;

  @SerializedName("total_amount")
  private Double totalAmount = null;

  @SerializedName("voucher_detail_list")
  private V1ExtraAlipayVoucherDetailList voucherDetailList = null;

  public V1ExtraAlipayScan advancePaymentType(String advancePaymentType) {
    this.advancePaymentType = advancePaymentType;
    return this;
  }

   /**
   * 预授权类型
   * @return advancePaymentType
  **/
  @ApiModelProperty(required = true, value = "预授权类型")
  public String getAdvancePaymentType() {
    return advancePaymentType;
  }

  public void setAdvancePaymentType(String advancePaymentType) {
    this.advancePaymentType = advancePaymentType;
  }

  public V1ExtraAlipayScan authCode(String authCode) {
    this.authCode = authCode;
    return this;
  }

   /**
   * 用户的条码
   * @return authCode
  **/
  @ApiModelProperty(required = true, value = "用户的条码")
  public String getAuthCode() {
    return authCode;
  }

  public void setAuthCode(String authCode) {
    this.authCode = authCode;
  }

  public V1ExtraAlipayScan authConfirmMode(String authConfirmMode) {
    this.authConfirmMode = authConfirmMode;
    return this;
  }

   /**
   * 授权确认方式
   * @return authConfirmMode
  **/
  @ApiModelProperty(required = true, value = "授权确认方式")
  public String getAuthConfirmMode() {
    return authConfirmMode;
  }

  public void setAuthConfirmMode(String authConfirmMode) {
    this.authConfirmMode = authConfirmMode;
  }

  public V1ExtraAlipayScan authNo(String authNo) {
    this.authNo = authNo;
    return this;
  }

   /**
   * 授权号
   * @return authNo
  **/
  @ApiModelProperty(required = true, value = "授权号")
  public String getAuthNo() {
    return authNo;
  }

  public void setAuthNo(String authNo) {
    this.authNo = authNo;
  }

  public V1ExtraAlipayScan buyerId(String buyerId) {
    this.buyerId = buyerId;
    return this;
  }

   /**
   * 买家的支付宝用户id
   * @return buyerId
  **/
  @ApiModelProperty(required = true, value = "买家的支付宝用户id")
  public String getBuyerId() {
    return buyerId;
  }

  public void setBuyerId(String buyerId) {
    this.buyerId = buyerId;
  }

  public V1ExtraAlipayScan buyerLogonId(String buyerLogonId) {
    this.buyerLogonId = buyerLogonId;
    return this;
  }

   /**
   * [ONLY IN RESPONSE] 买家支付宝账号
   * @return buyerLogonId
  **/
  @ApiModelProperty(required = true, value = "[ONLY IN RESPONSE] 买家支付宝账号")
  public String getBuyerLogonId() {
    return buyerLogonId;
  }

  public void setBuyerLogonId(String buyerLogonId) {
    this.buyerLogonId = buyerLogonId;
  }

  public V1ExtraAlipayScan buyerPayAmount(Double buyerPayAmount) {
    this.buyerPayAmount = buyerPayAmount;
    return this;
  }

   /**
   * [ONLY IN RESPONSE] 付款金额
   * @return buyerPayAmount
  **/
  @ApiModelProperty(required = true, value = "[ONLY IN RESPONSE] 付款金额")
  public Double getBuyerPayAmount() {
    return buyerPayAmount;
  }

  public void setBuyerPayAmount(Double buyerPayAmount) {
    this.buyerPayAmount = buyerPayAmount;
  }

  public V1ExtraAlipayScan buyerUserId(String buyerUserId) {
    this.buyerUserId = buyerUserId;
    return this;
  }

   /**
   * [ONLY IN RESPONSE] 买家在支付宝的用户id
   * @return buyerUserId
  **/
  @ApiModelProperty(required = true, value = "[ONLY IN RESPONSE] 买家在支付宝的用户id")
  public String getBuyerUserId() {
    return buyerUserId;
  }

  public void setBuyerUserId(String buyerUserId) {
    this.buyerUserId = buyerUserId;
  }

  public V1ExtraAlipayScan discountAmount(Double discountAmount) {
    this.discountAmount = discountAmount;
    return this;
  }

   /**
   * [ONLY IN RESPONSE] 商家优惠金额
   * @return discountAmount
  **/
  @ApiModelProperty(required = true, value = "[ONLY IN RESPONSE] 商家优惠金额")
  public Double getDiscountAmount() {
    return discountAmount;
  }

  public void setDiscountAmount(Double discountAmount) {
    this.discountAmount = discountAmount;
  }

  public V1ExtraAlipayScan discountGoodsDetail(String discountGoodsDetail) {
    this.discountGoodsDetail = discountGoodsDetail;
    return this;
  }

   /**
   * [ONLY IN RESPONSE] 商家优惠商品明细
   * @return discountGoodsDetail
  **/
  @ApiModelProperty(required = true, value = "[ONLY IN RESPONSE] 商家优惠商品明细")
  public String getDiscountGoodsDetail() {
    return discountGoodsDetail;
  }

  public void setDiscountGoodsDetail(String discountGoodsDetail) {
    this.discountGoodsDetail = discountGoodsDetail;
  }

  public V1ExtraAlipayScan discountableAmount(Double discountableAmount) {
    this.discountableAmount = discountableAmount;
    return this;
  }

   /**
   * 可打折金额
   * @return discountableAmount
  **/
  @ApiModelProperty(required = true, value = "可打折金额")
  public Double getDiscountableAmount() {
    return discountableAmount;
  }

  public void setDiscountableAmount(Double discountableAmount) {
    this.discountableAmount = discountableAmount;
  }

  public V1ExtraAlipayScan extendParams(V1ExtraAlipayExtendParams extendParams) {
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

  public V1ExtraAlipayScan fundBillList(V1ExtraAlipayFundBillList fundBillList) {
    this.fundBillList = fundBillList;
    return this;
  }

   /**
   * [ONLY IN RESPONSE] 支付金额信息
   * @return fundBillList
  **/
  @ApiModelProperty(value = "[ONLY IN RESPONSE] 支付金额信息")
  public V1ExtraAlipayFundBillList getFundBillList() {
    return fundBillList;
  }

  public void setFundBillList(V1ExtraAlipayFundBillList fundBillList) {
    this.fundBillList = fundBillList;
  }

  public V1ExtraAlipayScan gmtPayment(String gmtPayment) {
    this.gmtPayment = gmtPayment;
    return this;
  }

   /**
   * [ONLY IN RESPONSE] 支付时间
   * @return gmtPayment
  **/
  @ApiModelProperty(required = true, value = "[ONLY IN RESPONSE] 支付时间")
  public String getGmtPayment() {
    return gmtPayment;
  }

  public void setGmtPayment(String gmtPayment) {
    this.gmtPayment = gmtPayment;
  }

  public V1ExtraAlipayScan goodsDetail(List<V1ExtraAlipayGoodsDetail> goodsDetail) {
    this.goodsDetail = goodsDetail;
    return this;
  }

  public V1ExtraAlipayScan addGoodsDetailItem(V1ExtraAlipayGoodsDetail goodsDetailItem) {
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

  public V1ExtraAlipayScan invoiceAmount(Double invoiceAmount) {
    this.invoiceAmount = invoiceAmount;
    return this;
  }

   /**
   * [ONLY IN RESPONSE] 开票金额
   * @return invoiceAmount
  **/
  @ApiModelProperty(required = true, value = "[ONLY IN RESPONSE] 开票金额")
  public Double getInvoiceAmount() {
    return invoiceAmount;
  }

  public void setInvoiceAmount(Double invoiceAmount) {
    this.invoiceAmount = invoiceAmount;
  }

  public V1ExtraAlipayScan isAsyncPay(V1ExtraAlipayPayParams isAsyncPay) {
    this.isAsyncPay = isAsyncPay;
    return this;
  }

   /**
   * 是否异步支付
   * @return isAsyncPay
  **/
  @ApiModelProperty(value = "是否异步支付")
  public V1ExtraAlipayPayParams getIsAsyncPay() {
    return isAsyncPay;
  }

  public void setIsAsyncPay(V1ExtraAlipayPayParams isAsyncPay) {
    this.isAsyncPay = isAsyncPay;
  }

  public V1ExtraAlipayScan operatorId(String operatorId) {
    this.operatorId = operatorId;
    return this;
  }

   /**
   * 商户操作员编号
   * @return operatorId
  **/
  @ApiModelProperty(required = true, value = "商户操作员编号")
  public String getOperatorId() {
    return operatorId;
  }

  public void setOperatorId(String operatorId) {
    this.operatorId = operatorId;
  }

  public V1ExtraAlipayScan payParams(String payParams) {
    this.payParams = payParams;
    return this;
  }

   /**
   * [ONLY IN RESPONSE] 支付宝返回的支付参数
   * @return payParams
  **/
  @ApiModelProperty(required = true, value = "[ONLY IN RESPONSE] 支付宝返回的支付参数")
  public String getPayParams() {
    return payParams;
  }

  public void setPayParams(String payParams) {
    this.payParams = payParams;
  }

  public V1ExtraAlipayScan pointAmount(Double pointAmount) {
    this.pointAmount = pointAmount;
    return this;
  }

   /**
   * [ONLY IN RESPONSE] 集分宝金额
   * @return pointAmount
  **/
  @ApiModelProperty(required = true, value = "[ONLY IN RESPONSE] 集分宝金额")
  public Double getPointAmount() {
    return pointAmount;
  }

  public void setPointAmount(Double pointAmount) {
    this.pointAmount = pointAmount;
  }

  public V1ExtraAlipayScan productCode(String productCode) {
    this.productCode = productCode;
    return this;
  }

   /**
   * 销售产品码
   * @return productCode
  **/
  @ApiModelProperty(required = true, value = "销售产品码")
  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public V1ExtraAlipayScan queryOptions(String queryOptions) {
    this.queryOptions = queryOptions;
    return this;
  }

   /**
   * 商户授权查询类型
   * @return queryOptions
  **/
  @ApiModelProperty(required = true, value = "商户授权查询类型")
  public String getQueryOptions() {
    return queryOptions;
  }

  public void setQueryOptions(String queryOptions) {
    this.queryOptions = queryOptions;
  }

  public V1ExtraAlipayScan receiptAmount(Double receiptAmount) {
    this.receiptAmount = receiptAmount;
    return this;
  }

   /**
   * [ONLY IN RESPONSE] 实收金额
   * @return receiptAmount
  **/
  @ApiModelProperty(required = true, value = "[ONLY IN RESPONSE] 实收金额")
  public Double getReceiptAmount() {
    return receiptAmount;
  }

  public void setReceiptAmount(Double receiptAmount) {
    this.receiptAmount = receiptAmount;
  }

  public V1ExtraAlipayScan requestOrgPid(String requestOrgPid) {
    this.requestOrgPid = requestOrgPid;
    return this;
  }

   /**
   * 请求方机构id
   * @return requestOrgPid
  **/
  @ApiModelProperty(required = true, value = "请求方机构id")
  public String getRequestOrgPid() {
    return requestOrgPid;
  }

  public void setRequestOrgPid(String requestOrgPid) {
    this.requestOrgPid = requestOrgPid;
  }

  public V1ExtraAlipayScan scene(String scene) {
    this.scene = scene;
    return this;
  }

   /**
   * 支付场景
   * @return scene
  **/
  @ApiModelProperty(required = true, value = "支付场景")
  public String getScene() {
    return scene;
  }

  public void setScene(String scene) {
    this.scene = scene;
  }

  public V1ExtraAlipayScan storeId(String storeId) {
    this.storeId = storeId;
    return this;
  }

   /**
   * 商户门店编号
   * @return storeId
  **/
  @ApiModelProperty(required = true, value = "商户门店编号")
  public String getStoreId() {
    return storeId;
  }

  public void setStoreId(String storeId) {
    this.storeId = storeId;
  }

  public V1ExtraAlipayScan storeName(String storeName) {
    this.storeName = storeName;
    return this;
  }

   /**
   * [ONLY IN RESPONSE] 商户门店名称
   * @return storeName
  **/
  @ApiModelProperty(required = true, value = "[ONLY IN RESPONSE] 商户门店名称")
  public String getStoreName() {
    return storeName;
  }

  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }

  public V1ExtraAlipayScan terminalId(String terminalId) {
    this.terminalId = terminalId;
    return this;
  }

   /**
   * 商户机具终端编号
   * @return terminalId
  **/
  @ApiModelProperty(required = true, value = "商户机具终端编号")
  public String getTerminalId() {
    return terminalId;
  }

  public void setTerminalId(String terminalId) {
    this.terminalId = terminalId;
  }

  public V1ExtraAlipayScan totalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
    return this;
  }

   /**
   * [ONLY IN RESPONSE] 订单金额
   * @return totalAmount
  **/
  @ApiModelProperty(required = true, value = "[ONLY IN RESPONSE] 订单金额")
  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public V1ExtraAlipayScan voucherDetailList(V1ExtraAlipayVoucherDetailList voucherDetailList) {
    this.voucherDetailList = voucherDetailList;
    return this;
  }

   /**
   * [ONLY IN RESPONSE] 商家优惠明细列表
   * @return voucherDetailList
  **/
  @ApiModelProperty(value = "[ONLY IN RESPONSE] 商家优惠明细列表")
  public V1ExtraAlipayVoucherDetailList getVoucherDetailList() {
    return voucherDetailList;
  }

  public void setVoucherDetailList(V1ExtraAlipayVoucherDetailList voucherDetailList) {
    this.voucherDetailList = voucherDetailList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1ExtraAlipayScan v1ExtraAlipayScan = (V1ExtraAlipayScan) o;
    return Objects.equals(this.advancePaymentType, v1ExtraAlipayScan.advancePaymentType) &&
        Objects.equals(this.authCode, v1ExtraAlipayScan.authCode) &&
        Objects.equals(this.authConfirmMode, v1ExtraAlipayScan.authConfirmMode) &&
        Objects.equals(this.authNo, v1ExtraAlipayScan.authNo) &&
        Objects.equals(this.buyerId, v1ExtraAlipayScan.buyerId) &&
        Objects.equals(this.buyerLogonId, v1ExtraAlipayScan.buyerLogonId) &&
        Objects.equals(this.buyerPayAmount, v1ExtraAlipayScan.buyerPayAmount) &&
        Objects.equals(this.buyerUserId, v1ExtraAlipayScan.buyerUserId) &&
        Objects.equals(this.discountAmount, v1ExtraAlipayScan.discountAmount) &&
        Objects.equals(this.discountGoodsDetail, v1ExtraAlipayScan.discountGoodsDetail) &&
        Objects.equals(this.discountableAmount, v1ExtraAlipayScan.discountableAmount) &&
        Objects.equals(this.extendParams, v1ExtraAlipayScan.extendParams) &&
        Objects.equals(this.fundBillList, v1ExtraAlipayScan.fundBillList) &&
        Objects.equals(this.gmtPayment, v1ExtraAlipayScan.gmtPayment) &&
        Objects.equals(this.goodsDetail, v1ExtraAlipayScan.goodsDetail) &&
        Objects.equals(this.invoiceAmount, v1ExtraAlipayScan.invoiceAmount) &&
        Objects.equals(this.isAsyncPay, v1ExtraAlipayScan.isAsyncPay) &&
        Objects.equals(this.operatorId, v1ExtraAlipayScan.operatorId) &&
        Objects.equals(this.payParams, v1ExtraAlipayScan.payParams) &&
        Objects.equals(this.pointAmount, v1ExtraAlipayScan.pointAmount) &&
        Objects.equals(this.productCode, v1ExtraAlipayScan.productCode) &&
        Objects.equals(this.queryOptions, v1ExtraAlipayScan.queryOptions) &&
        Objects.equals(this.receiptAmount, v1ExtraAlipayScan.receiptAmount) &&
        Objects.equals(this.requestOrgPid, v1ExtraAlipayScan.requestOrgPid) &&
        Objects.equals(this.scene, v1ExtraAlipayScan.scene) &&
        Objects.equals(this.storeId, v1ExtraAlipayScan.storeId) &&
        Objects.equals(this.storeName, v1ExtraAlipayScan.storeName) &&
        Objects.equals(this.terminalId, v1ExtraAlipayScan.terminalId) &&
        Objects.equals(this.totalAmount, v1ExtraAlipayScan.totalAmount) &&
        Objects.equals(this.voucherDetailList, v1ExtraAlipayScan.voucherDetailList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(advancePaymentType, authCode, authConfirmMode, authNo, buyerId, buyerLogonId, buyerPayAmount, buyerUserId, discountAmount, discountGoodsDetail, discountableAmount, extendParams, fundBillList, gmtPayment, goodsDetail, invoiceAmount, isAsyncPay, operatorId, payParams, pointAmount, productCode, queryOptions, receiptAmount, requestOrgPid, scene, storeId, storeName, terminalId, totalAmount, voucherDetailList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1ExtraAlipayScan {\n");
    
    sb.append("    advancePaymentType: ").append(toIndentedString(advancePaymentType)).append("\n");
    sb.append("    authCode: ").append(toIndentedString(authCode)).append("\n");
    sb.append("    authConfirmMode: ").append(toIndentedString(authConfirmMode)).append("\n");
    sb.append("    authNo: ").append(toIndentedString(authNo)).append("\n");
    sb.append("    buyerId: ").append(toIndentedString(buyerId)).append("\n");
    sb.append("    buyerLogonId: ").append(toIndentedString(buyerLogonId)).append("\n");
    sb.append("    buyerPayAmount: ").append(toIndentedString(buyerPayAmount)).append("\n");
    sb.append("    buyerUserId: ").append(toIndentedString(buyerUserId)).append("\n");
    sb.append("    discountAmount: ").append(toIndentedString(discountAmount)).append("\n");
    sb.append("    discountGoodsDetail: ").append(toIndentedString(discountGoodsDetail)).append("\n");
    sb.append("    discountableAmount: ").append(toIndentedString(discountableAmount)).append("\n");
    sb.append("    extendParams: ").append(toIndentedString(extendParams)).append("\n");
    sb.append("    fundBillList: ").append(toIndentedString(fundBillList)).append("\n");
    sb.append("    gmtPayment: ").append(toIndentedString(gmtPayment)).append("\n");
    sb.append("    goodsDetail: ").append(toIndentedString(goodsDetail)).append("\n");
    sb.append("    invoiceAmount: ").append(toIndentedString(invoiceAmount)).append("\n");
    sb.append("    isAsyncPay: ").append(toIndentedString(isAsyncPay)).append("\n");
    sb.append("    operatorId: ").append(toIndentedString(operatorId)).append("\n");
    sb.append("    payParams: ").append(toIndentedString(payParams)).append("\n");
    sb.append("    pointAmount: ").append(toIndentedString(pointAmount)).append("\n");
    sb.append("    productCode: ").append(toIndentedString(productCode)).append("\n");
    sb.append("    queryOptions: ").append(toIndentedString(queryOptions)).append("\n");
    sb.append("    receiptAmount: ").append(toIndentedString(receiptAmount)).append("\n");
    sb.append("    requestOrgPid: ").append(toIndentedString(requestOrgPid)).append("\n");
    sb.append("    scene: ").append(toIndentedString(scene)).append("\n");
    sb.append("    storeId: ").append(toIndentedString(storeId)).append("\n");
    sb.append("    storeName: ").append(toIndentedString(storeName)).append("\n");
    sb.append("    terminalId: ").append(toIndentedString(terminalId)).append("\n");
    sb.append("    totalAmount: ").append(toIndentedString(totalAmount)).append("\n");
    sb.append("    voucherDetailList: ").append(toIndentedString(voucherDetailList)).append("\n");
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

