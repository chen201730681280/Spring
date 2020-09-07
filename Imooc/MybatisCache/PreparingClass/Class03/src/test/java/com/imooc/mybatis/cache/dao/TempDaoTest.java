package com.imooc.mybatis.cache.dao;

import com.imooc.mybatis.cache.entity.TempEntity;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Map;

public class TempDaoTest {

    private Logger logger = Logger.getLogger(this.getClass());

    @Test
    public void testSelectAsUpdate() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        sqlSession1.selectOne("com.imooc.mybatis.cache.dao.TempDao.getTempById", 100);
        sqlSession1.selectOne("com.imooc.mybatis.cache.dao.TempDao.getTempById", 100);
        sqlSession1.close();
    }

    @Test
    public void testSession() throws IOException, IllegalAccessException, NoSuchFieldException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        logger.info("sqlSession的class：" + sqlSession.getClass().getName());

        Field executorField = sqlSession.getClass().getDeclaredField("executor");
        executorField.setAccessible(true);
        Executor executor = (Executor) executorField.get(sqlSession);
        logger.info("childExcutor的class：" + executor.getClass().getName());

        Field childExcutorField = executor.getClass().getDeclaredField("delegate");
        childExcutorField.setAccessible(true);
        Executor childExcutor = (Executor) childExcutorField.get(executor);
        logger.info("childExcutor的class：" + childExcutor.getClass().getName());

        Field cacheField = childExcutor.getClass().getSuperclass().getDeclaredField("localCache");
        cacheField.setAccessible(true);
        Cache cache = (Cache) cacheField.get(childExcutor);
        logger.info("cache的class：" + cache.getClass().getName());

        Field mapField = cache.getClass().getDeclaredField("cache");
        mapField.setAccessible(true);
        Map<Object, Object> map = (Map<Object, Object>) mapField.get(cache);


        logger.info("执行查询前打印缓存---开始");
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            logger.info(entry.getKey() + " --->> " + entry.getValue());
        }
        logger.info("执行查询前打印缓存---结束");

        TempEntity tempEntity = sqlSession.selectOne("com.imooc.mybatis.cache.dao.TempDao.getTempById", 1);

        logger.info("执行查询后打印缓存---开始");
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            logger.info(entry.getKey() + " --->> " + entry.getValue());
        }
        logger.info("执行查询后打印缓存---结束");

        sqlSession.close();

        logger.info("关闭session后打印缓存---开始");
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            logger.info(entry.getKey() + " --->> " + entry.getValue());
        }
        logger.info("关闭session后打印缓存---结束");

        logger.info("查询结果：" + tempEntity);
    }

    @Test
    public void testCommit() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TempEntity tempEntity1 = sqlSession.selectOne("com.imooc.mybatis.cache.dao.TempDao.getTempById", 1);
        logger.info(tempEntity1);
        sqlSession.commit();
        TempEntity tempEntity2 = sqlSession.selectOne("com.imooc.mybatis.cache.dao.TempDao.getTempById", 1);
        logger.info(tempEntity2);
        sqlSession.close();
    }

    @Test
    public void testRollBack() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TempEntity tempEntity1 = sqlSession.selectOne("com.imooc.mybatis.cache.dao.TempDao.getTempById", 1);
        logger.info(tempEntity1);
        sqlSession.rollback();
        TempEntity tempEntity2 = sqlSession.selectOne("com.imooc.mybatis.cache.dao.TempDao.getTempById", 1);
        logger.info(tempEntity2);
        sqlSession.close();
    }

    @Test
    public void testClear() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TempEntity tempEntity1 = sqlSession.selectOne("com.imooc.mybatis.cache.dao.TempDao.getTempById", 1);
        logger.info(tempEntity1);
        sqlSession.clearCache();
        TempEntity tempEntity2 = sqlSession.selectOne("com.imooc.mybatis.cache.dao.TempDao.getTempById", 1);
        logger.info(tempEntity2);
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TempEntity tempEntity1 = sqlSession.selectOne("com.imooc.mybatis.cache.dao.TempDao.getTempById", 1);
        logger.info(tempEntity1);
        sqlSession.delete("com.imooc.mybatis.cache.dao.TempDao.deleteTestById", 2);
        TempEntity tempEntity2 = sqlSession.selectOne("com.imooc.mybatis.cache.dao.TempDao.getTempById", 1);
        logger.info(tempEntity2);
        sqlSession.close();
    }

    @Test
    public void testDirtyRead() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        TempEntity tempEntity1 = sqlSession1.selectOne("com.imooc.mybatis.cache.dao.TempDao.getTempById", 1);
        logger.info(tempEntity1);

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        sqlSession2.update("com.imooc.mybatis.cache.dao.TempDao.updateTempById", 1);
        TempEntity tempEntity2 = sqlSession2.selectOne("com.imooc.mybatis.cache.dao.TempDao.getTempById", 1);
        logger.info(tempEntity2);
        sqlSession2.commit();
        sqlSession2.close();

        TempEntity tempEntity3 = sqlSession1.selectOne("com.imooc.mybatis.cache.dao.TempDao.getTempById", 1);
        logger.info(tempEntity3);
        sqlSession1.clearCache();

        TempEntity tempEntity4 = sqlSession1.selectOne("com.imooc.mybatis.cache.dao.TempDao.getTempById", 1);
        logger.info(tempEntity4);

        sqlSession1.commit();

        sqlSession1.close();

    }


}