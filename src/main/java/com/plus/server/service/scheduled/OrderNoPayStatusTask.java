package com.plus.server.service.scheduled;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.plus.server.common.SysConfig;
import com.plus.server.dal.OrderDAO;
import com.plus.server.model.Order;

@Component
public class OrderNoPayStatusTask {
	private static final Logger log = LoggerFactory.getLogger(OrderNoPayStatusTask.class);
	@Autowired
	private OrderDAO orderDAO;

	/**
	 * 每分钟检查未支付订单，若超过最大未支付等待时间，则将订单状态设置为取消
	 */
	@Scheduled(cron = "0 * * * * ? ")
	@Transactional(rollbackFor = Exception.class)
	public void setStatus2CacelOfNoPayOrder() {
		log.info("未支付订单超时任务启动...");
		Order orderParam = new Order();
		orderParam.setValid(1);
		orderParam.setStatus(20);//状态（10-待确认，20-待付款，30-待评价，40-已评价，50-已取消）
		List<Order> existNoPayOrderList = this.orderDAO.selectByModel(orderParam);
		if(existNoPayOrderList != null && existNoPayOrderList.size() > 0){
			log.info("超时时间为："+SysConfig.max_wait_pay_minutes+"分钟");
			long timeoutMs = SysConfig.max_wait_pay_minutes * 60 * 1000;
			long nowMs = new Date().getTime();
			for(Order order : existNoPayOrderList){
				try {
					checkEachOrder(order, timeoutMs, nowMs);
				} catch (Exception e) {
					log.error("订单处理异常，order={}", JSON.toJSONString(order), e);
					log.info("订单处理异常，order={}", JSON.toJSONString(order));
				}
				
			}
		}
		log.info("未支付订单超时任务执行完毕！");
	}
	
	private void checkEachOrder(Order order, long timeoutMs,long nowMs){
		if(order.getGmtCreate() != null){
			if(order.getGmtCreate().getTime() + timeoutMs < nowMs){
				log.info("订单【id="+order.getId()+"】超时,重复检查开始...");
				Order orderForUpdate = orderDAO.selectByPrimaryKeyForUpdate(order.getId());
				if(orderForUpdate != null && orderForUpdate.getStatus() == 20 
						&& orderForUpdate.getGmtCreate() != null
						&& orderForUpdate.getGmtCreate().getTime() + timeoutMs < nowMs){
					log.info("订单【id="+order.getId()+"】重复检查一遍仍超时，将状态设置为取消（status=50）");
					Order updateOrderParam = new Order();
					updateOrderParam.setId(order.getId());
					updateOrderParam.setStatus(50);
					orderDAO.updateByPrimaryKeySelective(updateOrderParam);
				}
			}
		}else{
			log.warn("有订单创建时间为null，id={}",order.getId());
			log.info("有订单创建时间为null，id={}",order.getId());
		}
	}
}
