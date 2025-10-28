package com.study.weatherappbackend.httpclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

public class RestClientConfig {
    @Value("${openweather.api.url}")
    private String baseUrl;

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }


}
