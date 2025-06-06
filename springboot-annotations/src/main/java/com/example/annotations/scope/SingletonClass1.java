package com.example.annotations.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SingletonClass1 {

    public SingletonClass1() {
        System.out.println("Calling SingletonClass1 Constructor");
    }
}
