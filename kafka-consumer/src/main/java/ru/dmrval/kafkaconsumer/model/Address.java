package ru.dmrval.kafkaconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
  String street;
  String city;
  String state;

  public Address(Address address) {
    state = address.getState();
    city = address.getCity();
    street = address.getStreet();
  }

}
