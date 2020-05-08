package ru.dmrval.goldstatusproducer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.dmrval.goldstatusproducer.model.Address;
import ru.dmrval.goldstatusproducer.model.BankAccountInfo;
import ru.dmrval.goldstatusproducer.requestbankaccountinfos.BankAccountInfoRequest;

@RestController
@RequestMapping(value = "/")
public class RedisBankAccountInfoRepository {

  @Autowired BankAccountInfoRequest request;

  @Autowired ReactiveRedisConnectionFactory factory;

  @Autowired ReactiveRedisOperations<String, BankAccountInfo> reactiveRedisTemplate;

  @RequestMapping(value = "/setRedis", method = RequestMethod.GET)
  public Flux<BankAccountInfo> saveAll() {
    Flux<BankAccountInfo> allByGrpcService = request.getAllByGrpcService();
    BankAccountInfo hv = new BankAccountInfo();
    hv.setAddress(new Address("dsds", "dsds", "dsds"));
    reactiveRedisTemplate.opsForHash().put("BA", "sdaafsd", hv);
    reactiveRedisTemplate.opsForValue().set("dsdsds", hv);
    reactiveRedisTemplate.opsForGeo().hash("dsds", hv);
    return null;
  }
}
