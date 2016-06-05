package com.plus.server.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plus.server.dal.OrderDAO;
import com.plus.server.dal.ProductDAO;
import com.plus.server.dal.ProductSpecDAO;
import com.plus.server.model.Order;
import com.plus.server.model.Product;
import com.plus.server.model.ProductSpec;

/**
 * Created by jiangwulin on 16/5/22.
 */
@Service
public class OrderService {
	private static final Logger log = LoggerFactory.getLogger(OrderService.class);
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private ProductSpecDAO productSpecDAO;
	@Autowired
	private ProductDAO productDAO;

	/**
	 * 创建订单
	 * 
	 * @param userId
	 * @param productSpecId
	 * @param count
	 */
	public void createOrder(Long userId, Long productSpecId, Integer count) throws Exception {
		if (userId == null || productSpecId == null || count == null) {
			throw new Exception("参数不能为空");
		}
		ProductSpec ps = productSpecDAO.selectByPrimaryKey(productSpecId);
		if(ps == null){
			throw new Exception("产品规格错误");
		}
		Product pro = productDAO.selectByPrimaryKey(ps.getProductId());
		Order order = new Order();
		order.setCount(count);
		order.setGmtCreate(new Date());
		order.setPriceEach(ps.getPriceCurrent());
		order.setPriceTotal(count * ps.getPriceCurrent());
		order.setProductId(ps.getProductId());
		order.setProductSpecId(ps.getId());
		if(pro.getPayType() == 1){//支付类型（1-直接支付，2-不直接支付（生成的是待确认订单））
			order.setStatus(20);//状态（10-待确认，20-待付款，30-待评价，40-已评价，50-已取消）
		}else if(pro.getPayType() == 2){
			order.setStatus(10);
		}else{
			throw new Exception("产品支付类型错误");
		}
		order.setUserId(userId);
		order.setValid(1);
		this.orderDAO.insert(order);
	}

}
