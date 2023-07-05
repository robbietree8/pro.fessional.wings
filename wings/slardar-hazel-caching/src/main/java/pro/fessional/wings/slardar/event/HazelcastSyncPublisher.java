package pro.fessional.wings.slardar.event;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;
import com.hazelcast.topic.Message;
import com.hazelcast.topic.MessageListener;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationEventPublisher;

import java.util.UUID;

/**
 * ApplicationEventPublisher is a helper. Generally used for non-transactional Event processing, with the following main functions:
 * ① Asynchronous publishing.
 * ② IDE prompt navigation.
 * ③ Hazelcast topic (#HazelcastTopic) in the SpringEvent pattern.
 *
 * @author trydofor
 * @see #HazelcastTopic
 * @since 2021-06-07
 */
@Slf4j
public class HazelcastSyncPublisher implements ApplicationEventPublisher, MessageListener<Object> {

    public static final String HazelcastTopic = "SlardarApplicationEvent";

    private final ApplicationEventPublisher publisher;
    private final ITopic<Object> topic;
    private final UUID uuid;

    public HazelcastSyncPublisher(@NotNull HazelcastInstance instance, @NotNull ApplicationEventPublisher publisher) {
        this.publisher = publisher;
        topic = instance.getTopic(HazelcastTopic);
        uuid = topic.addMessageListener(this);
    }

    public UUID getMessageListenerUuid() {
        return uuid;
    }

    @Override
    public void publishEvent(@NotNull Object event) {
        topic.publish(event);
    }

    @Override
    public void onMessage(Message<Object> message) {
        final Object event = message.getMessageObject();
        log.debug("publish event from hazelcast topic, event={}", event);
        publisher.publishEvent(event);
    }
}
