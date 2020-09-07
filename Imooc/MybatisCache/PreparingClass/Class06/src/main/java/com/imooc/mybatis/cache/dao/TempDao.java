package com.imooc.mybatis.cache.dao;

import com.imooc.mybatis.cache.entity.TempEntity;

import java.util.Map;

public interface TempDao {

    public TempEntity getById1(int id);
    public TempEntity getById2(int id);
    public TempEntity getById3(Map param);
    public TempEntity list();
}
