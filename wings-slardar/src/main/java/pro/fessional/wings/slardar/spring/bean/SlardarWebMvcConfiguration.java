package pro.fessional.wings.slardar.spring.bean;

import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pro.fessional.wings.slardar.concur.impl.FirstBloodInterceptor;

/**
 * @author trydofor
 * @since 2019-12-03
 */
@Configuration
@RequiredArgsConstructor
public class SlardarWebMvcConfiguration implements WebMvcConfigurer {
    private static final Log logger = LogFactory.getLog(SlardarWebMvcConfiguration.class);
    private final ObjectProvider<FirstBloodInterceptor> firstBloodInterceptor;
    private final ObjectProvider<Converter<?, ?>> converters;

    @Override
    public void addInterceptors(@NotNull InterceptorRegistry registry) {

        final FirstBloodInterceptor bean = firstBloodInterceptor.getIfAvailable();
        if (bean != null) {
            logger.info("Wings conf firstBloodInterceptor=" + bean.getClass().getName());
            registry.addInterceptor(bean);
        }
    }

    @Override
    public void addFormatters(@NotNull FormatterRegistry registry) {
        for (Converter<?, ?> bean : converters) {
            logger.info("Wings conf Formatters.Converter=" + bean.getClass().getName());
            registry.addConverter(bean);
        }
    }
}
