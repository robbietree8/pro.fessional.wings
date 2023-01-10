package pro.fessional.wings.warlock.errorhandle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import pro.fessional.wings.slardar.webmvc.MessageExceptionResolver;
import pro.fessional.wings.slardar.webmvc.MessageResponse;
import pro.fessional.wings.warlock.constants.WarlockOrderConst;

/**
 * @author trydofor
 * @since 2021-03-25
 */
@Slf4j
@Order(WarlockOrderConst.DefaultExceptionResolver)
public class DefaultExceptionResolver extends MessageExceptionResolver<Exception> {

    public DefaultExceptionResolver(MessageResponse defaultBody) {
        super(defaultBody);
    }
}
