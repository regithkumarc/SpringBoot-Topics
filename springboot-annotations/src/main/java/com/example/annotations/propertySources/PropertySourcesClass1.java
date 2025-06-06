package com.example.annotations.propertySources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropertySourcesClass1 {

    @Autowired
    private PropertySourcesMailInfo propertySourcesMailInfo;

    public void printMessage(){
        //Email
        System.out.println("PropertySources UserName : " + propertySourcesMailInfo.getUserName());
        System.out.println("PropertySources Password : " + propertySourcesMailInfo.getPassword());
        System.out.println("PropertySources Secret : " + propertySourcesMailInfo.getSecret());

        //Message
        System.out.println("PropertySources MessageName : " + propertySourcesMailInfo.getMessageName());
        System.out.println("PropertySources MessageDesc : " + propertySourcesMailInfo.getMessageDesc());
    }
}
