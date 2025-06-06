package com.example.annotations.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentClass1 {

    @Autowired
    private EnvironmentMailInfo environmentMailInfo;

    public void printMessage() {
        System.out.println("Environment UserName : " + environmentMailInfo.getUserName());
        System.out.println("Environment UserName : " + environmentMailInfo.getPassword());
        System.out.println("Environment UserName : " + environmentMailInfo.getSecret());
    }
}
