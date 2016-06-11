package com.plus.server.controller;

import com.plus.server.common.util.BeanMapper;
import com.plus.server.common.util.MsgUtil;
import com.plus.server.common.vo.*;
import com.plus.server.common.vo.resp.*;
import com.plus.server.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.plus.server.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import java.util.List;
import java.util.Random;

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
            this.httpSession.setAttribute("user", u);
            r.setSuccess(true);
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
            r.setSuccess(true);
        } catch (Exception e) {
            log.error("", e);
            r.setMsg("注册失败");
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

    @RequestMapping(value = "plus/user/getUserSetting", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取用户设置")
    public UserSettingResp getUserSetting()
    {
        User u = this.getCurrentUser();
        UserSettingResp userSettingResp = new UserSettingResp();
        try{
            UserSetting userSetting = userService.getUserSetting(u.getId());
            userSettingResp.setUserSettingVo(BeanMapper.map(userSetting, UserSettingVo.class));
            userSettingResp.setSuccess(true);
        }
        catch (Exception e){
            log.error("",e);
            userSettingResp.setMsg(e.getMessage());
        }

        return userSettingResp;
    }


    @RequestMapping(value = "plus/user/setUserSetting", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "更新用户设置")
    public BaseResp setUserSetting(@ApiParam(required = true, value = "用户设置") @RequestBody(required = true) UserSettingVo userSettingVo)
    {
        User u = this.getCurrentUser();
        BaseResp r = new BaseResp();
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

    @RequestMapping(value = "plus/user/getUserInfo", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取用户信息(积分,里程数,飞行时长,成行次数)")
    public UserResp getUserInfo()
    {
        User u = this.getCurrentUser();
        UserResp userResp = new UserResp();
        try{
            User user = userService.getUser(u.getId());
            userResp.setUserVo(BeanMapper.map(user, UserVo.class));
            userResp.setSuccess(true);
        }
        catch (Exception e){
            log.error("",e);
            userResp.setMsg(e.getMessage());
        }

        return userResp;
    }


    @RequestMapping(value = "plus/user/getUserMessage", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取用户消息提醒")
    public MessageListResp getUserMessage()
    {
        User u = this.getCurrentUser();
        MessageListResp messageResp = new MessageListResp();
        try {
            List<Message> messages = userService.getUserMessage(u.getId());
            List<MessageVo> messageVoList = BeanMapper.mapList(messages,MessageVo.class);
            messageResp.setMessageVoList(messageVoList);
            messageResp.setSuccess(true);
        }
        catch (Exception e){
            log.error("", e);
            messageResp.setMsg(e.getMessage());
        }

        return messageResp;
    }


    @RequestMapping(value = "plus/user/getUserWish", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取用户心愿单")
    public WishListResp getUserWish()
    {
        User u = this.getCurrentUser();
        WishListResp wishListResp = new WishListResp();
        try{
            List<Wish> wishList = userService.getUserWish(u.getId());
            List<WishVo> wishVoList = BeanMapper.mapList(wishList,WishVo.class);
            wishListResp.setWishVoList(wishVoList);
            wishListResp.setSuccess(true);
        }
        catch (Exception e){
            log.error("", e);
            wishListResp.setMsg(e.getMessage());
        }
        return wishListResp;
    }

    @RequestMapping(value = "plus/user/commitUserWish", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "提交用户心愿单")
    public BaseResp commitUserWish(@ApiParam(required = true, value = "用户心愿单") @RequestBody(required = true) WishVo wishVo)
    {
        User u = this.getCurrentUser();
        BaseResp r = new BaseResp();
        try{
            Wish wish = BeanMapper.map(wishVo, Wish.class);
            wish.setUserId(u.getId());
            userService.commitUserWish(wish);
            r.setSuccess(true);
        }
        catch (Exception e){
            log.error("", e);
            r.setMsg(e.getMessage());
        }
        return r;
    }

    @RequestMapping(value = "plus/user/addPassenger", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加乘机人")
    public BaseResp addPassenger(@ApiParam(required = true, value = "乘机人") @RequestBody(required = true) UserBoardingVo userBoardingVo)
    {
        User u = this.getCurrentUser();
        BaseResp r = new BaseResp();
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

    @RequestMapping(value = "plus/user/passengerList", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "乘机人列表")
    public UserBoardingListResp getPassengerList()
    {
        User u = this.getCurrentUser();
        UserBoardingListResp userBoardingListResp = new UserBoardingListResp();
        try{
            List<UserBoarding> userBoardingList = userService.getUserBoarding(u.getId());
            List<UserBoardingVo> userBoardingVoList = BeanMapper.mapList(userBoardingList,UserBoardingVo.class);
            userBoardingListResp.setUserBoardingVoList(userBoardingVoList);
            userBoardingListResp.setSuccess(true);
        }
        catch (Exception e){
            log.error("", e);
            userBoardingListResp.setMsg(e.getMessage());
        }
        return userBoardingListResp;
    }


    @RequestMapping(value = "plus/user/deletePassenger", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "删除乘机人")
    public BaseResp deletePassenger(@ApiParam(required = true, value = "乘机人") @RequestBody(required = true) UserBoardingVo userBoardingVo)
    {
        User u = this.getCurrentUser();
        BaseResp r = new BaseResp();
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
}
