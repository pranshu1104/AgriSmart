package com.example.agrismart.model.weather;

import lombok.Data;

@Data
public class WeatherApiResponse {
    private Current current;

    @Data
    public static class Current {
        private double temp_c;
        private double temp_f;
        private int humidity;
        private double wind_kph;
        private double precip_mm;
        private Condition condition;
        private AirQualityResponse air_quality;
    }

    @Data
    public static class Condition {
        private String text;
    }

    @Data
    public static class AirQualityResponse {
        private double pm2_5;
        private double pm10;
        private int us_epa_index;
    }
}
