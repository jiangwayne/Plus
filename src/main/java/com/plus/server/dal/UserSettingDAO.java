package com.plus.server.dal;

import com.plus.server.model.UserSetting;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSettingDAO {
    int deleteByPrimaryKey(Long id);

    int insert(UserSetting record);

    int insertSelective(UserSetting record);

    UserSetting selectByPrimaryKey(Long id);

    UserSetting selectByUserId(Long id);

    int updateByPrimaryKeySelective(UserSetting record);

    int updateByPrimaryKey(UserSetting record);
}