package com.example.fabrickproject;

import com.example.fabrickproject.controllers.MainController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = MainController.class)

public class FabrickprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FabrickprojectApplication.class, args);
	}

}
