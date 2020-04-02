package ru.dmrval.rsocketclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountInfo {
  private UUID uuid;
  private Address addressValue;
  private BankAccount bankAccountValue;
}
