package com.plus.server.dal;

import com.plus.server.model.PicLib;

public interface PicLibDAO {
    int deleteByPrimaryKey(Long id);

    int insert(PicLib record);

    int insertSelective(PicLib record);

    PicLib selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PicLib record);

    int updateByPrimaryKey(PicLib record);
}