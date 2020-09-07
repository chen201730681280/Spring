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
import java.util.concurrent.CountDownLatch;

public class TempDaoTest {

    private Logger logger = Logger.getLogger(this.getClass());

    @Test
    public void testCreateOnCommit() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        TempEntity tempEntity1 = sqlSession1.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById", 1);
        sqlSession1.commit();
        logger.info(tempEntity1);

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        TempEntity tempEntity2 = sqlSession2.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById", 1);
        sqlSession2.close();
        logger.info(tempEntity2);
    }

    @Test
    public void testCreateOnClose() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        TempEntity tempEntity1 = sqlSession1.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById", 1);
        sqlSession1.close();
        logger.info(tempEntity1);

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        TempEntity tempEntity2 = sqlSession2.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById", 1);
        sqlSession2.close();
        logger.info(tempEntity2);
    }

    @Test
    public void testClearOnUpdate() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        TempEntity tempEntity1 = sqlSession1.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById", 1);

        sqlSession1.update("com.imooc.mybatis.cache.dao.TempDao.updateById", 1);

        sqlSession1.close();
        logger.info(tempEntity1);

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        TempEntity tempEntity2 = sqlSession2.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById", 1);
        sqlSession2.close();
        logger.info(tempEntity2);
    }

    @Test
    public void testCacheSize() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        for (int i = 1; i <= 6; i++) {
            SqlSession sqlSession = sqlSessionFactory.openSession();
            sqlSession.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById", i);
            sqlSession.close();
        }

        for (int i = 6; i >= 1; i--) {
            SqlSession sqlSession = sqlSessionFactory.openSession();
            sqlSession.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById", i);
            sqlSession.close();
        }
    }

    @Test
    public void testCacheReadOnly() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        TempEntity tempEntity1 = sqlSession1.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById", 1);
        sqlSession1.close();
        logger.info(tempEntity1);

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        TempEntity tempEntity2 = sqlSession2.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById", 1);
        sqlSession2.close();
        logger.info(tempEntity2);

        logger.info(tempEntity1 == tempEntity2);
    }

    @Test
    public void testCacheFlush() throws IOException, InterruptedException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        TempEntity tempEntity1 = sqlSession1.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById", 1);
        sqlSession1.close();
        logger.info(tempEntity1);

        Thread.sleep(6000);

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        TempEntity tempEntity2 = sqlSession2.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById", 1);
        sqlSession2.close();
        logger.info(tempEntity2);

        logger.info(tempEntity1 == tempEntity2);
    }

    @Test
    public void testCacheBlock() throws IOException, InterruptedException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        final SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        final CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 1; i <= 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    SqlSession sqlSession = sqlSessionFactory.openSession();
                    sqlSession.selectOne("com.imooc.mybatis.cache.dao.TempDao.getById", 1);
                    sqlSession.close();

                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
    }

}