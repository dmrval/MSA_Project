package ru.dmrval.kafkaproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Random;

@SpringBootApplication
public class KafkaProducerApplication {

  @Bean
  public WebClient.Builder webClientBuilder() {
    return WebClient.builder();
  }

  @Bean
  public Random random() {
    return new Random();
  }

  public static void main(String[] args) {
    SpringApplication.run(KafkaProducerApplication.class, args);
  }
}
