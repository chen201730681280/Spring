package com.imooc.spring.ioc.class06;

public class DIBySetter {

    private AnotherBean anotherBean;
    private String stringValue;
    private Integer integerValue;

    public AnotherBean getAnotherBean() {
        return anotherBean;
    }

    public void setAnotherBean(AnotherBean anotherBean) {
        this.anotherBean = anotherBean;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public Integer getIntegerValue() {
        return integerValue;
    }

    public void setIntegerValue(Integer integerValue) {
        this.integerValue = integerValue;
    }

    public DIBySetter() {
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
