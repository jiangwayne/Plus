package com.plus.server.common.vo.resp;

import com.plus.server.common.vo.OrderVo;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class OrderResp extends BasePageResp {

	@ApiModelProperty("订单")
	private OrderVo order;

	public OrderVo getOrder() {
		return order;
	}

	public void setOrder(OrderVo order) {
		this.order = order;
	}

}
