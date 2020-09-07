package com.imooc.spring.ioc.class17;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Class17Test {

    @Test
    public void Test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        TestBean testBean = context.getBean("testBean", TestBean.class);
        System.out.println("testBean = " + testBean);
        context.close();
    }
}
