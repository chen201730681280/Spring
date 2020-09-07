package com.imooc.spring.ioc.class15;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.lang.Nullable;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class MyScope implements org.springframework.beans.factory.config.Scope {

    private Map<String, Object> map = new ConcurrentHashMap<String, Object>();

    public Object get(String s, ObjectFactory<?> objectFactory) {
        if (map.containsKey(s + "0") && map.containsKey(s + "1")) {
            return map.get(s + new Random().nextInt(2));
        } else {
            Object object = objectFactory.getObject();
            if (!map.containsKey(s + "0")){
                map.put(s + "0", object);
            } else if (!map.containsKey(s + "1")) {
                map.put(s + "1", object);
            }
            return object;
        }
    }

    @Nullable
    public Object remove(String s) {
        Object object = null;
        if (map.containsKey(s + "0") && map.containsKey(s + "1")) {
            object =  map.get(s + new Random().nextInt(2));
        } else if (map.containsKey(s + "0")){
            object =  map.get(s + "0");
        } else if (map.containsKey(s + "1")) {
            object =  map.get(s + "1");
        }
        map.remove(s + "0");
        map.remove(s + "1");
        return object;
    }

    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Nullable
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Nullable
    public String getConversationId() {
        return null;
    }
}
