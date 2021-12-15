package com.ADRA;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ADRA.service.CapacitacionService;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableSwagger2
public class AdraApplication implements CommandLineRunner {
	
	@Resource
	CapacitacionService capaService; 

	public static void main(String[] args) {
		SpringApplication.run(AdraApplication.class, args);
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ADRA")).build();
	} 
	
	
	@Override
	public void run(String... arg) throws Exception{
		capaService.deleteAll();
		capaService.init();
	}
	
	/* En caso que tenga problema con los cors agregar este Bean */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
			}
		};
	}
	
}
