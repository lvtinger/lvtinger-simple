package com.lvtinger.value;

import java.io.Serializable;

public abstract class PersistentObject<K extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1799117846245835199L;

    private K id;
    private Long createTime;
    private Long updateTime;
    private Integer status;

    public K getId() {
        return id;
    }

    public void setId(K id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
