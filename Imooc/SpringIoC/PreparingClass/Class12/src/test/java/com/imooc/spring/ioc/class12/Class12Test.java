package com.imooc.spring.ioc.class12;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Class12Test {

    @Test
    public void Test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("========================ApplicationContext has been create========================");
        ParentBean parentBean = context.getBean("parentBean", ParentBean.class);
        System.out.println("parentBean = " + parentBean);
        Bean1 bean1 = context.getBean("bean1", Bean1.class);
        System.out.println("bean1 = " + bean1);
        Bean2 bean2 = context.getBean("bean2", Bean2.class);
        System.out.println("bean2 = " + bean2);
        Bean1WithoutParent bean1WithoutParent = context.getBean("bean1WithoutParent", Bean1WithoutParent.class);
        System.out.println("bean1WithoutParent = " + bean1WithoutParent);
        Bean2WithoutParent bean2WithoutParent = context.getBean("bean2WithoutParent", Bean2WithoutParent.class);
        System.out.println("bean2WithoutParent = " + bean2WithoutParent);
    }
}
