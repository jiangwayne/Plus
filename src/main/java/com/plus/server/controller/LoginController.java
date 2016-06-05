package com.plus.server.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.plus.server.common.util.MsgUtil;
import com.plus.server.common.vo.resp.BaseResp;
import com.plus.server.model.User;
import com.plus.server.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@RestController
@Api("登录登出")
@RequestMapping(value = "plus")
public class LoginController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "登录")
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

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "登出")
	public BaseResp logout() {
		log.info("登出----");
		BaseResp r = new BaseResp();
		this.httpSession.removeAttribute("user");
		r.setSuccess(true);
		return r;
	}

	@RequestMapping(value = "/getValidateCode", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "获取注册验证码")
	public BaseResp getValidateCode(@ApiParam(required = true, value = "手机号") @RequestParam(required = true) String phone) {
		log.info("注册，phone={}", phone);
		BaseResp r = new BaseResp();
		Random random = new Random();
		int randomInt = random.nextInt(6);
		if (randomInt < 100000) {
			randomInt += 100000;
		}
		String msg = "验证码：" + randomInt;
		MsgUtil.sendMsg(phone, msg);
		this.httpSession.setAttribute("validateCode", randomInt);
		
		r.setSuccess(true);
		return r;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "注册")
	public BaseResp register(@ApiParam(required = true, value = "手机号") @RequestParam(required = true) String phone,
			@ApiParam(required = true, value = "邮箱") @RequestParam(required = true) String email,
			@ApiParam(required = true, value = "密码") @RequestParam(required = true) String password,
			@ApiParam(required = true, value = "验证码") @RequestParam(required = true) String validateCode) {
		log.info("注册，phone={}，email={}，password={}，validateCode={}", phone, email, password, validateCode);
		BaseResp r = new BaseResp();
		Object o = this.httpSession.getAttribute("validateCode");
		if(o == null || !validateCode.equals(o)){
			r.setMsg("验证码错误");
			return r;
		}
		try {
			userService.register(phone, email, password);
		} catch (Exception e) {
			log.error("", e);
			r.setMsg("注册失败");
			return r;
		}
		r.setSuccess(true);
		return r;
	}
}
