package com.imooc.spring.ioc.class07;

public abstract class Bean3 {

    public abstract Bean2 getBean2();

    public void pringBean2() {
        System.out.println("bean2 = " + getBean2());
    }

}
