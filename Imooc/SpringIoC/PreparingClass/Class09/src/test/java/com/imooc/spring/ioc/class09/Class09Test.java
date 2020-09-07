package com.imooc.spring.ioc.class09;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Class09Test {

    @Test
    public void Test() {
        final ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        for (int i = 0; i < 10; i++) {
            Bean bean = context.getBean("beanOfMyScope", Bean.class);
            System.out.println("beanOfMyScope = " + bean);
        }
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    Bean bean = context.getBean("beanOfSimpleThreadScope", Bean.class);
                    System.out.println("beanOfSimpleThreadScope = " + bean);
                }
            }).start();
        }
    }
}
