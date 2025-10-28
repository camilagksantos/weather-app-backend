package com.study.weather_app_backend.httpClient;

import com.study.weather_app_backend.model.WeatherData;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface WeatherApiClient {
    @GetExchange("/weather")
    WeatherData getWeatherByCity(@RequestParam("q") String city,
                                 @RequestParam("appid") String apiKey,
                                 @RequestParam("units") String units);
}
