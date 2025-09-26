package com.example.agrismart.model.weather;

import lombok.Data;

@Data
public class AirQuality {
    private double pm2_5;
    private double pm10;
    private int usEpaIndex;
}
