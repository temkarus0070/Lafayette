package com.example.workflow;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.impl.scripting.engine.ScriptingEngines;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }

}