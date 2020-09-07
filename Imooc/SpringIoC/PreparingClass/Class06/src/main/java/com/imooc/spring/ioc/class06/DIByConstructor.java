package com.imooc.spring.ioc.class06;

public class DIByConstructor {

    private AnotherBean anotherBean;
    private String stringValue;
    private Integer integerValue;

    public DIByConstructor(AnotherBean anotherBean, String stringValue, Integer integerValue) {
        this.anotherBean = anotherBean;
        this.stringValue = stringValue;
        this.integerValue = integerValue;
    }

    public DIByConstructor() {
        System.out.println(this.getClass().getSimpleName() + " has been created");
    }

    @Override
    public String toString() {
        return "DIByConstructor{" +
                "anotherBean=" + anotherBean +
                ", stringValue='" + stringValue + '\'' +
                ", integerValue=" + integerValue +
                '}';
    }
}
