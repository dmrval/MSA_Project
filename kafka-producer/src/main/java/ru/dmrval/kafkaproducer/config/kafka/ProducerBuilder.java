package ru.dmrval.kafkaproducer.config.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import ru.dmrval.kafkaproducer.model.BankAccount;

import java.util.HashMap;
import java.util.Map;

import static ru.dmrval.kafkaproducer.config.kafka.IKafkaConstants.*;


@Configuration
public class ProducerBuilder {

  @Bean
  public static ProducerFactory<String, BankAccount> createProducer() {
    Map<String, Object> properties = new HashMap<>();
    properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_BROKERS);
    properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KEY_SERIALIZER);
    properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, VALUE_SERIALIZER);
    properties.put(ProducerConfig.CLIENT_ID_CONFIG, PRODUCER_ID);
    properties.put(ProducerConfig.RETRIES_CONFIG, RETRIES);
    return new DefaultKafkaProducerFactory<>(properties);
  }

  @Bean
  public KafkaTemplate<String, BankAccount> kafkaTemplate() {
    return new KafkaTemplate<>(createProducer());
  }
}
