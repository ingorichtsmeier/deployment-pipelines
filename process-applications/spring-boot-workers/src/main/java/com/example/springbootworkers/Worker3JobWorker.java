package com.example.springbootworkers;

import io.camunda.client.annotation.JobWorker;
import java.time.Instant;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Worker3JobWorker {

  private static final Logger LOG = LoggerFactory.getLogger(Worker3JobWorker.class);

  @JobWorker(name = "worker3", type = "worker3")
  public Map<String, Object> handle() {
    LOG.info("worker3 executing");
    return Map.of("worker3result", "worker3 executed at " + Instant.now());
  }
}
