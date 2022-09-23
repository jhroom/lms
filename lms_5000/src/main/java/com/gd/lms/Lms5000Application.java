package com.gd.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ServletComponentScan
@EnableScheduling
public class Lms5000Application {

	public static void main(String[] args) {
		SpringApplication.run(Lms5000Application.class, args);
	}
	
}
