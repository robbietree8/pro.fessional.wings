package pro.fessional.wings.warlock.controller.auth;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pro.fessional.wings.slardar.servlet.response.ResponseHelper;
import pro.fessional.wings.warlock.service.auth.WarlockOauthService;
import pro.fessional.wings.warlock.service.auth.WarlockOauthService.OAuth;
import pro.fessional.wings.warlock.spring.prop.WarlockEnabledProp;
import pro.fessional.wings.warlock.spring.prop.WarlockUrlmapProp;

/**
 * 简单的模仿Oauth验证，方便测试和API使用，
 * <a href="https://docs.github.com/en/developers/apps/building-oauth-apps/authorizing-oauth-apps">github authorizing-oauth-apps</a>
 * <a href="https://www.oauth.com/oauth2-servers/authorization/the-authorization-response/">authorization/the-authorization-response</a>
 *
 * @author trydofor
 * @since 2022-11-04
 */
@Slf4j
@Controller
@ConditionalOnProperty(name = WarlockEnabledProp.Key$controllerOauth, havingValue = "true")
public class SimpleOauthController {

    @Setter(onMethod_ = {@Autowired})
    protected WarlockOauthService warlockOauthService;

    @Operation(summary = "简单模拟Oauth2的AuthorizationCode授权", description = """
            # Usage
            参考 https://docs.github.com/en/developers/apps/building-oauth-apps/authorizing-oauth-apps
            参考 https://www.oauth.com/oauth2-servers/authorization/the-authorization-response
            * 默认为标准的302重定向
            * 当Accept: application/json返回json
            * 当Accept: application/xml返回xml
            * 错误时，以error,error_description为key返回
            ## Params
            * @param client_id  - Required. The client ID
            * @param redirect_uri - 重定向或直接返回json格式
            * @param scope - 空格分隔的字符串
            * @param state - 防SCRF攻击，原值返回数据
            * @header Accept  - application/json返回json，application/xml返回xml
            ## Returns
            * @return {302} redirect to redirect_uri
            * @return {200} json/xml
            """)
    @RequestMapping(value = "${" + WarlockUrlmapProp.Key$oauthAuthorize + "}", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<String> authorize(@RequestParam(WarlockOauthService.ClientId) String clientId,
                                            @RequestParam(value = WarlockOauthService.RedirectUri, required = false) String redirectUri,
                                            @RequestParam(value = WarlockOauthService.Scope, required = false) String scope,
                                            @RequestParam(value = WarlockOauthService.State, required = false) String state,
                                            @RequestHeader(value = "Accept", required = false) String accept,
                                            HttpServletRequest request) {
        final HttpSession session = request.getSession(false);
        final String sid = session != null ? session.getId() : null;
        final OAuth data = warlockOauthService.authorizeCode(clientId, scope, redirectUri, sid);
        data.put(WarlockOauthService.State, state);
        return ResponseHelper.flatResponse(data, accept, redirectUri);
    }

    @Operation(summary = "简单模拟Oauth2，仅支持authorization-code和client-credentials模式", description = """
            # Usage
            参考 https://docs.github.com/en/developers/apps/building-oauth-apps/authorizing-oauth-apps
            参考 https://www.oauth.com/oauth2-servers/access-tokens/authorization-code-request/
            参考 https://www.oauth.com/oauth2-servers/access-tokens/client-credentials/
            * 默认为标准的302重定向
            * 当Accept: application/json返回json
            * 当Accept: application/xml返回xml
            * 错误时，以error,error_description为key返回
            * 有效期内（默认1小时），可以使用access_token作为code再次刷新code
            ## Params
            * @param client_id  - Required. The client ID
            * @param client_secret  - Required. The client secret
            * @param code - 有值时为authorization_code, 否则为client_credentials
            * @param redirect_uri - 重定向或直接返回数据
            * @header Accept  - application/json返回json，application/xml返回xml
            ## Returns
            * @return {302} redirect to redirect_uri
            * @return {200} json/xml
            """)
    @RequestMapping(value = "${" + WarlockUrlmapProp.Key$oauthAccessToken + "}", method = {RequestMethod.POST})
    public ResponseEntity<?> accessToken(@RequestParam(WarlockOauthService.ClientId) String clientId,
                                         @RequestParam(WarlockOauthService.ClientSecret) String clientSecret,
                                         @RequestParam(value = WarlockOauthService.Code, required = false) String code,
                                         @RequestParam(value = WarlockOauthService.RedirectUri, required = false) String redirectUri,
                                         @RequestHeader(value = "Accept", required = false) String accept) {

        final OAuth data = warlockOauthService.accessToken(clientId, clientSecret, code);
        return ResponseHelper.flatResponse(data, accept, redirectUri);
    }

    @Operation(summary = "吊销AuthorizationCode或AccessToken授权，应付Token外泄情况", description = """
            # Usage
            * 默认为标准的302重定向
            * 当Accept: application/json返回json
            * 当Accept: application/xml返回xml
            * 错误时，以error,error_description为key返回
            ## Params
            * @param code - Required. 有效的AuthorizationCode或AccessToken
            * @param redirect_uri - 重定向或直接返回json格式
            * @header Accept  - application/json返回json，application/xml返回xml
            ## Returns
            * @return {302} redirect to redirect_uri
            * @return {200} json/xml
            """)
    @RequestMapping(value = "${" + WarlockUrlmapProp.Key$oauthRevokeToken + "}", method = {RequestMethod.POST})
    public ResponseEntity<String> revokeToken(@RequestParam(WarlockOauthService.ClientId) String clientId,
                                              @RequestParam(WarlockOauthService.Code) String code,
                                              @RequestParam(value = WarlockOauthService.RedirectUri, required = false) String redirectUri,
                                              @RequestHeader(value = "Accept", required = false) String accept) {
        final OAuth data = warlockOauthService.revokeToken(clientId, code);
        return ResponseHelper.flatResponse(data, accept, redirectUri);
    }
}
