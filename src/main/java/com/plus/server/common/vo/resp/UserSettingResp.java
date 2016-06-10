package com.plus.server.common.vo.resp;

import com.plus.server.common.vo.UserSettingVo;

/**
 * Created by jiangwulin on 16/6/10.
 */
public class UserSettingResp extends BaseResp {
    public UserSettingVo getUserSettingVo() {
        return userSettingVo;
    }

    public void setUserSettingVo(UserSettingVo userSettingVo) {
        this.userSettingVo = userSettingVo;
    }

    private UserSettingVo userSettingVo;


}
