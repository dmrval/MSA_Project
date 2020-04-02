package ru.dmrval.kafkaproducer.config;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.reactive.function.client.WebClient;
import ru.dmrval.kafkaproducer.model.AccountType;
import ru.dmrval.kafkaproducer.model.BankAccountResponse;

import java.util.Random;

@Configuration
@EnableScheduling
public class MyProducer {

  @Autowired private KafkaTemplate kafkaTemplate;
  @Autowired private WebClient.Builder webClientBuilder;
  @Autowired private Random random;

  @Scheduled(fixedDelay = 5000)
  public void pushInKafka() {
    BankAccountResponse bankAccountResponse =
        webClientBuilder
            .build()
            .get()
            .uri("http://localhost:8085/generate/" + 10)
            .retrieve()
            .bodyToMono(BankAccountResponse.class)
            .block();
    bankAccountResponse
        .getBankAccounts()
        .forEach(
            bankAccount -> {
              bankAccount.setAccountType(getRandomAccountType());
              // фильтрует Uuid который начинается на цифру 5
              if (bankAccount.getUuid().toString().charAt(0) == '5') {
                return;
              }
              kafkaTemplate.send(
                  new ProducerRecord<>(
                      IKafkaConstants.TOPIC_NAME, bankAccount.getUuid().toString(), bankAccount));
            });
    //  Не закрывать если рабоатет Sheduler
    //    producer.close();
  }

  private AccountType getRandomAccountType() {
    AccountType[] typeList = AccountType.values();
    return typeList[random.nextInt(typeList.length)];
  }
}
