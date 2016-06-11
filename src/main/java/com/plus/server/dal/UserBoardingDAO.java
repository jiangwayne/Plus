package com.plus.server.dal;

import com.plus.server.model.UserBoarding;
import com.sun.tools.javac.util.List;
import org.springframework.stereotype.Repository;

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
