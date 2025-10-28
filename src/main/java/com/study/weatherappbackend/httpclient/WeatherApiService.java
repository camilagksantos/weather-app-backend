package com.study.weatherappbackend.httpclient;

import com.study.weatherappbackend.model.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeatherApiService {

    private final WeatherApiClient weatherApiClient;
    private final String apiKey;

    public WeatherApiService(WeatherApiClient weatherApiClient,
                             @Value("${openweather.api.key}") String apiKey) {
        this.weatherApiClient = weatherApiClient;
        this.apiKey = apiKey;
    }

    public WeatherData fetchWeatherData(String city) {
        return weatherApiClient.getWeatherByCity(city, apiKey, "metric");
    }
}
