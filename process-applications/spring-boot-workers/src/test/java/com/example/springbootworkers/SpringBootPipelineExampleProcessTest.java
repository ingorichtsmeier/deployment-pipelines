package com.example.springbootworkers;

import static io.camunda.process.test.api.CamundaAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.camunda.client.CamundaClient;
import io.camunda.client.api.response.ProcessInstanceEvent;
import io.camunda.process.test.api.CamundaProcessTestContext;
import io.camunda.process.test.api.CamundaSpringProcessTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Runs the process against a real Camunda 8.8 runtime started by Camunda Process Test (CPT)
 * via Testcontainers/Docker.
 */
@SpringBootTest
@CamundaSpringProcessTest
class SpringBootPipelineExampleProcessTest {

  @Autowired private CamundaClient client;
  @Autowired private CamundaProcessTestContext processTestContext;

  @Test
  void shouldCompleteProcessAndSetWorker1Result() {
    final ProcessInstanceEvent processInstance =
        client
            .newCreateInstanceCommand()
            .bpmnProcessId("spring-boot-pipeline-example")
            .latestVersion()
            .send()
            .join();

    assertThat(processInstance).isCompleted();
    assertThat(processInstance)
        .hasVariableSatisfies(
            "worker1result",
            String.class,
            value -> assertTrue(value.startsWith("worker1 executed at ")));
  }
}
