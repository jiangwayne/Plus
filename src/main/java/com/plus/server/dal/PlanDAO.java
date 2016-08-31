package com.plus.server.dal;

import com.plus.server.model.Plan;
import java.util.List;

public interface PlanDAO {
    int deleteByPrimaryKey(Long id);

    int insert(Plan record);

    int insertSelective(Plan record);

    Plan selectByPrimaryKey(Long id);

    List<Plan> selectByModelLike(Plan record);

    List<Plan> selectByModel(Plan record);

    int updateByPrimaryKeySelective(Plan record);

    int updateByPrimaryKey(Plan record);
}