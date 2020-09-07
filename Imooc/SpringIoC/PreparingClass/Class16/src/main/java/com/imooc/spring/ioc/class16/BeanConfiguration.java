package com.imooc.spring.ioc.class16;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class BeanConfiguration {

    @Bean
    @Lazy
    public TestBean testBean() {
        return new TestBean();
    }

}
