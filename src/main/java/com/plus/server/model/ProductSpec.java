package com.plus.server.model;

import java.util.Date;

public class ProductSpec {
    /**  */
    private Long id;

    /** 产品id */
    private Long productId;

    /** 开始日期 */
    private Date startDate;

    /** 名称 */
    private String name;

    private String nameEn;

    /** 简介 */
    private String descriptionSimple;

    private String descriptionSimpleEn;

    /** 原价 */
    private Integer priceOriginal;

    /** 现价 */
    private Integer priceCurrent;

    /** 库存数 */
    private Integer countMax;

    /** 已卖数量 */
    private Integer countSale;

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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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

    public Integer getCountMax() {
        return countMax;
    }

    public void setCountMax(Integer countMax) {
        this.countMax = countMax;
    }

    public Integer getCountSale() {
        return countSale;
    }

    public void setCountSale(Integer countSale) {
        this.countSale = countSale;
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

    public String getDescriptionSimpleEn() {
        return descriptionSimpleEn;
    }

    public void setDescriptionSimpleEn(String descriptionSimpleEn) {
        this.descriptionSimpleEn = descriptionSimpleEn;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
}