package com.imooc.spring.ioc.class13;

import com.imooc.spring.ioc.class13.stage1.Bean1;
import com.imooc.spring.ioc.class13.stage1.BeanConfiguration1;
import com.imooc.spring.ioc.class13.stage2.Bean2;
import com.imooc.spring.ioc.class13.stage2.BeanConfiguration2;
import com.imooc.spring.ioc.class13.stage3.Bean3;
import com.imooc.spring.ioc.class13.stage3.BeanConfiguration3;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Class13Test {

    @Test
    public void Test() {
        ApplicationContext context1 = new AnnotationConfigApplicationContext(BeanConfiguration1.class);
        Bean1 bean1 = context1.getBean("bean1", Bean1.class);
        System.out.println("bean1 = " + bean1);

        ApplicationContext context2 = new AnnotationConfigApplicationContext(BeanConfiguration2.class);
        Bean2 bean2 = context2.getBean("bean2", Bean2.class);
        System.out.println("bean2 = " + bean2);

        ApplicationContext context3 = new AnnotationConfigApplicationContext(BeanConfiguration3.class);
        Bean3 bean3_1 = context3.getBean("bean3-1", Bean3.class);
        System.out.println("bean3_1 = " + bean3_1);
        Bean3 bean3_2 = context3.getBean("bean3-2", Bean3.class);
        System.out.println("bean3_2 = " + bean3_2);
        Bean3 bean3_3 = context3.getBean("bean3-3", Bean3.class);
        System.out.println("bean3_3 = " + bean3_3);
    }
}
