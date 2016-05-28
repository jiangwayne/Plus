package com.plus.server.dal;

import com.plus.server.model.Message;

import org.springframework.stereotype.Repository;

@Repository
public interface MessageDAO {
    int deleteByPrimaryKey(Long id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}