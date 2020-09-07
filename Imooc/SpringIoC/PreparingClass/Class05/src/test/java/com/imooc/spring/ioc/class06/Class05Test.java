package com.imooc.spring.ioc.class06;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Class05Test {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Bean bean = context.getBean("bean", Bean.class);
        System.out.println("bean = " + bean);
        Bean beanFromFactory1 = context.getBean("beanFromFactory1", Bean.class);
        System.out.println("beanFromFactory1 = " + beanFromFactory1);
        Bean beanFromFactory2 = context.getBean("beanFromFactory2", Bean.class);
        System.out.println("beanFromFactory2 = " + beanFromFactory2);
        Bean bean1 = context.getBean("bean1", Bean.class);
        System.out.println("bean1 = " + bean1);
        Bean bean2 = context.getBean("bean2", Bean.class);
        System.out.println("bean2 = " + bean2);
        Bean bean3 = context.getBean("bean3", Bean.class);
        System.out.println("bean3 = " + bean3);
        Bean bean4 = context.getBean("bean4", Bean.class);
        System.out.println("bean4 = " + bean4);
    }
}
