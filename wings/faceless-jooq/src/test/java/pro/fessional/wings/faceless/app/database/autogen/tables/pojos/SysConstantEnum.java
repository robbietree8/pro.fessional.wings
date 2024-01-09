/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.faceless.app.database.autogen.tables.pojos;


import pro.fessional.wings.faceless.app.database.autogen.tables.interfaces.ISysConstantEnum;

import javax.annotation.processing.Generated;


/**
 * The table <code>wings.sys_constant_enum</code>.
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
public class SysConstantEnum implements ISysConstantEnum {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String type;
    private String code;
    private String hint;
    private String info;

    public SysConstantEnum() {}

    public SysConstantEnum(ISysConstantEnum value) {
        this.id = value.getId();
        this.type = value.getType();
        this.code = value.getCode();
        this.hint = value.getHint();
        this.info = value.getInfo();
    }

    public SysConstantEnum(
        Integer id,
        String type,
        String code,
        String hint,
        String info
    ) {
        this.id = id;
        this.type = type;
        this.code = code;
        this.hint = hint;
        this.info = info;
    }

    /**
     * Getter for <code>sys_constant_enum.id</code>.
     */
    @Override
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>sys_constant_enum.id</code>.
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for <code>sys_constant_enum.type</code>.
     */
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Setter for <code>sys_constant_enum.type</code>.
     */
    @Override
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter for <code>sys_constant_enum.code</code>.
     */
    @Override
    public String getCode() {
        return this.code;
    }

    /**
     * Setter for <code>sys_constant_enum.code</code>.
     */
    @Override
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter for <code>sys_constant_enum.hint</code>.
     */
    @Override
    public String getHint() {
        return this.hint;
    }

    /**
     * Setter for <code>sys_constant_enum.hint</code>.
     */
    @Override
    public void setHint(String hint) {
        this.hint = hint;
    }

    /**
     * Getter for <code>sys_constant_enum.info</code>.
     */
    @Override
    public String getInfo() {
        return this.info;
    }

    /**
     * Setter for <code>sys_constant_enum.info</code>.
     */
    @Override
    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final SysConstantEnum other = (SysConstantEnum) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.type == null) {
            if (other.type != null)
                return false;
        }
        else if (!this.type.equals(other.type))
            return false;
        if (this.code == null) {
            if (other.code != null)
                return false;
        }
        else if (!this.code.equals(other.code))
            return false;
        if (this.hint == null) {
            if (other.hint != null)
                return false;
        }
        else if (!this.hint.equals(other.hint))
            return false;
        if (this.info == null) {
            if (other.info != null)
                return false;
        }
        else if (!this.info.equals(other.info))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
        result = prime * result + ((this.code == null) ? 0 : this.code.hashCode());
        result = prime * result + ((this.hint == null) ? 0 : this.hint.hashCode());
        result = prime * result + ((this.info == null) ? 0 : this.info.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SysConstantEnum (");

        sb.append(id);
        sb.append(", ").append(type);
        sb.append(", ").append(code);
        sb.append(", ").append(hint);
        sb.append(", ").append(info);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ISysConstantEnum from) {
        setId(from.getId());
        setType(from.getType());
        setCode(from.getCode());
        setHint(from.getHint());
        setInfo(from.getInfo());
    }

    @Override
    public <E extends ISysConstantEnum> E into(E into) {
        into.from(this);
        return into;
    }
}