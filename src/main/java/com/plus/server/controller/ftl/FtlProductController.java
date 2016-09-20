package com.plus.server.controller.ftl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.plus.server.common.util.BeanMapper;
import com.plus.server.common.vo.ProductSpecVo;
import com.plus.server.common.vo.ProductVo;
import com.plus.server.common.vo.resp.BaseResp;
import com.plus.server.common.vo.resp.FtlCommonResp;
import com.plus.server.common.vo.resp.ProductResp;
import com.plus.server.controller.BaseController;
import com.plus.server.controller.LoginController;
import com.plus.server.model.Airport;
import com.plus.server.model.City;
import com.plus.server.model.Country;
import com.plus.server.model.PicLib;
import com.plus.server.model.Product;
import com.plus.server.model.ProductSpec;
import com.plus.server.service.AreaService;
import com.plus.server.service.PicLibService;
import com.plus.server.service.ProductService;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "ftl/product")
public class FtlProductController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(FtlProductController.class);

    @Autowired
    private ProductService productService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private PicLibService picLibService;

    @RequestMapping(value = "/list")
    public ModelAndView list(Model model, Integer type,Integer page, Integer pageSize) {
    	System.out.println("ffff");
    	model.addAttribute("type", type);
		Product pro = new Product();
		pro.setType(type);
		pro.setValid(1);
		try {
			PageInfo<Product> pageInfo = productService.selectByModel(pro, page, pageSize);
			if(pageInfo != null && pageInfo.getList() != null){
				List<ProductVo> productList = BeanMapper.mapList(pageInfo.getList(), ProductVo.class);
				for(ProductVo vo : productList){
					fillDateStr(vo);
				}
				model.addAttribute("list", productList);
			}
			model.addAttribute("pages",pageInfo.getPages());
			model.addAttribute("page",pageInfo.getPageNum());
			model.addAttribute("total",pageInfo.getTotal());
		} catch (Exception e) {
			log.error("", e);
		}
		
		return new ModelAndView("productList.ftl");
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
    @RequestMapping(value = "/queryById")
	public ModelAndView queryById(Model model, Long productId) {
		log.info("产品查询---productId={}", productId);
		model.addAttribute("productId",productId);
		ProductResp r = new ProductResp();
		if(productId != null){
			Product product = productService.selectById(productId);
			model.addAttribute("s",product);
		}
		List<PicLib> picLibList = Lists.newArrayList();//picLibService.selectByModel(pl);
		for(long i = 1; i <= 10; i++){
			PicLib pl = new PicLib();
			pl.setId(i);
			pl.setPicUrl("12_10_"+i+".png");
			picLibList.add(pl);
		}
		model.addAttribute("picLibList",picLibList);
		return new ModelAndView("productInfo.ftl");
	}
    
	@RequestMapping(value = "/loadCountry")
	@ResponseBody
	public FtlCommonResp loadCountry() {
		FtlCommonResp r = new FtlCommonResp();
		Country c = new Country();
		c.setValid(1);
		List<Country> list = areaService.selectCountryByModel(c);
		r.setSuccess(true);
		r.setData(list);
		return r;
	}
	@RequestMapping(value = "/loadCity")
	@ResponseBody
	public FtlCommonResp loadCity(Integer countryId) {
		FtlCommonResp r = new FtlCommonResp();
		City c = new City();
		c.setValid(1);
		c.setCountryId(countryId);
		List<City> list = areaService.selectCityByModel(c);
		r.setSuccess(true);
		r.setData(list);
		return r;
	}
	@RequestMapping(value = "/loadAirport")
	@ResponseBody
	public FtlCommonResp loadAirport(Integer cityId) {
		FtlCommonResp r = new FtlCommonResp();
		Airport c = new Airport();
		c.setValid(1);
		c.setCityId(cityId);
		List<Airport> list = areaService.selectAirportByModel(c);
		r.setSuccess(true);
		r.setData(list);
		return r;
	}
	
//	@RequestMapping(value = "/createProduct")
//	@ResponseBody
//	@ApiOperation(value = "创建产品")
//	public BaseResp createProduct(@RequestBody(required = true) ProductVo productVo) {
//		log.info("创建产品---productVo={}", JSON.toJSONString(productVo));
//		BaseResp r = new BaseResp();
//		if (productVo == null) {
//			r.setMsg("参数为空");
//			return r;
//		}
//		Product pro = BeanMapper.copy(productVo, new Product());
//		try {
//			productService.save(pro);
//		} catch (Exception e) {
//			log.error("", e);
//			r.setMsg(e.getMessage());
//			return r;
//		}
//		r.setSuccess(true);
//		return r;
//	}
	
//	@RequestMapping(value = "/createProductSpec")
//	@ResponseBody
//	@ApiOperation(value = "创建产品规格")
//	public BaseResp createProductSpec(@RequestBody(required = true) ProductSpecVo productSpecVo) {
//		log.info("创建产品规格---productSpecVo={}", JSON.toJSONString(productSpecVo));
//		BaseResp r = new BaseResp();
//		if (productSpecVo == null || productSpecVo.getProductId() == null) {
//			r.setMsg("参数为空");
//			return r;
//		}
//		if(productSpecVo.getStartDateStr() != null ){
//			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//			try {
//				productSpecVo.setStartDate(f.parse(productSpecVo.getStartDateStr()));
//			} catch (ParseException e) {
//				r.setMsg("开始日期格式错误（"+productSpecVo.getStartDateStr()+"）,正确的应该是yyyy-MM-dd");
//				return r;
//			}
//		}
//		ProductSpec productSpec = BeanMapper.copy(productSpecVo, new ProductSpec());
//		try {
//			productService.saveProductSpec(productSpec);
//		} catch (Exception e) {
//			log.error("", e);
//			r.setMsg(e.getMessage());
//			return r;
//		}
//		r.setSuccess(true);
//		return r;
//	}

	@RequestMapping(value = "/updateProduct")
	@ResponseBody
	@ApiOperation(value = "更新产品")
	public BaseResp updateProduct( Product pro) {
		log.info("更新产品---productVo={}", JSON.toJSONString(pro));
		BaseResp r = new BaseResp();
		if (pro == null) {
			r.setMsg("参数为空");
			return r;
		}
		try {
			if(pro.getId() == null){
//				Product pro = BeanMapper.copy(productVo, new Product());
				productService.save(pro);
			}else{
				productService.update(pro);
			}
			r.setMsg(pro.getId().toString());
		} catch (Exception e) {
			log.error("", e);
			r.setMsg(e.getMessage());
			return r;
		}
		r.setSuccess(true);
		return r;
	}
	
	@RequestMapping(value = "/toSpec")
	public ModelAndView toSpec(Model model, Long productId) {
		log.info("产品查询---productId={}", productId);
		model.addAttribute("productId",productId);
		if(productId != null){
			model.addAttribute("productId",productId);
			ProductSpec ps = new ProductSpec();
			ps.setValid(1);
			ps.setProductId(productId);
			List<ProductSpec> specList = productService.selectProductSpecByModel(ps);
			model.addAttribute("list",specList);
		}
		return new ModelAndView("productSpecList.ftl");
	}
	
	@RequestMapping(value = "/updateProductSpec")
	@ResponseBody
	@ApiOperation(value = "更新产品规格")
	public BaseResp updateProductSpec(@RequestParam(required = true) ProductSpecVo productSpecVo) {
		log.info("更新产品规格---productSpecVo={}", JSON.toJSONString(productSpecVo));
		BaseResp r = new BaseResp();
		if (productSpecVo == null) {
			r.setMsg("参数为空");
			return r;
		}
		if(productSpecVo.getStartDateStr() != null ){
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			try {
				productSpecVo.setStartDate(f.parse(productSpecVo.getStartDateStr()));
			} catch (ParseException e) {
				r.setMsg("开始日期格式错误（"+productSpecVo.getStartDateStr()+"）,正确的应该是yyyy-MM-dd");
				return r;
			}
		}
		ProductSpec productSpec = BeanMapper.copy(productSpecVo, new ProductSpec());
		try {
			if(productSpec.getId() == null){
//				Product pro = BeanMapper.copy(productVo, new Product());
				productService.saveProductSpec(productSpec);
			}else{
				productService.updateProductSpec(productSpec);
			}
			
		} catch (Exception e) {
			log.error("", e);
			r.setMsg(e.getMessage());
			return r;
		}
		r.setSuccess(true);
		return r;
	}
	
	@RequestMapping(value = "/deleteProductSpec")
	@ResponseBody
	@ApiOperation(value = "删除产品规格")
	public BaseResp deleteProductSpec(@RequestParam(required = true) Long specId) {
		log.info("删除产品规格---specId={}", specId);
		BaseResp r = new BaseResp();
		if (specId == null) {
			r.setMsg("参数为空");
			return r;
		}
		ProductSpec productSpec =  new ProductSpec();
		productSpec.setValid(-1);
		productSpec.setId(specId);
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
	@RequestMapping(value = "/querySpecById")
	@ResponseBody
	@ApiOperation(value = "查询产品规格")
	public FtlCommonResp querySpecById(@RequestParam(required = true) Long specId) {
		log.info("查询产品规格---specId={}", specId);
		FtlCommonResp r = new FtlCommonResp();
		if (specId == null) {
			r.setMsg("参数为空");
			return r;
		}
		try {
			ProductSpec productSpec =  productService.selectProductSpecById(specId);
			if(productSpec != null && productSpec.getStartDate() != null){
				ProductSpecVo vo = BeanMapper.copy(productSpec, new ProductSpecVo());
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
				vo.setStartDateStr(f.format(vo.getStartDate()));
			}
			r.setData(JSON.toJSONString(productSpec));
		} catch (Exception e) {
			log.error("", e);
			r.setMsg(e.getMessage());
			return r;
		}
		r.setSuccess(true);
		return r;
	}
    
    
}
