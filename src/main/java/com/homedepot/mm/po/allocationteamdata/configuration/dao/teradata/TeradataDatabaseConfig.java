package com.homedepot.mm.po.allocationteamdata.configuration.dao.teradata;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "teradataEntityManagerFactory", 
        transactionManagerRef = "teradataTransactionManager",
        basePackages = { "com.homedepot.mm.po.allocationteamdata.repository.teradata" })
public class TeradataDatabaseConfig {

    /*@Autowired
    JpaVendorAdapter jpaVendorAdapter;*/

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
	
	@Bean(name = "teradataDataSource")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(qaUrl);
		dataSource.setUsername(qaUsername);
		dataSource.setPassword(qaPassword);
		dataSource.setDriverClassName(driverClassName);
		return dataSource;
	}
	
	@Bean(name = "teradataVendorAdapter")
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adaptor = new HibernateJpaVendorAdapter();
        adaptor.setShowSql(false);
        adaptor.setGenerateDdl(false);
        //adaptor.setDatabase(Da);
        adaptor.setDatabasePlatform("org.hibernate.dialect.TeradataDialect");
        return adaptor;
    }

    @Bean(name = "teradataEntityManager")
    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
    }

    @Bean(name = "teradataEntityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(dataSource());
        lef.setJpaVendorAdapter(jpaVendorAdapter());
        lef.setPackagesToScan("com.homedepot.mm.po.allocationteamdata.entities.teradata");
        lef.setPersistenceUnitName("teradataPersistenceUnit");
        lef.afterPropertiesSet();
        return lef.getObject();
    }

    @Bean(name = "teradataTransactionManager")
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }

}