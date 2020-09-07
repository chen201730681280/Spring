package com.imooc.spring.ioc.class06;

public class BeanFactory {

    public static Bean createBean1() {
        return new Bean();
    }

    public Bean createBean2() {
        return new Bean();
    }

}
