package com.imooc.spring.ioc.class02.stage2;

public class ZhangSan {

    private Audi audi = new Audi();

    public void backHome() {
        audi.start();
        audi.turnLeft();
        audi.turnRight();
        audi.stop();
    }

    public void gotoWork() {
        audi.start();
        audi.turnRight();
        audi.turnLeft();
        audi.stop();
    }

    public void gotoBuy() {
        audi.start();
        audi.stop();
    }

}
