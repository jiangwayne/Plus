package com.plus.server.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import com.plus.server.dal.*;
import com.plus.server.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Autowired
	private UserBoardingDAO userBoardingDAO;

	public void register(String phone, String email, String password) {
		User user = new User();
		user.setValid(1);
		String password_salt = generateSalt(5);
		String password_hash = getPasswordHash(password, password_salt);
		user.setPasswordSalt(password_salt);
		user.setPasswordHash(password_hash);
		user.setPhone(phone);
		user.setEmail(email);

		user.setValid(1);
		user.setGmtCreate(new Date());
		user.setGmtModify(new Date());

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
			user.setGmtModify(new Date());
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
		return userSettingDao.selectByUserId(userId);
	}

	public void setUserSetting(UserSetting userSetting) {
		userSettingDao.updateByPrimaryKeySelective(userSetting);
	}



	public List<Message> getUserMessage(Long userId)
	{
		return messageDAO.selectByUserId(userId);
	}

	public List<Wish> getUserWish(Long userId)
	{
		return wishDAO.selectByUserId(userId);
	}

	public void commitUserWish(Wish wish)
	{
		wish.setValid(1);
		wish.setGmtCreate(new Date());
		wish.setGmtModify(new Date());

		wishDAO.insert(wish);
	}

	public void createUserBoarding(UserBoarding userBoarding)
	{
		userBoarding.setValid(1);
		userBoarding.setGmtCreate(new Date());
		userBoarding.setGmtModify(new Date());

		userBoardingDAO.insert(userBoarding);
	}

	public void deleteUserBoarding(UserBoarding userBoarding)
	{
		userBoarding.setValid(-1);
		userBoarding.setGmtModify(new Date());

		userBoardingDAO.updateByPrimaryKeySelective(userBoarding);
	}

	public List<UserBoarding> getUserBoarding(Long userId)
	{
		return userBoardingDAO.selectByUserId(userId);
	}

}
