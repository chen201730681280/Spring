package com.imooc.spring.ioc.class14;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Class14Test {

    @Test
    public void Test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        TestBean testBean = context.getBean("testBean", TestBean.class);
        System.out.println("testBean = " + testBean);
        System.out.println("testBean.getAnotherBeanFromContext() = " + testBean.getAnotherBeanFromContext());
    }
}
