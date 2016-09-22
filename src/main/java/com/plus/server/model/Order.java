package com.plus.server.model;

import java.util.Date;

public class Order {
	/**  */
	private Long id;

	/** 订单号 */
	private String orderNo;

	/** 用户id */
	private Long userId;

	/** 产品id */
	private Long productId;

	/** 产品规格id */
	private Long productSpecId;

	/** 数量 */
	private Integer count;

	/** 单价 */
	private Integer priceEach;

	/** 总价 */
	private Integer priceTotal;

	/** 登机人id，逗号分隔 */
	private String boardingIds;

	/** 状态（10-待确认，20-待付款，30-待评价，40-已评价，50-已取消） */
	private Integer status;

	private String comment;

	/** 逻辑删除（1:有效数据,-1:已删除） */
	private Integer valid;

	/** 创建时间 */
	private Date gmtCreate;

	/** 修改时间 */
	private Date gmtModify;

	// -------------查询条件----------- */
	/** 是否未到出行日期 */
	private boolean notYetTravel;

	public boolean getNotYetTravel() {
		return notYetTravel;
	}

	public void setNotYetTravel(boolean notYetTravel) {
		this.notYetTravel = notYetTravel;
	}

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

	public String getBoardingIds() {
		return boardingIds;
	}

	public void setBoardingIds(String boardingIds) {
		this.boardingIds = boardingIds;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
}