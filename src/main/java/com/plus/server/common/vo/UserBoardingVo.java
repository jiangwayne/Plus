package com.plus.server.common.vo;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by jiangwulin on 16/6/11.
 */
public class UserBoardingVo {
    @ApiModelProperty(" 乘机人id")
    private Long id;

    @ApiModelProperty(" 全名 ")
    private String fullName;

    @ApiModelProperty(" 姓 ")
    private String firstName;

    @ApiModelProperty(" 名 ")
    private String lastName;

    @ApiModelProperty(" 国籍 ")
    private String nationality;

    @ApiModelProperty(" 证件类型 ")
    private Integer credentialType;

    @ApiModelProperty(" 证件号码 ")
    private String credential_number;

    @ApiModelProperty(" 生日 ")
    private Date birthday;

    @ApiModelProperty(" 联系电话 ")
    private String phone;

    @ApiModelProperty(" 地址 ")
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getCredentialType() {
        return credentialType;
    }

    public void setCredentialType(Integer credentialType) {
        this.credentialType = credentialType;
    }

    public String getCredential_number() {
        return credential_number;
    }

    public void setCredential_number(String credential_number) {
        this.credential_number = credential_number;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
