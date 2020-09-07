package com.imooc.mybatis.cache.dao;

import com.imooc.mybatis.cache.entity.TempEntity;

import java.util.Map;

public interface TempDao {

    public TempEntity getById(int id);
    public void updateById(int id);

}
