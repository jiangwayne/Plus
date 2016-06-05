package com.plus.server.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MsgUtil {
	private static final Logger log = LoggerFactory.getLogger(MsgUtil.class);

	public static void sendMsg(String phone, String msg) {
		log.info("发送短信，phone={},msg={}", phone, msg);
		// TODO 发送短信接口
	}
}
