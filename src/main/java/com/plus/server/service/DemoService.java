package com.plus.server.service;

import java.util.List;

import com.plus.server.model.User;

/**
 * Created by jiangwulin on 16/5/22.
 */
public interface DemoService {
    List<User> queryAllUser();
    void addUser(User user);
}
