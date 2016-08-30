package com.plus.server.model;

import java.util.Date;

public class Transaction {
    private Long id;

    private String tradeNo;

    private Integer transStatus;

    private Integer transType;

    private Integer transAmount;

    private String userId;

    private String userName;

    private String ip;

    private String sourceChannel;

    private String partnerOrderNo;

    private String partnerType;

    private Integer valid;

    private Date gmtCreate;

    private Date gmtModify;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public Integer getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(Integer transStatus) {
        this.transStatus = transStatus;
    }

    public Integer getTransType() {
        return transType;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }

    public Integer getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(Integer transAmount) {
        this.transAmount = transAmount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getSourceChannel() {
        return sourceChannel;
    }

    public void setSourceChannel(String sourceChannel) {
        this.sourceChannel = sourceChannel == null ? null : sourceChannel.trim();
    }

    public String getPartnerOrderNo() {
        return partnerOrderNo;
    }

    public void setPartnerOrderNo(String partnerOrderNo) {
        this.partnerOrderNo = partnerOrderNo == null ? null : partnerOrderNo.trim();
    }

    public String getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(String partnerType) {
        this.partnerType = partnerType == null ? null : partnerType.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
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
}