package com.imooc.spring.ioc.class03;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class IocContrainner {

    /**
     * 用来存储beans，String为bean的id，Object为bean本身
     */
    private final Map<String, Object> beans = new HashMap<String, Object>();

    /**
     * 根据beanId获取一个bean
     * @param beanId beanId
     * @return 返回bean
     */
    public Object getBean(String beanId) {
        return beans.get(beanId);
    }

    /**
     * 委托IoC容器创建一个bean
     * @param clazz 要创建的bean的class
     * @param beanId beanId
     * @param paramBeanIds 要创建的bean的class的构造方法所依赖的bean
     */
    public void registerBean(Class<?> clazz, String beanId, String... paramBeanIds)  {
        Object[] paramValues = new Object[paramBeanIds.length];
        for (int i = 0; i < paramBeanIds.length; i++) {
            Object paramValue = getBean(paramBeanIds[i]);
            if (paramValue == null) {
                throw new RuntimeException("Can't find bean of id: " + paramBeanIds[i]);
            }
            paramValues[i] = paramValue;
        }

        Object bean = null;
        // 获取并循环所有的构造方法
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            try {
                bean = constructor.newInstance(paramValues);
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
        }
        if (bean == null) {
            throw new RuntimeException("找不到合适的构造方法：" + paramBeanIds);
        }
        beans.put(beanId, bean);
    }
}
