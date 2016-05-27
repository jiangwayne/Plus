package com.plus.server.model;

import java.util.Date;

/**
 * Created by jiangwulin on 16/5/22.
 */
//订单
public class Order {
    private int id;                 //订单id（主键,自增）


    private int valid;              //逻辑删除（1:有效数据,-1:已删除）
    private Date gmt_create;        //创建时间
    private Date gmt_modify;        //修改时间
}
