package pro.fessional.wings.tiny.mail.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.MailParseException;
import org.springframework.mail.MailSendException;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;
import pro.fessional.mirana.best.ArgsAssert;
import pro.fessional.mirana.cast.BoxedCastUtil;
import pro.fessional.mirana.data.Null;
import pro.fessional.mirana.pain.ThrowableUtil;
import pro.fessional.mirana.time.DateLocaling;
import pro.fessional.mirana.time.ThreadNow;
import pro.fessional.wings.faceless.convention.EmptyValue;
import pro.fessional.wings.faceless.service.journal.JournalService;
import pro.fessional.wings.faceless.service.lightid.LightIdService;
import pro.fessional.wings.silencer.modulate.RunMode;
import pro.fessional.wings.silencer.modulate.RuntimeMode;
import pro.fessional.wings.silencer.spring.help.CommonPropHelper;
import pro.fessional.wings.slardar.jackson.JacksonHelper;
import pro.fessional.wings.tiny.mail.database.autogen.tables.WinMailSenderTable;
import pro.fessional.wings.tiny.mail.database.autogen.tables.daos.WinMailSenderDao;
import pro.fessional.wings.tiny.mail.database.autogen.tables.pojos.WinMailSender;
import pro.fessional.wings.tiny.mail.sender.MailConfigProvider;
import pro.fessional.wings.tiny.mail.sender.MailSenderManager;
import pro.fessional.wings.tiny.mail.sender.MailSenderManager.BatchResult;
import pro.fessional.wings.tiny.mail.sender.MailWaitException;
import pro.fessional.wings.tiny.mail.sender.TinyMailConfig;
import pro.fessional.wings.tiny.mail.sender.TinyMailMessage;
import pro.fessional.wings.tiny.mail.service.TinyMail;
import pro.fessional.wings.tiny.mail.service.TinyMailService;
import pro.fessional.wings.tiny.mail.spring.prop.TinyMailServiceProp;

import javax.mail.MessagingException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor.DEFAULT_TASK_SCHEDULER_BEAN_NAME;
import static pro.fessional.wings.silencer.spring.help.CommonPropHelper.notValue;

/**
 * @author trydofor
 * @since 2023-01-06
 */
@Service
@Slf4j
public class TinyMailServiceImpl implements TinyMailService, InitializingBean {

    @Setter(onMethod_ = {@Value("${spring.application.name}")})
    protected String appName;
    @Setter(onMethod_ = {@Autowired})
    protected LightIdService lightIdService;
    @Setter(onMethod_ = {@Autowired})
    protected JournalService journalService;
    @Setter(onMethod_ = {@Autowired})
    protected WinMailSenderDao winMailSenderDao;
    @Setter(onMethod_ = {@Autowired})
    protected MailConfigProvider mailConfigProvider;
    @Setter(onMethod_ = {@Autowired})
    protected MailSenderManager mailSenderManager;
    @Setter(onMethod_ = {@Autowired})
    protected TinyMailServiceProp tinyMailServiceProp;
    @Setter(onMethod_ = {@Autowired})
    protected ResourceLoader resourceLoader;
    @Setter(onMethod_ = {@Autowired, @Qualifier(DEFAULT_TASK_SCHEDULER_BEAN_NAME)})
    private ThreadPoolTaskScheduler taskScheduler;

    @SuppressWarnings("all")
    private final PriorityBlockingQueue<AsyncMail> asyncMails = new PriorityBlockingQueue<>();

    @Override
    public boolean send(@NotNull TinyMail message, boolean retry) {
        final String conf = message.getConf();
        final TinyMailConfig config = mailConfigProvider.bynamedConfig(conf);
        ArgsAssert.notNull(config, "mail conf={} not found", conf);

        final WinMailSender po = saveMailSender(config, message);
        final TinyMailMessage mailMessage = makeMailMessage(config, po, message);
        return doSyncSend(po, mailMessage, retry);
    }

