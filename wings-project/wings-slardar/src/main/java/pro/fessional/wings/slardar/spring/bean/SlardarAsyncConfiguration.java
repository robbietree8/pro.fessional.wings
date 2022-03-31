package pro.fessional.wings.slardar.spring.bean;

import com.alibaba.ttl.threadpool.TtlExecutors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration;
import org.springframework.boot.task.TaskExecutorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import pro.fessional.wings.slardar.spring.prop.SlardarEnabledProp;

import java.util.concurrent.Executor;

import static org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration.APPLICATION_TASK_EXECUTOR_BEAN_NAME;
import static org.springframework.scheduling.annotation.AsyncAnnotationBeanPostProcessor.DEFAULT_TASK_EXECUTOR_BEAN_NAME;

/**
 * https://docs.spring.io/spring-boot/docs/2.6.4/reference/htmlsingle/#features.task-execution-and-scheduling
 * https://github.com/alibaba/transmittable-thread-local
 *
 * @author trydofor
 * @see TaskExecutionAutoConfiguration
 * @see TaskSchedulingAutoConfiguration
 * @since 2019-12-03
 */
@EnableAsync
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(name = SlardarEnabledProp.Key$async, havingValue = "true")
public class SlardarAsyncConfiguration {

    private static final Log logger = LogFactory.getLog(SlardarAsyncConfiguration.class);

    @Bean(name = DEFAULT_TASK_EXECUTOR_BEAN_NAME)
    public Executor taskExecutor(TaskExecutorBuilder builder) {
        logger.info("Wings conf TtlExecutor for taskExecutor");
        return ttlExecutor(builder);
    }

    @Bean(name = APPLICATION_TASK_EXECUTOR_BEAN_NAME)
    public AsyncTaskExecutor applicationTaskExecutor(TaskExecutorBuilder builder) {
        logger.info("Wings conf TtlExecutor for applicationTaskExecutor");
        final Executor executor = ttlExecutor(builder);
        return new ConcurrentTaskExecutor(executor);
    }

    private Executor ttlExecutor(TaskExecutorBuilder builder) {
        final ThreadPoolTaskExecutor executor = builder.build();
        executor.initialize();
        return TtlExecutors.getTtlExecutor(executor);
    }
}
