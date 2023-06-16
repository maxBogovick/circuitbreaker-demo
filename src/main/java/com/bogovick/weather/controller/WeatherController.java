package com.bogovick.weather.controller;

import com.bogovick.weather.controller.model.WeatherRequest;
import com.bogovick.weather.controller.model.WeatherResponse;
import com.bogovick.weather.facade.WeatherFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {

  private final WeatherFacade weatherFacade;

  @PostMapping
  public WeatherResponse getWeather(@RequestBody final WeatherRequest request) {
    return weatherFacade.getWeather(request);
  }
}
