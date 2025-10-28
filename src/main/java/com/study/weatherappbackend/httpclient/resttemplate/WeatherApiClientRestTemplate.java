package com.study.weatherappbackend.httpclient.resttemplate;

import com.study.weatherappbackend.model.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class WeatherApiClientRestTemplate {

    @Value("${openweather.api.url}")
    private String baseUrl;

    @Value("${openweather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public WeatherApiClientRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherData getWeatherByCity(String city) {
        String url = UriComponentsBuilder
                .fromUriString(baseUrl + "/weather")
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .queryParam("units", "metric")
                .toUriString();

        return restTemplate.getForObject(url, WeatherData.class);
    }
}
