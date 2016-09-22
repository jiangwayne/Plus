package com.plus.server.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.plus.server.common.PageDefault;
import com.plus.server.common.util.BeanMapper;
import com.plus.server.common.vo.OrderVo;
import com.plus.server.common.vo.ProductSpecVo;
import com.plus.server.common.vo.ProductVo;
import com.plus.server.common.vo.resp.FtlCommonResp;
import com.plus.server.common.vo.resp.OrderListResp;
import com.plus.server.common.vo.resp.OrderResp;
import com.plus.server.model.Order;
import com.plus.server.model.Product;
import com.plus.server.model.ProductSpec;
import com.plus.server.service.CommentService;
import com.plus.server.service.OrderService;
import com.plus.server.service.ProductService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@RestController
@Api("订单")
@RequestMapping(value = "plus/order")
public class OrderController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "创建订单")
	public FtlCommonResp createOrder(
			@ApiParam(required = true, value = "产品规格id") @RequestParam(required = true) Long productSpecId,
			@ApiParam(required = true, value = "数量") @RequestParam(required = true) Integer count,
			@ApiParam(required = false, value = "乘机人id(多个乘机人时用逗号分隔)") @RequestParam(required = false) String boardingIds) {
		log.info("创建订单---productSpecId={},count={}", productSpecId, count);
		FtlCommonResp r = new FtlCommonResp();
		Long userId = this.getCurrentUser().getId();
		try {
			Order o = orderService.createOrder(userId, productSpecId, count, boardingIds);
			OrderVo vo = BeanMapper.copy(o, new OrderVo());
			fillDateStr(vo);
			fillProductAndProductSpec(vo);
			r.setData(vo);
		} catch (Exception e) {
			log.error("", e);
			r.setMsg(e.getMessage());
			return r;
		}
		r.setSuccess(true);
		return r;
	}
	
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "支付")
	public FtlCommonResp pay(
			@ApiParam(required = true, value = "订单ID(order对象的id字段)") @RequestParam(required = true) Long orderId,
			@ApiParam(required = true, value = "金额") @RequestParam(required = true) Integer money,
			@ApiParam(required = true, value = "渠道（1-支付宝，2-微信支付，3-ApplePay）") @RequestParam(required = true) Integer type,
			@ApiParam(required = true, value = "订单编号（支付时，订单编号若由我们生成则填我们的订单编号（orderNo），若由对方生成则填对方的订单编号）") @RequestParam(required = true) String partnerOrderNo) {
		log.info("支付---orderId={},money={},type={},partnerOrderNo={}", orderId, money, type, partnerOrderNo);
		FtlCommonResp r = new FtlCommonResp();
		Long userId = this.getCurrentUser().getId();
		try {
			orderService.pay(userId,orderId,money, type, partnerOrderNo,getRequestIp());
		} catch (Exception e) {
			log.error("", e);
			r.setMsg(e.getMessage());
			return r;
		}
		r.setSuccess(true);
		return r;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "订单查询")
	public OrderListResp list(@ApiParam(required = false, value = "产品id") @RequestParam(required = false) Long productId,
			@ApiParam(required = false, value = "状态（20-待支付，31-即将出行，不传时查全部）") @RequestParam(required = false) Integer status,
			@RequestParam(required = false) @ApiParam(required = false, value = "当前页码") Integer page,
			@RequestParam(required = false) @ApiParam(required = false, value = "每页记录数") Integer pageSize) {
		log.info("订单查询---productId={},status={}", productId, status);
		OrderListResp r = new OrderListResp();
		Long userId = this.getCurrentUser().getId();
		if (page == null || page <= 0) {
			page = PageDefault.PAGE_NUM_DEFAULT;
		}
		if (pageSize == null || pageSize <= 0) {
			pageSize = PageDefault.PAGE_SIZE_DEFAULT;
		}
		Order param = new Order();
		param.setUserId(userId);
		param.setProductId(productId);
		param.setStatus(status);
		if(status != null && status == 31){
			param.setStatus(30);
			param.setNotYetTravel(true);
		}
		param.setValid(1);
		PageInfo<Order> pageInfo = orderService.selectByModel(param,page,pageSize);
		List<OrderVo> orderList = BeanMapper.mapList(pageInfo.getList(), OrderVo.class);
		for(OrderVo vo : orderList){
			fillDateStr(vo);
			fillProductAndProductSpec(vo);
		}
		r.setPages(pageInfo.getPages());
		r.setTotal(pageInfo.getTotal());
		r.setOrderList(orderList);
		r.setSuccess(true);
		return r;
	}
	
	private void fillProductAndProductSpec(OrderVo vo){
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd Hh:mm:ss");
		SimpleDateFormat f2 = new SimpleDateFormat("yyyy-MM-dd");
		Product product = productService.selectById(vo.getProductId());
		ProductSpec productSpec = productService.selectProductSpecById(vo.getProductSpecId());
		if(product != null){
			ProductVo pv = BeanMapper.copy(product, new ProductVo());
			vo.setProduct(pv);
		}
		if(productSpec != null){
			ProductSpecVo pv = BeanMapper.copy(productSpec, new ProductSpecVo());
			vo.setProductSpec(pv);
			if(pv.getStartDate() != null){
				pv.setStartDateStr(f2.format(pv.getStartDate()));
			}
		}
	}
	private void fillDateStr(OrderVo vo){
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd Hh:mm:ss");
		if(vo.getGmtCreate() != null){
			vo.setGmtCreateStr(f.format(vo.getGmtCreate()));
		}
	}
	@RequestMapping(value = "/queryById", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "订单查询")
	public OrderResp queryById(@ApiParam(required = true, value = "订单id") @RequestParam(required = true) Long orderId) {
		log.info("订单查询---orderId={}", orderId);
		OrderResp r = new OrderResp();
		Order order = orderService.selectById(orderId);
		if(order != null){
			OrderVo vo = BeanMapper.copy(order, new OrderVo());
			fillDateStr(vo);
			r.setOrder(vo);
		}
		r.setSuccess(true);
		return r;
	}


	
}
