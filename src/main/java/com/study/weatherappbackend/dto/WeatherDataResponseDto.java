package com.study.weatherappbackend.dto;

import com.study.weatherappbackend.model.WeatherData;

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
