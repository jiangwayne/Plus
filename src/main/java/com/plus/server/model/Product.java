package com.plus.server.model;

import java.util.Date;

public class Product {
    /**  */
    private Long id;

    /** 类型（10-机票，20-门票） */
    private Integer type;

    /** 产品名称 */
    private String name;

    /** 产品简介 */
    private String descriptionSimple;

    /** 产品详细描述 */
    private String descriptionDetail;

    /** 原价 */
    private Integer priceOriginal;

    /** 现价 */
    private Integer priceCurrent;

    /** 出发地点 */
    private String addressStart;

    /** 销量 */
    private Integer saleCount;

    /** 6个icon的图片id */
    private String icon;

    /** 改退须知id */
    private Integer orderAlterAgreementId;

    /** 评论数 */
    private Integer commentCount;

    /** 位置经纬度 */
    private String longLat;

    /** 位置描述 */
    private String longLatAddress;

    /** 支付类型（1-直接支付，2-不直接支付（生成的是待确认订单）） */
    private Integer payType;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescriptionSimple() {
        return descriptionSimple;
    }

    public void setDescriptionSimple(String descriptionSimple) {
        this.descriptionSimple = descriptionSimple == null ? null : descriptionSimple.trim();
    }

    public String getDescriptionDetail() {
        return descriptionDetail;
    }

    public void setDescriptionDetail(String descriptionDetail) {
        this.descriptionDetail = descriptionDetail == null ? null : descriptionDetail.trim();
    }

    public Integer getPriceOriginal() {
        return priceOriginal;
    }

    public void setPriceOriginal(Integer priceOriginal) {
        this.priceOriginal = priceOriginal;
    }

    public Integer getPriceCurrent() {
        return priceCurrent;
    }

    public void setPriceCurrent(Integer priceCurrent) {
        this.priceCurrent = priceCurrent;
    }

    public String getAddressStart() {
        return addressStart;
    }

    public void setAddressStart(String addressStart) {
        this.addressStart = addressStart == null ? null : addressStart.trim();
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getOrderAlterAgreementId() {
        return orderAlterAgreementId;
    }

    public void setOrderAlterAgreementId(Integer orderAlterAgreementId) {
        this.orderAlterAgreementId = orderAlterAgreementId;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getLongLat() {
        return longLat;
    }

    public void setLongLat(String longLat) {
        this.longLat = longLat == null ? null : longLat.trim();
    }

    public String getLongLatAddress() {
        return longLatAddress;
    }

    public void setLongLatAddress(String longLatAddress) {
        this.longLatAddress = longLatAddress == null ? null : longLatAddress.trim();
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
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