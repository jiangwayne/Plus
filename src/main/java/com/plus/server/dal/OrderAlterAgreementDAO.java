package com.plus.server.dal;

import com.plus.server.model.OrderAlterAgreement;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderAlterAgreementDAO {
    int deleteByPrimaryKey(Long id);

    int insert(OrderAlterAgreement record);

    int insertSelective(OrderAlterAgreement record);

    OrderAlterAgreement selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderAlterAgreement record);

    int updateByPrimaryKey(OrderAlterAgreement record);
}