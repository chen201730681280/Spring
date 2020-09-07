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
    public void testRedisEnabled() throws IOException, InterruptedException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        TempEntity tempEntity1 = sqlSession1.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById", 1);
        sqlSession1.commit();
        logger.info(tempEntity1);
        sqlSession1.close();

        Thread.sleep(6000);


        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        TempEntity tempEntity2 = sqlSession2.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById", 1);
        sqlSession2.commit();
        logger.info(tempEntity2);
        sqlSession2.close();
    }

}