package com.plus.server.dal;

import com.plus.server.model.TransactionDetail;
import java.util.List;

public interface TransactionDetailDAO {
    int deleteByPrimaryKey(Long id);

    int insert(TransactionDetail record);

    int insertSelective(TransactionDetail record);

    TransactionDetail selectByPrimaryKey(Long id);

    List<TransactionDetail> selectByModelLike(TransactionDetail record);

    List<TransactionDetail> selectByModel(TransactionDetail record);

    int updateByPrimaryKeySelective(TransactionDetail record);

    int updateByPrimaryKey(TransactionDetail record);
}