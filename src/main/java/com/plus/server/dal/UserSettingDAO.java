package com.plus.server.dal;

import com.plus.server.model.UserSetting;

public interface UserSettingDAO {
    int deleteByPrimaryKey(Long id);

    int insert(UserSetting record);

    int insertSelective(UserSetting record);

    UserSetting selectByPrimaryKey(Long id);

    UserSetting selectByUserId(Long id);

    int updateByPrimaryKeySelective(UserSetting record);

    int updateByPrimaryKey(UserSetting record);
}