package com.plus.server.common.vo;

/**
 * Created by jiangwulin on 16/6/1.
 */
public class MessageVo {
    /** 用户id */
    private Long userId;

    /** 消息类型（1:行程,2:询价,3:提醒,4:促销） */
    private Integer messageType;

    /** 消息类容 */
    private String content;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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
