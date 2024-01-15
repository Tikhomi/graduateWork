package com.example.graduateWork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.graduateWork.config",
		"com.example.graduateWork.config.security",
		"com.example.graduateWork.controller.common",
		"com.example.graduateWork.service",
		"com.example.graduateWork.repository"})
@ComponentScan(basePackages = {"com.example.graduateWork"})
public class GraduateWorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraduateWorkApplication.class, args);
	}
}
