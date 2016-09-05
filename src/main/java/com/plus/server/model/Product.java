package com.plus.server.model;

import java.util.Date;

public class Product {
	private Long id;
	
	private String code;

	private Integer type;//类型（10-机票BB,11-机票LY,20-门票SE,21-门票SP）

	private String name;

	private String nameEn;

	private String fileUrl;

	private String descriptionSimple;

	private String descriptionSimpleEn;

	private String descriptionDetail;

	private String descriptionDetailEn;

	private Integer priceOriginal;

	private Integer priceCurrent;

	private String addressStart;

	private String addressStartEn;

	private String addressEnd;

	private String addressEndEn;

	private Integer cityStart;

	private Integer cityEnd;

	private Integer airportStart;

	private Integer airportEnd;

	private Integer saleCount;

	private String icon;

	private Integer orderAlterAgreementId;

	private Integer commentCount;

	private String longLat;

	private String longLatAddress;

	private String longLatAddressEn;

	private Integer payType;

	private Integer mileage;

	private Integer flyTime;

	private Integer isShowHome;

	private Integer isSpecialPrice;

	private Integer valid;

	private Date gmtCreate;

	private Date gmtModify;
	
	/*******/
	private Long planeId;//飞机Id
	private String pindaoPic;//频道图片 684*304 1张
	private String fengmianPic;//封面图片750*1334  1张
	private String lunboPic;//轮播图片750*550 8张
	
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
		this.name = name == null ? null : name.trim();
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn == null ? null : nameEn.trim();
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl == null ? null : fileUrl.trim();
	}

	public String getDescriptionSimple() {
		return descriptionSimple;
	}

	public void setDescriptionSimple(String descriptionSimple) {
		this.descriptionSimple = descriptionSimple == null ? null : descriptionSimple.trim();
	}

	public String getDescriptionSimpleEn() {
		return descriptionSimpleEn;
	}

	public void setDescriptionSimpleEn(String descriptionSimpleEn) {
		this.descriptionSimpleEn = descriptionSimpleEn == null ? null : descriptionSimpleEn.trim();
	}

	public String getDescriptionDetail() {
		return descriptionDetail;
	}

	public void setDescriptionDetail(String descriptionDetail) {
		this.descriptionDetail = descriptionDetail == null ? null : descriptionDetail.trim();
	}

	public String getDescriptionDetailEn() {
		return descriptionDetailEn;
	}

	public void setDescriptionDetailEn(String descriptionDetailEn) {
		this.descriptionDetailEn = descriptionDetailEn == null ? null : descriptionDetailEn.trim();
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

	public String getAddressStartEn() {
		return addressStartEn;
	}

	public void setAddressStartEn(String addressStartEn) {
		this.addressStartEn = addressStartEn == null ? null : addressStartEn.trim();
	}

	public String getAddressEnd() {
		return addressEnd;
	}

	public void setAddressEnd(String addressEnd) {
		this.addressEnd = addressEnd == null ? null : addressEnd.trim();
	}

	public String getAddressEndEn() {
		return addressEndEn;
	}

	public void setAddressEndEn(String addressEndEn) {
		this.addressEndEn = addressEndEn == null ? null : addressEndEn.trim();
	}

	public Integer getCityStart() {
		return cityStart;
	}

	public void setCityStart(Integer cityStart) {
		this.cityStart = cityStart;
	}

	public Integer getCityEnd() {
		return cityEnd;
	}

	public void setCityEnd(Integer cityEnd) {
		this.cityEnd = cityEnd;
	}

	public Integer getAirportStart() {
		return airportStart;
	}

	public void setAirportStart(Integer airportStart) {
		this.airportStart = airportStart;
	}

	public Integer getAirportEnd() {
		return airportEnd;
	}

	public void setAirportEnd(Integer airportEnd) {
		this.airportEnd = airportEnd;
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

	public String getLongLatAddressEn() {
		return longLatAddressEn;
	}

	public void setLongLatAddressEn(String longLatAddressEn) {
		this.longLatAddressEn = longLatAddressEn == null ? null : longLatAddressEn.trim();
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

	public Integer getIsShowHome() {
		return isShowHome;
	}

	public void setIsShowHome(Integer isShowHome) {
		this.isShowHome = isShowHome;
	}

	public Integer getIsSpecialPrice() {
		return isSpecialPrice;
	}

	public void setIsSpecialPrice(Integer isSpecialPrice) {
		this.isSpecialPrice = isSpecialPrice;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}