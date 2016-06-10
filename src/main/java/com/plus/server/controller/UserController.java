package com.plus.server.controller;

import com.plus.server.common.util.MsgUtil;
import com.plus.server.common.vo.resp.BaseResp;
import com.plus.server.common.vo.resp.MessageResp;
import com.plus.server.common.vo.resp.UserSettingResp;
import com.plus.server.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.plus.server.common.vo.MessageVo;
import com.plus.server.common.vo.UserSettingVo;
import com.plus.server.common.vo.WishVo;
import com.plus.server.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import java.util.Random;
import java.util.concurrent.ExecutionException;

/**
 * Created by jiangwulin on 16/5/22.
 */

@RestController
@Api("用户")
@RequestMapping
public class UserController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

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
            User u = new User();
            u.setPhone(userName);
            u.setPasswordHash(pwd);
            this.httpSession.setAttribute("user", u);
            r.setSuccess(true);
        }
        else {
            r.setSuccess(false);
        }
        return r;
    }

    @RequestMapping(value = "plus/user/logout", method = RequestMethod.POST)
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

    @RequestMapping(value = "plus/user/getUserSetting", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取用户设置")
    public UserSettingResp getUserSetting()
    {
        User u = (User) this.httpSession.getAttribute("user");
        UserSettingResp userSettingResp = new UserSettingResp();
        if(u != null) {
            try{
                userSettingResp.setUserSettingVo(userService.getUserSetting(u.getId()));
                userSettingResp.setSuccess(true);
            }
            catch (Exception e){
                log.error("",e);
                userSettingResp.setSuccess(false);
                userSettingResp.setMsg(e.getMessage());
            }
        }
        else
        {
            userSettingResp.setSuccess(false);
            userSettingResp.setMsg("未登录");
        }
        return userSettingResp;
    }

    @RequestMapping(value = "plus/user/setUserSetting", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新用户设置")
    public boolean setUserSetting(@ApiParam(required = true, value = "用户设置") @RequestBody(required = true) UserSettingVo userSettingVo)
    {
        return userService.setUserSetting(userSettingVo);
    }

    @RequestMapping(value = "plus/user/getUserMessage", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取用户消息提醒")
    public MessageResp getUserMessage()
    {
        User u = (User) this.httpSession.getAttribute("user");
        MessageResp messageResp = new MessageResp();
        if(u != null) {
            try {
                messageResp.setMessageVo(userService.getUserMessage(u.getId()));
                messageResp.setSuccess(true);
            }
            catch (Exception e){
                log.error("", e);
                messageResp.setSuccess(false);
                messageResp.setMsg(e.getMessage());
            }
        }
        else {
            messageResp.setSuccess(false);
            messageResp.setMsg("未登录");
        }

        return messageResp;
    }

    @RequestMapping(value = "plus/user/getUserWish", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取用户心愿单")
    public WishVo getUserWish()
    {
        User u = (User) this.httpSession.getAttribute("user");
        return userService.getUserWish(u.getId());
    }

    @RequestMapping(value = "plus/user/commitUserWish", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "提交用户心愿单")
    public boolean commitUserWish(@ApiParam(required = true, value = "用户心愿单") @RequestBody(required = true) WishVo wishVo)
    {
        return userService.commitUserWish(wishVo);
    }

}
