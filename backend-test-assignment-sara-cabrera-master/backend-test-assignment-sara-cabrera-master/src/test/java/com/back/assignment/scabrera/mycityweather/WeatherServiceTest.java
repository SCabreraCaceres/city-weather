package com.back.assignment.scabrera.mycityweather;

import com.back.assignment.scabrera.mycityweather.domain.Weather;
import com.back.assignment.scabrera.mycityweather.infra.openweather.OpenWeatherDTO;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {

  private static final String CITY = "CITY";
  private static final String TITLE = "TITLE";
  private static final String URL = "/data/2.5/weather?q={q}&appid={appid}";
  private static final Object API_KEY = "c2395dafd752b24690e1cdd50b5a6972";

  @Mock
  RestTemplate restTemplate;

  @InjectMocks
  private WeatherService weatherService;

  @Test
  void apiKeyNotValid() {
    given(restTemplate.getForObject(URL, OpenWeatherDTO.class, CITY, API_KEY))
        .willThrow(new HttpClientErrorException(UNAUTHORIZED));

    assertThrows(HttpClientErrorException.class, () -> weatherService.getWeatherByCity(CITY));
  }

  @Test
  void cityDoesNotExist() {
    given(restTemplate.getForObject(URL, OpenWeatherDTO.class, CITY, API_KEY)).willReturn(null);

    Optional<Weather> actualWeather = weatherService.getWeatherByCity(CITY);

    assertEquals(Optional.empty(), actualWeather);
  }

  @Test
  void retrievesCityWeather() {
    Weather expectedWeather = Weather.builder().title(TITLE).build();
    given(restTemplate.getForObject(URL, OpenWeatherDTO.class, CITY, API_KEY)).willReturn(openWeatherResponse());

    Optional<Weather> actualWeather = weatherService.getWeatherByCity(CITY);

    assertEquals(expectedWeather, actualWeather.get());
  }

  private OpenWeatherDTO openWeatherResponse() {
    OpenWeatherDTO dto = new OpenWeatherDTO();
    var weather = new com.back.assignment.scabrera.mycityweather.infra.openweather.Weather();
    weather.main = TITLE;
    dto.weather = new ArrayList<>();
    dto.weather.add(weather);
    return dto;
  }

}