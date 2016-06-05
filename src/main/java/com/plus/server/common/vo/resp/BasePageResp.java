package com.plus.server.common.vo.resp;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class BasePageResp extends BaseResp {
	@ApiModelProperty("总记录数")
	private int total;

	@ApiModelProperty("总页数")
	private int pages;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

}
