package com.plus.server.common.vo;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class UserVo {
	@ApiModelProperty(" 手机号（app注册） ")
    private String phone;

	@ApiModelProperty(" 邮箱(app注册) ")
    private String email;

	@ApiModelProperty(" 用户类别(1:app注册,2:微信登录) ")
    private Integer userType;

	@ApiModelProperty(" 微信登录唯一编码 ")
    private String wxUniqueCode;

	@ApiModelProperty(" 性别(微信登录获取) ")
    private Integer wxGender;

	@ApiModelProperty(" 地区(微信登录获取) ")
    private String wxRegion;

	@ApiModelProperty(" 积分 ")
    private Integer point;

	@ApiModelProperty(" 里程数(单位km) ")
	private Integer mileage;

	@ApiModelProperty(" 飞行时长(单位分钟) ")
	private Integer flyTime;

	@ApiModelProperty(" 成行次数(即订机票的次数) ")
	private Integer flyCount;

	@ApiModelProperty(" 昵称 ")
	private String nickname;

	@ApiModelProperty(" 性别（1:男,2:女) ")
	private Integer gender;

	@ApiModelProperty(" 1出差；2度假；3直飞；4家庭 ")
	private Integer habit;


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		this.wxUniqueCode = wxUniqueCode;
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
		this.wxRegion = wxRegion;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Integer getFlyTime() {
		return flyTime;
	}

	public void setFlyTime(Integer flyTime) {
		this.flyTime = flyTime;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public Integer getFlyCount() {
		return flyCount;
	}

	public void setFlyCount(Integer flyCount) {
		this.flyCount = flyCount;
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
