package com.plus.server.common.vo.resp;

import com.plus.server.common.vo.PicLibVo;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by iloveiflyplus on 16/9/10.
 */
public class PicLibListResp extends BaseResp {
    @ApiModelProperty("首页图片")
    private List<PicLibVo> picLibList;


    public List<PicLibVo> getPicLibList() {
        return picLibList;
    }

    public void setPicLibList(List<PicLibVo> picLibList) {
        this.picLibList = picLibList;
    }
}
