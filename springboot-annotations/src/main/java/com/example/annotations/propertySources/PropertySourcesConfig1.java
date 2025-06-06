package com.example.annotations.propertySources;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
//@PropertySource("classpath:email.properties")
//@PropertySource(("classpath:message.properties"))
@PropertySources({
        @PropertySource("classpath:email.properties"),
        @PropertySource(("classpath:message.properties"))
})
public class PropertySourcesConfig1 {
}
