package com.codigo.ms_seguridad_c;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsSeguridadCApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSeguridadCApplication.class, args);
	}

}
