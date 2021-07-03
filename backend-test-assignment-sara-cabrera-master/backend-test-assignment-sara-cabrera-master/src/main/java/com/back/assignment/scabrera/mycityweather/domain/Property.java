package com.back.assignment.scabrera.mycityweather.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Data
public class Property {
  String type;
  String description;
}
