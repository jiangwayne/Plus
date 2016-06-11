package com.plus.server.common.vo.resp;

import com.plus.server.common.vo.UserVo;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Created by jiangwulin on 16/6/11.
 */
public class UserResp extends BaseResp {
    @ApiModelProperty("用户信息")
    private UserVo userVo;

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }
}
