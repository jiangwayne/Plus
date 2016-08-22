package com.plus.server.dal;

import com.plus.server.model.Airport;
import java.util.List;

public interface AirportDAO {
    int deleteByPrimaryKey(Long id);

    int insert(Airport record);

    int insertSelective(Airport record);

    Airport selectByPrimaryKey(Long id);

    List<Airport> selectByModelLike(Airport record);

    List<Airport> selectByModel(Airport record);

    int updateByPrimaryKeySelective(Airport record);

    int updateByPrimaryKey(Airport record);
}