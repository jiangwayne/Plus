package com.plus.server.common.vo;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class OrderVo {
	@ApiModelProperty(" id ")
	private Long id;

	@ApiModelProperty(" 用户id ")
	private Long userId;

	@ApiModelProperty(" 产品id ")
	private Long productId;

	@ApiModelProperty(" 产品规格id ")
	private Long productSpecId;

	@ApiModelProperty(" 数量 ")
	private Integer count;

	@ApiModelProperty(" 单价 ")
	private Integer priceEach;

	@ApiModelProperty(" 总价 ")
	private Integer priceTotal;

	@ApiModelProperty(" 状态（10-待确认，20-待付款，30-待评价，40-已评价，50-已取消） ")
	private Integer status;

	@ApiModelProperty(" 创建时间  ")
	private Date gmtCreate;
	@ApiModelProperty(" 创建时间(yyyy-MM-dd Hh:mm:ss) ")
	private String gmtCreateStr;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getProductSpecId() {
		return productSpecId;
	}
	public void setProductSpecId(Long productSpecId) {
		this.productSpecId = productSpecId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getPriceEach() {
		return priceEach;
	}
	public void setPriceEach(Integer priceEach) {
		this.priceEach = priceEach;
	}
	public Integer getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(Integer priceTotal) {
		this.priceTotal = priceTotal;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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

}