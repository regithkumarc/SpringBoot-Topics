package com.example.annotations.propertySource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropertySourceClass1 {

    @Autowired
    private PropertySourceMailInfo propertySourceMailInfo;

    public void printMessage(){
        //Email
        System.out.println("PropertySource UserName : " + propertySourceMailInfo.getUserName());
        System.out.println("PropertySource Password : " + propertySourceMailInfo.getPassword());
        System.out.println("PropertySource Secret : " + propertySourceMailInfo.getSecret());

        //Message
        System.out.println("PropertySource MessageName : " + propertySourceMailInfo.getMessageName());
        System.out.println("PropertySource MessageDesc : " + propertySourceMailInfo.getMessageDesc());
    }
}
