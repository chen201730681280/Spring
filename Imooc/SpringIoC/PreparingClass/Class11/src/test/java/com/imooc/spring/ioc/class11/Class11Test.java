package com.imooc.spring.ioc.class11;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Class11Test {

    @Test
    public void Test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("========================ApplicationContext has been create========================");
        Bean bean = context.getBean("bean", Bean.class);
        System.out.println("bean = " + bean);
        context.close();
    }
}
