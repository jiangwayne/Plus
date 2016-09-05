package com.plus.server.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.plus.server.common.vo.resp.BaseResp;
import com.plus.server.service.FileService;
import com.wordnik.swagger.annotations.Api;

@Controller
@Api("示例")
@RequestMapping(value = "/plus/file")
public class FileController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(FileController.class);
	@Autowired
	private FileService fileService;

	/**
	 * 上传文件
	 * 
	 * @param fileName
	 *            文件参数名称
	 * @return
	 */
	@RequestMapping(value = "/uploadFile")
	@ResponseBody
	public BaseResp uploadFile(@RequestParam(value = "fileName", required = false) String fileName,
			@RequestParam MultipartFile[] btnFile,
			HttpServletRequest httpServletRequest) {
		System.out.println("上传文件");
		BaseResp ret = new BaseResp();
		if (httpServletRequest instanceof MultipartRequest) {

			MultipartRequest multipartRequest = (MultipartRequest) httpServletRequest;
			MultipartFile multipartFile = multipartRequest.getFile(fileName);
			log.info("上传文件,上传的文件内容为:【" + fileName + "】");
			try {
				String filePath=fileService.uploadFileStream(multipartFile.getOriginalFilename(), multipartFile.getBytes());
				ret.setMsg(filePath);
			} catch (Exception e) {
				log.error("上传文件出异常",e);
				ret.setMsg("上传失败，" + e.getMessage());
				return ret;
			}

		}
		ret.setSuccess(true);
		return ret;
	}
	
	/**
	 * 下载文件
	 * 
	 * @param fileName
	 *            文件参数名称
	 * @return
	 */
	@RequestMapping(value = "/downloadFile")
	public void downloadFile(@RequestParam(value = "fileName") String fileName) {
		if(fileName == null || "".equals(fileName)){
			return ;
		}
		try {
			byte[] b = fileService.downloadFileStream(fileName);
			httpResponse.getOutputStream().write(b);
			httpResponse.setContentType("image/*");
		} catch (Exception e) {
			log.error("", e);
		}
	}
	
}
