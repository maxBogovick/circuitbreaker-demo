package com.bogovick.weather.client.model;

import java.time.LocalDateTime;

public record WeatherApiResponse(LocalDateTime date, String value) {
}
