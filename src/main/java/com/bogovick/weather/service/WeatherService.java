package com.bogovick.weather.service;

import com.bogovick.weather.repository.WeatherRepository;
import com.bogovick.weather.repository.model.WeatherModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeatherService {

  private final WeatherRepository weatherRepository;

  public Optional<WeatherModel> getWeather(
      final Double longitude,
      final Double latitude,
      final LocalDateTime date) {
    Assert.notNull(longitude, "longitude must be a set");
    Assert.notNull(latitude, "latitude must be a set");

    return weatherRepository.getWeather(
        longitude,
        latitude,
        date == null ? LocalDateTime.now() : date
    );
  }
}
