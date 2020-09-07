package com.imooc.spring.ioc.class07;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Class07Test {

    @Test
    public void Test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Bean1 bean1SingletonBean2Singleton_1 = context.getBean("bean1SingletonBean2Singleton", Bean1.class);
        Bean1 bean1SingletonBean2Singleton_2 = context.getBean("bean1SingletonBean2Singleton", Bean1.class);
        Bean1 bean1SingletonBean2Prototype_1 = context.getBean("bean1SingletonBean2Prototype", Bean1.class);
        Bean1 bean1SingletonBean2Prototype_2 = context.getBean("bean1SingletonBean2Prototype", Bean1.class);
        Bean1 bean1PrototypeBean2Singleton_1 = context.getBean("bean1PrototypeBean2Singleton", Bean1.class);
        Bean1 bean1PrototypeBean2Singleton_2 = context.getBean("bean1PrototypeBean2Singleton", Bean1.class);
        Bean1 bean1PrototypeBean2Prototype_1 = context.getBean("bean1PrototypeBean2Prototype", Bean1.class);
        Bean1 bean1PrototypeBean2Prototype_2 = context.getBean("bean1PrototypeBean2Prototype", Bean1.class);

        System.out.println("bean1SingletonBean2Singleton");
        System.out.println(bean1SingletonBean2Singleton_1 == bean1SingletonBean2Singleton_2);
        System.out.println(bean1SingletonBean2Singleton_1.getBean2() == bean1SingletonBean2Singleton_2.getBean2());
        System.out.println("bean1SingletonBean2Prototype");
        System.out.println(bean1SingletonBean2Prototype_1 == bean1SingletonBean2Prototype_2);
        System.out.println(bean1SingletonBean2Prototype_1.getBean2() == bean1SingletonBean2Prototype_2.getBean2());
        System.out.println("bean1PrototypeBean2Singleton");
        System.out.println(bean1PrototypeBean2Singleton_1 == bean1PrototypeBean2Singleton_2);
        System.out.println(bean1PrototypeBean2Singleton_1.getBean2() == bean1PrototypeBean2Singleton_2.getBean2());
        System.out.println("bean1PrototypeBean2Prototype");
        System.out.println(bean1PrototypeBean2Prototype_1 == bean1PrototypeBean2Prototype_2);
        System.out.println(bean1PrototypeBean2Prototype_1.getBean2() == bean1PrototypeBean2Prototype_2.getBean2());

        Bean3 bean3 = context.getBean("bean3", Bean3.class);
        bean3.pringBean2();
        bean3.pringBean2();
    }
}
