package ru.dmrval.addressGenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountInfo {
  private BankAccount bankAccount;
  private Address address;
}
