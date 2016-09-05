package com.plus.server.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import com.plus.server.model.Product;
import com.plus.server.model.User;

@RestController
public class BaseController {

	private static final Logger log = LoggerFactory.getLogger(BaseController.class);
	@Value("#{configProperties['base_addr']}")
	private String base_addr;//http://127.0.0.1:8080
	
	@Autowired
	protected HttpServletRequest httpRequest;
	@Autowired
	protected HttpSession httpSession;
	@Autowired
	protected HttpServletResponse httpResponse;

	public User getCurrentUser() {
		User u = (User) httpRequest.getSession().getAttribute("user");
		return u;
	}

	public void fillImgPathOfProductList(List<Product> productList){
		if(productList != null && productList.size()> 0){
			for(Product product : productList){
				fillImgPathOfProduct(product);
			}
		}
	}
	public void fillImgPathOfProduct(Product product){
		if (product == null){
			return;
		}
		if(product.getFengmianPic() != null){
			product.setFengmianPic(addUrlPre(product.getFengmianPic()));
		}
		if(product.getPindaoPic() != null){
			product.setPindaoPic(addUrlPre(product.getPindaoPic()));
		}
		if(product.getLunboPic() != null){
			product.setLunboPic(addUrlPre(product.getLunboPic()));
		}
	}
	//"http://127.0.0.1:8080/plus/file/downloadFile?fileName=
	private String addUrlPre(String url){
		if(url.indexOf(",")>=0){
			String[] arr = url.split(",");
			String newUrl = "";
			for (int i = 0; i < arr.length; i++) {
				newUrl += this.base_addr + "/plus/file/downloadFile?fileName=" + arr[i];
				if(i < arr.length - 1){
					newUrl += ",";
				}
			}
			return newUrl;
		}else{
			return this.base_addr + "/plus/file/downloadFile?fileName=" + url;
		}
	}
}
