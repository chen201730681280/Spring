package com.imooc.spring.ioc.class03.humen;

import com.imooc.spring.ioc.class03.car.Car;

public class Li4Human extends HumenWithCar{

    public Li4Human(Car car) {
        super(car);
    }

    public void goHome() {
        car.start();
        car.turnRight();
        car.stop();
    }
}
