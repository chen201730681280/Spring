package com.imooc.mybatis.cache.dao;

import com.imooc.mybatis.cache.entity.TempEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TempDaoTest {

    private Logger logger = Logger.getLogger(this.getClass());

    @Test
    public void getById() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TempEntity tempEntity1 = sqlSession.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById", 1);
        logger.info(tempEntity1);
        TempEntity tempEntity2 = sqlSession.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById", 1);
        logger.info(tempEntity2);
        sqlSession.close();
    }

}