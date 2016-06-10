package com.plus.server.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

import com.plus.server.dal.MessageDAO;
import com.plus.server.dal.WishDAO;
import com.plus.server.model.UserSetting;
import com.plus.server.model.Wish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plus.server.dal.UserDAO;
import com.plus.server.dal.UserSettingDAO;
import com.plus.server.model.User;
import com.plus.server.model.Message;

/**
 * Created by jiangwulin on 16/5/22.
 */
@Service
public class UserService {
	@Autowired
	private UserDAO userDao;

	@Autowired
	private UserSettingDAO userSettingDao;

	@Autowired
	private WishDAO wishDAO;

	@Autowired
	private MessageDAO messageDAO;

	public void register(String phone, String email, String password) {
		User user = new User();
		user.setValid(1);
		String password_salt = generateSalt(5);
		String password_hash = getPasswordHash(password, password_salt);
		user.setPasswordSalt(password_salt);
		user.setPasswordHash(password_hash);

		userDao.insert(user);
	}

	public boolean login(String loginString, String password) {
		User user = userDao.selectByUserName(loginString);
		if(user != null) {
			String password_salt = user.getPasswordSalt();
			String password_hash = getPasswordHash(password, password_salt);
			if(password_hash == user.getPasswordHash()){
				return true;
			}
		}
		return false;
	}

	public boolean modifyPassword(String userName, String password){
		User user = userDao.selectByUserName(userName);
		if(user != null){
			String password_salt = generateSalt(5);
			String password_hash = getPasswordHash(password, password_salt);
			user.setPasswordSalt(password_salt);
			user.setPasswordHash(password_hash);
			userDao.updateByPrimaryKey(user);
			return true;
		}
		return false;
	}


	public User getUser(Long userId){
		return userDao.selectByPrimaryKey(userId);
	}

	public void updateUser(User user){
		userDao.updateByPrimaryKeySelective(user);
	}

	public User getUserByName(String userName){
		return userDao.selectByUserName(userName);
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

	public UserSetting getUserSetting(Long userId)
	{
		UserSetting userSetting = userSettingDao.selectByUserId(userId);
		return userSetting;
	}

	public void setUserSetting(UserSetting userSetting) {
		userSettingDao.updateByPrimaryKeySelective(userSetting);
	}



	public List<Message> getUserMessage(Long userId)
	{
		List<Message> message = messageDAO.selectByUserId(userId);
		return message;
	}

	public List<Wish> getUserWish(Long userId)
	{
		List<Wish> wishList = wishDAO.selectByUserId(userId);
		return wishList;
	}

	public void commitUserWish(Wish wish)
	{
		wishDAO.insert(wish);
	}

}
