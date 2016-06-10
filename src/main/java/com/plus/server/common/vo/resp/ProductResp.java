package com.plus.server.common.vo.resp;

import com.plus.server.common.vo.ProductVo;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class ProductResp extends BasePageResp {

	@ApiModelProperty("产品信息")
	private ProductVo product;

	public ProductVo getProduct() {
		return product;
	}

	public void setProduct(ProductVo product) {
		this.product = product;
	}

}
