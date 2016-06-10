package com.plus.server.dal;

import com.plus.server.model.Message;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDAO {
    int deleteByPrimaryKey(Long id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    List<Message> selectByUserId(Long userId);
}