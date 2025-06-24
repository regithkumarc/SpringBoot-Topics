package com.example.courseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FeignCourseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignCourseServiceApplication.class, args);
	}

}
