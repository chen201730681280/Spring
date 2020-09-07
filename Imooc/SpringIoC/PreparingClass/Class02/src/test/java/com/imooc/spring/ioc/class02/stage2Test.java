package com.imooc.spring.ioc.class02;

import com.imooc.spring.ioc.class02.stage2.ZhangSan;
import org.junit.Test;

public class stage2Test {

    @Test
    public void testStage1() {
        ZhangSan zhangSan = new ZhangSan();
        System.out.println("去上班");
        zhangSan.gotoWork();
        System.out.println("去买菜");
        zhangSan.gotoBuy();
        System.out.println("回家喽");
        zhangSan.backHome();
    }

}
