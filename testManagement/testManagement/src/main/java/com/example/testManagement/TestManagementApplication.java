package com.example.testManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.testManagement"})
public class TestManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestManagementApplication.class, args);
	}

}
