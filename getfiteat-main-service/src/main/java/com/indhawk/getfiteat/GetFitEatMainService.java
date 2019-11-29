package com.indhawk.getfiteat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan({"com.indhawk.getfiteat"})
@EnableScheduling
public class GetFitEatMainService {

	
	public static void main(String[] args) {
		SpringApplication.run(GetFitEatMainService.class, args);

	}
}
