package ru.dmrval.rsocketserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

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

  public BankAccount(UUID randomUUID, String s, String s1, String s2, int random_number1) {
    uuid = randomUUID;
    firstName = s;
    lastName = s1;
    patronymic = s2;
    accountNumber = random_number1;
  }

  public BankAccount(BankAccount bankAccount) {
    uuid = UUID.fromString(bankAccount.getUuid().toString());
    firstName = bankAccount.getFirstName();
    lastName = bankAccount.getLastName();
    patronymic = bankAccount.getPatronymic();
    accountNumber = bankAccount.getAccountNumber();
    accountType = bankAccount.getAccountType();
  }


}
