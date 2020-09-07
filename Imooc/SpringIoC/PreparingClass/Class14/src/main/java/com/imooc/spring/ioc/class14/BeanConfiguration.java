package com.imooc.spring.ioc.class14;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@ComponentScan("com.imooc.spring.ioc.class14")
public class BeanConfiguration {

    @Bean({"anotherBean2", "anotherBean3"})
    public AnotherBean anotherBean() {
        return new AnotherBean();
    }

    @Bean
    @Order(5)
    public String string1() {
        return "string1";
    }

    @Bean
    @Order(2)
    public String string2() {
        return "string2";
    }
}
