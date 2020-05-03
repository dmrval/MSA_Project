package ru.dmrval.goldstatusproducer.repository;

import reactor.core.publisher.Flux;
import ru.dmrval.goldstatusproducer.model.BankAccountInfo;

public interface BankAccountInfoRepository {
  Flux<BankAccountInfo> saveAll();

  default void test(String s) {
    System.out.println();
  }
}
