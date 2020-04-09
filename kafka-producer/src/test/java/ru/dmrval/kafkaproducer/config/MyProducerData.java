package ru.dmrval.kafkaproducer.config;

import ru.dmrval.kafkaproducer.model.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class MyProducerData {

  List<BankAccount> getBankAccounts(int count) {
    List<BankAccount> bankAccountList = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      bankAccountList.add(new BankAccount());
    }
    return bankAccountList;
  }
}
