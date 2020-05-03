package ru.dmrval.gRpcclientservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

/** Author - Damir_Valeev */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BankAccount {
  private UUID uuid;
  private String firstName;
  private String lastName;
  private String patronymic;
  private long accountNumber;
  private AccountType accountType;

  public BankAccount(ru.dmrval.entity.BankAccount bankAccount) {
    this.uuid = UUID.fromString(bankAccount.getUuid());
    this.firstName = bankAccount.getFirstName();
    this.lastName = bankAccount.getLastName();
    this.patronymic = bankAccount.getPatronymic();
    this.accountNumber = bankAccount.getAccountNumber();
    this.accountType = AccountType.valueOf(bankAccount.getType().name());
  }
}
