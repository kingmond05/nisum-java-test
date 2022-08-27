package com.nisum.javaevaluation;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.nisum.javaevaluation.controllers.AppUserController;
import com.nisum.javaevaluation.services.AppUserService;
import com.nisum.javaevaluation.services.PhoneService;
import com.nisum.javaevaluation.utils.SecuritySupports;

@SpringBootApplication
@ComponentScan(basePackageClasses = AppUserController.class)
public class JavaevaluationApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaevaluationApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	@Bean
	public SecuritySupports securitySupport() {
	    return new SecuritySupports();
	}
	
	@Bean
	public AppUserService appUserService() {
	    return new AppUserService();
	}
	
	@Bean
	public PhoneService phoneService() {
	    return new PhoneService();
	}
}
