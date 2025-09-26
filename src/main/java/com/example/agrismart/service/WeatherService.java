package com.example.agrismart.service;

import com.example.agrismart.model.User;
import com.example.agrismart.model.mapper.WeatherMapper;
import com.example.agrismart.model.weather.WeatherApiResponse;
import com.example.agrismart.model.weather.WeatherResponseDto;
import com.example.agrismart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {

  @Autowired
  private UserRepository userRepository; // use this name everywhere


  @Value("${weather.api.key}")
  private String apiKey;

  @Value("${weather.api.url}")
  private String apiUrl;

  private final RestTemplate restTemplate = new RestTemplate();

  public WeatherResponseDto getWeather(String username) {
    User user = userRepository.findByUsername(username)
      .orElseThrow(() -> new RuntimeException("User not found"));
    WeatherApiResponse weatherResponse = getWeatherByCity(user.getLocationCity());
    WeatherResponseDto weatherResponseDto = WeatherMapper.mapToWeatherDto(weatherResponse,  new WeatherResponseDto());
    return weatherResponseDto;
  }

  public WeatherApiResponse getWeatherByCity(String city) {
    String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
      .queryParam("key", apiKey)
      .queryParam("q", city)
      .queryParam("aqi", "yes") // optional
      .toUriString();

    return restTemplate.getForObject(url, WeatherApiResponse.class);
  }
}
