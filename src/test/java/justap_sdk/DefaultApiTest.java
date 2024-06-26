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


package justap_sdk;

import io.swagger.client.model.GooglerpcStatus;
import io.swagger.client.model.RpcStatus;
import io.swagger.client.model.V1BusinessUser;
import io.swagger.client.model.V1ChargeListResponse;
import io.swagger.client.model.V1ChargeResponse;
import io.swagger.client.model.V1CreateChargeRequest;
import io.swagger.client.model.V1CreateRefundRequest;
import io.swagger.client.model.V1CreateRoyaltyRequest;
import io.swagger.client.model.V1CreateSettlementAccountRequest;
import io.swagger.client.model.V1CreateUserRequest;
import io.swagger.client.model.V1DeleteSettlementAccountResponse;
import io.swagger.client.model.V1DeleteUserResponse;
import io.swagger.client.model.V1ListAllRoyaltiesResponse;
import io.swagger.client.model.V1RefundListResponse;
import io.swagger.client.model.V1RefundResponse;
import io.swagger.client.model.V1RoyaltyResponse;
import io.swagger.client.model.V1SettlementAccountListResponse;
import io.swagger.client.model.V1SettlementAccountResponse;
import io.swagger.client.model.V1UpdateAndPatchRequestBody;
import io.swagger.client.model.V1UserListResponse;
import io.swagger.client.model.V1UserResponse;
import org.junit.Test;
import org.junit.Ignore;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DefaultApi
 */
@Ignore
public class DefaultApiTest {

