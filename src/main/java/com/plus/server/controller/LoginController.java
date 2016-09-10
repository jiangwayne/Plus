package com.plus.server.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.plus.server.common.util.EmailUtil;
import com.plus.server.common.util.MsgUtil;
import com.plus.server.common.vo.resp.BaseResp;
import com.plus.server.model.User;
import com.plus.server.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

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
            r.setMsg(u.getId().toString()); //到极光注册别名用
        } else {
            r.setMsg("用户不存在或密码不正确");
        }
        return r;
    }

    @RequestMapping(value = "/getValidateCode", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "获取注册验证码")
    public BaseResp getValidateCode(@ApiParam(required = true, value = "手机号") @RequestParam(required = true) String phone) {
        log.info("手机注册，phone={}", phone);
        BaseResp r = new BaseResp();
        Random random = new Random();
        int randomInt = random.nextInt(999999);
        if (randomInt < 100000) {
            randomInt += 100000;
        }

        try {
            String getURL = "http://222.73.117.169/msg/HttpBatchSendSM?account=N9778371&pswd=Ps03262e&mobile=" + phone +
                    "&msg=【iFlyPlus】" + URLEncoder.encode("您好，您的验证码是", "utf-8") + randomInt + "&needstatus=true";
            URL getUrl = new URL(getURL);
            HttpURLConnection connection = (HttpURLConnection)getUrl.openConnection();
            connection.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String lines;
            while ((lines = reader.readLine()) != null) {
                lines += lines.toString();
            }
            reader.close();
            connection.disconnect();
        }catch (Exception e){

        }

        String msg = "验证码：" + randomInt;
        MsgUtil.sendMsg(phone, msg);
        this.httpSession.setAttribute("validateCode", randomInt);

        r.setSuccess(true);
        return r;
    }
    
    @RequestMapping(value = "/getEmailValidateCode", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "获取邮箱注册验证码")
    public BaseResp getEmailValidateCode(@ApiParam(required = true, value = "邮箱") @RequestParam(required = true) String toEmailUser) {
        log.info("邮箱注册，toEmailUser={}", toEmailUser);
        BaseResp r = new BaseResp();
        Random random = new Random();
        int randomInt = random.nextInt(999999);
        if (randomInt < 100000) {
            randomInt += 100000;
        }
        //randomInt = 123456;//TODO 测试用
        String msg = genMailContent(randomInt);
        EmailUtil.sendMsg(toEmailUser,"【iFlyPlus】确认电子邮件(验证码)", msg);
        this.httpSession.setAttribute("validateCode", randomInt);

        r.setSuccess(true);
        return r;
    }
//    public static void main(String[] args) throws Exception {
//    	int randomInt = 123456;
//    	LoginController lc = new LoginController();
//        String msg = lc.genMailContent( randomInt);
//        EmailUtil.sendMsg("150491137@qq.com","确认电子邮件(验证码)", msg);
//	}
    private String genMailContent(int validCode){
    	String s = "<b>您好！</b><br>";
    	s+="<b>恭喜您注册成为iFlyPlus私人飞行平台用户。iFlyPlus将用心为您服务！爱飞行，自逍遥。</b><br>";
    	s+="您现在正验证您的邮箱，验证成功后，您可以使用邮箱作为用户名进行登录及其他操作。<br>";
    	s+="请输入<span style=\"color:#ff6666;\">邮箱验证码："+validCode+"</span>，以完成注册。<br>";
    	s+="注册完成后，您可以使用邮箱作为用户名进行iFlyPlus App登录及其他操作。您也可通过邮箱及时收到订单提醒，惊喜包机等信息。<br><br>";
    	s+="最后祝您生活愉快。<br><br>";
    	s+="iFlyPlus团队 敬奉<br>";
    	s+="联系我们<br>";
    	s+="vip_service@iflyplus.com<br>";
    	
    	return s;
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
        if(o == null || !validateCode.equals(o.toString())){
            r.setMsg("验证码错误");
            return r;
        }
        if(!password.equals(confirmpassword)){
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
