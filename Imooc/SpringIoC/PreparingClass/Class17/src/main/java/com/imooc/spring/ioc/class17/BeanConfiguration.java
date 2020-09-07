package com.imooc.spring.ioc.class17;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class BeanConfiguration {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public TestBean testBean() {
        return new TestBean();
    }

}
