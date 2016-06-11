package com.plus.server.controller;

import com.plus.server.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.plus.server.common.vo.UserVo;
import javax.servlet.http.*;

@RestController
public class BaseController {

	private static final Logger log = LoggerFactory.getLogger(BaseController.class);

	@Autowired
	protected HttpServletRequest httpRequest;
	@Autowired
	protected HttpSession httpSession;
	@Autowired
	protected HttpServletResponse httpResponse;

	public User getCurrentUser() {
		User u = (User) httpRequest.getSession().getAttribute("user");
		return u;
	}

}
