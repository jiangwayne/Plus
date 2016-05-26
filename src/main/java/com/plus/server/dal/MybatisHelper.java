package com.plus.server.dal;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jiangwulin on 16/5/22.
 */
public class MybatisHelper {

    public static SqlSession getSqlSession()
    {
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }
        catch (IOException ex)
        {
            //TODO:log
        }

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory.openSession();
    }
}
