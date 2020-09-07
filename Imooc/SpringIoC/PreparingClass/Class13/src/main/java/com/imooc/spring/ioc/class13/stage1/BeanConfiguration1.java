package com.imooc.spring.ioc.class13.stage1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration1 {

    @Bean
    public Bean1 bean1() {
        return new Bean1();
    }
}
