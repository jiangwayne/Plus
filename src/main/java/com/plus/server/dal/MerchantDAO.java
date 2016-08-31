package com.plus.server.dal;

import com.plus.server.model.Merchant;
import java.util.List;

public interface MerchantDAO {
    int deleteByPrimaryKey(Long id);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    Merchant selectByPrimaryKey(Long id);

    List<Merchant> selectByModelLike(Merchant record);

    List<Merchant> selectByModel(Merchant record);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKey(Merchant record);
}