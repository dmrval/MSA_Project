package ru.dmrval.kafkaproducer.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Random;

@SpringBootTest
class MyProducerTest {
  private MyProducerData myProducerData;

  @InjectMocks MyProducer myProducer;
  @InjectMocks Random random;
  @Autowired private WebClient.Builder webClientBuilder;
  @Mock KafkaTemplate kafkaTemplate;

  @BeforeEach
  void init() {
    MockitoAnnotations.initMocks(this);
    myProducerData = new MyProducerData();
    ReflectionTestUtils.setField(myProducer, "random", random);
    ReflectionTestUtils.setField(myProducer, "webClientBuilder", webClientBuilder);
    ReflectionTestUtils.setField(myProducer, "kafkaTemplate", kafkaTemplate);
  }

  @Test
  void pushInKafka() {
    myProducer.pushInKafka();
  }
}
