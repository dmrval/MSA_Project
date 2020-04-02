package ru.dmrval.rsocketserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.dmrval.rsocketserver.model.BankAccountInfo;
import ru.dmrval.rsocketserver.model.RequestBankAccountInfo;
import ru.dmrval.rsocketserver.repository.BankAccountInfoRepository;

@RestController
@RequestMapping("/")
public class BankAccountInfoController {

  @Autowired private BankAccountInfoRepository bankAccountInfoRepository;

  public BankAccountInfoController(BankAccountInfoRepository bankAccountInfoRepository) {
    this.bankAccountInfoRepository = bankAccountInfoRepository;
  }

  @MessageMapping("request-response")
  Mono<BankAccountInfo> getBankAccountInfoByName(RequestBankAccountInfo requestBankAccountInfo) {
    return bankAccountInfoRepository.findById(requestBankAccountInfo.getId());
  }

  @MessageMapping("request-stream")
  Flux<BankAccountInfo> getAllBankAccountInfos() {
    return bankAccountInfoRepository.findAll();
  }

  @MessageMapping("fire-forget")
  Mono<Void> addBankAccountInfo(RequestBankAccountInfo requestBankAccountInfo) {
    bankAccountInfoRepository.deleteById(Mono.just(requestBankAccountInfo.getId())).subscribe();
    return Mono.empty();
  }
}
