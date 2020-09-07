package com.example.class005.demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Class005ApplicationTests {

    @Test
    public void test(){
        /*
            取上下文
         */
        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
        //获取bean
        Bean bean=context.getBean("bean",Bean.class);
        System.out.println("bean="+bean);

        //静态方法创建
        //static是静态方法，不需要实例化类就可以使用
        Bean2 bean2=context.getBean("bean2",Bean2.class);
        System.out.println("bean2="+bean2);

        //实例方法创建
        //非静态类需要实例化成对象后调用
        Bean3 bean3=context.getBean("bean3",Bean3.class);
        System.out.println("bean3="+bean3);
    }

}
