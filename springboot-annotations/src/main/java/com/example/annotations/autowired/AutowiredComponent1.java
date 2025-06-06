package com.example.annotations.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowiredComponent1 {

/*    @Autowired
    private AutowiredComponent2 autowiredComponent2;

    public void printName(){
        autowiredComponent2.printName();
    }*/

    private AutowiredComponent2 autowiredComponent2;

    public AutowiredComponent1(AutowiredComponent2 autowiredComponent2) {
        this.autowiredComponent2 = autowiredComponent2;
    }

    public void printName() {
        autowiredComponent2.printName();
    }
}
