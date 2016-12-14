/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author gxk8870
 *
 */
@Component
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "h2EntityManagerFactory", transactionManagerRef = "h2TransactionManager", basePackages = {
		"com.homedepot.mm.po.allocationteamdata.repository" })
public class H2Configuration {

	@Bean
	public DataSource h2DataDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:h2:mem:test;MODE=Oracle;DB_CLOSE_DELAY=-1");
		dataSource.setUsername("sa");
		dataSource.setDriverClassName("org.h2.Driver");
		return dataSource;

	}

	@Bean(name = "h2VendorAdapter")
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adaptor = new HibernateJpaVendorAdapter();
		adaptor.setShowSql(false);
		adaptor.setGenerateDdl(false);
		adaptor.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
		return adaptor;
	}

	@Bean(name = "h2EntityManagerFactory")
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(h2DataDataSource());
		lef.setJpaVendorAdapter(jpaVendorAdapter());
		lef.setPackagesToScan("com.homedepot.mm.po.allocationteamdata.entities");
		lef.setPersistenceUnitName("h2PersistenceUnit");
		lef.afterPropertiesSet();
		return lef.getObject();
	}

	@Bean(name = "h2TransactionManager")
	public PlatformTransactionManager barTransactionManager(
			@Qualifier("h2EntityManagerFactory") EntityManagerFactory h2EntityManagerFactory) {
		return new JpaTransactionManager(h2EntityManagerFactory);
	}

}
