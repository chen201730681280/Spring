package com.imooc.spring.ioc.class03;

import com.imooc.spring.ioc.class03.car.AudiCar;
import com.imooc.spring.ioc.class03.car.BuickCar;
import com.imooc.spring.ioc.class03.humen.Human;
import com.imooc.spring.ioc.class03.humen.Li4Human;
import com.imooc.spring.ioc.class03.humen.Zhang3Human;
import org.junit.Before;
import org.junit.Test;

public class Class03Test {

    private final IocContrainner iocContrainner = new IocContrainner();

    @Before
    public void before() {
        iocContrainner.registerBean(AudiCar.class, "audi");
        iocContrainner.registerBean(BuickCar.class, "buick");
        iocContrainner.registerBean(Zhang3Human.class, "zhang3", "audi");
        iocContrainner.registerBean(Li4Human.class, "li4", "buick");
    }

    @Test
    public void test() {
        Human zhang3 = (Human) iocContrainner.getBean("zhang3");
        System.out.println("张三要回家啦");
        zhang3.goHome();
        Human li4 = (Human) iocContrainner.getBean("li4");
        System.out.println("李四要回家啦");
        li4.goHome();
    }

}