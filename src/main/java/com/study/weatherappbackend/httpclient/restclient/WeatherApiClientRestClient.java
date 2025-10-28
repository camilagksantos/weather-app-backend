package com.study.weatherappbackend.httpclient.restclient;

import com.study.weatherappbackend.exception.WeatherApiException;
import com.study.weatherappbackend.model.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class WeatherApiClientRestClient {

    @Value("${openweather.api.url}")
    private String baseUrl;

    @Value("${openweather.api.key}")
    private String apiKey;

    private final RestClient restClient;

    public WeatherApiClientRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public WeatherData getWeatherByCity(String city) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/weather")
                        .queryParam("q", city)
                        .queryParam("appid", apiKey)
                        .queryParam("units", "metric")
                        .build())
                .retrieve()
                .body(WeatherData.class);
    }

    public WeatherData getWeatherByCityWithErrorHandling(String city) {
        return restClient.get()
                .uri("/weather?q={city}&appid={key}&units=metric", city, apiKey)
                .retrieve()
                .onStatus(status -> status.value() == 404,
                        (request, response) -> {
                            throw new WeatherApiException("City not found: " + city);
                        })
                .body(WeatherData.class);
    }
}
