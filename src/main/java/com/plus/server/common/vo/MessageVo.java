package com.plus.server.common.vo;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Created by jiangwulin on 16/6/1.
 */
public class MessageVo {
    @ApiModelProperty(" 消息类型（1:行程,2:询价,3:提醒,4:促销） ")
    private Integer messageType;

    @ApiModelProperty(" 消息类容 ")
    private String content;

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

}
