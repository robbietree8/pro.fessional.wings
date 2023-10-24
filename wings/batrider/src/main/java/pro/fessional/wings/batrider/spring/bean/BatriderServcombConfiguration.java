package pro.fessional.wings.batrider.spring.bean;

import org.apache.servicecomb.springboot2.starter.EnableServiceComb;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import pro.fessional.wings.batrider.spring.prop.BatriderEnabledProp;
import pro.fessional.wings.batrider.spring.prop.BatriderHandlerProp;

/**
 * @author trydofor
 * @since 2022-08-03
 */
@Configuration(proxyBeanMethods = false)
@EnableServiceComb
@EnableConfigurationProperties({BatriderEnabledProp.class,BatriderHandlerProp.class})
public class BatriderServcombConfiguration {
}
