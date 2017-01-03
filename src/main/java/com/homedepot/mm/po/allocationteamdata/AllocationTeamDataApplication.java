package com.homedepot.mm.po.allocationteamdata;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * AllocationTeamDataApplication is the main class for data retrieval for
 * Transload application.
 * 
 * @see <a href=
 *      "http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api">Swagger2
 *      reference link</a>
 * 
 * 
 * @author axd8472
 *
 */
@SpringBootApplication
@EnableSwagger2
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAutoConfiguration
public class AllocationTeamDataApplication {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(AllocationTeamDataApplication.class, args);
	}

	/**
	 * 
	 * @return
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	/**
	 * 
	 * @return
	 */
	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}

	/**
	 * 
	 * @return
	 */
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}

	/**
	 * 
	 * @return
	 */
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
		source.setBasenames("classpath:i18n/message");
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}
}
