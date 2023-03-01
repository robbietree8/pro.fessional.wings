package pro.fessional.wings.tiny.mail.sender;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.core.io.Resource;
import pro.fessional.mirana.text.WhiteUtil;

import java.util.Collections;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * @author trydofor
 * @since 2023-01-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TinyMailMessage extends TinyMailConfig {

    /**
     * 邮件的业务ID
     */
    protected Long bizId;

    /**
     * 邮件的业务标记
     */
    protected String bizMark;

    /**
     * 邮件标题
     */
    protected String subject;
    /**
     * 邮件正文
     */
    protected String content;

    /**
     * 邮件附件
     */
    protected Map<String, Resource> attachment = null;

    public Map<String, Resource> getAttachment() {
        return attachment != null ? attachment : Collections.emptyMap();
    }

    public String toMainString() {
        StringBuilder sb = new StringBuilder();
        if (bizId != null) {
            sb.append(" bizId=").append(bizId);
        }
        if (to != null) {
            sb.append(" to=[").append(String.join(",", to)).append(']');
        }
        if (subject != null) {
            sb.append(" subject=").append(subject);
        }
        return sb.toString();
    }

    /**
     * 全部使用that值
     */
    public void adopt(TinyMailMessage that) {
        if (that == null) return;
        super.adopt(that);
        bizId = that.bizId;
        bizMark = that.bizMark;
        subject = that.subject;
        content = that.content;
        attachment = that.attachment;
    }

    /**
     * this值无效时，使用that值
     */
    public void merge(TinyMailMessage that) {
        if (that == null) return;
        super.merge(that);

        if (bizId == null) bizId = that.bizId;
        if (bizMark == null) bizMark = that.bizMark;
        if (isEmpty(subject)) subject = that.subject;
        if (isEmpty(content)) content = that.content;
        if (attachment == null) attachment = that.attachment;
    }

    public boolean asHtml() {
        if (html != null) return html;
        return asHtml(content, true);
    }

    public static boolean asHtml(String str, boolean elze) {
        if (str == null) return elze;

        for (int i = 0, len = str.length(); i < len; i++) {
            char c = str.charAt(0);
            if (WhiteUtil.notWhiteSpace(c)) {
                return c == '<';
            }
        }

        return elze;
    }
}
