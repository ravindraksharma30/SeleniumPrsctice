package com.homedepot.mm.po.allocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class AllocationTeamDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllocationTeamDataApplication.class, args);
	}

}
