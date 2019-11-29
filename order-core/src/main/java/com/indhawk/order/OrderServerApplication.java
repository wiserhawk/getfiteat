package com.indhawk.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan({"com.indhawk.order"})
public class OrderServerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OrderServerApplication.class, args);
	}

}
