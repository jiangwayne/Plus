package com.plus.server.model;

import java.util.Date;

/**
 * Created by jiangwulin on 16/5/22.
 */
//用户
public class User {
    private  int id;                //用户id （主键,自增）
    private String phone;           //手机号（app注册）
    private String email;           //邮箱（app注册）
    private String password_hash;   //加密后的密码
    private String password_salt;   //salt
    private int user_type;          //用户类别（1:app注册,2:微信登录）
    private int gender;             //性别（微信登录获取）
    private String region;          //地区（微信登录获取）
    private int point;              //积分

    private int valid;              //逻辑删除（1:有效数据,-1:已删除）
    private Date gmt_create;        //创建时间
    private Date gmt_modify;        //修改时间

    public User(String phone, String email)
    {
        this.phone = phone;
        this.email = email;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPassword_hash(String password_hash)
    {
        this.password_hash = password_hash;
    }

    public void setPassword_salt(String password_salt)
    {
        this.password_salt = password_salt;
    }

    public void setValid(int valid)
    {
        this.valid = valid;
    }
}
