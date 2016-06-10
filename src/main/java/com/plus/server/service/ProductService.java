package com.plus.server.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.plus.server.common.PageDefault;
import com.plus.server.dal.ProductDAO;
import com.plus.server.dal.ProductSpecDAO;
import com.plus.server.model.Product;
import com.plus.server.model.ProductSpec;

public class ProductService {
	private static final Logger log = LoggerFactory.getLogger(ProductService.class);
	@Autowired
	private ProductSpecDAO productSpecDAO;
	@Autowired
	private ProductDAO productDAO;

	/**
	 * 新增产品
	 * 
	 * @param product
	 * @throws Exception
	 */
	public void save(Product product) throws Exception {
		log.info("新增产品---product={}", JSON.toJSONString(product));
		if(product == null){
			throw new Exception("参数不能为空");
		}
		product.setId(null);
		product.setGmtCreate(new Date());
		product.setValid(1);
		product.setGmtModify(null);
		this.productDAO.insert(product);
	}
	
	/**
	 * 修改产品
	 * 
	 * @param product
	 * @throws Exception
	 */
	public void update(Product product) throws Exception {
		log.info("新增产品---product={}", JSON.toJSONString(product));
		if(product == null || product.getId() == null){
			throw new Exception("参数不能为空");
		}
		product.setGmtCreate(null);
		product.setGmtModify(new Date());
		this.productDAO.updateByPrimaryKeySelective(product);
	}
	
	public PageInfo<Product> selectByModel(Product product, int page, int pageSize) {
		log.info("订单查询，product={},page={},pageSize={}", JSON.toJSONString(product), page, pageSize);
		if (page <= 0) {
			page = PageDefault.PAGE_NUM_DEFAULT;
		}
		if (pageSize <= 0) {
			pageSize = PageDefault.PAGE_SIZE_DEFAULT;
		}
		PageHelper.startPage(page, pageSize);
		List<Product> list = productDAO.selectByModel(product);
		PageInfo<Product> pageInfo = new PageInfo<Product>(list);
		return pageInfo;
	}
	public PageInfo<ProductSpec> selectProductSpecByModel(ProductSpec productSpec, int page, int pageSize) {
		log.info("订单查询，productSpec={},page={},pageSize={}", JSON.toJSONString(productSpec), page, pageSize);
		if (page <= 0) {
			page = PageDefault.PAGE_NUM_DEFAULT;
		}
		if (pageSize <= 0) {
			pageSize = PageDefault.PAGE_SIZE_DEFAULT;
		}
		PageHelper.startPage(page, pageSize);
		List<ProductSpec> list = productSpecDAO.selectByModel(productSpec);
		PageInfo<ProductSpec> pageInfo = new PageInfo<ProductSpec>(list);
		return pageInfo;
	}

	public Product selectById(Long id) {
		return this.productDAO.selectByPrimaryKey(id);
	}

	public void saveProductSpec(ProductSpec productSpec) throws Exception{
		log.info("新增产品规格---productSpec={}", JSON.toJSONString(productSpec));
		if(productSpec == null || productSpec.getProductId() == null){
			throw new Exception("参数不能为空");
		}
		productSpec.setId(null);
		productSpec.setGmtCreate(new Date());
		productSpec.setValid(1);
		productSpec.setGmtModify(null);
		this.productSpecDAO.insert(productSpec);
	}

	public void updateProductSpec(ProductSpec productSpec) throws Exception{
		log.info("修改产品规格---productSpec={}", JSON.toJSONString(productSpec));
		if(productSpec == null || productSpec.getId() == null){
			throw new Exception("参数不能为空");
		}
		productSpec.setGmtCreate(null);
		productSpec.setGmtModify(new Date());
		productSpec.setProductId(null);
		this.productSpecDAO.updateByPrimaryKeySelective(productSpec);
		
	}

	public List<ProductSpec> selectProductSpecByModel(ProductSpec productSpec) {
		return this.productSpecDAO.selectByModel(productSpec);
	}

}
