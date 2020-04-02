package ru.dmrval.kafkaproducer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
