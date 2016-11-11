package com.homedepot.mm.po.allocationteamdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.homedepot.mm.po.allocationteamdata" })
public class AllocationTeamDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllocationTeamDataApplication.class, args);
	}

}
