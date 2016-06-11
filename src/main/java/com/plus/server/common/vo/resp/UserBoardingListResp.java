package com.plus.server.common.vo.resp;

import com.plus.server.common.vo.UserBoardingVo;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by jiangwulin on 16/6/11.
 */
public class UserBoardingListResp extends BaseResp {
    @ApiModelProperty("用户乘机人")
    private List<UserBoardingVo> userBoardingVoList;

    public List<UserBoardingVo> getUserBoardingVoList() {
        return userBoardingVoList;
    }

    public void setUserBoardingVoList(List<UserBoardingVo> userBoardingVoList) {
        this.userBoardingVoList = userBoardingVoList;
    }
}
