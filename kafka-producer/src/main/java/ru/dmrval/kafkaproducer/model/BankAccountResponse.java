package ru.dmrval.kafkaproducer.model;

import lombok.Data;

import java.util.List;

@Data
public class BankAccountResponse {
  private List<BankAccount> bankAccounts;
}
