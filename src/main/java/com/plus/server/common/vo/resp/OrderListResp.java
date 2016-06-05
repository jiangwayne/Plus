package com.plus.server.common.vo.resp;

import java.util.List;

import com.plus.server.common.vo.OrderVo;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class OrderListResp extends BasePageResp {

	@ApiModelProperty("订单列表")
	private List<OrderVo> orderList;

	public List<OrderVo> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderVo> orderList) {
		this.orderList = orderList;
	}
	
}
