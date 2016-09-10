package com.plus.server.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.plus.server.common.PageDefault;
import com.plus.server.dal.PicLibDAO;
import com.plus.server.model.PicLib;
import com.plus.server.model.Product;
@Service
public class PicLibService {
	private static final Logger log = LoggerFactory.getLogger(PicLibService.class);
	@Autowired
	private PicLibDAO picLibDAO;

	
	public List<PicLib> selectByModel(PicLib pl) {
		log.info("图标查询，pl={} ", JSON.toJSONString(pl) );
		List<PicLib> list = picLibDAO.selectByModel(pl);
		return list;
	}

}
