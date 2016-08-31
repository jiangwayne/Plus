package com.plus.server.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.plus.server.common.PageDefault;
import com.plus.server.dal.ProductDAO;
import com.plus.server.dal.ProductSpecDAO;
import com.plus.server.model.Product;
import com.plus.server.model.ProductSpec;
@Service
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
		if(product == null || product.getName() == null){
			throw new Exception("参数不能为空");
		}
		Product param = new Product();
		param.setValid(1);
		param.setName(product.getName());
		List<Product> pList = productDAO.selectByModel(param);
		if(pList != null && pList.size() > 0){
			throw new Exception("产品名称重复");
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
		log.info("修改产品---product={}", JSON.toJSONString(product));
		if(product == null || product.getId() == null){
			throw new Exception("参数不能为空");
		}
		product.setGmtCreate(null);
		product.setGmtModify(new Date());
		this.productDAO.updateByPrimaryKeySelective(product);
	}
	
	public PageInfo<Product> selectByModel(Product product, Integer page, Integer pageSize) {
		log.info("产品查询，product={},page={},pageSize={}", JSON.toJSONString(product), page, pageSize);
		if (page == null || page <= 0) {
			page = PageDefault.PAGE_NUM_DEFAULT;
		}
		if (pageSize == null || pageSize <= 0) {
			pageSize = PageDefault.PAGE_SIZE_DEFAULT;
		}
		PageHelper.startPage(page, pageSize);
		List<Product> list = productDAO.selectByModel(product);
		PageInfo<Product> pageInfo = new PageInfo<Product>(list);
		return pageInfo;
	}
	public List<Product> selectByModel(Product product) {
		log.info("产品查询，product={} ", JSON.toJSONString(product) );
		List<Product> list = productDAO.selectByModel(product);
		return list;
	}
	public PageInfo<ProductSpec> selectProductSpecByModel(ProductSpec productSpec, Integer page, Integer pageSize) {
		log.info("产品规格查询，productSpec={},page={},pageSize={}", JSON.toJSONString(productSpec), page, pageSize);
		if (page == null || page <= 0) {
			page = PageDefault.PAGE_NUM_DEFAULT;
		}
		if (pageSize == null || pageSize <= 0) {
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
		if(productSpec == null || productSpec.getProductId() == null || productSpec.getName() == null){
			throw new Exception("参数不能为空");
		}
		Product product = productDAO.selectByPrimaryKey(productSpec.getProductId());
		if(product == null){
			throw new Exception("产品不存在");
		}
		ProductSpec param = new ProductSpec();
		param.setValid(1);
		param.setName(productSpec.getName());
		List<ProductSpec> specList = productSpecDAO.selectByModel(param);
		if(specList != null && specList.size() > 0){
			throw new Exception("产品规格名称重复");
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
