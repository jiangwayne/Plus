package com.plus.server.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileService {
	private static final Logger log = LoggerFactory.getLogger(FileService.class);

	//@Value("#{configProperties['file_path']}")
	private String filePath = "d:/plustest";

	/**
	 * 上传文件
	 * @param originalFilename
	 * @param bytes
	 */
	public String uploadFileStream(String originalFilename, byte[] bytes) throws Exception{
		SimpleDateFormat f = new SimpleDateFormat("yyMMddHHmmss");
		Date now = new Date();
		int r = new Random().nextInt(999);
		String thisFilePath = f.format(now)+"-"+r+"-"+originalFilename;
		File file = new File(filePath+File.separator+thisFilePath);
		if(file.exists()){
			throw new Exception("文件名重复");
		}
		FileOutputStream fo = null;
		try {
			fo = new FileOutputStream(file);
			fo.write(bytes);
		} finally {
			if(fo != null)
				try {
					fo.close();
				} catch (Exception e) {
					log.info("文件输出流关闭失败");
				}
		}
		return thisFilePath;
	}
	
	/**
	 * 读取文件
	 * @param originalFilename
	 * @param bytes
	 */
	public byte[] downloadFileStream(String fileName) throws Exception{
		File file = new File(filePath+File.separator+fileName);
		if(!file.exists()){
			throw new Exception("文件不存在");
		}
		byte[] b = new byte[Long.valueOf(file.length()).intValue()];
		FileInputStream fo = null;
		try {
			fo = new FileInputStream(file);
			fo.read(b);
		} finally {
			if(fo != null)
				try {
					fo.close();
				} catch (Exception e) {
					log.info("文件输入流关闭失败");
				}
		}
		return b;
	}

}
