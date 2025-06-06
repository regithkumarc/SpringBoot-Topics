package com.example.annotations.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration1 {

    @Bean(initMethod = "initMethod",destroyMethod = "destroyMethod")
    /*
     * Bean annotation indicates that method produce the bean to be managed by Spring Container
     * Bean annotation declared in Configuration class to create Spring bean
     */
    public BeanInterface1 beanClass2() {
        return new BeanClass2();
    }

    @Bean(initMethod = "initMethod",destroyMethod = "destroyMethod")
    public BeanInterface1 beanClass3() {
        return new BeanClass3();
    }
}
