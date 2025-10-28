package com.study.weatherappbackend.service;

import com.study.weatherappbackend.dto.WeatherDataResponseDto;
import com.study.weatherappbackend.httpclient.WeatherApiService;
import com.study.weatherappbackend.model.WeatherData;
import org.springframework.stereotype.Service;

@Service
public class WeatherDataService {
    private WeatherApiService weatherApiService;

    public WeatherDataService(WeatherApiService weatherApiService) {
        this.weatherApiService = weatherApiService;
    }

    public WeatherDataResponseDto getWeatherData(String city) {
        WeatherData weatherData = weatherApiService.fetchWeatherData(city);
        return new WeatherDataResponseDto(weatherData);
    }
}
