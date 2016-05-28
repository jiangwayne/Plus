package com.plus.server.model;

import java.util.Date;

public class UserSetting {
    /**  */
    private Long id;

    /** 用户id */
    private Long userId;

    /** 语言（1:中文,2:英文） */
    private Integer languageType;

    /** 时间区（1~24） */
    private Integer timezone;

    /** 货币（1:CNY,2:USD,3:BGP,4:EUR,5:HKD） */
    private Integer currency;

    /** 出行日期类型（1:灵活,2:固定） */
    private Integer travelDateType;

    /** 充许经停（0:,1:,2:） */
    private Integer allowStop;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getLanguageType() {
        return languageType;
    }

    public void setLanguageType(Integer languageType) {
        this.languageType = languageType;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public Integer getTravelDateType() {
        return travelDateType;
    }

    public void setTravelDateType(Integer travelDateType) {
        this.travelDateType = travelDateType;
    }

    public Integer getAllowStop() {
        return allowStop;
    }

    public void setAllowStop(Integer allowStop) {
        this.allowStop = allowStop;
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