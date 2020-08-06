package com.loginservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication(scanBasePackages="com.loginservice")
public class LoginServiceApplication {

	public static void main(String args[]) {
		SpringApplication.run(LoginServiceApplication.class, args);
	}
}
