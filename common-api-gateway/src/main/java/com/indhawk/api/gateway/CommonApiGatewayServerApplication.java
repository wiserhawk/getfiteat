package com.indhawk.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan({"com.indhawk.api.gateway"})
public class CommonApiGatewayServerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CommonApiGatewayServerApplication.class, args);
	}

}
