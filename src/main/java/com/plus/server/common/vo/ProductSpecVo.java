package com.plus.server.common.vo;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class ProductSpecVo {
	@ApiModelProperty(" id ")
	private Long id;
	@ApiModelProperty(" 产品id")
	private Long productId;

	@ApiModelProperty(" 开始日期")
	private Date startDate;
	@ApiModelProperty(" 开始日期(yyyy-MM-dd)")
	private String startDateStr;

	@ApiModelProperty(" 名称")
	private String name;

	private String nameEn;

	@ApiModelProperty(" 简介")
	private String descriptionSimple;

	private String descriptionSimpleEn;

	@ApiModelProperty(" 原价")
	private Integer priceOriginal;

	@ApiModelProperty(" 现价")
	private Integer priceCurrent;

	@ApiModelProperty(" 库存数")
	private Integer countMax;

	@ApiModelProperty(" 已卖数量")
	private Integer countSale;

	@ApiModelProperty(" 逻辑删除（1:有效数据,-1:已删除）")
	private Integer valid;

	@ApiModelProperty(" 创建时间")
	private Date gmtCreate;
	@ApiModelProperty(" 创建时间(yyyy-MM-dd Hh:mm:ss)")
	private String gmtCreateStr;

	@ApiModelProperty(" 最后修改时间")
	private Date gmtModify;
	@ApiModelProperty(" 最后修改时间(yyyy-MM-dd Hh:mm:ss)")
	private String gmtModifyStr;

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
		this.name = name;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getDescriptionSimple() {
		return descriptionSimple;
	}

	public void setDescriptionSimple(String descriptionSimple) {
		this.descriptionSimple = descriptionSimple;
	}

	public String getDescriptionSimpleEn() {
		return descriptionSimpleEn;
	}

	public void setDescriptionSimpleEn(String descriptionSimpleEn) {
		this.descriptionSimpleEn = descriptionSimpleEn;
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

	public String getGmtCreateStr() {
		return gmtCreateStr;
	}

	public void setGmtCreateStr(String gmtCreateStr) {
		this.gmtCreateStr = gmtCreateStr;
	}

	public Date getGmtModify() {
		return gmtModify;
	}

	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

	public String getGmtModifyStr() {
		return gmtModifyStr;
	}

	public void setGmtModifyStr(String gmtModifyStr) {
		this.gmtModifyStr = gmtModifyStr;
	}

	public String getStartDateStr() {
		return startDateStr;
	}

	public void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
	}

}