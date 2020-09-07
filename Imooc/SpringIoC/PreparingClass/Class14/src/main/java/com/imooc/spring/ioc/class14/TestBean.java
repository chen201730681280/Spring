package com.imooc.spring.ioc.class14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class TestBean {

    private AnotherBean anotherBean1;

    private AnotherBean anotherBean2;
    @Autowired
    @Qualifier("anotherBean3")
    private AnotherBean anotherBean3;

    @Autowired
    private List<String> stringList;
    @Autowired
    private List<AnotherBean> anotherBeanList;
    @Autowired
    private Set<String> stringSet;
    @Autowired
    private Set<AnotherBean> anotherBeanSet;
    @Autowired
    private Map<String, String> stringMap;
    @Autowired
    private Map<String, AnotherBean> anotherBeanMap;

    @Value("stringValue")
    private String stringValue;

    @Autowired
    private ApplicationContext context;

    public AnotherBean getAnotherBeanFromContext() {
        return context.getBean("anotherBean1", AnotherBean.class);
    }

    @Autowired
    public TestBean(AnotherBean anotherBean1) {
        this.anotherBean1 = anotherBean1;
    }

    @Autowired
    public void setAnotherBean2(AnotherBean anotherBean2) {
        this.anotherBean2 = anotherBean2;
    }

    public AnotherBean getAnotherBean1() {
        return anotherBean1;
    }

    public AnotherBean getAnotherBean2() {
        return anotherBean2;
    }

    public AnotherBean getAnotherBean3() {
        return anotherBean3;
    }

    public void setAnotherBean1(AnotherBean anotherBean1) {
        this.anotherBean1 = anotherBean1;
    }

    public void setAnotherBean3(AnotherBean anotherBean3) {
        this.anotherBean3 = anotherBean3;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<AnotherBean> getAnotherBeanList() {
        return anotherBeanList;
    }

    public void setAnotherBeanList(List<AnotherBean> anotherBeanList) {
        this.anotherBeanList = anotherBeanList;
    }

    public Set<String> getStringSet() {
        return stringSet;
    }

    public void setStringSet(Set<String> stringSet) {
        this.stringSet = stringSet;
    }

    public Set<AnotherBean> getAnotherBeanSet() {
        return anotherBeanSet;
    }

    public void setAnotherBeanSet(Set<AnotherBean> anotherBeanSet) {
        this.anotherBeanSet = anotherBeanSet;
    }

    public Map<String, String> getStringMap() {
        return stringMap;
    }

    public void setStringMap(Map<String, String> stringMap) {
        this.stringMap = stringMap;
    }

    public Map<String, AnotherBean> getAnotherBeanMap() {
        return anotherBeanMap;
    }

    public void setAnotherBeanMap(Map<String, AnotherBean> anotherBeanMap) {
        this.anotherBeanMap = anotherBeanMap;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "anotherBean1=" + anotherBean1 +
                ", anotherBean2=" + anotherBean2 +
                ", anotherBean3=" + anotherBean3 +
                ", stringList=" + stringList +
                ", anotherBeanList=" + anotherBeanList +
                ", stringSet=" + stringSet +
                ", anotherBeanSet=" + anotherBeanSet +
                ", stringMap=" + stringMap +
                ", anotherBeanMap=" + anotherBeanMap +
                ", stringValue='" + stringValue + '\'' +
                '}';
    }
}
