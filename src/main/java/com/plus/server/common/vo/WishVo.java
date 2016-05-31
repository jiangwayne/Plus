package com.plus.server.common.vo;

import java.util.Date;

/**
 * Created by jiangwulin on 16/6/1.
 */
public class WishVo {
    /** 用户id */
    private Long userId;

    /** 出行日期 */
    private Date travelDate;

    /** 人数 */
    private Integer peopleNumber;

    /** 预算(单位:分) */
    private Integer budget;

    /** 内容 */
    private Integer content;

    /** 回复消息内容 */
    private String contentReply;

    /** 处理状态（1:未回复,2:已回复） */
    private Integer processState;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getContent() {
        return content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }

    public String getContentReply() {
        return contentReply;
    }

    public void setContentReply(String contentReply) {
        this.contentReply = contentReply == null ? null : contentReply.trim();
    }

    public Integer getProcessState() {
        return processState;
    }

    public void setProcessState(Integer processState) {
        this.processState = processState;
    }

}
