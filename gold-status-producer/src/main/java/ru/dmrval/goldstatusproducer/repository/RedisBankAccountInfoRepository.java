package ru.dmrval.goldstatusproducer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import ru.dmrval.goldstatusproducer.model.BankAccountInfo;
import ru.dmrval.goldstatusproducer.requestbankaccountinfos.BankAccountInfoRequest;

@Repository
@EnableScheduling
public class RedisBankAccountInfoRepository implements BankAccountInfoRepository {

  //  @Autowired ReactiveRedisOperations redisOperations;
  @Autowired BankAccountInfoRequest request;

  @Override
  @Scheduled(fixedDelay = 5000)
  public Flux<BankAccountInfo> saveAll() {
    Flux<BankAccountInfo> allByGrpcService = request.getAllByGrpcService();
    allByGrpcService.subscribe(System.out::println);
    return null;
  }
}
