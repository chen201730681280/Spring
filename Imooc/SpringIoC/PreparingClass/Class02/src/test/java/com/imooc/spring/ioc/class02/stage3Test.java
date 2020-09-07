package com.imooc.spring.ioc.class02;

import com.imooc.spring.ioc.class02.stage3.Audi;
import com.imooc.spring.ioc.class02.stage3.ZhangSan;
import org.junit.Test;

public class stage3Test {

    @Test
    public void testStage1() {
        Audi audi = new Audi();

        ZhangSan zhangSan = new ZhangSan(audi);
        System.out.println("去上班");
        zhangSan.gotoWork();
        System.out.println("去买菜");
        zhangSan.gotoBuy();
        System.out.println("回家喽");
        zhangSan.backHome();
    }

}
