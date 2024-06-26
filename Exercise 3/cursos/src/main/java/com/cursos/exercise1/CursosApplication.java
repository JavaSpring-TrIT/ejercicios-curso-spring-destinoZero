package com.cursos.exercise1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.cursos.model")
@EnableJpaRepositories(basePackages = "com.cursos.dao")
@SpringBootApplication(scanBasePackages = {"com.cursos.controller", "com.cursos.service", "com.cursos.exercise1"})
public class CursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursosApplication.class, args);
	}

}
