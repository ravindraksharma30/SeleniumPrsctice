package com.homedepot.mm.po.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("qa")
public class JDBCConfiguration {

	@Value("${jdbc.qa.url}")
	private String url;
	@Value("${jdbc.qa.driver}")
	private String driver;
	@Value("${jdbc.qa.username}")
	private String username;
	@Value("${jdbc.qa.password}")
	private String password;
	
	@Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
	
}

