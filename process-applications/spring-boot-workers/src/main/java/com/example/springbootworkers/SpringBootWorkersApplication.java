package com.example.springbootworkers;

import io.camunda.client.annotation.Deployment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Deployment(resources = "classpath*:processes/*.bpmn")
public class SpringBootWorkersApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootWorkersApplication.class, args);
  }
}
