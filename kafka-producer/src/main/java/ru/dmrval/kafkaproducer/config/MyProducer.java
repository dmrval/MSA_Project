package ru.dmrval.kafkaproducer.config;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.reactive.function.client.WebClient;
import ru.dmrval.kafkaproducer.config.kafka.IKafkaConstants;
import ru.dmrval.kafkaproducer.config.redis.repository.BankAccountRepository;
import ru.dmrval.kafkaproducer.model.AccountType;
import ru.dmrval.kafkaproducer.model.BankAccountResponse;

import java.util.Random;

@Configuration
@EnableScheduling
public class MyProducer {

  @Autowired private KafkaTemplate kafkaTemplate;
  @Autowired private WebClient.Builder webClientBuilder;
  @Autowired private Random random;
  @Autowired private BankAccountRepository bankAccountRepository;

  @Scheduled(fixedDelay = 5000)
  public void pushInKafka() {
    BankAccountResponse bankAccountResponse = getRandomBankAccounts(10);
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

                bankAccountRepository.save(bankAccount);
            });
    //  Не закрывать если рабоатет Sheduler
    //    producer.close();
  }

  private BankAccountResponse getRandomBankAccounts(int count) {
    return webClientBuilder
        .build()
        .get()
        .uri("http://localhost:8085/generate/" + count)
        .retrieve()
        .bodyToMono(BankAccountResponse.class)
        .block();
  }

  private AccountType getRandomAccountType() {
    AccountType[] typeList = AccountType.values();
    return typeList[random.nextInt(typeList.length)];
  }
}
