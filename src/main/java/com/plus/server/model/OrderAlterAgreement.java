package com.plus.server.model;

import java.util.Date;

public class OrderAlterAgreement {
    /**  */
    private Long id;

    /** 改退须知内容 */
    private String content;

    /** 逻辑删除（1:有效数据,-1:已删除） */
    private Integer valid;

    /** 创建时间 */
    private Date gmtCreate;

    /** 修改时间 */
    private Date gmtModify;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }
}