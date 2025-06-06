package com.example.annotations.propertySource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:email.properties")
@PropertySource(("classpath:message.properties"))
public class PropertySourceConfig1 {
}
