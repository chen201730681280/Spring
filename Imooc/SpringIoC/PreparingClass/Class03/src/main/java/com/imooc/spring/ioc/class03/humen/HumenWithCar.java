package com.imooc.spring.ioc.class03.humen;

import com.imooc.spring.ioc.class03.car.Car;

public abstract class HumenWithCar implements Human{

    protected final Car car;

    public HumenWithCar(Car car) {
        this.car = car;
    }

    public abstract void goHome();

}
