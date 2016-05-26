package com.plus.server.service;

import com.plus.server.dal.UserDao;
import com.plus.server.model.User;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * Created by jiangwulin on 16/5/22.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    UserDao userDao;

    public boolean register(String phone, String email, String password) {
        User user = new User(phone,email);
        user.setValid(1);
        String password_salt = generateSalt(5);
        String password_hash = getPasswordHash(password, password_salt);
        user.setPassword_salt(password_salt);
        user.setPassword_hash(password_hash);

        return userDao.insert(user);
    }

    public boolean login(User user) {
        return false;
    }



    private static String generateSalt(int size)
    {
        byte[] saltBytes = new byte[size];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(saltBytes);

        return Base64.getEncoder().encodeToString(saltBytes);
    }

    private static String getPasswordHash(String password, String salt)
    {
        String strResult = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update((password + salt).getBytes());
            byte[] byteBuffer = messageDigest.digest();
            StringBuffer strHexString = new StringBuffer();

            for (int i = 0; i < byteBuffer.length; i++)
            {
                String hex = Integer.toHexString(0xff & byteBuffer[i]);
                if (hex.length() == 1)
                {
                    strHexString.append('0');
                }
                strHexString.append(hex);
            }

            strResult = strHexString.toString();

        }
        catch (NoSuchAlgorithmException ex)
        {
            //TODO:log
        }
        return strResult.substring(0, 66);
    }
}
