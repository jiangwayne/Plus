package com.plus.server.dal;

import com.plus.server.model.UserBoarding;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jiangwulin on 16/6/5.
 */
@Repository
public interface UserBoardingDAO {
    int deleteByPrimaryKey(Long id);

    int insert(UserBoarding record);

    int insertSelective(UserBoarding record);

    UserBoarding selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserBoarding record);

    int updateByPrimaryKey(UserBoarding record);

    List<UserBoarding> selectByUserId(Long userId);
}
