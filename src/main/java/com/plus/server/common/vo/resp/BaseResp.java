package com.plus.server.common.vo.resp;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class BaseResp {
	@ApiModelProperty("是否成功，true-成功，false-失败")
	private boolean success;

	@ApiModelProperty("消息，失败时（success=false）返回的错误消息")
	private String msg;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
