package com.back.assignment.scabrera.mycityweather;

import com.back.assignment.scabrera.mycityweather.domain.Weather;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@ExtendWith(MockitoExtension.class)
class WeatherControllerTest {

  private static final String CITY = "CITY";
  private static final String TITLE = "TITLE";

  @Mock
  private WeatherService weatherService;

  @InjectMocks
  private WeatherController weatherController;

  @Test
  void invalidApiData(){
    given(weatherService.getWeatherByCity(CITY)).willThrow(new HttpClientErrorException(UNAUTHORIZED));

    assertEquals(ResponseEntity.notFound().build(), weatherController.getWeatherByCity(CITY));
  }

  @Test
  void retrievesCityWeather(){
    Weather weather = Weather.builder().title(TITLE).build();
    given(weatherService.getWeatherByCity(CITY)).willReturn(Optional.of(weather));

    assertEquals(ResponseEntity.ok(weather), weatherController.getWeatherByCity(CITY));
  }
}
