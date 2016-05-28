package com.plus.server.common.vo;

public class UserVO {
	/**  */
    private Long id;

    /** 手机号（app注册） */
    private String phone;

    /** 邮箱（app注册） */
    private String email;

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
    
}
