package com.imooc.spring.ioc.class15;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Class15Test {

    @Test
    public void Test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        for (int i = 0; i < 10; i++) {
            Bean1 bean1 = context.getBean("bean1", Bean1.class);
            System.out.println("bean1 = " + bean1);
        }
        for (int i = 0; i < 10; i++) {
            Bean2 bean2 = context.getBean("bean2", Bean2.class);
            System.out.println("bean2 = " + bean2);
        }
        for (int i = 0; i < 10; i++) {
            Bean3 bean3 = context.getBean("bean3", Bean3.class);
            System.out.println("bean3 = " + bean3);
        }

        Bean4 bean4 = context.getBean("bean4", Bean4.class);
        for (int i = 0; i < 10; i++) {
            bean4.printBean2();
        }
    }
}
