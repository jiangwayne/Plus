package com.plus.server.common.vo;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class CommentVo {
	@ApiModelProperty(" ")
	private Long id;

	@ApiModelProperty(" 用户id")
	private Long userId;

	@ApiModelProperty(" 产品id")
	private Long productId;

	@ApiModelProperty(" 订单id")
	private Long orderId;

	@ApiModelProperty(" 内容")
	private String content;

	@ApiModelProperty(" 状态（10-待审核，20-已审核）")
	private Integer status;

	@ApiModelProperty(" 创建时间")
	private Date gmtCreate;
	@ApiModelProperty(" 创建时间(yyyy-MM-dd Hh:mm:ss)")
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

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
