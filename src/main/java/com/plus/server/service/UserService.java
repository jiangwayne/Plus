package com.plus.server.service;

import com.plus.server.common.vo.*;

/**
 * Created by jiangwulin on 16/5/22.
 */
public interface UserService {
    boolean register(String phone, String email, String password, String validateCode);
    boolean login(String loginString, String password);
    UserSettingVo getUserSetting(int userId);
    boolean setUserSetting(UserSettingVo userSettingVo);
    MessageVo getUserMessage(int userId);
    WishVo getUserWish(int userId);
    boolean commitUserWish(WishVo wishVo);
    boolean getValidateCode(String phone);
}
