package com.study.weatherappbackend.model.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {

    @JsonProperty("feels_like")
    private Double feelsLike;

    @JsonProperty("temp_min")
    private Double tempMin;

    @JsonProperty("temp_max")
    private Double tempMax;
}
