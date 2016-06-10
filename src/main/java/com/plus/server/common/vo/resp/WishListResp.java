package com.plus.server.common.vo.resp;

import com.plus.server.common.vo.WishVo;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by jiangwulin on 16/6/10.
 */
public class WishListResp extends BaseResp {
    public List<WishVo> getWishVoList() {
        return wishVoList;
    }

    public void setWishVoList(List<WishVo> wishVoList) {
        this.wishVoList = wishVoList;
    }

    @ApiModelProperty("用户心愿单")
    private List<WishVo> wishVoList;

}
