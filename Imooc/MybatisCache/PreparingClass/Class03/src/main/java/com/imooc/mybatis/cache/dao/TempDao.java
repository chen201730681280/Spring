package com.imooc.mybatis.cache.dao;

import com.imooc.mybatis.cache.entity.TempEntity;

public interface TempDao {

    public TempEntity getTempById(int id);
    public void updateTempById(int id);
    public void deleteTestById(int id);

}
