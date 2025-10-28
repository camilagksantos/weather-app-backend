package com.study.weather_app_backend.service;

import com.study.weather_app_backend.dto.WeatherDataResponseDto;
import com.study.weather_app_backend.httpClient.WeatherApiService;
import com.study.weather_app_backend.model.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherDataService {

    @Autowired
    private WeatherApiService weatherApiService;

    public WeatherDataResponseDto getWeatherData(String city) {
        WeatherData weatherData = weatherApiService.fetchWeatherData(city);
        return new WeatherDataResponseDto(weatherData);
    }
}
