package com.plus.server.common.vo;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jiangwulin on 16/6/1.
 */
public class WishVo {
    @ApiModelProperty(" 出行日期 ")
    private Date travelDate;

    @ApiModelProperty(" 创建时间(yyyy-MM-dd Hh:mm:ss) ")
    private String travelDateStr;

    @ApiModelProperty(" 人数 ")
    private Integer peopleNumber;

    @ApiModelProperty(" 预算(单位:分) ")
    private Integer budget;

    @ApiModelProperty(" 内容 ")
    private String content;

    @ApiModelProperty(" 回复消息内容 ")
    private String contentReply;

    @ApiModelProperty(" 处理状态（1:未回复,2:已回复） ")
    private Integer processState;

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public String getTravelDateStr() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd Hh:mm:ss");
        if(this.travelDate != null && !this.travelDate.equals("")){
            return f.format(this.travelDate);
        }
        return "";
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
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
