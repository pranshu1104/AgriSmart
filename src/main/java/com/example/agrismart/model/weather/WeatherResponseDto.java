package com.example.agrismart.model.weather;

import lombok.Data;

@Data
public class WeatherResponseDto {
  private double tempC;
  private double tempF;
  private int humidity;
  private double windKph;
  private double precipMm;
  private String conditionText;
  private AirQuality airQuality;
}
