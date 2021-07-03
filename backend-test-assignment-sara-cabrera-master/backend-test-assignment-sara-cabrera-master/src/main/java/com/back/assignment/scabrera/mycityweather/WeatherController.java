package com.back.assignment.scabrera.mycityweather;

import com.back.assignment.scabrera.mycityweather.domain.Weather;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/weather")
@Slf4j
public class WeatherController {

  private final WeatherService weatherService;

  @GetMapping("/city/{cityName}")
  public ResponseEntity<Weather> getWeatherByCity(@PathVariable String cityName) {
    try {
      return weatherService.getWeatherByCity(cityName)
          .map(toLog())
          .map(ResponseEntity::ok)
          .orElseGet(() -> ResponseEntity.notFound().build());
    } catch (HttpClientErrorException exception) {
      log.error("Api request failed, exception: ", exception);
      return ResponseEntity.notFound().build();
    }
  }

  private Function<Weather, Weather> toLog() {
    return weather -> {
      log.info("Your current weather is: {}", weather);
      return weather;
    };
  }
}
