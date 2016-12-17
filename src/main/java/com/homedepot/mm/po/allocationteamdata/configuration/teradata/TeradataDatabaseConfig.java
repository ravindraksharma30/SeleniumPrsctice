package com.homedepot.mm.po.allocationteamdata.configuration.teradata;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "teradataEntityManagerFactory", basePackages = {
		"com.homedepot.mm.po.allocationteamdata.repository.teradata" })
@Slf4j
public class TeradataDatabaseConfig {
	@Value("${spring.datasource.teradata.url}")
	private String url;
	@Value("${spring.datasource.teradata.username}")
	private String username;
	@Value("${spring.datasource.teradata.driverClassName}")
	private String driverClassName;
	
	@Bean
	@Primary
	//@ConfigurationProperties(prefix = "spring.datasource.teradata")
	public DataSource teraDataDataSource() {
		log.info("HODORRRRR" + System.getenv("TeradataPassword"));
		log.info("HODORRRRR" + System.getenv());

		return DataSourceBuilder.create()
				.url(url)
				.username(username)
				.password(System.getenv("TeradataPassword"))
				.driverClassName(driverClassName)
				.build();
	}

	@Bean(name = "teradataVendorAdapter")
	@Primary
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adaptor = new HibernateJpaVendorAdapter();
		adaptor.setShowSql(true);
		adaptor.setGenerateDdl(false);
		adaptor.setDatabasePlatform("org.hibernate.dialect.TeradataDialect");
		return adaptor;
	}

	@Bean(name = "teradataEntityManagerFactory")
	@Primary
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(teraDataDataSource());
		lef.setJpaVendorAdapter(jpaVendorAdapter());
		lef.setPackagesToScan("com.homedepot.mm.po.allocationteamdata.entities.teradata");
		lef.setPersistenceUnitName("teradataPersistenceUnit");
		lef.afterPropertiesSet();
		return lef.getObject();
	}

}