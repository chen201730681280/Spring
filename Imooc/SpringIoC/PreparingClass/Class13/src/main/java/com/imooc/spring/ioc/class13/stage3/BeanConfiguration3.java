package com.imooc.spring.ioc.class13.stage3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.imooc.spring.ioc.class13.stage3")
public class BeanConfiguration3 {

    @Bean({"bean3-2", "bean3-3"})
    public Bean3 bean3() {
        return new Bean3();
    }

}
