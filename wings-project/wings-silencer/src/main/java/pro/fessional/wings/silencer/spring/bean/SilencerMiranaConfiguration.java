package pro.fessional.wings.silencer.spring.bean;

import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.fessional.mirana.code.Crc8Long;
import pro.fessional.mirana.code.LeapCode;
import pro.fessional.wings.silencer.spring.prop.SilencerMiranaProp;

import java.util.Arrays;

/**
 * @author trydofor
 * @since 2019-06-26
 */
@Configuration
@RequiredArgsConstructor
public class SilencerMiranaConfiguration {

    private static final Log logger = LogFactory.getLog(SilencerMiranaConfiguration.class);

    private final SilencerMiranaProp silencerMiranaProp;

    @Bean
    public Crc8Long crc8Long() {
        int[] seed = silencerMiranaProp.getCode().getCrc8Long();
        logger.info("Wings make Crc8Long, seed = " + Arrays.toString(seed));
        if (seed == null || seed.length == 0) {
            return new Crc8Long();
        }
        else {
            return new Crc8Long(seed);
        }
    }

    @Bean
    public LeapCode leapCode() {
        String seed = silencerMiranaProp.getCode().getLeapCode();
        logger.info("Wings make LeapCode, seed = " + seed);
        if (seed == null) {
            return new LeapCode();
        }
        else {
            return new LeapCode(seed);
        }
    }
}