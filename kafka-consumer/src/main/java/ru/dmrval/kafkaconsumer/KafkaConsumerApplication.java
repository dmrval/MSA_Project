package ru.dmrval.kafkaconsumer;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.errors.LogAndContinueExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableKafkaStreams
public class KafkaConsumerApplication {

  @Value("${cassandra.point}")
  String point;
  @Value("${cassandra.userAndPass}")
  String userPass;

  @Bean
  public Session session() {
    Cluster cluster =
        Cluster.builder()
            .withoutMetrics()
            .addContactPoint(point)
            .withCredentials(userPass, userPass)
            .build();
    Session session = cluster.connect("bankaccountdb");
    return session;
  }



  public static void main(String[] args) {
    SpringApplication.run(KafkaConsumerApplication.class, args);
  }
}
