package pro.fessional.wings.slardar.spring.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;
import pro.fessional.wings.silencer.spring.boot.ConditionalWingsEnabled;
import pro.fessional.wings.slardar.concur.impl.DebounceInterceptor;
import pro.fessional.wings.slardar.servlet.response.view.PlainTextView;
import pro.fessional.wings.slardar.spring.prop.SlardarDebounceProp;

/**
 * @author trydofor
 * @since 2019-12-03
 */
@Configuration(proxyBeanMethods = false)
@ConditionalWingsEnabled
@EnableConfigurationProperties(SlardarDebounceProp.class)
public class SlardarDebounceConfiguration {

    private static final Log log = LogFactory.getLog(SlardarDebounceConfiguration.class);

    @Bean
    @ConditionalWingsEnabled
    public DebounceInterceptor debounceInterceptor(SlardarDebounceProp debounceProp) {
        final int cap = debounceProp.getCapacity();
        final int max = debounceProp.getMaxWait();
        log.info("SlardarWebmvc spring-bean debounceInterceptor, capacity=" + cap + ", max-wait=" + max);
        final ModelAndView mav = new ModelAndView();
        PlainTextView pv = new PlainTextView(debounceProp.getContentType(), debounceProp.getResponseBody());
        mav.setStatus(HttpStatus.valueOf(debounceProp.getHttpStatus()));
        mav.setView(pv);
        return new DebounceInterceptor(cap, max, mav);
    }
}
