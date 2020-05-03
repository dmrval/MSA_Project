package ru.dmrval.kafkaconsumer;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.test.TestRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.support.serializer.JsonSerde;
import ru.dmrval.kafkaconsumer.model.AccountType;
import ru.dmrval.kafkaconsumer.model.Address;
import ru.dmrval.kafkaconsumer.model.BankAccount;
import ru.dmrval.kafkaconsumer.model.BankAccountInfo;
import ru.dmrval.kafkaconsumer.topologyConfig.KafkaConfiguration;
import ru.dmrval.kafkaconsumer.topologyConfig.TopologyConfiguration;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

class KafkaConsumerApplicationTests {

  private TopologyTestDriver topologyTestDriver;
  private TestInputTopic<String, BankAccount> inputTopicBankAccount;
  private TestInputTopic<String, Address> inputTopicAddress;
  private TestOutputTopic<String, BankAccountInfo> outputTopic;

  private UUID uuidForTest;

  @BeforeEach
  public void setup() {
    KafkaStreamsConfiguration config = new KafkaConfiguration().getStreamsConfig();
    Topology topology = new TopologyConfiguration().createTopology(new StreamsBuilder());
    topologyTestDriver = new TopologyTestDriver(topology, config.asProperties());

    inputTopicBankAccount =
        topologyTestDriver.createInputTopic(
            "bankAccountTopic",
            Serdes.String().serializer(),
            new JsonSerde<>(BankAccount.class).serializer());

    inputTopicAddress =
        topologyTestDriver.createInputTopic(
            "accountAddress",
            Serdes.String().serializer(),
            new JsonSerde<>(Address.class).serializer());

    outputTopic =
        topologyTestDriver.createOutputTopic(
            "newBankAccountInfoTopic",
            Serdes.String().deserializer(),
            new JsonSerde<>(BankAccountInfo.class).deserializer());
  }

  void putBankAccount(BankAccount bankAccount) {
    inputTopicBankAccount.pipeInput(bankAccount.getUuid().toString(), bankAccount);
    uuidForTest = bankAccount.getUuid();
  }

  void putAddress(Address address) {
    inputTopicAddress.pipeInput(uuidForTest.toString(), address);
  }

  @Test
  public void first() {
    BankAccount bankAccount =
        new BankAccount(UUID.randomUUID(), "Ivanov", "Ivan", "Ivanovich", 432423, AccountType.GOLD);
    putBankAccount(bankAccount);
    Address address = new Address("TestStreet", "TestCity", "TestState");
    putAddress(address);
    BankAccountInfo expectedBankAccountInfo = new BankAccountInfo(bankAccount, address);
    TestRecord<String, BankAccountInfo> stringBankAccountInfoTestRecord = outputTopic.readRecord();
    assertEquals(
        expectedBankAccountInfo.getBankAccount(),
        stringBankAccountInfoTestRecord.getValue().getBankAccount());
    assertEquals(
        expectedBankAccountInfo.getAddress(),
        stringBankAccountInfoTestRecord.getValue().getAddress());
    assertEquals(
        expectedBankAccountInfo.getBankAccount().getUuid().toString(),
        stringBankAccountInfoTestRecord.getValue().getBankAccount().getUuid().toString());
    assertEquals(
        stringBankAccountInfoTestRecord.getValue().getBankAccount().getUuid(),
        bankAccount.getUuid());
    assertEquals(stringBankAccountInfoTestRecord.getKey(), bankAccount.getUuid().toString());
  }
}
