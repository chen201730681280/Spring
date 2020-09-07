package com.imooc.mybatis.cache.dao;

import com.imooc.mybatis.cache.SpringConfiguration;
import com.imooc.mybatis.cache.service.TempService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class TempDaoTest {

    @Autowired
    private TempService tempService;

    @Test
    public void test() {
        tempService.getTempByIdNoTranscation();;
        tempService.getTempByIdWithTranscation();
    }



}