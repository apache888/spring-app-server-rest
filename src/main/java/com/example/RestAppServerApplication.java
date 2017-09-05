package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class RestAppServerApplication {

	public static void main(String[] args) {
//		SpringApplication.run(RestAppServerApplication.class, args);

		SpringApplication app = new SpringApplication(RestAppServerApplication.class);
		app.setRegisterShutdownHook(false);
		app.run(args);
	}

	@Bean
	public WebMvcConfigurer corsConfig(){
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:4200")
						.allowCredentials(true)
						.allowedMethods("*")
						.allowedHeaders("*")
//						.exposedHeaders("Errors", "Content-Type","Access-Control-", "X-Auth-Token")
						.maxAge(7200);
			}
		};
	}
}
