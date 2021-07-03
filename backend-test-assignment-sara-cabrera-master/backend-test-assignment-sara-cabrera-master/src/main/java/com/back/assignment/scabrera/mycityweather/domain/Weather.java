package com.back.assignment.scabrera.mycityweather.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Weather {

  String title;
  String type;
  Properties properties;

}
