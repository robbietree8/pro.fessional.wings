package pro.fessional.wings.slardar.spring.bean;

import com.hazelcast.core.HazelcastInstance;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;
import pro.fessional.wings.spring.consts.OrderedSlardarConst;
import pro.fessional.wings.slardar.event.EventPublishHelper;
import pro.fessional.wings.slardar.event.HazelcastSyncPublisher;

/**
 * @author trydofor
 * @since 2019-12-03
 */
@Configuration(proxyBeanMethods = false)
@AutoConfigureOrder(OrderedSlardarConst.HazelcastPublisherConfiguration)
public class HazelcastPublisherConfiguration {

    private static final Log log = LogFactory.getLog(HazelcastPublisherConfiguration.class);

    @Autowired
    public void autowireHazelcastSyncPublisher(HazelcastInstance instance, ApplicationEventPublisher publisher) {
        HazelcastSyncPublisher global = new HazelcastSyncPublisher(instance, publisher);
        EventPublishHelper.setGlobalPublisher(global);
        log.info("SlardarHazelCaching spring-auto initHazelcastSyncPublisher, uuid=" + global.getMessageListenerUuid());
    }
}