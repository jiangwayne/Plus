package com.plus.server.dal;

import com.plus.server.model.ProductSpec;

public interface ProductSpecDAO {
    int deleteByPrimaryKey(Long id);

    int insert(ProductSpec record);

    int insertSelective(ProductSpec record);

    ProductSpec selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductSpec record);

    int updateByPrimaryKey(ProductSpec record);
}