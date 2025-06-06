package com.example.annotations.lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
/*
 * Spring create all singleton eagerly at the startup/bootstrap of the application context
 * You can load spring beans lazily (on-demand)
 * Can used @Configuration / @Component / @Bean annotations
 * Eager initialization is recommended : to avoid and detect all possible error immediately
 * rather than runtime
 *
 */
public class LazyClass1 {

    @Autowired
    private LazyInterface1 lazyInterface1;

    public LazyClass1() {
        System.out.println("Printing the LazyClass1 Constructor");
    }

    public void printMessage() {
        System.out.println("Printing the LazyClass1");
        lazyInterface1.printMessage();
    }

}
