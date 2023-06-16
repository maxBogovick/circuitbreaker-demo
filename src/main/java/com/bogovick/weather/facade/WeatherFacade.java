package com.bogovick.weather.facade;

import com.bogovick.weather.client.ExternalWeatherApi;
import com.bogovick.weather.controller.model.WeatherRequest;
import com.bogovick.weather.controller.model.WeatherResponse;
import com.bogovick.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeatherFacade {

  private final WeatherService weatherService;
  private final ExternalWeatherApi externalWeatherApi;

  public WeatherResponse getWeather(WeatherRequest request) {
    return
        weatherService.getWeather(request.longitude(), request.latitude(), request.date())
            .map(weatherModel ->
                new WeatherResponse(weatherModel.date(), weatherModel.temperature() + weatherModel.type().name())
            )
            .orElse(getExternalWeatherApi(request));
  }

  private WeatherResponse getExternalWeatherApi(final WeatherRequest request) {
    return
        Optional.ofNullable(externalWeatherApi.getWeather(request.longitude(), request.latitude()))
            .map(response -> new WeatherResponse(response.date(), response.value()))
            .orElse(WeatherResponse.empty());
  }
}
