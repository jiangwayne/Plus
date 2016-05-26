package com.plus.server.dal;

import com.plus.server.model.User;
import org.apache.ibatis.datasource.DataSourceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * Created by jiangwulin on 16/5/22.
 */
@Repository
public class UserDao {
    public boolean insert(User user)
    {
        SqlSession session = MybatisHelper.getSqlSession();
        try
        {
            session.insert("com.plus.server.dal.user", user);
        }
        catch (DataSourceException ex)
        {
            //TODO:log
            return false;
        }
        finally {
            session.close();
        }

        return true;
    }
}
