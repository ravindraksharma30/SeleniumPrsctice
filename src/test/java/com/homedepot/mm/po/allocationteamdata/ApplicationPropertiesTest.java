package com.homedepot.mm.po.allocationteamdata;

import org.springframework.beans.factory.annotation.Value;

public class ApplicationPropertiesTest {
	
	 @Value("${spring.datasource.qa.url}")
	private String qaUrl;
	@Value("${spring.datasource.qa.username}")
	private String qaUsername;
	@Value("${spring.datasource.qa.password}")
	private String qaPassword;
	@Value("${spring.datasource.driverClassName}")
	private String driverClassName;
	@Value("${spring.jpa.database-platform}")
	private String databasePlatform;

}
