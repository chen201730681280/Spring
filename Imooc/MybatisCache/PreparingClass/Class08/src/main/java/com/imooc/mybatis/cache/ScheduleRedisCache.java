package com.imooc.mybatis.cache;


import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.decorators.ScheduledCache;

import java.util.concurrent.locks.ReadWriteLock;

public class ScheduleRedisCache implements Cache {

    private final RedisCache redisCache;
    private final ScheduledCache scheduledCache;

    public ScheduleRedisCache(String id) {
        redisCache = new RedisCache(id);
        scheduledCache = new ScheduledCache(redisCache);
    }

    public String getId() {
        return redisCache.getId();
    }

    public void putObject(Object key, Object value) {
        scheduledCache.putObject(key, value);
    }

    public Object getObject(Object key) {
        return scheduledCache.getObject(key);
    }

    public Object removeObject(Object key) {
        return scheduledCache.removeObject(key);
    }

    public void clear() {
        scheduledCache.clear();
    }

    public int getSize() {
        return scheduledCache.getSize();
    }

    public ReadWriteLock getReadWriteLock() {
        return scheduledCache.getReadWriteLock();
    }

    public void setHost(String host) {
        redisCache.setHost(host);
    }

    public void setPort(int port) {
        redisCache.setPort(port);
    }

    public void setPassword(String password) {
        redisCache.setPassword(password);
    }

    public void setClearInterval(long clearInterval) {
        scheduledCache.setClearInterval(clearInterval);
    }
}
