package com.plus.server.dal;

import java.util.List;

import com.plus.server.model.Order;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);
    Order selectByPrimaryKeyForUpdate(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

	List<Order> selectByModel(Order param);
}