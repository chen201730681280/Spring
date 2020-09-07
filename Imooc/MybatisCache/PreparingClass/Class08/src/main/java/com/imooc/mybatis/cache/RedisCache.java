package com.imooc.mybatis.cache;

import org.apache.ibatis.cache.Cache;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.*;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;

public class RedisCache implements Cache {

    private final Logger logger = Logger.getLogger(this.getClass());
    private final String redisKey = "mybatis";

    private final String id;

    private String host;
    private int port;
    private String password;

    public RedisCache(String id) {
        this.id = id;
    }

    private Jedis jedis() {
        Jedis jedis = new Jedis(host, port);
        if (password != null) {
            jedis.auth(password);
        }
        return jedis;
    }

    private byte[] objectToBytes(Object o)  {
        if (o == null) return null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(o);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            logger.error(e);
            return new byte[]{};
        }
    }

    private Object bytesToObject(byte[] bytes) {
        if (bytes == null) return null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return objectInputStream.readObject();
        } catch (IOException e) {
            logger.error(e);
            return null;
        } catch (ClassNotFoundException e) {
            logger.error(e);
            return null;
        }
    }

    public String getId() {
        return id;
    }

    public void putObject(Object key, Object value) {
        Jedis jedis = jedis();
        try {
            jedis.hsetnx(redisKey.getBytes(), objectToBytes(key), objectToBytes(value));
        } finally {
            jedis.close();
        }
    }

    public Object getObject(Object key) {
        Jedis jedis = jedis();
        try {
            byte[] bytes = jedis.hget(redisKey.getBytes(), objectToBytes(key));
            return bytesToObject(bytes);
        } finally {
            jedis.close();
        }
    }

    public Object removeObject(Object key) {
        Jedis jedis = jedis();
        try {
            byte[] bytes = jedis.hget(redisKey.getBytes(), objectToBytes(key));
            jedis.hdel(redisKey.getBytes(), objectToBytes(key));
            return bytesToObject(bytes);
        } finally {
            jedis.close();
        }
    }

    public void clear() {
        Jedis jedis = jedis();
        try {
            jedis.del(redisKey);
        } finally {
            jedis.close();
        }
    }

    public int getSize() {
        Jedis jedis = jedis();
        try {
            Map<String, String> caches = jedis.hgetAll(redisKey);
            return caches.size();
        } finally {
            jedis.close();
        }
    }

    public ReadWriteLock getReadWriteLock() {
        return null;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
