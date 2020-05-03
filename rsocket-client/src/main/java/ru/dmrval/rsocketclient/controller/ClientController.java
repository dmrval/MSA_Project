package ru.dmrval.rsocketclient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.dmrval.rsocketclient.model.BankAccountInfo;
import ru.dmrval.rsocketclient.model.RequestBankAccountInfo;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ClientController {

  @Autowired private final RSocketRequester requester;

  @GetMapping("/{id}")
  Mono<BankAccountInfo> findBankAccountInfoById(@PathVariable String id) {
    return this.requester
        .route("request-response")
        .data(new RequestBankAccountInfo(UUID.fromString(id)))
        .retrieveMono(BankAccountInfo.class);
  }

  @GetMapping("/showAllBankAccountInfos")
  Flux<BankAccountInfo> findAllBankAccountInfos() {
    Flux<BankAccountInfo> bankAccountInfoFlux =
        this.requester.route("request-stream").retrieveFlux(BankAccountInfo.class);
    bankAccountInfoFlux.subscribe(System.err::println);
    return bankAccountInfoFlux;
  }

  @PostMapping("/deleteBankAccountInfo/{id}")
  Mono<Void> addBankAccountInfo(@PathVariable String id) {
    return this.requester
        .route("fire-forget")
        .data(new RequestBankAccountInfo(UUID.fromString(id)))
        .send();
  }
}
