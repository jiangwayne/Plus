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
import com.plus.server.model.User;
import com.plus.server.service.OrderService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@RestController
@Api("订单")
@RequestMapping(value = "plus")
public class OrderController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "创建订单")
	public BaseResp login(@ApiParam(required = true, value = "用户名") @RequestParam(required = true) String userName,
			@ApiParam(required = true, value = "密码") @RequestParam(required = true) String pwd) {
		log.info("登录---userName={},pwd={}", userName, pwd);
		BaseResp r = new BaseResp();
		User u = new User();
		u.setPhone(userName);
		u.setPasswordHash(pwd);
		this.httpSession.setAttribute("user", u);
		
		r.setSuccess(true);
		return r;
	}
	
}
