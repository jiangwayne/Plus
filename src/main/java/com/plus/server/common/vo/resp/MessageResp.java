package com.plus.server.common.vo.resp;

import com.plus.server.common.vo.MessageVo;

/**
 * Created by jiangwulin on 16/6/10.
 */
public class MessageResp extends BaseResp {
    public MessageVo messageVo;

    public MessageVo getMessageVo()
    {
        return this.messageVo;
    }

    public void setMessageVo(MessageVo messageVo)
    {
        this.messageVo = messageVo;
    }
}
