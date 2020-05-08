package ru.dmrval.goldstatusproducer.repository;

import reactor.core.publisher.Mono;
import ru.dmrval.goldstatusproducer.model.BankAccountInfo;

public interface BankAccountInfoRepository {
    Mono<BankAccountInfo> save(BankAccountInfo bankAccountInfo);
}
