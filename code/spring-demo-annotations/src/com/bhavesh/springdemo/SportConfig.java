package com.bhavesh.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @ComponentScan("com.bhavesh.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	// defining a bean for our SadFortuneService
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// defining a bean for our SwimCoach and inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
