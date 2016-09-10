package com.plus.server.model;

import java.util.Date;

public class User {
    /**  */
    private Long id;

    /** 手机号（app注册） */
    private String phone;

    /** 邮箱（app注册） */
    private String email;

    /** 加密后的密码 */
    private String passwordHash;

    /** salt */
    private String passwordSalt;

    /** 用户类别（1:app注册,2:微信登录） */
    private Integer userType;

    /** 微信登录唯一编码 */
    private String wxUniqueCode;

    /** 性别（微信登录获取） */
    private Integer wxGender;

    /** 地区（微信登录获取） */
    private String wxRegion;

    /** 积分 */
    private Integer point;

    /** 里程数(单位km) */
    private Integer mileage;

    /** 飞行时长(单位分钟) */
    private Integer flyTime;

    /** 成行次数(即订机票的次数) */
    private Integer flyCount;

    /**昵称**/
    private String nickname;

    /**性别（1:男,2:女）**/
    private Integer gender;

    /**1出差；2度假；3直飞；4家庭**/
    private Integer habit;

    /** 逻辑删除（1:有效数据,-1:已删除） */
    private Integer valid;

    /** 创建时间 */
    private Date gmtCreate;

    /** 修改时间 */
    private Date gmtModify;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash == null ? null : passwordHash.trim();
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt == null ? null : passwordSalt.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getWxUniqueCode() {
        return wxUniqueCode;
    }

    public void setWxUniqueCode(String wxUniqueCode) {
        this.wxUniqueCode = wxUniqueCode == null ? null : wxUniqueCode.trim();
    }

    public Integer getWxGender() {
        return wxGender;
    }

    public void setWxGender(Integer wxGender) {
        this.wxGender = wxGender;
    }

    public String getWxRegion() {
        return wxRegion;
    }

    public void setWxRegion(String wxRegion) {
        this.wxRegion = wxRegion == null ? null : wxRegion.trim();
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }


    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Integer getFlyTime() {
        return flyTime;
    }

    public void setFlyTime(Integer flyTime) {
        this.flyTime = flyTime;
    }

    public Integer getFlyCount() {
        return flyCount;
    }

    public void setFlyCount(Integer flyCount) {
        this.flyCount = flyCount;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getHabit() {
        return habit;
    }

    public void setHabit(Integer habit) {
        this.habit = habit;
    }
}