package com.imooc.spring.ioc.class02.stage3;

public class ZhangSan {

    private Audi audi;

    public ZhangSan(Audi audi) {
        this.audi = audi;
    }

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
