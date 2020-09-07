package com.imooc.spring.ioc.class06;

public class DIByNull {

    private AnotherBean anotherBean;

    public AnotherBean getAnotherBean() {
        return anotherBean;
    }

    public void setAnotherBean(AnotherBean anotherBean) {
        this.anotherBean = anotherBean;
    }

    @Override
    public String toString() {
        return "DIByNull{" +
                "anotherBean=" + anotherBean +
                '}';
    }
}
