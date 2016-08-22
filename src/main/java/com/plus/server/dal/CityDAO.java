package com.plus.server.dal;

import com.plus.server.model.City;
import java.util.List;

public interface CityDAO {
    int deleteByPrimaryKey(Long id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Long id);

    List<City> selectByModelLike(City record);

    List<City> selectByModel(City record);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}