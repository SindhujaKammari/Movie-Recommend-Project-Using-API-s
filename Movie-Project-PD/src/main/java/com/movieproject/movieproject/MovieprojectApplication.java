package com.movieproject.movieproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(OmdbProperties.class)
public class MovieprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieprojectApplication.class, args);
	}

}
