package com.kubernetesapi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// Use Component scan if package is outside the Application package or it is a parent package
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
