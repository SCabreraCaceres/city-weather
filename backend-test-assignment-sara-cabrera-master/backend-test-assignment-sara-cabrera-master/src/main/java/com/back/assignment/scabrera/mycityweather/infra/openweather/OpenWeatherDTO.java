package com.back.assignment.scabrera.mycityweather.infra.openweather;

import java.util.List;

public class OpenWeatherDTO {
  public Coord coord;
  public List<Weather> weather;
  public String base;
  public Main main;
  public int visibility;
  public Wind wind;
  public Clouds clouds;
  public int dt;
  public Sys sys;
  public int timezone;
  public int id;
  public String name;
  public int cod;
}
