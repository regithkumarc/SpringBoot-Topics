package com.example.annotations.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeClass1 {

    public PrototypeClass1() {
        System.out.println("Calling PrototypeClass1 Constructor");
    }
}
