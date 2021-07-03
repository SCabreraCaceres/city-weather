package com.back.assignment.scabrera.mycityweather;

import com.back.assignment.scabrera.mycityweather.domain.Properties;
import com.back.assignment.scabrera.mycityweather.domain.Weather;
import com.back.assignment.scabrera.mycityweather.domain.property.Condition;
import com.back.assignment.scabrera.mycityweather.domain.property.Temperature;
import com.back.assignment.scabrera.mycityweather.domain.property.WindSpeed;
import com.back.assignment.scabrera.mycityweather.infra.openweather.OpenWeatherDTO;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WeatherService {

  private static final String API_KEY = "c2395dafd752b24690e1cdd50b5a6972";
  public static final String STRING = "String";
  public static final String NUMBER = "Number";

  private final RestTemplate restTemplate;

  public Optional<Weather> getWeatherByCity(String city) {
    return Optional.ofNullable(getOpenWeatherForecastFor(city))
        .map(this::convert);
  }

  private OpenWeatherDTO getOpenWeatherForecastFor(String city) {
    return restTemplate.getForObject("/data/2.5/weather?q={q}&appid={appid}", OpenWeatherDTO.class, city, API_KEY);
  }

  private Weather convert(OpenWeatherDTO response) {
    return Weather.builder()
        .title(response.weather.get(0).main)
        .type(STRING)
        .properties(buildProperties(response))
        .build();
  }

  private Properties buildProperties(OpenWeatherDTO response) {
    return Properties.builder()
        .condition(buildCondition(response))
        .temperature(buildTemperature(response))
        .windSpeed(buildWindSpeed(response))
        .build();
  }

  private Condition buildCondition(OpenWeatherDTO response) {
    return Condition.builder()
        .type(STRING)
        .description(response.base)
        .build();
  }

  private Temperature buildTemperature(OpenWeatherDTO response) {
    return Temperature.builder()
        .type(NUMBER)
        .description(response.weather.get(0).description)
        .build();
  }

  private WindSpeed buildWindSpeed(OpenWeatherDTO response) {
    return WindSpeed.builder()
        .type(NUMBER)
        .description(response.weather.get(0).description)
        .build();
  }

}
