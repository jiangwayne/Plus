package com.plus.server.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.plus.server.common.util.BeanMapper;
import com.plus.server.common.vo.ProductSpecVo;
import com.plus.server.common.vo.ProductVo;
import com.plus.server.common.vo.resp.BaseResp;
import com.plus.server.common.vo.resp.ProductListResp;
import com.plus.server.common.vo.resp.ProductResp;
import com.plus.server.common.vo.resp.ProductSpecListResp;
import com.plus.server.model.Product;
import com.plus.server.model.ProductSpec;
import com.plus.server.service.CommentService;
import com.plus.server.service.ProductService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@RestController
@Api("产品")
@RequestMapping(value = "plus/product")
public class ProductController extends BaseController{
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private ProductService productService;
	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/listProduct", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询产品列表")
	public ProductListResp listProduct(
			@ApiParam(required = false, value = "类型（10-机票BB,11-机票LY,20-门票SE,21-门票SP）") @RequestParam(required = false) Integer type,
			@ApiParam(required = false, value = "产品名称") @RequestParam(required = false) String name,
			@ApiParam(required = false, value = "出发地点") @RequestParam(required = false) String addressStart,
			@ApiParam(required = false, value = "目的地") @RequestParam(required = false) String addressEnd,
			@ApiParam(required = false, value = "出行时间（yyyy-MM-dd）") @RequestParam(required = false) String travelDate,
			@ApiParam(required = false, value = "支付类型（1-直接支付，2-不直接支付（生成的是待确认订单））") @RequestParam(required = false) Integer payType,
			@RequestParam(required = false) @ApiParam(required = false, value = "当前页码") Integer page,
			@RequestParam(required = false) @ApiParam(required = false, value = "每页记录数") Integer pageSize) {
		log.info("查询产品---type={},name={}", type, name);
		ProductListResp r = new ProductListResp();
		Product pro = new Product();
		pro.setType(type);
		pro.setName(name);

		pro.setAddressStart(addressStart);
		pro.setAddressEnd(addressEnd);
		pro.setPayType(payType);
		pro.setValid(1);
		try {
			PageInfo<Product> pageInfo = productService.selectByModel(pro, page, pageSize);
			if(pageInfo != null && pageInfo.getList() != null){
				fillImgPathOfProductList(pageInfo.getList());
				List<ProductVo> productList = BeanMapper.mapList(pageInfo.getList(), ProductVo.class);
				for(ProductVo vo : productList){
					fillDateStr(vo);
				}
				r.setPages(pageInfo.getPages());
				r.setTotal(pageInfo.getTotal());
				r.setProductList(productList);
			}
		} catch (Exception e) {
			log.error("", e);
			r.setMsg(e.getMessage());
			return r;
		}
		r.setSuccess(true);
		return r;
	}
	@RequestMapping(value = "/listHomePageProduct", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询首页产品列表")
	public ProductListResp listHomePageProduct() {
		log.info("查询首页产品列表");
		ProductListResp r = new ProductListResp();
		Product pro = new Product();
		pro.setIsShowHome(1);
		pro.setValid(1);
		try {
			List<Product> pageInfo = productService.selectByModel(pro);
			if(pageInfo != null ){
				fillImgPathOfProductList(pageInfo);
				List<ProductVo> productList = BeanMapper.mapList(pageInfo , ProductVo.class);
				for(ProductVo vo : productList){
					fillDateStr(vo);
				}
				r.setProductList(productList);
			}
		} catch (Exception e) {
			log.error("", e);
			r.setMsg(e.getMessage());
			return r;
		}
		r.setSuccess(true);
		return r;
	}
	@RequestMapping(value = "/listSpecialPriceProduct", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询特价产品列表")
	public ProductListResp listSpecialPriceProduct() {
		log.info("查询特价产品列表");
		ProductListResp r = new ProductListResp();
		Product pro = new Product();
		pro.setType(21);//21-SP,表示特价
		pro.setValid(1);
		try {
			List<Product> pageInfo = productService.selectByModel(pro);
			if(pageInfo != null ){
				fillImgPathOfProductList(pageInfo);
				List<ProductVo> productList = BeanMapper.mapList(pageInfo , ProductVo.class);
				for(ProductVo vo : productList){
					fillDateStr(vo);
				}
				r.setProductList(productList);
			}
		} catch (Exception e) {
			log.error("", e);
			r.setMsg(e.getMessage());
			return r;
		}
		r.setSuccess(true);
		return r;
	}
	@RequestMapping(value = "/listProductSpec", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询产品规格列表")
	public ProductSpecListResp listProductSpec(
			@ApiParam(required = true, value = "产品id") @RequestParam(required = true) Long productId) {
		log.info("查询产品规格---productId={}", productId);
		ProductSpecListResp r = new ProductSpecListResp();
		ProductSpec productSpec = new ProductSpec();
		productSpec.setValid(1);
		productSpec.setProductId(productId);
		try {
			List<ProductSpec> list = productService.selectProductSpecByModel(productSpec);
			if(list != null && list.size() > 0){
				List<ProductSpecVo> productSpecList = BeanMapper.mapList(list, ProductSpecVo.class);
				for(ProductSpecVo vo : productSpecList){
					fillDateStr(vo);
				}
				r.setProductSpecList(productSpecList);
			}
		} catch (Exception e) {
			log.error("", e);
			r.setMsg(e.getMessage());
			return r;
		}
		r.setSuccess(true);
		return r;
	}
	
	@RequestMapping(value = "/queryStorageByDay", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询每日库存")
	public BaseResp queryStorageByDay(
			@ApiParam(required = true, value = "产品id") @RequestParam(required = true) Long productId,
			@ApiParam(required = true, value = "开始日期(yyyy-MM-dd)") @RequestParam(required = true) String startDateStr,
			@ApiParam(required = true, value = "开始日期(yyyy-MM-dd)") @RequestParam(required = true) String endDateStr) {
		log.info("查询每日库存---productId={}", productId);
		BaseResp r = new BaseResp();
		ProductSpec productSpec = new ProductSpec();
		productSpec.setValid(1);
		productSpec.setProductId(productId);
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if(startDateStr != null && !startDateStr.isEmpty()){
				productSpec.setStartDate_start(f.parse(startDateStr));
			}
			if(endDateStr != null && !endDateStr.isEmpty()){
				Date dd = f.parse(endDateStr);
				dd.setTime(dd.getTime() + 24 * 3600 * 1000);//查询条件没有等于
				productSpec.setStartDate_end(dd);
			}
		} catch (ParseException e1) {
			r.setMsg("日期格式错误");
			return r;
		}
		try {
			List<ProductSpec> list = productService.selectProductSpecByModel(productSpec);
			if(list != null && list.size() > 0){
				List<Map> retlist = Lists.newArrayList();
				for(ProductSpec vo : list){
					Map map = Maps.newHashMap();
					map.put("startDate", f.format(vo.getStartDate()));
					map.put("count", vo.getCountMax()-vo.getCountSale());
					retlist.add(map);
				}
				r.setMsg(JSON.toJSONString(retlist));
			}
		} catch (Exception e) {
			log.error("", e);
			r.setMsg(e.getMessage());
			return r;
		}
		r.setSuccess(true);
		return r;
	}
	
	@RequestMapping(value = "/queryById", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "产品明细查询")
	public ProductResp queryById(@ApiParam(required = true, value = "产品id") @RequestParam(required = true) Long productId) {
		log.info("产品查询---productId={}", productId);
		ProductResp r = new ProductResp();
		Product product = productService.selectById(productId);
		if(product != null){
			ProductVo vo = BeanMapper.copy(product, new ProductVo());
			fillDateStr(vo);
			r.setProduct(vo);
		}
		r.setSuccess(true);
		return r;
	}
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "删除产品")
	public BaseResp deleteProduct(@ApiParam(required = true, value = "产品id") @RequestParam(required = true) Long productId) {
		log.info("删除产品---productId={}", productId);
		BaseResp r = new BaseResp();
		Product product = new Product();
		product.setId(productId);
		product.setValid(-1);
		try {
			productService.update(product);
		} catch (Exception e) {
			log.error("", e);
			r.setMsg(e.getMessage());
			return r;
		}
		r.setSuccess(true);
		return r;
	}
	
	@RequestMapping(value = "/deleteProductSpec", method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "删除产品规格")
	public BaseResp deleteProductSpec(@ApiParam(required = true, value = "产品规格id") @RequestParam(required = true) Long productSpecId) {
		log.info("删除产品规格---productSpecId={}", productSpecId);
		BaseResp r = new BaseResp();
		ProductSpec productSpec = new ProductSpec();
		productSpec.setId(productSpecId);
		productSpec.setValid(-1);
		try {
			productService.updateProductSpec(productSpec);
		} catch (Exception e) {
			log.error("", e);
			r.setMsg(e.getMessage());
			return r;
		}
		r.setSuccess(true);
		return r;
	}
	
	private void fillDateStr(ProductVo vo){
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd Hh:mm:ss");
		if(vo.getGmtCreate() != null){
			vo.setGmtCreateStr(f.format(vo.getGmtCreate()));
		}
		if(vo.getGmtModify() != null){
			vo.setGmtModifyStr(f.format(vo.getGmtModify()));
		}
	}
	
	private void fillDateStr(ProductSpecVo vo){
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd Hh:mm:ss");
		SimpleDateFormat f2 = new SimpleDateFormat("yyyy-MM-dd");
		if(vo.getGmtCreate() != null){
			vo.setGmtCreateStr(f.format(vo.getGmtCreate()));
		}
		if(vo.getGmtModify() != null){
			vo.setGmtModifyStr(f.format(vo.getGmtModify()));
		}
		if(vo.getStartDate() != null){
			vo.setStartDateStr(f2.format(vo.getStartDate()));
		}
	}

}
