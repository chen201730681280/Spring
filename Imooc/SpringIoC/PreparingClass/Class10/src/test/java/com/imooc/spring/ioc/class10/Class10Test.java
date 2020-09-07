package com.imooc.spring.ioc.class10;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Class10Test {

    @Test
    public void Test() {
        final ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("========================ApplicationContext has been create========================");
        Bean1 bean1 = context.getBean("bean1", Bean1.class);
        System.out.println("bean1 = " + bean1);
        Bean2 bean2 = context.getBean("bean2", Bean2.class);
        System.out.println("bean2 = " + bean2);
    }
}
