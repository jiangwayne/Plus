package com.plus.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.plus.server.common.vo.UserVO;
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

	public UserVO getCurrentUser() {
		UserVO u = (UserVO) httpRequest.getSession().getAttribute("user");
		return u;
	}

}
