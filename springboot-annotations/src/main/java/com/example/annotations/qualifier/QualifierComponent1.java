package com.example.annotations.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class QualifierComponent1 {

    @Autowired
    /*
     * Qualifier annotation is used in conjuction with Autowired to avoid confusion when we have two or more beans
     * configured for same type
     */
    @Qualifier("qualifierComponent2")
    private QualifierInterface1 qualifierInterface1;


/*    private QualifierInterface1 qualifierInterface1;

    public QualifierComponent1(@Qualifier("qualifierComponent2") QualifierInterface1 qualifierInterface1) {
        this.qualifierInterface1 = qualifierInterface1;
    }*/

    public void printMessage() {
        qualifierInterface1.printMessage();
    }
}
