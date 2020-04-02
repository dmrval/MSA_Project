package ru.dmrval.kafkaconsumer.topologyConfig;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Printed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.kafka.support.serializer.JsonSerializer;
import ru.dmrval.kafkaconsumer.dao.BankAccoutInfoDao;
import ru.dmrval.kafkaconsumer.model.Address;
import ru.dmrval.kafkaconsumer.model.BankAccount;
import ru.dmrval.kafkaconsumer.model.BankAccountInfo;

@Configuration
public class TopologyConfiguration {

  @Autowired BankAccoutInfoDao bankAccoutInfoDao;

  @Autowired KafkaStreamsConfiguration defaultKafkaStreamsConfig;

  @Bean
  public Topology createTopology(StreamsBuilder streamsBuilder) {

    KTable<String, BankAccount> bankAccountKTable =
        streamsBuilder.table(
            "bankAccountTopic", Consumed.with(Serdes.String(), new JsonSerde<>(BankAccount.class)));

    JsonDeserializer<Address> jsonDeserializer = new JsonDeserializer<>(Address.class);
    JsonDeserializer<Address> addressJsonDeserializer = jsonDeserializer.ignoreTypeHeaders();
    JsonSerializer<Address> jsonSerializer = new JsonSerializer<>();

    JsonSerde<Address> addressJsonSerde = new JsonSerde<>(jsonSerializer, addressJsonDeserializer);

    KTable<String, Address> addressKTable =
        streamsBuilder.table("accountAddress", Consumed.with(Serdes.String(), addressJsonSerde));

    KTable<String, BankAccountInfo> bankAccoultInfoKTable =
        bankAccountKTable.join(
            addressKTable,
            BankAccountInfo::new,
            Materialized.with(Serdes.String(), new JsonSerde<>(BankAccountInfo.class)));

    bankAccoultInfoKTable.toStream().print(Printed.toSysOut());

    bankAccoultInfoKTable.toStream().to("newBankAccountInfoTopic");

    bankAccoultInfoKTable
        .toStream()
        .foreach((s, bankAccountInfo) -> bankAccoutInfoDao.addBankAccountInfo(s, bankAccountInfo));

    Topology topology = streamsBuilder.build();
    KafkaStreams kafkaStreams =
        new KafkaStreams(topology, defaultKafkaStreamsConfig.asProperties());
    kafkaStreams.start();
    return topology;
  }
}