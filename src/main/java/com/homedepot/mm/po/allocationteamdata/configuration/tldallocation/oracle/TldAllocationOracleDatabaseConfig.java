/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.configuration.tldallocation.oracle;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author gxk8870
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "tldAllocationOracleEntityManagerFactory", transactionManagerRef = "transactionManager", basePackages = {
		"com.homedepot.mm.po.allocationteamdata.repository.tldallocation.oracle" })
public class TldAllocationOracleDatabaseConfig {

	@Bean(name = "tldAllocationOracleDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.tldallocation.oracle")
	public DataSource oracleDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "tldAllocationOracleVendorAdapter")
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adaptor = new HibernateJpaVendorAdapter();
		adaptor.setShowSql(true);
		adaptor.setGenerateDdl(false);
		adaptor.setDatabasePlatform("org.hibernate.dialect.Oracle10gDialect");
		return adaptor;
	}

	@Bean(name = "tldAllocationOracleEntityManagerFactory")
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(oracleDataSource());
		lef.setJpaVendorAdapter(jpaVendorAdapter());
		lef.setPackagesToScan("com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle");
		lef.setPersistenceUnitName("tldAllocationOraclePersistenceUnit");
		lef.afterPropertiesSet();
		return lef.getObject();
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("tldAllocationOracleEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
