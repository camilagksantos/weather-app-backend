package com.study.weather_app_backend.controller;

import com.study.weather_app_backend.dto.WeatherDataResponseDto;
import com.study.weather_app_backend.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "http://localhost:3000")
public class WeatherDataController {
    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping
    public ResponseEntity<WeatherDataResponseDto> getWeather(@RequestParam String city) {
        WeatherDataResponseDto weatherData = weatherDataService.getWeatherData(city);
        return ResponseEntity.ok(weatherData);
    }
}
