package ru.dmrval.goldstatusproducer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.dmrval.goldstatusproducer.model.BankAccountInfo;
import ru.dmrval.goldstatusproducer.requestbankaccountinfos.BankAccountInfoRequest;

@RestController
@RequestMapping(value = "/")
public class RedisBankAccountInfoRepository {

  @Autowired BankAccountInfoRequest request;
  @Autowired ReactiveRedisTemplate<String, BankAccountInfo> reactiveRedisTemplate;

  @RequestMapping(value = "/setRedis", method = RequestMethod.GET)
  public void saveAll() {
    Flux<BankAccountInfo> allByGrpcService = request.getAllByGrpcService();
    allByGrpcService.subscribe(
        bankAccountInfo ->
            reactiveRedisTemplate
                .opsForValue()
                .set(bankAccountInfo.getBankAccount().getUuid().toString(), bankAccountInfo)
                .map(String::valueOf)
                .subscribe());
  }
}
