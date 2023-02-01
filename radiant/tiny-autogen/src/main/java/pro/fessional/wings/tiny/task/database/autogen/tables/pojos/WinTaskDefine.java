/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.tiny.task.database.autogen.tables.pojos;


import pro.fessional.wings.tiny.task.database.autogen.tables.interfaces.IWinTaskDefine;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;


/**
 * The table <code>wings.win_task_define</code>.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.17.7",
        "schema version:2020102701"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class WinTaskDefine implements IWinTaskDefine {

    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDateTime createDt;
    private LocalDateTime modifyDt;
    private LocalDateTime deleteDt;
    private Long commitId;
    private String propkey;
    private Boolean enabled;
    private Boolean autorun;
    private Integer version;
    private String taskerBean;
    private String taskerPara;
    private String taskerName;
    private Boolean taskerFast;
    private String taskerApps;
    private String taskerRuns;
    private String noticeBean;
    private String noticeWhen;
    private String noticeConf;
    private String timingZone;
    private String timingType;
    private String timingCron;
    private Integer timingIdle;
    private Integer timingRate;
    private Integer timingMiss;
    private Integer timingBeat;
    private String duringFrom;
    private String duringStop;
    private Integer duringExec;
    private Integer duringFail;
    private Integer duringDone;
    private Integer duringBoot;
    private Integer resultKeep;
    private LocalDateTime lastExec;
    private LocalDateTime lastFail;
    private LocalDateTime lastDone;
    private LocalDateTime nextExec;
    private Integer nextLock;
    private Integer durFail;
    private Integer sumExec;
    private Integer sumFail;
    private Integer sumDone;

    public WinTaskDefine() {}

    public WinTaskDefine(IWinTaskDefine value) {
        this.id = value.getId();
        this.createDt = value.getCreateDt();
        this.modifyDt = value.getModifyDt();
        this.deleteDt = value.getDeleteDt();
        this.commitId = value.getCommitId();
        this.propkey = value.getPropkey();
        this.enabled = value.getEnabled();
        this.autorun = value.getAutorun();
        this.version = value.getVersion();
        this.taskerBean = value.getTaskerBean();
        this.taskerPara = value.getTaskerPara();
        this.taskerName = value.getTaskerName();
        this.taskerFast = value.getTaskerFast();
        this.taskerApps = value.getTaskerApps();
        this.taskerRuns = value.getTaskerRuns();
        this.noticeBean = value.getNoticeBean();
        this.noticeWhen = value.getNoticeWhen();
        this.noticeConf = value.getNoticeConf();
        this.timingZone = value.getTimingZone();
        this.timingType = value.getTimingType();
        this.timingCron = value.getTimingCron();
        this.timingIdle = value.getTimingIdle();
        this.timingRate = value.getTimingRate();
        this.timingMiss = value.getTimingMiss();
        this.timingBeat = value.getTimingBeat();
        this.duringFrom = value.getDuringFrom();
        this.duringStop = value.getDuringStop();
        this.duringExec = value.getDuringExec();
        this.duringFail = value.getDuringFail();
        this.duringDone = value.getDuringDone();
        this.duringBoot = value.getDuringBoot();
        this.resultKeep = value.getResultKeep();
        this.lastExec = value.getLastExec();
        this.lastFail = value.getLastFail();
        this.lastDone = value.getLastDone();
        this.nextExec = value.getNextExec();
        this.nextLock = value.getNextLock();
        this.durFail = value.getDurFail();
        this.sumExec = value.getSumExec();
        this.sumFail = value.getSumFail();
        this.sumDone = value.getSumDone();
    }

    public WinTaskDefine(
        Long id,
        LocalDateTime createDt,
        LocalDateTime modifyDt,
        LocalDateTime deleteDt,
        Long commitId,
        String propkey,
        Boolean enabled,
        Boolean autorun,
        Integer version,
        String taskerBean,
        String taskerPara,
        String taskerName,
        Boolean taskerFast,
        String taskerApps,
        String taskerRuns,
        String noticeBean,
        String noticeWhen,
        String noticeConf,
        String timingZone,
        String timingType,
        String timingCron,
        Integer timingIdle,
        Integer timingRate,
        Integer timingMiss,
        Integer timingBeat,
        String duringFrom,
        String duringStop,
        Integer duringExec,
        Integer duringFail,
        Integer duringDone,
        Integer duringBoot,
        Integer resultKeep,
        LocalDateTime lastExec,
        LocalDateTime lastFail,
        LocalDateTime lastDone,
        LocalDateTime nextExec,
        Integer nextLock,
        Integer durFail,
        Integer sumExec,
        Integer sumFail,
        Integer sumDone
    ) {
        this.id = id;
        this.createDt = createDt;
        this.modifyDt = modifyDt;
        this.deleteDt = deleteDt;
        this.commitId = commitId;
        this.propkey = propkey;
        this.enabled = enabled;
        this.autorun = autorun;
        this.version = version;
        this.taskerBean = taskerBean;
        this.taskerPara = taskerPara;
        this.taskerName = taskerName;
        this.taskerFast = taskerFast;
        this.taskerApps = taskerApps;
        this.taskerRuns = taskerRuns;
        this.noticeBean = noticeBean;
        this.noticeWhen = noticeWhen;
        this.noticeConf = noticeConf;
        this.timingZone = timingZone;
        this.timingType = timingType;
        this.timingCron = timingCron;
        this.timingIdle = timingIdle;
        this.timingRate = timingRate;
        this.timingMiss = timingMiss;
        this.timingBeat = timingBeat;
        this.duringFrom = duringFrom;
        this.duringStop = duringStop;
        this.duringExec = duringExec;
        this.duringFail = duringFail;
        this.duringDone = duringDone;
        this.duringBoot = duringBoot;
        this.resultKeep = resultKeep;
        this.lastExec = lastExec;
        this.lastFail = lastFail;
        this.lastDone = lastDone;
        this.nextExec = nextExec;
        this.nextLock = nextLock;
        this.durFail = durFail;
        this.sumExec = sumExec;
        this.sumFail = sumFail;
        this.sumDone = sumDone;
    }

    /**
     * Getter for <code>win_task_define.id</code>.
     */
    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>win_task_define.id</code>.
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for <code>win_task_define.create_dt</code>.
     */
    @Override
    public LocalDateTime getCreateDt() {
        return this.createDt;
    }

    /**
     * Setter for <code>win_task_define.create_dt</code>.
     */
    @Override
    public void setCreateDt(LocalDateTime createDt) {
        this.createDt = createDt;
    }

    /**
     * Getter for <code>win_task_define.modify_dt</code>.
     */
    @Override
    public LocalDateTime getModifyDt() {
        return this.modifyDt;
    }

    /**
     * Setter for <code>win_task_define.modify_dt</code>.
     */
    @Override
    public void setModifyDt(LocalDateTime modifyDt) {
        this.modifyDt = modifyDt;
    }

    /**
     * Getter for <code>win_task_define.delete_dt</code>.
     */
    @Override
    public LocalDateTime getDeleteDt() {
        return this.deleteDt;
    }

    /**
     * Setter for <code>win_task_define.delete_dt</code>.
     */
    @Override
    public void setDeleteDt(LocalDateTime deleteDt) {
        this.deleteDt = deleteDt;
    }

    /**
     * Getter for <code>win_task_define.commit_id</code>.
     */
    @Override
    public Long getCommitId() {
        return this.commitId;
    }

    /**
     * Setter for <code>win_task_define.commit_id</code>.
     */
    @Override
    public void setCommitId(Long commitId) {
        this.commitId = commitId;
    }

    /**
     * Getter for <code>win_task_define.propkey</code>.
     */
    @Override
    public String getPropkey() {
        return this.propkey;
    }

    /**
     * Setter for <code>win_task_define.propkey</code>.
     */
    @Override
    public void setPropkey(String propkey) {
        this.propkey = propkey;
    }

    /**
     * Getter for <code>win_task_define.enabled</code>.
     */
    @Override
    public Boolean getEnabled() {
        return this.enabled;
    }

    /**
     * Setter for <code>win_task_define.enabled</code>.
     */
    @Override
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Getter for <code>win_task_define.autorun</code>.
     */
    @Override
    public Boolean getAutorun() {
        return this.autorun;
    }

    /**
     * Setter for <code>win_task_define.autorun</code>.
     */
    @Override
    public void setAutorun(Boolean autorun) {
        this.autorun = autorun;
    }

    /**
     * Getter for <code>win_task_define.version</code>.
     */
    @Override
    public Integer getVersion() {
        return this.version;
    }

    /**
     * Setter for <code>win_task_define.version</code>.
     */
    @Override
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * Getter for <code>win_task_define.tasker_bean</code>.
     */
    @Override
    public String getTaskerBean() {
        return this.taskerBean;
    }

    /**
     * Setter for <code>win_task_define.tasker_bean</code>.
     */
    @Override
    public void setTaskerBean(String taskerBean) {
        this.taskerBean = taskerBean;
    }

    /**
     * Getter for <code>win_task_define.tasker_para</code>.
     */
    @Override
    public String getTaskerPara() {
        return this.taskerPara;
    }

    /**
     * Setter for <code>win_task_define.tasker_para</code>.
     */
    @Override
    public void setTaskerPara(String taskerPara) {
        this.taskerPara = taskerPara;
    }

    /**
     * Getter for <code>win_task_define.tasker_name</code>.
     */
    @Override
    public String getTaskerName() {
        return this.taskerName;
    }

    /**
     * Setter for <code>win_task_define.tasker_name</code>.
     */
    @Override
    public void setTaskerName(String taskerName) {
        this.taskerName = taskerName;
    }

    /**
     * Getter for <code>win_task_define.tasker_fast</code>.
     */
    @Override
    public Boolean getTaskerFast() {
        return this.taskerFast;
    }

    /**
     * Setter for <code>win_task_define.tasker_fast</code>.
     */
    @Override
    public void setTaskerFast(Boolean taskerFast) {
        this.taskerFast = taskerFast;
    }

    /**
     * Getter for <code>win_task_define.tasker_apps</code>.
     */
    @Override
    public String getTaskerApps() {
        return this.taskerApps;
    }

    /**
     * Setter for <code>win_task_define.tasker_apps</code>.
     */
    @Override
    public void setTaskerApps(String taskerApps) {
        this.taskerApps = taskerApps;
    }

    /**
     * Getter for <code>win_task_define.tasker_runs</code>.
     */
    @Override
    public String getTaskerRuns() {
        return this.taskerRuns;
    }

    /**
     * Setter for <code>win_task_define.tasker_runs</code>.
     */
    @Override
    public void setTaskerRuns(String taskerRuns) {
        this.taskerRuns = taskerRuns;
    }

    /**
     * Getter for <code>win_task_define.notice_bean</code>.
     */
    @Override
    public String getNoticeBean() {
        return this.noticeBean;
    }

    /**
     * Setter for <code>win_task_define.notice_bean</code>.
     */
    @Override
    public void setNoticeBean(String noticeBean) {
        this.noticeBean = noticeBean;
    }

    /**
     * Getter for <code>win_task_define.notice_when</code>.
     */
    @Override
    public String getNoticeWhen() {
        return this.noticeWhen;
    }

    /**
     * Setter for <code>win_task_define.notice_when</code>.
     */
    @Override
    public void setNoticeWhen(String noticeWhen) {
        this.noticeWhen = noticeWhen;
    }

    /**
     * Getter for <code>win_task_define.notice_conf</code>.
     */
    @Override
    public String getNoticeConf() {
        return this.noticeConf;
    }

    /**
     * Setter for <code>win_task_define.notice_conf</code>.
     */
    @Override
    public void setNoticeConf(String noticeConf) {
        this.noticeConf = noticeConf;
    }

    /**
     * Getter for <code>win_task_define.timing_zone</code>.
     */
    @Override
    public String getTimingZone() {
        return this.timingZone;
    }

    /**
     * Setter for <code>win_task_define.timing_zone</code>.
     */
    @Override
    public void setTimingZone(String timingZone) {
        this.timingZone = timingZone;
    }

    /**
     * Getter for <code>win_task_define.timing_type</code>.
     */
    @Override
    public String getTimingType() {
        return this.timingType;
    }

    /**
     * Setter for <code>win_task_define.timing_type</code>.
     */
    @Override
    public void setTimingType(String timingType) {
        this.timingType = timingType;
    }

    /**
     * Getter for <code>win_task_define.timing_cron</code>.
     */
    @Override
    public String getTimingCron() {
        return this.timingCron;
    }

    /**
     * Setter for <code>win_task_define.timing_cron</code>.
     */
    @Override
    public void setTimingCron(String timingCron) {
        this.timingCron = timingCron;
    }

    /**
     * Getter for <code>win_task_define.timing_idle</code>.
     */
    @Override
    public Integer getTimingIdle() {
        return this.timingIdle;
    }

    /**
     * Setter for <code>win_task_define.timing_idle</code>.
     */
    @Override
    public void setTimingIdle(Integer timingIdle) {
        this.timingIdle = timingIdle;
    }

    /**
     * Getter for <code>win_task_define.timing_rate</code>.
     */
    @Override
    public Integer getTimingRate() {
        return this.timingRate;
    }

    /**
     * Setter for <code>win_task_define.timing_rate</code>.
     */
    @Override
    public void setTimingRate(Integer timingRate) {
        this.timingRate = timingRate;
    }

    /**
     * Getter for <code>win_task_define.timing_miss</code>.
     */
    @Override
    public Integer getTimingMiss() {
        return this.timingMiss;
    }

    /**
     * Setter for <code>win_task_define.timing_miss</code>.
     */
    @Override
    public void setTimingMiss(Integer timingMiss) {
        this.timingMiss = timingMiss;
    }

    /**
     * Getter for <code>win_task_define.timing_beat</code>.
     */
    @Override
    public Integer getTimingBeat() {
        return this.timingBeat;
    }

    /**
     * Setter for <code>win_task_define.timing_beat</code>.
     */
    @Override
    public void setTimingBeat(Integer timingBeat) {
        this.timingBeat = timingBeat;
    }

    /**
     * Getter for <code>win_task_define.during_from</code>.
     */
    @Override
    public String getDuringFrom() {
        return this.duringFrom;
    }

    /**
     * Setter for <code>win_task_define.during_from</code>.
     */
    @Override
    public void setDuringFrom(String duringFrom) {
        this.duringFrom = duringFrom;
    }

    /**
     * Getter for <code>win_task_define.during_stop</code>.
     */
    @Override
    public String getDuringStop() {
        return this.duringStop;
    }

    /**
     * Setter for <code>win_task_define.during_stop</code>.
     */
    @Override
    public void setDuringStop(String duringStop) {
        this.duringStop = duringStop;
    }

    /**
     * Getter for <code>win_task_define.during_exec</code>.
     */
    @Override
    public Integer getDuringExec() {
        return this.duringExec;
    }

    /**
     * Setter for <code>win_task_define.during_exec</code>.
     */
    @Override
    public void setDuringExec(Integer duringExec) {
        this.duringExec = duringExec;
    }

    /**
     * Getter for <code>win_task_define.during_fail</code>.
     */
    @Override
    public Integer getDuringFail() {
        return this.duringFail;
    }

    /**
     * Setter for <code>win_task_define.during_fail</code>.
     */
    @Override
    public void setDuringFail(Integer duringFail) {
        this.duringFail = duringFail;
    }

    /**
     * Getter for <code>win_task_define.during_done</code>.
     */
    @Override
    public Integer getDuringDone() {
        return this.duringDone;
    }

    /**
     * Setter for <code>win_task_define.during_done</code>.
     */
    @Override
    public void setDuringDone(Integer duringDone) {
        this.duringDone = duringDone;
    }

    /**
     * Getter for <code>win_task_define.during_boot</code>.
     */
    @Override
    public Integer getDuringBoot() {
        return this.duringBoot;
    }

    /**
     * Setter for <code>win_task_define.during_boot</code>.
     */
    @Override
    public void setDuringBoot(Integer duringBoot) {
        this.duringBoot = duringBoot;
    }

    /**
     * Getter for <code>win_task_define.result_keep</code>.
     */
    @Override
    public Integer getResultKeep() {
        return this.resultKeep;
    }

    /**
     * Setter for <code>win_task_define.result_keep</code>.
     */
    @Override
    public void setResultKeep(Integer resultKeep) {
        this.resultKeep = resultKeep;
    }

    /**
     * Getter for <code>win_task_define.last_exec</code>.
     */
    @Override
    public LocalDateTime getLastExec() {
        return this.lastExec;
    }

    /**
     * Setter for <code>win_task_define.last_exec</code>.
     */
    @Override
    public void setLastExec(LocalDateTime lastExec) {
        this.lastExec = lastExec;
    }

    /**
     * Getter for <code>win_task_define.last_fail</code>.
     */
    @Override
    public LocalDateTime getLastFail() {
        return this.lastFail;
    }

    /**
     * Setter for <code>win_task_define.last_fail</code>.
     */
    @Override
    public void setLastFail(LocalDateTime lastFail) {
        this.lastFail = lastFail;
    }

    /**
     * Getter for <code>win_task_define.last_done</code>.
     */
    @Override
    public LocalDateTime getLastDone() {
        return this.lastDone;
    }

    /**
     * Setter for <code>win_task_define.last_done</code>.
     */
    @Override
    public void setLastDone(LocalDateTime lastDone) {
        this.lastDone = lastDone;
    }

    /**
     * Getter for <code>win_task_define.next_exec</code>.
     */
    @Override
    public LocalDateTime getNextExec() {
        return this.nextExec;
    }

    /**
     * Setter for <code>win_task_define.next_exec</code>.
     */
    @Override
    public void setNextExec(LocalDateTime nextExec) {
        this.nextExec = nextExec;
    }

    /**
     * Getter for <code>win_task_define.next_lock</code>.
     */
    @Override
    public Integer getNextLock() {
        return this.nextLock;
    }

    /**
     * Setter for <code>win_task_define.next_lock</code>.
     */
    @Override
    public void setNextLock(Integer nextLock) {
        this.nextLock = nextLock;
    }

    /**
     * Getter for <code>win_task_define.dur_fail</code>.
     */
    @Override
    public Integer getDurFail() {
        return this.durFail;
    }

    /**
     * Setter for <code>win_task_define.dur_fail</code>.
     */
    @Override
    public void setDurFail(Integer durFail) {
        this.durFail = durFail;
    }

    /**
     * Getter for <code>win_task_define.sum_exec</code>.
     */
    @Override
    public Integer getSumExec() {
        return this.sumExec;
    }

    /**
     * Setter for <code>win_task_define.sum_exec</code>.
     */
    @Override
    public void setSumExec(Integer sumExec) {
        this.sumExec = sumExec;
    }

    /**
     * Getter for <code>win_task_define.sum_fail</code>.
     */
    @Override
    public Integer getSumFail() {
        return this.sumFail;
    }

    /**
     * Setter for <code>win_task_define.sum_fail</code>.
     */
    @Override
    public void setSumFail(Integer sumFail) {
        this.sumFail = sumFail;
    }

    /**
     * Getter for <code>win_task_define.sum_done</code>.
     */
    @Override
    public Integer getSumDone() {
        return this.sumDone;
    }

    /**
     * Setter for <code>win_task_define.sum_done</code>.
     */
    @Override
    public void setSumDone(Integer sumDone) {
        this.sumDone = sumDone;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final WinTaskDefine other = (WinTaskDefine) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.createDt == null) {
            if (other.createDt != null)
                return false;
        }
        else if (!this.createDt.equals(other.createDt))
            return false;
        if (this.modifyDt == null) {
            if (other.modifyDt != null)
                return false;
        }
        else if (!this.modifyDt.equals(other.modifyDt))
            return false;
        if (this.deleteDt == null) {
            if (other.deleteDt != null)
                return false;
        }
        else if (!this.deleteDt.equals(other.deleteDt))
            return false;
        if (this.commitId == null) {
            if (other.commitId != null)
                return false;
        }
        else if (!this.commitId.equals(other.commitId))
            return false;
        if (this.propkey == null) {
            if (other.propkey != null)
                return false;
        }
        else if (!this.propkey.equals(other.propkey))
            return false;
        if (this.enabled == null) {
            if (other.enabled != null)
                return false;
        }
        else if (!this.enabled.equals(other.enabled))
            return false;
        if (this.autorun == null) {
            if (other.autorun != null)
                return false;
        }
        else if (!this.autorun.equals(other.autorun))
            return false;
        if (this.version == null) {
            if (other.version != null)
                return false;
        }
        else if (!this.version.equals(other.version))
            return false;
        if (this.taskerBean == null) {
            if (other.taskerBean != null)
                return false;
        }
        else if (!this.taskerBean.equals(other.taskerBean))
            return false;
        if (this.taskerPara == null) {
            if (other.taskerPara != null)
                return false;
        }
        else if (!this.taskerPara.equals(other.taskerPara))
            return false;
        if (this.taskerName == null) {
            if (other.taskerName != null)
                return false;
        }
        else if (!this.taskerName.equals(other.taskerName))
            return false;
        if (this.taskerFast == null) {
            if (other.taskerFast != null)
                return false;
        }
        else if (!this.taskerFast.equals(other.taskerFast))
            return false;
        if (this.taskerApps == null) {
            if (other.taskerApps != null)
                return false;
        }
        else if (!this.taskerApps.equals(other.taskerApps))
            return false;
        if (this.taskerRuns == null) {
            if (other.taskerRuns != null)
                return false;
        }
        else if (!this.taskerRuns.equals(other.taskerRuns))
            return false;
        if (this.noticeBean == null) {
            if (other.noticeBean != null)
                return false;
        }
        else if (!this.noticeBean.equals(other.noticeBean))
            return false;
        if (this.noticeWhen == null) {
            if (other.noticeWhen != null)
                return false;
        }
        else if (!this.noticeWhen.equals(other.noticeWhen))
            return false;
        if (this.noticeConf == null) {
            if (other.noticeConf != null)
                return false;
        }
        else if (!this.noticeConf.equals(other.noticeConf))
            return false;
        if (this.timingZone == null) {
            if (other.timingZone != null)
                return false;
        }
        else if (!this.timingZone.equals(other.timingZone))
            return false;
        if (this.timingType == null) {
            if (other.timingType != null)
                return false;
        }
        else if (!this.timingType.equals(other.timingType))
            return false;
        if (this.timingCron == null) {
            if (other.timingCron != null)
                return false;
        }
        else if (!this.timingCron.equals(other.timingCron))
            return false;
        if (this.timingIdle == null) {
            if (other.timingIdle != null)
                return false;
        }
        else if (!this.timingIdle.equals(other.timingIdle))
            return false;
        if (this.timingRate == null) {
            if (other.timingRate != null)
                return false;
        }
        else if (!this.timingRate.equals(other.timingRate))
            return false;
        if (this.timingMiss == null) {
            if (other.timingMiss != null)
                return false;
        }
        else if (!this.timingMiss.equals(other.timingMiss))
            return false;
        if (this.timingBeat == null) {
            if (other.timingBeat != null)
                return false;
        }
        else if (!this.timingBeat.equals(other.timingBeat))
            return false;
        if (this.duringFrom == null) {
            if (other.duringFrom != null)
                return false;
        }
        else if (!this.duringFrom.equals(other.duringFrom))
            return false;
        if (this.duringStop == null) {
            if (other.duringStop != null)
                return false;
        }
        else if (!this.duringStop.equals(other.duringStop))
            return false;
        if (this.duringExec == null) {
            if (other.duringExec != null)
                return false;
        }
        else if (!this.duringExec.equals(other.duringExec))
            return false;
        if (this.duringFail == null) {
            if (other.duringFail != null)
                return false;
        }
        else if (!this.duringFail.equals(other.duringFail))
            return false;
        if (this.duringDone == null) {
            if (other.duringDone != null)
                return false;
        }
        else if (!this.duringDone.equals(other.duringDone))
            return false;
        if (this.duringBoot == null) {
            if (other.duringBoot != null)
                return false;
        }
        else if (!this.duringBoot.equals(other.duringBoot))
            return false;
        if (this.resultKeep == null) {
            if (other.resultKeep != null)
                return false;
        }
        else if (!this.resultKeep.equals(other.resultKeep))
            return false;
        if (this.lastExec == null) {
            if (other.lastExec != null)
                return false;
        }
        else if (!this.lastExec.equals(other.lastExec))
            return false;
        if (this.lastFail == null) {
            if (other.lastFail != null)
                return false;
        }
        else if (!this.lastFail.equals(other.lastFail))
            return false;
        if (this.lastDone == null) {
            if (other.lastDone != null)
                return false;
        }
        else if (!this.lastDone.equals(other.lastDone))
            return false;
        if (this.nextExec == null) {
            if (other.nextExec != null)
                return false;
        }
        else if (!this.nextExec.equals(other.nextExec))
            return false;
        if (this.nextLock == null) {
            if (other.nextLock != null)
                return false;
        }
        else if (!this.nextLock.equals(other.nextLock))
            return false;
        if (this.durFail == null) {
            if (other.durFail != null)
                return false;
        }
        else if (!this.durFail.equals(other.durFail))
            return false;
        if (this.sumExec == null) {
            if (other.sumExec != null)
                return false;
        }
        else if (!this.sumExec.equals(other.sumExec))
            return false;
        if (this.sumFail == null) {
            if (other.sumFail != null)
                return false;
        }
        else if (!this.sumFail.equals(other.sumFail))
            return false;
        if (this.sumDone == null) {
            if (other.sumDone != null)
                return false;
        }
        else if (!this.sumDone.equals(other.sumDone))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.createDt == null) ? 0 : this.createDt.hashCode());
        result = prime * result + ((this.modifyDt == null) ? 0 : this.modifyDt.hashCode());
        result = prime * result + ((this.deleteDt == null) ? 0 : this.deleteDt.hashCode());
        result = prime * result + ((this.commitId == null) ? 0 : this.commitId.hashCode());
        result = prime * result + ((this.propkey == null) ? 0 : this.propkey.hashCode());
        result = prime * result + ((this.enabled == null) ? 0 : this.enabled.hashCode());
        result = prime * result + ((this.autorun == null) ? 0 : this.autorun.hashCode());
        result = prime * result + ((this.version == null) ? 0 : this.version.hashCode());
        result = prime * result + ((this.taskerBean == null) ? 0 : this.taskerBean.hashCode());
        result = prime * result + ((this.taskerPara == null) ? 0 : this.taskerPara.hashCode());
        result = prime * result + ((this.taskerName == null) ? 0 : this.taskerName.hashCode());
        result = prime * result + ((this.taskerFast == null) ? 0 : this.taskerFast.hashCode());
        result = prime * result + ((this.taskerApps == null) ? 0 : this.taskerApps.hashCode());
        result = prime * result + ((this.taskerRuns == null) ? 0 : this.taskerRuns.hashCode());
        result = prime * result + ((this.noticeBean == null) ? 0 : this.noticeBean.hashCode());
        result = prime * result + ((this.noticeWhen == null) ? 0 : this.noticeWhen.hashCode());
        result = prime * result + ((this.noticeConf == null) ? 0 : this.noticeConf.hashCode());
        result = prime * result + ((this.timingZone == null) ? 0 : this.timingZone.hashCode());
        result = prime * result + ((this.timingType == null) ? 0 : this.timingType.hashCode());
        result = prime * result + ((this.timingCron == null) ? 0 : this.timingCron.hashCode());
        result = prime * result + ((this.timingIdle == null) ? 0 : this.timingIdle.hashCode());
        result = prime * result + ((this.timingRate == null) ? 0 : this.timingRate.hashCode());
        result = prime * result + ((this.timingMiss == null) ? 0 : this.timingMiss.hashCode());
        result = prime * result + ((this.timingBeat == null) ? 0 : this.timingBeat.hashCode());
        result = prime * result + ((this.duringFrom == null) ? 0 : this.duringFrom.hashCode());
        result = prime * result + ((this.duringStop == null) ? 0 : this.duringStop.hashCode());
        result = prime * result + ((this.duringExec == null) ? 0 : this.duringExec.hashCode());
        result = prime * result + ((this.duringFail == null) ? 0 : this.duringFail.hashCode());
        result = prime * result + ((this.duringDone == null) ? 0 : this.duringDone.hashCode());
        result = prime * result + ((this.duringBoot == null) ? 0 : this.duringBoot.hashCode());
        result = prime * result + ((this.resultKeep == null) ? 0 : this.resultKeep.hashCode());
        result = prime * result + ((this.lastExec == null) ? 0 : this.lastExec.hashCode());
        result = prime * result + ((this.lastFail == null) ? 0 : this.lastFail.hashCode());
        result = prime * result + ((this.lastDone == null) ? 0 : this.lastDone.hashCode());
        result = prime * result + ((this.nextExec == null) ? 0 : this.nextExec.hashCode());
        result = prime * result + ((this.nextLock == null) ? 0 : this.nextLock.hashCode());
        result = prime * result + ((this.durFail == null) ? 0 : this.durFail.hashCode());
        result = prime * result + ((this.sumExec == null) ? 0 : this.sumExec.hashCode());
        result = prime * result + ((this.sumFail == null) ? 0 : this.sumFail.hashCode());
        result = prime * result + ((this.sumDone == null) ? 0 : this.sumDone.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("WinTaskDefine (");

        sb.append(id);
        sb.append(", ").append(createDt);
        sb.append(", ").append(modifyDt);
        sb.append(", ").append(deleteDt);
        sb.append(", ").append(commitId);
        sb.append(", ").append(propkey);
        sb.append(", ").append(enabled);
        sb.append(", ").append(autorun);
        sb.append(", ").append(version);
        sb.append(", ").append(taskerBean);
        sb.append(", ").append(taskerPara);
        sb.append(", ").append(taskerName);
        sb.append(", ").append(taskerFast);
        sb.append(", ").append(taskerApps);
        sb.append(", ").append(taskerRuns);
        sb.append(", ").append(noticeBean);
        sb.append(", ").append(noticeWhen);
        sb.append(", ").append(noticeConf);
        sb.append(", ").append(timingZone);
        sb.append(", ").append(timingType);
        sb.append(", ").append(timingCron);
        sb.append(", ").append(timingIdle);
        sb.append(", ").append(timingRate);
        sb.append(", ").append(timingMiss);
        sb.append(", ").append(timingBeat);
        sb.append(", ").append(duringFrom);
        sb.append(", ").append(duringStop);
        sb.append(", ").append(duringExec);
        sb.append(", ").append(duringFail);
        sb.append(", ").append(duringDone);
        sb.append(", ").append(duringBoot);
        sb.append(", ").append(resultKeep);
        sb.append(", ").append(lastExec);
        sb.append(", ").append(lastFail);
        sb.append(", ").append(lastDone);
        sb.append(", ").append(nextExec);
        sb.append(", ").append(nextLock);
        sb.append(", ").append(durFail);
        sb.append(", ").append(sumExec);
        sb.append(", ").append(sumFail);
        sb.append(", ").append(sumDone);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IWinTaskDefine from) {
        setId(from.getId());
        setCreateDt(from.getCreateDt());
        setModifyDt(from.getModifyDt());
        setDeleteDt(from.getDeleteDt());
        setCommitId(from.getCommitId());
        setPropkey(from.getPropkey());
        setEnabled(from.getEnabled());
        setAutorun(from.getAutorun());
        setVersion(from.getVersion());
        setTaskerBean(from.getTaskerBean());
        setTaskerPara(from.getTaskerPara());
        setTaskerName(from.getTaskerName());
        setTaskerFast(from.getTaskerFast());
        setTaskerApps(from.getTaskerApps());
        setTaskerRuns(from.getTaskerRuns());
        setNoticeBean(from.getNoticeBean());
        setNoticeWhen(from.getNoticeWhen());
        setNoticeConf(from.getNoticeConf());
        setTimingZone(from.getTimingZone());
        setTimingType(from.getTimingType());
        setTimingCron(from.getTimingCron());
        setTimingIdle(from.getTimingIdle());
        setTimingRate(from.getTimingRate());
        setTimingMiss(from.getTimingMiss());
        setTimingBeat(from.getTimingBeat());
        setDuringFrom(from.getDuringFrom());
        setDuringStop(from.getDuringStop());
        setDuringExec(from.getDuringExec());
        setDuringFail(from.getDuringFail());
        setDuringDone(from.getDuringDone());
        setDuringBoot(from.getDuringBoot());
        setResultKeep(from.getResultKeep());
        setLastExec(from.getLastExec());
        setLastFail(from.getLastFail());
        setLastDone(from.getLastDone());
        setNextExec(from.getNextExec());
        setNextLock(from.getNextLock());
        setDurFail(from.getDurFail());
        setSumExec(from.getSumExec());
        setSumFail(from.getSumFail());
        setSumDone(from.getSumDone());
    }

    @Override
    public <E extends IWinTaskDefine> E into(E into) {
        into.from(this);
        return into;
    }
}
