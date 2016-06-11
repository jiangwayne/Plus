package com.plus.server.controller;

import com.plus.server.common.util.MsgUtil;
import com.plus.server.common.vo.resp.BaseResp;
import com.plus.server.model.User;
import com.plus.server.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * Created by jiangwulin on 16/6/11.
 */
@RestController
@Api("登录")
@RequestMapping(value = "login")
public class LoginController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "登录")
    public BaseResp login(@ApiParam(required = true, value = "邮箱或手机号") @RequestParam(required = true) String userName,
                          @ApiParam(required = true, value = "密码") @RequestParam(required = true) String pwd) {
        log.info("登录---userName={},pwd={}", userName, pwd);
        BaseResp r = new BaseResp();
        if(userService.login(userName, pwd)) {
            User u = userService.getUserByName(userName);
            this.httpSession.setAttribute("user", u);
            r.setSuccess(true);
        }
        r.setMsg("用户不存在或密码不正确");
        return r;
    }

    @RequestMapping(value = "/getValidateCode", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "获取注册验证码")
    public BaseResp getValidateCode(@ApiParam(required = true, value = "手机号") @RequestParam(required = true) String phone) {
        log.info("注册，phone={}", phone);
        BaseResp r = new BaseResp();
        Random random = new Random();
        int randomInt = random.nextInt(999999);
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
        if(o == null || !validateCode.equals(o.toString())){
            r.setMsg("验证码错误");
            return r;
        }
        try {
            userService.register(phone, email, password);
            r.setSuccess(true);
        } catch (Exception e) {
            log.error("", e);
            r.setMsg(e.getMessage());
        }
        return r;
    }

    @RequestMapping(value = "/modifyPassword", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "找回密码")
    public BaseResp modifyPassword(@ApiParam(required = true, value = "邮箱或手机号") @RequestParam(required = true) String userName,
                                   @ApiParam(required = true, value = "新密码") @RequestParam(required = true) String password,
                                   @ApiParam(required = true, value = "确认新密码") @RequestParam(required = true) String confirmpassword,
                                   @ApiParam(required = true, value = "验证码") @RequestParam(required = true) String validateCode){
        log.info("找回密码，userName={}, password={}，confirmpassword={}，validateCode={}", userName, password, confirmpassword, validateCode);
        BaseResp r = new BaseResp();
        Object o = this.httpSession.getAttribute("validateCode");
        if(o == null || !validateCode.equals(o)){
            r.setMsg("验证码错误");
            return r;
        }
        if(password != confirmpassword){
            r.setMsg("两次输入密码不一致");
            return r;
        }

        try{
            userService.modifyPassword(userName, password);
            r.setSuccess(true);
        }
        catch (Exception e){
            log.error("", e);
            r.setMsg("重置密码失败");
        }
        return r;
    }
}
