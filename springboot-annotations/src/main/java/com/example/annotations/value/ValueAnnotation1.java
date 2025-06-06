package com.example.annotations.value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueAnnotation1 {

    @Value("default name")
    private String name;

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private MailInfo mailInfo;

    public void printMessage(){
        System.out.println("Default Name : " +name);
        System.out.println("Application Name : " + applicationName);

        System.out.println("Mail UserName : " + mailInfo.getUserName());
        System.out.println("Mail Password : " + mailInfo.getPassword());
        System.out.println("Mail Secret : " + mailInfo.getSecret());
    }
}
