package com.imooc.spring.ioc.class11;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Bean implements InitializingBean, DisposableBean {

    public Bean() {
        System.out.println(this.getClass().getSimpleName() + " has been created");
    }

    public void initMethod() {
        System.out.println("initMethod");
    }

    public void destoryMethod() {
        System.out.println("destoryMethod");
    }

    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
