package ru.dmrval.redisreactivemsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.dmrval.redisreactivemsa.config.RequestWebClientConfigImpl;
import ru.dmrval.redisreactivemsa.model.BankAccountInfo;

@RestController
public class BankAccountController {

  @Autowired private ReactiveRedisTemplate<String, BankAccountInfo> reactiveRedisTemplate;
  @Autowired private ReactiveRedisOperations<String, BankAccountInfo> reactiveRedisOperations;
  @Autowired private RequestWebClientConfigImpl requestWebClientConfig;

  @GetMapping(value = "/getGoldByRedisDB", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
  public Flux<BankAccountInfo> all() {
    requestWebClientConfig.getUpdateData();
    return reactiveRedisTemplate.keys("*").flatMap(s -> reactiveRedisTemplate.opsForValue().get(s));
  }
}
