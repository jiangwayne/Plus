package com.plus.server.dal;

import com.plus.server.model.Wish;

public interface WishDAO {
    int deleteByPrimaryKey(Long id);

    int insert(Wish record);

    int insertSelective(Wish record);

    Wish selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Wish record);

    int updateByPrimaryKey(Wish record);
}