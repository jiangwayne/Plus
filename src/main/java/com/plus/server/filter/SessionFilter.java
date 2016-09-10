package com.plus.server.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(SessionFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	private static final String[] openUrlArr = new String[] { "login", "getValidateCode", "getEmailValidateCode",
			"register", "ftl/","static/","file/","/swagger"};

	private boolean isOpenUrl(String url) {
		for (String openUrl : openUrlArr) {
			if (url.indexOf(openUrl) >= 0) {
				return true;
			}
		}
		return false;
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String url = httpRequest.getRequestURL().toString();
		if (!isOpenUrl(url)) {// 如果不是openUrl，则需要校验登录状态
			if (!url.matches("^.*/login.*$") && url.matches("^.*/plus.*$")) {
				if (httpRequest.getSession().getAttribute("user") == null) {
//					httpResponse.setStatus(401);
				}
			}
		}
		if (httpResponse.getStatus() == 200) {
			chain.doFilter(httpRequest, httpResponse);
		}
	}

	@Override
	public void destroy() {
	}

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}
