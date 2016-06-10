package com.plus.server.dal;

import java.util.List;

import com.plus.server.model.Product;

public interface ProductDAO {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    /**
     * 增加评论数
     */
    int updateCommentCountByPrimaryKey(Product record);

	List<Product> selectByModel(Product product);
}