package com.plus.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.plus.server.common.vo.resp.BaseResp;
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
	public BaseResp createOrder(@ApiParam(required = true, value = "产品规格id") @RequestParam(required = true) Long productSpecId,
			@ApiParam(required = true, value = "数量") @RequestParam(required = true) Integer count) {
		log.info("创建订单---productSpecId={},count={}", productSpecId, count);
		BaseResp r = new BaseResp();
		Long userId = this.getCurrentUser().getId();
		try {
			orderService.createOrder(userId,productSpecId,count);
		} catch (Exception e) {
			log.error("",e);
			r.setMsg(e.getMessage());
			return r;
		}
		r.setSuccess(true);
		return r;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "订单查询")
	public BaseResp list(@ApiParam(required = true, value = "产品规格id") @RequestParam(required = true) Long productSpecId,
			@ApiParam(required = true, value = "数量") @RequestParam(required = true) Integer count) {
		log.info("创建订单---productSpecId={},count={}", productSpecId, count);
		BaseResp r = new BaseResp();
		Long userId = this.getCurrentUser().getId();
		try {
			orderService.createOrder(userId,productSpecId,count);
		} catch (Exception e) {
			log.error("",e);
			r.setMsg(e.getMessage());
			return r;
		}
		r.setSuccess(true);
		return r;
	}
	
}