    @Override
    public boolean post(@NotNull TinyMail message, boolean retry) {
        try {
            return send(message, retry);
        }
        catch (Exception e) {
            log.error("fail to post mail, subject=" + message.getSubject(), e);
            return false;
        }
    }

    @Override
    public void emit(@NotNull TinyMail message, boolean retry) {
        final String conf = message.getConf();
        final TinyMailConfig config = mailConfigProvider.bynamedConfig(conf);
        ArgsAssert.notNull(config, "mail conf={} not found", conf);
        final WinMailSender po = saveMailSender(config, message);
        final TinyMailMessage mailMessage = makeMailMessage(config, po, message);
        doAsyncFreshSend(po, mailMessage, retry);
    }

    @Override
    public boolean send(long id, boolean retry) {
        final WinMailSender po = winMailSenderDao.fetchOneById(id);
        if (po == null) {
            log.warn("mail not found by id={}, skip send", id);
            return false;
        }
        final String conf = po.getMailConf();
        final TinyMailConfig config = mailConfigProvider.bynamedConfig(conf);
        if (config == null) {
            log.warn("mail conf={} not found", conf);
            return false;
        }

        final TinyMailMessage mailMessage = makeMailMessage(config, po, null);
        return doSyncSend(po, mailMessage, retry);
    }

    @Override
    public boolean post(long id, boolean retry) {
        try {
            return send(id, retry);
        }
        catch (Exception e) {
            log.error("fail to post mail, id=" + id, e);
            return false;
        }
    }

    @Override
    public void emit(long id, boolean retry) {
        final WinMailSender po = winMailSenderDao.fetchOneById(id);
        if (po == null) {
            log.warn("mail not found by id={}, skip emit", id);
            return;
        }
        doAsyncFreshSend(po, null, retry);
    }

    @Override
    public int scan() {
        log.info("scan misfire mail to queue");
        final long now = ThreadNow.millis();
        final long mis = now - tinyMailServiceProp.getMaxNext().toMillis();
        final LocalDateTime min = DateLocaling.utcLdt(mis);
        final LocalDateTime max = DateLocaling.utcLdt(now);

        final WinMailSenderTable t = winMailSenderDao.getTable();
        final List<AsyncMail> pos = winMailSenderDao
                .ctx()
                .selectFrom(t)
                .where(t.NextSend.gt(min).and(t.NextSend.lt(max)))
                .fetch()
                .into(WinMailSender.class)
                .stream()
                .filter(po -> !notMatchProp(po))
                .map(it -> new AsyncMail(it.getId(), DateLocaling.utcEpoch(it.getNextSend()), true, it, null))
                .collect(Collectors.toList());

        //
        final int size = pos.size();
        if (size > 0) {
            asyncMails.addAll(pos);
            taskScheduler.schedule(this::doAsyncBatchSend, Instant.ofEpochMilli(now));
            log.info("schedule init mail, size={}", size);
        }
        else {
            log.info("skip schedule init mail for empty");
        }
        return size;
    }

    @Override
    public void afterPropertiesSet() {
        final long bms = tinyMailServiceProp.getBootScan().toMillis();
        if (bms > 0) {
            taskScheduler.schedule(this::scan, Instant.ofEpochMilli(ThreadNow.millis() + bms));
        }
    }

