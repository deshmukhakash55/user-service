package com.xperphile.userservice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.xperphile.userservice.dao", "com.xperphile.userservice.controller", "com.xperphile.userservice.service", "com.xperphile.userservice.constants", "com.xperphile.userservice.listener", "com.xperphile.userservice.configuration", "com.xperphile.userservice.utility", "com.xperphile.userservice.repository"})
@EntityScan(basePackages = {"com.xperphile.userservice.dao"} )
@EnableJpaRepositories(basePackages = {"com.xperphile.userservice.repository"})
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
