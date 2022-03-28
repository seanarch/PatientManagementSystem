package com.PatManSystem.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.PatManSystem.main.Controllers",
		"com.PatManSystem.main.Services",
		"com.PatManSystem.main.DTO",
		"com.PatManSystem.main.Mapper",
		"com.PatManSystem.main.Repository",
		"com.PatManSystem.main.Models"})
public class PatientManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientManagementSystemApplication.class, args);
	}

}
