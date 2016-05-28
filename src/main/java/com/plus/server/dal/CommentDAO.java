package com.plus.server.dal;

import com.plus.server.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDAO {
    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}