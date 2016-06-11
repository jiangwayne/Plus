package com.plus.server.dal;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.plus.server.model.User;

@Repository
public interface UserDAO {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);
    List<User> selectByUser(User record);

    User selectByUserName(String userName);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}