    private TinyMailMessage makeMailMessage(@NotNull TinyMailConfig config, @NotNull WinMailSender po, @Nullable TinyMail msg) {
        final TinyMailMessage message = new TinyMailMessage();
        message.adopt(config);
        message.setBizId(po.getId());

        if (msg == null) {
            message.setFrom(po.getMailFrom());
            message.setTo(toArrOrNull(po.getMailTo()));
            message.setCc(toArrOrNull(po.getMailCc()));
            message.setBcc(toArrOrNull(po.getMailBcc()));
            message.setReply(toStrOrNull(po.getMailReply()));
            message.setHtml(po.getMailHtml());
            message.setSubject(po.getMailSubj());
            message.setContext(po.getMailText());
            final Map<String, Resource> files = toResource(po.getMailFile());
            if (!files.isEmpty()) {
                message.setAttachment(files);
            }
            message.setBizMark(toStrOrNull(po.getMarkWord()));
        }
        else {
            if (msg.getFrom() != null) message.setFrom(msg.getFrom());
            if (msg.getTo() != null) message.setTo(msg.getTo());
            if (msg.getCc() != null) message.setCc(msg.getCc());
            if (msg.getBcc() != null) message.setBcc(msg.getBcc());
            if (msg.getReply() != null) message.setReply(msg.getReply());
            if (msg.getHtml() != null) message.setHtml(msg.getHtml());
            message.setSubject(msg.getSubject());
            message.setContext(msg.getContext());
            message.setAttachment(msg.getAttachment());
            message.setBizMark(msg.getMark());
        }

        return message;
    }

    private WinMailSender saveMailSender(@NotNull TinyMailConfig config, @NotNull TinyMail msg) {
        final WinMailSender po = new WinMailSender();
        final long id = lightIdService.getId(winMailSenderDao.getTable());
        po.setId(id);
        po.setMailApps(appName);
        final RunMode rm = RuntimeMode.getRunMode();
        po.setMailRuns(rm == RunMode.Nothing ? "" : rm.name().toLowerCase());

        po.setMailConf(config.getName());
        po.setMailFrom(toString(msg.getFrom(), config.getFrom()));
        po.setMailTo(toString(msg.getTo(), config.getTo()));
        po.setMailCc(toString(msg.getCc(), config.getCc()));
        po.setMailBcc(toString(msg.getBcc(), config.getBcc()));
        po.setMailReply(toString(msg.getReply(), config.getReply()));
        po.setMailSubj(toString(msg.getSubject(), null));
        po.setMailText(msg.getContext());
        po.setMailHtml(BoxedCastUtil.orElse(msg.getHtml(), config.getHtml()));
        po.setMailFile(toString(msg.getAttachment()));
        po.setMarkWord(toString(msg.getMark(), null));

        // 乐观锁
        po.setNextLock(0);
        po.setNextSend(ThreadNow.localDateTime(ThreadNow.UtcZoneId));
        // 检查结束
        po.setSumsSend(0);
        po.setSumsFail(0);
        po.setSumsDone(0);

        journalService.commit(Jane.Insert, journal -> {
            journal.create(po);
            winMailSenderDao.insert(po);
        });
        return po;
    }

    private boolean notMatchProp(WinMailSender po) {
        if (tinyMailServiceProp.isOnlyApp()) {
            final String ma = po.getMailApps();
            if (StringUtils.isNotEmpty(ma) && !appName.equalsIgnoreCase(ma)) {
                log.info("skip only send app-mail app={}, id={}", appName, po.getId());
                return true;
            }
        }
        if (tinyMailServiceProp.isOnlyRun()) {
            final String mrs = po.getMailRuns();
            if (StringUtils.isNotEmpty(mrs)) {
                final RunMode rmd = RuntimeMode.getRunMode();
                if (rmd == RunMode.Nothing) {
                    log.info("skip only send run-mail, run={}, id={}", mrs, po.getId());
                    return true;
                }
                if (!RuntimeMode.hasRunMode(StringUtils.split(mrs, ','))) {
                    log.info("skip only send run-mail, run={}, cur={}, id={}", mrs, rmd, po.getId());
                    return true;
                }
            }
        }

        final int maxDone = tinyMailServiceProp.getMaxDone();
        final int sumDone = BoxedCastUtil.orElse(po.getSumsDone(), 0);
        if (sumDone >= maxDone) {
            log.info("skip max-send, max={}, sum={}, id={}", maxDone, sumDone, po.getId());
            return true;
        }

        final int maxFail = tinyMailServiceProp.getMaxFail();
        final int sumFail = BoxedCastUtil.orElse(po.getSumsFail(), 0);
        if (sumFail >= maxFail) {
            log.info("skip max-fail, max={}, sum={}, id={}", maxFail, sumFail, po.getId());
            return true;
        }

        return false;
    }

