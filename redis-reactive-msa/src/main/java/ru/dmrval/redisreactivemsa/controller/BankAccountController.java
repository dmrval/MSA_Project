package ru.dmrval.redisreactivemsa.controller;

import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dmrval.redisreactivemsa.model.BankAccount;

@RestController
public class BankAccountController {
  private final ReactiveRedisOperations<String, BankAccount> redisOperations;

  BankAccountController(ReactiveRedisOperations<String, BankAccount> redisOperations) {
    this.redisOperations = redisOperations;
  }

  @GetMapping(value = "/ba", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
  public void all() {
    redisOperations.keys("*").subscribe(System.out::println);
  }
}
