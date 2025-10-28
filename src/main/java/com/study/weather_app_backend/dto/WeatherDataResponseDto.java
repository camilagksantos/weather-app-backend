package com.study.weather_app_backend.dto;

import com.study.weather_app_backend.model.WeatherData;

public class WeatherDataResponseDto {
    private WeatherData data;

    public WeatherDataResponseDto(WeatherData data) {
        this.data = data;
    }

    public WeatherData getData() {
        return data;
    }

    public void setData(WeatherData data) {
        this.data = data;
    }
}