    private boolean notNextLock(WinMailSender po, long now) {
        final WinMailSenderTable t = winMailSenderDao.getTable();
        final int rc = winMailSenderDao
                .ctx()
                .update(t)
                .set(t.NextLock, t.NextLock.add(1))
                .set(t.LastSend, DateLocaling.utcLdt(now))
                .where(t.Id.eq(po.getId()).and(t.NextLock.eq(po.getNextLock())))
                .execute();

        if (rc <= 0) {
            log.info("skip not-next-lock mail, id={}", po.getId());
            return true;
        }

        return false;
    }

    private void saveStatusAndNext(@NotNull WinMailSender po, TinyMailMessage message, long cost, long now, Exception exception, boolean retry, boolean rethrow) {
        long nextSend = -1;
        try {
            final WinMailSenderTable t = winMailSenderDao.getTable();
            final Map<Object, Object> setter = new HashMap<>();
            if (exception == null) {
                setter.put(t.LastFail, null);
                setter.put(t.LastDone, DateLocaling.utcLdt(now));
                setter.put(t.LastCost, cost);

                if (po.getSumsDone() + 1 >= tinyMailServiceProp.getMaxDone()) {
                    setter.put(t.NextSend, EmptyValue.DATE_TIME);
                    log.info("done mail by max-send id={}, subject={}", po.getId(), po.getMailSubj());
                }
                else {
                    nextSend = now + tinyMailServiceProp.getTryNext().toMillis();
                    setter.put(t.NextSend, DateLocaling.utcLdt(nextSend));
                    log.info("next done-mail id={}, subject={}", po.getId(), po.getMailSubj());
                }

                setter.put(t.SumsSend, t.SumsSend.add(1));
                setter.put(t.SumsDone, t.SumsDone.add(1));
            }
            else {
                setter.put(t.LastFail, ThrowableUtil.toString(exception));
                setter.put(t.LastDone, EmptyValue.DATE_TIME);
                setter.put(t.LastCost, cost);

                if (po.getSumsFail() + 1 >= tinyMailServiceProp.getMaxFail()) {
                    setter.put(t.NextSend, EmptyValue.DATE_TIME);
                    log.info("done mail by max-fail id={}, subject={}", po.getId(), po.getMailSubj());
                }
                else if (retry) {
                    if (exception instanceof MailWaitException) {
                        MailWaitException mwe = ((MailWaitException) exception);
                        if (mwe.isStopRetry()) {
                            setter.put(t.NextSend, EmptyValue.DATE_TIME);
                            log.error("stop stop-retry mail, id=" + po.getId(), exception);
                        }
                        else {
                            nextSend = mwe.getWaitEpoch();
                        }
                    }
                    else if (exception instanceof MailParseException || exception instanceof MessagingException) {
                        setter.put(t.NextSend, EmptyValue.DATE_TIME);
                        log.error("failed to parse, stop mail, id=" + po.getId(), exception);
                    }
                    else {
                        nextSend = now + tinyMailServiceProp.getTryNext().toMillis();
                    }

                    if (nextSend > 0) {
                        setter.put(t.NextSend, DateLocaling.utcLdt(nextSend));
                        log.info("next fail-mail id={}, subject={}", po.getId(), po.getMailSubj());
                    }
                }
                else {
                    setter.put(t.NextSend, EmptyValue.DATE_TIME);
                    log.error("stop not-retry mail, id=" + po.getId(), exception);
                }
                setter.put(t.SumsSend, t.SumsSend.add(1));
                setter.put(t.SumsFail, t.SumsFail.add(1));
            }

            journalService.commit(Jane.Update, journal -> {
                setter.put(t.CommitId, journal.getCommitId());
                setter.put(t.ModifyDt, journal.getCommitDt());
                winMailSenderDao.ctx()
                                .update(t)
                                .set(setter)
                                .where(t.Id.eq(po.getId()))
                                .execute();
            });
        }
        catch (Exception e) {
            log.error("failed to save mail status, id=" + po.getId() + ", subject=" + po.getMailSubj(), e);
            nextSend = now + tinyMailServiceProp.getTryNext().toMillis();
        }

        if (exception == null) {
            if (nextSend > 0) {
                asyncMails.add(new AsyncMail(po.getId(), nextSend, retry, null, message));
                taskScheduler.schedule(this::doAsyncBatchSend, Instant.ofEpochMilli(nextSend));
                log.info("schedule done-mail send, id={}, subject={}", po.getId(), po.getMailSubj());
            }
        }
        else {
            if (retry && nextSend > 0 && nextSend - now < tinyMailServiceProp.getMaxNext().toMillis()) {
                asyncMails.add(new AsyncMail(po.getId(), nextSend, retry, null, message));
                taskScheduler.schedule(this::doAsyncBatchSend, Instant.ofEpochMilli(nextSend));
                log.warn("schedule fail-mail send, id=" + po.getId() + ", subject=" + po.getMailSubj(), exception);
            }
            else {
                if (rethrow) {
                    if (exception instanceof RuntimeException) {
                        throw (RuntimeException) exception;
                    }
                    else {
                        throw new MailSendException("failed mail, id=" + po.getId() + ", subject=" + po.getMailSubj(), exception);
                    }
                }
                else {
                    log.warn("no rethrow or retry mail, id=" + po.getId() + ", subject=" + po.getMailSubj(), exception);
                }
            }
        }
    }

