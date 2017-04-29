package com.nowakis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.nowakis.controller.RsvpController;

@SpringBootApplication
@ComponentScan("com.nowakis")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
