package ru.dmrval.kafkaconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountInfo {
  private BankAccount bankAccount;
  private Address address;
}
