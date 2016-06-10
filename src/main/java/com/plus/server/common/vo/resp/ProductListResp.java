package com.plus.server.common.vo.resp;

import java.util.List;

import com.plus.server.common.vo.ProductVo;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class ProductListResp extends BasePageResp {

	@ApiModelProperty("产品列表")
	private List<ProductVo> productList;

	public List<ProductVo> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductVo> productList) {
		this.productList = productList;
	}

}
