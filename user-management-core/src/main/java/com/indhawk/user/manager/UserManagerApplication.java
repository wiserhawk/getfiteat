package com.indhawk.user.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan({"com.indhawk.user.manager"})
public class UserManagerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(UserManagerApplication.class, args);
	}

}