    private final DefaultApi api = new DefaultApi();

    
    /**
     * 创建 Business User 对象
     *
     * 创建 Business User 对象。商业用户是本系统中的一种账户类型，在交易完成之后可以对该类型的账户进行分账等操作。
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void businessUserServiceCreateUserTest() throws Exception {
        V1CreateUserRequest body = null;
        V1UserResponse response = api.businessUserServiceCreateUser(body);

        // TODO: test validations
    }
    
    /**
     * 删除 Business User 对象
     *
     * 删除 Business User 对象
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void businessUserServiceDeleteUserTest() throws Exception {
        String id = null;
        String appId = null;
        V1DeleteUserResponse response = api.businessUserServiceDeleteUser(id, appId);

        // TODO: test validations
    }
    
    /**
     * 查询 Business User 对象列表
     *
     * 查询 Business User 对象列表
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void businessUserServiceListAllUsersTest() throws Exception {
        String appId = null;
        Integer limit = null;
        String startingAfter = null;
        String endingBefore = null;
        Long createdLt = null;
        Long createdLte = null;
        Long createdGt = null;
        Long createdGte = null;
        Boolean disabled = null;
        V1UserListResponse response = api.businessUserServiceListAllUsers(appId, limit, startingAfter, endingBefore, createdLt, createdLte, createdGt, createdGte, disabled);

        // TODO: test validations
    }
    
    /**
     * 查询 Business User 对象
     *
     * 查询 Business User 对象
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void businessUserServiceRetrieveUserTest() throws Exception {
        String id = null;
        String appId = null;
        V1UserResponse response = api.businessUserServiceRetrieveUser(id, appId);

        // TODO: test validations
    }
    
    /**
     * 查询 Business User 对象列表
     *
     * 查询 Business User 对象列表
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void businessUserServiceSearchUsersTest() throws Exception {
        String appId = null;
        Integer limit = null;
        Long createdLt = null;
        Long createdLte = null;
        Long createdGt = null;
        Long createdGte = null;
        String email = null;
        String name = null;
        String phone = null;
        V1UserListResponse response = api.businessUserServiceSearchUsers(appId, limit, createdLt, createdLte, createdGt, createdGte, email, name, phone);

        // TODO: test validations
    }
    
    /**
     * 更新 Business User 对象
     *
     * 更新 Business User 对象
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void businessUserServiceUpdateUserTest() throws Exception {
        String userId = null;
        V1BusinessUser body = null;
        String updateMask = null;
        V1UserResponse response = api.businessUserServiceUpdateUser(userId, body, updateMask);

        // TODO: test validations
    }
    
    /**
     * 更新 Business User 对象
     *
     * 更新 Business User 对象
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void businessUserServiceUpdateUser2Test() throws Exception {
        String userId = null;
        V1BusinessUser body = null;
        String updateMask = null;
        V1UserResponse response = api.businessUserServiceUpdateUser2(userId, body, updateMask);

        // TODO: test validations
    }
    
    /**
     * 创建 Charge 对象
     *
     * 发起一次支付请求时需要创建一个新的 charge 对象，获取一个可用的支付凭据用于客户端向第三方渠道发起支付请求。如果使用测试模式的 API Key，则不会发生真实交易。当支付成功后，会发送 Webhooks 通知。
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void chargeServiceChargesTest() throws Exception {
        V1CreateChargeRequest body = null;
        V1ChargeResponse response = api.chargeServiceCharges(body);

        // TODO: test validations
    }
    
    /**
     * 创建 Charge 对象
     *
     * 发起一次支付请求时需要创建一个新的 charge 对象，获取一个可用的支付凭据用于客户端向第三方渠道发起支付请求。如果使用测试模式的 API Key，则不会发生真实交易。当支付成功后，会发送 Webhooks 通知。
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void chargeServiceCharges2Test() throws Exception {
        V1CreateChargeRequest body = null;
        V1ChargeResponse response = api.chargeServiceCharges2(body);

        // TODO: test validations
    }
    
    /**
     * 查询 Charge 对象
     *
     * 你可以在后台异步通知之前，通过查询接口确认支付状态。通过charge对象的id查询一个已创建的charge对象。
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void chargeServiceQueryChargeTest() throws Exception {
        String chargeId = null;
        String appId = null;
        String merchantTradeId = null;
        V1ChargeResponse response = api.chargeServiceQueryCharge(chargeId, appId, merchantTradeId);

        // TODO: test validations
    }
    
    /**
     * 查询 Charge 对象
     *
     * 你可以在后台异步通知之前，通过查询接口确认支付状态。通过charge对象的id查询一个已创建的charge对象。
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void chargeServiceQueryCharge2Test() throws Exception {
        String chargeId = null;
        String appId = null;
        String merchantTradeId = null;
        V1ChargeResponse response = api.chargeServiceQueryCharge2(chargeId, appId, merchantTradeId);

        // TODO: test validations
    }
    
    /**
     * 查询 Charge 对象
     *
     * 你可以在后台异步通知之前，通过查询接口确认支付状态。通过charge对象的id查询一个已创建的charge对象。
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void chargeServiceQueryCharge3Test() throws Exception {
        String merchantTradeId = null;
        String chargeId = null;
        String appId = null;
        V1ChargeResponse response = api.chargeServiceQueryCharge3(merchantTradeId, chargeId, appId);

        // TODO: test validations
    }
    
    /**
     * 查询 Charge 对象列表
     *
     * 返回之前创建过 charge 对象的一个列表。列表是按创建时间进行排序，总是将最新的 charge 对象显示在最前。如果不设置 created 参数，默认查询近一个月的数据；设置了 created 参数，会按照对应的时间段查询。
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void chargeServiceQueryChargeListTest() throws Exception {
        String appId = null;
        Integer limit = null;
        String startingAfter = null;
        String endingBefore = null;
        String merchantTradeId = null;
        Long createdLt = null;
        Long createdLte = null;
        Long createdGt = null;
        Long createdGte = null;
        String channel = null;
        Boolean paid = null;
        Boolean refunded = null;
        Boolean reversed = null;
        Boolean closed = null;
        Boolean expired = null;
        V1ChargeListResponse response = api.chargeServiceQueryChargeList(appId, limit, startingAfter, endingBefore, merchantTradeId, createdLt, createdLte, createdGt, createdGte, channel, paid, refunded, reversed, closed, expired);

        // TODO: test validations
    }
    
    /**
     * 查询 Charge 对象列表
     *
     * 返回之前创建过 charge 对象的一个列表。列表是按创建时间进行排序，总是将最新的 charge 对象显示在最前。如果不设置 created 参数，默认查询近一个月的数据；设置了 created 参数，会按照对应的时间段查询。
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void chargeServiceQueryChargeList2Test() throws Exception {
        String appId = null;
        Integer limit = null;
        String startingAfter = null;
        String endingBefore = null;
        String merchantTradeId = null;
        Long createdLt = null;
        Long createdLte = null;
        Long createdGt = null;
        Long createdGte = null;
        String channel = null;
        Boolean paid = null;
        Boolean refunded = null;
        Boolean reversed = null;
        Boolean closed = null;
        Boolean expired = null;
        V1ChargeListResponse response = api.chargeServiceQueryChargeList2(appId, limit, startingAfter, endingBefore, merchantTradeId, createdLt, createdLte, createdGt, createdGte, channel, paid, refunded, reversed, closed, expired);

        // TODO: test validations
    }
    
    /**
     * 撤销 Charge 对象
     *
     * 针对已经创建的 Charge，你可以调用撤销接口进行交易的关闭。接口支持对于未成功付款的订单进行撤销，则关闭交易。调用此接口后用户后期不能支付成功。  注：撤销订单在不同收单机构会有不同的行为。对于成功付款的订单请使用 退款 接口进行退款处理。只有针对未支付的订单，我们建议你调用撤销接口。  - 微信支付：如果此订单用户支付失败，微信支付系统会将此订单关闭；如果用户支付成功，微信支付系统会将此订单资金退还给用户。(7天以内的交易单可调用撤销) - 支付宝：如果此订单用户支付失败，支付宝系统会将此订单关闭；如果用户支付成功，支付宝系统会将此订单资金退还给用户。
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void chargeServiceReverseChargeTest() throws Exception {
        String chargeId = null;
        V1ChargeResponse response = api.chargeServiceReverseCharge(chargeId);

        // TODO: test validations
    }
    
    /**
     * 撤销 Charge 对象
     *
     * 针对已经创建的 Charge，你可以调用撤销接口进行交易的关闭。接口支持对于未成功付款的订单进行撤销，则关闭交易。调用此接口后用户后期不能支付成功。  注：撤销订单在不同收单机构会有不同的行为。对于成功付款的订单请使用 退款 接口进行退款处理。只有针对未支付的订单，我们建议你调用撤销接口。  - 微信支付：如果此订单用户支付失败，微信支付系统会将此订单关闭；如果用户支付成功，微信支付系统会将此订单资金退还给用户。(7天以内的交易单可调用撤销) - 支付宝：如果此订单用户支付失败，支付宝系统会将此订单关闭；如果用户支付成功，支付宝系统会将此订单资金退还给用户。
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void chargeServiceReverseCharge2Test() throws Exception {
        String chargeId = null;
        V1ChargeResponse response = api.chargeServiceReverseCharge2(chargeId);

        // TODO: test validations
    }
    
    /**
     * 查询 Refund 对象
     *
     * 可以通过 charge 对象的查询接口查询某一个 charge 对象的退款列表，也可以通过 refund 对象的 id 查询一个已创建的 refund 对象。可以在 Webhooks 通知之前，通过查询接口确认退款状态。
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void refundServiceQueryRefundTest() throws Exception {
        String chargeId = null;
        String refundId = null;
        String appId = null;
        V1RefundResponse response = api.refundServiceQueryRefund(chargeId, refundId, appId);

        // TODO: test validations
    }
    
    /**
     * 查询 Refund 对象
     *
     * 可以通过 charge 对象的查询接口查询某一个 charge 对象的退款列表，也可以通过 refund 对象的 id 查询一个已创建的 refund 对象。可以在 Webhooks 通知之前，通过查询接口确认退款状态。
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void refundServiceQueryRefund2Test() throws Exception {
        String refundId = null;
        String chargeId = null;
        String appId = null;
        V1RefundResponse response = api.refundServiceQueryRefund2(refundId, chargeId, appId);

        // TODO: test validations
    }
    
    /**
     * 查询 Refund 对象列表
     *
     * 返回之前创建 charge 对象的一个 refund 对象列表。列表是按创建时间进行排序，总是将最新的 refund 对象显示在最前。
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void refundServiceQueryRefundListTest() throws Exception {
        String chargeId = null;
        String appId = null;
        Integer limit = null;
        String startingAfter = null;
        String endingBefore = null;
        V1RefundListResponse response = api.refundServiceQueryRefundList(chargeId, appId, limit, startingAfter, endingBefore);

        // TODO: test validations
    }
    
    /**
     * 查询 Refund 对象列表
     *
     * 返回之前创建 charge 对象的一个 refund 对象列表。列表是按创建时间进行排序，总是将最新的 refund 对象显示在最前。
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void refundServiceQueryRefundList2Test() throws Exception {
        String chargeId = null;
        String appId = null;
        Integer limit = null;
        String startingAfter = null;
        String endingBefore = null;
        V1RefundListResponse response = api.refundServiceQueryRefundList2(chargeId, appId, limit, startingAfter, endingBefore);

        // TODO: test validations
    }
    
    /**
     * 创建 Refund 对象
     *
     * 通过发起一次退款请求创建一个新的 refund 对象，只能对已经发生交易并且没有全额退款的 charge 对象发起退款。当进行全额退款之前，可以进行多次退款，直至全额退款。当一次退款成功后，会发送 Webhooks 通知。
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void refundServiceRefundsTest() throws Exception {
        V1CreateRefundRequest body = null;
        V1RefundResponse response = api.refundServiceRefunds(body);

        // TODO: test validations
    }
    
    /**
     * 创建 Refund 对象
     *
     * 通过发起一次退款请求创建一个新的 refund 对象，只能对已经发生交易并且没有全额退款的 charge 对象发起退款。当进行全额退款之前，可以进行多次退款，直至全额退款。当一次退款成功后，会发送 Webhooks 通知。
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void refundServiceRefunds2Test() throws Exception {
        V1CreateRefundRequest body = null;
        V1RefundResponse response = api.refundServiceRefunds2(body);

        // TODO: test validations
    }
    
    /**
     * 创建 Royalty 对象
     *
     * 对一个 Charge 对象进行分账，分账的金额和分账接收方由 Royalty 对象指定。Royalty 创建仅代表本系统成功接收分账申请，尚未提交到支付机构清分，更不代表分账立即成功，相关结果信息请调用查询接口确认
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void royaltyServiceCreateRoyaltyTest() throws Exception {
        V1CreateRoyaltyRequest body = null;
        V1RoyaltyResponse response = api.royaltyServiceCreateRoyalty(body);

        // TODO: test validations
    }
    
    /**
     * 查询 Royalty 对象列表
     *
     * 查询 Royalty 对象的列表信息
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void royaltyServiceListAllRoyaltiesTest() throws Exception {
        Integer limit = null;
        String startingAfter = null;
        String endingBefore = null;
        String merchantTradeId = null;
        Long createdLt = null;
        Long createdLte = null;
        Long createdGt = null;
        Long createdGte = null;
        String appId = null;
        String settleAccountId = null;
        String royaltySettlementId = null;
        V1ListAllRoyaltiesResponse response = api.royaltyServiceListAllRoyalties(limit, startingAfter, endingBefore, merchantTradeId, createdLt, createdLte, createdGt, createdGte, appId, settleAccountId, royaltySettlementId);

        // TODO: test validations
    }
    
    /**
     * 查询 Royalty 对象
     *
     * 查询 Royalty 对象的信息
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void royaltyServiceRetrieveRoyaltyTest() throws Exception {
        String id = null;
        V1RoyaltyResponse response = api.royaltyServiceRetrieveRoyalty(id);

        // TODO: test validations
    }
    
    /**
     * 创建结算账户
     *
     * 为用户创建一个结算账户。添加结算账户信息后方可对该用进行分账、余额充值、转账等操作。
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void settlementServiceCreateSettlementAccountTest() throws Exception {
        V1CreateSettlementAccountRequest body = null;
        V1SettlementAccountResponse response = api.settlementServiceCreateSettlementAccount(body);

        // TODO: test validations
    }
    
    /**
     * 删除结算账户
     *
     * 删除结算账户
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void settlementServiceDeleteSettlementAccountTest() throws Exception {
        String id = null;
        String appId = null;
        V1DeleteSettlementAccountResponse response = api.settlementServiceDeleteSettlementAccount(id, appId);

        // TODO: test validations
    }
    
    /**
     * 查询结算账户列表
     *
     * 查询结算账户列表
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void settlementServiceListAllSettlementAccountsTest() throws Exception {
        String appId = null;
        Integer limit = null;
        String startingAfter = null;
        String endingBefore = null;
        Long createdLt = null;
        Long createdLte = null;
        Long createdGt = null;
        Long createdGte = null;
        Boolean disabled = null;
        String customerId = null;
        String businessUserId = null;
        V1SettlementAccountListResponse response = api.settlementServiceListAllSettlementAccounts(appId, limit, startingAfter, endingBefore, createdLt, createdLte, createdGt, createdGte, disabled, customerId, businessUserId);

        // TODO: test validations
    }
    
    /**
     * 查询结算账户
     *
     * 查询结算账户
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void settlementServiceRetrieveSettlementAccountTest() throws Exception {
        String id = null;
        String appId = null;
        String object = null;
        String dataId = null;
        String dataAppId = null;
        String dataBusinessUserId = null;
        String dataCustomerId = null;
        String dataChannel = null;
        String dataRecipientWechatpayAccount = null;
        String dataRecipientWechatpayName = null;
        Boolean dataRecipientWechatpayForceCheck = null;
        String dataRecipientWechatpayType = null;
        String dataRecipientWechatpayAccountType = null;
        String dataRecipientWechatpayAppId = null;
        String dataRecipientWechatpaySubAppId = null;
        String dataRecipientPaymentAlipayAccount = null;
        String dataRecipientPaymentAlipayName = null;
        String dataRecipientPaymentAlipayType = null;
        String dataRecipientPaymentAlipayAccountType = null;
        String dataRecipientBankAccount = null;
        String dataRecipientBankName = null;
        String dataRecipientBankType = null;
        String dataRecipientBankBankName = null;
        String dataRecipientBankBankBranch = null;
        String dataRecipientBankBankProvince = null;
        String dataRecipientBankBankCity = null;
        String dataRecipientYsepayMerchantDivisionMerUsercode = null;
        Long dataCreated = null;
        Long dataUpdated = null;
        String dataObject = null;
        V1SettlementAccountResponse response = api.settlementServiceRetrieveSettlementAccount(id, appId, object, dataId, dataAppId, dataBusinessUserId, dataCustomerId, dataChannel, dataRecipientWechatpayAccount, dataRecipientWechatpayName, dataRecipientWechatpayForceCheck, dataRecipientWechatpayType, dataRecipientWechatpayAccountType, dataRecipientWechatpayAppId, dataRecipientWechatpaySubAppId, dataRecipientPaymentAlipayAccount, dataRecipientPaymentAlipayName, dataRecipientPaymentAlipayType, dataRecipientPaymentAlipayAccountType, dataRecipientBankAccount, dataRecipientBankName, dataRecipientBankType, dataRecipientBankBankName, dataRecipientBankBankBranch, dataRecipientBankBankProvince, dataRecipientBankBankCity, dataRecipientYsepayMerchantDivisionMerUsercode, dataCreated, dataUpdated, dataObject);

        // TODO: test validations
    }
    
    /**
     * 查询结算账户列表
     *
     * 查询结算账户列表
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void settlementServiceSearchSettlementAccountsTest() throws Exception {
        String userId = null;
        String appId = null;
        V1SettlementAccountListResponse response = api.settlementServiceSearchSettlementAccounts(userId, appId);

        // TODO: test validations
    }
    
    /**
     * 更新结算账户
     *
     * 更新结算账户
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void settlementServiceUpdateSettlementAccountTest() throws Exception {
        String settlementAccountId = null;
        V1UpdateAndPatchRequestBody body = null;
        String updateMask = null;
        V1SettlementAccountResponse response = api.settlementServiceUpdateSettlementAccount(settlementAccountId, body, updateMask);

        // TODO: test validations
    }
    
    /**
     * 更新结算账户
     *
     * 更新结算账户
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void settlementServiceUpdateSettlementAccount2Test() throws Exception {
        String settlementAccountId = null;
        V1UpdateAndPatchRequestBody body = null;
        String updateMask = null;
        V1SettlementAccountResponse response = api.settlementServiceUpdateSettlementAccount2(settlementAccountId, body, updateMask);

        // TODO: test validations
    }
    
}
