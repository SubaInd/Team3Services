package com.qthonservices.practisemcqservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@SpringBootApplication(scanBasePackages="com.qthonservices.practisemcqservices")
@EnableDiscoveryClient
public class PractiseMcqApplication {

	public static void main(String[] args) {
		SpringApplication.run(PractiseMcqApplication.class, args);
	}
}
