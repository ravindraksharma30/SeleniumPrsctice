/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.configuration.oracle;

import java.util.TimeZone;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.homedepot.mm.po.allocationteamdata.constants.AllocationTeamDataConstants;

/**
 * @author gxk8870
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "oracleEntityManagerFactory", basePackages = {
		"com.homedepot.mm.po.allocationteamdata.repository.oracle" })
public class OracleDatabaseConfig {

	/**
	 * 
	 * @return
	 */
	@Bean(name = "oracleDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.oracle")
	public DataSource oracleDataSource() {
		TimeZone.setDefault(TimeZone.getTimeZone(AllocationTeamDataConstants.TIMEZONE_STR));
		return DataSourceBuilder.create().build();

	}

	/**
	 * 
	 * @return
	 */

	@Bean(name = "oracleVendorAdapter")
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adaptor = new HibernateJpaVendorAdapter();
		adaptor.setShowSql(true);
		adaptor.setGenerateDdl(false);
		adaptor.setDatabasePlatform("org.hibernate.dialect.Oracle10gDialect");
		return adaptor;
	}

	/**
	 * 
	 * @return
	 */
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
