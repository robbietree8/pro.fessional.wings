package pro.fessional.wings.slardar.spring.bean;

import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.fessional.mirana.time.DateParser;
import pro.fessional.wings.slardar.jackson.AutoRegisterPropertyFilter;
import pro.fessional.wings.slardar.jackson.EmptyValuePropertyFilter;
import pro.fessional.wings.slardar.jackson.I18nResultPropertyFilter;
import pro.fessional.wings.slardar.spring.prop.SlardarEnabledProp;
import pro.fessional.wings.slardar.spring.prop.SlardarJacksonProp;
import pro.fessional.wings.slardar.spring.prop.SlardarNumberProp;

import java.time.LocalDate;

/**
 * @author trydofor
 * @link <a href="https://docs.spring.io/spring-boot/docs/3.0.3/reference/htmlsingle/#howto.spring-mvc.customize-jackson-objectmapper">Customize the Jackson ObjectMapper</a>
 * @see InstantDeserializer#ZONED_DATE_TIME
 * @since 2019-06-26
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(DateSerializer.class)
@ConditionalOnProperty(name = SlardarEnabledProp.Key$jackson, havingValue = "true")
@EnableConfigurationProperties({SlardarJacksonProp.class, SlardarNumberProp.class})
@RequiredArgsConstructor
public class SlardarJacksonConfiguration {

    private static final Log log = LogFactory.getLog(SlardarJacksonConfiguration.class);

    private final SlardarJacksonProp slardarJacksonProp;
    private final MessageSource messageSource;


    @Bean
    @ConditionalOnProperty(name = SlardarJacksonProp.Key$i18nResult, havingValue = "true")
    public AutoRegisterPropertyFilter i18nResultPropertyFilter() {
        log.info("Slardar spring-bean i18nResultPropertyFilter");
        return new I18nResultPropertyFilter(messageSource);
    }

    @Bean
    // "${logging.enabled:true} and '${logging.level}'.equals('DEBUG')"
    @ConditionalOnExpression("T(org.springframework.util.StringUtils).hasText('${" + SlardarJacksonProp.Key$emptyDate + "}') "
                             + "|| ${" + SlardarJacksonProp.Key$emptyList + ":false}"
                             + "|| ${" + SlardarJacksonProp.Key$emptyMap + ":false}"
    )
    public AutoRegisterPropertyFilter emptyValuePropertyFilter() {
        log.info("Slardar spring-bean emptyValuePropertyFilter");

        final LocalDate ed = slardarJacksonProp.getEmptyDate() == null ? null :
                             DateParser.parseDate(slardarJacksonProp.getEmptyDate());
        return new EmptyValuePropertyFilter(ed,
                slardarJacksonProp.getEmptyDateOffset(),
                slardarJacksonProp.isEmptyList(),
                slardarJacksonProp.isEmptyMap()
        );
    }

}
