package com.imooc.spring.ioc.class15;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.imooc.spring.ioc.class15")
public class BeanConfiguration {

    @Bean
    @Scope("prototype")
    public Bean2 bean2() {
        return new Bean2();
    }

    @Bean
    public MyScope myScope() { return new MyScope(); }

    @Bean
    public CustomScopeConfigurer customScopeConfigurer(MyScope myScope) {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("myScope", myScope);
        return configurer;
    }

    @Bean
    @Scope("myScope")
    public Bean3 bean3() { return new Bean3(); }

}
