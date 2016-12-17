/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.configuration.oracle;

import java.util.TimeZone;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.homedepot.mm.po.allocationteamdata.configuration.teradata.TeradataDatabaseConfig;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gxk8870
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "oracleEntityManagerFactory", basePackages = {
		"com.homedepot.mm.po.allocationteamdata.repository.oracle" })
@Slf4j
public class OracleDatabaseConfig {

	public static final String TIMEZONE_STR = "America/New_York";
	private static final void setUp() {
        TimeZone.setDefault(TimeZone.getTimeZone(TIMEZONE_STR));
	}
	
	@Value("${spring.datasource.oracle.url}")
	private String url;
	@Value("${spring.datasource.oracle.username}")
	private String username;
	@Value("${spring.datasource.oracle.driverClassName}")
	private String driverClassName;
	
	
	@Bean(name = "oracleDataSource")
	//@ConfigurationProperties(prefix = "spring.datasource.oracle")
	public DataSource oracleDataSource() {
		try { 
			setUp();
		return DataSourceBuilder.create()
				.url(url)
				.username(username)
				.password(System.getenv("OraclePassword"))
				.driverClassName(driverClassName)
				.build();
		} catch (Exception e) {
			log.error("Exception occured trying to set up oracle connection: " + e.getMessage());
			return null;
		}
	}

	@Bean(name = "oracleVendorAdapter")
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adaptor = new HibernateJpaVendorAdapter();
		adaptor.setShowSql(true);
		adaptor.setGenerateDdl(false);
		adaptor.setDatabasePlatform("org.hibernate.dialect.Oracle10gDialect");
		return adaptor;
	}

	@Bean(name = "oracleEntityManagerFactory")
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(oracleDataSource());
		lef.setJpaVendorAdapter(jpaVendorAdapter());
		lef.setPackagesToScan("com.homedepot.mm.po.allocationteamdata.entities.oracle");
		lef.setPersistenceUnitName("oraclePersistenceUnit");
		lef.afterPropertiesSet();
		return lef.getObject();
	}

}
