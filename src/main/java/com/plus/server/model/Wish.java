package com.plus.server.model;

import java.util.Date;

/**
 * Created by jiangwulin on 16/5/22.
 */
//心愿单
public class Wish {
    private int id;                 //主键id 自增
    private int user_id;            //用户id
    private Date travel_date;       //出行日期
    private int people_number;      //人数
    private int budget;             //预算(单位:分)
    private String content;         //内容
    private int process_state;      //处理状态（1:未回复,2:已回复）

    private int valid;              //逻辑删除（1:有效数据,-1:已删除）
    private Date gmt_create;        //创建时间
    private Date gmt_modify;        //修改时间
}
