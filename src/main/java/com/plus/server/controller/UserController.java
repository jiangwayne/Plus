package com.plus.server.controller;

import com.plus.server.model.User;
import com.plus.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by jiangwulin on 16/5/22.
 */

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/trade/register", method = RequestMethod.POST)
    @ResponseBody
//    public boolean register(@RequestParam("phone") String phone, @RequestParam("email") String email,
//                            @RequestParam("pwd") String password)
    public boolean register(@RequestBody Map<String, Object> params)
    {
        String phone = params.get("phone").toString();
        String email = params.get("email").toString();
        String password = params.get("pwd").toString();
        return userService.register(phone, email, password);
    }

    @RequestMapping(value = "/trade/login", method = RequestMethod.POST)
    @ResponseBody
    public boolean login(@RequestBody User user)
    {
        return userService.login(user);
    }

}
