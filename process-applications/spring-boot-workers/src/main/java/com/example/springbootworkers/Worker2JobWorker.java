package com.example.springbootworkers;

import io.camunda.client.annotation.JobWorker;
import java.time.Instant;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Worker2JobWorker {

  private static final Logger LOG = LoggerFactory.getLogger(Worker2JobWorker.class);

  @JobWorker(name = "worker2", type = "worker2")
  public Map<String, Object> handle() {
    LOG.info("worker2 executing");
    return Map.of("worker2result", "worker2 executed at " + Instant.now());
  }
}
