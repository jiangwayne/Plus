package com.plus.server.model;

import java.util.Date;

/**
 * Created by jiangwulin on 16/5/22.
 */
//用户消息
public class UserMessage {
    private int id;                 //消息id（主键,自增）
    private int user_id;            //用户id
    private int message_type;       //消息类型（1:行程,2:询价,3:提醒,4:促销）
    private String content;         //消息类容

    private int valid;              //逻辑删除（1:有效数据,-1:已删除）
    private Date gmt_create;        //创建时间
    private Date gmt_modify;        //修改时间
}
