package ru.dmrval.kafkaproducer.config.kafka;

import org.apache.kafka.common.serialization.StringSerializer;
import ru.dmrval.kafkaproducer.model.BankAccount;

public interface IKafkaConstants {
  String KAFKA_BROKERS = "localhost:9092";
  String TOPIC_NAME = "bankAccountTopic";
  String PRODUCER_ID = "BkProducer";
  String KEY_SERIALIZER = StringSerializer.class.getName();
  String VALUE_SERIALIZER = BankAccount.class.getName();
  int RETRIES = 2;
}
