package ru.dmrval.goldstatusproducer.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash
@ToString
@Builder
public class BankAccountInfo {
  @Id
  private BankAccount bankAccount;
  private Address address;
}
