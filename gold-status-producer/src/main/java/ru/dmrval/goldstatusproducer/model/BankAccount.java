package ru.dmrval.goldstatusproducer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BankAccount  {
  private UUID uuid;
  private String firstName;
  private String lastName;
  private String patronymic;
  private long accountNumber;
  private AccountType accountType;
}
