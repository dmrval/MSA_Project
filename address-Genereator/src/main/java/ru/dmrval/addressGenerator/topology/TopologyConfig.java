package ru.dmrval.addressGenerator.topology;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonSerde;
import ru.dmrval.addressGenerator.model.Address;
import ru.dmrval.addressGenerator.model.BankAccount;
import ru.dmrval.addressGenerator.resource.AddressGenerator;

@Configuration
public class TopologyConfig {

  @Autowired AddressGenerator addressGenerator;

  @Autowired KafkaTemplate<String, Address> kafkaTemplate;

  @Bean
  public Topology createTopology(StreamsBuilder streamsBuilder) {
    KStream<String, BankAccount> bankAccountKStream =
        streamsBuilder.stream(
            "bankAccountTopic", Consumed.with(Serdes.String(), new JsonSerde<>(BankAccount.class)));

    bankAccountKStream
        .filter((s, bankAccount) -> bankAccount.getFirstName().charAt(0) == 'А')
        .mapValues((s, bankAccount) -> addressGenerator.getAddressRandomApi())
        .to("accountAddress", Produced.with(Serdes.String(), new JsonSerde<>(Address.class)));

    Topology topology = streamsBuilder.build();
    return topology;
  }
}
