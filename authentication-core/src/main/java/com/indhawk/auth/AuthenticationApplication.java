package com.indhawk.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan({"com.indhawk.auth"})
public class AuthenticationApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

}
