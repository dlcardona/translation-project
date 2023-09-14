package com.example.app.translatejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TranslateJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranslateJavaApplication.class, args);
	}

}
