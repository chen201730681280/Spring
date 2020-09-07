package com.imooc.spring.ioc.class06;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Class06Test {

    @Test
    public void Test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        DIByConstructor diByConstructor1 = context.getBean("diByConstructor1", DIByConstructor.class);
        System.out.println("diByConstructor1 = " + diByConstructor1);
        DIByConstructor diByConstructor2 = context.getBean("diByConstructor2", DIByConstructor.class);
        System.out.println("diByConstructor2 = " + diByConstructor2);
        DIBySetter diBySetter1 = context.getBean("diBySetter1", DIBySetter.class);
        System.out.println("diBySetter1 = " + diBySetter1);
        DIBySetter diBySetter2 = context.getBean("diBySetter2", DIBySetter.class);
        System.out.println("diBySetter2 = " + diBySetter2);
        DIByCollection diByCollection = context.getBean("diByCollection", DIByCollection.class);
        System.out.println("diByCollection = " + diByCollection);
        DIByNull diByNull = context.getBean("diByNull", DIByNull.class);
        System.out.println("diByNull = " + diByNull);
        DIByInnerClass diByInnerClass = context.getBean("diByInnerClass", DIByInnerClass.class);
        System.out.println("diByInnerClass = " + diByInnerClass);

    }
}
