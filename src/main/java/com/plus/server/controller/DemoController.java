package com.plus.server.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.plus.server.model.User;
import com.plus.server.service.DemoService;

@RestController
@RequestMapping(value = "plus")
public class DemoController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(DemoController.class);
	
	@Autowired
	private DemoService demoService;

	@RequestMapping(value = "/demo/listAllUser", method = RequestMethod.GET)
	@ResponseBody
	public List<User> listAllUser() {
		List<User> list = demoService.queryAllUser();
		return list;
	}
	
	@RequestMapping(value = "/demo/addUser", method = RequestMethod.GET)
	@ResponseBody
	public Long addUser(String userName, String pwd) {
		User u = new User();
		u.setPhone(userName);
		u.setPasswordHash(pwd);
		demoService.addUser(u);
		return u.getId();
	}
}
