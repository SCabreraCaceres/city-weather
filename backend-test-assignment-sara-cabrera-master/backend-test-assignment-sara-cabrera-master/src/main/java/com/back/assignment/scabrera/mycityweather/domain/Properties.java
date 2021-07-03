package com.back.assignment.scabrera.mycityweather.domain;

import com.back.assignment.scabrera.mycityweather.domain.property.Condition;
import com.back.assignment.scabrera.mycityweather.domain.property.Temperature;
import com.back.assignment.scabrera.mycityweather.domain.property.WindSpeed;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Properties {
  Condition condition;
  Temperature temperature;
  WindSpeed windSpeed;
}
