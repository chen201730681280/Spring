package com.imooc.spring.ioc.class15;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class Bean4 {

    @Lookup
    public abstract Bean2 getBean2();

    public void printBean2() {
        System.out.println("getBean2 = " + getBean2());
    }
}
