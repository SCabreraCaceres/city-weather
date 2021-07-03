package com.back.assignment.scabrera.mycityweather;

import com.back.assignment.scabrera.mycityweather.domain.Weather;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MyCityWeatherApplicationTestIT {

  public static final String CITY_NAME = "Madrid";

  @Autowired
  TestRestTemplate client;

  @Test
	void endpointReturnsWeatherInfo() {

    ResponseEntity<Weather> weatherByCity = client.getForEntity(format("/v1/weather/city/%s", CITY_NAME), Weather.class);

    assertNotNull(weatherByCity.getBody().getTitle());
  }

}
