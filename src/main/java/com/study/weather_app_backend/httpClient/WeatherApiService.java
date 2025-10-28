package com.study.weather_app_backend.httpClient;

import com.study.weather_app_backend.model.WeatherData;
import org.springframework.beans.factory.annotation.Value;

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
