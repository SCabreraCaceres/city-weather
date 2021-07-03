# Getting Started

This application retrieves the weather information of a given city from an open source at 
[https://openweathermap.org](https://openweathermap.org/current).
It runs on Java 11 and Maven 3.6.3.

Intellij: To run **My city weather** you can use a Spring Boot run configuration or simply click on the run button
in class MyCityWeatherApplication.java.

To run it from a terminal you can use `mvn spring-boot:run`.

The entry endpoint is a GET localhost:8080/v1/weather/city/[yourcityname] that you can call from Postman, Talend API or
using a curl from a terminal. Also running this test MyCityWeatherApplicationTestIT you can see the output from 
the endpoint in the console.

## SWAGGER
* API documentation: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
* API definitions yaml: [http://localhost:8080/api-docs.yaml](http://localhost:8080/api-docs.yaml)
* OpenAPI descriptions: [http://localhost:8080/api-docs/](http://localhost:8080/api-docs/)


### Want to dive in the used technologies?
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.1/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.1/reference/htmlsingle/#boot-features-developing-web-applications)
* [Testcontainers](https://www.testcontainers.org/)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)





# Backend Developer Test Assignment

## Goal
The goal of this test assignment is to write a Spring Boot application in Java which returns the current weather information for a city using the OpenWeather API.

## OpenWeather API
Please use the current open weather API https://openweathermap.org/current
with the following API_KEY: c2395dafd752b24690e1cdd50b5a6972

## Requirements
- Please create a compilable Spring Boot application using maven or gradle.
- Please spend no more than 3 hours on the task. Incomplete solutions are also welcomed.

### Task - Weather API
Please create a Web Application which should:
- Accept a city name via REST API
- Get the current weather for the city name using the OpenWeather API
- Return the response as JSON following this **[JSON schema](https://json-schema.org/)**:
```
{
  "title": "Weather",
  "type": "object",
  "properties": {
    "condition": {
      "type": "string",
      "description": "The description of the weather. eg: scattered clouds."
    },
    "temperature": {
      "type": "number",
      "description": "The actual temperature of the city in celsius."
    },
    "wind_speed": {
      "type": "number",
      "description": "Speed of the wind in km/h.",
      "minimum": 0
    }
  }
}
```
- Please write tests or describe the testing approach you would do
- Validate the input of the REST API allow only meaningful data and handle invalid requests.

### Bonus Task
- Create an OpenAPI Specification with Swagger
- Optimize the performance e.g.: introducing cache

## Guidelines
Implement the solution you think is the best:
- follow REST API guidelines
- follow clean code practices
- rely on Spring Boot and it's dependency management

## Share your solution
Please create a Pull Request when you are ready, so we can review it.

**Have fun with the exercise 🏃 and again don't worry if you don't finish everything, our main intention
is to see how you work and to talk to you about the ideas and concepts 📚 you followed.**
