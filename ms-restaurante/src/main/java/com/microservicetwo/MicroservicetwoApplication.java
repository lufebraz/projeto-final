package com.microservicetwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicetwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicetwoApplication.class, args);
	}

}
