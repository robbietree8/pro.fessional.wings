package pro.fessional.wings.warlock.service.lightid.impl;

import com.hazelcast.core.HazelcastInstance;
import io.qameta.allure.TmsLink;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pro.fessional.mirana.id.LightIdBufferedProvider;
import pro.fessional.mirana.id.LightIdProvider;
import pro.fessional.wings.faceless.service.lightid.impl.BlockingLightIdProvider;
import pro.fessional.wings.slardar.service.lightid.HazelcastLightIdProvider;

/**
 * @author trydofor
 * @since 2023-07-18
 */
@SpringBootTest(properties = {
        "debug=false",
        "logging.level.root=WARN"
})
@Slf4j
@Disabled("Benchmark: light id provider")
public class AllLightIdProviderPerformTest {

    @Setter(onMethod_ = {@Autowired})
    private LightIdProvider.Loader lightIdLoader;
    @Setter(onMethod_ = {@Autowired})
    private HazelcastInstance hazelcastInstance;

    @Test
    @TmsLink("C14058")
    public void testJvm() {
        // avg=0.039ms
        test(new LightIdBufferedProvider(lightIdLoader), 1000);
    }

    @Test
    @TmsLink("C14059")
    public void testHz() {
        // avg=1.065ms
        test(new HazelcastLightIdProvider(lightIdLoader, hazelcastInstance), 1000);
    }

    @Test
    @TmsLink("C14060")
    public void testDb() {
        // avg=10.723ms, 5ms per sql
        test(new BlockingLightIdProvider(lightIdLoader), 1000);
    }

    public void test(LightIdProvider provider, int count) {
        final String key = "sys_commit_journal";
        final int blk = 0;
        long pre = provider.next(key, blk);

        final long now = System.nanoTime();
        for (int i = 0; i < count; i++) {
            final long id = provider.next(key, blk, 2000);
            Assertions.assertEquals(pre + 1, id, "ID's are not continuous increment");
            pre = id;
        }
        long cost = System.nanoTime() - now;

        final String str = String.format("provider=%s, count=%,d, cost=%,.3fms, avg=%,.3fms",
                provider.getClass().getSimpleName(),
                count,
                cost * 1D / 1_000_000,
                cost * 1D / (count * 1_000_000));
        log.warn(str);
    }
}
