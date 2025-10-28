package com.study.weatherappbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.study.weatherappbackend")
public class WeatherAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherAppBackendApplication.class, args);
	}

}
