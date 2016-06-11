package com.plus.server.common.vo.resp;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class BasePageResp extends BaseResp {
	@ApiModelProperty("总记录数")
	private long total;

	@ApiModelProperty("总页数")
	private int pages;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

}
