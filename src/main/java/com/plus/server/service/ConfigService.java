package com.plus.server.service;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.plus.server.common.SysConfig;
import com.plus.server.dal.ConfigDAO;
import com.plus.server.model.Config;

@Service
public class ConfigService {
	private static final Logger log = LoggerFactory.getLogger(SysConfig.class);
	@Autowired
	private ConfigDAO configDAO;
	
	@PostConstruct
	public void initConfig(){
		log.info("初始化配置...");
		List<Config> list = configDAO.findAll();
		if(list != null && list.size() > 0){
			for(Config c : list){
				try {
					initEach(c);
				} catch (Exception e) {
					log.error("其中一个参数初始化失败，参数：{}",JSON.toJSONString(c),e);
					log.info("其中一个参数初始化失败，参数：{}",JSON.toJSONString(c));
				}
			}
		}
		log.info("初始化配置完成！");
	}
	
	private void initEach(Config c){
		String code = c.getCode();
		String value = c.getValue();
		if("max_wait_pay_minutes".equals(code)){
			log.info("初始化max_wait_pay_minutes");
			SysConfig.max_wait_pay_minutes = Integer.parseInt(value);
		}else if("product_max_buy_count".equals(code)){
			log.info("初始化product_max_buy_count");
			SysConfig.product_max_buy_count = Integer.parseInt(value);
		}else if("max_no_pay_order_count".equals(code)){
			log.info("初始化max_no_pay_order_count");
			SysConfig.max_no_pay_order_count = Integer.parseInt(value);
		}else if("rmb_doller_rate".equals(code)){
			log.info("初始化rmb_doller_rate");
			SysConfig.rmb_doller_rate = new BigDecimal(value);
		}else if("up_scale_a".equals(code)){
			log.info("初始化up_scale_a");
			SysConfig.up_scale_a = Integer.parseInt(value);
		}else if("up_scale_b".equals(code)){
			log.info("初始化up_scale_b");
			SysConfig.up_scale_b = Integer.parseInt(value);
		}else{
			log.info("未识别的code："+code);
		}
	}
}
