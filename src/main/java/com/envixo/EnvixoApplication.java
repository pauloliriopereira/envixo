package com.envixo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableJpaRepositories
public class EnvixoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnvixoApplication.class, args);
	}
	
}