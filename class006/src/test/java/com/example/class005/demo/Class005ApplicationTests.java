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
        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        Bean bean=context.getBean("bean",Bean.class);
        System.out.println("bean="+bean);
    }

}
