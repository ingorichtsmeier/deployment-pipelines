package com.example.springbootworkers;

import io.camunda.client.annotation.JobWorker;
import java.time.Instant;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Worker1JobWorker {

  private static final Logger LOG = LoggerFactory.getLogger(Worker1JobWorker.class);

  @JobWorker(name = "worker1", type = "worker1")
  public Map<String, Object> handle() {
    LOG.info("worker1 executing");
    return Map.of("worker1result", "worker1 executed at " + Instant.now());
  }
}
