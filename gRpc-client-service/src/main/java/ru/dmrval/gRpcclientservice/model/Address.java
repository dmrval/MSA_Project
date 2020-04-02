package ru.dmrval.gRpcclientservice.model;

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

  public Address(ru.dmrval.entity.Address address) {
    this.street = address.getStreet();
    this.city = address.getCity();
    this.state = address.getState();
  }
}
