package pro.fessional.wings.warlock.spring.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.fessional.wings.spring.consts.OrderedWarlockConst;
import pro.fessional.wings.warlock.service.auth.impl.DefaultDaoAuthnCombo;
import pro.fessional.wings.warlock.service.grant.WarlockGrantService;
import pro.fessional.wings.warlock.service.grant.impl.WarlockGrantServiceImpl;
import pro.fessional.wings.warlock.service.perm.WarlockPermService;
import pro.fessional.wings.warlock.service.perm.WarlockRoleService;
import pro.fessional.wings.warlock.service.perm.impl.WarlockPermServiceImpl;
import pro.fessional.wings.warlock.service.perm.impl.WarlockRoleServiceImpl;
import pro.fessional.wings.warlock.service.user.WarlockUserAuthnService;
import pro.fessional.wings.warlock.service.user.WarlockUserBasisService;
import pro.fessional.wings.warlock.service.user.WarlockUserLoginService;
import pro.fessional.wings.warlock.service.user.impl.WarlockUserAuthnServiceImpl;
import pro.fessional.wings.warlock.service.user.impl.WarlockUserBasisServiceImpl;
import pro.fessional.wings.warlock.service.user.impl.WarlockUserLoginServiceImpl;
import pro.fessional.wings.warlock.spring.prop.WarlockEnabledProp;


/**
 * @author trydofor
 * @since 2019-12-01
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(name = WarlockEnabledProp.Key$securityBean, havingValue = "true")
@AutoConfigureBefore(WarlockSecurityBeanConfiguration.class)
@AutoConfigureOrder(OrderedWarlockConst.BondBeanConfiguration)
public class WarlockBondBeanConfiguration {

    private final static Log log = LogFactory.getLog(WarlockBondBeanConfiguration.class);

    ///////// AuthZ & AuthN /////////

    @Bean
    @ConditionalOnMissingBean(DefaultDaoAuthnCombo.class)
    public DefaultDaoAuthnCombo defaultDaoAuthnCombo() {
        log.info("WarlockBond spring-bean defaultDaoAuthnCombo");
        return new DefaultDaoAuthnCombo();
    }

    @Bean
    @ConditionalOnMissingBean(WarlockGrantService.class)
    public WarlockGrantService warlockGrantService() {
        // 存在子类，则不需要此bean，如JustAuthUserAuthnAutoReg
        log.info("WarlockBond spring-bean warlockGrantService");
        return new WarlockGrantServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean(WarlockPermService.class)
    public WarlockPermService warlockPermService() {
        log.info("WarlockBond spring-bean warlockPermService");
        return new WarlockPermServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean(WarlockRoleService.class)
    public WarlockRoleService warlockRoleService() {
        log.info("WarlockBond spring-bean warlockRoleService");
        return new WarlockRoleServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean(WarlockUserAuthnService.class)
    public WarlockUserAuthnService warlockUserAuthnService() {
        log.info("WarlockBond spring-bean warlockUserAuthnService");
        return new WarlockUserAuthnServiceImpl();
    }

    ///////// UserDetails /////////
    @Bean
    @ConditionalOnMissingBean(WarlockUserBasisService.class)
    public WarlockUserBasisService warlockUserBasisService() {
        log.info("WarlockBond spring-bean warlockUserBasisService");
        return new WarlockUserBasisServiceImpl();
    }

    ///////// login /////////

    @Bean
    @ConditionalOnMissingBean(WarlockUserLoginService.class)
    public WarlockUserLoginService warlockUserLoginService() {
        log.info("WarlockBond spring-bean warlockUserLoginService");
        return new WarlockUserLoginServiceImpl();
    }

}
