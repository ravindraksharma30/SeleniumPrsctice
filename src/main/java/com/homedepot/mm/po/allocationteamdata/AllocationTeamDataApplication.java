package com.homedepot.mm.po.allocationteamdata;

import org.springframework.boot.SpringApplication;
<<<<<<< HEAD:src/main/java/com/homedepot/mm/po/allocation/AllocationTeamDataApplication.java
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
=======
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.homedepot.mm.po.allocationteamdata" })
>>>>>>> 021fcd067904e78be03f673dc2c79f6cbb4a868d:src/main/java/com/homedepot/mm/po/allocationteamdata/AllocationTeamDataApplication.java
public class AllocationTeamDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllocationTeamDataApplication.class, args);
	}
<<<<<<< HEAD:src/main/java/com/homedepot/mm/po/allocation/AllocationTeamDataApplication.java

}
=======
}
>>>>>>> 021fcd067904e78be03f673dc2c79f6cbb4a868d:src/main/java/com/homedepot/mm/po/allocationteamdata/AllocationTeamDataApplication.java