    private boolean doSyncSend(@NotNull WinMailSender po, TinyMailMessage mailMessage, boolean retry) {
        if (notMatchProp(po)) {
            return false;
        }

        final long start = ThreadNow.millis();
        if (notNextLock(po, start)) {
            return false;
        }

        Exception exception = null;
        try {
            mailSenderManager.singleSend(mailMessage);
        }
        catch (Exception e) {
            exception = e;
        }
        finally {
            final long now = ThreadNow.millis();
            saveStatusAndNext(po, mailMessage, now - start, now, exception, retry, true);
        }

        return exception != null;
    }

    private void doAsyncFreshSend(@NotNull WinMailSender po, TinyMailMessage message, boolean retry) {
        if (notMatchProp(po)) return;

        final long now = ThreadNow.millis();
        asyncMails.add(new AsyncMail(po.getId(), now, retry, po, message));
        taskScheduler.schedule(this::doAsyncBatchSend, Instant.ofEpochMilli(now));
    }

    private void doAsyncBatchSend() {
        final long start = ThreadNow.millis();
        final int bz = tinyMailServiceProp.getBatchSize();

        try {
            final AtomicInteger count = new AtomicInteger(bz > 0 ? bz : 1);
            final HashMap<Long, AsyncMail> mails = new HashMap<>(count.get());
            asyncMails.removeIf(it -> {
                if (count.get() <= 0) return false;
                if (it.next > start) {
                    return false;
                }
                else {
                    mails.put(it.id, it);
                    count.decrementAndGet();
                    return true;
                }
            });

            if (mails.isEmpty()) return;

            final Map<Long, WinMailSender> freshPo = new HashMap<>();
            final List<Long> dirtyIds = new ArrayList<>();
            for (AsyncMail am : mails.values()) {
                if (am.fresher == null) {
                    dirtyIds.add(am.id);
                }
                else {
                    freshPo.put(am.id, am.fresher);
                }
            }

            final WinMailSenderTable t = winMailSenderDao.getTable();
            winMailSenderDao
                    .ctx()
                    .selectFrom(t)
                    .where(t.Id.in(dirtyIds))
                    .fetchInto(WinMailSender.class)
                    .forEach(po -> freshPo.put(po.getId(), po));

            final List<TinyMailMessage> messages = new ArrayList<>(freshPo.size());
            for (WinMailSender po : freshPo.values()) {
                if (notMatchProp(po) || notNextLock(po, start)) continue;

                final AsyncMail am = mails.get(po.getId());
                if (am != null && am.message != null) {
                    messages.add(am.message);
                }
                else {
                    final String conf = po.getMailConf();
                    final TinyMailConfig config = mailConfigProvider.bynamedConfig(conf);
                    if (config == null) {
                        log.warn("mail conf={} not found", conf);
                    }
                    else {
                        messages.add(makeMailMessage(config, po, null));
                    }
                }
            }

            final List<BatchResult> results = mailSenderManager.batchSend(messages);
            for (BatchResult result : results) {
                final TinyMailMessage msg = result.getTinyMessage();
                final WinMailSender po = freshPo.get(msg.getBizId()); // must not null
                saveStatusAndNext(po, msg, result.getCostMillis(), result.getDoneMillis(), result.getException(), true, false);
            }
        }
        finally {
            final int size = asyncMails.size();
            if (size > 0) {
                final long next = start + tinyMailServiceProp.getTryNext().toMillis();
                taskScheduler.schedule(this::doAsyncBatchSend, Instant.ofEpochMilli(next));
                if (size > tinyMailServiceProp.getWarnSize()) {
                    log.warn("schedule next war-size={}, idle={}", size, tinyMailServiceProp.getTryNext());
                }
                else {
                    log.info("schedule next size={}, idle={}", size, tinyMailServiceProp.getTryNext());
                }
            }
        }
    }

