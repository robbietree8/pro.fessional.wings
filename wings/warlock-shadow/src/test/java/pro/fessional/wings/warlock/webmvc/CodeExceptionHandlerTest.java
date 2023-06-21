package pro.fessional.wings.warlock.webmvc;

import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * @author trydofor
 * @since 2020-06-03
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CodeExceptionHandlerTest {

    @Setter(onMethod_ = {@Autowired})
    private MockMvc mockMvc;

    @Test
    public void testCodeExceptionEn() throws Exception {
        mockMvc.perform(get("/test/code-exception.json")
                       .header("Accept-Language", "en_US"))
               .andDo(print())
               .andExpect(content().json("{\"success\":false,\"code\":\"error.common.assert.empty\",\"message\":\"test should NOT empty\"}"));
    }

    @Test
    public void testCodeExceptionCn() throws Exception {
        mockMvc.perform(get("/test/code-exception.json")
                       .header("Accept-Language", "zh_CN"))
               .andDo(print())
               .andExpect(content().json("{\"success\":false,\"code\":\"error.common.assert.empty\",\"message\":\"test不能为空\"}"));
    }

    @Test
    public void testMessageExceptionEn() throws Exception {
        mockMvc.perform(get("/test/message-exception.json")
                       .header("Accept-Language", "en_US"))
               .andDo(print())
               .andExpect(content().json("{\"success\":false,\"code\":\"error.common.assert.empty\",\"message\":\"test should NOT empty\"}"));
    }

    @Test
    public void testMessageExceptionCn() throws Exception {
        mockMvc.perform(get("/test/message-exception.json")
                       .header("Accept-Language", "zh_CN"))
               .andDo(print())
               .andExpect(content().json("{\"success\":false,\"code\":\"error.common.assert.empty\",\"message\":\"test不能为空\"}"));
    }

    @Test
    public void testFutureExceptionCn() throws Exception {
        mockMvc.perform(get("/test/future-exception.json")
                       .header("Accept-Language", "zh_CN"))
               .andDo(print())
               .andExpect(content().json("{\"success\":false,\"code\":\"error.common.assert.empty\",\"message\":\"test不能为空\"}"));
    }
}
