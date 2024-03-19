package com.codigo.clinicapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
@EnableFeignClients("com.codigo.clinicapp")
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class ClinicAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicAppApplication.class, args);
	}

}
