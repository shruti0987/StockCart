package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configuration
@EnableSwagger2
@EnableAutoConfiguration //(exclude = {DataSourceAutoConfiguration.class })
@EnableJpaRepositories("/StockCart/src/main/java/repository")
public class Demo3Application extends SpringBootServletInitializer {

	private static final Class<Demo3Application> applicationClass = Demo3Application.class;
    private static final Logger log = LoggerFactory.getLogger(applicationClass);
	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
	}
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(applicationClass);
	    }
}
