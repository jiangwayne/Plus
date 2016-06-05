package com.plus.server.controller;

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

/**
 * Created by jiangwulin on 16/5/22.
 */

@RestController
@Api("用户")
@RequestMapping(value = "plus/user")
public class UserController {
    @Autowired
    private UserService userService;

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
