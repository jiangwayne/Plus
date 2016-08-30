package com.plus.server.controller.ftl;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.plus.server.common.util.EmailUtil;
import com.plus.server.common.util.MsgUtil;
import com.plus.server.common.vo.resp.BaseResp;
import com.plus.server.controller.BaseController;
import com.plus.server.controller.LoginController;
import com.plus.server.model.User;
import com.plus.server.service.UserService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Created by jiangwulin on 16/6/11.
 */
@Controller
@RequestMapping(value = "ftlOrder")
public class FtlOrderController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test")
    public ModelAndView test() {
        ModelAndView mv = new ModelAndView("test.ftl");
        return mv;
    }

}
