package com.homedepot.mm.po.allocationteamdata.configuration.teradata;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "teradataEntityManagerFactory", basePackages = {
		"com.homedepot.mm.po.allocationteamdata.repository.teradata" })
public class TeradataDatabaseConfig {

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.teradata")
	public DataSource teraDataDataSource() {
		return DataSourceBuilder.create().password(System.getProperty("TeradataPassword")).build();
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