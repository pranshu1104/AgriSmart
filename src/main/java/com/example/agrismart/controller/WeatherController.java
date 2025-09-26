package com.example.agrismart.controller;

import com.example.agrismart.model.weather.WeatherResponseDto;
import com.example.agrismart.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

  private final WeatherService weatherService;

  public WeatherController(WeatherService weatherService) {
    this.weatherService = weatherService;
  }

  @GetMapping("/user/{username}")
  public ResponseEntity<WeatherResponseDto> getWeatherForUser(@PathVariable String username) {
    WeatherResponseDto response = weatherService.getWeather(username);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}

