package com.plus.server.common.vo.resp;

import com.plus.server.common.vo.MessageVo;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by jiangwulin on 16/6/10.
 */
public class MessageListResp extends BaseResp {
    @ApiModelProperty("用户消息列表")
    private List<MessageVo> messageList;

    public List<MessageVo> getMessageVoList()
    {
        return this.messageList;
    }

    public void setMessageVoList(List<MessageVo> messageList)
    {
        this.messageList = messageList;
    }
}
