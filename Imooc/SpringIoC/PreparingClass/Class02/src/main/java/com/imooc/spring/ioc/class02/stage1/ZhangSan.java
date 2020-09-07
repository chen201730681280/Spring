package com.imooc.spring.ioc.class02.stage1;

public class ZhangSan {

    public void backHome() {
        Audi audi = new Audi();
        audi.start();
        audi.turnLeft();
        audi.turnRight();
        audi.stop();
    }

    public void gotoWork() {
        Audi audi = new Audi();
        audi.start();
        audi.turnRight();
        audi.turnLeft();
        audi.stop();
    }

    public void gotoBuy() {
        Audi audi = new Audi();
        audi.start();
        audi.stop();
    }

}
