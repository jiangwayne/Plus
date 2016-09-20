package com.plus.server.common.vo;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Created by iloveiflyplus on 16/9/10.
 */
public class PicLibVo {
    @ApiModelProperty(" 图片url")
    private String picUrl;

    @ApiModelProperty("类型")
    private Integer type;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
