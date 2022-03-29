package com.PatManSystem.main;

import com.PatManSystem.main.DTO.PatientinformationDTO;
import com.PatManSystem.main.Services.PatientInformationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

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
