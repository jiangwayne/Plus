package com.plus.server.controller;

import com.plus.server.common.vo.MessageVo;
import com.plus.server.common.vo.UserSettingVo;
import com.plus.server.common.vo.UserVO;
import com.plus.server.common.vo.WishVo;
import com.plus.server.model.User;
import com.plus.server.model.UserSetting;
import com.plus.server.service.UserService;
import com.sun.deploy.net.HttpRequest;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by jiangwulin on 16/5/22.
 */

@RestController
@Api("用户")
@RequestMapping(value = "plus/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "用户注册")
    public boolean register(@ApiParam(required = true, value = "手机") @RequestParam(required = true, value = "phone") String phone,
                            @ApiParam(required = true, value = "邮箱") @RequestParam(required = true, value ="email") String email,
                            @ApiParam(required = true, value = "密码") @RequestParam(required = true, value ="pwd") String password,
                            @ApiParam(required = true, value = "短信验证码") @RequestParam(required = true, value ="validateCode") String validateCode)
    {
        return userService.register(phone, email, password, validateCode);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "用户登录")
    public boolean login(@ApiParam(required = true, value = "手机或邮箱") @RequestParam(required = true, value = "loginString") String loginString,
                         @ApiParam(required = true, value = "密码") @RequestParam(required = true, value ="pwd") String password)
    {

        return userService.login(loginString, password);
    }

    @RequestMapping(value = "/getUserSetting", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取用户设置")
    public UserSettingVo getUserSetting(@ApiParam(required = true, value = "用户id") @RequestParam(required = true, value = "userId") String userId)
    {
        return userService.getUserSetting(Integer.parseInt(userId));
    }

    @RequestMapping(value = "/setUserSetting", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新用户设置")
    public boolean setUserSetting(@ApiParam(required = true, value = "用户设置") @RequestBody(required = true) UserSettingVo userSettingVo)
    {
        return userService.setUserSetting(userSettingVo);
    }

    @RequestMapping(value = "/getUserMessage", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取用户消息提醒")
    public MessageVo getUserMessage(@ApiParam(required = true, value = "用户id") @RequestParam(required = true, value = "userId") String userId)
    {
        return userService.getUserMessage(Integer.parseInt(userId));
    }

    @RequestMapping(value = "/getUserWish", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取用户心愿单")
    public WishVo getUserWish(@ApiParam(required = true, value = "用户id") @RequestParam(required = true, value = "userId") String userId)
    {
        return userService.getUserWish(Integer.parseInt(userId));
    }

    @RequestMapping(value = "/commitUserWish", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "提交用户心愿单")
    public boolean commitUserWish(@ApiParam(required = true, value = "用户心愿单") @RequestBody(required = true) WishVo wishVo)
    {
        return userService.commitUserWish(wishVo);
    }

}
