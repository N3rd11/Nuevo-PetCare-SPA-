package com.petcare.resena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ResenaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResenaApplication.class, args);
	}

}
