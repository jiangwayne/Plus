package com.plus.server.common.vo;

import java.util.Date;

import com.plus.server.common.SysConfig;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class ProductVo {
	@ApiModelProperty(" id ")
	private Long id;

	@ApiModelProperty(" 类型（10-机票，20-门票）")
	private Integer type;

	@ApiModelProperty(" 产品名称")
	private String name;

	@ApiModelProperty(" 产品名称(英文)")
	private String nameEn;

	@ApiModelProperty(" 素材url")
	private String fileUrl;

	@ApiModelProperty(" 产品简介")
	private String descriptionSimple;
	private String descriptionSimpleEn;

	@ApiModelProperty(" 产品详细描述")
	private String descriptionDetail;
	private String descriptionDetailEn;

	@ApiModelProperty(" 原价")
	private Integer priceOriginal;

	@ApiModelProperty(" 现价")
	private Integer priceCurrent;

	@ApiModelProperty(" 出发地点")
	private String addressStart;
	private String addressStartEn;

	@ApiModelProperty(" 目的地")
	private String addressEnd;
	private String addressEndEn;

	@ApiModelProperty(" 销量")
	private Integer saleCount;

	@ApiModelProperty(" 6个icon的图片id(逗号分隔)")
	private String icon;

	@ApiModelProperty(" 改退须知id")
	private Integer orderAlterAgreementId;

	@ApiModelProperty(" 评论数")
	private Integer commentCount;

	@ApiModelProperty(" 位置经纬度(经纬度用逗号分隔)")
	private String longLat;

	@ApiModelProperty(" 位置描述")
	private String longLatAddress;
	private String longLatAddressEn;

	@ApiModelProperty(" 支付类型（1-直接支付，2-不直接支付（生成的是待确认订单））")
	private Integer payType;

	@ApiModelProperty(" 里程数(单位km)")
	private Integer mileage;

	@ApiModelProperty(" 飞行时长(单位分钟)")
	private Integer flyTime;

	@ApiModelProperty(" 创建时间")
	private Date gmtCreate;
	@ApiModelProperty(" 创建时间(yyyy-MM-dd Hh:mm:ss)")
	private String gmtCreateStr;

	@ApiModelProperty(" 最后修改时间")
	private Date gmtModify;
	@ApiModelProperty(" 最后修改时间(yyyy-MM-dd Hh:mm:ss)")
	private String gmtModifyStr;
	@ApiModelProperty(" 飞机Id")
	private Long planeId;//
	@ApiModelProperty(" 频道图片 684*304 1张")
	private String pindaoPic;//
	@ApiModelProperty(" 封面图片750*1334  1张")
	private String fengmianPic;//
	@ApiModelProperty("轮播图片750*550 8张")
	private String lunboPic;//

	public Long getPlaneId() {
		return planeId;
	}

	public void setPlaneId(Long planeId) {
		this.planeId = planeId;
	}

	public String getPindaoPic() {
		return pindaoPic;
	}

	public void setPindaoPic(String pindaoPic) {
		this.pindaoPic = pindaoPic;
	}

	public String getFengmianPic() {
		return fengmianPic;
	}

	public void setFengmianPic(String fengmianPic) {
		this.fengmianPic = fengmianPic;
	}

	public String getLunboPic() {
		return lunboPic;
	}

	public void setLunboPic(String lunboPic) {
		this.lunboPic = lunboPic;
	}

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
		this.name = name;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
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

	public String getDescriptionDetail() {
		return descriptionDetail;
	}

	public void setDescriptionDetail(String descriptionDetail) {
		this.descriptionDetail = descriptionDetail;
	}

	public String getDescriptionDetailEn() {
		return descriptionDetailEn;
	}

	public void setDescriptionDetailEn(String descriptionDetailEn) {
		this.descriptionDetailEn = descriptionDetailEn;
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
		this.addressStart = addressStart;
	}

	public String getAddressStartEn() {
		return addressStartEn;
	}

	public void setAddressStartEn(String addressStartEn) {
		this.addressStartEn = addressStartEn;
	}

	public String getAddressEnd() {
		return addressEnd;
	}

	public void setAddressEnd(String addressEnd) {
		this.addressEnd = addressEnd;
	}

	public String getAddressEndEn() {
		return addressEndEn;
	}

	public void setAddressEndEn(String addressEndEn) {
		this.addressEndEn = addressEndEn;
	}

	/**
	 * 增加系数
	 * @return
	 */
	public Integer getSaleCount() {
		if(saleCount == null){
			saleCount = 0;
		}
		return saleCount * SysConfig.up_scale_a + SysConfig.up_scale_b;
	}

	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getOrderAlterAgreementId() {
		return orderAlterAgreementId;
	}

	public void setOrderAlterAgreementId(Integer orderAlterAgreementId) {
		this.orderAlterAgreementId = orderAlterAgreementId;
	}

	/**
	 * 增加系数
	 * @return
	 */
	public Integer getCommentCount() {
		if(commentCount == null){
			commentCount = 0;
		}
		return commentCount * SysConfig.up_scale_a + SysConfig.up_scale_b;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public String getLongLat() {
		return longLat;
	}

	public void setLongLat(String longLat) {
		this.longLat = longLat;
	}

	public String getLongLatAddress() {
		return longLatAddress;
	}

	public void setLongLatAddress(String longLatAddress) {
		this.longLatAddress = longLatAddress;
	}

	public String getLongLatAddressEn() {
		return longLatAddressEn;
	}

	public void setLongLatAddressEn(String longLatAddressEn) {
		this.longLatAddressEn = longLatAddressEn;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public Integer getFlyTime() {
		return flyTime;
	}

	public void setFlyTime(Integer flyTime) {
		this.flyTime = flyTime;
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

}