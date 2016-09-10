package com.plus.server.controller;

import com.alibaba.fastjson.JSON;
import com.plus.server.common.util.BeanMapper;
import com.plus.server.common.vo.*;
import com.plus.server.common.vo.resp.*;
import com.plus.server.model.*;
import com.plus.server.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.plus.server.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangwulin on 16/5/22.
 */

@RestController
@Api("用户")
@RequestMapping(value = "plus/user")
public class UserController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "登出")
    public BaseResp logout() {
        log.info("登出----");
        User u = this.getCurrentUser();
        BaseResp r = new BaseResp();
        if(u == null)
        {
            r.setMsg("未登录");
            return r;
        }

        this.httpSession.removeAttribute("user");
        r.setSuccess(true);
        return r;
    }


    @RequestMapping(value = "/getUserSetting", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取用户设置")
    public UserSettingResp getUserSetting()
    {
        log.info("获取用户设置----");
        User u = this.getCurrentUser();
        UserSettingResp userSettingResp = new UserSettingResp();
        if(u == null)
        {
            userSettingResp.setMsg("未登录");
            return userSettingResp;
        }
        try{
            UserSetting userSetting = userService.getUserSetting(u.getId());
            if (userSetting != null) {
                userSettingResp.setUserSettingVo(BeanMapper.map(userSetting, UserSettingVo.class));
            } else {
                userSettingResp.setMsg("用户未设置");
            }
            userSettingResp.setSuccess(true);
        }
        catch (Exception e){
            log.error("",e);
            userSettingResp.setMsg(e.getMessage());
        }

        return userSettingResp;
    }


    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "updateUser")
    public BaseResp updateUser(@ApiParam(required = false, value = "手机号") @RequestParam(required = false) String phone,
                               @ApiParam(required = false, value = "邮箱") @RequestParam(required = false) String email,
                               @ApiParam(required = false, value = "旧密码") @RequestParam(required = false) String oldpassword,
                               @ApiParam(required = false, value = "密码") @RequestParam(required = false) String password,
                               @ApiParam(required = false, value = "昵称") @RequestParam(required = false) String nickname,
                               @ApiParam(required = false, value = "性别") @RequestParam(required = false) Integer gender,
                               @ApiParam(required = false,value = "习惯") @RequestParam(required = false) Integer habit){
        BaseResp r = new BaseResp();
        User u = (User)httpSession.getAttribute("user");
        if(u == null){
            r.setMsg("用户不存在");
        }
        if(phone != null && !phone.equals("")){
            u.setPhone(phone);
        }
        if(email != null && !email.equals("")) {
            u.setEmail(email);
        }
        if(oldpassword != null && !oldpassword.equals("")){
            if(!userService.login(phone,oldpassword) && !userService.login(email,oldpassword)){
                r.setMsg("旧密码错误");
            }
        }
        if(nickname != null && !nickname.equals("")){
            u.setNickname(nickname);
        }
        if(gender != null){
            u.setGender(gender);
        }
        if(habit != null){
            u.setHabit(habit);
        }
        if(password != null && !password.equals("")) {
            userService.updateUser(u, password);
        } else {
            userService.updateUser(u);
        }

        return r;
    }

    @RequestMapping(value = "/setUserSetting", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "更新用户设置")
    public BaseResp setUserSetting(@ApiParam(required = true, value = "用户设置") @RequestBody(required = true) UserSettingVo userSettingVo)
    {
        log.info("更新用户设置----userSettingVo={}", JSON.toJSONString(userSettingVo));
        User u = this.getCurrentUser();
        BaseResp r = new BaseResp();
        if(u == null)
        {
            r.setMsg("未登录");
            return r;
        }
        try{
            UserSetting userSetting = BeanMapper.map(userSettingVo, UserSetting.class);
            userSetting.setUserId(u.getId());
            userService.setUserSetting(userSetting);
            r.setSuccess(true);
        }
        catch (Exception e){
            log.error("", e);
            r.setMsg(e.getMessage());
        }

        return r;
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取用户信息(积分,里程数,飞行时长,成行次数)")
    public UserResp getUserInfo()
    {
        log.info("获取用户信息-------");
        User u = this.getCurrentUser();
        UserResp userResp = new UserResp();
        if(u == null)
        {
            userResp.setMsg("未登录");
            return userResp;
        }
        try{
            u = userService.getUser(u.getId());
            userResp.setUserVo(BeanMapper.map(u, UserVo.class));
            userResp.setSuccess(true);
        }
        catch (Exception e){
            log.error("",e);
            userResp.setMsg(e.getMessage());
        }

        return userResp;
    }


    @RequestMapping(value = "/getUserMessage", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取用户消息提醒")
    public MessageListResp getUserMessage()
    {
        log.info("获取用户消息提醒-------");
        User u = this.getCurrentUser();
        MessageListResp messageResp = new MessageListResp();
        if(u == null)
        {
            messageResp.setMsg("未登录");
            return messageResp;
        }
        try {
            List<Message> messages = userService.getUserMessage(u.getId());
            if(messages != null && !messages.isEmpty()){
                List<MessageVo> messageVoList = BeanMapper.mapList(messages, MessageVo.class);
                messageResp.setMessageVoList(messageVoList);
            } else {
                messageResp.setMsg("该用户无消息提醒");
            }
            messageResp.setSuccess(true);
        }
        catch (Exception e){
            log.error("", e);
            messageResp.setMsg(e.getMessage());
        }

        return messageResp;
    }


    @RequestMapping(value = "/getUserWish", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取用户心愿单")
    public WishListResp getUserWish()
    {
        log.info("获取用户心愿单-------");
        User u = this.getCurrentUser();
        WishListResp wishListResp = new WishListResp();
        if(u == null)
        {
            wishListResp.setMsg("未登录");
            return wishListResp;
        }
        try{
            List<Wish> wishList = userService.getUserWish(u.getId());
            if(wishList != null && !wishList.isEmpty()){
                List<WishVo> wishVoList = BeanMapper.mapList(wishList,WishVo.class);
                wishListResp.setWishVoList(wishVoList);
            } else {
                wishListResp.setMsg("该用户无心愿单");
            }

            wishListResp.setSuccess(true);
        }
        catch (Exception e){
            log.error("", e);
            wishListResp.setMsg(e.getMessage());
        }

        return wishListResp;
    }

    @RequestMapping(value = "/addUserWish", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "提交用户心愿单")
    public BaseResp addUserWish(@ApiParam(required = true, value = "用户心愿单") @RequestBody(required = true) WishVo wishVo)
    {
        log.info("提交用户心愿单-------wishVo={}", JSON.toJSONString(wishVo));
        User u = this.getCurrentUser();
        BaseResp r = new BaseResp();
        if(u == null)
        {
            r.setMsg("未登录");
            return r;
        }
        try {
            Wish wish = BeanMapper.map(wishVo, Wish.class);
            wish.setUserId(u.getId());
            userService.addUserWish(wish);
            r.setSuccess(true);
        }
        catch (Exception e){
            log.error("", e);
            r.setMsg(e.getMessage());
        }
        return r;
    }

    @RequestMapping(value = "/addPassenger", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加乘机人")
    public BaseResp addPassenger(@ApiParam(required = true, value = "乘机人") @RequestBody(required = true) UserBoardingVo userBoardingVo)
    {
        log.info("添加乘机人-------userBoardingVo={}", JSON.toJSONString(userBoardingVo));
        User u = this.getCurrentUser();
        BaseResp r = new BaseResp();
        if(u == null)
        {
            r.setMsg("未登录");
            return r;
        }
        try{
            UserBoarding userBoarding = BeanMapper.map(userBoardingVo, UserBoarding.class);
            userBoarding.setUserId(u.getId());
            userService.createUserBoarding(userBoarding);
            r.setSuccess(true);

        }
        catch (Exception e){
            log.error("", e);
            r.setMsg(e.getMessage());
        }
        return r;
    }

    @RequestMapping(value = "/passengerList", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "乘机人列表")
    public UserBoardingListResp getPassengerList(@ApiParam(required = false, value = "oderId") @RequestParam(required = false) String orderId)
    {
        log.info("乘机人列表-------");
        User u = this.getCurrentUser();
        UserBoardingListResp userBoardingListResp = new UserBoardingListResp();
        if(u == null)
        {
            userBoardingListResp.setMsg("未登录");
            return userBoardingListResp;
        }
        try{
            String ids = "";
            if(orderId != null && !orderId.equals("")){
                ids = orderService.selectById(Long.parseLong(orderId)).getBoardingIds();
            }

            List<UserBoarding> userBoardingList = userService.getUserBoarding(u.getId());
            List<UserBoarding> result = new ArrayList<>();
            if(!ids.equals("")) {
                for(UserBoarding userBoarding : userBoardingList){
                    if(ids.contains(userBoarding.getId().toString())){
                        result.add(userBoarding);
                    }
                }
                userBoardingList = result;
            }


            if(userBoardingList != null && !userBoardingList.isEmpty()) {
                List<UserBoardingVo> userBoardingVoList = BeanMapper.mapList(userBoardingList, UserBoardingVo.class);
                userBoardingListResp.setUserBoardingVoList(userBoardingVoList);
            } else {
                userBoardingListResp.setMsg("该用户无乘机人");
            }

            userBoardingListResp.setSuccess(true);
        }
        catch (Exception e){
            log.error("", e);
            userBoardingListResp.setMsg(e.getMessage());
        }
        return userBoardingListResp;
    }


    @RequestMapping(value = "/deletePassenger", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "删除乘机人")
    public BaseResp deletePassenger(@ApiParam(required = true, value = "乘机人") @RequestBody(required = true) UserBoardingVo userBoardingVo)
    {
        log.info("删除乘机人-------userBoardingVo={}", JSON.toJSONString(userBoardingVo));
        User u = this.getCurrentUser();
        BaseResp r = new BaseResp();
        if(u == null)
        {
            r.setMsg("未登录");
            return r;
        }
        try{
            UserBoarding userBoarding = BeanMapper.map(userBoardingVo, UserBoarding.class);
            userBoarding.setUserId(u.getId());
            userService.deleteUserBoarding(userBoarding);
            r.setSuccess(true);
        }
        catch (Exception e){
            log.error("", e);
            r.setMsg(e.getMessage());
        }
        return r;
    }


    @RequestMapping(value = "/picLibList", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "首页图片")
    public PicLibListResp getPicLibList(){
        PicLibListResp picLibListResp = new PicLibListResp();

        try{
            List<PicLib> list = userService.getPicLib();
            if(list != null && !list.isEmpty()) {
                List<PicLibVo> PicLibVoList = BeanMapper.mapList(list, PicLibVo.class);
                picLibListResp.setPicLibList(PicLibVoList);
            }

        }catch (Exception e){
            log.error("", e);
            picLibListResp.setMsg(e.getMessage());
        }
        return picLibListResp;
    }
}
