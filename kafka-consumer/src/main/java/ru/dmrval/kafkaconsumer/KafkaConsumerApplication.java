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

  @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
  public KafkaStreamsConfiguration getStreamsConfig() {
    Map<String, Object> props = new HashMap<>();
    props.put(StreamsConfig.APPLICATION_ID_CONFIG, "bankAccountWithAddress");
    props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(StreamsConfig.NUM_STREAM_THREADS_CONFIG, "4");
    props.put(
        StreamsConfig.DEFAULT_DESERIALIZATION_EXCEPTION_HANDLER_CLASS_CONFIG,
        LogAndContinueExceptionHandler.class);
    return new KafkaStreamsConfiguration(props);
  }

  public static void main(String[] args) {
    SpringApplication.run(KafkaConsumerApplication.class, args);
  }
}
