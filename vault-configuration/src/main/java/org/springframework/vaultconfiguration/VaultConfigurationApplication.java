package org.springframework.vaultconfiguration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.vaultconfiguration.properties.Credentials;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(Credentials.class)
@Slf4j
public class VaultConfigurationApplication implements CommandLineRunner {

	private final Credentials credentials;

	public VaultConfigurationApplication(Credentials credentials) {
		this.credentials = credentials;
	}

	public static void main(String[] args) {
		SpringApplication.run(VaultConfigurationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("UserName : {} " ,credentials.getUserName());
		log.info("Password : {} " ,credentials.getPassword());
	}
}
