package com.plus.server.common.vo;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class OrderVo {
    @ApiModelProperty(" id ")
    private Long id;

    @ApiModelProperty(" 用户id ")
    private Long userId;

    @ApiModelProperty(" 产品id ")
    private Long productId;

    @ApiModelProperty(" 产品规格id ")
    private Long productSpecId;

    @ApiModelProperty(" 数量 ")
    private Integer count;

    @ApiModelProperty(" 单价 ")
    private Integer priceEach;

    @ApiModelProperty(" 总价 ")
    private Integer priceTotal;

    @ApiModelProperty(" 状态（10-待确认，20-待付款，30-待评价，40-已评价，50-已取消） ")
    private Integer status;

    @ApiModelProperty(" 创建时间 ")
    private Date gmtCreate;
    @ApiModelProperty(" 创建时间(yyyy-MM-dd Hh:mm:ss) ")
    private Date gmtCreateStr;

}