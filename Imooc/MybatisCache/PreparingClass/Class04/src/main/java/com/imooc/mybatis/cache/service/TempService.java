package com.imooc.mybatis.cache.service;

import com.imooc.mybatis.cache.dao.TempDao;
import com.imooc.mybatis.cache.entity.TempEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TempService {

    @Autowired
    private TempDao tempDao;

    @Transactional
    public void getTempByIdWithTranscation() {
        TempEntity tempEntity1 = tempDao.getTempById(1);
        System.out.println("tempEntity1 = " + tempEntity1);
        TempEntity tempEntity2 = tempDao.getTempById(1);
        System.out.println("tempEntity2 = " + tempEntity2);
        System.out.println("tempEntity1 == tempEntity2 = " + (tempEntity1 == tempEntity2));
    }

    public void getTempByIdNoTranscation() {
        TempEntity tempEntity1 = tempDao.getTempById(1);
        System.out.println("tempEntity1 = " + tempEntity1);
        TempEntity tempEntity2 = tempDao.getTempById(1);
        System.out.println("tempEntity2 = " + tempEntity2);
        System.out.println("tempEntity1 == tempEntity2 = " + (tempEntity1 == tempEntity2));
    }


}
