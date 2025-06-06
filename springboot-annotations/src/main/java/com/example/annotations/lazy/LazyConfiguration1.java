package com.example.annotations.lazy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class LazyConfiguration1 {

    @Bean(initMethod = "initMethod",destroyMethod = "destroyMethod")
    @Lazy
    /*
     * Bean annotation indicates that method produce the bean to be managed by Spring Container
     * Bean annotation declared in Configuration class to create Spring bean
     */
    public LazyInterface1 lazyClass2() {
        return new LazyClass2();
    }

    @Bean(initMethod = "initMethod",destroyMethod = "destroyMethod")
    @Lazy
    public LazyInterface1 lazyClass3() {
        return new LazyClass3();
    }
}
