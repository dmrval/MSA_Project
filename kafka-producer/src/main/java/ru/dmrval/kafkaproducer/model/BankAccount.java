package ru.dmrval.kafkaproducer.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@RedisHash
public class BankAccount implements Serializer<BankAccount> {
  @Id
  private UUID uuid;
  private String firstName;
  private String lastName;
  private String patronymic;
  private long accountNumber;
  private AccountType accountType;

  @Override
  public byte[] serialize(String s, BankAccount bankAccount) {
    byte[] retVal = null;
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      retVal = objectMapper.writeValueAsString(bankAccount).getBytes();
    } catch (Exception exception) {
      System.out.println("Error in serializing object" + bankAccount);
    }
    return retVal;
  }
}
