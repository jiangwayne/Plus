//package com.plus.server.controller;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.plus.server.model.User;
//import com.plus.server.service.DemoService;
//import com.wordnik.swagger.annotations.Api;
//import com.wordnik.swagger.annotations.ApiOperation;
//import com.wordnik.swagger.annotations.ApiParam;
//
//@RestController
//@Api("示例")
//@RequestMapping(value = "plus")
//public class DemoController extends BaseController {
//	private static final Logger log = LoggerFactory.getLogger(DemoController.class);
//
//	@Autowired
//	private DemoService demoService;
//
//	@RequestMapping(value = "/demo/listAllUser", method = RequestMethod.GET)
//	@ResponseBody
//	@ApiOperation(value = "查询所有用户")
//	public List<User> listAllUser() {
//		log.info("查询所有用户。。。");
//		System.out.println("into listAllUser");
//		List<User> list = demoService.queryAllUser();
//		return list;
//	}
//
//	@RequestMapping(value = "/demo/addUser", method = RequestMethod.GET)
//	@ResponseBody
//	@ApiOperation(value = "添加用户")
//	public Long addUser(@ApiParam(required = true, value = "用户名") @RequestParam(required = true) String userName,
//			@ApiParam(required = true, value = "密码") @RequestParam(required = true) String pwd) {
//		log.info("添加用户。。。");
//		System.out.println("into addUser");
//		User u = new User();
//		u.setPhone(userName);
//		u.setPasswordHash(pwd);
//		u.setValid(1);
//		demoService.addUser(u);
//		return u.getId();
//	}
//
//	@RequestMapping(value = "/demo/login", method = RequestMethod.GET)
//	@ResponseBody
//	@ApiOperation(value = "登录")
//	public boolean login(@ApiParam(required = true, value = "用户名") @RequestParam(required = true) String userName,
//			@ApiParam(required = true, value = "密码") @RequestParam(required = true) String pwd) {
//		log.info("登录。。。");
//		User u = new User();
//		u.setPhone(userName);
//		u.setPasswordHash(pwd);
//		this.httpSession.setAttribute("user", u);
//		return true;
//	}
//
//	@RequestMapping(value = "/demo/logout", method = RequestMethod.GET)
//	@ResponseBody
//	@ApiOperation(value = "登出")
//	public boolean logout() {
//		log.info("登出。。。");
//		this.httpSession.removeAttribute("user");
//		return true;
//	}
//}
