package com.example.annotations.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentMailInfo {

    @Autowired
    private Environment environment;

    private String userName;

    private String password;

    private String secret;

    public String getUserName() {
        return environment.getProperty("email.userName");
    }

    public String getPassword() {
        return environment.getProperty("email.password");
    }

    public String getSecret() {
        return environment.getProperty("email.userName");
    }
}
