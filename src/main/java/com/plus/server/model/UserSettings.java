package com.plus.server.model;

import java.util.Date;

/**
 * Created by jiangwulin on 16/5/22.
 */
//用户设置
public class UserSettings {
    private int id;                 //主键id,自增
    private int user_id;            //用户id
    private int language_type;      //语言（1:中文,2:英文）
    private int timezone;           //时间区（1~24）
    private int currency;           //货币（1:CNY,2:USD,3:BGP,4:EUR,5:HKD）
    private int travel_date_type;   //出行日期类型（1:灵活,2:固定）
    private int allow_stop;         //充许经停（0:,1:,2:）

    private int valid;              //逻辑删除（1:有效数据,-1:已删除）
    private Date gmt_create;        //创建时间
    private Date gmt_modify;        //修改时间
}
