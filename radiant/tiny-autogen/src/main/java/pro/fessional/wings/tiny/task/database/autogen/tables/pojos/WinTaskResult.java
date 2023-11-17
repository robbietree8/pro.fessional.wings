/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.tiny.task.database.autogen.tables.pojos;


import pro.fessional.wings.tiny.task.database.autogen.tables.interfaces.IWinTaskResult;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;


/**
 * The table <code>wings.win_task_result</code>.
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
public class WinTaskResult implements IWinTaskResult {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long taskId;
    private String taskApp;
    private Integer taskPid;
    private String taskMsg;
    private LocalDateTime timeExec;
    private LocalDateTime timeFail;
    private LocalDateTime timeDone;
    private Integer timeCost;

    public WinTaskResult() {}

    public WinTaskResult(IWinTaskResult value) {
        this.id = value.getId();
        this.taskId = value.getTaskId();
        this.taskApp = value.getTaskApp();
        this.taskPid = value.getTaskPid();
        this.taskMsg = value.getTaskMsg();
        this.timeExec = value.getTimeExec();
        this.timeFail = value.getTimeFail();
        this.timeDone = value.getTimeDone();
        this.timeCost = value.getTimeCost();
    }

    public WinTaskResult(
        Long id,
        Long taskId,
        String taskApp,
        Integer taskPid,
        String taskMsg,
        LocalDateTime timeExec,
        LocalDateTime timeFail,
        LocalDateTime timeDone,
        Integer timeCost
    ) {
        this.id = id;
        this.taskId = taskId;
        this.taskApp = taskApp;
        this.taskPid = taskPid;
        this.taskMsg = taskMsg;
        this.timeExec = timeExec;
        this.timeFail = timeFail;
        this.timeDone = timeDone;
        this.timeCost = timeCost;
    }

    /**
     * Getter for <code>win_task_result.id</code>.
     */
    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>win_task_result.id</code>.
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for <code>win_task_result.task_id</code>.
     */
    @Override
    public Long getTaskId() {
        return this.taskId;
    }

    /**
     * Setter for <code>win_task_result.task_id</code>.
     */
    @Override
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    /**
     * Getter for <code>win_task_result.task_app</code>.
     */
    @Override
    public String getTaskApp() {
        return this.taskApp;
    }

    /**
     * Setter for <code>win_task_result.task_app</code>.
     */
    @Override
    public void setTaskApp(String taskApp) {
        this.taskApp = taskApp;
    }

    /**
     * Getter for <code>win_task_result.task_pid</code>.
     */
    @Override
    public Integer getTaskPid() {
        return this.taskPid;
    }

    /**
     * Setter for <code>win_task_result.task_pid</code>.
     */
    @Override
    public void setTaskPid(Integer taskPid) {
        this.taskPid = taskPid;
    }

    /**
     * Getter for <code>win_task_result.task_msg</code>.
     */
    @Override
    public String getTaskMsg() {
        return this.taskMsg;
    }

    /**
     * Setter for <code>win_task_result.task_msg</code>.
     */
    @Override
    public void setTaskMsg(String taskMsg) {
        this.taskMsg = taskMsg;
    }

    /**
     * Getter for <code>win_task_result.time_exec</code>.
     */
    @Override
    public LocalDateTime getTimeExec() {
        return this.timeExec;
    }

    /**
     * Setter for <code>win_task_result.time_exec</code>.
     */
    @Override
    public void setTimeExec(LocalDateTime timeExec) {
        this.timeExec = timeExec;
    }

    /**
     * Getter for <code>win_task_result.time_fail</code>.
     */
    @Override
    public LocalDateTime getTimeFail() {
        return this.timeFail;
    }

    /**
     * Setter for <code>win_task_result.time_fail</code>.
     */
    @Override
    public void setTimeFail(LocalDateTime timeFail) {
        this.timeFail = timeFail;
    }

    /**
     * Getter for <code>win_task_result.time_done</code>.
     */
    @Override
    public LocalDateTime getTimeDone() {
        return this.timeDone;
    }

    /**
     * Setter for <code>win_task_result.time_done</code>.
     */
    @Override
    public void setTimeDone(LocalDateTime timeDone) {
        this.timeDone = timeDone;
    }

    /**
     * Getter for <code>win_task_result.time_cost</code>.
     */
    @Override
    public Integer getTimeCost() {
        return this.timeCost;
    }

    /**
     * Setter for <code>win_task_result.time_cost</code>.
     */
    @Override
    public void setTimeCost(Integer timeCost) {
        this.timeCost = timeCost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final WinTaskResult other = (WinTaskResult) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.taskId == null) {
            if (other.taskId != null)
                return false;
        }
        else if (!this.taskId.equals(other.taskId))
            return false;
        if (this.taskApp == null) {
            if (other.taskApp != null)
                return false;
        }
        else if (!this.taskApp.equals(other.taskApp))
            return false;
        if (this.taskPid == null) {
            if (other.taskPid != null)
                return false;
        }
        else if (!this.taskPid.equals(other.taskPid))
            return false;
        if (this.taskMsg == null) {
            if (other.taskMsg != null)
                return false;
        }
        else if (!this.taskMsg.equals(other.taskMsg))
            return false;
        if (this.timeExec == null) {
            if (other.timeExec != null)
                return false;
        }
        else if (!this.timeExec.equals(other.timeExec))
            return false;
        if (this.timeFail == null) {
            if (other.timeFail != null)
                return false;
        }
        else if (!this.timeFail.equals(other.timeFail))
            return false;
        if (this.timeDone == null) {
            if (other.timeDone != null)
                return false;
        }
        else if (!this.timeDone.equals(other.timeDone))
            return false;
        if (this.timeCost == null) {
            if (other.timeCost != null)
                return false;
        }
        else if (!this.timeCost.equals(other.timeCost))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.taskId == null) ? 0 : this.taskId.hashCode());
        result = prime * result + ((this.taskApp == null) ? 0 : this.taskApp.hashCode());
        result = prime * result + ((this.taskPid == null) ? 0 : this.taskPid.hashCode());
        result = prime * result + ((this.taskMsg == null) ? 0 : this.taskMsg.hashCode());
        result = prime * result + ((this.timeExec == null) ? 0 : this.timeExec.hashCode());
        result = prime * result + ((this.timeFail == null) ? 0 : this.timeFail.hashCode());
        result = prime * result + ((this.timeDone == null) ? 0 : this.timeDone.hashCode());
        result = prime * result + ((this.timeCost == null) ? 0 : this.timeCost.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("WinTaskResult (");

        sb.append(id);
        sb.append(", ").append(taskId);
        sb.append(", ").append(taskApp);
        sb.append(", ").append(taskPid);
        sb.append(", ").append(taskMsg);
        sb.append(", ").append(timeExec);
        sb.append(", ").append(timeFail);
        sb.append(", ").append(timeDone);
        sb.append(", ").append(timeCost);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IWinTaskResult from) {
        setId(from.getId());
        setTaskId(from.getTaskId());
        setTaskApp(from.getTaskApp());
        setTaskPid(from.getTaskPid());
        setTaskMsg(from.getTaskMsg());
        setTimeExec(from.getTimeExec());
        setTimeFail(from.getTimeFail());
        setTimeDone(from.getTimeDone());
        setTimeCost(from.getTimeCost());
    }

    @Override
    public <E extends IWinTaskResult> E into(E into) {
        into.from(this);
        return into;
    }
}
