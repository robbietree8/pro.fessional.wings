package pro.fessional.wings.warlock.security;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pro.fessional.wings.slardar.httprest.okhttp.OkHttpClientHelper;

/**
 * @author trydofor
 * @since 2023-08-28
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class AccessDeny403Test {

    @Setter(onMethod_ = {@Value("http://localhost:${local.server.port}")})
    private String host;

    @Setter(onMethod_ = {@Autowired})
    private OkHttpClient okHttpClient;

    @Test
    public void testAnonymous() {
        final RestTemplate tmpl = new RestTemplate();

        RequestEntity<?> e1 = RequestEntity
                .post(host + "/actuator")
                .accept(MediaType.APPLICATION_JSON)
                .build();
        try {
            tmpl.exchange(e1, String.class);
            Assertions.fail("should 401");
        }
        catch (HttpClientErrorException.Unauthorized e) {
            Assertions.assertEquals(401, e.getStatusCode().value());
        }

        RequestEntity<?> e2 = RequestEntity
                .post(host + "/test/secured-create.json")
                .accept(MediaType.APPLICATION_JSON)
                .build();
        try {
            tmpl.exchange(e2, String.class);
            Assertions.fail("should 403");
        }
        catch (HttpClientErrorException.Forbidden e) {
            Assertions.assertEquals(403, e.getStatusCode().value());
            Assertions.assertTrue(e.getResponseBodyAsString().contains("error.authz.accessDenied"));
        }


        RequestEntity<?> e3 = RequestEntity
                .post(host + "/test/secured-update.json")
                .accept(MediaType.APPLICATION_JSON)
                .build();
        try {
            tmpl.exchange(e3, String.class);
            Assertions.fail("should 403");
        }
        catch (HttpClientErrorException.Forbidden e) {
            Assertions.assertEquals(403, e.getStatusCode().value());
            Assertions.assertTrue(e.getResponseBodyAsString().contains("error.authz.accessDenied"));
        }
    }

    @Test
    public void testLogin() {
        OkHttpClientHelper.clearCookie(okHttpClient, HttpUrl.get(host));
        final Response r0 = OkHttpClientHelper.execute(okHttpClient, new Request.Builder()
                .url(host + "/auth/username/login.json?username=trydofor&password=moMxVKXxA8Pe9XX9"), false);
        String login = OkHttpClientHelper.extractString(r0, false);
        log.info("get login res = " + login);
        Assertions.assertTrue(login.contains("true"));

        // 403
        final Response r1 = OkHttpClientHelper.execute(okHttpClient, new Request.Builder()
                .url(host + "/actuator"), false);
        String ok1 = OkHttpClientHelper.extractString(r1, false);
        log.info(ok1);
        Assertions.assertTrue(ok1.contains("error.authz.accessDenied"));

        final Response r2 = OkHttpClientHelper.execute(okHttpClient, new Request.Builder()
                .url(host + "/test/secured-create.json"), false);
        String ok2 = OkHttpClientHelper.extractString(r2, false);
        Assertions.assertEquals("OK", ok2);

        final Response r3 = OkHttpClientHelper.execute(okHttpClient, new Request.Builder()
                .url(host + "/test/secured-update.json"), false);
        String ok3 = OkHttpClientHelper.extractString(r3, false);
        Assertions.assertTrue(ok3.contains("error.authz.accessDenied"));

        final Response r4 = OkHttpClientHelper.execute(okHttpClient, new Request.Builder()
                .url(host + "/test/prepost-create.json"), false);
        String ok4 = OkHttpClientHelper.extractString(r4, false);
        Assertions.assertEquals("OK", ok4);

        final Response r5 = OkHttpClientHelper.execute(okHttpClient, new Request.Builder()
                .url(host + "/test/prepost-update.json"), false);
        String ok5 = OkHttpClientHelper.extractString(r5, false);
        Assertions.assertTrue(ok5.contains("error.authz.accessDenied"));
    }
}
