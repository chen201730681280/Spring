package com.imooc.spring.ioc.class17;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class TestBean implements InitializingBean, DisposableBean {

    public void initMethod() {
        System.out.println("TestBean.initMethod");
    }

    public void destroyMethod() {
        System.out.println("TestBean.destroyMethod");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("TestBean.postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("TestBean.preDestroy");
    }

    public void destroy() throws Exception {
        System.out.println("TestBean.destroy");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("TestBean.afterPropertiesSet");
    }
}
