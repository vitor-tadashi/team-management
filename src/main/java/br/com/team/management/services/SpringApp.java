package br.com.team.management.services;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
public class SpringApp extends SpringBootServletInitializer implements WebApplicationInitializer {

	/**
	 * Start via Spring Boot
	 * @param args
	 */
	public static void main(String[] args) {
		new SpringApp()
				.configure(new SpringApplicationBuilder(SpringApp.class))
				.run(args);
	}
}
