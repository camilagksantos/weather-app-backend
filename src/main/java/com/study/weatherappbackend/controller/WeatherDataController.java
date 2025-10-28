package com.study.weatherappbackend.controller;

import com.study.weatherappbackend.dto.WeatherDataResponseDto;
import com.study.weatherappbackend.service.WeatherDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "http://localhost:3000")
public class WeatherDataController {

    private WeatherDataService weatherDataService;

    public WeatherDataController(WeatherDataService weatherDataService) {
        this.weatherDataService = weatherDataService;
    }

    @GetMapping
    public ResponseEntity<WeatherDataResponseDto> getWeather(@RequestParam String city) {
        WeatherDataResponseDto weatherData = weatherDataService.getWeatherData(city);
        return ResponseEntity.ok(weatherData);
    }
}