    @Nullable
    private String toString(String[] arr, String[] elz) {
        if (arr == null) arr = elz;
        return arr == null ? null : String.join(",", arr);
    }

    @Nullable
    private String toString(String str, String elz) {
        return notValue(str) ? elz : str;
    }

    @SneakyThrows
    @NotNull
    private String toString(Map<String, Resource> file) {
        if (file == null || file.isEmpty()) return Null.Str;
        Map<String, String> nameUrl = new LinkedHashMap<>(file.size());
        for (Map.Entry<String, Resource> en : file.entrySet()) {
            nameUrl.put(en.getKey(), CommonPropHelper.toString(en.getValue()));
        }
        return JacksonHelper.string(nameUrl, true);
    }

    @Nullable
    private String[] toArrOrNull(String str) {
        return (str == null || str.isEmpty()) ? Null.StrArr : StringUtils.split(str, ',');
    }

    @Nullable
    private String toStrOrNull(String str) {
        return (str == null || str.isEmpty()) ? null : str;
    }

    @NotNull
    private Map<String, Resource> toResource(String map) {
        if (map == null || map.isEmpty()) return Collections.emptyMap();
        final Map<String, Resource> rst = new LinkedHashMap<>();
        final Iterator<Map.Entry<String, JsonNode>> node = JacksonHelper.object(map).fields();
        while (node.hasNext()) {
            final Map.Entry<String, JsonNode> en = node.next();
            rst.put(en.getKey(), resourceLoader.getResource(en.getValue().asText()));
        }
        return rst;
    }

    @Data
    private static class AsyncMail implements Comparable<AsyncMail> {
        private final long id;
        private final long next;
        private final boolean retry;
        @Nullable
        private final WinMailSender fresher;
        @Nullable
        private final TinyMailMessage message;

        @Override
        public int compareTo(@NotNull TinyMailServiceImpl.AsyncMail o) {
            return Long.compare(next, o.next);
        }
    }

    public enum Jane {
        Insert,
        Update
    }
}
