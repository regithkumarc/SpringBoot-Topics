package com.example.centralizedlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CentralizedLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralizedLogApplication.class, args);
	}

}
