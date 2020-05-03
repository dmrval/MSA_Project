package ru.dmrval.goldstatusproducer.requestbankaccountinfos;

import reactor.core.publisher.Flux;
import ru.dmrval.goldstatusproducer.model.BankAccountInfo;

public interface BankAccountInfoRequest {
  Flux<BankAccountInfo> getAllByGrpcService();
}
