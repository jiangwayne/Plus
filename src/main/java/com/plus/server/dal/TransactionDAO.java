package com.plus.server.dal;

import com.plus.server.model.Transaction;
import java.util.List;

public interface TransactionDAO {
    int deleteByPrimaryKey(Long id);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(Long id);

    List<Transaction> selectByModelLike(Transaction record);

    List<Transaction> selectByModel(Transaction record);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);
}