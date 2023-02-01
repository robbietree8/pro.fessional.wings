package pro.fessional.wings.tiny.mail.sender;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import pro.fessional.mirana.time.StopWatch;

/**
 * @author trydofor
 * @since 2022-12-28
 */
@SpringBootTest(properties = {
        "debug = true",
        "wings.tiny.mail.service.boot-scan=0",
//        "wings.tiny.mail.notice.default.file[application.properties]=classpath:./application.properties"
})
@Slf4j
public class MailNoticeTest {

    @Setter(onMethod_ = {@Autowired})
    protected MailNotice mailNotice;

    @Setter(onMethod_ = {@Value("${QQ_MAIL_USER}")})
    protected String mailTo;

    @Test
    public void testPost() {
        final boolean snd = mailNotice.post("test tiny mail send", "test send");
        Assertions.assertTrue(snd,"可能需要设置 QQ_MAIL_USER, QQ_MAIL_USER");
    }

    @Test
    @Disabled("timing")
    public void testDefault() {
        final StopWatch stopWatch = new StopWatch();
        try (final StopWatch.Watch w = stopWatch.start("emit")) {
            mailNotice.emit("test tiny mail emit", "test emit");
        }
        try (final StopWatch.Watch w = stopWatch.start("post")) {
            mailNotice.post("test tiny mail post", "test post");
        }
        try (final StopWatch.Watch w = stopWatch.start("send")) {
            mailNotice.send("test tiny mail send", "test send");
        }
        log.info(stopWatch.toString());
    }

    @Test
    @Disabled("manual")
    public void testGmail() {
        final TinyMailConfig gmail = mailNotice.provideConfig("gmail", true);
        mailNotice.send(gmail, "test tiny mail gmail", "test gmail");
    }
}
