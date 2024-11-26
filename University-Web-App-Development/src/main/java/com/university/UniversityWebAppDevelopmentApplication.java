package com.university;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.university")
public class UniversityWebAppDevelopmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityWebAppDevelopmentApplication.class, args);
	}

}
