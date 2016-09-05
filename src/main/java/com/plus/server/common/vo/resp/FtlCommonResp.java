package com.plus.server.common.vo.resp;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class FtlCommonResp extends BaseResp {
	@ApiModelProperty("返回数据")
	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
