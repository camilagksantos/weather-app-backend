package com.study.weather_app_backend.model.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {
    private Double temp;

    @JsonProperty("feels_like")
    private Double feelsLike;

    @JsonProperty("temp_min")
    private Double tempMin;

    @JsonProperty("temp_max")
    private Double tempMax;

    private Integer pressure;
    private Integer humidity;
}
