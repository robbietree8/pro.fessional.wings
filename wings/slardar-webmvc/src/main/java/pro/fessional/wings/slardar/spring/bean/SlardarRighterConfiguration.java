package pro.fessional.wings.slardar.spring.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import pro.fessional.wings.silencer.spring.boot.ConditionalWingsEnabled;
import pro.fessional.wings.slardar.concur.impl.RighterExceptionResolver;
import pro.fessional.wings.slardar.concur.impl.RighterInterceptor;
import pro.fessional.wings.slardar.spring.prop.SlardarRighterProp;

/**
 * @author trydofor
 * @since 2019-06-29
 */
@Configuration(proxyBeanMethods = false)
@ConditionalWingsEnabled
@EnableConfigurationProperties(SlardarRighterProp.class)
public class SlardarRighterConfiguration {
    private final static Log log = LogFactory.getLog(SlardarRighterConfiguration.class);


    @Bean
    @ConditionalWingsEnabled
    public RighterInterceptor righterInterceptor(ObjectProvider<RighterInterceptor.SecretProvider> secretProvider, SlardarRighterProp prop) {
        log.info("SlardarWebmvc spring-bean righterInterceptor");
        final RighterInterceptor bean = new RighterInterceptor(prop);
        secretProvider.ifAvailable(bean::setSecretProvider);
        return bean;
    }

    @Bean
    @ConditionalWingsEnabled
    public HandlerExceptionResolver righterExceptionResolver(SlardarRighterProp prop) {
        log.info("SlardarWebmvc spring-bean righterExceptionResolver");
        return new RighterExceptionResolver(prop);
    }
}
