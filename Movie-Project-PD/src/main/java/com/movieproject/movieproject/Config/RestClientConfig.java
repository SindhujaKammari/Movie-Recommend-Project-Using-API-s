package com.movieproject.movieproject.Config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.client.RestClient;



@Configuration
public class RestClientConfig {

    @Bean
    public RestClient omdbRestClient() {
        return RestClient.builder()
                .baseUrl("https://www.omdbapi.com") // The base website address
                .build();
    }
}
