package com.plus.server.dal;

import java.util.List;

import com.plus.server.model.Config;

import org.springframework.stereotype.Repository;

@Repository
public interface ConfigDAO {
    int deleteByPrimaryKey(Long id);

    int insert(Config record);

    int insertSelective(Config record);

    Config selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Config record);

    int updateByPrimaryKey(Config record);

	List<Config> findAll();
}