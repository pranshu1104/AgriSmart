package com.example.agrismart.model.mapper;

import com.example.agrismart.model.weather.AirQuality;
import com.example.agrismart.model.weather.WeatherApiResponse;
import com.example.agrismart.model.weather.WeatherResponseDto;

public class WeatherMapper {

  public static WeatherResponseDto mapToWeatherDto(WeatherApiResponse apiResponse, WeatherResponseDto dto) {
    if (apiResponse == null || apiResponse.getCurrent() == null) {
      return dto;
    }
    WeatherApiResponse.Current current = apiResponse.getCurrent();
    dto.setTempC(current.getTemp_c());
    dto.setTempF(current.getTemp_f());
    dto.setHumidity(current.getHumidity());
    dto.setWindKph(current.getWind_kph());
    dto.setPrecipMm(current.getPrecip_mm());
    dto.setConditionText(current.getCondition() != null ? current.getCondition().getText() : null);

    if (current.getAir_quality() != null) {
      AirQuality air = new AirQuality();
      air.setPm2_5(current.getAir_quality().getPm2_5());
      air.setPm10(current.getAir_quality().getPm10());
      air.setUsEpaIndex(current.getAir_quality().getUs_epa_index());
      dto.setAirQuality(air);
    }

    return dto;
  }
}
