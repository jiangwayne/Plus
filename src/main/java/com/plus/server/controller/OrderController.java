package com.plus.server.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.plus.server.common.PageDefault;
import com.plus.server.common.util.BeanMapper;
import com.plus.server.common.vo.OrderVo;
import com.plus.server.common.vo.resp.BaseResp;
import com.plus.server.common.vo.resp.OrderListResp;
import com.plus.server.model.Order;
import com.plus.server.service.OrderService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@RestController
@Api("订单")
@RequestMapping(value = "plus/order")
public class OrderController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "创建订单")
	public BaseResp createOrder(
			@ApiParam(required = true, value = "产品规格id") @RequestParam(required = true) Long productSpecId,
			@ApiParam(required = true, value = "数量") @RequestParam(required = true) Integer count) {
		log.info("创建订单---productSpecId={},count={}", productSpecId, count);
		BaseResp r = new BaseResp();
		Long userId = this.getCurrentUser().getId();
		try {
			orderService.createOrder(userId, productSpecId, count);
		} catch (Exception e) {
			log.error("", e);
			r.setMsg(e.getMessage());
			return r;
		}
		r.setSuccess(true);
		return r;
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "订单查询")
	public OrderListResp list(@ApiParam(required = true, value = "产品id") @RequestParam(required = true) Long productId,
			@ApiParam(required = true, value = "状态（10-待确认，20-待付款，30-待评价，40-已评价，50-已取消）") @RequestParam(required = true) Integer status,
			@RequestParam(required = false) @ApiParam(required = false, value = "当前页码") Integer page,
			@RequestParam(required = false) @ApiParam(required = false, value = "每页记录数") Integer pageSize) {
		log.info("订单查询---productId={},status={}", productId, status);
		OrderListResp r = new OrderListResp();
		r.setSuccess(true);
		Long userId = this.getCurrentUser().getId();
		if (page == null || page <= 0) {
			page = PageDefault.PAGE_NUM_DEFAULT;
		}
		if (pageSize == null || pageSize <= 0) {
			pageSize = PageDefault.PAGE_SIZE_DEFAULT;
		}
		PageInfo<Order> pageInfo = orderService.list(userId,status,page,pageSize);
		List<OrderVo> orderList = BeanMapper.mapList(pageInfo.getList(), OrderVo.class);
		SimpleDateFormat f = new SimpleDateFormat();
		for(OrderVo vo : orderList){
			if(vo.getGmtCreate() != null){
				vo.setGmtCreateStr(f.format(vo.getGmtCreate()));
			}
		}
		r.setOrderList(orderList);
		r.setSuccess(true);
		return r;
	}
}
