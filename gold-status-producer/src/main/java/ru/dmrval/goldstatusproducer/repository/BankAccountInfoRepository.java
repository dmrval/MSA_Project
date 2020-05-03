package ru.dmrval.goldstatusproducer.repository;

import reactor.core.publisher.Flux;
import ru.dmrval.goldstatusproducer.model.BankAccountInfo;
import ru.dmrval.goldstatusproducer.requestbankaccountinfos.BankAccountInfoRequest;

public interface BankAccountInfoRepository {

  Flux<BankAccountInfo> saveAll();

  default void test() {
    System.out.println();
  }
}
