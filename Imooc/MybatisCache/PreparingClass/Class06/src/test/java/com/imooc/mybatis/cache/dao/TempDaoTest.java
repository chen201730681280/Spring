package com.imooc.mybatis.cache.dao;

import com.imooc.mybatis.cache.entity.TempEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class TempDaoTest {

    private Logger logger = Logger.getLogger(this.getClass());

    @Test
    public void testStatementId() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        TempEntity tempEntity1 = sqlSession1.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById1", 1);
        sqlSession1.close();
        logger.info(tempEntity1);
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        TempEntity tempEntity2 = sqlSession2.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById1", 1);
        sqlSession2.close();
        logger.info(tempEntity2);
    }

    @Test
    public void testParam() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        TempEntity tempEntity1 = sqlSession1.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById1", 1);
        sqlSession1.close();
        logger.info(tempEntity1);
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        TempEntity tempEntity2 = sqlSession2.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById1", 2);
        sqlSession2.close();
        logger.info(tempEntity2);
    }

    @Test
    public void testPage() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        List<TempEntity> tempEntityList1 = sqlSession1.selectList("com.imooc.mybatis.cache.dao.TempDao.list", null, new RowBounds(0, 2));
        sqlSession1.close();
        logger.info(tempEntityList1);
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        List<TempEntity> tempEntityList2 = sqlSession2.selectList("com.imooc.mybatis.cache.dao.TempDao.list", null, new RowBounds(2, 2));
        sqlSession2.close();
        logger.info(tempEntityList2);
    }

    @Test
    public void testSqlScript() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        Map<String, Integer> param1 = new HashMap<String, Integer>();
        param1.put("type", 1);
        param1.put("id", 1);
        TempEntity tempEntity1 = sqlSession1.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById3", param1);
        sqlSession1.close();
        logger.info(tempEntity1);
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        Map<String, Integer> param2 = new HashMap<String, Integer>();
        param2.put("type", 2);
        param2.put("id", 1);
        TempEntity tempEntity2 = sqlSession2.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById3", param2);
        logger.info(tempEntity2);
        sqlSession2.close();
    }

}