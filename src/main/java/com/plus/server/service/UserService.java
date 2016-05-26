package com.plus.server.service;

import com.plus.server.model.User;

/**
 * Created by jiangwulin on 16/5/22.
 */
public interface UserService {
    boolean register(String phone, String email, String password);
    boolean login(User user);
}
