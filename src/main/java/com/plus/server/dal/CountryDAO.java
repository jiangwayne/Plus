package com.plus.server.dal;

import com.plus.server.model.Country;
import java.util.List;

public interface CountryDAO {
    int deleteByPrimaryKey(Long id);

    int insert(Country record);

    int insertSelective(Country record);

    Country selectByPrimaryKey(Long id);

    List<Country> selectByModelLike(Country record);

    List<Country> selectByModel(Country record);

    int updateByPrimaryKeySelective(Country record);

    int updateByPrimaryKey(Country record);
}