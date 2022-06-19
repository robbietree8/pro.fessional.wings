/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.warlock.database.autogen.tables.pojos;


import pro.fessional.wings.warlock.database.autogen.tables.interfaces.IWinConfRuntime;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * The table <code>wings_warlock.win_conf_runtime</code>.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.15",
        "schema version:2021102301"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Entity
@Table(
    name = "win_conf_runtime",
    uniqueConstraints = {
        @UniqueConstraint(name = "KEY_win_conf_runtime_PRIMARY", columnNames = { "key" })
    }
)
public class WinConfRuntime implements IWinConfRuntime {

    private static final long serialVersionUID = 1L;

    private String key;
    private String current;
    private String previous;
    private String initial;
    private String comment;
    private String handler;

    public WinConfRuntime() {}

    public WinConfRuntime(IWinConfRuntime value) {
        this.key = value.getKey();
        this.current = value.getCurrent();
        this.previous = value.getPrevious();
        this.initial = value.getInitial();
        this.comment = value.getComment();
        this.handler = value.getHandler();
    }

    public WinConfRuntime(
        String key,
        String current,
        String previous,
        String initial,
        String comment,
        String handler
    ) {
        this.key = key;
        this.current = current;
        this.previous = previous;
        this.initial = initial;
        this.comment = comment;
        this.handler = handler;
    }

    /**
     * Getter for <code>win_conf_runtime.key</code>.
     */
    @Id
    @Column(name = "key", nullable = false, length = 200)
    @NotNull
    @Size(max = 200)
    @Override
    public String getKey() {
        return this.key;
    }

    /**
     * Setter for <code>win_conf_runtime.key</code>.
     */
    @Override
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Getter for <code>win_conf_runtime.current</code>.
     */
    @Column(name = "current", nullable = false, length = 3000)
    @Size(max = 3000)
    @Override
    public String getCurrent() {
        return this.current;
    }

    /**
     * Setter for <code>win_conf_runtime.current</code>.
     */
    @Override
    public void setCurrent(String current) {
        this.current = current;
    }

    /**
     * Getter for <code>win_conf_runtime.previous</code>.
     */
    @Column(name = "previous", nullable = false, length = 3000)
    @Size(max = 3000)
    @Override
    public String getPrevious() {
        return this.previous;
    }

    /**
     * Setter for <code>win_conf_runtime.previous</code>.
     */
    @Override
    public void setPrevious(String previous) {
        this.previous = previous;
    }

    /**
     * Getter for <code>win_conf_runtime.initial</code>.
     */
    @Column(name = "initial", nullable = false, length = 3000)
    @Size(max = 3000)
    @Override
    public String getInitial() {
        return this.initial;
    }

    /**
     * Setter for <code>win_conf_runtime.initial</code>.
     */
    @Override
    public void setInitial(String initial) {
        this.initial = initial;
    }

    /**
     * Getter for <code>win_conf_runtime.comment</code>.
     */
    @Column(name = "comment", nullable = false, length = 500)
    @Size(max = 500)
    @Override
    public String getComment() {
        return this.comment;
    }

    /**
     * Setter for <code>win_conf_runtime.comment</code>.
     */
    @Override
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Getter for <code>win_conf_runtime.handler</code>.
     */
    @Column(name = "handler", nullable = false, length = 200)
    @Size(max = 200)
    @Override
    public String getHandler() {
        return this.handler;
    }

    /**
     * Setter for <code>win_conf_runtime.handler</code>.
     */
    @Override
    public void setHandler(String handler) {
        this.handler = handler;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final WinConfRuntime other = (WinConfRuntime) obj;
        if (key == null) {
            if (other.key != null)
                return false;
        }
        else if (!key.equals(other.key))
            return false;
        if (current == null) {
            if (other.current != null)
                return false;
        }
        else if (!current.equals(other.current))
            return false;
        if (previous == null) {
            if (other.previous != null)
                return false;
        }
        else if (!previous.equals(other.previous))
            return false;
        if (initial == null) {
            if (other.initial != null)
                return false;
        }
        else if (!initial.equals(other.initial))
            return false;
        if (comment == null) {
            if (other.comment != null)
                return false;
        }
        else if (!comment.equals(other.comment))
            return false;
        if (handler == null) {
            if (other.handler != null)
                return false;
        }
        else if (!handler.equals(other.handler))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.key == null) ? 0 : this.key.hashCode());
        result = prime * result + ((this.current == null) ? 0 : this.current.hashCode());
        result = prime * result + ((this.previous == null) ? 0 : this.previous.hashCode());
        result = prime * result + ((this.initial == null) ? 0 : this.initial.hashCode());
        result = prime * result + ((this.comment == null) ? 0 : this.comment.hashCode());
        result = prime * result + ((this.handler == null) ? 0 : this.handler.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("WinConfRuntime (");

        sb.append(key);
        sb.append(", ").append(current);
        sb.append(", ").append(previous);
        sb.append(", ").append(initial);
        sb.append(", ").append(comment);
        sb.append(", ").append(handler);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IWinConfRuntime from) {
        setKey(from.getKey());
        setCurrent(from.getCurrent());
        setPrevious(from.getPrevious());
        setInitial(from.getInitial());
        setComment(from.getComment());
        setHandler(from.getHandler());
    }

    @Override
    public <E extends IWinConfRuntime> E into(E into) {
        into.from(this);
        return into;
    }
}