package org.springframework.vaultconfiguration.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.vaultconfiguration.properties.Credentials;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credentials")
@Slf4j
public class CredentialsController {

    @Autowired
    private Credentials credentials;

    @GetMapping("/getName")
    public String getName() {
        log.info("Getting the CredentialsController");
        return "Getting the CredentialsController";
    }

    @GetMapping("/getCredentials")
    public Credentials getCredentials() {
        return credentials;
    }
}
