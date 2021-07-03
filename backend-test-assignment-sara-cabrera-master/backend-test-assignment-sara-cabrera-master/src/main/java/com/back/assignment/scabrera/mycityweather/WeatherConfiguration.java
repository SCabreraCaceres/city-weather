package com.back.assignment.scabrera.mycityweather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WeatherConfiguration {

  @Bean
  RestTemplate restTemplate(@Value("${owUrl}") String url) {
    return new RestTemplateBuilder().rootUri(url).build();
  }
}
