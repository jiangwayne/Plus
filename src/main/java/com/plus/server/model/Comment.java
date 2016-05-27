package com.plus.server.model;

import java.util.Date;

/**
 * Created by jiangwulin on 16/5/27.
 */
//评论
public class Comment {
    private int id;                 //评论id（主键,自增）
    private int order_id;           //订单id
    private String content;         //内容
    private int process_state;      //处理状态（1:审核通过,2:审核未通过）

    private int valid;              //逻辑删除（1:有效数据,-1:已删除）
    private Date gmt_create;        //创建时间
    private Date gmt_modify;        //修改时间
}
