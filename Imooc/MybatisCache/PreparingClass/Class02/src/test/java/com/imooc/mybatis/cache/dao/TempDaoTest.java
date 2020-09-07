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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TempDaoTest {

    private Logger logger = Logger.getLogger(this.getClass());

    @Test
    public void testStatementId() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TempEntity tempEntity1 = sqlSession.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById1", 1);
        logger.info(tempEntity1);
        TempEntity tempEntity2 = sqlSession.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById2", 1);
        logger.info(tempEntity2);
        sqlSession.close();
    }

    @Test
    public void testParam() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TempEntity tempEntity1 = sqlSession.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById1", 1);
        logger.info(tempEntity1);
        TempEntity tempEntity2 = sqlSession.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById1", 2);
        logger.info(tempEntity2);
        sqlSession.close();
    }

    @Test
    public void testPage() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<TempEntity> tempEntityList1 = sqlSession.selectList("com.imooc.mybatis.cache.dao.TempDao.list", null, new RowBounds(0, 2));
        logger.info(tempEntityList1);
        List<TempEntity> tempEntityList2 = sqlSession.selectList("com.imooc.mybatis.cache.dao.TempDao.list", null, new RowBounds(2, 2));
        logger.info(tempEntityList2);
        sqlSession.close();
    }

    @Test
    public void testSqlScript() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map<String, Integer> param1 = new HashMap<String, Integer>();
        param1.put("type", 1);
        param1.put("id", 1);
        TempEntity tempEntity1 = sqlSession.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById3", param1);
        logger.info(tempEntity1);
        Map<String, Integer> param2 = new HashMap<String, Integer>();
        param2.put("type", 2);
        param2.put("id", 1);
        TempEntity tempEntity2 = sqlSession.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById3", param2);
        logger.info(tempEntity2);
        sqlSession.close();
    }

}