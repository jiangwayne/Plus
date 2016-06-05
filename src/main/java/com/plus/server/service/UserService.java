package com.plus.server.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import com.plus.server.common.vo.MessageVo;
import com.plus.server.common.vo.UserSettingVo;
import com.plus.server.common.vo.WishVo;
import com.plus.server.model.Wish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plus.server.dal.UserDAO;
import com.plus.server.model.User;

/**
 * Created by jiangwulin on 16/5/22.
 */
@Service
public class UserService {
	@Autowired
	private UserDAO userDao;

	public boolean register(String phone, String email, String password, String validateCode) {
		if(!validateCode(validateCode))
		{
			return false;
		}
		User user = new User();
		user.setValid(1);
		String password_salt = generateSalt(5);
		String password_hash = getPasswordHash(password, password_salt);
		user.setPasswordSalt(password_salt);
		user.setPasswordHash(password_hash);

		//TODO:insert
		//userDao.insert(user);
		return true;
	}

	public boolean login(String loginString, String password) {

		//TODO:手机或邮箱登录判断
		return false;
	}

	private static String generateSalt(int size) {
		byte[] saltBytes = new byte[size];
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.nextBytes(saltBytes);

		return Base64.getEncoder().encodeToString(saltBytes);
	}

	private static String getPasswordHash(String password, String salt) {
		String strResult = "";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
			messageDigest.update((password + salt).getBytes());
			byte[] byteBuffer = messageDigest.digest();
			StringBuffer strHexString = new StringBuffer();

			for (int i = 0; i < byteBuffer.length; i++) {
				String hex = Integer.toHexString(0xff & byteBuffer[i]);
				if (hex.length() == 1) {
					strHexString.append('0');
				}
				strHexString.append(hex);
			}

			strResult = strHexString.toString();

		} catch (NoSuchAlgorithmException ex) {
			// TODO:log
		}
		return strResult.substring(0, 66);
	}

	private static boolean validateCode(String validateCode)
	{
		//TODO:手机短信验证
		return true;
	}

	public UserSettingVo getUserSetting(int userId)
	{
		//TODO:获取用户设置
		UserSettingVo userSettingVo = new UserSettingVo();
		return userSettingVo;
	}

	public boolean setUserSetting(UserSettingVo userSettingVo)
	{
		//TODO:更新用户设置
		return true;
	}

	public MessageVo getUserMessage(int userId)
	{
		//TODO:获取用户消息提醒
		MessageVo messageVo = new MessageVo();
		return messageVo;
	}

	public WishVo getUserWish(int userId)
	{
		//TODO:获取用户心愿单
		WishVo wishVo = new WishVo();
		return wishVo;
	}

	public boolean commitUserWish(WishVo wishVo)
	{
		//TODO:提交用户心愿单
		return true;
	}

	public boolean getValidateCode(String phone)
	{
		//TODO:调用短信通道接口给用phone发送验证码
		return true;
	}

}
