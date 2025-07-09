package com.petcare.ubicacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UbicacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(UbicacionApplication.class, args);
	}

}
