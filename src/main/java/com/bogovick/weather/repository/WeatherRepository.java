package com.bogovick.weather.repository;

import com.bogovick.weather.repository.model.TemperatureType;
import com.bogovick.weather.repository.model.WeatherModel;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Random;

@Component
public class WeatherRepository {


  private final Random random = new Random();


  public Optional<WeatherModel> getWeather(final Double longitude,
                                           final Double latitude,
                                           final LocalDateTime date) {
    if (longitude > 20D && latitude > 20D) {
      return Optional.of(new WeatherModel(date.truncatedTo(ChronoUnit.HOURS), random.nextDouble(40d), TemperatureType.C));
    } else {
      return Optional.empty();
    }
  }
}
