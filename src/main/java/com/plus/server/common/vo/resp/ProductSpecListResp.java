package com.plus.server.common.vo.resp;

import java.util.List;

import com.plus.server.common.vo.ProductSpecVo;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class ProductSpecListResp extends BasePageResp {

	@ApiModelProperty("产品规格列表")
	private List<ProductSpecVo> productSpecList;

	public List<ProductSpecVo> getProductSpecList() {
		return productSpecList;
	}

	public void setProductSpecList(List<ProductSpecVo> productSpecList) {
		this.productSpecList = productSpecList;
	}

}
