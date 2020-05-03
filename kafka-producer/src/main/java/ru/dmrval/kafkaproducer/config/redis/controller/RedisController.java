package ru.dmrval.kafkaproducer.config.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dmrval.kafkaproducer.config.redis.repository.BankAccountRepository;
import ru.dmrval.kafkaproducer.model.AccountType;
import ru.dmrval.kafkaproducer.model.BankAccount;

import java.util.UUID;

@RestController
@RequestMapping(value = "/redis")
public class RedisController {

  @Autowired private BankAccountRepository bankAccountRepository;

  @GetMapping("/save")
  public void save() {
    BankAccount bankAccount =
        new BankAccount(UUID.randomUUID(), "A", "A", "A", 34232, AccountType.GOLD);
    bankAccountRepository.save(bankAccount);
  }
}
