package com.imooc.spring.ioc.class02.stage1;

public class Audi {

    public void start() {
        System.out.println(this.getClass().getSimpleName() + ": 出发!!!");
    }

    public void turnLeft() {
        System.out.println(this.getClass().getSimpleName() + ": 左转!!!");
    }

    public void turnRight() {
        System.out.println(this.getClass().getSimpleName() + ": 右转!!!");
    }

    public void stop() {
        System.out.println(this.getClass().getSimpleName() + ": 到达!!!");
    }

}
