package com.imooc.spring.ioc.class03.humen;

import com.imooc.spring.ioc.class03.car.Car;

public class Zhang3Human extends HumenWithCar{

    public Zhang3Human(Car car) {
        super(car);
    }

    public void goHome() {
        car.start();
        car.turnLeft();
        car.stop();
    }
}
